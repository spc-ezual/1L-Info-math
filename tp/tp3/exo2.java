package tp3;

public class exo2 {
    public static void println(String affiche) {
        System.out.println(affiche);
    }    
    public static void main(String[] args) {
        String rep1="",rep2="",rep3="";
        rep1+=impot(32000.0);
        println(rep1);
        rep2+=pourcent_impot(32000.0);
        println(rep2);
        rep3+=gainMariage(15000.0,10000.0);
        println(rep3);

    }
    public static Double impot(Double salaire) {
        double rep=0;
        boolean f = false;
        Double[] tab_impot= {0.0,10064.0,25659.0,73369.0,157805.0,Double.POSITIVE_INFINITY},pourcent={0.0,11.0,30.0,41.0,45.0};
        for ( int i=1; i<tab_impot.length;i++){
            if (salaire>tab_impot[i]){
                    rep+=(tab_impot[i]-tab_impot[i-1])*pourcent[i-1]/100;
                    }
            
            else if (f==false){
                rep+=(salaire-tab_impot[i-1])*pourcent[i-1]/100;
                f=true;}
                
        }
        return rep;
        
    }
    public static double pourcent_impot(double salaire) {
        double rep=0;
        double imp=impot(salaire);
        rep=(imp/salaire)*100;
        return rep;
    }
    public static double gainMariage(double salaire1,double salaire2) {
        double rep=0;
        rep+=impot(salaire1)+impot(salaire2);
        rep-=impot((salaire1+salaire2)/2);
        return rep;
    }
}
