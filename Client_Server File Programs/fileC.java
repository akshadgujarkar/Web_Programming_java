import java.net.*;
import java.io.*;
import java.util.*;
class fileC
{
	public static void main(String args[])
	{
		try
		{
			Socket ss = new Socket("localhost",5000);
			System.out.println("Server Connected");
			DataOutputStream dos = new DataOutputStream(ss.getOutputStream());
			DataInputStream dis = new DataInputStream(ss.getInputStream());
			Scanner sc = new Scanner(System.in);
			System.out.println("Get the data from file store in the server write yes");
			String data = sc.nextLine();
			dos.writeUTF(data);
			dos.flush();
			String fileData = dis.readUTF();
			System.out.println("Data From server File : "+fileData);


		}
		catch(IOException e)
		{
			System.out.println("File exception");
		}

	}
}