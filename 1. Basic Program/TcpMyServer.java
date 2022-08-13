import java.io.*;  
import java.net.*;  

public class TcpMyServer 
{  
    public static void main(String[] args)
    {  
        try
        {  
            ServerSocket socketServer=new ServerSocket(6666);  
            Socket socket=socketServer.accept();//establishes connection   
            DataInputStream dis=new DataInputStream(socket.getInputStream());  
            String  str=(String)dis.readUTF();  
            System.out.println("message= "+str);  
            socketServer.close();  
        }
        catch(Exception e){System.out.println(e);}  
    }  
} 

