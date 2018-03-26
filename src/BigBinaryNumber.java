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
}
