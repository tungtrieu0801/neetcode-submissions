class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int fleets = 0;
        float[] time = new float[target + 1];

        for (int i = 0; i < speed.length; i++) {
            time[position[i]] = (float)(target - position[i]) / speed[i];
        }

        float prev = 0;
        for (int i = target; i >= 0; i--) {
            if (time[i] > prev) {
                fleets++;
                prev = time[i];
            }
        }
        return fleets;
    }
}