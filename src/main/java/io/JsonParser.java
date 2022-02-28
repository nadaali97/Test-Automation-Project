
package io;

import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonParser {
	public static SimpleDateFormat Dateformatter = new SimpleDateFormat("yyyy-MM-dd");
	public static JSONParser parser;

	public static JSONObject readJson(String path) {
		try {
			Object config = getParser().parse(new FileReader(path));
			return (JSONObject) config;

		} catch (ParseException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static JSONParser getParser() {
		if (parser == null)
			parser = new JSONParser();
		return parser;
	}

	public static SimpleDateFormat getDateformatter() {
		return Dateformatter;
	}

}