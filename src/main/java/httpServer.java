import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
public class httpServer {
  public static void main(String[] args) throws IOException {
    int port = 8080;
    HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
    System.out.println("Server started at " + port);
    server.createContext("/",  new RootHandler());
    server.createContext("/myHead",  new HeaderHandler());
    server.createContext("/myGet",  new HeaderHandler());
    server.createContext("/myPost",  new PostHandler());
    server.setExecutor(null);
    server.start();
  }
}