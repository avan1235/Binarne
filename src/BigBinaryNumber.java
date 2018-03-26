import javax.swing.plaf.PanelUI;

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
            if(this.number.charAt(i) =='i')
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

    public boolean ifDividedByEight(){
        return (this.number.charAt(this.number.length() - 1) == '0') && (this.number.charAt(this.number.length() - 2) == '0') && (this.number.charAt(this.number.length() - 3) == '0');
    }

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
}
