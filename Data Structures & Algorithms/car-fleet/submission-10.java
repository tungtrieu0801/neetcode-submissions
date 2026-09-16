class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < position.length; i++ ) {
            treeMap.put(position[i], speed[i]);
        }
        List<Double> s = new ArrayList<>();

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(treeMap.entrySet());
        for (int j = list.size() - 1; j >= 0; j-- ) {
            Map.Entry<Integer, Integer> entry = list.get(j);
            double lengthWayCar = target - entry.getKey();
            double speedCar = entry.getValue();
            double timeSpending = lengthWayCar / speedCar;
            if(s.isEmpty()) {
                s.add(timeSpending);
            } else if (s.getLast() < timeSpending) {
                s.add(timeSpending);
            } else {

            }
        }
        return s.size();
    }

}