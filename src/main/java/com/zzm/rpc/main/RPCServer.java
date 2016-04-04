package com.zzm.rpc.main;

import java.io.IOException;

import org.apache.hadoop.HadoopIllegalArgumentException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;
import org.apache.hadoop.ipc.Server;

import com.zzm.rpc.impl.Bizable;

public class RPCServer implements Bizable {
	
	/**
	 * ����rpc���ݵķ���
	 */
	public String say(String name) {
		return "hi " + name;
	}
	
	/**
	 * 
	 * @param args
	 * @throws IOException 
	 * @throws HadoopIllegalArgumentException 
	 */
	public static void main(String[] args) throws HadoopIllegalArgumentException, IOException {
		Configuration conf = new Configuration();
		/**
		 * ���ô������ ʵ�������� �󶨵�ַ, �󶨶˿�
		 */
		Server server = new RPC.Builder(conf).setProtocol(Bizable.class).setInstance(new RPCServer()).setBindAddress("192.168.0.105").setPort(9555).build();
		server.start();
	}

}
