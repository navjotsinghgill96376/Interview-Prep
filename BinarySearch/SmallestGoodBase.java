class Solution {
    public String smallestGoodBase(String n) {
        long target = Long.parseLong(n);

        for (long terms = 63; terms > 1; terms--) {
            long base = findBase(terms, target);
            if (base != -1) {
                return String.valueOf(base);
            }
        }

        return String.valueOf(target - 1);
    }

    public long findBase(long terms, long target) {
        long lo = 2;
        long hi = (long) Math.pow(target, 1.0 / (terms - 1));

        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;

            long sum = calculateSum(mid, terms);

            if (sum == target) return mid;
            else if (sum > target) hi = mid - 1;
            else lo = mid + 1;
        }

        return -1;
    }

    public long calculateSum(long base, long terms) {
        long power = 1;
        long sum = 1;

        for (int i = 1; i < terms; i++) {
            if (power > Long.MAX_VALUE / base) return Long.MAX_VALUE;
            power *= base;

            if (sum > Long.MAX_VALUE - power) return Long.MAX_VALUE;
            sum += power;
        }

        return sum;
    }
}