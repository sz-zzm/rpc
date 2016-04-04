package com.zzm.rpc.main;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

import com.zzm.rpc.impl.Bizable;

public class RPCClient {
	
	/**
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Bizable proxy  = RPC.getProxy(Bizable.class, 1000, new InetSocketAddress("192.168.0.105", 9555), new Configuration());
		String res = proxy.say("zzm");
		System.out.println(res);
		RPC.stopProxy(proxy);
	}
	
}
