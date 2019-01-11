package test6;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClient {
    public static void main(String[] args) {
        try {
            Socket socket=new Socket("localhost",10086);
            OutputStream out=socket.getOutputStream();
            PrintWriter writer=new PrintWriter(out);
            writer.write("Jerry");
            writer.flush();
            socket.shutdownOutput();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
