
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class main {
   static Scanner scan = new Scanner(System.in);

    public static void printMainMenu(){
        System.out.print("\u001b[37m");
        System.out.println("\t______________________________________________________________________________");
        System.out.println("\t||______________________________"+"\u001b[33m"+"THE MAIN MENU"+"\u001b[37m"+"_______________________________||");
        System.out.println("\t||__________________________________________________________________________||");
        System.out.println("\t||\tpress [1] to add a product                                              ||");
        System.out.println("\t||\tpress [2] to add an order                                               || ");
        System.out.println("\t||\tpress [3] to add shipment                                               || ");
        System.out.println("\t||\tpress [4] to search about a product                                     ||");
        System.out.println("\t||\tpress [5] to update the  price or the quantity of product               || ");
        System.out.println("\t||\tpress [6] to delete a product                                           || ");
        System.out.println("\t||\tpress [7] to search about a shipment                                    ||");
        System.out.println("\t||\tpress [8] to update the deliveryDate                                    ||");
        System.out.println("\t||\tpress [9] to find the order with the height priority                    ||");
        System.out.println("\t||\tpress [10] to update the priority of the order                          || ");
        System.out.println("\t||\tpress [11] to print products                                            || ");
        System.out.println("\t||\tpress [12] to print orders                                              || ");
        System.out.println("\t||\tpress [13] to print shipments                                           || ");
        System.out.println("\t||\tpress [14] to show reports                                              || ");
        System.out.println("\t||\tpress [0] to exit                                                       ||");
        System.out.println("\t||__________________________________________________________________________||");
        System.out.println("\t||__________________________________________________________________________||");
    }


    static void addProduct(){
        ProductManager productManager=new ProductManager();
        System.out.println("enter the id please ");
        int id =scan.nextInt();
        System.out.println("enter the name please ");
        String name=scan.next();
        System.out.println("enter the price please ");
        float price= scan.nextFloat();
        System.out.println("enter the quantity please ");
        int quantity= scan.nextInt();
        ProductManager.productManagers.add(productManager.addAProduct(id,name,price,quantity));
    }

    static void addOrder(){
        PriorityOrder priorityOrder=new PriorityOrder();
        System.out.println("enter the id please ");
        int id =scan.nextInt();
        System.out.println("enter the priority please ");
        int priority =scan.nextInt();
        System.out.println("enter the number of product please ");
        int number =scan.nextInt();
        PriorityOrder.orders.add(priorityOrder.addOrder(id,priority,number));
    }

    static void addShipment(){
        ShipmentManegment shipmentManegment=new ShipmentManegment();
        System.out.println("enter the id please ");
        int id =scan.nextInt();
        System.out.println("enter the destination please ");
        String destination =scan.next();
        System.out.println("enter the cost please ");
        float cost =scan.nextFloat();
        System.out.println("enter the date like day\\month\\year please ");
        String date =scan.next();
        ShipmentManegment.shipments.add(shipmentManegment.addShipment(id,destination,cost,date));

    }

    static void update(){
        ShipmentManegment.PriorityOrder.ProductManager s=new ShipmentManegment.PriorityOrder.ProductManager();
        System.out.println("enter the id please ");
        int id =scan.nextInt();
        System.out.println("enter the priority please ");
        int newUpdate =scan.nextInt();
        System.out.println("enter the number of product please ");
        char type =scan.next().charAt(0);
        s.UpdateDetails(id,newUpdate,type);
    }

    static void deleteProduct(){
        ProductManager productManager=new ProductManager();
        System.out.println("enter the id of the product you want to delete :");
        int id=scan.nextInt();
        ProductManager.productManagers.remove(productManager.delateProduct(id));
        System.out.println("the product has deleted ");
    }

    static void searchShipment(){
        ShipmentManegment shipmentManegment=new ShipmentManegment();
        System.out.println("enter the id of the shipment you want to find :");
        int id=scan.nextInt();
        shipmentManegment.Shipment_search(id);
    }




    static void searchProduct(){
        PriorityOrder.ProductManager priorityOrder=new PriorityOrder.ProductManager();
        System.out.println("enter the id of the product you want to find :");
        int id= scan.nextInt();
        priorityOrder.searchProduct(id);


    }

    static void updatedeliveryDate(){
        ShipmentManegment shipmentManegment=new ShipmentManegment();
        System.out.println("enter the id of the shipment please ");
        int id =scan.nextInt();
        System.out.println("enter the new date like day\\month\\year please ");
        String date =scan.next();
        shipmentManegment.updateShipmentDate(id,date);

    }
    static void heightPriority(){
        PriorityOrder priorityOrder=new PriorityOrder();
        priorityOrder.mostPriority();


    }
    static void updaetPriority(){
        PriorityOrder priorityOrder=new PriorityOrder();
        System.out.println("enter the id of the order please ");
        int id =scan.nextInt();
        System.out.println("enter the new priority please ");
        int priority =scan.nextInt();
        priorityOrder.updatePriority(id,priority);
    }

    static void printProduct(){
        PriorityOrder .ProductManager productManager=new PriorityOrder.ProductManager();
        System.out.println("__________the products______________ ");
        productManager.showProduct();
    }

    static void printOrder(){
        PriorityOrder priorityOrder=new PriorityOrder();
        System.out.println("__________the orders______________ ");
        priorityOrder.print();
    }

    static void printShipment(){
        ShipmentManegment shipmentManegment=new ShipmentManegment();
        System.out.println("__________the shipments______________ ");
        shipmentManegment.printShipments();

    }

    static void reports(){
        System.out.print("\u001b[37m");
        System.out.println("\t________________________________________");
        System.out.println("\t||_________"+"\u001b[33m"+" MANAGEMENT REPORT"+"\u001b[37m"+"_________||");
        System.out.println("\t||\t[1] to show the height shipment cost        ||");
        System.out.println("\t||\t[2] to show the capacity container          ||");
        System.out.println("\t||\t[3] to show the total cost of orders        ||");
        System.out.println("\t||______________________________________________||");
        int number = scan.nextInt();
        switch (number){
            case 1:
                ShipmentManegment.printHighCostShipments(0);
                break;
            case 2:
                System.out.println("the capacity container is :"+ProductManager.containerCapacity);
                break;
            case 3:
                PriorityOrder.totalCostOfOrders();
                break;
            default:
                System.out.println("\u001b[32m"+"\tsorry...your choose is not found "+"\u001b[37m");        }
    }


    public static void startProgram(){

        do{
            printMainMenu();
            System.out.print("\tplease enter number the choose : ");
            int num = scan.nextInt();
            switch (num) {
                case 1:
                    addProduct();
                    break;
                case 2:
                  addOrder();
                    break;
                case 3:
                  addShipment();
                    break;
                case 4:
                  searchProduct();
                    break;
                case 5:
                    update();
                    break;
                case 6:
                   deleteProduct();
                    break;
                case 7:
                 searchShipment();
                    break;
                case 8:
                   updatedeliveryDate();
                    break;
                case 9:
                  heightPriority();
                    break;
                case 10:
                    updaetPriority();
                    break;
                case 11:
                  printProduct();
                    break;
                case 12:
                    printOrder();
                    break;
                case 13:
                    printShipment();
                    break;
                case 14 :
                    reports();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("\u001b[32m"+"\tyour choose is not found "+"\u001b[37m");
            }
        }while(true);
    }

    public static void main(String [] args)
    {
       startProgram();
    }
}
