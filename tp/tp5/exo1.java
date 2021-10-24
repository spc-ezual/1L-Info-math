package tp5;

class exo1{
    public static void main(String[] args){

    }
    public static int[] copieTableau(int[] tab) {
        int rep[]=new int[tab.length];
        System.arraycopy(tab, 0, rep, 0, tab.length);
        return rep;
    }
    public static int[] sousTableau(int[] tab , int i , int j) {
        int [] rep= new int[j-i];
        System.arraycopy(tab, i, rep, 0, j-i);
        return rep;
    }
    public static int[] concatenation( int[] tab, int[] tab2) {
        int rep []= new int[tab.length+tab2.length];
        System.arraycopy(tab, 0, rep, 0, tab.length);
        System.arraycopy(tab2, 0, rep, tab.length, tab2.length);
        return rep;
    }
    public static int[] fusion2tab(int[] tab ,int[ ]tab2) {
        int[]rep=new int[tab.length+tab2.length];
        int tl1=0,tl2=0;
        while(tl1<tab.length&&tl2<tab2.length){
            rep[tl1+tl2]=tab[tl1];
            rep[tl1+tl2+1]=tab2[tl2];
            tl1++;
            tl2++;
        }
        if (tl1<tab.length)System.arraycopy(tab, tl1, rep, tl1+tl2, tab.length-tl1);
        else if (tl2<tab2.length)System.arraycopy(tab2, tl2, rep, tl1+tl2, tab2.length-tl2);
        return rep;
        
    }
}