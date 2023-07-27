import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class FoodSupplierRunner {
    public static void main(String args[]) {
        File f = new File("/Users/user/IdeaProjects/AT CS/src/supplyOrders.dat");
        FoodSupplier fs = new FoodSupplier();
        try {
            Scanner scan = new Scanner(f);
            String next;
            scan.nextLine();
            while (scan.hasNext()) {
                next = scan.nextLine();
                fs.addOrder(next);
            }
            System.out.println(fs);
            System.out.println("Date With Most Burgers: " + fs.dateWithMostItems("burgers"));
            System.out.println("Company With Most Burgers: " + fs.companyWithMostItems("burgers"));
            System.out.println(fs.storeWithLongestOrderBreak());
            System.out.println("Company Most Burgers in the year 2014: " + fs.companyWithMostItems("burgers", 2014));
            System.out.println("Orders on 12-30-2015: " + fs.ordersOn(30, 12, 2015));
            System.out.println("Orders on December of 2015: " + fs.ordersOn(12, 2015));
            System.out.println("Orders on December: " + fs.ordersOnMonth(12));
            System.out.println("Orders on the 30th: " + fs.ordersOnDay(30));
            System.out.println("Duplicates Orders on 1-9-2010: " + fs.duplicates(9, 1, 2010));
            System.out.println("Companies with at least 6 burgers in 2010: " + fs.companiesWithItemAmountInYear("burgers", 6, 2010));
            System.out.println("Orders made by McDonalds between 1/14/2010 to 1/14/2011: "+fs.getOrdersForCompanyInDateInterval("McDonalds",new Date(2010-1900,01-1,14), new Date(2011-1900, 01 - 1,14)));
            fs.printNumOrdersByCompanyInDateInterval("Wendys",new Date(2010-1900,01-1,14), new Date(2011-1900, 01 - 1,14));
            fs.printTotalItemsOrdered("fries",new Date(2010-1900,01-1,14), new Date(2011-1900, 01 - 1,14));
            System.out.println("Money collected on 1/14/2010: $" + fs.money_on_one_date(new Date(2010-1900,01-1,14)));
            System.out.println("Money collected between 1/14/2010 and 1/14/2011: $" + fs.money_on_an_interval(new Date(2010-1900,01-1,14),new Date(2011-1900, 01 - 1,14)));
            System.out.println("Money collected by Wendys between 1/14/2010 and 1/14/2011: $" + fs.billing_statement(new Date(2010-1900,01-1,14),new Date(2011-1900, 01 - 1,14),"Wendys"));


        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

//[BurgerKing, McDonalds, Wendys, Hardees, FiveGuys]