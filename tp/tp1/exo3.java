package tp.tp1;
import java.util.Scanner;

public class exo3{
    public static void main(String[] args ) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Année :");
        int a ;
        a= sc.nextInt();
        if ((a%4==0 & a%100!=0)||a%400==0){
            System.out.println(a+" est une année bis.");
        }
        else{
            System.out.println(a+" n'est pas une année bis.");
        }
        sc.close();
        
    }
}
