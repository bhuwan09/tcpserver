package servers.servertoreadandwrite;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServerForReadAndWrite {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(3333);
        System.out.println("Server Started");
        System.out.println("waiting for Client ...");

        Socket s = ss.accept();
        System.out.println("Client accepted");
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String str="", str2 ="";
        while(!str.equals("stop")){
            str = din.readUTF();
            System.out.println("client says:" + str);
            str2 = br.readLine();
            dout.writeUTF(str2);
            dout.flush();
        }
        System.out.println("Closing connection");

        din.close();
        s.close();
        ss.close();
    }
}
