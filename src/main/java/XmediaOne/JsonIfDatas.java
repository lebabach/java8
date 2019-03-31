package XmediaOne;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

public class JsonIfDatas {
	public static void main(String[] s) {
		try (Stream<String> stream = Files.lines(Paths.get("F:\\table.txt"), StandardCharsets.ISO_8859_1)) {

			List<String> output = stream.parallel().map(line -> {
				String partterField = StringUtils.EMPTY;
				if (line.contains("--")) {
					line = line.substring(0, line.indexOf("--"));
				}
				line = line.trim();
				String[] slitLine = line.split(" ");
				if (line.contains("bigint") || line.contains("smallint") || line.contains("numeric")) {
					partterField = "@(Pattern @field)(regexp = \"\"\"^[-]?\\d+$\"\"\")" + "\n";
				}
				else if (line.contains("timestamp") && (!line.contains("delete_date") && !line.contains("insert_date")
						&& !line.contains("update_date"))) {
					partterField = "@(DateRange @field)(format = \"yyyy-MM-dd\")" + "\n";
				}
				else if (line.contains("timestamp") && line.contains("update_date")) {
					partterField = "@(DateRange @field)(format = \"yyyy-MM-dd HH:mm:ss.SSS\")" + "\n";
				}

				String column = slitLine[0];
				String jsonProperty = String.format("@JsonProperty(\"%s\")", column);
				String columnFormat=StringUtils.uncapitalize(Arrays.asList(column.split("_")).stream().map(x->StringUtils.upperCase(x)).collect(Collectors.joining("")));
				String propertyFormat = String.format("%s\n%svar %s: String = null,\n", jsonProperty, partterField,
						columnFormat);
				return propertyFormat;
			}).collect(Collectors.toList());
			output.set(output.size()-1, output.get(output.size()-1).replace(",","\n"));
			Files.write(Paths.get("F:\\JsonIfDatas.txt"), output);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
