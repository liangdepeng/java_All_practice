package http;

import ldp.utils.SystemOutputUtils;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    public static void main(String[] args) {
        tcpServer();
    }

    private static void tcpServer(){
        try{
            // 创建服务器端 Socket
            ServerSocket serverSocket = new ServerSocket(1234);
            SystemOutputUtils.println(serverSocket.getInetAddress());
            // 等待客户端连接
            Socket clientSocket = serverSocket.accept();

            // 获取客户端输入流
            InputStream inputStream = clientSocket.getInputStream();
            InputStreamReader reader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(reader);
            // 读取数据
            String data =null;
            while ((data=bufferedReader.readLine())!=null){
                SystemOutputUtils.println(data);
            }
            // 关闭客户端输入流
            clientSocket.shutdownInput();

            OutputStream outputStream = clientSocket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.println("服务端的响应数据1");
            printWriter.println("服务端的响应数据2");
            printWriter.flush();
            // 关闭输出流
            clientSocket.shutdownOutput();
            printWriter.close();
            outputStream.close();
            bufferedReader.close();
            reader.close();
            inputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
