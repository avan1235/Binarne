import java.math.BigInteger;
import java.security.PublicKey;

/**
 * Created by Maciej Procyk on 26.03.2018.
 */
public class BigBinaryNumber {
    private String number;

    BigBinaryNumber(String number){
        this.number = number;
    }

    BigBinaryNumber(int number){
        this.number = Integer.toString(number);
    }

    BigBinaryNumber(long number){
        this.number = Long.toString(number);
    }

    public String getValue(){
        return this.number;
    }

    public int howManyZeros(){
        int hMZ = 0;
        for(int i = 0; i<this.number.length(); i++){
            if(this.number.charAt(i) == '0')
                hMZ++;
        }

        return hMZ;
    }

    public int howManyOnes(){
        int hMO = 0;
        for(int i = 0; i<this.number.length(); i++){
            if(this.number.charAt(i) =='1')
                hMO++;
        }

        return hMO;
    }

    public int length(){
        return this.number.length();
    }

    public boolean ifDividedByTwo(){
        return this.number.charAt(this.number.length() - 1) == '0';
    }

    /**
     * Przy dzieleniu przez osiem wymaga się, by trzy ostatnie cyfry były zerami
     */

    public boolean ifDividedByEight(){
        return (this.number.charAt(this.number.length() - 1) == '0') && (this.number.charAt(this.number.length() - 2) == '0') && (this.number.charAt(this.number.length() - 3) == '0');
    }

    /**
     * Porównywanie dwóch liczb, z których jedna jest aktualnym aobiektem, a druga to obiekt będący argumentem
     * funkcji, do którego wartości .number mamy dostęp, gdyż jest członkiem tej samej klasy
     *
     * Jeżeli secondNumber jest mniejsza, zwraca 1, jak jest większa zwraca -1, a gdy równe liczby zwraca 0
     */

    public int compareTo(BigBinaryNumber secondNumber){
        if (this.number.length() > secondNumber.number.length())
            return 1;
        else if (this.number.length() == secondNumber.number.length()){
            for (int i = 0; i<this.number.length(); i++){
                if(this.number.charAt(i) != secondNumber.number.charAt(i)){
                    if (this.number.charAt(i) == '1')
                        return 1;
                    else
                        return -1;
                }
            }
            return 0;
        }
        else
            return -1;
    }

    public BigBinaryNumber add(BigBinaryNumber secondNumber){
        StringBuilder result = new StringBuilder();
        int len = (this.length()>secondNumber.length()?this.length():secondNumber.length());
        int actBuffor = 0;
        int toRemember = 0;
        for (int i = 1; i <= len; i++){
            actBuffor = 0;

            if (this.length()-i >= 0)
                actBuffor += Character.getNumericValue(this.getValue().charAt(this.length()-i));
            if (secondNumber.length()-i >= 0)
                actBuffor += Character.getNumericValue(secondNumber.getValue().charAt(secondNumber.length()-i));

            actBuffor += toRemember;

            if (actBuffor%2 == 0)
                result.append("0");
            else
                result.append("1");

            if (actBuffor > 1)
                toRemember = 1;
            else
                toRemember = 0;
        }
        if (toRemember == 1)
            result.append("1");

        String resultNumber = result.reverse().toString();
        BigBinaryNumber toReturn = new BigBinaryNumber(resultNumber);
        return toReturn;
    }

    public BigInteger toBigInteger(){
        BigInteger number = BigInteger.valueOf(0);
        BigInteger multiplay = BigInteger.valueOf(1);

        for(int i = 1; i <= this.length(); i++){
            number = number.add(multiplay.multiply(BigInteger.valueOf(Character.getNumericValue(this.getValue().charAt(this.length()-i)))));
            multiplay = multiplay.multiply(BigInteger.valueOf(2));
        }

        return number;
    }
}
