package tp3;
import java.util.Scanner;


public class exo3 {
    public static void print(char affiche) {
        System.out.print(affiche);
    }  
    public static void saut_L(String affiche) {
        System.out.println("");
    }  
    
    public static void main(String[] arg) throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.print("taille n :");
        int n = sc.nextInt();
        System.out.print("Ligne :");
        int i = sc.nextInt();
        if (n>26 || n<1){
            sc.close();
            throw new cara_exception();            
            }
        System.out.println(ligne(i-1,n,i-1,0)+System.getProperty("line.separator"));
        System.out.println(cible(n));
        sc.close();
    }
    
    public static String ligne(int i , int n, int base , int longu) {
        // i : ligne 
        // n : taille
        // base : i de base 
        // longu : longeur
        String rep="";
        if (i<1)i=1;
        if (longu<=n-1){
            rep+=(char)('a'+(base-i))+" ";
            if (longu!=n-1){
                rep+=ligne(i-1, n, base, longu+1);
                rep+=(char)('a'+(base-i))+" ";
                }
            }
        return rep;
    }
    public static String cible(int n) {
        String rep="";
        for (int i =0;i<=n;i++){
            rep+= ligne(i, n, i, 0)+System.getProperty("line.separator");
        }
        for (int i = n-1;i!=0;i--)rep+=ligne(i, n, i, 0)+System.getProperty("line.separator");
        return rep;
    }
//System.getProperty("line.separator")
    
}
