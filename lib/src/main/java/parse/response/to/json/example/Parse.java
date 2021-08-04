package parse.response.to.json.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Parse {
	/**
	 * Parse JSON String to org.json.simple.JSONObject.
	 * 
	 * @param json Required String to parse.
	 * @return A JSONObject from String
	 * @throws ParseException If the parse cannot be performed.
	 */
	public JSONObject toJsonObject(String json) throws ParseException {
		final JSONParser parser = new JSONParser();
		return (JSONObject) parser.parse(json);
	}

	/**
	 * Parse JSON String to org.json.simple.JSONArray.
	 * 
	 * @param json Required String to parse.
	 * @return A JSONArray from String
	 * @throws ParseException If the parse cannot be performed.
	 */
	public JSONArray toJsonArray(String json) throws ParseException {
		final JSONParser parser = new JSONParser();
		return (JSONArray) parser.parse(json);
	}
}
