package tictactoe;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class Frame {

	private JFrame frame;
	private List<CustomButton> customButtons;
	
	Frame(){
		frame = new JFrame();
		instantiateButtons();
		addButtonsToFrame();
		
		frame.setLayout(new GridLayout(3,3));
		frame.setSize(300,300);
		frame.setVisible(true);
	}
	
	private void instantiateButtons() {
		customButtons = new ArrayList<CustomButton>();
		ButtonAction action = new ButtonAction(customButtons);
		
		for(int position = 0; position < 9; position++) {
			customButtons.add(CustomButton.builder()
					.position(position)
					.value(ButtonValue.valueOf("Empty"))
					.build());
			
			customButtons.get(position).addActionListener(action);
		}
	}
	
	private void addButtonsToFrame() {
		for(int counter = 0; counter < customButtons.size(); counter++) {
			frame.add(customButtons.get(counter));
		}
	}
	
}
