package tp4;

public class exo2 {
    public static void main(String[]args) {
        System.out.println(PremiereOccurence(new int[] {1,2,34,7}, 7));
    }
    public static int PremiereOccurence(int[]tab,int a) {
    for(int i=0;i<tab.length;i++)
        if(tab[i]==a) return i;
    return -1;
        
    }
    public static int nombreOccurrences(int[] tab , int a) {
        int rep=0;
        for(int val : tab)
            if(val==a)rep++;
        return rep;
        }
    public static int[] remplace(int[] tab , int a,int b) {
        for(int i=0;i<tab.length;i++)
        if(tab[i]==a) tab[i]=b;
        return tab;
    }
}
