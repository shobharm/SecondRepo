package com.example.TestApp;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class WebsiteTriggerController {
	private final String USER_AGENT = "Mozilla/5.0";
	
	
	@RequestMapping("/")
	public void triggerWebsite() {
		
	//	HttpURLConnectionExample http = new HttpURLConnectionExample();

		System.out.println("Testing 1 - Send Http GET request");
		

		List<String> url = new ArrayList<String>();
				url.add("http://www.google.com/");
				url.add("https://stackoverflow.com/");
				url.add("https://https://www.youtube.com/watch?v=6cKErCWrb44");
				url.add("https://in.yahoo.com/");
				url.add("https://en.wikipedia.org/wiki/Main_Page");
				url.add("http://university.mongodb.com/");
				url.add("http://pythonhosted.org/");
				Random rand = new Random();
				
				

			url.forEach(i->{
				try {
					sendGet(i);
					int  n = rand.nextInt(5000) + 1000;
					System.out.println("Sleeping for "+n+" milli seconds");
					Thread.sleep(n);
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
			
		
	}
	
	private void sendGet(String url) throws Exception {

		System.out.println("beginning of sendGet");
				

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		System.out.println(response.toString());

	}
	

}
