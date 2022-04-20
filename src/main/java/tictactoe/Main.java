package tictactoe;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Main {

	public static void main(String[] args) {
		Frame frame = new Frame();
		GlobalValue.initializeEmptyBoxes();
		GlobalValue.initializeWinningCombinations();
		
		final JDialog dialog = new JDialog();
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		JButton vsPlayer = new JButton("vs Player");
		JButton vsComputer = new JButton("vs Computer");
		
		setupActionListener(vsPlayer, dialog);
		setupActionListener(vsComputer, dialog);
		
		panel.add(vsPlayer);
		panel.add(vsComputer);
		
		//JOptionPane.showOptionDialog(null, panel,"Opponent Selection", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, null, new Object[]{}, null);
		JOptionPane optionPane = new JOptionPane(panel, JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
		
		dialog.setTitle("Select Opponent");
		dialog.setModal(true);
		dialog.setContentPane(optionPane);
		dialog.pack();
		dialog.setVisible(true);
		
		
		
		
	}
	
	public static void setupActionListener(JButton button, final JDialog dialog) {
		ActionListener btnListener = new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				JButton jbutton = (JButton) ae.getSource();
				jbutton.getText();
				
				if(jbutton.getText().equals("vs Player")) {
					GlobalValue.gameType = "Player";
				}else {
					GlobalValue.gameType = "Computer";
				}
				
				dialog.dispose();
			}
		};
		
		button.addActionListener(btnListener);
	}

}
