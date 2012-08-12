package com.buaa.multiSocket;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class MyServer {
public static List<Socket> sockets=new ArrayList<Socket>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
ServerSocket ss=new ServerSocket(30001);
while (true) {
	Socket socket=ss.accept();
	sockets.add(socket);
	new Thread(new ServerThread(socket)).start();
	
	
}
	}

}
