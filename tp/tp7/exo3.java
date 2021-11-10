package tp7;

public class exo3 {
    public static void main(String[]args) {
        
    }
    /**
     * 
     * @param tab
     * @pre les sous-tableaux de tab on tous la meme taille
     */
    public static boolean estNormal(int[][]tab) {
        boolean rep=true;
        boolean[] estla =new boolean[tab.length*tab[0].length];
        init_false(estla);
        for(int[]soustab:tab){
            for(int val : soustab){
                if(val>(tab.length*tab[0].length) && val < 1 && estla[val]==true){
                    rep=false;
                }
                else {
                    estla[val]=true;
                }
            }
        }
        return rep;
    }
    static void init_false(boolean[]tab){
        for(int i = 0;i<tab.length;i++)
        tab[i]=false;}
}
