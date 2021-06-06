package guru.springframework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

import guru.springframework.services.StringUtils;

public class SSocketThread implements Runnable{
    
	Socket client;  
    
    public SSocketThread(Socket client) {
        this.client = client;  
    }

    public void run() {
    	StringBuilder sb = new StringBuilder();
        try {
//		   StringBuffer text=new StringBuffer();
//		   BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
//		   PrintStream  ps = new PrintStream(client.getOutputStream());
//		   String msg;
//		   //如果输入流不为空,将接受到的信息打印到相应的文本框中并反馈回收到的信息
//		   if ((msg = br.readLine()) != null) {
//		       text.append("服务器端收到：" + msg + "\n");
//		       ps.println(msg);
//		   }
//		   System.out.println(msg);
//		   ps.close();
//		   br.close();
        	InputStream inputStream = client.getInputStream();
        	//解决拥塞问题
        	client.setSoTimeout(2000);
            byte[] bytes = new byte[10];
            int len;
            
            
            while ((len = inputStream.read(bytes)) != -1) {
              //注意指定编码格式，发送方和接收方一定要统一，建议使用UTF-8
              sb.append(new String(bytes, 0, len,"UTF-8"));
            }
            System.out.println("get message from client: " + sb);
            inputStream.close();
        } catch (IOException e) {  
            //e.printStackTrace();  
        	//System.out.println("get message from client: " + sb);
        	System.out.println(StringUtils.hexStringToString(sb.toString()));
        }
    }
}
