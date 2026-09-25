class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        for (int x = 0; x < n - 2; x++) {

            // Bỏ qua nums[x] bị trùng
            if (x > 0 && nums[x] == nums[x - 1]) {
                continue;
            }

            int i = x + 1;
            int j = n - 1;

            while (i < j) {

                int sum = nums[x] + nums[i] + nums[j];

                if (sum < 0) {
                    i++;
                } else if (sum > 0) {
                    j--;
                } else {
                    result.add(Arrays.asList(
                        nums[x],
                        nums[i],
                        nums[j]
                    ));

                    // Bỏ qua các nums[i] bị trùng
                    while (i < j && nums[i] == nums[i + 1]) {
                        i++;
                    }

                    // Bỏ qua các nums[j] bị trùng
                    while (i < j && nums[j] == nums[j - 1]) {
                        j--;
                    }

                    i++;
                    j--;
                }
            }
        }

        return result;
    }
}