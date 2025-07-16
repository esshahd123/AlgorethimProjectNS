import java.util.ArrayList;

public class ProductManager {

    static ArrayList<Product> productManagers=new ArrayList<>();
    private Product newProductCreated = null;
    Product product;
    static int containerCapacity;
    ProductManager(){
        addAProduct(9,"milk",76,33);
        addAProduct(8,"orange",55,44);
        addAProduct(7,"chair",788,36);
        addAProduct(10,"bread",33,27);
        addAProduct(11,"table",900,75);
    }

    public static class Product {
        int ID;
        String name;
        float price;
        int quantity;
        int hight;
        Product left;
        Product right;
        Product(){

        }

        public Product(int ID, String name, float price, int quantity) {
            this.ID = ID;
            this.name = name;
            this.price = price;
            this.quantity = quantity;
            left = null;
            right = null;
        }
    }



    public void addAProduct(int ID,String name,float price, int quantity)
    {
        int bell= containerCapacity+quantity;

        if(price <= 0 || price > 10000 )
        {
            System.out.println("Invalid price! Please make it between 0 and 1000000.");
            return;
        }
        if(quantity < 0 || quantity > 1000 || (bell > 1000)) {
            System.out.println("Invalid quantity! Exceeds warehouse capacity.");
            return;
        }

        containerCapacity=bell;
        newProductCreated=null;
        product=innerAddingProduct(product,ID,name,price,quantity);
        if(newProductCreated!=null)
        productManagers.add(newProductCreated);
    }
    private Product innerAddingProduct(Product p, int ID, String name, float price, int quantity)
    {
        if (p == null) {
            newProductCreated = new Product(ID, name, price, quantity); // نحفظ العنصر الجديد
            return newProductCreated;
        }

        if (ID < p.ID) {
            p.left = innerAddingProduct(p.left, ID, name, price, quantity);
        } else if (ID > p.ID) {
            p.right = innerAddingProduct(p.right, ID, name, price, quantity);
        } else {
            System.out.println("You already have this product.");
        }

        return p;
    }


    public void balanceAdding(int ID,String name,float price, int quantity)
    {
        int bell = containerCapacity + quantity;
        if (bell > 1000 || price < 0) {
            System.out.println("Over full container or invalid price!");
            return;
        }

        containerCapacity = bell;
        newProductCreated = null; // مهم
        product = innerBalanceAdding(product, ID, name, price, quantity);

        if (newProductCreated != null)
            productManagers.add(newProductCreated);
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
        if (p == null) {
            newProductCreated = new Product(ID, name, price, quantity); // نحفظ العقدة الجديدة
            return newProductCreated;
        }

        if (ID < p.ID)
            p.left = innerBalanceAdding(p.left, ID, name, price, quantity);
        else if (ID > p.ID)
            p.right = innerBalanceAdding(p.right, ID, name, price, quantity);
        else {
            System.out.println("You already have this product.");
            return p;
        }

        p.hight = 1 + Math.max(getHight(p.left), getHight(p.right));
        int factor = getBalance(p);

        if (factor > 1 && ID < p.left.ID)
            return rightRotation(p);
        if (factor < -1 && ID > p.right.ID)
            return leftRotation(p);
        if (factor > 1 && ID > p.left.ID) {
            p.left = leftRotation(p.left);
            return rightRotation(p);
        }
        if (factor < -1 && ID < p.right.ID) {
            p.right = rightRotation(p.right);
            return leftRotation(p);
        }

        return p;
    }



    public void searchProduct(int id)
    {
        Product p=innerSearching(product,id);
        if(p!=null)
            System.out.println("Product founded.");
        else
            System.out.println("No such ID like "+id+" !!!!");
    }


    private Product innerSearching(Product p,int id)
    {
        if(p!=null)
        {
            if(p.ID==id) return p;
            else if(id<p.ID)
                return  innerSearching(p.left,id);
            else
                return  innerSearching(p.right,id);
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
            if (newUpdate <= 0 || newUpdate > 1000000) {
                System.out.println("Invalid new price! Please make it between 0 and 1000000.");
                return;
            }
            p.price=newUpdate;
            System.out.println("Price updated successfully.");
        }
        else if(typeOfChange=='q'||typeOfChange=='Q')
        {
            if (newUpdate < 0 || newUpdate > 1000 || (containerCapacity - p.quantity + newUpdate) > 1000) {
                System.out.println("Invalid new quantity!");
                return;
            }
            containerCapacity = containerCapacity - p.quantity + (int)newUpdate;
            p.quantity=(int)newUpdate;
            System.out.println("Quantity updated successfully.");
        }
        else
            System.out.println("No such operation !!!");
    }

    public void delateProduct(int id)
    {
        Product target = innerSearching(product, id);
        if (target == null) {
            System.out.println("Product not found.");
            return;
        }

        int bell = containerCapacity - target.quantity;
        if (bell < 0) {
            System.out.println("Invalid quantity to delete!");
            return;
        }

        containerCapacity = bell;

        productManagers.removeIf(p -> p.ID == id);

        product = innerDelation(product, id);
    }

    private Product findTheNextID(Product p)
    {
        if (p.left != null)
            return findTheNextID(p.left);
        return p;
    }



    private Product innerDelation(Product p, int id)
    {
        if (p == null)
            return null;

        if (id < p.ID) {
            p.left = innerDelation(p.left, id);
        } else if (id > p.ID) {
            p.right = innerDelation(p.right, id);
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

    private float calculateInventory(Product p) {
        if (p == null) return 0;
        return (p.price * p.quantity) + calculateInventory(p.left) + calculateInventory(p.right);
    }

}
