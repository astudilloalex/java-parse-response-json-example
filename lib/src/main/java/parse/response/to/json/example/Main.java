package parse.response.to.json.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public class Main {
	public static void main(String[] args) {
		JSONArray data = new JSONArray();
		try {
			//JSONArray countries = new Parse().toJsonArray(new GetData("https://restcountries.eu/rest/v2/all").data());
			JSONArray cities = new Parse().toJsonArray(new GetData(
					"https://raw.githubusercontent.com/dr5hn/countries-states-cities-database/master/cities.json")
							.data());	
			for (int i = 0; i < cities.size(); i++) {
				JSONObject object = new JSONObject();	
				object.put("name", ((JSONObject) cities.get(i)).get("name"));
				object.put("countryCode", ((JSONObject) cities.get(i)).get("country_code"));
				data.add(object);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(data.size());
		try(FileWriter file=new FileWriter("cities.json")){
			file.write(data.toJSONString());
			file.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
