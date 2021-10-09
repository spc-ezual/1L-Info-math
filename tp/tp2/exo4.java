package tp.tp2;
import java.time.LocalDateTime;
import java.util.Scanner;

public class exo4 {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        Scanner sc = new Scanner(System.in);
        int mili = now.getNano();
        int nb_alea =(mili/100)%100;
        boolean Réussi = false;
        int val;
        while(Réussi==false){
            System.out.print("valeur : ");
            val = sc.nextInt();
            if (val==nb_alea){
                Réussi = true;
            }
            else if( val< nb_alea){
                System.out.println("Trop petit !");
            }
            else{
                System.out.println("Trop grand !");
            }
        }
        System.out.println("La valeur étais bien :"+nb_alea);
        sc.close();
    }
}
