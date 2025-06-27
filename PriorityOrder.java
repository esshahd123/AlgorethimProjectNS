import java.util.ArrayList;


public class PriorityOrder {
    public class Order{
        int orderID;
        int priority;

        public Order(int orderID, int priority) {
            this.orderID = orderID;
            this.priority = priority;
        }
        @Override
        public String toString() {
            return "[OrderID: " + orderID + ", Priority: " + priority + "]";
        }

    }


    ArrayList <Order>orders=new ArrayList<>();
/// ////////////////////////////////////////////////////////////////////////// ///

    public void addOrder(Order order)
    {
        orders.add(order);
        Heapify_Up(orders.size()-1);

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
        }
    }

    public void updatePriority(int orderID, int newPriority)
    {
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
}
