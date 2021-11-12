package tp9;

import java.util.concurrent.ThreadLocalRandom;
import tp9.outils.*;

public class TP9 {

	// Méthode fourni par le squelette
	public static int entierAleatoire(int a, int b){
		//Retourne un entier aléatoire entre a (inclus) et b (inclus)
		return ThreadLocalRandom.current().nextInt(a, b + 1);
	}

	public static void verifierPixel(Pixel p) {
		if(p.r<0)p.r=0;
		if(p.r>255)p.r=255;
		if(p.b<0)p.b=0;
		if(p.b>255)p.b=255;
		if(p.v<0)p.v=0;
		if(p.v>255)p.v=255;
	}

	/**
	 * 
	 * @param m
	 * @param n
	 * @pre n>50 m>50
	 */
	public static BitMap simpleRectangle(int n , int m) {
		BitMap rep = BitMap.blanche(n, m);
		for(int i = 10 ; i<n-10;i++){
			for(int j =10;j<=20;j++){
				rep.set(i,j,new Pixel(0,0,0));
				rep.set(i,m-j-1,new Pixel(0,0,0));
			}
		}
		for(int j =20;j<m-20;j++){
			for(int i =10; i<20;i++){
				rep.set(i,j,new Pixel(0,0,0));
				rep.set(n-i-1,j,new Pixel(0,0,0));
			}
		}
		return rep;
	}

	public static BitMap simpleCroix(int n,int m) {
		BitMap rep = BitMap.blanche(n, m);
		for(int i =n/2-5;i<=n/2+5;i++){
			for(int j = 10; j<m-10;j++){
				rep.set(i,j,new Pixel(0,0,0));
			}
		}
		for(int i = 10 ; i<n-10;i++){
			for(int j = m/2-5;j<=m/2+5;j++){
				rep.set(i,j,new Pixel(0,0,0));
			}
		}
		return rep;
		
	}	

	public static BitMap composanteRouge(BitMap img) {
		BitMap rep = new BitMap(img.largeur(),img.hauteur());
		for(int i =0 ; i<img.largeur();i++)
			for(int j = 0 ; j<img.hauteur();j++)
				rep.set(i,j,new Pixel((img.get(i,j)).r,0,0));
		return rep;
	}
	public static BitMap composanteVerte(BitMap img) {
		BitMap rep = new BitMap(img.largeur(),img.hauteur());
		for(int i =0 ; i<img.largeur();i++)
			for(int j = 0 ; j<img.hauteur();j++)
				rep.set(i,j,new Pixel(0,(img.get(i,j)).v,0));
		return rep;
	}
	public static BitMap composanteBleue(BitMap img) {
		BitMap rep = new BitMap(img.largeur(),img.hauteur());
		for(int i =0 ; i<img.largeur();i++)
			for(int j = 0 ; j<img.hauteur();j++)
				rep.set(i,j,new Pixel(0,0,(img.get(i,j)).b));
		return rep;
	}
	public static BitMap inverser(BitMap img) {
		BitMap rep = new BitMap(img.largeur(),img.hauteur());
		for(int i =0 ; i<img.largeur();i++)
			for(int j = 0 ; j<img.hauteur();j++)
				rep.set(i,j,new Pixel(255-(img.get(i,j)).r,255-(img.get(i,j)).v,255-(img.get(i,j)).b));
		return rep;
	}
	
	public static BitMap bruit(BitMap img,int m) {
		BitMap rep = new BitMap(img.largeur(),img.hauteur());
		int alea;
		Pixel temp;
		for(int i =0 ; i<img.largeur();i++){
			for(int j = 0 ; j<img.hauteur();j++){
				alea=entierAleatoire(-m, m);
				temp=new Pixel(	(img.get(i,j)).r+alea,(img.get(i,j)).v+alea,(img.get(i,j)).b+alea);
				verifierPixel(temp);
				rep.set(i,j,temp);
			}
		}
		return rep;
	}
	
