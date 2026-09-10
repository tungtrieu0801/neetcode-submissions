class Solution {
    public int longestConsecutive(int[] nums) {
        int longest = 0;

        Set<Integer> numSet = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toSet());

        for (Integer num: numSet) {
            if(!numSet.contains(num-1)) {
                int length = 0;
                while (numSet.contains(num + length)) {
                    length ++;
                }
                longest = Math.max(longest, length);
            }
        }

        return longest;
    }
}