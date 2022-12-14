import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
  
public class UdpMyClient
{
    public static void main(String args[]) throws IOException
    {
        Scanner scan = new Scanner(System.in);
  
        // Step 1:Create the socket object for
        // carrying the data.
        DatagramSocket datagramSocket = new DatagramSocket();
  
        InetAddress ip = InetAddress.getLocalHost();
        byte buf[] = null;
  
        // loop while user not enters "bye"
        while (true)
        {
            String inp = scan.nextLine();
  
            // convert the String input into the byte array.
            buf = inp.getBytes();
  
            // Step 2 : Create the datagramPacket for sending
            // the data.
            DatagramPacket DpSend =
                  new DatagramPacket(buf, buf.length, ip, 1234);
  
            // Step 3 : invoke the send call to actually send
            // the data.
            datagramSocket.send(DpSend);
  
            // break the loop if user enters "bye"
            if (inp.equals("bye"))
                break;
        }
    }
}