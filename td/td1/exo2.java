/**package td1;

import java.util.Scanner;

public class exo2 {
    public static void main(String[] arg) throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.print("taille n :");
        int n = sc.nextInt();
        if (n>26){
            sc.close();
            throw new cara_exception();            
            }
        sc.close();
        affiche(n, 0);
    }
    public static void affiche(int n ,int l) {
        int l2=0;
        String s="";
        //faire la chaine de cara
        
        int vl=l;
        //s+=(char)97;
        System.out.println(s);
        if (l!=n){
            affiche(n, l+1);
            System.out.println(s);
        }

    }
}
*/