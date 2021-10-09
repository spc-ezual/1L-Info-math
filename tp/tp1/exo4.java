package tp.tp1;

import java.util.Scanner;

public class exo4 {
    public static void main( String[] args) {
        Scanner sc = new Scanner(System.in);
        int somme=0;
        for (int i=0 ; i<3 ; i++){
            System.out.println("valeur "+i+":");
            somme+= sc.nextInt();
        }
        if (somme%2==0)System.out.println("La somme est paire");
        else System.out.println("la somme n'est pas paire");
        sc.close();
    }
}
