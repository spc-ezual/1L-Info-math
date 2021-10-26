package td.td1;
import java.util.Scanner;

class exo1 {
    public static void main(String [] args) {
        System.out.print("entier : ");
        Scanner sc = new Scanner(System.in);
        int val = LireEntier(sc);
        System.out.println(carré(val));

    }
    public static int LireEntier(Scanner sc) {
        int val = sc.nextInt();
        return val;        
    }
    public static int carré(int a) {
        return a*a;
    }
}
