package tp4;

import java.util.Scanner;

public class exo1 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Valeur i :");
        int i=sc.nextInt();
        System.out.println("Valeur J :");
        int j = sc.nextInt();
        int[] tab={};
        System.out.print(echange(tab, i, j));
        sc.close();
    }
    public static int[] echange(int[] tab,int i,int j){
        int a=tab[i];
        tab[i]=tab[j];
        tab[j]=a;
        return tab;
    }
}
