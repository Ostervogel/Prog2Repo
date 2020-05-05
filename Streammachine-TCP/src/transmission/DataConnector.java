package transmission;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class DataConnector implements DataConnection, Runnable{

	/**
	 * Create client side - open connection to address / port
	 * 
	 * @param address
	 * @throws IOException
	 * @throws UnknownHostException
	 */

	public Socket socket;
	public ServerSocket serverSocket;

	public DataConnector(String address, int port) throws UnknownHostException, IOException {
		this.socket = new Socket(address, port);
		System.out.println("Connection established with " + address + " on port: " + port);
	}

	/**
	 * Create server side - open port on this port and wait for one client
	 * 
	 * @param port
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	public DataConnector(int port) throws IOException, InterruptedException {
		serverSocket = new ServerSocket(port);
		Thread thread = new Thread();
		thread.start();
		Thread.sleep(1);
		System.out.println("Connection established");
		
	}

	@Override
	public DataInputStream getDataInputStream() throws IOException {
		InputStream is = socket.getInputStream();
		DataInputStream dis = new DataInputStream(is);
		return dis;
	}

	@Override
	public DataOutputStream getDataOutputStream() throws IOException {
		OutputStream os = socket.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		return dos;
	}

	@Override
	public void run() {
		try {
			socket = serverSocket.accept();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
