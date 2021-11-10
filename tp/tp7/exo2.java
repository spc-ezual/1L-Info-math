package tp7;

public class exo2 {
    public static void main(String[] args) {
        
    }
    public static boolean verifierLignes(int[][]tab) {
        boolean rep =true;
        int sommebase,somme2=0;
        for(int[] soustab:tab){
            sommebase=somme2;
            somme2=0;
            for(int valu : soustab){
                somme2+=valu;
            }
            if(sommebase!=0&&somme2!=sommebase){
                rep=false;
            }
        }
        return rep;
    }
        /**
         * @param tab
         * @pre les sous-tableaux de tab sont tous de la meme taille
         */
    public static boolean verifierColonnes(int[][]tab) {
        boolean rep=true;
        int sommebase,somme2=0;
        for(int i = 0 ;i<tab[0].length;i++){
            sommebase=somme2;
            somme2=0;
            for(int j = 0 ; j<tab.length;j++){
                somme2+=tab[j][i];
            }
            if(sommebase!=0&&somme2!=sommebase){
                rep=false;
            }
        }
        return rep;
    }
    /**
     * @param tab
     * @pre les sous-tableaux de tab sont tous de la meme taille
     */
    public static boolean estMagique(int[][] tab) {
        return verifierColonnes(tab)&&verifierLignes(tab);
    }
}