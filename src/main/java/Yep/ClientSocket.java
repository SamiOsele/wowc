package Yep;

import java.io.*;
import java.net.Socket;

public  class ClientSocket {

    private Socket socket;
    private ObjectInputStream in;
    private ObjectOutputStream out;


    public void start() {
        try {
            System.out.println(socket.getInetAddress().getHostAddress());
           // InputStream inputStream= socket.getInputStream();
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
            // OutputStream outputStream= socket.getOutputStream();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void connect() {
        try {
            socket = new Socket("192.168.43.10", 6969);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ObjectInputStream getIn() {
        return in;
    }

    public ObjectOutputStream getOut() {
        return out;
    }
}