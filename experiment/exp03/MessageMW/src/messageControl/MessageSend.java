package messageControl;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.Date;

/**
 * <h3>MessageMW</h3>
 * <h4> IntelliJ IDEA</h4>
 * <p>used to send message</p>
 *
 * @author : ganlin
 * @date : 2020-05-12 11:24
 **/
public class MessageSend implements Runnable {
  private String url = null;
  private String user = null;
  private String passwd = null;
  public boolean messageReady = false;
  public String message = null;
  public boolean finishSend = false;
  private final String QUEUE;


  public MessageSend(String queue, String url, String user, String password) {
    this.url = url;
    this.user = user;
    this.passwd = password;
    this.QUEUE = queue;
  }

  @Override
  public void run() {
    ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
            user, passwd, url
    );
    Session session = null;
    Destination sendQueue;
    Connection connection = null;

    int messageCount = 0;
    try {
      connection = connectionFactory.createConnection();
      connection.start();

      while (true) {
        session = connection.createSession(true, Session.SESSION_TRANSACTED);

        sendQueue = session.createQueue(QUEUE);
        MessageProducer sender = session.createProducer(sendQueue);
        TextMessage outMessage = session.createTextMessage();

        if (messageReady) {
//          System.out.println("message:" + message);
          outMessage.setText(this.message);
          
          sender.send(outMessage);
          session.commit();
          sender.close();

          messageReady = !messageReady;
        }

        if(finishSend)
          break;
      }
      connection.close();
    } catch (JMSException e) {
      e.printStackTrace();
    }
  }

  void prepareMessage(String message) {
    this.message = message;
    this.messageReady = !(this.messageReady);

    return;
  }

}
