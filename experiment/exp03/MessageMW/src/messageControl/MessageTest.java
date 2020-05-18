package messageControl;

/**
 * <h3>MessageMW</h3>
 * <h4> IntelliJ IDEA</h4>
 * <p>used to test message middleware</p>
 *
 * @author : ganlin
 * @date : 2020-05-13 11:24
 **/
public class MessageTest {
  public static void main(String[] rgs) {
    String url = "tcp://localhost:61616";
    String user = null;
    String password = null;
    String query = "MyQueue";

    new Thread(new MessageSend(query,url,user,password), "Name-Sender").start();
    new Thread(new MessageRec(query,url,user,password), "Name-Receiver").start();
  }
}
