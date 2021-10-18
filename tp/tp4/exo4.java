package tp4;

public class exo4 {
    public static void main(String[] args) {
        int[] aff =parcoursTableau(new int[] {2,5,6,1,9,8,3,4,5,7}, 4, new int[] {-2,3,-1,4});
        for ( int m : aff)System.out.println(m);
    }
    public static int[] parcoursTableau(int[] tab , int id,int[] mouv) {
        int[] rep =new int[mouv.length];
        int act = 0;
        for ( int dep : mouv){
            id=(id+dep)%tab.length;
            rep[act++]=tab[id];
        }
        return rep;
    }
}
