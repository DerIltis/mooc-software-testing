package tudelft.numfinder;

public class NumFinder {
    private int smallest = Integer.MAX_VALUE;
    private int largest = Integer.MIN_VALUE;

    public void find(int[] nums) {
        Reset();
        if (nums == null) return;
        for(int n : nums) {

            if(n < smallest)
                smallest = n;
            if (n > largest)
                largest = n;

        }
    }

    private void Reset()
    {
        smallest = Integer.MAX_VALUE;
        largest = Integer.MIN_VALUE;
    }
    public int getSmallest () {
        return smallest;
    }

    public int getLargest () {
        return largest;
    }
}
