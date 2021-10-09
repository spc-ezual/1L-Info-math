package tp.tp2;
public class exo2 {
    public static void main(String[]args) {
        float df =250;
        float dc=0;
        while(df!=-30){
            dc=df*5/9;
            dc-=160/9;
            System.out.println(df+" Degrés F ---> "+dc+" degrés C");
            df-=10;
        }
    }
    
}
