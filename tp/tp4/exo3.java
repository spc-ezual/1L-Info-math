package tp4;

public class exo3 {
    public static void main(String[] args) {
        int[] m =miroirCopie(new int[] {1,2,3,4,5});
        for (int j:m )
        System.out.println(j);
    }
    public static int[] miroirCopie(int[]tab) {
        int[] tab2= new int[tab.length];
        int a;
        System.arraycopy(tab, 0, tab2, 0, tab.length);
        for(int i =0 ;i<tab.length/2;i++){
            a=tab2[i];
            tab2[i]=tab2[tab.length-i-1];
            tab2[tab.length-i-1]=a;
        }
        return tab2;
    }
}
