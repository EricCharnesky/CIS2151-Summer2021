package exceptionsandfileio;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

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
            Food food = new Food("Sushi", 9.99);
            FileOutputStream fileOutputStream = new FileOutputStream("testbinaryobject.dat");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(food);
            objectOutputStream.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
        
        try {
            Food food;
            
            FileInputStream fileInputStream = new FileInputStream("testbinaryobject.dat");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            
            food = (Food)objectInputStream.readObject();
            
            System.out.println(food.getName() + " $" + food.getCost());
            
        }catch (IOException | ClassNotFoundException ex ) {
            System.out.println(ex);
        }
        
        System.out.println("Hello?");
    }

}
