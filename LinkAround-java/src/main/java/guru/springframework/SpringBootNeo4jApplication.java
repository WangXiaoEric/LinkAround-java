package guru.springframework;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
public class SpringBootNeo4jApplication {

	public static void main(String[] args) {
		//開啟HTTP服務監聽, 接收android數據
		SpringApplication.run(SpringBootNeo4jApplication.class, args);
		
		//開啟TCP端口監聽，接受Arduino數據
		new Thread() {
			public void run() {
				try {
				ServerSocket servSock;
				servSock = new ServerSocket();
		        servSock.bind(new InetSocketAddress("192.168.50.84", 16666));
		        System.out.println("socket服务端:"+servSock.getInetAddress()+":"+servSock.getLocalPort()+""); 
		        while(true){
		            // 2.调用accept方法，建立和客户端的连接  
		            Socket client = servSock.accept(); 
		            SocketAddress clientAddress =client.getRemoteSocketAddress();  
		            System.out.println("socket链接客户端:" + clientAddress);  
		           new Thread(new SSocketThread(client)).start();   
		         } 
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				
			};
		}.start();
	}
}
