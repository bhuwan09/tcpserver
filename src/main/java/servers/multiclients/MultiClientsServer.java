package servers.multiclients;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MultiClientsServer {
    public static void main(String[] args) {
        ArrayList<ServerThread> threadList = new ArrayList<>();   //to add  clients thread
        try(ServerSocket serverSocket = new ServerSocket(5000))
        {
            while(true){
                Socket socket = serverSocket.accept();
                ServerThread serverThread = new ServerThread(socket,threadList);

                threadList.add(serverThread); //starting the thread
                serverThread.start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
