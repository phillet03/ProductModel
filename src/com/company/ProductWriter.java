package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class ProductWriter {

    public static void main(String[] args) {
        String totalInput = "";
        ArrayList<String> products = new ArrayList<String>();
        Scanner input = new Scanner(System.in);



        while(!totalInput.toString().equalsIgnoreCase("n")) {
            totalInput = SafeInput.getNonZeroLenString(input, "Give the product's information in the format: " +
                    "ID, Name, Description, Cost. Give 'N' to cancel");

            products.add(totalInput);
        }

        products.remove(products.size() - 1);


        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\ProductTestData.txt");

        try {

            OutputStream out = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

            for (String product : products) {
                writer.write(product, 0, product.length());

                writer.newLine();
            }

            writer.close();
            System.out.println("File has been written");


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
