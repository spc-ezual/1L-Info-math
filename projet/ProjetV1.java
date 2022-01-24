package projet;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
/** Licence:
 * 
 *  CC BY-NC-ND
 *  
 *  https://creativecommons.org/licenses/by-nc-nd/4.0/deed.fr
 *  
 */
class partie{
    static int[][] grille;
    static int hauteur=6;
    static int largeur=7;
    
    /**
     * 
     * @param tab
     * @return deep-copy de tab
     */
    public static int[][] copitab(int[][] tab) {
        /**
         * Rep est le tableaude la deep-copy de tab
         */
        int rep[][]=new int[tab.length][tab[0].length];
        for (int i = 0 ; i<tab.length;i++)for (int j = 0 ; j<tab[0].length;j++)rep[i][j]=tab[i][j];
        return rep;
    }


    /**
     * 
     * @param tab
     * 
     * @print tableau2D 
     */
    public static void afficheTab2D(int [][]tab) {
        /**
         * Utilisation d'un for each pour enumere tous les sous element du tableaux
         */
        for(int[]val:tab){
            for(int value: val){
                System.out.print(value+" ");
            }
        System.out.println("");
        }
    }


    /**
     * 
     * @param tab
     * @print tableau1D
     */
    public static void afficheTab1D(int []tab) {
        /**
         * Utilisation d'un for each pour enumere tous les sous element du tableaux
         */
        for(int value: tab){
        System.out.print(value+" ");
        }
    }


    /**
     * 
     * @param a
     * @param b
     * @return entier aleatoir entre a et b compris
     */
    public static int entierAleatoire(int a, int b){
		//Retourne un entier aléatoire entre a (inclus) et b (inclus)
		return ThreadLocalRandom.current().nextInt(a, b + 1);	
	}


    /**
     * @init grille de 0 de taille longeur*largeur
     */
    public static void initialiseGrille(){
        /**
         * Initialise la grille en fonction des variable globale en entré
         */
        grille=new int[hauteur][largeur];
        for(int i =0; i<hauteur;i++)for(int j =0;j<largeur;j++)grille[i][j]=0;
                        
    }


    /**
     * 
     * @param tab
     * @pre tab = longeur*largeur
     * @init grille <- tab
     * 
     */
    static void initialiseGrille(int[][] tab){
        /**
         * Initialise la grille avec une deep copy d'un tableau en entre 
         * Précondition tab doit etre en accord avec les variable globales
         */
        grille=copitab(tab);
    }


    /**
     * 
     * @return deep-copy de la grille actuel
     */
    public static int[][] copieGrille() {
        /**
         * Rep est une deep copy de grille
         */
        int rep[][]=new int[grille.length][grille[0].length];
        for(int i =0;i<grille.length;i++)
            for(int j =0 ; j<grille[i].length;j++)
                rep[i][j]=grille[i][j];
        return rep;
        
    }


    /**
     * 
     * @param joueur
     * @param col
     * @pre 0<=col<largeur
     * @act joue un coup dans grille
     */
    static void jouer(int joueur,int col){
        /**
         * joue un coup dans la grille dans la colone en entré 
         * Peut etre modifier pour renvoyer les coordoner du nouveaux pions pour une amelioration du projet
         */
        int ligne=0;
        while(grille[ligne][col]!=0&&ligne!=largeur-1)ligne++;
        if(ligne!=largeur-1)grille[ligne][col]=joueur;
        //return new int[]{ligne,col};
    }


    /**
     * @print grille modeliser
     */
    static void afficheGrille(){
        /**
         * Affiche la grille en replacent les element que la grille contient
         */
        String I0= "| ",I1="|X",I2="|O";
        for(int i = hauteur-1; i>=0;i--){
            for(int val :grille[i]){
                if(val==0)System.out.print(I0);
                if(val==1)System.out.print(I1);
                if(val==2)System.out.print(I2);
            }
            System.out.print("|"+System.lineSeparator());
        }
        for(int i=0;i<largeur;i++){
            System.out.print(" "+i);
        }
        System.out.println("");
    }


//--------------------------------------------------------------------------------------------------------------------------------------------
// Vérif

