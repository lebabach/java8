package XmediaOne;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang.StringUtils;

import asyn.Mail;

public class ServicesInsertUpdate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//for services: MMaterialService
		try (Stream<String> stream = Files.lines(Paths.get("F:\\table.txt"), StandardCharsets.ISO_8859_1)) {
			// insert

			Supplier<DataTable> supplier = () -> new DataTable(stream.collect(Collectors.toList()), false) ;
			Function<DataTable, DataTable> process1 = Services::insertNameColumn;
			Function<DataTable, DataTable> process2 = Services::insertValues;

			CompletableFuture<DataTable> cfSupply = CompletableFuture.supplyAsync(supplier);
			CompletableFuture<DataTable> cfApply1 = cfSupply.thenApplyAsync(process1);
			CompletableFuture<DataTable> cfApply2 = cfSupply.thenApplyAsync(process2);
			List<String> output = cfApply1.thenCombineAsync(cfApply2, (x, y) -> new ArrayList<String>() {
				{
					addAll(x.items);
					addAll(y.items);
				}
			}).get();
			Files.write(Paths.get("F:\\insertServices.txt"), output);

		} catch (Exception e) {
			e.printStackTrace();
		}
		//for tableText: MMaterialTextService
		try (Stream<String> stream = Files.lines(Paths.get("F:\\table.txt"), StandardCharsets.ISO_8859_1)) {
			// insert
			Supplier<DataTable> supplier = () -> new DataTable(stream.collect(Collectors.toList()), true) ;
			Function<DataTable, DataTable> process1 = Services::insertNameColumn;
			Function<DataTable, DataTable> process2 = Services::insertValues;

			CompletableFuture<DataTable> cfSupply = CompletableFuture.supplyAsync(supplier);
			CompletableFuture<DataTable> cfApply1 = cfSupply.thenApplyAsync(process1);
			CompletableFuture<DataTable> cfApply2 = cfSupply.thenApplyAsync(process2);
			List<String> output = cfApply1.thenCombineAsync(cfApply2, (x, y) -> new ArrayList<String>() {
				{
					addAll(x.items);
					addAll(y.items);
				}
			}).get();
			Files.write(Paths.get("F:\\insertServiceTEXT.txt"), output);

		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Stream<String> stream = Files.lines(Paths.get("F:\\table.txt"), StandardCharsets.ISO_8859_1)) {
			// update
			List<String> output2 = Services.updateFuntion(stream.collect(Collectors.toList()),false);
			Files.write(Paths.get("F:\\updateServices.txt"), output2);

		} catch (Exception e) {
			e.printStackTrace();
		}
		try (Stream<String> stream = Files.lines(Paths.get("F:\\table.txt"), StandardCharsets.ISO_8859_1)) {
			// update
			List<String> output2 = Services.updateFuntion(stream.collect(Collectors.toList()),true);
			Files.write(Paths.get("F:\\updateServiceText.txt"), output2);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

class Services {
	public static DataTable insertNameColumn(DataTable table) {
		Stream<String> filter = table.items.parallelStream()
				.filter(line -> !line.contains("owner_company_id") && !line.contains("valid_flag")
						&& !line.contains("insert_date") && !line.contains("insert_operator_id")
						&& !line.contains("update_date") && !line.contains("update_operator_id")
						&& !line.contains("delete_date") && !line.contains("delete_operator_id")
						&& !line.contains("locale"));
		if (!table.isTableText) {
			filter = filter.skip(1);
		}
		List<String> result = filter.map(line -> {
			String partterField = StringUtils.EMPTY;
			if (line.contains("--")) {
				line = line.substring(0, line.indexOf("--"));
			}
			line = line.trim();
			String[] slitLine = line.split(" ");
			String column = slitLine[0];
			String columnFormat = StringUtils.uncapitalize(Arrays.asList(column.split("_")).stream()
					.map(x -> StringUtils.capitalise(x)).collect(Collectors.joining("")));
			String conditionFormat = String.format("if (tableModel.%s != null){ \n\tsqlIns += \"%s,\"\n}", columnFormat,
					column);
			return conditionFormat;
		}).collect(Collectors.toList());
		String addInsCommonField = "sqlIns = addInsCommonField(sqlIns)\n";
		result.add(addInsCommonField);
		return new DataTable(result, false);
	}

	public static DataTable insertValues(DataTable table) {
		Stream<String> filter = table.items.parallelStream()
				.filter(line -> !line.contains("owner_company_id") && !line.contains("valid_flag")
						&& !line.contains("insert_date") && !line.contains("insert_operator_id")
						&& !line.contains("update_date") && !line.contains("update_operator_id")
						&& !line.contains("delete_date") && !line.contains("delete_operator_id")
						&& !line.contains("locale"));
		if (!table.isTableText) {
			filter = filter.skip(1);
		}

		List<String> result = filter.map(line -> {
					String sqlValue = StringUtils.EMPTY;
					if (line.contains("--")) {
						line = line.substring(0, line.indexOf("--"));
					}
					line = line.trim();
					String[] slitLine = line.split(" ");
					String column = slitLine[0];
					String columnFormat = StringUtils.uncapitalize(Arrays.asList(column.split("_")).stream()
							.map(x -> StringUtils.capitalise(x)).collect(Collectors.joining("")));

					if (line.contains("bigint")) {
						sqlValue = "sqlIns = sqlIns +? tableModel." + columnFormat + ".toLong + \",\"";
					} else if (line.contains("smallint")) {
						sqlValue = "sqlIns = sqlIns +? tableModel." + columnFormat + ".toShort + \",\"";
					} else if (line.contains("numeric")) {
						sqlValue = "sqlIns = sqlIns +? tableModel." + columnFormat + ".toDouble + \",\"";
					} else if (line.contains("timestamp")) {
						sqlValue = "sqlIns = sqlIns + \"to_timestamp(\" +? tableModel." + columnFormat
								+ " + \",\'YYYY-MM-DD HH24:MI:SS.MS\'),\"";
					} else {
						sqlValue = "sqlIns = sqlIns +? tableModel." + columnFormat + " + \",\"";
					}

					String conditionFormat = String.format("if (tableModel.%s != null){ \n\t%s\n}", columnFormat,
							sqlValue);
					return conditionFormat;
				}).collect(Collectors.toList());
		String addInsCommonVal = "if (tableModel.validFlag != null && tableModel.validFlag.equals(\"0\")){\n\tcommonFields.validFlag = 0\n}\n";
		addInsCommonVal += "sqlIns = addInsCommonVal(sqlIns, commonFields, \""
				+ table.items.get(0).toString().trim().split(" ")[0].toString() + "\")";
		addInsCommonVal += "\nsqlIns.first.longValue()";
		result.add(addInsCommonVal);
		return new DataTable(result, true);
	}

	public static List<String> updateFuntion(List<String> process,boolean isTableText) {
		
		List<String> result = process.parallelStream()
				.filter(line -> !line.contains("owner_company_id") && !line.contains("insert_date")
						&& !line.contains("insert_operator_id") && !line.contains("update_date")
						&& !line.contains("update_operator_id") && !line.contains("delete_date")
						&& !line.contains("delete_operator_id") && !line.contains("locale"))
				.skip(1).map(line -> {
					String sql = StringUtils.EMPTY;
					if (line.contains("--")) {
						line = line.substring(0, line.indexOf("--"));
					}
					line = line.trim();
					String[] slitLine = line.split(" ");
					String column = slitLine[0];
					String columnFormat = StringUtils.uncapitalize(Arrays.asList(column.split("_")).stream()
							.map(x -> StringUtils.capitalise(x)).collect(Collectors.joining("")));
					if (!line.contains("lang_code")) {
						sql = "if (tableModel." + columnFormat + " != null) {\n\t";

						if (line.contains("bigint")) {
							sql += "sqlUp = sqlUp + \"" + column + " = \" +? tableModel." + columnFormat
									+ ".toLong + \",\"";
						} else if (line.contains("smallint")) {
							sql += "sqlUp = sqlUp + \"" + column + " = \" +? tableModel." + columnFormat
									+ ".toShort + \",\"";
						} else if (line.contains("numeric")) {
							sql += "sqlUp = sqlUp + \"" + column + " = \" +? tableModel." + columnFormat
									+ ".toDouble + \",\"";
						} else if (line.contains("timestamp")) {
							sql += "sqlUp = sqlUp + \"" + column + " = to_timestamp(\" +? tableModel." + columnFormat
									+ " + \",\'YYYY-MM-DD HH24:MI:SS.MS\'),\"";
						} else {
							sql += "sqlUp = sqlUp + \"" + column + " = \" +? tableModel." + columnFormat + " + \",\"";
						}
						sql += "\n} else {";
						sql += "\n\tif (!individualFlag) sqlUp = sqlUp + \"" + column + " = null,\"";
						sql += "\n}";
					}
					
					return sql;
				}).collect(Collectors.toList());
		String column = process.get(0).toString().trim().split(" ")[0].toString();
		String columnFormat = StringUtils.uncapitalize(Arrays.asList(column.split("_")).stream()
				.map(x -> StringUtils.capitalise(x)).collect(Collectors.joining("")));
		String sql = "sqlUp = addUpdCommonField(sqlUp, commonFields)\n";
		sql += "sqlUp = sqlUp + \" where " + column + " = \" +? tableModel." + columnFormat + ".toLong\n";
		if(isTableText){
			sql += "sqlUp = sqlUp + \" and lang_code = \" +? tableModel.langCode\n";	
		}
		sql += "updateExecute(sqlUp, tableModel.updateDate)";
		result.add(sql);
		return result;
	}
}
