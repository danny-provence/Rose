package com.buaa.multiSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class ServerThread implements Runnable {
	public ServerThread(Socket socket) throws IOException {
		super();
		this.socket = socket;
		bReader = new BufferedReader(new InputStreamReader(
				socket.getInputStream(), "utf-8"));
	}

	Socket socket;
	BufferedReader bReader;

	@Override
	public void run() {
		try {
			String content = null;
			while ((content = bReader.readLine()) != null) {
				for (Socket socket : MyServer.sockets) {
					OutputStream outputStream = socket.getOutputStream();
					outputStream.write((content + "\n").getBytes("utf-8"));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
