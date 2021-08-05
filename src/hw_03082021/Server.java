package hw_03082021;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    static ServerSocket server;
    static Socket socket;
    private static final int PORT = 8189;

    public static void main(String[] args) {
        try {
            server = new ServerSocket(PORT);
            System.out.println("Server started");

            socket = server.accept();
            System.out.println("Client connected");

            Scanner scannerIn = new Scanner(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner scannerOut = new Scanner(System.in);

            Thread inThread = new Thread(() -> {
                while (!Thread.interrupted()) {
                    String msgIn = scannerIn.nextLine();
                    if (msgIn.equals("/end")) {
                        System.out.println("Client disconnected");
                        break;
                    }
                    if (Thread.interrupted()) {
                        break;
                    }
                    System.out.println("Client: " + msgIn);
                }
            });

            Thread outThread = new Thread(() -> {
                while (true) {
                    String msgOut = scannerOut.nextLine();
                    out.println(msgOut);
                    if (msgOut.equals("/end")) {
                        System.out.println("END");
                        inThread.interrupt();
                        break;
                    }
                }
            });
            inThread.start();
            outThread.start();
            try {
                inThread.join();
                outThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            scannerIn.close();
            scannerOut.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
