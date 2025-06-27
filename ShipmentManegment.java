public class ShipmentManegment {
    public class Shipment{
        int shipmentID;
        String destination;
        float cost;
        String deliveryDate;
        Shipment left;
        Shipment right;

        public Shipment(int shipmentID, String destination, float cost, String deliveryDate) {
            this.shipmentID = shipmentID;
            this.destination = destination;
            this.cost = cost;
            this.deliveryDate = deliveryDate;
        }
    }


    Shipment shipment;

    /// ///////////////////////////////////////////////////////////// ///

    public void addShipment(int ID, String destination, float cost, String deliveryDate)
    {
        shipment = innerAddShipment(shipment, ID, destination, cost, deliveryDate);
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

    public void Shipment_search(int ID)
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

    }

    private Shipment Inner_search(Shipment shipment, int ID)
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
        }
    }



}
