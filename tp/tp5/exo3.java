package tp5;

public class exo3 {
    
    public static void afficheTab(int []tab) {
            for(int value: tab){
                System.out.print(value+" ");
            }
        System.out.println("");
    }
    public static void main(String[] args){
        System.out.println(estPermutation(new int[]{1,3,4,2,0}));
        afficheTab(compose(new int[]{1,3,4,2,0}, new int[]{1,0,2,4,3}));
        afficheTab(inverse(new int[]{1,3,4,2,0}));
        System.out.println(iere(new int[]{1,3,4,2,0}, 0, 2));
    }
    public static boolean estPermutation(int[] tab) {
        boolean rep=true;
        int ad=0;
        for(int val : tab){
            if (val<0)rep=false;
            ad+=val;
        }
        if(ad!=(tab.length*(tab.length-1))/2)rep=false;
        return rep;
    }
    public static int[] compose(int[] tab, int[] tab2) {
        int [] rep = new int[tab.length];
        for ( int j = 0 ; j < tab.length;j++)
        rep[j]= tab2[tab[j]];
        return rep;
    }
    public static int[] inverse(int[] tab) {
        int[] rep = new int[tab.length];
        for (int i = 0 ; i< tab.length;i++)
        rep[tab[i]]=i;
        return rep;
    }
    // question bonus : on otien le tableau  de longeur n trié .
    //23 min sans Challenge
    public static int iere(int[] tab ,int i ,int j) {
        int rep= 0;
        if ( j > 0){
            rep=tab[i];
            j--;
        }
        while(j!=0){
            rep=tab[rep];
            j--;
        }
        return rep;
    }
    //7min chall.
}
