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
	JPanel intro1, intro2, intro3, intro4, intro5, intro6;
	JLabel intro1Label, intro2Label, intro3Label, intro4Label, intro5Label, intro6Label;
	JButton introStart, loadPresets, savePresets, start, end;
	JTextField headerInput, transmissionInput, mutationInput, groupSizeInput, iterationInput, lethalityInput, lifespanInput;
	JLabel headerLabel, transmissionLabel, mutationLabel, groupSizeLabel, iterationLabel, lethalityLabel, lifespanLabel;
	JPanel header, transmission, mutation,  groupSize, iteration, lethality, lifespan;
	JPanel susceptible, infected, recovered, dead, goodbye, addIterations;
	JLabel susceptibleLabel, infectedLabel, recoveredLabel, deadLabel, goodbyeLabel, addIterationsLabel;
	JButton conclude, resume, results;
	JButton cancel, saveYes, saveNo;
	JButton cancel1, iterationsOnly, changeVariables;
	UserDefinedData userInputs;
	private SimulationManager name;
	private boolean simulated;
	//private SimulationManager name = new SimulationManager();

	public GUI(SimulationManager stuff)
	{
		simulated = false;
		name = stuff;
		//Create default font and instantiate UserDefinedData.
		standard = new Font("TimesRoman", Font.PLAIN, 16);
		userInputs = new UserDefinedData();

		//Create the frame
		frame = new JFrame("The Zombie Simulation");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900, 600);
		frame.getContentPane().setBackground(Color.black);
		frame.setLayout(null);

		//Create introduction labels
		intro1 = new JPanel(new FlowLayout(SwingConstants.LEADING, 25, 15));
		intro1.setBounds(200, 100, 600, 50);
		intro1.setBackground(Color.black);
		intro1Label = new JLabel("Hello! Welcome to Team Plague's disease simulation software!");
		intro1Label.setFont(standard);
		intro1Label.setForeground(Color.green);
		intro1.add(intro1Label);
		frame.add(intro1);
		
		intro2 = new JPanel(new FlowLayout(SwingConstants.LEADING, 25, 15));
		intro2.setBounds(100, 150, 650, 50);
		intro2.setBackground(Color.black);
		intro2Label = new JLabel("This software will take in your inputs and show how your disease affects a population group.");
		intro2Label.setFont(standard);
		intro2Label.setForeground(Color.green);
		intro2.add(intro2Label);
		frame.add(intro2);
		
		intro3 = new JPanel(new FlowLayout(SwingConstants.LEADING, 25, 15));
		intro3.setBounds(25, 200, 750, 50);
		intro3.setBackground(Color.black);
		intro3Label = new JLabel("The following screen will ask you to input your disease's transmission range, lifespan, mutation rate, and lethality.");
		intro3Label.setFont(standard);
		intro3Label.setForeground(Color.green);
		intro3.add(intro3Label);
		frame.add(intro3);
		
		intro4 = new JPanel(new FlowLayout(SwingConstants.LEADING, 25, 15));
		intro4.setBounds(125, 250, 600, 50);
		intro4.setBackground(Color.black);
		intro4Label = new JLabel("In addition, you will need to input your population size and number of iterations to run.");
		intro4Label.setFont(standard);
		intro4Label.setForeground(Color.green);
		intro4.add(intro4Label);
		frame.add(intro4);
		
		intro5 = new JPanel(new FlowLayout(SwingConstants.LEADING, 25, 15));
		intro5.setBounds(175, 300, 600, 50);
		intro5.setBackground(Color.black);
		intro5Label = new JLabel("At the end of the simulation, you will have the option to save your outputs.");
		intro5Label.setFont(standard);
		intro5Label.setForeground(Color.green);
		intro5.add(intro5Label);
		frame.add(intro5);
		
		intro6 = new JPanel(new FlowLayout(SwingConstants.LEADING, 25, 15));
		intro6.setBounds(275, 350, 600, 50);
		intro6.setBackground(Color.black);
		intro6Label = new JLabel("And that's it! Are you ready to start?");
		intro6Label.setFont(standard);
		intro6Label.setForeground(Color.green);
		intro6.add(intro6Label);
		frame.add(intro6);
		
		//Create intro start button
		introStart = new JButton("Yes! Let's go!");
		introStart.setBounds(335, 400, 150, 100);
		introStart.setBackground(Color.gray);
		introStart.setForeground(Color.green);
		introStart.setVisible(true);
		frame.add(introStart);
		introStart.addActionListener(this);
		
		loadPresets = new JButton("Load Preset Values");
		loadPresets.setBounds(375, 100, 150, 100);
		loadPresets.setBackground(Color.gray);
		loadPresets.setForeground(Color.green);
		loadPresets.setVisible(false);
		frame.add(loadPresets);
		loadPresets.addActionListener(this);
		
		savePresets = new JButton("Save Preset Values");
		savePresets.setBounds(375, 250, 150, 100);
		savePresets.setBackground(Color.gray);
		savePresets.setForeground(Color.green);
		savePresets.setVisible(false);
		frame.add(savePresets);
		savePresets.addActionListener(this);
		
		//Create File Header Input Field
		header = new JPanel(new FlowLayout(SwingConstants.LEADING, 25, 15));
		header.setBounds(315, 5, 275, 100);
		header.setBackground(Color.black);
		headerInput = new JTextField("", 20);
		headerLabel = new JLabel("File Name: (If loading/saving presets)");
		headerLabel.setFont(standard);
		headerLabel.setForeground(Color.green);
		header.add(headerLabel);
		header.add(headerInput);
		header.setVisible(false);
		
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
		transmission.setVisible(false);
		
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
		mutation.setVisible(false);

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
		lethality.setVisible(false);
		
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
		lifespan.setVisible(false);

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
		groupSize.setVisible(false);

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
		iteration.setVisible(false);

		//Add the panels to the frame
		frame.add(header);
		frame.add(transmission);
		frame.add(mutation);
		frame.add(lethality);
		frame.add(lifespan);
		frame.add(groupSize);
		frame.add(iteration);

		//Add buttons to start/end simulation. END IS NOT IN USE CURRENTLY.
		start = new JButton("Run Simulation");
		start.setBounds(375, 400, 150, 100);
		start.setBackground(Color.gray);
		start.setForeground(Color.green);
		start.setVisible(false);
		frame.add(start);
		start.addActionListener(this);

		//Create susceptible head count
		susceptible = new JPanel(new FlowLayout(SwingConstants.LEADING, 25, 15));
		susceptible.setBounds(50, 75, 325, 100);
		susceptible.setBackground(Color.black);
		susceptibleLabel = new JLabel("Total number of susceptible people: " + name.getMinorGroup().getNumSusceptible());
		susceptibleLabel.setFont(standard);
		susceptibleLabel.setForeground(Color.green);
		susceptible.add(susceptibleLabel);
		susceptible.setVisible(false);

		//Create Infected head count
		infected = new JPanel(new FlowLayout(SwingConstants.LEADING, 25, 15));
		infected.setBounds(50, 175, 325, 100);
		infected.setBackground(Color.black);
		infectedLabel = new JLabel("Total number of infected people: " + name.getMinorGroup().getNumInfected());
		infectedLabel.setFont(standard);
		infectedLabel.setForeground(Color.green);
		infected.add(infectedLabel);
		infected.setVisible(false);

		//Create Recovered head count
		recovered = new JPanel(new FlowLayout(SwingConstants.LEADING, 25, 15));
		recovered.setBounds(50, 275, 325, 100);
		recovered.setBackground(Color.black);
		recoveredLabel = new JLabel("Total number of recovered people: " + name.getMinorGroup().getNumRecovered());
		recoveredLabel.setFont(standard);
		recoveredLabel.setForeground(Color.green);
		recovered.add(recoveredLabel);
		recovered.setVisible(false);

		//Create Dead head count
		dead = new JPanel(new FlowLayout(SwingConstants.LEADING, 25, 15));
		dead.setBounds(50, 375, 325, 100);
		dead.setBackground(Color.black);
		deadLabel = new JLabel("Total number of dead people: " + name.getMinorGroup().getNumDead());
		deadLabel.setFont(standard);
		deadLabel.setForeground(Color.green);
		dead.add(deadLabel);
		dead.setVisible(false);


		frame.add(susceptible);
		frame.add(infected);
		frame.add(recovered);
		frame.add(dead);

		//Add buttons to conclude/continue simulation.
		resume = new JButton("Continue Simulation?");
		resume.setBounds(600, 150, 150, 100);
		resume.setBackground(Color.gray);
		resume.setForeground(Color.green);
		resume.setVisible(false);
		frame.add(resume);
		resume.addActionListener(this);

		conclude = new JButton("Conclude Simulation?");
		conclude.setBounds(600, 300, 150, 100);
		conclude.setBackground(Color.gray);
		conclude.setForeground(Color.green);
		conclude.setVisible(false);
		frame.add(conclude);
		conclude.addActionListener(this);

		//Add buttons to save results/not save/cancel and resume simulation.
		cancel = new JButton("Cancel and Go Back!");
		cancel.setBounds(600, 450, 200, 100);
		cancel.setBackground(Color.gray);
		cancel.setForeground(Color.green);
		cancel.setVisible(false);
		frame.add(cancel);
		cancel.addActionListener(this);

		saveYes = new JButton("Yes, save the results!");
		saveYes.setBounds(600, 150, 200, 100);
		saveYes.setBackground(Color.gray);
		saveYes.setForeground(Color.green);
		saveYes.setVisible(false);
		frame.add(saveYes);
		saveYes.addActionListener(this);

		saveNo = new JButton("No, I don't need to save.");
		saveNo.setBounds(600, 300, 200, 100);
		saveNo.setBackground(Color.gray);
		saveNo.setForeground(Color.green);
		saveNo.setVisible(false);
		frame.add(saveNo);
		saveNo.addActionListener(this);

		//add button to see results
		results = new JButton("See Results");
		results.setBounds(375, 200, 150, 100);
		results.setBackground(Color.gray);
		results.setForeground(Color.green);
		results.setVisible(false);
		frame.add(results);
		results.addActionListener(this);

		//Create goodbye label
		goodbye = new JPanel(new FlowLayout(SwingConstants.LEADING, 25, 15));
		goodbye.setBounds(200, 250, 600, 100);
		goodbye.setBackground(Color.black);
		goodbyeLabel = new JLabel("Team Plague thanks you for using our disease simulation software! Goodbye!");
		goodbyeLabel.setFont(standard);
		goodbyeLabel.setForeground(Color.green);
		goodbye.add(goodbyeLabel);
		goodbye.setVisible(false);
		frame.add(goodbye);

		//Add buttons to add iterations/change variables/cancel and go back and label asking question
		cancel1 = new JButton("Cancel and Go Back!");
		cancel1.setBounds(600, 450, 250, 100);
		cancel1.setBackground(Color.gray);
		cancel1.setForeground(Color.green);
		cancel1.setVisible(false);
		frame.add(cancel1);
		cancel1.addActionListener(this);

		iterationsOnly = new JButton("Add iterations only.");
		iterationsOnly.setBounds(600, 150, 250, 100);
		iterationsOnly.setBackground(Color.gray);
		iterationsOnly.setForeground(Color.green);
		iterationsOnly.setVisible(false);
		frame.add(iterationsOnly);
		iterationsOnly.addActionListener(this);

		changeVariables = new JButton("Add iterations and change variables");
		changeVariables.setBounds(600, 300, 250, 100);
		changeVariables.setBackground(Color.gray);
		changeVariables.setForeground(Color.green);
		changeVariables.setVisible(false);
		frame.add(changeVariables);
		changeVariables.addActionListener(this);

		addIterations = new JPanel(new FlowLayout(SwingConstants.LEADING, 25, 15));
		addIterations.setBounds(450, 50, 600, 100);
		addIterations.setBackground(Color.black);
		addIterationsLabel = new JLabel("Would you like to change your variables? Or only add iterations?");
		addIterationsLabel.setFont(standard);
		addIterationsLabel.setForeground(Color.green);
		addIterations.add(addIterationsLabel);
		addIterations.setVisible(false);
		frame.add(addIterations);




		transmissionInput.setVisible(true);
		transmissionLabel.setVisible(true);
		frame.setVisible(true);
	}
	
	private void displayInputMenu()
	{
		header.setVisible(true);
		transmission.setVisible(true);
		mutation.setVisible(true);
		lethality.setVisible(true);
		lifespan.setVisible(true);
		groupSize.setVisible(true);
		iteration.setVisible(true);
		start.setVisible(true);
		savePresets.setVisible(true);
		loadPresets.setVisible(true);
		susceptible.setVisible(false);
		infected.setVisible(false);
		recovered.setVisible(false);
		dead.setVisible(false);
		resume.setVisible(false);
		conclude.setVisible(false);
		cancel.setVisible(false);
		saveYes.setVisible(false);
		saveNo.setVisible(false);
		results.setVisible(false);
		goodbye.setVisible(false);
		cancel1.setVisible(false);
		addIterations.setVisible(false);
		iterationsOnly.setVisible(false);
		changeVariables.setVisible(false);
		intro1.setVisible(false);
		intro2.setVisible(false);
		intro3.setVisible(false);
		intro4.setVisible(false);
		intro5.setVisible(false);
		intro6.setVisible(false);
		introStart.setVisible(false);

	}

	private void displaySimulationEndMenu()
	{
		header.setVisible(false);
		transmission.setVisible(false);
		mutation.setVisible(false);
		lethality.setVisible(false);
		lifespan.setVisible(false);
		groupSize.setVisible(false);
		iteration.setVisible(false);
		start.setVisible(false);
		savePresets.setVisible(false);
		loadPresets.setVisible(false);
		susceptible.setVisible(true);
		infected.setVisible(true);
		recovered.setVisible(true);
		dead.setVisible(true);
		resume.setVisible(true);
		conclude.setVisible(true);
		cancel.setVisible(false);
		saveYes.setVisible(false);
		saveNo.setVisible(false);
		results.setVisible(false);
		goodbye.setVisible(false);
		cancel1.setVisible(false);
		addIterations.setVisible(false);
		iterationsOnly.setVisible(false);
		changeVariables.setVisible(false);
		intro1.setVisible(false);
		intro2.setVisible(false);
		intro3.setVisible(false);
		intro4.setVisible(false);
		intro5.setVisible(false);
		intro6.setVisible(false);
		introStart.setVisible(false);
	}

	private void displayAddIterationsMenu()
	{
		header.setVisible(false);
		transmission.setVisible(false);
		mutation.setVisible(false);
		lethality.setVisible(false);
		lifespan.setVisible(false);
		groupSize.setVisible(false);
		iteration.setVisible(false);
		start.setVisible(false);
		savePresets.setVisible(false);
		loadPresets.setVisible(false);
		susceptible.setVisible(true);
		infected.setVisible(true);
		recovered.setVisible(true);
		dead.setVisible(true);
		resume.setVisible(false);
		conclude.setVisible(false);
		cancel.setVisible(false);
		saveYes.setVisible(false);
		saveNo.setVisible(false);
		results.setVisible(false);
		goodbye.setVisible(false);
		cancel1.setVisible(true);
		addIterations.setVisible(true);
		iterationsOnly.setVisible(true);
		changeVariables.setVisible(true);
		intro1.setVisible(false);
		intro2.setVisible(false);
		intro3.setVisible(false);
		intro4.setVisible(false);
		intro5.setVisible(false);
		intro6.setVisible(false);
		introStart.setVisible(false);
	}

	private void displayProgramEndMenu()
	{
		header.setVisible(false);
		transmission.setVisible(false);
		mutation.setVisible(false);
		lethality.setVisible(false);
		lifespan.setVisible(false);
		groupSize.setVisible(false);
		iteration.setVisible(false);
		start.setVisible(false);
		savePresets.setVisible(false);
		loadPresets.setVisible(false);
		susceptible.setVisible(true);
		infected.setVisible(true);
		recovered.setVisible(true);
		dead.setVisible(true);
		resume.setVisible(false);
		conclude.setVisible(false);
		cancel.setVisible(true);
		saveYes.setVisible(true);
		saveNo.setVisible(true);
		results.setVisible(false);
		goodbye.setVisible(false);
		cancel1.setVisible(false);
		addIterations.setVisible(false);
		iterationsOnly.setVisible(false);
		changeVariables.setVisible(false);
		intro1.setVisible(false);
		intro2.setVisible(false);
		intro3.setVisible(false);
		intro4.setVisible(false);
		intro5.setVisible(false);
		intro6.setVisible(false);
		introStart.setVisible(false);
	}

	private void displayGoodbyeWindow()
	{
		header.setVisible(false);
		transmission.setVisible(false);
		mutation.setVisible(false);
		lethality.setVisible(false);
		lifespan.setVisible(false);
		groupSize.setVisible(false);
		iteration.setVisible(false);
		start.setVisible(false);
		savePresets.setVisible(false);
		loadPresets.setVisible(false);
		susceptible.setVisible(false);
		infected.setVisible(false);
		recovered.setVisible(false);
		dead.setVisible(false);
		resume.setVisible(false);
		conclude.setVisible(false);
		cancel.setVisible(false);
		saveYes.setVisible(false);
		saveNo.setVisible(false);
		results.setVisible(false);
		goodbye.setVisible(true);
		cancel1.setVisible(false);
		addIterations.setVisible(false);
		iterationsOnly.setVisible(false);
		changeVariables.setVisible(false);
		intro1.setVisible(false);
		intro2.setVisible(false);
		intro3.setVisible(false);
		intro4.setVisible(false);
		intro5.setVisible(false);
		intro6.setVisible(false);
		introStart.setVisible(false);
	}

	private void simulate(){
		if(!simulated)
		{
			name = new SimulationManager(userInputs);
		}
		name.runSim(simulated);
		name.getMinorGroup().checkTotals();
		
		deadLabel.setText("Total number of dead people: " + name.getMinorGroup().getNumDead());
		recoveredLabel.setText("Total number of recovered people: " + name.getMinorGroup().getNumRecovered());
		infectedLabel.setText("Total number of infected people: " + name.getMinorGroup().getNumInfected());
		susceptibleLabel.setText("Total number of susceptible people: " + name.getMinorGroup().getNumSusceptible());
		simulated = true;


		//if (userInputs.getIterations() == 0) {
		//	displaySimulationEndMenu();
		//}
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == introStart)
		{
			displayInputMenu();
			//Tell Simulation to Go
			
		}
		
		if(e.getSource() == loadPresets)
		{
			//load presets
			//headerInput is textfield name
			float[] preValues = new float[6];
			preValues = name.recorder.readPreset(headerInput.getText());
			lethalityInput.setText(Float.toString(preValues[0]));
			transmissionInput.setText(Float.toString(preValues[1])); 
			lifespanInput.setText(Integer.toString( (int) preValues[2])); 
			mutationInput.setText(Integer.toString( (int) preValues[3])); 
			iterationInput.setText(Integer.toString( (int) preValues[4])); 
			groupSizeInput.setText(Integer.toString( (int) preValues[5])); 
		}
		
		if(e.getSource() == savePresets)
		{
			//save textfield inputs as presets
			try {
				name.recorder.savePreset(
					headerInput.getText(),
					Float.parseFloat(lethalityInput.getText()),
					Float.parseFloat(transmissionInput.getText()),
					Integer.parseInt(lifespanInput.getText()),
					Integer.parseInt(mutationInput.getText()),
					Integer.parseInt(iterationInput.getText()),
					Integer.parseInt(groupSizeInput.getText())
				);
			}catch(NumberFormatException numEx){
				System.out.println("Wrong Data Type!");
				numEx.printStackTrace();
			}
		}
		
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
				header.setVisible(false);
				transmission.setVisible(false);
				mutation.setVisible(false);
				lethality.setVisible(false);
				lifespan.setVisible(false);
				groupSize.setVisible(false);
				iteration.setVisible(false);
				start.setVisible(false);
				savePresets.setVisible(false);
				loadPresets.setVisible(false);
				simulate();
				susceptible.setVisible(true);
				infected.setVisible(true);
				recovered.setVisible(true);
				dead.setVisible(true);
				resume.setVisible(false);
				conclude.setVisible(false);
				cancel.setVisible(false);
				saveYes.setVisible(false);
				saveNo.setVisible(false);
				results.setVisible(true);
				goodbye.setVisible(false);
				intro1.setVisible(false);
				intro2.setVisible(false);
				intro3.setVisible(false);
				intro4.setVisible(false);
				intro5.setVisible(false);
				intro6.setVisible(false);
				introStart.setVisible(false);
			}

		}


		if(e.getSource() == results)
		{
			displaySimulationEndMenu();
		}

		//ask for more iterations/new variables if user clicks resume
		if(e.getSource() == resume)
		{
			displayAddIterationsMenu();
		}

		//go back to previous screen if user presses cancel
		if(e.getSource() == cancel1)
		{
			displaySimulationEndMenu();
		}

		//Ask for more iterations
		if(e.getSource() == iterationsOnly)
		{
			//ask for more iterations
		}

		//Ask for new variables
		if(e.getSource() == changeVariables)
		{
			displayInputMenu();
		}

		//conclude program if user wants to end
		if(e.getSource() == conclude)
		{
			displayProgramEndMenu(); //asks if want to save yes/no
		}

		//go back to previous screen if user presses cancel
		if(e.getSource() == cancel)
		{
			displaySimulationEndMenu(); //shows outputs, continue or end?
		}

		//shows data to be saved, name of file?
		if(e.getSource() == saveYes)
		{
			//do something
			
		}

		//end the program, thank you window
		if(e.getSource() == saveNo)
		{
			displayGoodbyeWindow();
		}
	}

}
