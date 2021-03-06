/*
57. Insert Intervals
*/

//遍历每一个已给出的interval，

//当当前的interval的end小于newInterval的start时，说明新的区间在当前遍历到的区间的后面，并且没有重叠，所以res添加当前的interval；

//当当前的interval的start大于newInterval的end时，说明新的区间比当前遍历到的区间要前面，并且也没有重叠，所以把newInterval添加到res里，并更新newInterval为当前的interval； 

//当当前的interval与newInterval有重叠时，merge interval并更新新的newInterval为merge后的。


public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
    ArrayList<Interval> res = new ArrayList<Interval>();
        
   for(Interval each: intervals){
       if(each.end < newInterval.start){
           res.add(each);
       }else if(each.start > newInterval.end){
           res.add(newInterval);
           newInterval = each;        
       }else if(each.end >= newInterval.start || each.start <= newInterval.end){
           int nstart = Math.min(each.start, newInterval.start);
           int nend = Math.max(newInterval.end, each.end);
           newInterval = new Interval(nstart, nend);
       }
   }

   res.add(newInterval); 

   return res;
}