    /**
     * 
     * @param y
     * @param x
     * @param joueur
     * @return False si il n'y a pas 4 pions aligné a l'horizontal a partir de grille[x][y] ||
     *         True si il y a 4 pions aligné a l'horizontal a partir de grille[x][y]
     */
    static boolean aGagneHor(int y,int x,int joueur){
        /**
         * Enumere les 4 pions situer sur la droite du pions en entre compris 
         * si il sont tous les 4 egal au joueur en entré alors le joueur gagné
         */
        boolean rep;
        if(y<4&&y>=0){
            rep = grille[x][y]==joueur&&grille[x][y]==grille[x][y+1]&&grille[x][y+1]==grille[x][y+2]&&grille[x][y+2]==grille[x][y+3];
        }
        else rep=false;
        return rep;
    }


    /**
     * 
     * @param y
     * @param x
     * @param joueur
     * @return False si il n'y a pas 4 pions aligné a la verticale a partir de grille[x][y] ||
     *         True si il y a 4 pions aligné a la verticale a partir de grille[x][y]
     */
    static boolean aGagneVer(int y,int x,int joueur){
        /**
         * Enumere les 4 pions situer vers le bas en partant du pions en entre compris 
         * si il sont tous les 4 egal au joueur en entré alors le joueur gagné
         */
        boolean rep;
        if(x<3&&x>=0){
            rep = grille[x][y]==joueur&&grille[x][y]==grille[x+1][y]&&grille[x+1][y]==grille[x+2][y]&&grille[x+2][y]==grille[x+3][y];
        }
        else rep=false;
        return rep;
    }


    /**
     * 
     * @param y
     * @param x
     * @param joueur
     * @return False si il n'y a pas 4 pions aligné a la diagonal vers le haut a partir de grille[x][y] ||
     *         True si il y a 4 pions aligné a la diagonal vers le haut a partir de grille[x][y]
     */
    static boolean aGagneDiagMont(int y,int x,int joueur){
        /**
         * Enumere les 4 pions situer sur la diagonal montante en partant du pions en entre compris 
         * si il sont tous les 4 egal au joueur en entré alors le joueur gagné
         */
        boolean rep;
        if(x<3&&x>=0&&y<4&&y>=0){
            rep = grille[x][y]==joueur&&grille[x][y]==grille[x+1][y+1]&&grille[x+1][y+1]==grille[x+2][y+2]&&grille[x+2][y+2]==grille[x+3][y+3];
        }
        else rep=false;
        return rep;
    }


    /**
     * 
     * @param y
     * @param x
     * @param joueur
     * @return False si il n'y a pas 4 pions aligné a la diagonal vers le bas a partir de grille[x][y] ||
     *         True si il y a 4 pions aligné a la diagonal vers le bas a partir de grille[x][y]
     */
    static boolean aGagneDiagDesc(int y,int x,int joueur){
        /**
         * Enumere les 4 pions situer sur la diagonal desandante en partant du pions en entre compris 
         * si il sont tous les 4 egal au joueur en entré alors le joueur gagné
         */
        boolean rep;
        if(x>=3&&x<largeur-1&&y<4&&y>=0){
            rep = grille[x][y]==joueur&&grille[x][y]==grille[x-1][y+1]&&grille[x-1][y+1]==grille[x-2][y+2]&&grille[x-2][y+2]==grille[x-3][y+3];
        }
        else rep=false;
        return rep;
    }


