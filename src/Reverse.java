public class Reverse{

	public static void main(String arg[]) {
		Reverse rev = new Reverse();
		int[] a = new int[] {1,2,3,4,5,6};
		a = rev.reverseArray(a);
		for(int i = 0; i< a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	int[] reverseArray(int[] a) {
		int i = 0; 
		int j = a.length-1;

		while (i <= j) {
			swap(i, j, a);
			i++;
			j--;
		}
		return a;
	}

	void swap(int i, int j, int[] a) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}