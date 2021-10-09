package tp.tp1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class exo5 {
    public static void main(String[] args) {
        ArrayList arrayy = new ArrayList();
        Scanner sc = new Scanner(System.in);
        System.out.println("nombre de valeur a trier:");
        int nb= sc.nextInt();
        int i =0;
        int val = 0 ;
        while( i<nb){
            System.out.println("valeur n°"+i+" : ");
            val = sc.nextInt();
            arrayy.add(val);
            i++;

        }
        Collections.sort(arrayy);
        int longeur = arrayy.size();
        String rep ="";
        rep +=arrayy.get(0);


        for(int j =1 ; j<longeur;j++){
            rep+="<="+arrayy.get(j);

        }
        System.out.println(rep);

        


    }
    
}
