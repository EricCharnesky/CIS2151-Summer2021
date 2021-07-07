package exceptionsandfileio;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExceptionsAndFileIO {

    public static void main(String[] args) {
        
        
        try {
            PrintWriter outputFile = new PrintWriter("testfile.txt");
            outputFile.println("2000000000");
            outputFile.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("testbinaryfile.dat");
            DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
            dataOutputStream.writeChars("2000000000\n");
            dataOutputStream.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
        try {
            Food food = new Food("Sushi", -9.99);
            food.addIngredient("rice");
            food.addIngredient("avacado");
            food.addIngredient("krab");
            food.addIngredient("seaweed");
            FileOutputStream fileOutputStream = new FileOutputStream("testbinaryobject.dat");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(food);
            objectOutputStream.close();
        } 
        catch ( IllegalArgumentException ex){
            System.out.println(ex);
        }
        catch (IOException ex ) {
            System.out.println(ex);
        }

        try {
            Food food;
            
            File testBinaryObjectFile = new File("testbinaryobject.dat");
            
            if ( testBinaryObjectFile.exists() )
            {
                FileInputStream fileInputStream = new FileInputStream(testBinaryObjectFile);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

                food = (Food) objectInputStream.readObject();

                System.out.println(food.getName() + " $" + food.getCost());
                for (String ingredient : food.getIngredients()) {
                    System.out.println(ingredient);
                }
            }

        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex);
        }

        
        try {
            RandomAccessFile randomFile = new RandomAccessFile("someData.dat", "rw");
            randomFile.seek(100);
            int value = randomFile.readInt();
            System.out.println(value);
        } catch (IOException ex) {
            System.out.println(ex);
        }
        
        
    }

}
