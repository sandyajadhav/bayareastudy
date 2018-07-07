import java.io.*;
import java.net.*;
public class HttpClient{
	public static void main(String args[]) throws Exception{
		
		Socket socket = new Socket("localhost",84);
		
		InputStream is = socket.getInputStream();
		OutputStream os = socket.getOutputStream();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(is));
		
		PrintWriter out = new PrintWriter(os,true);
		
		out.println("GET /v1.0/admin/campaigns/44859?access_token=31c788e8-2028-499d-ad70-f21a4fa804a1 HTTP/1.1");
		out.println();
		out.flush();
		
		String line ;
		
		while((line = in.readLine()) != null){
			System.out.println(line);
		}
		
		in.close();
		out.close();
		
	}
}