
public class SeperateZero {

	public static void main(String[] args) {
		SeperateZero ob = new SeperateZero();
		//int[] a = new int[] {-1,2,-6,8,-10, -3 };
		int[] a = new int[] {0,1,1,0,0,1};
		int[] b = new int[] {3,4,5};
		ob.separate(a);
		for(int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		/*int [] result = ob.operation(a);
		for(int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		int [] resultMerger = ob.merge(a,b);
		for(int i = 0; i < resultMerger.length; i++) {
			System.out.println(result[i]);
		}
		ob.arrangeNegative(a);
		for(int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}*/
	}
	void separate(int [] a) {
		if(a == null || a.length == 0) {
			System.out.println("Blank Input");
			return;
		}
		int i = 0; 
		int j = a.length-1;

		while(i <= j) {
			if(a[i] == 0 && a[j] == 1) {
				i++;
				j--;
			} else if(a[i] == 1 && a[j] == 0) {
				swap(i, j, a);
				i++;
				j--;
			}else if(a[i] == 0 && a[j] == 0) {
				i++;
			} else {
				j--;
			}
		}
	}

	void swap(int i, int j, int[] a) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	int[] operation(int [] a) {
		int[] result = new int[2];
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for(int i = 0; i < a.length; i++) {
			if(a[i] > max) {
				max = a[i];
			} 
			if(a[i] < min) {
				min = a[i];
			}
		}
		result[0] = min;
		result[1] = max;
		return result;
	}

	int[] merge(int[] a, int[] b) {
		int[] result = new int[a.length + b.length];
		int i = 0;
		int j = 0;
		int k = 0;
		while(i != a.length - 1 || j != b.length - 1) {
			if(a[i] < b[j]) {
				result[k] = a[i];
				k++;
				i++;
			} else {
				result[k] = b[j];
				k++;
				j++;
			}
		}
		while(i < a.length) {
			result[k] = a[i];
			i++;
			k++;
		}
		while(j <b.length) {
			result[k] = b[j];
			k++;
			j++;
		}
		return result;
	}

	void arrangeNegative(int[] a) {
		int i = 0;
		int j = a.length-1;
		while(i <= j) {
			if(a[i] < 0 && a[j] > 0) {
				i++;
				j--;
			} else
				if(a[i] > 0  && a[j] < 0){
					swap(i, j ,a);
					i++;
					j--;
				} else 
					if(a[i] > 0 && a[j] > 0) {
						j--;
					} else {
						i++;
					}
		}
	}
}
