package cn.bangnongmang.notify.server.service.util;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NotifyPatternUtil {
	public static Pattern replacePattern = Pattern.compile("\\$\\{(\\w+)\\}");

	public static String parsePatternToValue(String pattern, Map<String, Object> params) {

		if (params == null) {
			return pattern;
		}
		if (pattern == null) {
			return null;
		}

		String s = pattern;
		Matcher matcher = replacePattern.matcher(s);
		while (matcher.find()) {
			if (params.containsKey(matcher.group(1))) {
				s = s.replace(matcher.group(), String.valueOf(params.get(matcher.group(1))));
			}
		}

		return s;
	}
}
