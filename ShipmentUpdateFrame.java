import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ShipmentUpdateFrame {
    public ShipmentUpdateFrame(int shipmentID, JTable table, int rowIndex) {
        JFrame frame = new JFrame("Update Shipment Date for ID: " + shipmentID);
        frame.setSize(400, 150);
        frame.setLayout(new GridLayout(2, 2, 10, 10));
        frame.setLocationRelativeTo(null);

        JLabel label = new JLabel("New Delivery Date (d\\M\\yyyy):");
        JTextField dateField = new JTextField();

        JButton updateBtn = new JButton("Update");
        updateBtn.addActionListener(e -> {
            String newDate = dateField.getText().trim();

            if (newDate.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please enter a delivery date.");
                return;
            }

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d\\M\\yyyy");
            try {
                LocalDate inputDate = LocalDate.parse(newDate, formatter);

                if (inputDate.isBefore(LocalDate.now())) {
                    JOptionPane.showMessageDialog(frame, "The delivery date cannot be in the past.");
                    return;
                }

                ShipmentManegment.Shipment targetShipment = ShipmentManegment.Shipment_search(shipmentID);

                if (targetShipment != null) {
                    targetShipment.deliveryDate = newDate;
                    table.setValueAt(newDate, rowIndex, 3);
                    JOptionPane.showMessageDialog(frame, "Date updated successfully.");
                    frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(frame, "Shipment not found.");
                }

            } catch (DateTimeParseException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid date format! Please use: d\\M\\yyyy");
            }
        });

        frame.add(label);
        frame.add(dateField);
        frame.add(new JLabel());
        frame.add(updateBtn);
        frame.setVisible(true);
    }
}
