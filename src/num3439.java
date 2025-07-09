public class num3439 {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n=startTime.length;
        if(n==k){
            for(int i=0;i<n;i++){
                eventTime-=endTime[i]-startTime[i];
            }
            return eventTime;
        }
        int[] intervals=new int[n-k+1];
        intervals[0]=startTime[k];
        for(int i=1;i<intervals.length-1;i++){
            intervals[i]=startTime[k+i]-endTime[i-1];
        }
        intervals[intervals.length-1]=eventTime-endTime[n-k-1];
        int ans=0;
        int middleSpace=0;
        for(int j=0;j<k;j++){
            middleSpace+=endTime[j]-startTime[j];
        }
        for(int i=0;i<intervals.length;i++){
            int freeSpace=intervals[i];
            freeSpace-=middleSpace;
            if(i<intervals.length-1){
                middleSpace-=endTime[i]-startTime[i];
                middleSpace+=endTime[k+i]-startTime[k+i];
            }
            ans=Math.max(ans,freeSpace);
        }
        return ans;
    }
}
