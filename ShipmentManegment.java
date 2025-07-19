
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class ShipmentManegment {

    private Shipment newNodeCreated = null;
    static ArrayList<Shipment> shipments = new ArrayList<>();
    static boolean write=true;
    public ShipmentManegment() {
        if(write) {
            addShipment(1111, "damas", 2300, "2\\9\\2025");
            addShipment(1114, "Aleppo", 1250, "2\\10\\2025");
            addShipment(1112, "Hama", 3000, "3\\8\\2025");
        }
        write=false;
    }

    public class PriorityOrder {


        static ArrayList <Order>orders= new ArrayList<Order>();
        Order order=null;
        boolean write=true;
        //ProductManager pm=null;


        PriorityOrder(){

        }
        static public class ProductManager {

            static ArrayList<Product> productManagers=new ArrayList<>();
            static Product product;
            static int containerCapacity;
            static boolean write=true;
            ProductManager(){
//            if(write) {
//                addAProduct(9, "milk", 76, 33);
//                addAProduct(8, "orange", 55, 44);
//                addAProduct(7, "chair", 788, 36);
//                addAProduct(10, "bread", 33, 27);
//                addAProduct(11, "table", 900, 75);
//            }
//            write=false;
            }

            public static class Product {
                int ID;
                String name;
                float price;
                int quantity;
                int hight;
                Product left;
                Product right;
                Product(){}

                public Product(int ID, String name, float price, int quantity) {
                    this.ID = ID;
                    this.name = name;
                    this.price = price;
                    this.quantity = quantity;
                    left = null;
                    right = null;
                }
            }
            public void addAProduct(int id,String name,float price, int quantity)
            {
                Product p=innerSearching(product,id);

                if(p!=null && p.ID==id)
                {
                    System.out.println("THIS PRODUCT IS ALREADY EXIST !!!!!");
                    return;
                }
                int bell =containerCapacity+quantity;

                if (price<=0 || price >10000) {
                    System.out.println("Invalid price! Please make it between 0 and 1000000.");
                    return;
                }
                if (quantity< 0|| quantity >1000 || (bell> 1000)) {
                    System.out.println("Invalid quantity! Exceeds warehouse capacity.");
                    return;
                }

                containerCapacity=bell;
                product = innerAddingProduct(product,id, name,price, quantity);
                productManagers.add(new Product(id, name,price, quantity));
                return;
            }

            private Product innerAddingProduct(Product p, int ID, String name, float price, int quantity)
            {
                if (p == null) {
                    return new Product(ID,name,price,quantity);
                }

                if (ID <p.ID) {
                    p.left =innerAddingProduct(p.left, ID,name, price,quantity);
                } else if (ID >p.ID) {
                    p.right =innerAddingProduct(p.right,ID, name,price,quantity);
                }
                return p;
            }

            public void balanceAdding(int id,String name,float price, int quantity)
            {
                Product p=new Product();
                p=innerSearching(product,id);
                if (p!=null && p.ID==id)
                {


                    System.out.println("THIS PRODUCT IS ALREADY EXIST !!!!!");

                    return;
                }
                int bell=containerCapacity+quantity;
                if (bell>1000 ||price< 0) {
                    System.out.println("Over full container or invalid price!");
                    return;
                }

                containerCapacity=bell;
                product = innerBalanceAdding(product, id,name,price,quantity);

                productManagers.add(new Product(id,name,price,quantity));
                return;
            }

            private int getHight(Product p) {
                if (p == null) return 0;
                return p.hight;
            }

            private int getBalance(Product p) {
                if (p == null) return 0;
                return getHight(p.left) - getHight(p.right);
            }

            private Product leftRotation(Product p)
            {
                Product newRoot=p.right;
                Product newRootChildren=newRoot.left;
                newRoot.left=p;
                p.right=newRootChildren;
                p.hight=1+Math.max(getHight(p.right),getHight(p.left));
                newRoot.hight=1+Math.max(getHight(newRoot.left),getHight(newRoot.right));
                return newRoot;
            }
            private Product rightRotation(Product p)
            {
                Product newRoot=p.left;
                Product newRootChildren=newRoot.right;
                newRoot.right=p;
                p.left=newRootChildren;
                p.hight=1+Math.max(getHight(p.right),getHight(p.left));
                newRoot.hight=1+Math.max(getHight(newRoot.left),getHight(newRoot.right));

                return newRoot;
            }
            private Product innerBalanceAdding(Product p, int ID, String name, float price, int quantity)
            {
                if (p==null) {
                    return new Product(ID,name ,price,quantity);
                }

                if (ID<p.ID)
                    p.left= innerBalanceAdding(p.left,ID,name,price,quantity);
                else if (ID>p.ID)
                    p.right =innerBalanceAdding(p.right,ID,name,price, quantity);
                else {
                    return p;
                }

                p.hight = 1 + Math.max(getHight(p.left), getHight(p.right));
                int factor = getBalance(p);

                if (factor > 1 &&ID< p.left.ID)
                    return rightRotation(p);
                if (factor< -1 &&ID > p.right.ID)
                    return leftRotation(p);
                if (factor> 1 &&ID >p.left.ID) {
                    p.left=leftRotation(p.left);
                    return rightRotation(p);
                }
                if (factor< -1 &&ID<p.right.ID) {
                    p.right=rightRotation(p.right);
                    return leftRotation(p);
                }
                return p;
            }



            static public Product searchProduct(int id)
            {
                Product p=innerSearching(product,id);
                if(p!=null)
                    System.out.println("Product founded.");
                else
                    System.out.println("No such ID like "+id+" !!!!");
                return p;
            }


            static private Product innerSearching(Product p, int id)
            {
                if(p!=null)
                {
                    if(p.ID==id) return p;
                    else if(id<p.ID)
                        return  innerSearching(p.left,id);
                    else if(id>p.ID)
                        return  innerSearching(p.right,id);
                    else return p;
                }
                return null;
            }


            public void UpdateDetails(int id,float newUpdate,char typeOfChange)
            {
                Product p=innerSearching(product,id);
                if (p == null) {
                    System.out.println("Product not found.");
                    return;
                }
                if(typeOfChange=='p'|| typeOfChange=='P')
                {
                    if (newUpdate<= 0 || newUpdate>1000000) {
                        System.out.println("Invalid new price! Please make it between 0 and 1000000.");
                        return;
                    }
                    p.price=newUpdate;
                    System.out.println("Price updated successfully.");
                }
                else if(typeOfChange=='q'||typeOfChange=='Q')
                {
                    if (newUpdate < 0||newUpdate >1000||(containerCapacity-p.quantity+newUpdate)>1000) {
                        System.out.println("Invalid new quantity!");
                        return;
                    }
                    containerCapacity =containerCapacity-p.quantity+(int)newUpdate;
                    p.quantity=(int)newUpdate;
                    System.out.println("Quantity updated successfully.");
                }
                else
                    System.out.println("No such operation !!!");
            }

            public void delateProduct(int id)
            {
                Product target =innerSearching(product, id);
                if (target ==null) {
                    System.out.println("Product not found.");
                    return;
                }

                int bell = containerCapacity-target.quantity;
                if (bell<0) {
                    System.out.println("Invalid quantity to delete!");
                    return;
                }

                containerCapacity=bell;

                productManagers.removeIf(p ->p.ID ==id);

                product = innerDelation(product,id);
            }

            private Product findTheNextID(Product p)
            {
                if (p.left!=null)
                    return findTheNextID(p.left);
                return p;
            }

            private Product innerDelation(Product p, int id)
            {
                if (p ==null)
                    return null;

                if (id <p.ID) {
                    p.left =innerDelation(p.left, id);
                } else if (id > p.ID) {
                    p.right=innerDelation(p.right, id);
                } else {
                    if (p.left == null)
                        return p.right;
                    if (p.right == null)
                        return p.left;

                    Product nextProduct = findTheNextID(p.right);
                    int nextID = nextProduct.ID;

                    p.ID = nextProduct.ID;
                    p.price = nextProduct.price;
                    p.name = nextProduct.name;
                    p.quantity = nextProduct.quantity;

                    p.right = innerDelation(p.right, nextID);
                }
                return p;
            }

            public void showProduct()
            {
                innerPrintProduct(product);
            }
            private void innerPrintProduct(Product p)
            {
                if(p==null) return ;
                else
                {
                    System.out.println("product name: "+p.name+" , "+" price: "+p.price+" , "+" quantity: "+p.quantity+" , "+" ID: "+p.ID);
                    innerPrintProduct(p.left);
                    innerPrintProduct(p.right);
                }
            }

            public float calculateInventoryValue() {
                return calculateInventory(product);
            }

            private float calculateInventory(Product p)
            {
                if (p == null) return 0;
                return (p.price * p.quantity)+calculateInventory(p.left)+calculateInventory(p.right);
            }

        }
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////
        public  static class Order{
            int orderID;
            int priority;
            int numberOfProduct;
            ProductManager pro=new ProductManager();

            public Order(){}
            public Order(int orderID, int priority,int numberOfProduct) {
                this.orderID = orderID;
                this.priority = priority;
                this.numberOfProduct=numberOfProduct;
            }
            @Override
            public String toString() {
                return "[OrderID: " + orderID + " , Priority: " + priority +" , Number product: "+numberOfProduct +"]";
            }

        }

        /// ////////////////////////////////////////////////////////////////////////// ///
        Scanner in=new Scanner(System.in);
        public void addOrder(int id,int priority,int numberOfProduct)
        {
            if (priority < 1) {
                System.out.println("Invalid priority! Please make it between 1 and 10.");
                return;
            }
            for(Order ord:orders)
                if(ord.orderID==id)
                {
                    System.out.println("This order is already exist!!!!");
                    return ;
                }


            order=new Order(id,priority,numberOfProduct);
            orders.add(order);
            Heapify_Up(orders.size() - 1);
            for(int i=1;i<=numberOfProduct;i++)
            {
                System.out.println("* product number "+ i);
                System.out.println("enter id: ");
                int idp=in.nextInt();
                System.out.println("enter the name: ");
                String name=in.next();
                System.out.println("enter the price: ");
                float price=in.nextFloat();
                System.out.println("enter the quantity: ");
                int quantity=in.nextInt();
                order.pro.addAProduct(idp,name,price,quantity);
            }



        }

        public Order mostPriority()
        {
            if (orders.isEmpty()) return null;
            return orders.get(0);
        }

        public void print()
        {
            if (orders.isEmpty()) {
                System.out.println("Queue is empty.");
                return;
            }

            System.out.println("Current Orders in Queue:");
            for (Order order : orders) {
                System.out.println(order);
                order.pro.showProduct();
            }
        }

        public void updatePriority(int orderID, int newPriority)
        {
            if (newPriority < 1 || newPriority > 10) {
                System.out.println("Invalid new priority! Please make it between 1 and 10.");
                return;
            }

            for(int i = 0; i<orders.size(); i++){
                if(orders.get(i).orderID==orderID)
                {
                    int oldPriority=orders.get(i).priority;
                    orders.get(i).priority=newPriority;

                    if(newPriority>oldPriority)
                        Heapify_Up(i);
                    else
                        Heapify_Down(i);
                    return;
                }
            }
            System.out.println("Order ID " + orderID + " not found.");
        }

        public Order extractMax() {
            if(orders.isEmpty())
            {
                System.out.println("Queue is empty.");
                return null;
            }
            Order max =orders.get(0);
            Order last =orders.remove(orders.size()-1);

            if(!orders.isEmpty()){
                orders.set(0,last);
                Heapify_Down(0);
            }
            return max;
        }

        /// ///////////////////////////////////////////////////////////////////// ///

        private void Heapify_Up(int index)
        {
            while (index>0){
                int mindex=(index-1)/2;
                if(orders.get(index).priority>orders.get(mindex).priority)
                {
                    swap(index,mindex);
                    index=mindex;
                }
                else
                    break;
            }
        }

        private void Heapify_Down(int index)
        {
            int size=orders.size();

            while(index<size){
                int left=2*index+1;
                int right=2*index+2;
                int largest = index;
                if(right<size && orders.get(largest).priority<orders.get(right).priority)
                    largest=right;
                else if (left<size&&orders.get(largest).priority<orders.get(left).priority)
                    largest=left;
                if(largest!=index) {
                    swap(index, largest);
                    index = largest;
                }
                else
                    break;
            }
        }

        private void swap(int index,int midindex)
        {
            Order temp=orders.get(index);
            orders.set(index,orders.get(midindex));
            orders.set(midindex,temp);
        }
        public float totalCostOfOrders()
        {
            int total=0;
            for(Order ord:orders)
                total+=ord.pro.calculateInventoryValue();
            return total;

        }
    }
    public class Shipment{
        int shipmentID;
        String destination;
        float cost;
        String deliveryDate;
        Shipment left;
        Shipment right;
        PriorityOrder prio=new PriorityOrder();

        Shipment(){

        }
        public Shipment(int shipmentID, String destination, float cost, String deliveryDate) {
            this.shipmentID = shipmentID;
            this.destination = destination;
            this.cost = cost;
            this.deliveryDate = deliveryDate;

        }
    }

   static Shipment shipment;

    /// /////////////////////////////////////////////////////////////// ///
    ///
    /// @return

    public Shipment addShipment(int ID, String destination, float cost, String deliveryDate)
    {
        Shipment s=Inner_search(shipment,ID);
        if(s!=null && s.shipmentID==ID)
        {
            System.out.println("THIS SHIPMENT IS ALREADY EXSIST!!!");
            return s;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d\\M\\yyyy");
        LocalDate delivery = LocalDate.parse(deliveryDate,formatter);
        if (delivery.isBefore(LocalDate.now())) {
            System.out.println("Invalid delivery date! Cannot be in the past.");
            return s;
        }
        if(cost<=0 || cost>1000000){
            System.out.println("invalide cost ! Please make it between 0 and 1000000.");
            return s;
        }


        shipment = innerAddShipment(shipment, ID, destination, cost, deliveryDate);


       // if (newNodeCreated != null)
            shipments.add(new Shipment(ID, destination, cost, deliveryDate));
        return shipment;
    }

    private Shipment innerAddShipment(Shipment node, int ID, String destination, float cost, String deliveryDate)
    {
        if (node == null) {
            return new Shipment(ID, destination, cost, deliveryDate);

        }
        if (ID < node.shipmentID) {
            node.left = innerAddShipment(node.left, ID, destination, cost, deliveryDate);
        } else if (ID > node.shipmentID) {
            node.right = innerAddShipment(node.right, ID, destination, cost, deliveryDate);
        } else {
            System.out.println("Shipment with ID " + ID + " already exists.");

        }
        return node;
    }


    public Shipment Shipment_search(int ID)
    {
        Shipment s=Inner_search(shipment,ID);
        if(s!=null)
        {
            System.out.println("Product founded and it is: ");
            System.out.println("Shipment ID: " + s.shipmentID +'\n'+ "Destination: " + s.destination
                    +'\n'  + "Cost: " + s.cost +'\n'+ "Delivery Date: " + s.deliveryDate);
        }
        else
        {
            System.out.println("No such ID like "+ID+" !!!!");
        }


        return s;
    }

  static   private Shipment Inner_search(Shipment shipment, int ID)
    {
        if(shipment!=null)
        {
            if(shipment.shipmentID==ID) return shipment;
            else if(ID<shipment.shipmentID)
                return  Inner_search(shipment.left,ID);
            else
                return  Inner_search(shipment.right,ID);
        }
        return null;

    }



    public void updateShipmentDate(int ID,String upDate)
    {


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d\\M\\yyyy");


        LocalDate newDate  = LocalDate.parse(upDate,formatter);
        if (newDate.isBefore(LocalDate.now())) {
            System.out.println("Invalid delivery date! Cannot be in the past.");
            return;
        }
        Shipment s=Inner_search(shipment,ID);
        if(s!=null)
            s.deliveryDate=upDate;
        else
            System.out.println("No such ID like "+ID+" !!!!");
    }

    public void printShipments()
    {
        inOrderPrint(shipment);
    }

    private void inOrderPrint(Shipment shipment)
    {
        if (shipment != null) {
            inOrderPrint(shipment.left);
            System.out.println("Shipment ID: " + shipment.shipmentID +'\n'+ "Destination: " + shipment.destination
                    +'\n'  + "Cost: " + shipment.cost +'\n'+ "Delivery Date: " + shipment.deliveryDate);
            inOrderPrint(shipment.right);
            System.out.println("___________________________________________");
        }
    }

   static public void printHighCostShipments(float threshold) {
        System.out.println("Shipments with cost higher than " + threshold + ":");
        recursiveHighCost(shipment, threshold);
    }

   static private void recursiveHighCost(Shipment s, float threshold) {
        if (s == null) return;
        recursiveHighCost(s.left, threshold);
        if (s.cost > threshold) {
            System.out.println("ID: " + s.shipmentID + ", Cost: " + s.cost + ", Destination: " + s.destination);
        }
        recursiveHighCost(s.right, threshold);
    }

}

