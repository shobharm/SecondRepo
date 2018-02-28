/*package com.example.TestApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nmap4j.Nmap4j;
import org.nmap4j.core.nmap.ExecutionResults;
import org.nmap4j.data.NMapRun;
import org.nmap4j.data.nmaprun.Host;
import org.nmap4j.parser.OnePassParser;
import org.snmp4j.smi.OID;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class NmapController {
	
	private final String USER_AGENT = "Mozilla/5.0";
	
	@RequestMapping(value="/{ipaddress:.*}/{udp}", method=RequestMethod.GET)
	public @ResponseBody ArrayList getNmaPDetails(@PathVariable(value="ipaddress") String ipaddress, @PathVariable(value="udp") String radioVal) throws IOException {
		ArrayList<String> ipaddresList = new ArrayList<String>();
		String originalvalue = ipaddress.replaceAll("_","/");
		
		 Nmap4j nmap4j = new Nmap4j("/usr/") ;
	   	 nmap4j.includeHosts(originalvalue) ;
	   	 if(radioVal.equalsIgnoreCase("udp"))
	   	 {
	 	nmap4j.addFlags("--privileged -sU -p161");
	   	 }
	   	 else
	   	 {
	   		nmap4j.addFlags("--privileged -sT -p2022");
	   	 }

	   	  try{
	   	  nmap4j.execute() ; 
	   	 }catch(Exception e){
	   		 e.printStackTrace();
	   	  System.out.println("error execute");

	   	 }
	   	 if( !nmap4j.hasError() ) { 

		   		ExecutionResults res=nmap4j.getExecutionResults();
		   		String nmapRun = nmap4j.getOutput() ;
		   	   	
		   	   	OnePassParser opp = new OnePassParser() ;
		   	   	NMapRun nmapRun1 = opp.parse( nmapRun, OnePassParser.STRING_INPUT ) ;
		   	   	ArrayList<Host> hosts=nmapRun1.getHosts(); 
		   	   	for(Host ipAddr:hosts) {
		   	   	if(ipAddr.getPorts().getPorts().get(0).getState().getState().equalsIgnoreCase("open")) {
		   	   		ipaddresList.add(ipAddr.getAddresses().get(0).getAddr());
		   	   		
		   		}
		   	   		}
		   	   	
		   	  System.out.println(""+res.getOutput()+"\n");
		   	 }
	   	  else {
	   	   System.out.println( nmap4j.getExecutionResults().getErrors() ) ; 
	   	   }
	   //	getContainerDetails(ipaddresList);

		 System.out.println("ipaddresList"+ipaddresList);
	 	 
	 return ipaddresList;
	 	
	}
	
	
	public void getContainerDetails(ArrayList<String> list) throws IOException {
		 String url = "http://localhost:8036/port/";
		
		 String uriList = list.toString();
		 uriList = uriList.substring(1, uriList.length()-1);
		 System.out.println(url+uriList);
	        URL obj = new URL(url+uriList);
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

	        System.out.println(response.toString());
	}
	}
	
	
*/