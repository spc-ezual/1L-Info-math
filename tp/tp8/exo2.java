package tp8;

public class exo2 {
    public static void main(String[] args) {
        
    }
    public static boolean estMajuscule(char cara) {
        boolean rep = false;
        if(cara<91&&cara>64)rep=true;
        return rep;
    }
    public static boolean estMinuscule(char cara) {
        boolean rep = false;
        if(cara<123&&cara>96)rep=true;
        return rep;
    }
    public static char minusculeChar(char cara) {
        if(estMajuscule(cara)){
            int valCara=cara;
            cara=(char)(valCara+32);
        }
        return cara;
    }
    public static char majusculeChar(char cara) {
        if(estMinuscule(cara)){
            int valCara=cara;
            cara=(char)(valCara-32);
        }
        return cara;
    }
    public static String minusculeChaine(String str) {
        //return str.toLowerCase();
        String rep="";
        for(char cara : str.toCharArray())rep+=minusculeChar(cara);
        return rep;
    }
    public static String majusculeChaine(String str) {
        //return str.toUpperCase();
        String rep="";
        for(char cara : str.toCharArray())rep+=majusculeChar(cara);
        return rep;
    }
}
