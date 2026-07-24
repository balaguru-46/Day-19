import java.util.*;

class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Prefix sum 0 exists before starting
        map.put(0, -1);

        int sum = 0;
        int maxLength = 0;

        for (int i = 0; i < nums.length; i++) {
            // Convert 0 to -1 and 1 to +1
            if (nums[i] == 0) {
                sum--;
            } else {
                sum++;
            }

            // If prefix sum was seen before
            if (map.containsKey(sum)) {
                int length = i - map.get(sum);
                maxLength = Math.max(maxLength, length);
            } else {
                // Store first occurrence only
                map.put(sum, i);
            }
        }

        return maxLength;
    }
}