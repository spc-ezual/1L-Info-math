package tp3;

public class exo1 {
    public static void main(String[] args) {
       String normal=lettre_N(97, 26),inverse=lettre_inv(90, 26) ;
        System.out.println(normal);
        System.out.println(inverse);
    }
    public static String lettre_N(int debut ,int longeur) {
        String rep="";
        String newl=System.getProperty("line.separator");
        for (int i =debut; i<(debut+longeur);i++){
            rep+=" ["+i+"] = "+(char)i;
            if (i%5==0)rep+=newl;
        }
        return rep;
    }
    public static String lettre_inv(int debut ,int longeur) {
        String rep="";
        String newl=System.getProperty("line.separator");
        for (int i =debut; i>(debut-longeur);i--){
            rep+=" ["+i+"] = "+(char)i;
            if (i%5==0)rep+=newl;            
        }
        return rep;
    }
}
