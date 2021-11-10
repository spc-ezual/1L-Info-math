package tp7;

public class exo4 {
    public static void main(String[]args) {
        
    }
    /**
     * 
     * @param tab
     * @param tab2
     * @pre taille tab == taille tab2
     * @return tab+tab2
     */
    public static int[][] sommeRectangles(int[][] tab,int[][]tab2) {
        int rep[][]=new int[tab.length][];
        for(int i = 0 ; i<tab.length;i++){
            rep[i]=new int[tab[i].length];
            for(int j =0;j<tab[i].length;j++){
                rep[i][j]=tab[i][j]+tab2[i][j];
            }
        }
        return rep;
    }
    public static int[][] symetrieHorizontale(int[][] tab) {
        int[][]rep=new int[tab.length][];
        for(int i = 1 ; i<=tab.length;i++){
            rep[i]=new int[tab[(tab.length)-i].length];
            for(int j = 0;j<tab[(tab.length)-i].length;j++){
                rep[i][j]=tab[tab.length-i][j];
            }
        }
        return rep;
    }
    
}
