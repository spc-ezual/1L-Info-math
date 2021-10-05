package démi;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class CréationMatrice {
    //taille :
    // S : 15*15
    // M : 20*20
    // L : 30*30
    // XL : 50*50

    // nombre de bombe :
    // +- 10% : 1
    // +- 20% : 2
    // +- 30% : 3
    // +- 40% : 4

    int[] taille={15,20,30,50};
    CaseDemineur[][] mat;
    public void main(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Taille (S, M, L, XL) :");
        String t=sc.next();
        int nb_alea;
        if (t=="S"){
            this.mat=new CaseDemineur[this.taille[0]][this.taille[0]];
        }
        if (t=="M"){
            this.mat=new CaseDemineur[this.taille[1]][this.taille[1]];
        }
        if (t=="L"){
            this.mat=new CaseDemineur[this.taille[2]][this.taille[2]];
        }
        if (t=="XL"){
            this.mat=new CaseDemineur[this.taille[3]][this.taille[3]];
        }
        System.out.print("Niveau de difficulter / nombre de bombe (1, 2, 3, 4) :");
        int pourcent= sc.nextInt()*10;

        for (int i =0;i<this.mat.length;i++){
            for (int j =0;j<this.mat[i].length;j++){
                nb_alea=entierAleatoire(0, 100);
                this.mat[i][j] = new CaseDemineur();
                if (nb_alea<=pourcent)this.mat[i][j].devien_une_bombe();
                if(i>0)this.mat[i][j].ajouter_g(this.mat[i-1][j]);
                if(j>0)this.mat[i][j].ajouter_h(this.mat[i][j-1]);
            }
        }
        //fait pour le moment : les matrices de case sont fait et totalement remplis 
        //bombe poser et coter fait
        // a faire :
        // faire en sorte que la premiere case ne soit pas une bombe 
        // ainsi que faire un algo pour retiré tous les blanc d'un coup https://fr.wikipedia.org/wiki/Algorithme_de_remplissage_par_diffusion cf
    sc.close();
    }
    public static int entierAleatoire(int a, int b) {
		// Retourne un entier aléatoire entre a (inclus) et b (inclus)
		return ThreadLocalRandom.current().nextInt(a, b + 1);
}
}
