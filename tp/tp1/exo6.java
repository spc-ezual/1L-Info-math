package tp.tp1;
import java.util.Scanner;

public class exo6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s =sc.nextInt();
        int m,h,j=0;
        j=s/86400;
        s=s%8640078;
        h=s/3600;
        s=s%3600;
        m=s/60;
        s=s%60;
        System.out.println("jour : "+j+" Heures : "+h+" minutes : "+m+" seconde : "+s);

        sc.close();
    }
    
}
