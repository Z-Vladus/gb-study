package ru.geekbrainsLev2.Lesson6.homework;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    private boolean msgRcvd=false;

    public boolean isMsgRcvd() {
        return msgRcvd;
    }

    public void setMsgRcvd(boolean msgRcvd) {
        this.msgRcvd = msgRcvd;
    }

    public void start(){
        this.setMsgRcvd(false);

        Socket socket = null;
        ServerSocket serverSocket = null;
        boolean msgReceived=false;
        try {
            serverSocket = new ServerSocket  (8189);
            System.out.println("server is listening at "+serverSocket.getLocalSocketAddress());

            socket = serverSocket.accept(); // blocking
            System.out.println("client connected");

            DataInputStream is = new DataInputStream(socket.getInputStream());
            DataOutputStream os = new DataOutputStream(socket.getOutputStream());

            Thread thrReceiver = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        try {
                            String msg=is.readUTF();
                            if("/end".equalsIgnoreCase(msg)){break;};
                            System.out.println();
                            System.out.println("Msg from client = : "+msg);
                            System.out.print("Enter text message for client: ");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                }
            });
            System.out.println("Server is waiting for incoming messages");
            thrReceiver.start();
            System.out.print("Enter text message for client: ");
            Scanner scanner = new Scanner(System.in);
            while (true){
                if (this.isMsgRcvd()) {
                    setMsgRcvd(false);
                    System.out.print("Enter text message for client: ");
                }
                String msg = scanner.nextLine(); // blocking method
                os.writeUTF(msg);  // sending messages
                System.out.print("Enter text message for client: ");
                if("/end".equalsIgnoreCase(msg)){break;};
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

    public static void main(String[] args) {
        Server s = new Server();
        s.start();
    }



}
