import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
public class ThreadExample{

	public static void main(String args[]){
		ThreadExample threadExample = new ThreadExample();
		System.out.println(threadExample.getAndSendMail1());
	}
	
	public String getAndSendMail(){
		String str = this.getString();
		
		Thread t = new Thread(new Runnable(){
			@Override
			public void run(){
			ThreadExample t = new ThreadExample();
			t.sendMail(str);
			}
		
		});
		
		t.start();
		return str;
	}
	
	public String getAndSendMail1(){
		String str = this.getString();
		Runnable runner = () ->{
				ThreadExample t = new ThreadExample();
				t.sendMail(str);
		};
		CompletableFuture<Void> future = CompletableFuture.runAsync(runner);
		return str;
	}
	
	
	public String getString(){
	 return "hi";
	
	}
	public void sendMail(String str){
		System.out.println("Sending mail ="+ str);
	
		try{
			Thread.sleep(1000);
			System.out.println("Sending mail complete");
		}catch(Exception ex){
		}	
	}

}