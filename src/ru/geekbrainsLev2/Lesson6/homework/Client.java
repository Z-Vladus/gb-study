package ru.geekbrainsLev2.Lesson6.homework;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private Socket s;
    private DataOutputStream os;
    private DataInputStream is;

    public static void main(String[] args) {
        Client c = new Client();
        c.start();
    }

    private void start() {
        try {
            openConnection();
            Scanner scanner = new Scanner(System.in);
            while (true){
                System.out.print("Enter text message for server: ");
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

        if (s!=null) {
            try {
                s.close();
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
        s = new Socket("127.0.0.1",8189);
        is = new DataInputStream(s.getInputStream());
        os = new DataOutputStream(s.getOutputStream());

        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true){
                        // ждём сообщения от сервера
                        final String msg = is.readUTF(); // blocking
                        if("/end".equalsIgnoreCase(msg)){break;};
                        System.out.println();
                        System.out.println("Сообщение от сервера: "+msg);
                        System.out.print("Enter text message for client: ");
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
