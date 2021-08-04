package parse.response.to.json.example;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class GetData {
	final private String url;

	/**
	 * Main constructor
	 * 
	 * @param url The URL from API to get data.
	 */
	public GetData(String url) {
		this.url = url;
	}

	/**
	 * This function is synchronous to get data from API.
	 * 
	 * @return String with body of the response.
	 */
	public String data() {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
		try {
			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
			return response.body();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}

}
