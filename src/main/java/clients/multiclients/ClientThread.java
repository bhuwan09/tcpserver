package clients.multiclients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientThread extends Thread{
    private Socket socket;
    private BufferedReader input;

    public ClientThread(Socket s) throws IOException {
        this.socket = s;
        this.input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    @Override
    public void run()
    {
        try{
            while(true)
            {
                String response = input.readLine();
                System.out.println(response);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                input.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
