package com.nextgen.snmp;

import java.util.Date;

import org.snmp4j.CommunityTarget;
import org.snmp4j.PDU;
import org.snmp4j.Snmp;
import org.snmp4j.TransportMapping;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.IpAddress;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.UdpAddress;
import org.snmp4j.smi.VariableBinding;
import org.snmp4j.transport.DefaultUdpTransportMapping;

public class TrapSenderVersion2 {

	public static final String community = "public";

	// Sending Trap for sysLocation of RFC1213
	public static final String Oid = "1.3.6.1.4.1.39067.100.0.8";

	//IP of Local Host
	public static final String ipAddress = "10.132.32.211";

	//Ideally Port 162 should be used to send receive Trap, any other available Port can be used
	public static final int port = 1025;

	public static void main(String[] args) {
		TrapSenderVersion2 trapV2 = new TrapSenderVersion2();
		trapV2.sendTrap_Version2();
	}
	/**
	 * This methods sends the V1 trap to the Localhost in port 162
	 */
	public void sendTrap_Version2() {
		try {
			// Create Transport Mapping
			TransportMapping transport = new DefaultUdpTransportMapping();
			transport.listen();

			// Create Target
			CommunityTarget cTarget = new CommunityTarget();
			cTarget.setCommunity(new OctetString(community));
			cTarget.setVersion(SnmpConstants.version2c);
			cTarget.setAddress(new UdpAddress(ipAddress + "/" + port));
			cTarget.setRetries(2);
			cTarget.setTimeout(5000);

			// Create PDU for V2
			PDU pdu = new PDU();

			// need to specify the system up time
			pdu.add(new VariableBinding(SnmpConstants.sysUpTime,
					new OctetString(new Date().toString())));
			pdu.add(new VariableBinding(SnmpConstants.snmpTrapOID, new OID(
					Oid)));
			pdu.add(new VariableBinding(SnmpConstants.snmpTrapAddress,
					new IpAddress(ipAddress)));

			pdu.add(new VariableBinding(new OID(Oid), new OctetString(
					"Major")));
			pdu.setType(PDU.NOTIFICATION);

			// Send the PDU
			Snmp snmp = new Snmp(transport);
			System.out.println("Sending V2 Trap... Check Wheather NMS is Listening or not? ");
			snmp.send(pdu, cTarget);
			snmp.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
