package messageControl;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * <h3>MessageMW</h3>
 * <h4> IntelliJ IDEA</h4>
 * <p>used to receive message</p>
 *
 * @author : ganlin
 * @date : 2020-05-12 11:23
 **/
public class MessageRec implements Runnable {
  private String url = null;
  private String user = null;
  private String passwd = null;
  private String newMessage = null;
  private int numOfMessage;
  private final String QUEUE;
  public boolean finishRec = false;

  public MessageRec(String queue, String url, String user, String passwd) {
    this.url = url;
    this.user = user;
    this.passwd = passwd;
    this.newMessage = "";
    this.numOfMessage = 0;
    this.QUEUE = queue;
  }

  @Override
  public void run() {
    ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
            user, passwd, url
    );
    Session session = null;
    Destination receiveQueue;

    try {
      Connection connection = connectionFactory.createConnection();
      session = connection.createSession(true, Session.SESSION_TRANSACTED);
      receiveQueue = session.createQueue(QUEUE);
      MessageConsumer consumer = session.createConsumer(receiveQueue);

      connection.start();

      while (true) {
        Message message = consumer.receive();

        if (message instanceof TextMessage) {
          TextMessage receiveMessage = (TextMessage) message;
          newMessage = receiveMessage.getText();
          System.out.println("receive:" + newMessage);
          numOfMessage++;
        } else {
          session.commit();
          break;
        }
        if (finishRec) {
          break;
        }
      }

      connection.close();
    } catch (JMSException e) {
      System.err.println("Receiver-Connection ERROR!!");
      e.printStackTrace();
    }
  }

  public String getNewMessage() {
    return this.newMessage;
  }

  public int getNumOfMessage() {
    return this.numOfMessage;
  }
}
