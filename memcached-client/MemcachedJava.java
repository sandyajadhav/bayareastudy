import net.spy.memcached.MemcachedClient;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Created by sandeepjadhav on 7/7/18.
 */
public class MemcachedJava {
    public static void main(String[] args) throws IOException {

        // Connecting to Memcached server on localhost
        //MemcachedClient mcc = new MemcachedClient(new InetSocketAddress("my-first-memcached1.ca2pee.0001.usw2.cache.amazonaws.com", 11211));

        MemcachedClient mcc = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11111));

        System.out.println("Connection to server sucessfully");

        //not set data into memcached server
        System.out.println("set status:"+mcc.set("tutorialspoint", 900, "memcached").getStatus().isSuccess());

        //Get value from cache
        System.out.println("Get from Cache:"+mcc.get("tutorialspoint"));
    }
}
