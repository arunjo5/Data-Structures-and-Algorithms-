import java.util.HashMap;
import java.util.Map;

public class Order {
    String company;
    String original_order;
    Map<String, Integer> order_items = new HashMap<String, Integer>();

    public Order(String order_info) {
        original_order = order_info;
        company = "";
        for(String order_item:order_info.split(" ")) {
            if(company.equals("")) {
                company = order_item; // company set to order_item
            } else {
                String[] order_details = order_item.split("-"); // splits into item name and quantity
                order_items.put(order_details[0], Integer.parseInt(order_details[1])); // hashmap gets put with name/quanity
            }
        }
    }

    public int getNumOrdered(String item) {
        if(order_items.get(item) == null) { return 0;}
        return order_items.get(item);
    }

    public String getCompanyName() {
        return company.split("#")[0];
    }

    public int getStoreNumber() {
        return Integer.parseInt(company.split("#")[1]);
    }

    public String getStoreId() {
        return company;
    }

    public String getOriginalOrder(){
        return original_order;
    }

    public String toString() {
        String ret = company+" ";
        for(String item : order_items.keySet()) {
            ret += "{"+item + " : " + order_items.get(item) + "} | ";
        }
        return ret;
    }
}