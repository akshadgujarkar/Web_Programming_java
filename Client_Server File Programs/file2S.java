import java.net.*;
import java.io.*;
class file2S
{
	public static void main(String args[])
	{
		try
		{
			File f = new File("xyz.txt");
            f.createNewFile();
            System.out.println("File Created");
			ServerSocket ss = new ServerSocket(4545);
			Socket server = ss.accept();
			System.out.println("Client Connected");
			DataOutputStream dos = new DataOutputStream( server.getOutputStream());
			DataInputStream dis = new DataInputStream(server.getInputStream());
			String confirm = dis.readUTF();
			if(confirm.equalsIgnoreCase("yes"))
			{

				FileWriter fw = new FileWriter(f);
				String data = dis.readUTF();
				fw.write(data);
				fw.close();
				System.out.println("Successfully written in file");
				dos.writeUTF("success");
			}

		}
		catch(IOException e)
		{
			System.out.println("file error");
		}
	}
}