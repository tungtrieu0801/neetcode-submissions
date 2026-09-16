class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] cars = new double[n][2];

        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double)(target - position[i]) / speed[i]; // time
        }

        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0])); // sort position giảm dần

        int fleets = 0;
        double maxTime = 0;
        for (double[] car : cars) {
            if (car[1] > maxTime) {   // xe này không đuổi kịp fleet trước
                fleets++;
                maxTime = car[1];
            }
        }
        return fleets;
    }
}