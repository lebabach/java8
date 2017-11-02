package XmediaOne;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang.StringUtils;

public class ServiceSelect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Stream<String> stream = Files.lines(Paths.get("F:\\table.txt"), StandardCharsets.ISO_8859_1)) {
			// select clause

			Supplier<List<String>> supplier = () -> stream.collect(Collectors.toList());
			Function<List<String>, List<String>> process1 = SelectServices::selectClause;
			Function<List<String>, List<String>> process2 = SelectServices::instanceSelect;

			CompletableFuture<List<String>> cfSupply = CompletableFuture.supplyAsync(supplier);
			CompletableFuture<List<String>> cfApply1 = cfSupply.thenApplyAsync(process1);
			CompletableFuture<List<String>> cfApply2 = cfSupply.thenApplyAsync(process2);
			List<String> output = cfApply1.thenCombineAsync(cfApply2, (x, y) -> new ArrayList<String>() {
				{
					addAll(x);
					addAll(y);
				}
			}).get();
			Files.write(Paths.get("F:\\selectServices.txt"), output);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

class SelectServices {
	public static List<String> selectClause(List<String> process) {
		List<String> result = process.parallelStream().map(line -> {
			String partterField = StringUtils.EMPTY;
			if (line.contains("--")) {
				line = line.substring(0, line.indexOf("--"));
			}
			line = line.trim();
			String[] slitLine = line.split(" ");
			String column = slitLine[0];

			String conditionFormat = String.format("\"%s\",", column);
			return conditionFormat;
		}).collect(Collectors.toList());
		result.set(result.size()-1, result.get(result.size()-1).replace(",","\n"));
		return result;
	}

	public static List<String> instanceSelect(List<String> process) {
		List<String> result = process.parallelStream().map(line -> {
			String sql = StringUtils.EMPTY;

			if (line.contains("timestamp") && (!line.contains("delete_date") && !line.contains("insert_date")
					&& !line.contains("update_date"))) {
				sql += "TableUtils.convDateOnlyStr(pr.<<[Timestamp], \"yyyy-MM-dd\"),";
			} else if (line.contains("timestamp")
					&& (line.contains("delete_date") || line.contains("insert_date") || line.contains("update_date"))) {
				sql += "TableUtils.convDateToStr(pr.<<[Timestamp]),";
			} else {
				sql += "pr.<<,";
			}

			return sql;
		}).collect(Collectors.toList());
		result.set(result.size()-1, result.get(result.size()-1).replace(",",""));
		return result;
	}
}
