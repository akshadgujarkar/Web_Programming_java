import java.net.*;
import java.io.*;
class fileS{
	public static void main(String args[])
	{
		try
		{
			File f = new File("abc.txt");
			f.createNewFile();
			FileWriter fw = new FileWriter(f);
			fw.write("my name is akshad gujarkar and i studied in anjuman polytechnic collage and love to do coding and acquiring new technologies");
			fw.close();

			System.out.println("File updated");
			ServerSocket ss = new ServerSocket(5000);
			Socket server = ss.accept();
			System.out.println("Client connected");
			DataOutputStream dos = new DataOutputStream(server.getOutputStream());
			DataInputStream dis = new DataInputStream(server.getInputStream());
			String confirm = dis.readUTF();
			if(confirm.equalsIgnoreCase("yes"))
			{
				BufferedReader br = new BufferedReader( new FileReader(f));
				String data = br.readLine();
				dos.writeUTF(data);
				dos.flush();
				System.out.println("Data successfully send to client");

			}
			dis.close();
			server.close();


		}
		catch(IOException e)
		{
			System.out.println("File exception");
		}

	}
}