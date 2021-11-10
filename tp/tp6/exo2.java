package tp6;

public class exo2 {
    public static void main(String[] args) {
        afficheHistoHorizontal(calculHistogramme(new int [] {6, 11, 13, 16, 12, 8, 9, 7, 12, 9, 8, 10, 14,11, 9, 1, 6, 4, 19, 17, 12, 13, 4, 0, 5, 9, 10, 11} ));
    }
    public static int[] calculHistogramme(int[] tab) {
        int[] Histo= {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        for(int val : tab)Histo[val]=Histo[val]+1;
        return Histo;
    }
    public static void afficheHistoHorizontal(int[] histo) {
        for( int i =0 ; i<histo.length;i++){
            System.out.print(i+" ");
            for ( int j =0 ; j<histo[i] ;j++){
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}