package com.example.TestApp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.snmp4j.agent.mo.snmp.SNMPv2MIB.SysOREntry;
import org.snmp4j.smi.OID;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nextgen.demo.Attributes;
import com.nextgen.demo.SNMPManager;

@Controller
public class SNMPController {

	
	@RequestMapping(value ="/{ipaddress:.*}",method = RequestMethod.GET)
	 public void add(@PathVariable("ipaddress") String ipaddress,HttpServletResponse resp) throws Exception {
		
		PrintWriter out = resp.getWriter();
		System.out.println("in add");
		SNMPManager client = new SNMPManager(""+ipaddress+"/161");
		client.start();
		
		/**
			* OID - .1.3.6.1.2.1.1.1.0 => SysDec
			* OID - .1.3.6.1.2.1.1.5.0 => SysName
			* => MIB explorer will be useful here, as discussed in previous article
			*/
		String sysDescr = client.getAsString(new OID(".1.3.6.1.2.1.1.1.0"));
		String cpuutilization = client.getAsString(new OID(".1.3.6.1.4.1.2021.11.9.0"));
		String ramUsed = client.getAsString(new OID(".1.3.6.1.4.1.2021.4.6.0"));
		String diskStatistics = client.getAsString(new OID(".1.3.6.1.4.1.2021.9.1.6.1"));
		out.println("sysDescr"+sysDescr);
		out.println("cpuutilization"+cpuutilization);
	    out.println("ramUsed"+ramUsed);
	    out.println("diskStatistics"+diskStatistics);
		out.close();	
	}
	
}
	

