import javax.swing.*;
import java.awt.*;

public class OrderUpdateFrame {
    public OrderUpdateFrame(int orderID, JTable table, int rowIndex) {
        JFrame frame = new JFrame("Update Order Priority - ID: " + orderID);
        frame.setSize(400, 150);
        frame.setLayout(new GridLayout(2, 2, 10, 10));
        frame.setLocationRelativeTo(null);

        JLabel label = new JLabel("New Priority (>= 1, unique):");
        JTextField priorityField = new JTextField();

        JButton updateBtn = new JButton("Update");
        updateBtn.addActionListener(e -> {
            try {
                int newPriority = Integer.parseInt(priorityField.getText().trim());

                if (newPriority < 1) {
                    JOptionPane.showMessageDialog(frame, "Priority must be greater than or equal to 1.");
                    return;
                }

                // تحقق أن الأولوية غير مستخدمة من قبل طلب آخر
                boolean alreadyExists = false;
                for (PriorityOrder.Order order : PriorityOrder.orders) {
                    if (order.orderID != orderID && order.priority == newPriority) {
                        alreadyExists = true;
                        break;
                    }
                }

                if (alreadyExists) {
                    JOptionPane.showMessageDialog(frame, "This priority is already used by another order.");
                    return;
                }

                // التحديث
                for (PriorityOrder.Order order : PriorityOrder.orders) {
                    if (order.orderID == orderID) {
                        order.priority = newPriority;
                        break;
                    }
                }

                table.setValueAt(newPriority, rowIndex, 1);
                JOptionPane.showMessageDialog(frame, "Priority updated successfully.");
                frame.dispose();

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Enter a valid number.");
            }
        });

        frame.add(label);
        frame.add(priorityField);
        frame.add(new JLabel());
        frame.add(updateBtn);

        frame.setVisible(true);
    }
}
