package XmediaOne;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang.StringUtils;

public class PostJson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Stream<String> stream = Files.lines(Paths.get("F:\\table.txt"), StandardCharsets.ISO_8859_1)) {
			List<String> output = stream.parallel()
					.filter(line -> !line.contains("owner_company_id") && !line.contains("valid_flag")
							&& !line.contains("insert_date") && !line.contains("insert_operator_id")
							&& !line.contains("update_date") && !line.contains("update_operator_id")
							&& !line.contains("delete_date") && !line.contains("delete_operator_id")
							&& !line.contains("locale"))
					.map(line -> {
						String formatField = StringUtils.EMPTY;
						if (line.contains("--")) {
							line = line.substring(0, line.indexOf("--"));
						}
						line = line.trim();
						String[] slitLine = line.split(" ");
						String column = slitLine[0];
						if (line.contains("bigint") || line.contains("numeric")) {
							formatField = "\"" + column + "\": \""
									+ ThreadLocalRandom.current().nextInt(0, 100 + 1) + "\",";
						} else if (line.contains("smallint")) {
							formatField = "\"" + column + "\": \"" + ThreadLocalRandom.current().nextInt(0, 1 + 1)
									+ "\",";
						} else if (line.contains("timestamp")) {
							formatField = "\"" + column + "\": \"" + randomDate() + "\",";
						}else{
							formatField = "\"" + column + "\": \""
									+ ThreadLocalRandom.current().nextInt(10, 200 + 1) + "\",";
						}

						return formatField;
					}).collect(Collectors.toList());
			output.set(output.size() - 1, output.get(output.size() - 1).replace(",", "\n"));
			Files.write(Paths.get("F:\\PostJsons.txt"), output);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String randomDate() {
		GregorianCalendar gc = new GregorianCalendar();

		int year = randBetween(2016, 2020);

		gc.set(gc.YEAR, year);

		int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));

		gc.set(gc.DAY_OF_YEAR, dayOfYear);

		return gc.get(gc.YEAR) + "-" + (gc.get(gc.MONTH) + 1) + "-" + gc.get(gc.DAY_OF_MONTH);

	}

	public static int randBetween(int start, int end) {
		return start + (int) Math.round(Math.random() * (end - start));
	}

}
