package tp6;

public class exo3 {
    public static void main(String[] args) {

    }
    public static void affichePoly(double[] tab) {
        int puissance = 0;
        for(double val : tab){
            if (puissance==0)System.out.print(val);
            else if ( puissance ==1)System.out.print(val+"x");
            else System.out.print(val+"x^"+puissance);
            puissance++;
        }
    }
    public static double evaluePoly(int[] tab , double y) {
        double rep=0;
        for (int i = 0;i<tab.length;i++){
            if (i==0){
                rep+=tab[i];
            }
            else rep+=tab[i]*Math.pow(y, i);
        }
        return rep;
    }
    public static double[] additionPoly(double[] tab1,double[] tab2) {
        double rep[];
        if(tab1.length<tab2.length) {
            rep=new double[tab2.length];
        }
        else {
            rep=new double[tab1.length];
        }
        int idi1=0;
        while(idi1<tab1.length&&idi1<tab2.length){
            rep[idi1]=tab1[idi1]+tab2[idi1++];
        }
        if(idi1<tab1.length){
            while(idi1<tab1.length)rep[idi1]=tab1[idi1++];
        }
        else if(idi1<tab2.length){
            while ( idi1<tab2.length)rep[idi1]=tab2[idi1++];
        }
        return rep;
    }
    
}
