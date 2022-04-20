package tictactoe;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

public class ButtonAction implements ActionListener{
	CustomButton button;
	private List<CustomButton> customButtons;
	
	ButtonAction(List<CustomButton> customButtons){
		this.customButtons = customButtons;
	}
	
	public void actionPerformed(ActionEvent ae) {
		button = (CustomButton) ae.getSource();
	
		if(GlobalValue.gameType.equalsIgnoreCase("Player")) {
			vsPlayer();
		}else {
			vsComputer();
		}
	}
	
	private boolean vsPlayer() {
		if(button.getValue().toString().equalsIgnoreCase("Circle") || button.getValue().toString().equalsIgnoreCase("X") || GlobalValue.gameEnded) {
			return false;
		}
		
		if(GlobalValue.isCircle) {
			button.setBackground(Color.green);
			button.setValue(ButtonValue.valueOf("Circle"));
		}else {
			button.setBackground(Color.red);
			button.setValue(ButtonValue.valueOf("X"));
		}
		
		removeEmptySpots(button.getPosition());
		
		if(checkIfPlayerWins(button.getPosition())) {
			JOptionPane.showMessageDialog(null, "Player " + button.getValue() + " Wins!");
			GlobalValue.gameEnded = true;
			return false;
		}
		
		if(GlobalValue.emptyBoxes.size() == 0){
			JOptionPane.showMessageDialog(null, "It's a tie!");
			GlobalValue.gameEnded = true;
			return false;
		}
		
		GlobalValue.isCircle = !GlobalValue.isCircle;
		
		return false;
		
	}
	
	private boolean vsComputer() {
		int position;
		
		if(button.getValue().toString().equalsIgnoreCase("Circle") || button.getValue().toString().equalsIgnoreCase("X") || GlobalValue.gameEnded) {
			return false;
		}
		
		// Player Moves
		button.setValue(ButtonValue.valueOf("Circle"));
		button.setBackground(Color.green);
		position = button.getPosition();
		removeEmptySpots(position);
		
		if(checkIfPlayerWins(button.getPosition())) {
			JOptionPane.showMessageDialog(null, "Player " + button.getValue() + " Wins!");
			GlobalValue.gameEnded = true;
			return false;
		}
		
		GlobalValue.isCircle = !GlobalValue.isCircle;
		
		if(GlobalValue.emptyBoxes.size() == 0){
			JOptionPane.showMessageDialog(null, "It's a tie!");
			GlobalValue.gameEnded = true;
			return false;
		}
		
		// Computer Moves
		
		position = checkCircleWinningCombinations();
		if(checkIfPlayerWins(position)) {
			JOptionPane.showMessageDialog(null, "Player X Wins!");
			GlobalValue.gameEnded = true;
		}
		
		GlobalValue.isCircle = !GlobalValue.isCircle;
		
		return false;
	}
	
	private List<Integer[]> getWinCombinations(int position){
		return GlobalValue.winningCombinations.get(position);
	}
	
	private boolean checkIfPlayerWins(int position) {
		List<Integer[]> winCombinations = getWinCombinations(position);
		String value = GlobalValue.isCircle ? "Circle" : "X";
		
		for(Integer[] winIndexes : winCombinations) {
			int counter = 0;
			while(counter < winIndexes.length) {
				int index = winIndexes[counter];
				if(!customButtons.get(index).getValue().toString().equals(value)) {
					break;
				}
				counter++;
			}
			
			if(counter == winIndexes.length) {
				return true;
			}
		}
		
		return false;
	}
	
	private int checkCircleWinningCombinations() {
		boolean breaker = false;
		Integer fillInIndex = null;
		
		for(List<Integer[]> winCombinations : GlobalValue.winningCombinations) {
			for(int outerCounter = 0; outerCounter < winCombinations.size(); outerCounter++){
				Integer[] winIndexes = winCombinations.get(outerCounter);
				int winPosition = 0;
				int emptyPosition = 0;
				
				for(int innerCounter = 0; innerCounter < winIndexes.length; innerCounter++){
					int index = winIndexes[innerCounter];
					CustomButton customBtn = customButtons.get(index);
					if(customBtn.getValue().toString().equalsIgnoreCase("Circle")) {
						winPosition++;
					}
					
					if(customBtn.getValue().toString().equalsIgnoreCase("Empty")) {
						emptyPosition++;
					}
				}
				
				if(winPosition > 1 && emptyPosition == 1){
					fillInIndex = setBlocker(winIndexes);
					breaker = true;
					break;
				}
			}
			
			if(breaker){
				break;
			}
		}
		
		// meaning, there's no 2 consecutive circles beside each other with empty spot next
		if(!breaker){
			fillInIndex = fillInXToEmptyBox();
		}

		return fillInIndex;
	}
	
	
	private int setBlocker(Integer[] winIndexes) {
		Integer fillInIndex = null;
		
		for(int counter = 0; counter < winIndexes.length;counter++){
			int index = winIndexes[counter];
			CustomButton customBtn = customButtons.get(index);
			if(customBtn.getValue().toString().equalsIgnoreCase("Empty")) {
				customBtn.setValue(ButtonValue.valueOf("X"));
				customBtn.setBackground(Color.red);
				removeEmptySpots(index);
				fillInIndex = index;
				break;
			}
		}
		
		if(fillInIndex == null) {
			fillInIndex = fillInXToEmptyBox();
		}
		
		return fillInIndex;
	}
	
	
	private void removeEmptySpots(int index) {
		int idx_of_element_to_remove = GlobalValue.emptyBoxes.indexOf(index);
		GlobalValue.emptyBoxes.remove(idx_of_element_to_remove);
	}
	
	
	private int fillInXToEmptyBox() {
		int index = GlobalValue.emptyBoxes.get(0);
		CustomButton customBtn = customButtons.get(index);
		
		customBtn.setValue(ButtonValue.valueOf("X"));
		customBtn.setBackground(Color.red);
		removeEmptySpots(index);
		
		return index;
	}
}
