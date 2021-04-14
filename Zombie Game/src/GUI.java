import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/*	
 * 	Current version as of 4/14/2021 Last Edited by Bryan Polk
 * 	GUI class creates a GUI for the user to input 6 values and begin simulation, which instantiates a SimulationManager
 * 	then Simulation is conducted and output to console after inputs are verified through UserDefinedData class.
 */
public class GUI implements ActionListener
{
	//Declare global objects
	Font standard;
	JFrame frame;
	JButton start, pause, end;
	JTextField transmissionInput, mutationInput, groupSizeInput, iterationInput, lethalityInput, lifespanInput;
	JLabel transmissionLabel, mutationLabel, groupSizeLabel, iterationLabel, lethalityLabel, lifespanLabel;
	JPanel transmission, mutation,  groupSize, iteration, lethality, lifespan;
	UserDefinedData userInputs;
	public GUI()
	{
		//Create default font and instantiate UserDefinedData.
		standard = new Font("TimesRoman", Font.PLAIN, 16);
		userInputs = new UserDefinedData();
		
		
		//Create the frame
		frame = new JFrame("The Zombie Simulation");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900, 600);
		frame.getContentPane().setBackground(Color.black);
		frame.setLayout(null);
		
		//Create transmission range input section
		transmission = new JPanel(new FlowLayout(SwingConstants.LEADING, 25, 15));
		transmission.setBounds(50, 75, 275, 100);
		transmission.setBackground(Color.black);
		transmissionInput = new JTextField("", 20);
		transmissionLabel = new JLabel("Transmission Range: 0.5-10.0");
		transmissionLabel.setFont(standard);
		transmissionLabel.setForeground(Color.green);
		transmission.add(transmissionLabel);
		transmission.add(transmissionInput);
		
		//Create mutation rate input section
		mutation = new JPanel(new FlowLayout(SwingConstants.LEADING, 25, 15));
		mutation.setBounds(50, 250, 275, 100);
		mutation.setBackground(Color.black);
		mutationInput = new JTextField("", 20);
		mutationLabel = new JLabel("Mutation Rate: 0-3 Integer");
		mutationLabel.setFont(standard);
		mutationLabel.setForeground(Color.green);
		mutation.add(mutationLabel);
		mutation.add(mutationInput);
		
		//Create lethality input section
		lethality = new JPanel(new FlowLayout(SwingConstants.LEADING, 25, 15));
		lethality.setBounds(50, 425, 275, 100);
		lethality.setBackground(Color.black);
		lethalityInput = new JTextField("", 20);
		lethalityLabel = new JLabel("Lethality: 1.0-10.0");
		lethalityLabel.setFont(standard);
		lethalityLabel.setForeground(Color.green);
		lethality.add(lethalityLabel);
		lethality.add(lethalityInput);
		
		//Create lifespan input section
		lifespan = new JPanel(new FlowLayout(SwingConstants.LEADING, 25, 15));
		lifespan.setBounds(575, 75, 275, 100);
		lifespan.setBackground(Color.black);
		lifespanInput = new JTextField("", 20);
		lifespanLabel = new JLabel("Lifespan: 5-28 Integer");
		lifespanLabel.setFont(standard);
		lifespanLabel.setForeground(Color.green);
		lifespan.add(lifespanLabel);
		lifespan.add(lifespanInput);
		
		//Create group size input section
		groupSize = new JPanel(new FlowLayout(SwingConstants.LEADING, 25, 15));
		groupSize.setBounds(575, 250, 275, 100);
		groupSize.setBackground(Color.black);
		groupSizeInput = new JTextField("", 20);
		groupSizeLabel = new JLabel("Size of Groups: > 0 Integer");
		groupSizeLabel.setFont(standard);
		groupSizeLabel.setForeground(Color.green);
		groupSize.add(groupSizeLabel);
		groupSize.add(groupSizeInput);
		
		//Create iterations input section
		iteration = new JPanel(new FlowLayout(SwingConstants.LEADING, 25, 15));
		iteration.setBounds(575, 425, 275, 100);
		iteration.setBackground(Color.black);
		iterationInput = new JTextField("", 20);
		iterationLabel = new JLabel("Number of Iterations: > 0 Integer");
		iterationLabel.setFont(standard);
		iterationLabel.setForeground(Color.green);
		iteration.add(iterationLabel);
		iteration.add(iterationInput);
		
		
		//Add the panels to the frame
		frame.add(transmission);
		frame.add(mutation);
		frame.add(lethality);
		frame.add(lifespan);
		frame.add(groupSize);
		frame.add(iteration);
		
		//Add buttons to start/pause/end simulation. END IS NOT IN USE CURRENTLY.
		start = new JButton("Run Simulation");
		start.setBounds(375, 250, 150, 100);
		start.setBackground(Color.gray);
		start.setForeground(Color.green);
		start.setVisible(true);
		frame.add(start);
		start.addActionListener(this);
		
		pause = new JButton("Pause");
		pause.setBounds(375, 400, 150, 100);
		pause.setBackground(Color.gray);
		pause.setForeground(Color.green);
		pause.setVisible(false);
		frame.add(pause);
		pause.addActionListener(this);
		
		
		
		transmissionInput.setVisible(true);
		transmissionLabel.setVisible(true);
		frame.setVisible(true);
	}
	
	
	
	
	
	
	
	
	
	private void displayInputMenu()
	{
		transmission.setVisible(true);
		mutation.setVisible(true);
		lethality.setVisible(true);
		lifespan.setVisible(true);
		groupSize.setVisible(true);
		iteration.setVisible(true);
		start.setVisible(true);
		pause.setVisible(false);
	}
	
	private void simulate()
	{
		while (userInputs.getIterations() > 0) {
			SimulationManager sim1 = new SimulationManager(userInputs);
			sim1.runSim();
			userInputs.setIterations(userInputs.getIterations()-1);
		}

	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == start)
		{
			//Start simulation
			String[] userData = new String[6];
			userData[0] = transmissionInput.getText();
			userData[1] = mutationInput.getText();
			userData[2] = lethalityInput.getText();
			userData[3] = lifespanInput.getText();
			userData[4] = groupSizeInput.getText();
			userData[5] = iterationInput.getText();
			if(userInputs.defineData(userData))
			{
				transmission.setVisible(false);
				mutation.setVisible(false);
				lethality.setVisible(false);
				lifespan.setVisible(false);
				groupSize.setVisible(false);
				iteration.setVisible(false);
				start.setVisible(false);
				pause.setVisible(true);
				simulate();
			}
		}
		
		if(e.getSource() == pause)
		{
			displayInputMenu();
		}
		
	}
	
	
	
}
