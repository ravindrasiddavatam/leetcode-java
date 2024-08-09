class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        
        int n = profits.length;

        PriorityQueue<int[]> minCapitalHeap = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));

        PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i=0;i<n;i++) {
            minCapitalHeap.offer(new int[] {capital[i], profits[i]});

        }

        for(int i=0;i<k;i++) {
            while(!minCapitalHeap.isEmpty() && minCapitalHeap.peek()[0] <= w) {
                maxProfitHeap.offer(minCapitalHeap.poll()[1]);
            }

            if(maxProfitHeap.isEmpty()) {
                break;
            }

            w+=maxProfitHeap.poll();
        }

        return w;
    }
}
