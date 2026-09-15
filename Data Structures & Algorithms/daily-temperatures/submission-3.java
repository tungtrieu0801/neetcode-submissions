class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();

        for (int i=0; i< temperatures.length; i++) {
            int x = temperatures[i];
            while (!stack.isEmpty() && stack.peek()[0] < x ) {
                int temp[] = stack.pop();
                res[temp[1]] = i - temp[1];
            }
            stack.push(new int []{x,i});
        }
        return res;
    }
}