    /**
     * 
     * @param joueur
     * @return False si le joueur n'as pas 4 pions aligné sur la grille || True si le joeur a 4 pions alligné sur la grille
     */
    static boolean aGagne(int joueur){
        /**
         * enumere tous les point et effectue toutes le verifiaction si dessus avec chacun d'eux
         * Si l'un d'entre eux mene a une serie de 4 pions successif alors l'on retourn True
         */
        boolean rep=false;
        for(int i = 0 ; i<largeur-1;i++){
            for (int j = 0 ; j<7;j++){
                rep=rep||aGagneHor(j, i, joueur)||aGagneVer(j, i, joueur)||aGagneDiagMont(j, i, joueur)||aGagneDiagDesc(j, i, joueur);
            }
        }
        return rep;
    }

    /**
     * 
     * @return False si il reste des coup jouable || True si la grille est complete
     */
    static boolean matchNul(){
        /**
         * verifie si la grille est pleine
         */
        boolean rep =true;
        for(int i = 0; i<7;i++){
            if(grille[hauteur-1][i]==0){
                rep = false;
            }
        }
        return rep;
    }
//--------------------------------------------------------------------------------------------------------------------------------------------
//Jeux


    /**
     * @act boucle de jeux pour jouer en jcj 
     */
    static void boucleJeux(){
        /**
         * Boucle qui permet de jouer elle effectue ceci a chaque tour de boucle 
         *      -   demande une colone pour jouer
         *      -   verifie si celle si est valide 
         *      -   si elle l'es :
         *              -   joue dans la colone 
         *              -   l'on change de joueur ssi le joueur actuel n'as pas gagné
         *      -   sinon message d'erreur redemande une nouvelle colone
         *   
         */
        int joueur=1;
        int coup;
        Scanner sc = new Scanner(System.in);
        do{
            afficheGrille();
            System.out.print(" Quel coup pour le joueur "+joueur+" ? ");
            coup = sc.nextInt();
            System.out.println("");
            if(coup<7&&grille[hauteur-1][coup]==0){
                jouer(joueur, coup);
                if(!aGagne(joueur))joueur=3-joueur;
            }
            else System.out.println("Ligne Complete ou indice invalide");
        }while(!(aGagne(joueur)|matchNul()));
        sc.close();
        afficheGrille();
        if(matchNul())System.out.print("Match nul");
        else System.out.print("Lejoueur "+ joueur+" a gagné");
    }


    /**
     * @init grille
     * @act lance la boucle de jeux jcj
    */
    static void LancerP() {
        /**
         * inititialise la grille et lance une partie de joueur contre joueur
         */
        initialiseGrille();
        boucleJeux();
    }

    /**
     * @act boucle de jeux pour jouer en j c IA
     */
    public static void BoucleJeuxIA(){
        /**
         *  Boucle qui permet de jouer elle effectue ceci a chaque tour de boucle 
         *      -   demande une colone pour jouer
         *      -   verifie si celle si est valide 
         *      -   si elle l'es :
         *              -   joue dans la colone 
         *              -   l'on change de joueur ssi le joueur actuel n'as pas gagné
         *      -   sinon message d'erreur redemande une nouvelle colone
         *  Si ces a l'IA de jouer alors l'on appelle une des fonction coup random
         */
        int coup,joueur;
        Scanner sc=new Scanner(System.in);
        System.out.print("Voulez-vous commencer ? (O/N)");
        String rep = sc.nextLine();
        System.out.println("");
        if(rep.equals("O")){
            joueur=1;
        }
        else {
            joueur=2;}
            do{
                if(joueur==1){afficheGrille();
                    System.out.print(" Quel coup voulez vous jouez ? ");
                    coup = sc.nextInt();
                    System.out.println("");
                    if(coup<7&&grille[hauteur-1][coup]==0){
                        jouer(joueur, coup);
                        if(!aGagne(joueur))joueur=3-joueur;
                    }
                    else System.out.println("Ligne Complete ou indice invalide");}
                else {
                    joueCoupRandom3(joueur);
                    if(!aGagne(joueur))joueur=3-joueur;}
                
            }while(!(aGagne(joueur)|matchNul()));
            afficheGrille();
            sc.close();
            if(matchNul())System.out.print("Match nul");
            else if(joueur==2){
                System.out.println("L'IA a gagné !");
            }
            else System.out.println("Vous avez gagnez !! ");
    }


