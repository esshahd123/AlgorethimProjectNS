import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class main {

    public static void main(String [] args)
    {
        Scanner in=new Scanner(System.in);
        PriorityOrder o=new PriorityOrder();
        System.out.println("enter id,priority and number of products: ");
        o.addOrder(in.nextInt(),in.nextInt(),in.nextInt());
        o.print();
        System.out.println("enter id,priority and number of products: ");

        o.addOrder(in.nextInt(),in.nextInt(),in.nextInt());
        System.out.println("total cost of order: "+o.totalCostOfOrders());
//
//
    }
}
