package tp.tp1;
import java.util.Scanner;
import java.lang.Math;

class Exe2 {
	//Sasie et opérations de base

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int a,b;
        System.out.println(" valeur de a :");
        a=sc.nextInt();
        System.out.println(" valeur de b :");
        b=sc.nextInt();
        int c = a;
        a=b;
        b=c;
        System.out.println("valeur de a : "+a+" valeur de b : "+b);
        System.out.println(a*2);
        System.out.println(b/2);
        System.out.println("quotien :" +(a/b)+" reste : "+ a%b);
        System.out.println("max"+Math.max(a,b));
        

        





		sc.close();
	}
}
