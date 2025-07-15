import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeSwing {

    public WelcomeSwing(){
        JFrame frame = new JFrame();
        frame.setBounds(0,0,900, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(0xF298A7B6));
        frame.setLayout(null);


        ImageIcon icon = new ImageIcon("C:\\Users\\User\\Downloads\\checkout (1).png");
        frame.setIconImage(icon.getImage());
        JLabel iconPanel=new JLabel(icon);
        iconPanel.setBounds(800,700,50,50);
        frame.add(iconPanel);



        JPanel panel1=new JPanel();
        panel1.setBounds(0,0,250,800);
        panel1.setBackground(new Color(0x1A2A5E));
        panel1.setLayout(null);
        frame.add(panel1);

        JPanel mainPanel = new JPanel(null);
        mainPanel.setBounds(250, 0, 650, 800);
        mainPanel.setOpaque(false);
        frame.add(mainPanel);


        JTextField textField = new JTextField("welcome");
        textField.setBounds(230, 300, 300, 70);
        textField.setForeground(Color.BLACK);
        textField.setFont(new Font("Times New Roman", Font.BOLD, 60));
        textField.setOpaque(false);
        textField.setBorder(null);
        mainPanel.add(textField);

        textField.setCaretPosition(0);
        textField.select(0, 0);



        JTextArea textArea = new JTextArea("YOUR ORDER IN \nSAFE HANDS");
        textArea.setBounds(50, 50, 550, 150);
        textArea.setFont(new Font("Serif", Font.BOLD, 40));
        textArea.setForeground(Color.black);
        textArea.setEditable(false);
        textArea.setOpaque(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        mainPanel.add(textArea);

        JButton button = new JButton("start");
        button.setBounds(515, 395, 150, 40);
        button.setFont(new Font("Times New Roman", Font.BOLD, 18));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(0x1A2A5E));
        button.addActionListener(e->{
            frame.dispose();
            new MenuSwing();
        });
        // ////
        frame.add(button);
        frame.setVisible(true);

    }
}





