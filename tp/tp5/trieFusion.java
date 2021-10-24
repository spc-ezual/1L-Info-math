package tp5;
//15 min
public class trieFusion {
    public static void main(String[] args){
        afficheTab(trie_fusion(new int[] {1,2,4,5,7,6,4,8,1}));
    }
    public static int[] trie_fusion( int[] tab) {
        if(tab.length==1)return tab;
        int imillieu=(tab.length+1)/2;
        int[] g= new int[imillieu], d = new int[tab.length-imillieu];
        System.arraycopy(tab, 0, g, 0, imillieu);
        System.arraycopy(tab, imillieu, d, 0, tab.length-imillieu);
        int[] tg = trie_fusion(g);
        int[] td = trie_fusion(d);
        return fusion(tg, td);
    }
    public static int[] fusion(int[] tab , int[] tab2) {
        int[] rep = new int[ tab.length+tab2.length];
        int tl1 = 0 , tl2 =0 , actuel = 0;
        while (tl1<tab.length&&tl2<tab2.length){
            if ( tab[tl1]<tab2[tl2])rep[actuel++]=tab[tl1++];
            else rep[actuel++]=tab2[tl2++];
        }
        if (tl1<tab.length)System.arraycopy(tab, tl1, rep, actuel, tab.length-tl1);
        else if ( tl2 < tab2.length)System.arraycopy(tab2, tl2, rep, actuel, tab2.length-tl2);
        return rep;
    }


    public static void afficheTab(int []tab) {
        for(int value: tab){
            System.out.print(value+" ");
        }
    System.out.println("");
}
}
