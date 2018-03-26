import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main{

    public static void main(String[] args)  {
        File inputFile = new File("data.txt");
        try {
            Scanner inputData = new Scanner(inputFile);

            int howManyMore = 0;
            int howManyByTwo = 0;
            int howManyByEight = 0;
            boolean readFirst = false;
            BigBinaryNumber minNumber = new BigBinaryNumber("0");
            int minIndex = 0;
            BigBinaryNumber maxNumber = new BigBinaryNumber("0");
            int maxIndex = 0;

            int k = 1;

            while (inputData.hasNextLine()){
                String stringLine = inputData.nextLine();
                BigBinaryNumber actLineNumber = new BigBinaryNumber(stringLine);

                if (!readFirst){
                    minNumber = actLineNumber;
                    minIndex = k;
                    maxNumber = actLineNumber;
                    minIndex = k;
                    readFirst = true;
                }

                if(actLineNumber.howManyZeros() > actLineNumber.howManyOnes())
                    howManyMore++;

                if(actLineNumber.ifDividedByTwo())
                    howManyByTwo++;

                if(actLineNumber.ifDividedByEight())
                    howManyByEight++;

                if(actLineNumber.compareTo(maxNumber) > 0) {
                    maxNumber = actLineNumber;
                    maxIndex = k;
                }

                if(actLineNumber.compareTo(minNumber) < 0) {
                    minNumber = actLineNumber;
                    minIndex = k;
                }
                k++;
            }


            System.out.println("Ile ma więcej zer niż jedynek: " + howManyMore);
            System.out.println("Podzielnych przez dwa: " + howManyByTwo);
            System.out.println("Podzielnych przez osiem: " + howManyByEight);
            System.out.println("Najmniejsza w linii " + minIndex + " to: " + minNumber.getValue());
            System.out.println("Największa w linii " + maxIndex + " to: " + maxNumber.getValue());

            inputData.close();
        }
        catch (IOException ex){
            System.out.println("Błąd pliku wejściowego");
        }
    }
}
