package com.example.TestApp;

import java.io.FileInputStream;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.w3c.dom.html.HTMLDocument;

public class Test {
	 private static String  OldTime="2:15:09.40";
	public static void main(String[] args) throws UnknownHostException, SocketException {
		/*SimpleDateFormat parser = new SimpleDateFormat("HH:mm:ss.FFF");
		SimpleDateFormat target = new SimpleDateFormat("HH:mm:ss.FFF");
    	Date OldTimeDate;
		try {
			OldTimeDate = parser.parse(OldTime);
		
    	Calendar cal = Calendar.getInstance();
    	System.out.println("Inside pdu not null+++");
    	String newTimString="2:15:39.40";
    		Date newTime = parser.parse(newTimString);
    		System.out.println("New Time"+target.format(newTime));
    		System.out.println("New Time"+newTime.toString()+"++++++Old Time+++++"+target.format(OldTimeDate));
    		cal.setTime(parser.parse(target.format(OldTimeDate)));
    		cal.add(Calendar.SECOND, 10);
    		String oldTimeString = parser.format(cal.getTime());
    		Date OldTimeTenSec=parser.parse(oldTimeString); 
    		
    		
    		        NetworkInterface ni = NetworkInterface.getByName("eno1");
    		        Enumeration<InetAddress> inetAddresses =  ni.getInetAddresses();


    		        while(inetAddresses.hasMoreElements()) {
    		            InetAddress ia = inetAddresses.nextElement();
    		            if(!ia.isLinkLocalAddress()) {
    		                System.out.println("IP: " + ia.getHostAddress());
    		            }
    		        }
    		
    		
    		
    		
    		//System.out.println("IP Address"+InetAddress.getLocalHost().getHostAddress());
    		System.out.println("OldTime String "+parser.parse(oldTimeString)+"New time"+parser.parse(target.format(newTime)));
    		System.out.println("if"+parser.parse(target.format(newTime)).compareTo(OldTimeTenSec));
    		if(target.format(OldTimeDate).equals("00:00:00.004")) {
    			System.out.println("Coming inside if loop");
    		}else if(parser.parse(target.format(newTime)).compareTo(OldTimeTenSec)>=1){
    			System.out.println("Coming inside else loop"+target.format(newTime));
    			OldTimeDate=newTime;
    		}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
*/
		/*Object content =
				   new URL("http://www.brainbench.com").readObject();
int a=3;int b=0;
switch(a) {
case 1:
	b=a+2;
case 3:
	b=a+4;
}
		System.out.println(System.resolveHostByName("www.brainbench.com"));
	}*/
		//List<String> a=new ArrayList<String>();
		
		/*al.add("a");
		al.add("b");
		al.add("c");
		al.add("d");
		al.forEach(System.out::println);
		Map<String,Integer> amap=new HashMap<String,Integer>();
		amap.put("a",1);
		amap.put("b",2);
		amap.put("c",3);
		amap.put("d",4);
	
		//Set<Integer> entMap=amap.values();
		for (Integer a:entMap) {
			System.out.println(a);
		}*/
		/*amap.forEach((k,v)->{
			if(k=="c") {
				
				System.out.println(k+"="+v);
			}
		});*/
	}

}
