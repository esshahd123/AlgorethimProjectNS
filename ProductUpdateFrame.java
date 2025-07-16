import javax.swing.*;
import java.awt.*;

public class ProductUpdateFrame {
    public ProductUpdateFrame(int productId, JTable table, int rowIndex) {
        JFrame frame = new JFrame("Update Product ID: " + productId);
        frame.setSize(400, 200);
        frame.setLayout(new GridLayout(3, 2, 10, 10));
        frame.setLocationRelativeTo(null);

        JLabel fieldLabel = new JLabel("Field to Update:");
        String[] options = {"Price", "Quantity"};
        JComboBox<String> fieldCombo = new JComboBox<>(options);

        JLabel valueLabel = new JLabel("New Value:");
        JTextField valueField = new JTextField();

        JButton updateBtn = new JButton("Update");

        updateBtn.addActionListener(e -> {
            String selectedField = (String) fieldCombo.getSelectedItem();
            String newValueText = valueField.getText().trim();

            if (newValueText.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please enter a value.");
                return;
            }

            try {
                float newValue = Float.parseFloat(newValueText);

                char type = selectedField.equals("Price") ? 'p' : 'q';

                ProductManager manager = new ProductManager();
                manager.UpdateDetails(productId, newValue, type);

                if (type == 'p')
                    table.setValueAt(newValue, rowIndex, 2);
                else if (type == 'q')
                    table.setValueAt((int) newValue, rowIndex, 3);

                JOptionPane.showMessageDialog(frame, selectedField + " updated successfully.");
                frame.dispose();

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter a valid number.");
            }
        });

        frame.add(fieldLabel);
        frame.add(fieldCombo);
        frame.add(valueLabel);
        frame.add(valueField);
        frame.add(new JLabel());
        frame.add(updateBtn);

        frame.setVisible(true);
    }
}
