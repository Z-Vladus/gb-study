package ru.geekbrainsLev2.Lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
    private Socket socket;
    private DataOutputStream os;
    private DataInputStream is;



    public static void main(String[] args) {
        EchoClient client = new EchoClient();
        client.start();
    }

    private void start() {
        try {
            openConnection();
            Scanner scanner = new Scanner(System.in);
            while (true){
                String msg = scanner.nextLine(); // blocking method
                os.writeUTF(msg);  // sending messages
                if("/end".equalsIgnoreCase(msg)){break;};
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    private void closeConnection() {

        if (socket!=null) {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (is!=null) {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (os!=null) {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // подкл. к серверу
    private void openConnection() throws IOException {
        socket = new Socket("127.0.0.1",8189);
        is = new DataInputStream(socket.getInputStream());
        os = new DataOutputStream(socket.getOutputStream());

        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true){
                        // ждём сообщения от сервера
                        final String msg = is.readUTF(); // blocking
                        if("/end".equalsIgnoreCase(msg)){break;};
                        System.out.println("Сообщение от сервера: "+msg);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    closeConnection();
                }
            }
        });
        thread.start();




    }

}
