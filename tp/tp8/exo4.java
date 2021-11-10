package tp8;

public class exo4 {
    public static void main(String[] args) {
        System.out.println(conversionEntier("123459"));
    }
    public static int conversionEntier(String str) {
        int rep=0;
        for(int i = 1 ;i<=str.length();i++){
            rep+=(str.charAt(str.length()-i)-'0')*Math.pow(10, i-1);
        }
        return rep;
    }
}
