class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        List<Integer> listResult = new ArrayList<>();
        for (int i = 0; i < temperatures.length; i++) {
            int day =1;
            if (i == temperatures.length -1) {
                listResult.add(0);
            }
            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperatures[i] >= temperatures[j]) {
                    day += 1;
                }
                if(temperatures[i] < temperatures[j]){
                    listResult.add(day);
                    break;
                }
                if (j == temperatures.length -1) {
                    listResult.add(0);
                }
            }

        }


        return listResult.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}