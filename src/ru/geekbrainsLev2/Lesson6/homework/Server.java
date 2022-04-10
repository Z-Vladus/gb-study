package ru.geekbrainsLev2.Lesson6.homework;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        Socket socket = null;
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket  (8189);
            System.out.println("Сервер запущен");

            socket = serverSocket.accept(); // blocking
            System.out.println("клиент подключился");

            //  получение сообщений
            DataInputStream is = new DataInputStream(socket.getInputStream());
            // отсылка сообщений
            DataOutputStream os = new DataOutputStream(socket.getOutputStream());

            while (true) {
                String msg = is.readUTF(); // blocking
                // ядовитая таблетка
                if ("/end".equalsIgnoreCase(msg)) {
                    os.writeUTF("/end");
                    break;
                }
                os.writeUTF("Echo: " + msg);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket!=null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Сервер остановлен");
    }

}
