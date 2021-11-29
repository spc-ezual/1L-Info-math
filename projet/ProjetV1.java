import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
class partie{
    static int[][] grille;
    static int hauteur=6;
    static int largeur=7;

    public static int entierAleatoire(int a, int b){
		//Retourne un entier aléatoire entre a (inclus) et b (inclus)
		return ThreadLocalRandom.current().nextInt(a, b + 1);	
	}
    public static void initialiseGrille(){
        grille=new int[hauteur][largeur];
        for(int i =0; i<hauteur;i++)for(int j =0;j<largeur;j++)grille[i][j]=0;
                        
    }
    static void initialiseGrille(int[][] tab){
        grille=tab.clone();
    }
    public static int[][] copieGrille() {
        int rep[][]=new int[grille.length][grille[0].length];
        for(int i =0;i<grille.length;i++)
            for(int j =0 ; j<grille[i].length;j++)
                rep[i][j]=grille[i][j];
        return rep;
        
    }
    static int[] jouer(int joueur,int col){
        int ligne=0;
        while(grille[ligne][col]!=0&&ligne!=largeur-1)ligne++;
        if(ligne!=largeur-1)grille[ligne][col]=joueur;
        return new int[]{ligne,col};
    }
    static void afficheGrille(){
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
//----------------------------------------------------------------------------------------------------------------
// Vérif
    static boolean aGagneHor(int y,int x,int joueur){
        boolean rep;
        if(y<4&&y>=0){
            rep = grille[x][y]==joueur&&grille[x][y]==grille[x][y+1]&&grille[x][y+1]==grille[x][y+2]&&grille[x][y+2]==grille[x][y+3];
        }
        else rep=false;
        return rep;
    }
    static boolean aGagneVer(int y,int x,int joueur){
        boolean rep;
        if(x<3&&x>=0){
            rep = grille[x][y]==joueur&&grille[x][y]==grille[x+1][y]&&grille[x+1][y]==grille[x+2][y]&&grille[x+2][y]==grille[x+3][y];
        }
        else rep=false;
        return rep;
    }
    static boolean aGagneDiagMont(int y,int x,int joueur){
        boolean rep;
        if(x<3&&x>=0&&y<4&&y>=0){
            rep = grille[x][y]==joueur&&grille[x][y]==grille[x+1][y+1]&&grille[x+1][y+1]==grille[x+2][y+2]&&grille[x+2][y+2]==grille[x+3][y+3];
        }
        else rep=false;
        return rep;
    }
    static boolean aGagneDiagDesc(int y,int x,int joueur){
        boolean rep;
        if(x>=3&&x<largeur-1&&y<4&&y>=0){
            rep = grille[x][y]==joueur&&grille[x][y]==grille[x-1][y+1]&&grille[x-1][y+1]==grille[x-2][y+2]&&grille[x-2][y+2]==grille[x-3][y+3];
        }
        else rep=false;
        return rep;
    }

    static boolean aGagne(int joueur){
        boolean rep=false;
        for(int i = 0 ; i<largeur-1;i++){
            for (int j = 0 ; j<7;j++){
                rep=rep||aGagneHor(j, i, joueur)||aGagneVer(j, i, joueur)||aGagneDiagMont(j, i, joueur)||aGagneDiagDesc(j, i, joueur);
            }
        }
        return rep;
    }
    static boolean matchNul(){
        boolean rep =true;
        for(int i = 0; i<7;i++){
            if(grille[hauteur-1][i]==0){
                rep = false;
            }
        }
        return rep;
    }
//----------------------------------------------------------------------------------------------------
//Jeux
    static void boucleJeux(){
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

    static void jouer() {
        initialiseGrille();
        boucleJeux();
    }

//-------------------------------------------------------------------------------------
// IA
    public static void joueCoupRandom(int joueur){
        int coup,NBrep=0;
        int[] rep=new int[largeur];
        for(int i=0;i<largeur;i++){
            if(grille[hauteur-1][i]==0){
                rep[NBrep]=i;
                NBrep++;
            }
        }
        coup=entierAleatoire(0, NBrep-1);
        jouer(joueur, rep[coup]);
    }
    public static void BoucleJeuxIA(){
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
                    joueCoupRandom2(joueur);
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
    static void jouerIA() {
        initialiseGrille();
        BoucleJeuxIA();
    }
    public static void joueCoupRandom2(int joueur){

        int coup=0,NBrep=0,rep[]=new int[largeur],tabBase[][]=copieGrille();
        boolean fini=false;

        for(int i=0;i<largeur;i++){
            if(grille[hauteur-1][i]==0){
                rep[NBrep]=i;
                NBrep++;
                System.out.println(rep[i]);
            }
        }

        for(int i =0;(i<NBrep)||fini;i++){
            jouer(joueur, rep[i]);
            afficheGrille();
            if(aGagne(joueur)){
                fini=true;
                coup=i;
            }
            initialiseGrille(tabBase);
        }

        if(!fini)coup=entierAleatoire( 0, NBrep-1);
        initialiseGrille(tabBase);
        jouer(joueur, rep[coup]);
    }

//---------------------------------------------------------------------------
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
            jouer();}
        sc.close();
    }
}