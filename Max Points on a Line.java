class Solution {
    public int maxPoints(int[][] points) {

        if(points == null) return 0;
        if(points.length <= 2) return points.length;

        int maxPoints = 0;

        for(int i = 0; i<points.length; i++){
            HashMap<String, Integer> slopeMap = new HashMap<>();
            int duplicates = 1;
            int verticalPoints = 0;

            for(int j = i+1; j< points.length; j++){
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];

                if(x1 == x2 && y1 == y2) {
                    duplicates++;
                }else if(x1 == x2){
                    verticalPoints++;
                }else{
                    int dx=x2-x1;
                    int dy=y2-y1;
                    int gcd = gcd(dx,dy);

                    dx/=gcd;
                    dy/=gcd;

                    String slope = dy + "/" + dx;
                    slopeMap.put(slope, slopeMap.getOrDefault(slope,0)+1);

                }
            }

            int currentMax = verticalPoints;
            for(int count:slopeMap.values()) {
                currentMax = Math.max(currentMax, count);
            }
            maxPoints = Math.max(maxPoints, currentMax + duplicates);
        }
        return maxPoints;  
    }
    private int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b, a%b);
    }
}
