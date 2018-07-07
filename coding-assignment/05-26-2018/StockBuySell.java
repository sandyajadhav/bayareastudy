import java.util.*;
public class StockBuySell{

	public void stockBuySell(int [] prices,int n){
		if( n == 1){
			return ;
		}
		
		List<Interval> result = new ArrayList();
		
		int i = 0;
		while(i < n-1 ){
			//find minima 
			
			while((i < n-1) && prices[i+1] <= prices[i]){
				i++;
			}
			
			if(i == n-1){
				break;
			}
			
			Interval interval = new Interval();
			interval.buy = i;
			i++;
			
			while((i < n) && prices[i] >= prices[i-1]){
				i++;
			}
			
			interval.sell = i-1;
			result.add(interval);

		}
		
		
		if(result.isEmpty() ){
			System.out.println("There is no way to make profit");
		}else{
		
			for(Interval interval:result){
				System.out.println("Buy at "+ prices[interval.buy] +" and sell at "+prices[interval.sell]);
			}
		}
	}
	
	public static void main(String args[]){
		//int []prices = {100,200,456,29,457,12,400,400,800};
		int []prices = {500,400,200,12};

		StockBuySell stock = new StockBuySell();
		stock.stockBuySell(prices,prices.length);
	}
}

class Interval{
	int buy;
	int sell;
}