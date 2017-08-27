import java.awt.*;
 import java.util.*;
 import java.awt.event.*;
 import javax.swing.*;
 /*
  * 验证文本框输入数据是否合法
 	以下示例有两个文本字段，其中第一个字段期望用户输入字符串 "pass"。
 	如果在第一个文本字段中输入该字符串，那么用户可以通过在第二个文本
 	字段上单击或按下 TAB 前进到第二个文本字段。不过，如果将其他字符串
 	输入到第一个文本字段中，则用户无法将焦点转移到第二个文本字段。
 */
 // This program demonstrates the use of the Swing InputVerifier class.
 // It creates two text fields; the first of the text fields expects the
 // string "pass" as input, and will allow focus to advance out of it
 // only after that string is typed in by the user.

 public class VerifierTest extends JFrame {
     public VerifierTest() {
         JTextField tf1 = new JTextField ("Type \"pass\" here");
           getContentPane().add (tf1, BorderLayout.NORTH);
           tf1.setInputVerifier(new PassVerifier());
 
           JTextField tf2 = new JTextField ("TextField2");
           getContentPane().add (tf2, BorderLayout.SOUTH);
 
           WindowListener l = new WindowAdapter() {
               public void windowClosing(WindowEvent e) { 
                   System.exit(0); 
               }
           };
           addWindowListener(l);
     }
 
     class PassVerifier extends InputVerifier {
         public boolean verify(JComponent input) {
               JTextField tf = (JTextField) input;
               return "pass".equals(tf.getText());
         }
     }
 
     public static void main(String[] args) {
         Frame f = new VerifierTest();
           f.pack();
           f.setVisible(true);
     }
 }
