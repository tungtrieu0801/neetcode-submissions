class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i< nums.length; i ++) {
            map.merge(nums[i], 1, Integer::sum);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a,b) -> Integer.compare(
                b.getValue(),
                a.getValue()
        ));
        int result[] = new int[k];
        for(int i = 0; i<k; i++) {
            result[i] = list.get(i).getKey();
        }

        return result;
    }
}