package td;
class td6{
    public static void main(String[] args) {
        afficheTab(new int[][] {{1,2,3,4,5,6},{1,2,4,5},{7,8,9,4,6},{7,8,9,5,7}});
        System.out.println(compareTab(new int[][] {{1,2,3,4,5,6},{1,2,4,5}}, new int[][] {{1,2,3,4,5,6},{1,2,4,5}}));        
        System.out.println(compareTab(new int[][] {{1,2,3,4,5,6},{1,2,4,5}}, new int[][] {{1,2,3,4,5},{1,2,4,5}}));
        afficheTab(copiTab(new int[][] {{1,2,3,4,5,6},{1,2,4,5}}));
        System.out.println(sommeLigne(new int[][] {{1,2,3,4,5,6},{1,2,4,5}},1));
        System.out.println(sommeLigne(new int[][] {{1,2,3,4,5,6},{1,2,4,5}},2));
    }
    public static void afficheTab(int [][]tab) {
        for(int[]val:tab){
            for(int value: val){
                System.out.print(value+" ");
            }
        System.out.println("");
        }
    }
    public static boolean compareTab(int[][]tab,int[][] tab2) {
        /*
         * import java.util.Arrays;
         * return Arrays.equals(tab, tab2)
        */
        boolean rep=true;
        try{
            for(int i = 0 ;i<tab.length;i++ ){
                for(int j = 0 ; j<tab[i].length;j++){
                    if(tab[i][j]!=tab2[i][j])rep=false;
                }
            }
        }
        catch(Exception Index­Out­Of­Bounds­Exception){
            rep=false;
        }
        return rep;
    }

    public static int[][] copiTab(int[][] tab) {
        int[][] rep=new int[tab.length][];
        for (int i =0;i<tab.length;i++){
            rep[i]=new int[tab[i].length];
            for (int j =0;j<tab[i].length;j++){
                rep[i][j]=tab[i][j];
            }
        }
        return rep;
    }
    public static int sommeLigne(int[][] tab , int ligne) {
        int rep=0;
        try{
            for(int i = 0;i<tab[ligne].length;i++)rep+=tab[ligne][i];
        }
        catch(Exception Index­Out­Of­Bounds­Exception){}
        return rep;
        }
        
    }