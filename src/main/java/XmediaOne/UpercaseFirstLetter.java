package XmediaOne;

import java.util.*;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

public class UpercaseFirstLetter {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = "le_ba_bach";
		List<String> strings = Arrays.asList(string.split("_"));
		//System.out.println(StringUtils.uncapitalize(strings.stream().map(x->StringUtils.capitalise(x)).collect(Collectors.joining(""))));
		System.out.println(strings.stream().skip(1).collect(Collectors.joining("")));
	}

}
