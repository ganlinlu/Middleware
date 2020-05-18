package client;

import javax.swing.*;
import java.awt.event.*;

public class UIConnectInfo extends JDialog {
  private JPanel contentPane;
  private JButton buttonOK;
  private JButton buttonCancel;
  private JPanel panel1;
  private JPanel panel2;
  private JTextField textFieldURL;
  private JTextField textFieldUser;
  private JTextField textFieldPW;
  private JTextField textFieldSQ;
  private JTextField textFieldRQ;
  private JLabel labelURL;
  private JLabel labelUser;
  private JLabel labelPW;
  private JLabel sendQuery;
  private JLabel receiveQuery;
  private String[] info = null;

  public UIConnectInfo() {
    setContentPane(contentPane);
    setTitle("set connection info");
    setSize(100, 90);
    setLocation(390, 150);
    setModal(true);
    getRootPane().setDefaultButton(buttonOK);

    buttonOK.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        onOK();
      }
    });

    buttonCancel.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        onCancel();
      }
    });

    // call onCancel() when cross is clicked
    setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        onCancel();
      }
    });

    // call onCancel() on ESCAPE
    contentPane.registerKeyboardAction(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        onCancel();
      }
    }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
  }

  private void onOK() {
    String url = this.textFieldURL.getText();
    String user = this.textFieldUser.getText();
    String passwd = this.textFieldPW.getText();
    String sendQuery = this.textFieldSQ.getText();
    String recQuery = this.textFieldRQ.getText();

    this.info = new String[]{url, user, passwd, sendQuery, recQuery};

    dispose();
  }

  private void onCancel() {
    this.textFieldURL.setText("");
    this.textFieldUser.setText("");
    this.textFieldPW.setText("");
    this.textFieldSQ.setText("");
    this.textFieldRQ.setText("");
    dispose();
  }

  public String[] getInfo() {
    return this.info;
  }

  public static void main(String[] args) {
    UIConnectInfo dialog = new UIConnectInfo();
    dialog.pack();
    dialog.setVisible(true);
    System.exit(0);
  }
}
