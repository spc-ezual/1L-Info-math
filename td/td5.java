package td;

public class td5 {
    public static void main(String[] args) {
        
    }
    public static int[] copieTab(int[] tab) {
        int rep[]=new int[tab.length];
        for (int i = 0 ; i<tab.length;i++)rep[i]=tab[i];
        return rep;
    }
    public static char[] compareTab(int[] tab1, int[] tab2) {
        char rep[]=new char[tab1.length];
        for (int i =0;i<tab1.length;i++){
            if(tab1[i]<tab2[i])rep[i]='<';
            else if(tab1[i]>tab2[i])rep[i]='>';
            else rep[i]='=';
        }
        return rep;
    }
}
