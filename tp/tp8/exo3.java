package tp8;

public class exo3 {
    public static void main(String[] args) {
        System.out.println(comptageMot("Le si et le la en cle de fa", 2));
    }
    public static int comptageMot(String str,int n) {
        String[] mot=str.split(" ");
        int rep =0;
        for (int i = 0 ; i<mot.length;i++)if(mot[i].length()==n)rep+=1;
        return rep;
    }
}
