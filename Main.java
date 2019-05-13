import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Product> products = new ArrayList<Product>();

        //create demo Users
        Product prod = new Product("Alex",10,100);

        Product prod2 = new Product("Marc",5,10);

        Product prod3 = new Product("Radu",20,200);


        CsvReaderWriter csv = new CsvReaderWriter("E:\\Alex\\Evozon\\ProductApp\\src\\Data\\products.csv");

        Product p = new Product();

        csv.writeRow(prod);
        csv.writeRow(prod2);
        csv.writeRow(prod3);
        csv.readOneRow(p);
        csv.deleteRow();
        System.out.println(p);
        csv.readOneRow(p);
        System.out.println(p);
        csv.updateRow("Paul",1,1);


    }
}
