package tp.tp2;

import java.util.Scanner;

public class exo5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("valeur h : ");
        int h = sc.nextInt();
        String f1="",f2="",f3="",f4="",f5="";
        String newl=System.getProperty("line.separator");
        f1=fig1(h);
        f2=fig2(h);
        f3=fig3(h);
        f4=fig4(h);
        f5=fig5(h);
        System.out.print(f1+newl+f2+newl+f3+newl+f4+newl+f5);
        sc.close();

    }
    private static String fig1(int h) {
        String f1="",rep="";
        String newl=System.getProperty("line.separator");
        for (int i=h;i>0;i-- ){
            f1="";
            for (int j =0;j<i;j++){
                f1+="*";

            }
            rep=rep+newl+f1;
    }
        return rep;
        
    }
    private static String fig2(int h) {
        String rep="",f2="",saut=System.getProperty("line.separator");
        for (int i =0;i<h;i++){
            f2="";

            if (i==0 || i==h-1){
                
                for (int j =0;j<h;j++){
                    f2+="*";
            }
        }
        else{
            f2="*";
            for (int j =0; j<h-2;j++){
                f2+=" ";

            }
            f2+="*";
        }
        rep=rep+saut+f2;
        }
        return rep;
        
    }

    private static String fig3(int h) {
        String rep="",f3="",saut=System.getProperty("line.separator");
        for ( int i =0;i<h;i++){
            f3+="*";
        }
        rep=rep+saut+f3;
        for (int i =h-2;i>0;i--){
            f3="";
            for (int j =i ; j>0;j--){
                f3+=" ";
            }
            f3+="*";
            rep+=saut+f3;
        }
        f3="";
        for ( int i =0;i<=h;i++){
            f3+="*";
        }
        rep=rep+saut+f3;
        return rep;
        
    }
    private static String fig4(int h ){
        String rep="",f4="",saut=System.getProperty("line.separator");
        for (int i =h;i>0;i--){
            f4="";
            for (int j=i;j!=0;j-- ){
                f4+=" ";
            }
            f4+="*";
            for (int j =i;j<h;j++){
                f4+="**";
            }
            rep+=saut+f4;
        }
        return rep;
    }
    private static String fig5(int h){
        String rep="",f5="",saut=System.getProperty("line.separator");
        for (int i =0;i<h;i++){
            f5="";
            for(int j =0;j<h;j++ ){
            if (j==0 || j==h-1)f5+="*";
            else if(j==i) f5+="*";
            else f5+=" ";}

            rep+=saut+f5;
        }

        return rep;
    }
}
