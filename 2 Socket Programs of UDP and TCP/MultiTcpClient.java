import java.io.*;
import java.net.*;
import java.util.*;

public class MultiTcpClient{
	public static void main(String[] args) throws Exception
	{
		Socket socket=new Socket("localhost",6666);
		DataOutputStream douts= new DataOutputStream(socket.getOutputStream());
		DataInputStream dins=new DataInputStream(socket.getInputStream());
		Scanner sc=new Scanner(System.in);
		while(true)
		{
			String strrecived=dins.readUTF();
			System.out.println("Server Messaged:"+strrecived);
			System.out.println("Write Your Message");
			String strtosend=sc.nextLine();
			douts.writeUTF(strtosend);
			douts.flush();
			if(strtosend.equals("Exit"))
			{
				System.out.println("Client "+socket+" is exiting");
				socket.close();
				dins.close();
				douts.close();
				break;
			}
		}
	}
}