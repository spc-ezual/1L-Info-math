package démi;

public class CaseDemineur {
    CaseDemineur Haut=null,Bas=null,Gauche=null,Droite=null;
    int nb_bombe;
    boolean bombe;

    void newbombe(){
        this.nb_bombe+=1;
    }

    boolean est_une_bombe(){return bombe;}

    void devien_une_bombe(){
        this.bombe=true;

    }

    void ajouter_g(CaseDemineur g){this.Gauche=g;
        if (g.Droite==null)g.ajouter_d(this);
        if(g.est_une_bombe()==true){
            this.newbombe();
        }}


    void ajouter_d(CaseDemineur d){this.Droite=d;
        if(d.Gauche==null) d.ajouter_g(this);
        if(d.est_une_bombe()==true){
            this.newbombe();
        }}


    void ajouter_h(CaseDemineur h){this.Haut=h;
        if(h.Bas==null)h.ajouter_b(this);
        if(h.est_une_bombe()==true){
            this.newbombe();
        }}


    void ajouter_b(CaseDemineur b){this.Bas=b;
        if(b.Haut==null)b.ajouter_h(this);
        if(b.est_une_bombe()==true){
            this.newbombe();
        }}
}
