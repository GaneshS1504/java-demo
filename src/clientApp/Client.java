package clientApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
	

	Socket socket;
	BufferedReader br;
	PrintWriter out;

	public Client() {

		try {
			System.out.println("client started");
			socket = new Socket("127.0.0.1", 7777);
			System.out.println("connection made");

			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream());
			
			startReading();
			startWriting();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void startWriting() {

		Runnable r2 = () -> {
			System.out.println("writing started");
			while (true) {
				try {
					BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
					String content = br1.readLine();
					out.println(content);
					out.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		};

		new Thread(r2).start();
	}

	private void startReading() {

		Runnable r1 = () -> {
			System.out.println("Reading started");
			while (true) {
				try {
					String msg = br.readLine();
					if (msg.equals("exit")) {
						System.out.println("server msg terminated");
						break;
					}
					System.out.println("server:" + msg);
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		};

		new Thread(r1).start();
	}

	public static void main(String[] args) {
		System.out.println("this is client");
		new Client();
	}

}
