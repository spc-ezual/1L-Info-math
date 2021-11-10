package tp6;

public class exo1 {
    public static void main(String[] args) {
        System.out.println(variance(new int[] {3,7,6,18}));
    }
    public static double moyenne(int[ ] tab) {
        double toto=0;
        for (int val : tab)toto+=val;
        toto/=tab.length;
        return toto;
    }
    public static double variance(int[]tab) {
        double var=0,moy=moyenne(tab);
        for ( int val : tab)var+=(val-moy)*(val-moy);
        var/=(tab.length-1);
        return var;
    }
}