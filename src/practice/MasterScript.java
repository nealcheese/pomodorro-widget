package practice;

import org.eclipse.swt.widgets.*;
import org.eclipse.swt.*;
import org.eclipse.swt.layout.*;
import java.util.*;

public class MasterScript {
	
	//Declare public variables 
	public static ArrayList<String> Calculation = new ArrayList<String>();
    public static int j = 0;
    

public static void main (String [] args) {
	
	//Add a blank as the first entry, otherwise NumberButton.add_custom_listener will return null 
	Calculation.add("");
	
	//Initiate and configure the display and shell a.k.a the window
	Display display = new Display ();
	Shell shell = new Shell (display);
	shell.setText("Calculator");
	shell.setSize (300, 200);
	shell.open ();
	
	//Set the layout of the buttons and text field as a grid
	GridLayout gridLayout = new GridLayout();
	gridLayout.numColumns = 4;
	shell.setLayout(gridLayout);
	
	//Initiate and configure the text field, acting as the display at the top of the calculator 
	Text text = new Text(shell, SWT.NONE);
	GridData gridData = new GridData();
	gridData.horizontalAlignment = GridData.FILL;
	gridData.horizontalSpan = 4;
	text.setLayoutData(gridData);
	
	//Add listener to text field so that only numbers and function symbols can be typed in
	text.addListener(SWT.KeyDown, event -> 
    event.doit = event.keyCode == SWT.BS || event.keyCode == SWT.DEL ||
    event.keyCode == SWT.ARROW_LEFT || event.keyCode == SWT.ARROW_RIGHT ||
    Character.isDigit(event.character));
	
    
	//Create array for buttons numbered 0 to 9, then initiate buttons and add listeners.
	//Configuration of these buttons are identical so the "NumberButton" class has been created, and they are all initiated in a for loop 
	ArrayList<NumberButton> NumberButtons = new ArrayList<NumberButton>();
	
	for(int i = 0; i < 9; i++) {
		NumberButtons.add(new NumberButton(Integer.toString(i + 1), new Button(shell, SWT.PUSH)));
	    NumberButtons.get(i).button.setText(Integer.toString(i+1));
	    NumberButtons.get(i).add_custom_listener(text);
	};
	
	//Create array for function buttons used for adding, subtracting, multiplying etc..., then initiate buttons and add listeners.
	//Configuration of these buttons are identical so the "FunctionButton" class has been created, and they are all initiated in a series of for loops
	//Note that two for loops are required to initiate the Function Buttons, whereas only one for loop is required to initiate the Number Buttons.
	//The numbering of the Number Buttons from 0 to 9 means it works well with the standard for loop iteration, starting at int i = 0
	//The Function Buttons are labelled by symbols so it doesn't work so cleanly, also writing for each loops is fun lol
	ArrayList<FunctionButton> FunctionButtons = new ArrayList<FunctionButton>();
	String[] functions = {"+", "-", "="};
	
	for(String i : functions) {
		FunctionButtons.add(new FunctionButton(i, new Button(shell, SWT.PUSH)));
	};
	
	for(FunctionButton i:FunctionButtons){
		i.button.setText(i.symbol);
		
		//the listener for the equals operator is different to all the others
		if(i.symbol != "=")
		i.add_custom_operation_listener(text);
		else i.add_custom_equals_listener(text);
	};
	

	shell.pack();
    
    while (!shell.isDisposed ()) {
		if (!display.readAndDispatch ()) display.sleep ();
	}
	display.dispose ();
}}
