package tudelft.numfinder;

public class NumFinderMain {

    public static void main (String[] args) {
        NumFinder nf = new NumFinder();

        // this works
        // nf.find(new int[] {4, 25, 7, 9});

        // this crashed
        // nf.find(new int[] {4, 3, 2, 1});

        // This crashed
        // nf.find(null);

        nf.find(new int[] {4, 4, 4, 4});
        nf.find(new int[] {5, 5, 5, 5});

        System.out.println(nf.getLargest());
        System.out.println(nf.getSmallest());
    }
}
