package com.CK;

public class Main {

    public static void main(String[] args) {
        // write your code here
    }
}

class Solution {
    int lastIndex;
    List<Integer> nums;
    Random rand;

    public Solution(int[] w) {
        rand = new Random();
        lastIndex = -1;
        nums = new ArrayList<>();
        for (int weight : w) {
            lastIndex += weight;
            nums.add(lastIndex);
        }
    }

    public int pickIndex() {
        int index = rand.nextInt(lastIndex + 1);
        return binarySearch(nums, index);
    }

    private int binarySearch(List<Integer> nums, int index) {
        int l = 0, r = nums.size() - 1;
        while (l + 1 < r) {
            int mid = (l + r) / 2;
            if (nums.get(mid) == index) {
                return mid;
            } else if (nums.get(mid) > index)
                r = mid;
            else
                l = mid;
        }
        return nums.get(l) >= index ? l : r;
    }

}