    /**
     * @init grille
     * @act lance la boucle de jeux en JcIA
     */
    static void jouerIA() {
        /**
         * inititialise la grille et lance une partie de joueur contre IA
         */
        initialiseGrille();
        BoucleJeuxIA();
    }
//--------------------------------------------------------------------------------------------------------------------------------------------
// IA


    /**
     * 
     * @param joueur
     * @act joue un coup random sur a grille parmis tous les coup jouable 
     */
    public static void joueCoupRandom(int joueur){
        /**
         * joue un coup totalement alea. parmis les coup possible
         */
        int coup,rep[]=possibiliter();
        coup=entierAleatoire(0, rep[largeur]-1);
        jouer(joueur, rep[coup]);
    }


    /**
     * 
     * @param joueur
     * @act joue un coup gagnant si il existe sinon il joue un coup random 
     */
    public static void joueCoupRandom2(int joueur){
        /**
         * Appel la fonction peut finir si celle si renvois un entier autre que -1 ces que en jouant se coup l'ia peut finir alors elle le joue
         * sinon elle tire une posibiliter alea. parmis celle possible.
         */
        int coup=peutfinir(joueur);        
        if(coup==-1){
            int[] rep =possibiliter();
            coup=entierAleatoire(0, rep[largeur]-1);
            jouer(joueur, rep[coup]);}
        else jouer(joueur, coup);
    }


    /**
     * 
     * @param joueur
     *  @act joue un coup gagnant pour le joueur courant si il existe sinon joue un coup aleatoir qui ne fait pas gagné les second joueur 
     */
    public static void joueCoupRandom3(int joueur) {
        int coup=peutfinir(joueur);
        if (coup==-1){
            int tabBase[][]=copieGrille();
            int possibiliterJ[]=possibiliter();
            for (int i = 0 ; i<possibiliterJ[largeur];i++){
                jouer(joueur,possibiliterJ[i]);
                coup=peutfinir(3-joueur);
                if(coup!=-1){
                    possibiliterJ[i]=possibiliterJ[possibiliterJ[largeur]-1];
                    possibiliterJ[largeur]=possibiliterJ[largeur]-1;
                    i--;
                }
                initialiseGrille(tabBase);
            }
            if(possibiliterJ[largeur]>0){
                coup=entierAleatoire(0, possibiliterJ[largeur]-1);
                jouer(joueur, possibiliterJ[coup]);}
                else 
                jouer(joueur, possibiliterJ[0]);
            }
        else jouer(joueur, coup);
    }


    /**
     * 
     * @param joueur
     * @return le coup gagnant pour le joueur en entré si il existe sinon return -1
     */
    public static int peutfinir(int joueur) {
    int rep=-1,tabBase[][]=copieGrille();
    boolean fini=false;
    for(int i=0;i<largeur&&!fini;i++){
        if(grille[hauteur-1][i]==0){
            jouer(joueur, i);
            if(aGagne(joueur)){
                fini=true;
                rep=i;
                }
            initialiseGrille(tabBase);
            }
        }
        return rep;
    }


    /**
     * 
     * @return l'ensemble des coup jouable sous forme de tableaux et le dernier element est le nombre de coup jouable 
     */
    public static int[] possibiliter() {
        int rep[]=new int[largeur+1],nbpos=0;
        for(int i =0;i<largeur;i++){
            if(grille[hauteur-1][i]==0){
                rep[nbpos++]=i;
            }
        }
        rep[largeur]=nbpos;
        return rep;
    }
//--------------------------------------------------------------------------------------------------------------------------------------------
//Main
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("Voulez-vous jouez contre une IA ? (O/N)");
        String rep = sc.nextLine();
        System.out.println("");
        if(rep.equals("O")){
            jouerIA();;
        }
        else {
            LancerP();}
        sc.close();
    }
}