class Solution {
    public int maxNumberOfFamilies(final int n, final int[][] reservedSeats) {
        final int[] valid = new int[] { 0x1E, 0x78, 0x1E0 };
        final Map<Integer, Integer> reserved = new HashMap<>();

        for(final int[] r : reservedSeats) {
            final int bitmask = 1 << (r[1] - 1);

            reserved.put(r[0] - 1, reserved.getOrDefault(r[0] - 1, 0) | bitmask);
        }

        int count = 0;

        for(int value : reserved.values()) {
            for(final int v : valid) {
                if((value & v) == 0) {
                    count++;
                    value |= v;
                }
            }
        }

        return count + (n - reserved.size()) * 2;
    }
}