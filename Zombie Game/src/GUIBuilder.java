import javax.swing.*;
import java.awt.*;
public class GUIBuilder 
{
	Font standard = new Font("TimesRoman", Font.PLAIN, 16);
	FlowLayout layout = new FlowLayout(SwingConstants.LEADING, 25, 15);
	
	public JButton makeButton(String text, int x, int y, int width, int height, Color background, Color foreground, boolean visible)
	{
		JButton button = new JButton(text);
		button.setBounds(x,y,width,height);
		button.setBackground(background);
		button.setForeground(foreground);
		button.setVisible(visible);
		return button;
	}
	
	public JLabel makeLabel(String text)
	{
		JLabel label = new JLabel(text);
		label.setFont(standard);
		label.setForeground(Color.green);
		return label;
	}
	
	public JPanel makePanelWithLabel(int x, int y, int width, int height, JLabel label)
	{
		JPanel panel = new JPanel(layout);
		panel.setBackground(Color.black);
		panel.setBounds(x,y,width,height);
		panel.add(label);
		return panel;
	}
	
	//Overloaded method to handle setting visibility.
	public JPanel makePanelWithLabel(int x, int y, int width, int height, JLabel label, boolean visible)
	{
		JPanel panel = new JPanel(layout);
		panel.setBackground(Color.black);
		panel.setBounds(x,y,width,height);
		panel.add(label);
		panel.setVisible(visible);
		return panel;
	}
	
	public JPanel makePanelWithTextAndLabel(int x, int y, int width, int height, JTextField text, JLabel label, boolean visible)
	{
		JPanel panel = new JPanel(layout);
		panel.setBackground(Color.black);
		panel.setBounds(x,y,width,height);
		panel.add(label);
		panel.add(text);
		panel.setVisible(visible);
		return panel;
	}
}
