package CEApplication;
import java.net.*;
import java.io.*;

public class CEApplication implements Runnable
{
	DatagramSocket socket;
	private CEWorld world;
	public CEApplication(int port){
		try
		{
			socket = new DatagramSocket(port);
			new Thread(this).start();
		}
		catch (IOException e)
		{
			System.err.println(e);
		}
	}
	@Override
	public void run()
	{
		while(true){
			byte[] buffer = new byte[1024];
			DatagramPacket packet=new DatagramPacket(buffer,buffer.length);
			try
			{
				socket.receive(packet);
			}
			catch (IOException e)
			{
				System.err.println(e);
			}
			
		}
	}
}
