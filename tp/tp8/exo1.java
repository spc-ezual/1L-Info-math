package tp8;

public class exo1 {
    public static void main(String[] args) {
        
    }
    public static int occurrence(String str,char cara){
        int rep = 0;
        for (char ca : str.toCharArray())
        {
        if (ca == cara)
        rep++;
        }
        return rep;
    }
    public static boolean estPalindrome(String str) {
        boolean rep =true;
        char cara[]=str.toCharArray();
        for(int i = 1 ; i<cara.length/2;i++){
            if(cara[i-1]!=cara[cara.length-i])rep=false;
        }
        return rep;
    }
    public static String extraireSousChaine(String str,int d, int f) {
        String rep="";
        for(int i =d ;i<=f;i++)rep+=str.charAt(i);
        return rep;
    }
    public static String remplacer(String str , char c1, char c2) {
        //return str.replace(c1, c2);
        String rep = "";
        for( char cara:str.toCharArray()){
            if(cara==c1)rep+=c2;
            else rep+= cara;
        }
        return rep;
    }
}
