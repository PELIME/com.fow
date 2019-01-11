package test6;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    public static void main(String[] args) {
        try {
            ServerSocket server=new ServerSocket(10086);
            Socket socket=null;
           while (true)
           {
               socket=server.accept();
               new ServerThread(socket).run();
           }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static class ServerThread extends Thread
    {
        Socket socket;
        public ServerThread(Socket socket)
        {
            this.socket=socket;
        }

        @Override
        public void run()
        {
            try {
                InputStream stream = socket.getInputStream();
                StringBuffer sb=new StringBuffer();
                char c=' ';
                BufferedReader br=new BufferedReader(new InputStreamReader(stream));
                String s=null;
                while ((s=br.readLine())!=null)
                {
                    sb.append(s);
                }
                System.out.println("hello "+sb.toString());
                stream.close();
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

}
