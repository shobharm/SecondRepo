package com.nextgen.snmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;

import org.snmp4j.CommandResponder;
import org.snmp4j.CommandResponderEvent;
import org.snmp4j.CommunityTarget;
import org.snmp4j.MessageDispatcher;
import org.snmp4j.MessageDispatcherImpl;
import org.snmp4j.PDU;
import org.snmp4j.Snmp;
import org.snmp4j.mp.MPv1;
import org.snmp4j.mp.MPv2c;
import org.snmp4j.security.Priv3DES;
import org.snmp4j.security.SecurityProtocols;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.TcpAddress;
import org.snmp4j.smi.TransportIpAddress;
import org.snmp4j.smi.UdpAddress;
import org.snmp4j.smi.Variable;
import org.snmp4j.transport.AbstractTransportMapping;
import org.snmp4j.transport.DefaultTcpTransportMapping;
import org.snmp4j.transport.DefaultUdpTransportMapping;
import org.snmp4j.util.MultiThreadedMessageDispatcher;
import org.snmp4j.util.ThreadPool;

public class TrapReceiver implements CommandResponder{
	 private final String USER_AGENT = "Mozilla/5.0";
	 private static String OldTime="00:00:00.0";
		public static void main(String[] args)
		  {
		    TrapReceiver snmp4jTrapReceiver = new TrapReceiver();
		    try
		    {
		      snmp4jTrapReceiver.listen(new UdpAddress("10.132.32.211/162"));
		    }
		    catch (IOException e)
		    {
		      System.err.println("Error in Listening for Trap");
		      System.err.println("Exception Message = " + e.getMessage());
		    }
		  }

		  /**
		   * This method will listen for traps and response pdu's from SNMP agent.
		   */
		  public synchronized void listen(TransportIpAddress address) throws IOException
		  {
		    AbstractTransportMapping transport;
		    if (address instanceof TcpAddress)
		    {
		      transport = new DefaultTcpTransportMapping((TcpAddress) address);
		    }
		    else
		    {
		      transport = new DefaultUdpTransportMapping((UdpAddress) address);
		    }

		    ThreadPool threadPool = ThreadPool.create("DispatcherPool", 10);
		    MessageDispatcher mtDispatcher = new MultiThreadedMessageDispatcher(threadPool, new MessageDispatcherImpl());

		    // add message processing models
		    mtDispatcher.addMessageProcessingModel(new MPv1());
		    mtDispatcher.addMessageProcessingModel(new MPv2c());

		    // add all security protocols
		    SecurityProtocols.getInstance().addDefaultProtocols();
		    SecurityProtocols.getInstance().addPrivacyProtocol(new Priv3DES());

		    //Create Target
		    CommunityTarget target = new CommunityTarget();
		    target.setCommunity( new OctetString("public"));
		   
		    Snmp snmp = new Snmp(mtDispatcher, transport);
		    snmp.addCommandResponder(this);
		   
		    transport.listen();
		    System.out.println("Listening on " + address);

		    try
		    {
		      this.wait();
		    }
		    catch (InterruptedException ex)
		    {
		      Thread.currentThread().interrupt();
		    }
		  }
	
	/**
     * This method will be called whenever a pdu is received on the given port
     * specified in the listen() method
     */
		  
		  /**
		   * This method will be called whenever a pdu is received on the given port specified in the listen() method
		   */
		  public synchronized void processPdu(CommandResponderEvent cmdRespEvent) 
		  {
		    System.out.println("Received PDU++++...");
		    PDU pdu = cmdRespEvent.getPDU();
		    OID systemTimeOID= new OID("1.3.6.1.2.1.1.3.0");
	    	
	    	

		    if (pdu != null){
		    	try {
		    		SimpleDateFormat parser = new SimpleDateFormat("HH:mm:ss.FFF");
		    		SimpleDateFormat target = new SimpleDateFormat("HH:mm:ss.FFF");
		    		Calendar cal = Calendar.getInstance();
		    		
		    		String OldTimeDate= target.format(parser.parse(OldTime));
		    
		    	String newTimString=pdu.getVariable(systemTimeOID).toString();
		    		Date newTime = parser.parse(newTimString);
		    		cal.setTime(parser.parse(OldTimeDate));
		    		cal.add(Calendar.SECOND, 10);
		    		String oldTimeString = parser.format(cal.getTime());
		    		Date OldTimeTenSec=parser.parse(oldTimeString); 
		    		if(OldTimeDate.equals("00:00:00.004")) {
		    			sendEmail(pdu);
		    			OldTime=target.format(newTime).toString();
		    		}else if(parser.parse(target.format(newTime)).compareTo(OldTimeTenSec)>=1){
		    			sendEmail(pdu);
		    			OldTime=target.format(newTime).toString();
		    		
		    		}
					

					} catch (ParseException e) {
						 System.out.println("Exception"+e);
					}
		    }    
		  }
		  
		  
		  
		  
		  
		  	
		  
		  public void sendEmail(PDU pdu) {
			  try {
		    	String url = "http://localhost:8036/sendmail";
		    	URL obj;
		    	String ipAddress="";
		  	     BufferedReader in =null;
		  	     OID trapOID= new OID("1.3.6.1.6.3.1.1.4.1.0");
		  	     
		  	     
		  	   NetworkInterface ni = NetworkInterface.getByName("eno1");
		        Enumeration<InetAddress> inetAddresses =  ni.getInetAddresses();


		        while(inetAddresses.hasMoreElements()) {
		            InetAddress ia = inetAddresses.nextElement();
		            if(!ia.isLinkLocalAddress()) {
		                System.out.println("IP: " + ia.getHostAddress());
		                ipAddress=ia.getHostAddress();
		            }
		        }
		  	     		  	     
	            
		            
		     	String snmpTrapOID=pdu.getVariable(trapOID).toString();
		     	String body="";
		     	String subject="";
		     	if(snmpTrapOID.trim().equals("1.3.6.1.6.3.1.1.5.5")) {
		     	body= "Hi,_This is to inform you that there was password breach for the device with IP address "+ipAddress+"._Regards_Admin";
		     	subject="Password breach intimation";	
		     	}
		     	
		     	String mailBody=body+"-"+subject;
		     	mailBody=mailBody.replaceAll(" ", "%20");
		     	url=url+"/"+mailBody;
		     	System.out.println("mail body"+mailBody+"URL+++++++++++"+url);
					try {
						obj = new URL(url);
					
		   	        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		   	        // optional default is GET
		   	        con.setRequestMethod("GET");

		   	        //add request header
		   	       con.setRequestProperty("User-Agent", USER_AGENT);

		   	        int responseCode = con.getResponseCode();
		   	        System.out.println("\nSending 'GET' request to URL : " + url);
		   	        System.out.println("Response Code : " + responseCode);

		   	         in = new BufferedReader(
		   	                new InputStreamReader(con.getInputStream()));
		   	        String inputLine;
		   	        StringBuffer response = new StringBuffer();

		   	        while ((inputLine = in.readLine()) != null) {
		   	            response.append(inputLine);
		   	        }
		   	       
		   	     System.out.println(response.toString());
			        
					} catch (Exception e) {
						e.printStackTrace();
					}finally {
						 try {
							in.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
		   	      
		    }catch(Exception e) {
		    	System.out.println("Exception ***********"+e.getMessage());
		    }
		  
		  
		  
		  
		  }

            }
    


