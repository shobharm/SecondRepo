package com.example.TestApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.BindException;
import java.net.DatagramSocket;
import java.net.HttpURLConnection;
import java.net.ServerSocket;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DockerSpawning {
	
	private static final String USER_AGENT = "Mozilla/5.0";
	@RequestMapping(value ="/port",method = RequestMethod.GET)
	public @ResponseBody Map<String, String> getContainerDetails() throws IOException{
		
		
		String url = "http://localhost:8091/10.132.32.192_27/udp";
		Map<String, String> ipList = new HashMap<String,String>();
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
        String response1= response.toString();
        System.out.println(response.toString());
        response1 = response1.substring(1,response1.length()-1);
         response1= response1.replaceAll("\"", "");
        String list[] = response1.split(",");
        
        List<String> wordList = Arrays.asList(list);
        
        for (String ipadd : wordList)
        {
        	System.out.println(ipadd);
        	StringBuffer port = getPort();
        	
	        String s;
	        Process p;
	        try {
	            p = Runtime.getRuntime().exec("docker run -d --name "+ipadd+" --publish "+port+":8080 samplesnmp");

	            BufferedReader br = new BufferedReader(
	                new InputStreamReader(p.getInputStream()));
	            while ((s = br.readLine()) != null)
	            p.waitFor();
	            System.out.println ("exit: " + p.exitValue());
	            if(p.exitValue()==0) {
	            	ipList.put(ipadd, port.toString());
	            }
	            p.destroy();
	            
	        }
	         catch (Exception e) {
	        	e.printStackTrace();
	        	if(ipList.isEmpty()) {
	            	ipList.put("Error Occured", "Unable to proceed, Please check the logs for details");
	            }
	        }
        }
        in.close();
        return ipList;
    }
	
	
	public static StringBuffer getPort() {
		StringBuffer port = new StringBuffer("80");
        Random rand = new Random();
        int  n = rand.nextInt(99) + 10;
        port.append(n);
        int portint = Integer.parseInt(port.toString());
        System.out.println(portint);
        if(available(portint)) {
        	return port;
        }else {
        	getPort();
        }
      
        return port;	
	}
	public static boolean available(int port) {
	    
	    ServerSocket ss = null;
	    DatagramSocket ds = null;
	    try {
	    	if(port<8010 || port>8099) {
	    		return false;
	    	}
	    	else{
	    	ss = new ServerSocket(port);
	        ss.setReuseAddress(true);
	        ds = new DatagramSocket(port);
	        ds.setReuseAddress(true);
	        return true;
	    	}
	    } catch (IOException e) {
	    } finally {
	        if (ds != null) {
	            ds.close();
	        }

	        if (ss != null) {
	            try {
	                ss.close();
	            } catch (IOException e) {
	                /* should not be thrown */
	            }
	        }
	    }

	    return false;
	}	
}
