package client;

import messageControl.MessageRec;
import messageControl.MessageSend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * <h3>MessageMW</h3>
 * <h4> IntelliJ IDEA</h4>
 * <p></p>
 *
 * @author : ganlin
 * @date : 2020-05-14 11:14
 **/
public class UIClient implements Runnable{
  private JTextArea allMessage;
  private JPanel panelMain;
  private JTextArea sendMessage;
  private JButton sendButton;
  private JButton connectButton;
  private JButton disconnectButton;
  private JLabel copyright;
  private JToolBar toolBarMain;
  private JLabel labelStatus;
  private MessageRec receiver = null;
  private MessageSend sender = null;
  private boolean isConnection = false;
  private boolean isDisConnect = false;
  private String[] info = null;

  public UIClient() {
    Dimension dimension = this.disconnectButton.getSize();
    this.connectButton.setSize(dimension);
    this.setButtonEvent();
  }


  public static void main(String[] args) {
    JFrame frame = new JFrame("Message Box");
    UIClient clinet1 = new UIClient();

    new Thread(clinet1).start();
    frame.setContentPane(clinet1.panelMain);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setSize(500, 600);
    frame.setLocation(380, 50);
    frame.setVisible(true);
  }

  private void setButtonEvent() {
    connectButton.addMouseListener(new MouseListener() {
      @Override
      public void mouseClicked(MouseEvent mouseEvent) {
        System.out.println("connect");
        UIConnectInfo c1 = new UIConnectInfo();
        c1.pack();
        c1.setVisible(true);
        info = c1.getInfo();
        if (info != null) {
          activeMessageQueue();
          isConnection = true;
          isDisConnect = false;
          labelStatus.setText("connect:ON");
        } else
          System.err.println("null");
      }

      @Override
      public void mousePressed(MouseEvent mouseEvent) {

      }

      @Override
      public void mouseReleased(MouseEvent mouseEvent) {

      }

      @Override
      public void mouseEntered(MouseEvent mouseEvent) {

      }

      @Override
      public void mouseExited(MouseEvent mouseEvent) {

      }
    });
    disconnectButton.addMouseListener(new MouseListener() {
      @Override
      public void mouseClicked(MouseEvent mouseEvent) {
        sender.finishSend = true;
        receiver.finishRec = true;
        isConnection = false;
        isDisConnect = true;
        System.out.println("disconnect");
        labelStatus.setText("connect:OFF");
      }

      @Override
      public void mousePressed(MouseEvent mouseEvent) {

      }

      @Override
      public void mouseReleased(MouseEvent mouseEvent) {

      }

      @Override
      public void mouseEntered(MouseEvent mouseEvent) {

      }

      @Override
      public void mouseExited(MouseEvent mouseEvent) {

      }
    });
    sendButton.addMouseListener(new MouseListener() {
      @Override
      public void mouseClicked(MouseEvent mouseEvent) {
        String message = null;
        if (sender.finishSend){
          message = "Failed to send:" + info[1] + ": " + sendMessage.getText();
        } else {
          message = info[1] + ": " + sendMessage.getText();
        }

        sender.message = message;
        System.out.println(sender.message);
        sender.messageReady = !(sender.messageReady);
        sendMessage.setText("");
        allMessage.setText(allMessage.getText() + "Send: " + message + "\n");
      }

      @Override
      public void mousePressed(MouseEvent mouseEvent) {

      }

      @Override
      public void mouseReleased(MouseEvent mouseEvent) {

      }

      @Override
      public void mouseEntered(MouseEvent mouseEvent) {

      }

      @Override
      public void mouseExited(MouseEvent mouseEvent) {
      }
    });
  }

  private void activeMessageQueue() {
    this.sender = new MessageSend(info[3], info[0], info[1], info[2]);
    this.receiver = new MessageRec(info[4], info[0], info[1], info[2]);
    new Thread(sender, "sender").start();
    new Thread(this.receiver, "receiver").start();
  }

  @Override
  public void run() {
    System.out.println("receive listening...");
    int numberOfMessage = 0;
    int newNumberOfMessage = 0;

    if (receiver != null)
      numberOfMessage = receiver.getNumOfMessage();

    while (true) {
      if (isDisConnect){
        System.out.println("stop listening!");
        break;
      }
      boolean connectStatus = isConnection;
      System.out.println(connectStatus);
      if (connectStatus){
        numberOfMessage = receiver.getNumOfMessage();
        if (numberOfMessage != newNumberOfMessage){
          System.out.println(numberOfMessage);
          System.out.println(newNumberOfMessage);
          newNumberOfMessage = numberOfMessage;
          String newMessage = receiver.getNewMessage();
          allMessage.setText(allMessage.getText() + "Receive: " +newMessage + "\n");
        }
      }
    }
  }
}
