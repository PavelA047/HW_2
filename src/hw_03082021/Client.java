package hw_03082021;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    static Socket socket;
    private static final int PORT = 8189;
    private static final String IP_ADDRESS = "localhost";

    public static void main(String[] args) {
        try {
            socket = new Socket(IP_ADDRESS, PORT);
            System.out.println("Server connected");

            Scanner scannerIn = new Scanner(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner scannerOut = new Scanner(System.in);

            Thread inThread = new Thread(() -> {
                while (true) {
                    String msgIn = scannerIn.nextLine();
                    if (msgIn.equals("/end")) {
                        System.out.println("Server disconnected");
                        break;
                    } else {
                        System.out.println("Server: " + msgIn);
                    }

                }
            });
            inThread.setDaemon(true);
            inThread.start();

            while (true) {
                String msgOut = scannerOut.nextLine();
                if (msgOut.equals("/end")) {
                    System.out.println("You are disconnected");
                    out.println("/end");
                    break;
                } else {
                    out.println(msgOut);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
