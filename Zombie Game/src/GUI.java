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
	private GUIBuilder builder;
	//private SimulationManager name = new SimulationManager();

	public GUI(SimulationManager stuff)
	{
		builder = new GUIBuilder();
		simulated = false;
		name = stuff;
		//Create default font and instantiate UserDefinedData.
		userInputs = new UserDefinedData();

		//Create the frame
		frame = new JFrame("The Zombie Simulation");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900, 600);
		frame.getContentPane().setBackground(Color.black);
		frame.setLayout(null);

		
		initializeIntro();
		
		
		initializeInputFields();
		

		initializeStatsScreen();

		
		initializeSaveOptions();

		
		initializeGoodBye();

		
		initializeExtraIterations();


		frame.setVisible(true);
	}
	
	
	private void initializeIntro()
	{
		//Create introduction labels
		intro1Label = builder.makeLabel("Hello! Welcome to Team Plague's disease simulation software!");
		intro1 = builder.makePanelWithLabel(200, 100, 600, 50, intro1Label);
		frame.add(intro1);
		
		intro2Label = builder.makeLabel("This software will take in your inputs and show how your disease affects a population group.");
		intro2 = builder.makePanelWithLabel(100, 150, 650, 50, intro2Label);
		frame.add(intro2);
		
		intro3Label = builder.makeLabel("The following screen will ask you to input your disease's transmission range, lifespan, mutation rate, and lethality.");
		intro3 = builder.makePanelWithLabel(25, 200, 750, 50, intro3Label);
		frame.add(intro3);
		
		intro4Label = builder.makeLabel("In addition, you will need to input your population size and number of iterations to run.");
		intro4 = builder.makePanelWithLabel(125, 250, 600, 50, intro4Label);
		frame.add(intro4);

		intro5Label = builder.makeLabel("At the end of the simulation, you will have the option to save your outputs.");
		intro5 = builder.makePanelWithLabel(175, 300, 600, 50, intro5Label);
		frame.add(intro5);

		intro6Label = builder.makeLabel("And that's it! Are you ready to start?");
		intro6 = builder.makePanelWithLabel(275, 350, 600, 50, intro6Label);
		frame.add(intro6);
		
		//Create intro start button
		introStart = builder.makeButton("Yes, let's go!", 335, 400, 150, 100, Color.gray, Color.green, true);
		frame.add(introStart);
		introStart.addActionListener(this);
	}
	
	
	
	private void initializeInputFields()
	{
		loadPresets = builder.makeButton("Load Preset Values", 375, 100, 150, 100, Color.gray, Color.green, false);
		frame.add(loadPresets);
		loadPresets.addActionListener(this);
		
		savePresets = builder.makeButton("Save Preset Values", 375, 250, 150, 100, Color.gray, Color.green, false);
		frame.add(savePresets);
		savePresets.addActionListener(this);
		
		//Add button to start simulation.
		start = builder.makeButton("Run Simulation", 375, 400, 150, 100, Color.gray, Color.green, false);
		frame.add(start);
		start.addActionListener(this);
		
		//Create File Header Input Field
		headerInput = new JTextField("", 20);
		headerLabel = builder.makeLabel("File Name: (If loading/saving presets)");
		header = builder.makePanelWithTextAndLabel(315, 5, 275, 100, headerInput, headerLabel, false);
		
		//Create transmission range input section
		transmissionInput = new JTextField("", 20);
		transmissionLabel = builder.makeLabel("Transmission Range: 0.5-10.0");
		transmission = builder.makePanelWithTextAndLabel(50, 75, 275, 100, transmissionInput, transmissionLabel, false);
		
		//Create mutation rate input section
		mutationInput = new JTextField("", 20);
		mutationLabel = builder.makeLabel("Mutation Rate: 0-3 Integer");
		mutation = builder.makePanelWithTextAndLabel(50, 250, 275, 100, mutationInput, mutationLabel, false);

		//Create lethality input section
		lethalityInput = new JTextField("", 20);
		lethalityLabel = builder.makeLabel("Lethality: 1.0-10.0");
		lethality = builder.makePanelWithTextAndLabel(50, 425, 275, 100, lethalityInput, lethalityLabel, false);
		
		//Create lifespan input section
		lifespanInput = new JTextField("", 20);
		lifespanLabel = builder.makeLabel("Lifespan: 5-28 Integer");
		lifespan = builder.makePanelWithTextAndLabel(575, 75, 275, 100, lifespanInput, lifespanLabel, false);

		//Create group size input section
		groupSizeInput = new JTextField("", 20);
		groupSizeLabel = builder.makeLabel("Size of Groups: > 0 Integer");
		groupSize = builder.makePanelWithTextAndLabel(575, 250, 275, 100, groupSizeInput, groupSizeLabel, false);

		//Create iterations input section
		iterationInput = new JTextField("", 20);
		iterationLabel = builder.makeLabel("Number of Iterations: > 0 Integer");
		iteration = builder.makePanelWithTextAndLabel(575, 425, 275, 100, iterationInput, iterationLabel, false);
		
		//Add the panels to the frame
		frame.add(header);
		frame.add(transmission);
		frame.add(mutation);
		frame.add(lethality);
		frame.add(lifespan);
		frame.add(groupSize);
		frame.add(iteration);
		
	}
	
	
	private void initializeStatsScreen()
	{
		//Create susceptible head count
		susceptibleLabel = builder.makeLabel("Total number of susceptible people: " + name.getMinorGroup().getNumSusceptible());
		susceptible = builder.makePanelWithLabel(50, 75, 325, 100, susceptibleLabel, false);
	
		//Create Infected head count
		infectedLabel = builder.makeLabel("Total number of infected people: " + name.getMinorGroup().getNumInfected());
		infected = builder.makePanelWithLabel(50, 175, 325, 100, infectedLabel, false);
	
		//Create Recovered head count
		recoveredLabel = builder.makeLabel("Total number of recovered people: " + name.getMinorGroup().getNumRecovered());
		recovered = builder.makePanelWithLabel(50, 275, 325, 100, recoveredLabel, false);
	
		//Create Dead head count
		deadLabel = builder.makeLabel("Total number of dead people: " + name.getMinorGroup().getNumDead());
		dead = builder.makePanelWithLabel(50, 375, 325, 100, deadLabel, false);
	
		frame.add(susceptible);
		frame.add(infected);
		frame.add(recovered);
		frame.add(dead);
	
		//add button to see results
		results  = builder.makeButton("See Results", 375, 200, 150, 100, Color.gray, Color.green, false);
		frame.add(results);
		results.addActionListener(this);
		
		//Add buttons to conclude/continue simulation.
		resume = builder.makeButton("Continue Simulation?", 600, 150, 150, 100, Color.gray, Color.green, false);
		frame.add(resume);
		resume.addActionListener(this);
	
		conclude  = builder.makeButton("Conclude Simulation?", 600, 300, 150, 100, Color.gray, Color.green, false);
		frame.add(conclude);
		conclude.addActionListener(this);
	}
	
	
	
	private void initializeSaveOptions()
	{
		//Add buttons to save results/not save/cancel and resume simulation.
		cancel  = builder.makeButton("Cancel and go back!", 600, 450, 200, 100, Color.gray, Color.green, false);
		frame.add(cancel);
		cancel.addActionListener(this);

		saveYes  = builder.makeButton("Yes, save the results!", 600, 150, 200, 100, Color.gray, Color.green, false);
		frame.add(saveYes);
		saveYes.addActionListener(this);

		
		saveNo  = builder.makeButton("No, I don't need to save.", 600, 300, 200, 100, Color.gray, Color.green, false);
		frame.add(saveNo);
		saveNo.addActionListener(this);
	}
	
	
	private void initializeGoodBye()
	{
		//Create goodbye label
		goodbyeLabel = builder.makeLabel("Team Plague thanks you for using our disease simulation software! Goodbye!");
		goodbye = builder.makePanelWithLabel(200, 250, 600, 100, goodbyeLabel, false);
		frame.add(goodbye);
	}
	
	
	private void initializeExtraIterations()
	{
		//Add buttons to add iterations/change variables/cancel and go back and label asking question
		cancel1  = builder.makeButton("Cancel and Go Back!", 600, 450, 250, 100, Color.gray, Color.green, false);
		frame.add(cancel1);
		cancel1.addActionListener(this);

		iterationsOnly  = builder.makeButton("Add iterations only.", 600, 150, 250, 100, Color.gray, Color.green, false);
		frame.add(iterationsOnly);
		iterationsOnly.addActionListener(this);

		changeVariables = builder.makeButton("Add iterations and change variables", 600, 300, 250, 100, Color.gray, Color.green, false);
		frame.add(changeVariables);
		changeVariables.addActionListener(this);

		addIterationsLabel = builder.makeLabel("Would you like to change your variables? Or only add iterations?");
		addIterations = builder.makePanelWithLabel(450, 50, 600, 100, addIterationsLabel, false);
		frame.add(addIterations);
	}
	
	
	
	private void displayInputMenu(int menuSelect)
	{
		//Display input menu items for a full menu (first round of iteration input)
		if(menuSelect == 0)
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
		}
		//Display input menu items for iterations only
		if(menuSelect == 1)
		{
			iteration.setVisible(true);
			start.setVisible(true);
		}
		//Display input menu items for changing disease values and adding iterations
		else if(menuSelect == 2)
		{
			transmission.setVisible(true);
			mutation.setVisible(true);
			lethality.setVisible(true);
			lifespan.setVisible(true);
			iteration.setVisible(true);
			start.setVisible(true);
		}

		//Hide post-simulation screen items
		cancel1.setVisible(false);
		addIterations.setVisible(false);
		iterationsOnly.setVisible(false);
		changeVariables.setVisible(false);
		susceptible.setVisible(false);
		infected.setVisible(false);
		recovered.setVisible(false);
		dead.setVisible(false);
		
		//Hide intro screen items
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
		//Hide input menu items
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
		
		//Display infection statistics and options to continue/conclude
		susceptible.setVisible(true);
		infected.setVisible(true);
		recovered.setVisible(true);
		dead.setVisible(true);
		resume.setVisible(true);
		conclude.setVisible(true);
		
		//Hide menu items from conclusion/continue menus if the user tries to go back
		cancel.setVisible(false);
		saveYes.setVisible(false);
		saveNo.setVisible(false);
		results.setVisible(false);
		goodbye.setVisible(false);
		cancel1.setVisible(false);
		addIterations.setVisible(false);
		iterationsOnly.setVisible(false);
		changeVariables.setVisible(false);
		
		
	}

	private void displayAddIterationsMenu()
	{
		//Hide the continue/conclude buttons
		resume.setVisible(false);
		conclude.setVisible(false);
		
		//Display new menu items for continuing simulation
		cancel1.setVisible(true);
		addIterations.setVisible(true);
		iterationsOnly.setVisible(true);
		changeVariables.setVisible(true);
	}

	private void displayProgramEndMenu()
	{
		//Hide the continue/conclude buttons
		resume.setVisible(false);
		conclude.setVisible(false);
		
		//Show the save function options
		cancel.setVisible(true);
		saveYes.setVisible(true);
		saveNo.setVisible(true);
		
	}

	private void displayGoodbyeWindow()
	{		
		//Hide all SEIR stats and buttons
		susceptible.setVisible(false);
		infected.setVisible(false);
		recovered.setVisible(false);
		dead.setVisible(false);
		cancel.setVisible(false);
		saveYes.setVisible(false);
		saveNo.setVisible(false);
		
		//Display the goodbye label and thank the user
		goodbye.setVisible(true);
		
	}

	private void simulate(){
		if(!simulated)
		{
			name = new SimulationManager(userInputs);
		}
		//if it's getting iterations added and variables changed, update the variables in addition to the iterations
		//TODO^^^^^
		else
		{
			name.setIterations(userInputs.getIterations());
			Disease newDisease = new Disease(userInputs);
			name.setDisease(newDisease);
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
			displayInputMenu(0);
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
			displayInputMenu(1);
		}

		//Ask for new variables
		if(e.getSource() == changeVariables)
		{
			displayInputMenu(2);
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
