import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class main {





    public static void main(String [] args)
    {
        ShipmentManegment shipmentManegment=new ShipmentManegment();
        PriorityOrder priorityOrder=new PriorityOrder();
        ProductManager productManager=new ProductManager();
//
//        shipmentManegment.addShipment(87,"aleppo",64,"23\\9\\2025");
//        shipmentManegment.printShipments();


        new  WelcomeSwing();
       // productManager.showProduct();
       // new AddSwing();
    }
}
