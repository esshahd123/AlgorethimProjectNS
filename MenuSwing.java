import javax.swing.*;
import java.awt.*;
import java.util.Collections;
import java.util.Comparator;

public class MenuSwing {
    MenuSwing(){


        JFrame frame=new JFrame();
        frame.setSize(900, 800);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(new Color(0xF298A7B6));

        JPanel panel = new JPanel();
        panel.setBackground(new Color(0x1A2A5E));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setPreferredSize(new Dimension(300, 800));

        panel.add(Box.createVerticalGlue());
        JButton btn1 = new JButton("Show Products");
        JButton btn2 = new JButton("Show Shipments");
        JButton btn3 = new JButton("Show Orders");
        JButton btn4 = new JButton("start to add");



        Font btnFont = new Font("Arial", Font.BOLD, 16);
        for (JButton btn : new JButton[]{btn1, btn2, btn3,btn4}) {
            btn.setFont(btnFont);
            btn.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(Box.createVerticalStrut(40));
            panel.add(btn);
        }



        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 100, 0));
        centerPanel.setOpaque(false);
        centerPanel.add(panel);
        panel.add(Box.createVerticalStrut(300));


        btn1.addActionListener( e -> {

            JFrame productFrame = new JFrame("Products");
            productFrame.setSize(900, 800);

            String[] columnNames = {"ID", "Name", "Price", "Quantity"};

            Object[][] data = new Object[ProductManager.productManagers.size()][4];

            for (int i = 0; i < ProductManager.productManagers.size(); i++) {
                ProductManager.Product p = ProductManager.productManagers.get(i);
                data[i][0] = p.ID;
                data[i][1] = p.name;
                data[i][2] = p.price;
                data[i][3] = p.quantity;
            }

            JTable table = new JTable(data, columnNames);
            table.getTableHeader().setReorderingAllowed(false);
            productFrame.add(new JScrollPane(table));
            productFrame.setVisible(true);
        });


        btn2.addActionListener( e -> {

            JFrame ShipmentFrame = new JFrame("Shipment");
            ShipmentFrame.setSize(900, 800);

            String[] columnNames = {"ID", "Destination", "Cost", "DeliveryDate"};
            Object[][] data = new Object[ShipmentManegment.shipments.size()][4];
            Collections.sort(ShipmentManegment.shipments, Comparator.comparingInt(s -> s.shipmentID));
            for (int i = 0; i < ShipmentManegment.shipments.size(); i++) {
                ShipmentManegment.Shipment shipment = ShipmentManegment.shipments.get(i);
                data[i][0] = shipment.shipmentID;
                data[i][1] = shipment.destination;
                data[i][2] = shipment.cost;
                data[i][3] = shipment.deliveryDate;
            }

            JTable table = new JTable(data, columnNames);
            ShipmentFrame.add(new JScrollPane(table));
            table.getTableHeader().setReorderingAllowed(false);
            ShipmentFrame.setVisible(true);
        });

        btn3.addActionListener( e -> {

            JFrame OrderFrame = new JFrame("Order");
            OrderFrame.setSize(900, 800);

            String[] columnNames = {"ID", "Order Priority"};
            Object[][] data = new Object[PriorityOrder.orders.size()][4];

            Collections.sort(PriorityOrder.orders,  Comparator.comparingInt(s -> s.priority));
            for (int i = 0; i < PriorityOrder.orders.size(); i++) {
                PriorityOrder.Order order = PriorityOrder.orders.get(i);
                data[i][0] = order.orderID;
                data[i][1] = order.priority;

            }

            JTable table = new JTable(data, columnNames);
            table.getTableHeader().setReorderingAllowed(false);
            OrderFrame.add(new JScrollPane(table));
            OrderFrame.setVisible(true);
        });

        btn4.addActionListener(d->{
            new AddSwing();
        });




        frame.add(centerPanel, BorderLayout.CENTER);
        frame.setVisible(true);


    }
}
