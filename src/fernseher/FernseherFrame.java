package fernseher;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class FernseherFrame extends JFrame {
	
	private JPanel panel;
	private JLabel bildLabel;
	private JTextArea textArea;
	public String number;

	public FernseherFrame()
	{
		super("Fernseher");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		textArea = new JTextArea();
		panel.setBackground(Color.WHITE);
		
		bildLabel = new JLabel(new ImageIcon(getClass().getResource("/images/fernsehraus.png")));
		panel.add(bildLabel);
		panel.add(textArea);

		this.setSize(500, 500);
		this.setVisible(true);
		this.add(panel);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setLocation(screenWidth / 2, screenHeight / 6);
	}

	public void turnOn() {
		bildLabel.setIcon(new ImageIcon(getClass().getResource("/images/rock.gif")));
		textArea.setText(number);
	}

	public void turnOff() {
		bildLabel.setIcon(new ImageIcon(getClass().getResource("/images/fernsehraus.png")));
	}
	
	public void message(String msg) {
		textArea.setText(msg);
	}

	

}
