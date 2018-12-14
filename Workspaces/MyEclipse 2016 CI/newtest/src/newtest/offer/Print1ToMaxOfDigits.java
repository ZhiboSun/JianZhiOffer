package newtest.offer;

public class Print1ToMaxOfDigits {
    public static void main(String[] args){
         int n= 3;
         System.out.println("start print");
         print1ToMaxOfDigits(n);
    }

    private static void print1ToMaxOfDigits(int n) {
        if(n< 0){
            return;
        }

        char[] number= new char[n];
        print1ToMaxOfDigitsRecurisity(number, n, 0);
    }

    private static void print1ToMaxOfDigitsRecurisity(char[] number, int length, int index) {
        if(index== length){
            PrintNum(number);
            return;
        }
        for(int i= 0; i< 10; i++){
            number[index]= (char)(i+ '0');
            print1ToMaxOfDigitsRecurisity(number, length, index+ 1);
        }
    }

    private static void PrintNum(char[] number) {
        boolean isBeginning0= true;
        int nLength= number.length;
        int i= 0;
        for(i= 0; i< nLength; i++){
            if(isBeginning0 && number[i]!= '0'){
                isBeginning0= false;
            }
            if(!isBeginning0){
                System.out.print(number[i]);
            }
        }
        System.out.println("");
    }
}
