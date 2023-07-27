import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class FoodSupplier {
    Map<Date, LinkedList<Order>> orders;
    HashMap<String, Double> costmap = new HashMap<>();
    public FoodSupplier() {
        orders = new TreeMap<Date, LinkedList<Order>>();
        costmap.put("burgers", 5.0);
        costmap.put("buns", 2.0);
        costmap.put("fries", 1.0);
        costmap.put("straws", 0.5);
        costmap.put("napkins", 0.2);
        costmap.put("cokesyrup", 1.0);
    }

    public void addOrder(String order) {
        String date_str = order.split(" ")[0]; // Date
        order = order.substring(order.indexOf(" ") + 1, order.length()); // Everything else
        String[] date_split_strs = date_str.split("-");
        int[] date_split_ints = new int[3];
        int y = 0;
        for (String x : date_split_strs) {
            date_split_ints[y++] = Integer.parseInt(x);
        }
        Date order_date = new Date(date_split_ints[2] - 1900, date_split_ints[0] - 1, date_split_ints[1]);
        if (orders.get(order_date) == null) {
            orders.put(order_date, new LinkedList<Order>());
        }
        orders.get(order_date).add(new Order(order));
    }

    public LinkedList<Order> getDateOrders(Date x){
        return orders.get(x);
    }

    public Date dateWithMostItems(String item) {
        Date dateWithMost = new Date(0, 0, 0);
        int numItems = 0;
        for (Date x : orders.keySet()) {
            int num_items_date = 0;
            for (Order o : orders.get(x)) {
                num_items_date += o.getNumOrdered(item);
            }
            if (num_items_date > numItems) {
                numItems = num_items_date;
                dateWithMost = x;
            }
        }
        return dateWithMost;
    }

    public String companyWithMostItems(String item) {
        Map<String, Integer> order_items = new HashMap<String, Integer>();
        for (Date x : orders.keySet()) {
            for (Order o : orders.get(x)) {
                int num_ordered = o.getNumOrdered(item);
                if (order_items.get(o.getCompanyName()) != null) {
                    order_items.put(o.getCompanyName(), order_items.get(o.getCompanyName()) + num_ordered);
                } else {
                    order_items.put(o.getCompanyName(), num_ordered);
                }
            }
        }

        String companyMost = "";
        for (String company : order_items.keySet()) {
            if (companyMost == "") {
                companyMost = company;
                continue;
            }
            if (order_items.get(companyMost) < order_items.get(company)) {
                companyMost = company;
            }
        }
        return companyMost;
    }

    public String companyWithMostItems(String item, int year) {
        Map<String, Integer> order_items = new HashMap<String, Integer>();
        for (Date x : orders.keySet()) {
            if (x.getYear() + 1900 == year) {
                int num_items_date = 0;
                for (Order o : orders.get(x)) {
                    int num_ordered = o.getNumOrdered(item);
                    if (order_items.get(o.getCompanyName()) != null) {
                        order_items.put(o.getCompanyName(), order_items.get(o.getCompanyName()) + num_ordered);
                    } else {
                        order_items.put(o.getCompanyName(), num_ordered);
                    }
                }
            }
        }

        String companyMost = "";
        for (String company : order_items.keySet()) {
            if (companyMost == "") {
                companyMost = company;
                continue;
            }
            if (order_items.get(companyMost) < order_items.get(company)) {
                companyMost = company;
            }
        }
        return companyMost;
    }

    public String storeWithLongestOrderBreak() {
        Map<String, ArrayList<Date>> stores_and_dates = new TreeMap<String, ArrayList<Date>>();
        for (Date x : orders.keySet()) {
            for (Order o : orders.get(x)) {
                if (stores_and_dates.get(o.getStoreId()) == null) {
                    ArrayList<Date> dates = new ArrayList<Date>();
                    stores_and_dates.put(o.getStoreId(), dates);
                } else {
                    stores_and_dates.get(o.getStoreId()).add(x);
                }
            }
        }
        // Calculate the maximum time between orders for each store
        Map<String, Integer> stores_and_max_days_between_orders = new TreeMap<String, Integer>();
        for (String c : stores_and_dates.keySet()) { // Get all the dates of orders for each store
            int max_between_orders = 0;
            Date lastOrder = null;
            for (Date order_date : stores_and_dates.get(c)) {
                if (lastOrder != null) {
                    int daysBetween = (int) TimeUnit.DAYS.convert(order_date.getTime() - lastOrder.getTime(), TimeUnit.MILLISECONDS);
                    if (daysBetween > max_between_orders) {
                        max_between_orders = daysBetween;
                    }
                }
                lastOrder = order_date;
            }
            stores_and_max_days_between_orders.put(c, max_between_orders);
        }
        // Find store with maximum days between orders
        String storeWithLongestBreak = "";
        int max_days_between_orders = 0;
        for (String c : stores_and_max_days_between_orders.keySet()) {
            if (stores_and_max_days_between_orders.get(c) > max_days_between_orders) {
                max_days_between_orders = stores_and_max_days_between_orders.get(c);
                storeWithLongestBreak = c;
            }
        }
        return "Store with longest order break is " + storeWithLongestBreak + " with " + max_days_between_orders + " days.";
    }



    public Set<Order> ordersOn(int day, int month, int year) {
        Date d = new Date(year - 1900, month - 1, day);
        HashSet<Order> orders_set = new HashSet<Order>();
        if (orders.get(d) == null) {
            return null;
        }
        for (Order o : orders.get(d)) {
            orders_set.add(o);
        }
        return orders_set;

    }

    public Set<Order> ordersOn(int month, int year) {
        HashSet<Order> orders_set = new HashSet<Order>();
        for (int day = 1; day < 32; day++) {
            Date d = new Date(year - 1900, month - 1, day);
            if (orders.get(d) != null) {
                for (Order o : orders.get(d)) {
                    orders_set.add(o);
                }
            }

        }
        return orders_set;
    }

    public Set<Order> ordersOnMonth(int month) {
        HashSet<Order> orders_set = new HashSet<>();
        for (Date date : orders.keySet()) {
            if (date.getMonth() + 1 == month) {
                LinkedList<Order> orderList = orders.get(date);
                orders_set.addAll(orderList);
            }
        }
        return orders_set;
    }

    public Set<Order> ordersOnDay(int day) {
        HashSet<Order> ordersSet = new HashSet<>();
        for (Date date : orders.keySet()) {
            if (date.getDate() == day) {
                ordersSet.addAll(orders.get(date));
            }
        }
        return ordersSet;
    }

    public Set<Order> duplicates(int day, int month, int year) {
        HashSet<Order> orders_set = new HashSet<Order>();
        HashSet<Order> orders_dupes = new HashSet<Order>();
        Date d = new Date(year - 1900, month - 1, day);
        if (orders.get(d) == null) {
            return null;
        }
        for (Order o : orders.get(d)) {
            if (orders_set.add(o) == false) {
                orders_dupes.add(o);
            }
        }
        return orders_dupes;
    }



    public Set<String> companiesWithItemAmountInYear(String item, int amount, int year) {
        Set<String> companies = new HashSet<>();
        for (Date x : orders.keySet()) {
            if (x.getYear() + 1900 == year) {
                for (Order o : orders.get(x)) {
                    int num_ordered = o.getNumOrdered(item);
                    if (num_ordered >= amount) {
                        companies.add(o.getCompanyName());
                    }
                }
            }
        }
        return companies;
    }

    public Set<Order> getOrdersForCompanyInDateInterval(String company, Date start, Date end) {
        Set<Order> companyOrders = new HashSet<Order>();
        for (Date date : orders.keySet()) {
            if (date.compareTo(start) >= 0 && date.compareTo(end) <= 0) {
                LinkedList<Order> ordersList = orders.get(date);
                for (Order order : ordersList) {
                    if (order.getCompanyName().equals(company)) {
                        companyOrders.add(order);
                    }
                }
            }
        }
        return companyOrders;
    }

    public void printNumOrdersByCompanyInDateInterval(String company, Date start, Date end) {
        int numOrders = 0;
        for (Date x : orders.keySet()) {
            if (x.compareTo(start) >= 0 && x.compareTo(end) <= 0) {
                for (Order o : orders.get(x)) {
                    if (o.getCompanyName().equals(company)) {
                        numOrders++;
                    }
                }
            }
        }
        System.out.println("The total number of orders from " + company + " between " + start + " and " + end + " is: " + numOrders);
    }

    public void printTotalItemsOrdered(String item, Date start, Date end) {
        int numOrdered = 0;
        for (Date x : orders.keySet()) {
            if (x.compareTo(start) >= 0 && x.compareTo(end) <= 0) {
                for (Order o : orders.get(x)) {
                    numOrdered += o.getNumOrdered(item);
                }
            }
        }
        System.out.println("Total number of " + item + " ordered from " + start + " to " + end + ": " + numOrdered);
    }

    public double money_on_one_date(Date start) {
        double totalCost = 0.0;
        for(Date d : orders.keySet()) {
            LinkedList<Order> orderlist = orders.get(d);
            for(Order order : orderlist) {
                if (d.equals(start)) {
                        double cost = 0.0;
                        for (String item : order.order_items.keySet()) {
                            if (costmap.containsKey(item)) {
                                cost += costmap.get(item) * order.order_items.get(item);
                            }
                        }
                        totalCost += cost;
                }
            }

        }
        return totalCost;
    }

    public double money_on_an_interval(Date start, Date end) {
        double totalCost = 0.0;
        for(Date d : orders.keySet()) {
            LinkedList<Order> orderlist = orders.get(d);
            for(Order order : orderlist) {
                if (d.after(start) && d.before(end)) {
                        double cost = 0.0;
                        for (String item : order.order_items.keySet()) {
                            if (costmap.containsKey(item)) {
                                cost += costmap.get(item) * order.order_items.get(item);
                            }
                        }
                        totalCost += cost;

                }
            }

        }
        return totalCost;
    }


    public double billing_statement(Date start, Date end, String company) {
        double totalCost = 0.0;
        for(Date d : orders.keySet()) {
            LinkedList<Order> orderlist = orders.get(d);
            for(Order order : orderlist) {
                if (d.after(start) && d.before(end)) {
                    if (order.getCompanyName().equals(company)) {
                        double cost = 0.0;
                        for (String item : order.order_items.keySet()) {
                            if (costmap.containsKey(item)) {
                                cost += costmap.get(item) * order.order_items.get(item);
                            }
                        }
                        totalCost += cost;
                    }
                }
            }

        }
        return totalCost;
    }


    //Our method #4 deletes a particular order on a date from the database
    public void deleteOrder(Date date, Order toDelete) {
        File inputFile = new File("supplyOrders.dat");
        File tempFile = new File("temp.txt");

        String sMonth = (date.getMonth()+1) + "";
        if(date.getMonth() < 10) {
            sMonth = "0"+sMonth;
        }
        String sDate = date.getDate() + "";
        if(date.getDate() < 10) {
            sDate = "0"+sDate;
        }
        String sYear = (date.getYear() + 1900) + "";

        String deleteRow =  sMonth+ "-"+sDate+"-"+sYear+" "+toDelete.getOriginalOrder();
        System.out.println(deleteRow);
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                if (currentLine.equals(deleteRow)) {
                    continue; // Skip this line to delete it
                }
                writer.write(currentLine + System.lineSeparator()); // Write remaining lines to temp file
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // Replace original file with temp file
        inputFile.delete();
        tempFile.renameTo(inputFile);

    }


    public String toString() {
        String ret = "";
        for (Date x : orders.keySet()) {
            ret += x + " : " + orders.get(x).toString() + "\n";
        }
        return ret;
    }

}