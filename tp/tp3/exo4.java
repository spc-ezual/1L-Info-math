package tp3;

public class exo4 {
    public static void main(String[] arg) {
        
    }
    public static String fig(int h ) {
    String rep=""  ;
    for (int i =0;i<2*h;i++){
        rep+=" ";
        if (i>=h){
            rep+="*";

        }
    }
    return rep;
    }
}
