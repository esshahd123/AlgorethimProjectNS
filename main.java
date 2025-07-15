public class main {
    public static void showData()
    {
        ProductManager p1=new ProductManager();
        p1.addAProduct(1112,"milk bottul",2500,140);
        p1.addAProduct(1111,"meat",4000,250);
        p1.addAProduct(1117,"blastic",3500,100);
        p1.addAProduct(1119,"glasses",2000,500);
        //p1.addAProduct(1116,"ceriaten",2750,120);
        //p1.delateProduct(1117);
        // p1.UpdateDetails(1112,2600,'P');
        p1.showProduct();
        System.out.println("* The whole cost of all products: "+p1.calculateInventoryValue());
        ShipmentManegment sh1=new ShipmentManegment();
        sh1.addShipment(4441,"damas",12000,"2025/7/17");
        sh1.addShipment(4440,"aleppo",30000,"2025/7/20");
        sh1.addShipment(4444,"hama",10000,"2025/8/1");
        sh1.printShipments();

    }
    public static void main(String [] args)
    {
        //showData();
        new  WelcomeSwing();
    }
}
