package tictactoe;

import java.util.ArrayList;
import java.util.List;

public class GlobalValue {
	public static boolean isCircle = true;
	public static boolean gameEnded = false;
	public static String gameType = "Computer";
	public static List<Integer> emptyBoxes = new ArrayList<Integer>();
	public static List<List<Integer[]>> winningCombinations = new ArrayList<List<Integer[]>>();
	
	public static void initializeEmptyBoxes() {
		for(int counter = 0; counter < 9; counter++) {
			emptyBoxes.add(counter);
		}
	}
	
	public static void initializeWinningCombinations() {
		// for box 0
		Integer[] winCombination0_1 = {0,4,8};
		Integer[] winCombination0_2 = {0,3,6};
		Integer[] winCombination0_3 = {0,1,2};
		
		// for box 1
		Integer[] winCombination1_1 = {1,4,7};
		Integer[] winCombination1_2 = {1,0,2};
		
		// for box 2
		Integer[] winCombination2_1 = {2,4,6};
		Integer[] winCombination2_2 = {2,5,8};
		Integer[] winCombination2_3 = {2,0,1};
		
		// for box 3
		Integer[] winCombination3_1 = {3,0,6};
		Integer[] winCombination3_2 = {3,4,5};
		
		// for box 4
		Integer[] winCombination4_1 = {4,0,8};
		Integer[] winCombination4_2 = {4,2,6};
		Integer[] winCombination4_3 = {4,1,7};
		Integer[] winCombination4_4 = {4,3,5};
		
		// for box 5
		Integer[] winCombination5_1 = {5,2,8};
		Integer[] winCombination5_2 = {5,3,4};
		
		// for box 6
		Integer[] winCombination6_1 = {6,2,4};
		Integer[] winCombination6_2 = {6,0,3};
		Integer[] winCombination6_3 = {6,7,8};
		
		// for box 7
		Integer[] winCombination7_1 = {7,1,4};
		Integer[] winCombination7_2 = {7,6,8};
		
		// for box 8
		Integer[] winCombination8_1 = {8,0,4};
		Integer[] winCombination8_2 = {8,2,5};
		Integer[] winCombination8_3 = {8,6,7};
		
		List<Integer[]> box0 = new ArrayList<Integer[]>();
		List<Integer[]> box1 = new ArrayList<Integer[]>();
		List<Integer[]> box2 = new ArrayList<Integer[]>();
		List<Integer[]> box3 = new ArrayList<Integer[]>();
		List<Integer[]> box4 = new ArrayList<Integer[]>();
		List<Integer[]> box5 = new ArrayList<Integer[]>();
		List<Integer[]> box6 = new ArrayList<Integer[]>();
		List<Integer[]> box7 = new ArrayList<Integer[]>();
		List<Integer[]> box8 = new ArrayList<Integer[]>();
		
		box0.add(winCombination0_1);
		box0.add(winCombination0_2);
		box0.add(winCombination0_3);
		
		box1.add(winCombination1_1);
		box1.add(winCombination1_2);
		
		box2.add(winCombination2_1);
		box2.add(winCombination2_2);
		box2.add(winCombination2_3);
		
		box3.add(winCombination3_1);
		box3.add(winCombination3_2);
		
		box4.add(winCombination4_1);
		box4.add(winCombination4_2);
		box4.add(winCombination4_3);
		box4.add(winCombination4_4);
		
		box5.add(winCombination5_1);
		box5.add(winCombination5_2);
		
		box6.add(winCombination6_1);
		box6.add(winCombination6_2);
		box6.add(winCombination6_3);
		
		box7.add(winCombination7_1);
		box7.add(winCombination7_2);
		
		box8.add(winCombination8_1);
		box8.add(winCombination8_2);
		box8.add(winCombination8_3);
		
		winningCombinations.add(box0);
		winningCombinations.add(box1);
		winningCombinations.add(box2);
		winningCombinations.add(box3);
		winningCombinations.add(box4);
		winningCombinations.add(box5);
		winningCombinations.add(box6);
		winningCombinations.add(box7);
		winningCombinations.add(box8);
		
	}
}
