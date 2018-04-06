package backtracking;

public class KnightTour {
	int n = 8;
	public static void main(String[] args) {
		KnightTour sol = new KnightTour();
		System.out.println(sol.knight());
	}
	boolean isValidPos(int[][]sol, int x, int y){
		if(sol[x][y] == -1 && (x>= 0 && x < n && (y >= 0 && y < n ))) {
			return true;
		}
		return false;
	}
	public boolean knight() {
		int[][] sol = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				sol[i][j] = -1; 
			}
		}	
		int[] xPos = new int[]{2, 1, -1, -2, -2, -1, 1, 2};
		int[] yPos = new int[]{1, 2, 2, 1, -1, -2, -2, -1};
		sol[0][0] = 0;
		return knightUtil(sol,0, 0, xPos, yPos, 1);
	}

	boolean knightUtil(int[][]sol, int x, int y, int xPos[], int yPos[], int counter){
		int nextX, nextY;
		if(counter  == n*n){
			return true; //filled all position;
		}
		for(int i  = 0; i < n; i++) {
			nextX = x + xPos[i];
			nextY = y + yPos[i];
			if(isValidPos(sol, nextX, nextY)) {
				sol[nextX][nextY] = counter;
				if( knightUtil(sol, nextX, nextY, xPos, yPos, counter + 1))
					return true;
			   else
				  sol[nextX][nextY] = -1;
		   }
		}
		return false;
	}
}
