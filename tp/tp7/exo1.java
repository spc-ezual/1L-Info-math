package tp7;

public class exo1 {
    public static void main(String[] args) {
        afficheTab2D(new int[][]{ {8,2,7,4,3,6,5,9,1},
        {1,9,3,2,8,5,4,7,6},
        {4,5,6,7,9,1,2,8,3},
        {5,6,4,8,7,3,9,1,2},
        {9,3,8,1,6,2,7,4,5},
        {7,1,2,5,4,9,3,6,8},
        {3,8,5,9,1,7,6,2,4},
        {6,7,1,3,2,4,8,5,9},
        {2,4,9,6,5,8,1,3,7}});
    }
    public static void afficheTab2D(int[][] tab) {
        for(int[] val :tab){
            for(int val2:val){
                System.out.print(val2+" ");
            }
            System.out.println("");
        }
    }

}
