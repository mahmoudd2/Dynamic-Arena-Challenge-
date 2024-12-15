package csen703.main.assignment2;

public class DynamicArena {

	public static int ClimbDynamicArenaDP(int [] floors) {
		int n = floors.length;
		int [][] dp = new int [n][2]; // 2d array 3shan el two states bta3et el game (no fight w fighting)
		
		for(int i = 0; i < n; i++) { //intialize el array be -1 3shan n check enha lesa msh calculated
			for (int j = 0; j < 2; j++) {
				dp[i][j] = -1;
			}
		}
		
		return fighting (0, n, 0, floors, dp);
	}
	
	public static int fighting (int i ,int n, int fight, int []floors, int [][] dp) {
		// base case1 ---> el index 3ada el length bta3 el array aw equal to it
		if (i >= n ) {
			return 0;
		}
		// base case2 ----> lw kol el 2d array msh equal le -1 fa kda we are done
		if (dp [i][fight] != -1) {
			return dp[i][fight];
		}
		
		int finalScore = 0;
		if(fight == 0) {
			// ha n skip w msh hnbd2 fight aw hn start a fight
			finalScore = Math.max(fighting(i + 1, n, 0, floors, dp), fighting(i + 1, n, 1, floors, dp) - floors[i]);
		}
		else if (fight == 1) {
			// ha n skip aw n end a fight
			finalScore = Math.max(fighting(i + 1, n, 1, floors, dp), fighting(i + 2, n, 0, floors, dp) + floors[i]);
		}
		
		dp[i][fight] = finalScore;
		return finalScore;
	}
}
