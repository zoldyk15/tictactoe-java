package tictactoe;

import javax.swing.JButton;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class CustomButton extends JButton{
	private static final long serialVersionUID = -4206918716213245910L;
	
	private ButtonValue value;
	private int position;

}
