package tudelft.numfinder;

public class NumFinder {
    private int smallest = Integer.MAX_VALUE;
    private int largest = Integer.MIN_VALUE;

    public void find(int[] nums) {
        // initialize here to allow multiple calls
        smallest = Integer.MAX_VALUE;
        largest = Integer.MIN_VALUE;

        // sanity checks
        if (nums == null) return;
        if (nums.length < 2) return;

        for(int n : nums) {

            if(n < smallest)
                smallest = n;
            if (n > largest)
                largest = n;

        }
    }

    public int getSmallest () {
        return smallest;
    }

    public int getLargest () {
        return largest;
    }
}
