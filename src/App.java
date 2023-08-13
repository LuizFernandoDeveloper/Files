
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.Product;

public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        File path  = new File("/home/luiz/wk/udemy/java/files/files/ex001/file.csv");
        File pathFolder = new File("/home/luiz/wk/udemy/java/files/files/ex001/");
        Scanner sc = null;
        List<Product> products = new ArrayList<Product>();

        System.out.println();
        System.out.println();

        try{
            sc = new Scanner(path);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String [] vectLine = line.split(",");
                String nameProduct = vectLine[0].trim();
                Float price = Float.parseFloat(vectLine[1].trim());
                Integer quantity = Integer.parseInt(vectLine[2].trim());
                Product product = new Product(nameProduct, price, quantity);
                products.add(product);
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }finally{
            if(sc != null){
                sc.close();
            }
        }

    for (Product product : products) {
        System.out.println(product);
        System.out.println();
    }

    System.out.println();
    System.out.println();

    boolean success = new File(pathFolder + "/out").mkdir();
    System.out.println("Folder created: " + success );

    String targetFileStr = pathFolder + "/out/summary.csv";

    try(BufferedWriter bw = new BufferedWriter( new FileWriter(targetFileStr))){
        for(Product product: products){
            bw.write(product.getNameProduct() + ", " + String.format("%.2f", product.getTotalValue()));
            bw.newLine();
        }
        System.out.println("Create a file");
    }catch(IOException e){
        System.out.println("Error writing file: " + e.getMessage());
    }

    }
}