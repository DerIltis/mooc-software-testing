package tudelft.chocolate;

public class MakeChocolate {
    public int makeChocolate(int small, int big, int goal) {
        int maxBigBoxes = goal / 5;
        int bigBoxesWeCanUse = Math.min(maxBigBoxes, big);
        goal -= (bigBoxesWeCanUse * 5);
        if(small < goal)
            return -1;
        return goal;
    }

}
