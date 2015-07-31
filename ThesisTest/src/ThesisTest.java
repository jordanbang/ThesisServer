import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;


public class ThesisTest {
	
	
	
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", 8000);
			
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
			
			EventPacket packet = new EventPacket();
			out.writeObject(packet);
			
			EventPacket response = (EventPacket) in.readObject();
			System.out.println(response.response);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
