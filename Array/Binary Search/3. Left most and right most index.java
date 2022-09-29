class Solution {
    // find first occurence
    public long first(long arr[], long x) {
        int low = 0;
        int high = arr.length - 1;
        long ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == x) {
                ans = mid;
                high = mid - 1;
            } else if (arr[mid] > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    // find last occurence

    public long last(long arr[], long x) {
        int low = 0;
        int high = arr.length - 1;
        long ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == x) {
                ans = mid;
                low = mid + 1;
            } else if (arr[mid] > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public pair indexes(long v[], long x) {
        // Your code goes here
        long firstOccure = first(v, x);
        if (firstOccure == -1) {
            return new pair(-1, -1);
        }
        long lastOccure = last(v, x);

        return new pair(firstOccure, lastOccure);

    }
}