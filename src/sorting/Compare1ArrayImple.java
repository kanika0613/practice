package sorting;

import java.io.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Compare1ArrayImple {

	public static void main(String[] args) {
		
		Compare1ArrayImple ob = new Compare1ArrayImple();
		

		/*Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		String[] s = line.split(" ");
		int totalNextLines = Integer.parseInt(s[0]);
		int minute = Integer.parseInt(s[1]);
		
		List<Integer[]> timeInMinutes = ob.readFromScreen(sc, totalNextLines);
		List<Integer[]> mergedIntervals = ob.merge(timeInMinutes);
		List<Integer[]> validIntervals = ob.findValidIntervals(mergedIntervals, minute);
		List<String> result = convertToHHMM(validIntervals);
		*/
		ob.test();
	}
	
	private static List<String> convertToHHMM(List<Integer[]> validIntervals) {
		List<String> result = new ArrayList<String>();
		
		for(int i = 0; i< validIntervals.size(); i++) {
			int startHH = validIntervals.get(i)[0]/60;
			int startMM =  validIntervals.get(i)[0] % 60;
			int endHH = validIntervals.get(i)[1]/60;
			int endMM =  validIntervals.get(i)[1] % 60;
			result.add(startHH+ " " + startMM + " " +endHH+ " "+ endMM);
		}
		return result;
	}

	private List<Integer[]> findValidIntervals(List<Integer[]> mergedInterval, int minute){
		List<Integer[]> result  = new ArrayList<Integer[]>();
		if(mergedInterval.get(0)[0] >= minute) {
			result.add(new Integer[] {0,mergedInterval.get(0)[0]});
		}
		if((24*60) - mergedInterval.get( mergedInterval.size()-1)[1]  >= minute) {
			result.add(new Integer[] {mergedInterval.get(mergedInterval.size()-1)[1]+1, (24*60)});
		}
		for(int i = 0 ; i < mergedInterval.size() - 1; i++) {
			if(mergedInterval.get(i+1)[0] - mergedInterval.get(i)[1] >= minute ){
				result.add(new Integer[]{mergedInterval.get(i)[0] + 1 , mergedInterval.get(i+1)[0] -1});
			}
		}
		 return result;
	}
	
	private List<Integer[]> readFromScreen(Scanner sc, int totalNextLines) {
		List<Integer[]> list = new ArrayList<Integer[]>();
		for(int i = 0; i < totalNextLines ; i++) {
			String time = sc.nextLine();
			Integer [] t = convertToInt(time); //final time
			list.add(t);
		}
		return list;
	}

	private Integer[] convertToInt(String sa) { //hh mm hh mm converted to minutes  mm mm
		String[] s = sa.split(" "); 
		int[] arr = new int[s.length];
		for(int  i = 0; i < s.length; i++) {
			arr[i] = Integer.parseInt(s[i]);
		}
		Integer[] hhmm = new Integer[2];
		hhmm[0] = arr[0]*60 + arr[1];
		hhmm[1] = arr[2]*60 + arr[3];
		return hhmm;
	}
	
	private void test() {
		Integer[] result = convertToInt("02 00 21 00");
		System.out.println(result[0] + " " +result[1]);
	}
	private List<Integer[]> merge(List<Integer[]> a){
		
		Collections.sort(a, new compareArray());
		for(int i = 0; i < a.size() - 1; i++ ) {
			if(a.get(i)[1] >= a.get(i+1)[0]) {
				int min = Math.min(a.get(i)[0], a.get(i+1)[0]);
				int max = Math.max(a.get(i)[1], a.get(i+1)[1]);
				a.remove(i+1);
				a.remove(i);
				a.add(i, new Integer[] {min,max});
				i--;
			} else {
				continue;
			}
		}
		return a;
	}
	
	private List<Integer[]> function() {
		List<Integer[]> list = new ArrayList<Integer[]>();
		list.add(new Integer[] {3,5});
		list.add(new Integer[] {0,6});
		list.add(new Integer[] {7,9});
		list.add(new Integer[] {10,11});
		list.add(new Integer[] {11,12});
		list.add(new Integer[] {0,0});
		
		return list;
	}
}
class compareArray implements Comparator<Integer[]>{
	public int compare(Integer[] a, Integer[] b) {
		return a[0] - b[0];
	}
}
