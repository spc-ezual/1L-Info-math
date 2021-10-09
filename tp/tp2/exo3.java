package tp.tp2;

import java.util.Scanner;

public class exo3 {
    public static void main(String[]args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int Somme= Add(n);
        System.out.println("La somme est de : "+Somme);
        sc.close();
    }
    private static int Add(int n ){
        int a=0;
        while ( n !=0){
            a+=n;
            n--;
        }
        return a;
    }
}