	public static BitMap filtreMonochrome(BitMap img) {
		BitMap rep = new BitMap(img.largeur(),img.hauteur());
		int moy;
		for(int i =0 ; i<img.largeur();i++){
			for(int j = 0 ; j<img.hauteur();j++){
				moy=((img.get(i,j)).r+(img.get(i,j)).v+(img.get(i,j)).b)/3;
				if(moy<128)rep.set(i,j,new Pixel(0,0,0));
				else rep.set(i,j,new Pixel(255,255,255));
			}
		}
		return rep;
	}
	
	public static BitMap filtreGris(BitMap img,boolean moyenne) {
		BitMap rep = new BitMap(img.largeur(),img.hauteur());
		int moy;
		double temp;
		for(int i =0 ; i<img.largeur();i++){
			for(int j = 0 ; j<img.hauteur();j++){
				if(moyenne){
					moy=((img.get(i,j)).r+(img.get(i,j)).v+(img.get(i,j)).b)/3;
					rep.set(i,j,new Pixel(moy,moy,moy));}
				else {
					temp=(img.get(i,j)).r*0.22125+(img.get(i,j)).v*0.7154+(img.get(i,j)).b*0.0721;
					rep.set(i,j,new Pixel((int)temp,(int)temp,(int)temp));
				}
			}
		}
		return rep;
	}

	public static BitMap filtreSepia(BitMap img) {
		BitMap rep = new BitMap(img.largeur(),img.hauteur());
		double tempR,tempG,tempB;
		for(int i =0 ; i<img.largeur();i++){
			for(int j = 0 ; j<img.hauteur();j++){
				tempR=0.393*img.get(i,j).r+0.769*img.get(i,j).v+0.189*img.get(i,j).b;
				tempG=0.349*img.get(i,j).r+0.686*img.get(i,j).v+0.168*img.get(i,j).b;
				tempB=0.272*img.get(i,j).r+0.534*img.get(i,j).v+0.131*img.get(i,j).b;
				rep.set(i,j,new Pixel((int)tempR,(int)tempG,(int)tempB));
				
			}
		}
		return rep;
	}
	public static void main(String[] args) {

		System.out.println("Début du TP 9");
		BitMap img = BitMap.aPartirDe("tp9/tiger.bmp");
		/*
		// Exercice 1
		
		BitMap rectangle = simpleRectangle(100, 100);
		BitMap.enregistreBitMap(rectangle, "tp9/img/simpleRectangle");
		

		// Exercice 2
		
		BitMap croix = simpleCroix(100, 100);
		BitMap.enregistreBitMap(croix, "tp9/img/simpleCroix");
		

		// Lit l'image tiger.bmp dans le dossier principal du projet (au dessus du dossier src/ qui contient TP9.java)
		

		// Exercice 3
		
		BitMap.enregistreBitMap(composanteRouge(img),"tp9/img/tiger_rouge");
		BitMap.enregistreBitMap(composanteVerte(img),"tp9/img/tiger_vert");
		BitMap.enregistreBitMap(composanteBleue(img),"tp9/img/tiger_bleu");
		

		// Exercice 4
		
		BitMap.enregistreBitMap(inverser(img),"tp9/img/tiger_inverse");
		

		// Exercice 5
		
		BitMap.enregistreBitMap(bruit(img, 128),"tp9/img/tiger_bruit128");
		

		// Exercice 6
		
		BitMap.enregistreBitMap(filtreMonochrome(img),"tp9/img/tiger_mono");
		

		
		BitMap.enregistreBitMap(filtreGris(img, false),"tp9/img/tiger_gris_pasrealiste");
		BitMap.enregistreBitMap(filtreGris(img, true),"tp9/img/tiger_gris_realiste");
		*/
		BitMap.enregistreBitMap(filtreSepia(img),"tp9/img/tiger_sepia");
		

		// Exercice 7
		/*
		BitMap.enregistreBitMap(posteriser(img, 32),"tp9/img/tiger_post32");
		BitMap.enregistreBitMap(posteriser(img, 64),"tp9/img/tiger_post64");
		BitMap.enregistreBitMap(posteriser(img, 128),"tp9/img/tiger_post128");
		*/

		// Exercice 8
		/*
		BitMap.enregistreBitMap(flou(img), "tp9/img/tiger_flou");
		BitMap.enregistreBitMap(flou(flou(img)), "tp9/img/tiger_flou_flou");
		*/

		System.out.println("Fin du TP 9");
	}

}








