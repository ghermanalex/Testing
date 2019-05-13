import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class CsvReaderWriter {

    private  String filePath;

    public CsvReaderWriter(String filePath)
    { this.filePath=filePath;
    }


    public  void writeRow(Product p ) {


        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(filePath,true);
            fileWriter.append(p.getName());
            fileWriter.append(",");
            fileWriter.append(String.valueOf(p.getPrice()));
            fileWriter.append(",");
            fileWriter.append(String.valueOf(p.getQuantity()));
            fileWriter.append("\n");

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void readOneRow( Product prod) {
        BufferedReader reader = null;


        try {

            String line = "";
            reader = new BufferedReader(new FileReader(filePath));

            while((line = reader.readLine()) != null ) {
                String[] fields = line.split(",");

                if(fields.length > 0) {
                    prod.setName(fields[0]);
                    prod.setPrice(Integer.parseInt(fields[1]));
                    prod.setQuantity(Integer.parseInt(fields[2]));

                }

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    //we can delete a specifix row by giving the index of the row as parameter
    //and remove from that index
    public void deleteRow()
    {
        List<Product> products = new ArrayList<Product>() ;
        readAllPorducts(products);
        int size = products.size();

        products.remove(size-1);
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(filePath);
            for(Product p:products) {
                fileWriter.append(p.getName());
                fileWriter.append(",");
                fileWriter.append(String.valueOf(p.getPrice()));
                fileWriter.append(",");
                fileWriter.append(String.valueOf(p.getQuantity()));
                fileWriter.append("\n");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


    public void updateRow(String name,Integer price,Integer quantity)
    {
        List<Product> products = new ArrayList<Product>() ;
        readAllPorducts(products);
        int size = products.size();
        products.get(size-1).setName(name);
        products.get(size-1).setPrice(price);
        products.get(size-1).setQuantity(quantity);

        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(filePath);
            for(Product p:products) {
                fileWriter.append(p.getName());
                fileWriter.append(",");
                fileWriter.append(String.valueOf(p.getPrice()));
                fileWriter.append(",");
                fileWriter.append(String.valueOf(p.getQuantity()));
                fileWriter.append("\n");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }







    public void readAllPorducts( List<Product> products) {
        BufferedReader reader = null;


        try {
           // List<Product> products = new ArrayList<Product>();
            String line = "";
            reader = new BufferedReader(new FileReader(filePath));

            while((line = reader.readLine()) != null) {
                String[] fields = line.split(",");

                if(fields.length > 0) {
                    Product prod = new Product();
                    prod.setName(fields[0]);
                    prod.setPrice(Integer.parseInt(fields[1]));
                    prod.setQuantity(Integer.parseInt(fields[2]));
                    products.add(prod);
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}