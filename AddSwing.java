import javax.swing.*;
import java.awt.*;

public class AddSwing {
    AddSwing(){
        JFrame newFrame = new JFrame("New Frame");
        newFrame.setSize(900, 800);
        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newFrame.setLayout(new BorderLayout());

        JPanel panel2 = new JPanel();
        panel2.setBackground(new Color(0x1A2A5E));
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        panel2.setPreferredSize(new Dimension(300, 800));

        panel2.add(Box.createVerticalStrut(200));

        Dimension fieldSize = new Dimension(250, 40);
        Font labelFont = new Font("Arial", Font.BOLD, 16);
        Color labelColor = Color.WHITE;


        JButton titleButton = new JButton("PRODUCT");
        titleButton.setFont(new Font("Arial", Font.BOLD, 20));
        titleButton.setForeground(Color.WHITE);
        titleButton.setBackground(new Color(0x394867));
        titleButton.setFocusPainted(false);
        titleButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel2.add(titleButton);
        panel2.add(Box.createVerticalStrut(40));

       // ProductManager .Product product=new ProductManager.Product();
        JLabel label1 = new JLabel("ID:");
        label1.setFont(labelFont);
        label1.setForeground(labelColor);
        label1.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField textField1 = new JTextField();
        textField1.setMaximumSize(fieldSize);
        textField1.setAlignmentX(Component.CENTER_ALIGNMENT);
        textField1.setEnabled(false);




        panel2.add(label1);
        panel2.add(textField1);
        panel2.add(Box.createRigidArea(new Dimension(0, 20)));

        JLabel label2 = new JLabel("NAME:");
        label2.setFont(labelFont);
        label2.setForeground(labelColor);
        label2.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField textField2 = new JTextField();
        textField2.setMaximumSize(fieldSize);
        textField2.setAlignmentX(Component.CENTER_ALIGNMENT);
        textField2.setEnabled(false);
       // String name=textField2.getText();

        panel2.add(label2);
        panel2.add(textField2);
        panel2.add(Box.createRigidArea(new Dimension(0, 20)));

        JLabel label3 = new JLabel("PRICE:");
        label3.setFont(labelFont);
        label3.setForeground(labelColor);
        label3.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField textField3 = new JTextField();
        textField3.setMaximumSize(fieldSize);
        textField3.setAlignmentX(Component.CENTER_ALIGNMENT);
        textField3.setEnabled(false);
        // float price=Float.parseFloat(textField3.getText());

        panel2.add(label3);
        panel2.add(textField3);
        panel2.add(Box.createRigidArea(new Dimension(0, 20)));


        JLabel label4 = new JLabel("QUANTITY:");
        label4.setFont(labelFont);
        label4.setForeground(labelColor);
        label4.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField textField4 = new JTextField();
        textField4.setMaximumSize(fieldSize);
        textField4.setAlignmentX(Component.CENTER_ALIGNMENT);
        textField4.setEnabled(false);
       // int quantity =Integer.parseInt(textField4.getText());

        panel2.add(label4);
        panel2.add(textField4);
        panel2.add(Box.createRigidArea(new Dimension(0, 20)));


        JButton save=new JButton("SAVE");
        save.setAlignmentX(Component.CENTER_ALIGNMENT);
        save.setFont(new Font("Arial", Font.BOLD, 20));
        save.addActionListener(d->{
            int id=Integer.parseInt(textField1.getText());
            String name=textField2.getText();
            float price=Float.parseFloat(textField3.getText());
            int quantity=Integer.parseInt(textField4.getText());
            ProductManager manager = new ProductManager();
            manager.addAProduct(id, name, price, quantity);


        });
        panel2.add(save);

// ///////////////////////////////////////////////////////////////////////////////////////////////////
        JPanel panel3 = new JPanel();
        panel3.setBackground(new Color(0xF298A7B6, true));  // لون خلفية مختلف
        panel3.setLayout(new BoxLayout(panel3,BoxLayout.Y_AXIS));
        panel3.setPreferredSize(new Dimension(300, 800));

        panel3.add(Box.createVerticalStrut(200));

        Dimension fieldSize2 = new Dimension(250, 40);
        Font labelFont2 = new Font("Arial", Font.BOLD, 16);
        Color labelColor2 = Color.WHITE;

        JButton titleButton2 = new JButton("ORDER");
        titleButton2.setFont(new Font("Arial", Font.BOLD, 20));
        titleButton2.setForeground(Color.WHITE);
        titleButton2.setBackground(new Color(0x394867));
        titleButton2.setFocusPainted(false);
        titleButton2.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel3.add(titleButton2);
        panel3.add(Box.createVerticalStrut(60));

        JLabel label12 = new JLabel("ID:");
        label12.setFont(labelFont2);
        label12.setForeground(labelColor2);
        label12.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField textField11 = new JTextField();
        textField11.setMaximumSize(fieldSize2);
        textField11.setAlignmentX(Component.CENTER_ALIGNMENT);
        textField11.setEnabled(false);

        panel3.add(label12);
        panel3.add(textField11);
        panel3.add(Box.createRigidArea(new Dimension(0, 20)));

        JLabel label8 = new JLabel("PRIORITY:");
        label8.setFont(labelFont2);
        label8.setForeground(labelColor2);
        label8.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField textField12 = new JTextField();
        textField12.setMaximumSize(fieldSize2);
        textField12.setAlignmentX(Component.CENTER_ALIGNMENT);
        textField12.setEnabled(false);

        panel3.add(label8);
        panel3.add(textField12);

        JButton save1=new JButton("SAVE");
        save1.setAlignmentX(Component.CENTER_ALIGNMENT);
        save1.setFont(new Font("Arial", Font.BOLD, 20));
        save1.addActionListener(d->{
            int idOrder=Integer.parseInt(textField11.getText());
            int priority=Integer.parseInt(textField12.getText());
            PriorityOrder order=new PriorityOrder();
            order.addOrder(idOrder,priority);
                });
        panel3.add(save1);


// //////////////////////////////////////////////////////////////////////////////////////////////////
        JPanel panel4 = new JPanel();
        panel4.setBackground(new Color(0xFF1A2A5E, true));  // لون خلفية مختلف
        panel4.setLayout(new BoxLayout(panel4, BoxLayout.Y_AXIS));
        panel4.setPreferredSize(new Dimension(300, 800));


        panel4.add(Box.createVerticalStrut(200));

        Dimension fieldSizee = new Dimension(250, 40);
        Font labelFontt = new Font("Arial", Font.BOLD, 16);
        Color labelColorr = Color.WHITE;

        JButton titleButtonn = new JButton("SHIPMENT");
        titleButtonn.setFont(new Font("Arial", Font.BOLD, 20));
        titleButtonn.setForeground(Color.WHITE);
        titleButtonn.setBackground(new Color(0x394867));
        titleButtonn.setFocusPainted(false);
        titleButtonn.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel4.add(titleButtonn);
        panel4.add(Box.createVerticalStrut(40));

        JLabel label6 = new JLabel("ID:");
        label6.setFont(labelFontt);
        label6.setForeground(labelColorr);
        label6.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField textField7 = new JTextField();
        textField7.setMaximumSize(fieldSizee);
        textField7.setAlignmentX(Component.CENTER_ALIGNMENT);
        textField7.setEnabled(false);

        panel4.add(label6);
        panel4.add(textField7);
        panel4.add(Box.createRigidArea(new Dimension(0, 20)));

        JLabel labell = new JLabel("DESTINATION:");
        labell.setFont(labelFontt);
        labell.setForeground(labelColorr);
        labell.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField textField8 = new JTextField();
        textField8.setMaximumSize(fieldSizee);
        textField8.setAlignmentX(Component.CENTER_ALIGNMENT);
        textField8.setEnabled(false);

        panel4.add(labell);
        panel4.add(textField8);
        panel4.add(Box.createRigidArea(new Dimension(0, 20)));

        JLabel label7 = new JLabel("PRICE:");
        label7.setFont(labelFontt);
        label7.setForeground(labelColorr);
        label7.setAlignmentX(Component.CENTER_ALIGNMENT);
        JTextField textField9 = new JTextField();
        textField9.setMaximumSize(fieldSizee);
        textField9.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel4.add(label7);
        panel4.add(textField9);
        panel4.add(Box.createRigidArea(new Dimension(0, 20)));

        JLabel labelo = new JLabel("DELIVERY DATE:");
        labelo.setFont(labelFontt);
        labelo.setForeground(labelColorr);
        labelo.setAlignmentX(Component.CENTER_ALIGNMENT);
        JTextField textField10 = new JTextField();
        textField10.setMaximumSize(fieldSizee);
        textField10.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel4.add(labelo);
        panel4.add(textField10);
        JButton save2 =new JButton("SAVE");
        save2.setAlignmentX(Component.CENTER_ALIGNMENT);
        save2.setFont(new Font("Arial", Font.BOLD, 20));
        save2.addActionListener(e->{
            int idShip=Integer.parseInt(textField7.getText());
            String dest=textField8.getText();
            int cost=Integer.parseInt(textField9.getText());
            String date=textField10.getText();
            ShipmentManegment shipment=new ShipmentManegment();
            shipment.addShipment(idShip,dest,cost,date);
        });
        panel4.add(save2);


        titleButton.addActionListener(d -> {
            titleButtonn.setEnabled(false);
            textField1.setEnabled(true);
            textField2.setEnabled(true);
            textField3.setEnabled(true);
            textField4.setEnabled(true);
            titleButton.setText("ENTER THE INFO");
            titleButton.setEnabled(false);
            titleButton2.setEnabled(false);
        });

        titleButtonn.addActionListener(d -> {
            titleButton.setEnabled(false);
            textField7.setEnabled(true);
            textField8.setEnabled(true);
            textField9.setEnabled(true);
            textField10.setEnabled(true);
            titleButtonn.setText("ENTER THE INFO");
            titleButtonn.setEnabled(false);
            titleButton2.setEnabled(false);
        });
        titleButton2.addActionListener(d->{
            titleButtonn.setEnabled(false);
            titleButton.setEnabled(false);
            textField11.setEnabled(true);
            textField12.setEnabled(true);
            titleButton2.setText("ENTER THE INFO");
            titleButton2.setEnabled(false);
        });

        newFrame.add(panel2, BorderLayout.WEST);
        newFrame.add(panel3, BorderLayout.CENTER);
        newFrame.add(panel4, BorderLayout.EAST);
        newFrame.setVisible(true);


    }


}

