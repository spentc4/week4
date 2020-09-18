import java.util.*;
import java.text.ParseException;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;
public class week4 {
	
	
	
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		int greater;
		int count = 5000;
		int[] number = new int[count];
		int[] order = new int[count];
		ArrayList<Integer> dynamicArray = new ArrayList<Integer>(count);
		Random rd = new Random();
		int n = dynamicArray.size();
		for(int i = 0; i< number.length; i++) {
		
	      number[i] = rd.nextInt() % 1000;
	      
			
					
			
				System.out.println(number[i]+ " ");
		}
		 for (int i=0; i<n; i++) {
			 Integer r = rd.nextInt() % 1000;
	    	  dynamicArray.add(r);
	      }
		 Instant start = Instant.now();
		 methodToTime();
		for (int i=0; i < dynamicArray.size(); i++) {
			for (int j = dynamicArray.size() - 1; j > i; j--) {
				if (dynamicArray.get(i) > dynamicArray.get(j)) {
					int tmp = dynamicArray.get(i);
					dynamicArray.set(i,dynamicArray.get(j));
					dynamicArray.set(j, tmp);
				}
			}
		}
		Instant finish = Instant.now();
		long timeElapsed = Duration.between(start, finish).toNanos();
		Instant start1 = Instant.now();
		methodToTime();
		for (int i: dynamicArray) {
			System.out.println(i);
		}
		
		for (int i = 0; i < number.length; i++) {
			greater = 0;
			for (int k=0; k<number.length;k++) {
				if (number[i]>number[k]) {
					greater++;
				}
			}
			while(order[greater] == number[i]) {
				greater++;
			}
			order[greater]=number[i];
		}
		Instant finish1 = Instant.now();
		long timeElapsed2 = Duration.between(start1,finish1).toNanos();
		System.out.println("now the sorted numbers will show ");
		for (greater=0;greater<order.length;greater++) {
			System.out.println(order[greater]+ " ");
		}
		
		System.out.println("this is the time elapsed for the linked list: " + timeElapsed);
		System.out.println("this is the time elapsed for the array: " + timeElapsed2);

		
		
	}
	private static void methodToTime() {
	    try {
	      TimeUnit.SECONDS.sleep(3);
	    } catch (InterruptedException e) {
	      e.printStackTrace();
	    }
	}
}
