import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main{

    public static void main(String[] args)  {
        File inputFile = new File("data.txt");
        try {
            Scanner inputData = new Scanner(inputFile);

        }
        catch (IOException ex){
            System.out.println("Błąd pliku wejściowego");
        }

    }
}
