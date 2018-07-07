import java.util.*;

//By compromising space complexity of O(n), we merge intervals in O(nLogn) time comlexity
public class MergeInterval{
	public void mergeInterval(List<Interval> intervalList){
		
		Stack<Interval> stack = new Stack();
		
		stack.push(intervalList.get(0));
		
		
		for(int i = 1; i< intervalList.size(); i++){
			Interval interval = intervalList.get(i);
		    Interval top = stack.peek();
		    if(top.end < interval.start){
		    	stack.push(interval);
		    }else if(top.end < interval.end){
		       Interval item = stack.pop();
		       item.end = interval.end;
		       stack.push(item);
		    }
		}
		
	  while(!stack.isEmpty()){
	    Interval item = stack.pop();
	  	System.out.println("( "+item.start+" , "+item.end+" )");
	  }
	}
	
	public static void main(String args[]){
	
		List<Interval> intervalList = new ArrayList();
		intervalList.add(new Interval(2,4));
		intervalList.add(new Interval(5,7));
		intervalList.add(new Interval(6,8));
		intervalList.add(new Interval(1,3));

		//O(nLogn) we can implement quick sort here
		//Collections.sort(intervalList);
		
		QuickSort quickSort = new QuickSort();
		quickSort.sort(intervalList,0,intervalList.size()-1);
		intervalList.forEach(p->System.out.println(p.start));
		MergeInterval m = new MergeInterval();
		m.mergeInterval(intervalList);
		
	}
}


class Interval implements Comparable<Interval> {
	int start;
	int end;
	
	public Interval(int start, int end){
		this.start = start;
		this.end = end;
	}
	
	@Override 
	public int compareTo(Interval o1){
	  if(this.start > o1.start){
	    return 1;
	  }else if(this.start < o1.start){
	    return -1;
	  }
	  return 0;
	}
}	
class QuickSort{
	public void sort(List<Interval> intervalList, int l, int r){
		if(l < r){
			int pivot = partition(intervalList,l,r);
			sort(intervalList,l, pivot-1);
			sort(intervalList,pivot+1,r);
		}
	}
	
	public int partition(List<Interval> intervalList, int low, int high)	{
		Interval pivot =  intervalList.get(high);
		int i = low-1;
		int j = high;
		while(j < high){
			if(intervalList.get(j).start <= pivot.start){
				i++;
				swap(intervalList,i,j);
			}
			j++;
		}
		swap(intervalList,i+1,high);
		return i+1;
		
	}
	
	public void swap(List<Interval> intervalList, int index1,int index2){
		Interval temp = intervalList.get(index1);
		intervalList.set(index1,intervalList.get(index2));
		intervalList.set(index2,temp);
	}
}