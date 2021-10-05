package démi;

public class CaseDemiv1 {
    CaseDemiv1 Haut=null,Bas=null,Gauche=null,Droite=null;
    int nb_bombe;
    boolean bombe;

    void newbombe(){
        this.nb_bombe+=1;
    }

    boolean est_une_bombe(){return bombe;}

    void devien_une_bombe(){
        this.bombe=true;

    }

    void ajouter_g(CaseDemiv1 g){this.Gauche=g;
        if(g.est_une_bombe()==true){
            this.newbombe();
        }}


    void ajouter_d(CaseDemiv1 d){this.Droite=d;
        if(d.est_une_bombe()==true){
            this.newbombe();
        }}


    void ajouter_h(CaseDemiv1 h){this.Haut=h;
        if(h.est_une_bombe()==true){
            this.newbombe();
        }}


    void ajouter_b(CaseDemiv1 b){this.Bas=b;
        if(b.est_une_bombe()==true){
            this.newbombe();
        }}

    
    void CaseDemiv1(CaseDemiv1 h,CaseDemiv1 b,CaseDemiv1 g,CaseDemiv1 d){
        if (b!=null){
            this.Bas=b;
            b.ajouter_h(this);
            if(b.est_une_bombe()==true){
                this.newbombe();
            }
        }
        if (h!=null){
            this.Haut=h;
            h.ajouter_b(this);
            if(h.est_une_bombe()==true){
                this.newbombe();
            }
        }
        if(g!=null){
            this.Gauche=g;
            g.ajouter_d(this);
            if(g.est_une_bombe()==true){
                this.newbombe();
            }
        }
        if(d!=null){
            this.Droite=d;
            d.ajouter_g(this);
            if(d.est_une_bombe()==true){
                this.newbombe();
            }
        }
    }
}
