package com.mycompany.editor;

import java.io.*;
import java.net.Socket;

public  class ClientSocket {

    private Socket socket;
    private ObjectInputStream in;
    private ObjectOutputStream out;


    public void start() {
        try {
            InputStream inputStream= socket.getInputStream();
            in = new ObjectInputStream(inputStream);
            OutputStream outputStream= socket.getOutputStream();
            out = new ObjectOutputStream(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void connect() {
        try {
            socket = new Socket("0.0.0.0", 6969);

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