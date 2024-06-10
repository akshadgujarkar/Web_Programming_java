import java.io.*;
import java.net.*;
import java.util.*;
class file2C
{
	public static void main(String args[])
	{
		try
		{
			Socket client = new Socket("localhost",4545);
			System.out.println("Server Connected");
	        DataOutputStream dos = new DataOutputStream( client.getOutputStream());
	        DataInputStream dis = new DataInputStream(client.getInputStream());
	        Scanner s = new Scanner(System.in);
	        System.out.println("Want to store data in Server File Storage write yes");
	        String confirm = s.nextLine();
	        dos.writeUTF(confirm);
	        dos.flush();
	        System.out.println("Enter the data Want to Store in Server File Storage");
	        String data = s.nextLine();
			dos.writeUTF(data);
			if(dis.readUTF().equals("success"))
			{
          		System.out.println("Data Successfully received ");
			}
			client.close();
		}
		catch(IOException e)
		{
		  System.out.println("file error");
		}
	}

}