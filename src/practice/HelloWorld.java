package practice;

/*
 * Display example snippet: create two one shot timers (5000 ms, 2000 ms)
*
* For a list of all SWT example snippets see
* http://www.eclipse.org/swt/snippets/
*/
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.*;
import org.eclipse.swt.layout.*;
import java.util.*;

public class HelloWorld {
	
    public static ArrayList<String> Calculation = new ArrayList<String>();
    public static int j = 0;

public static void main (String [] args) {
	Calculation.add("");
	
	Display display = new Display ();
	Shell shell = new Shell (display);
	shell.setText("Calculator");
	shell.setSize (300, 200);
	shell.open ();
	
	GridLayout gridLayout = new GridLayout();
	gridLayout.numColumns = 4;
	shell.setLayout(gridLayout);
	
	Text text = new Text(shell, SWT.NONE);
	GridData gridData = new GridData();
	gridData.horizontalAlignment = GridData.FILL;
	gridData.horizontalSpan = 4;
	text.setLayoutData(gridData);
	
	text.addListener(SWT.KeyDown, event -> 
    event.doit = event.keyCode == SWT.BS || event.keyCode == SWT.DEL ||
    event.keyCode == SWT.ARROW_LEFT || event.keyCode == SWT.ARROW_RIGHT ||
    Character.isDigit(event.character));
	
    
	ArrayList<NumberButton> NumberButtons = new ArrayList<NumberButton>();
	
	for(int i = 0; i < 9; i++) {
		NumberButtons.add(new NumberButton(Integer.toString(i + 1), new Button(shell, SWT.PUSH)));
	    NumberButtons.get(i).button.setText(Integer.toString(i+1));
	    NumberButtons.get(i).add_custom_listener(text);
	};
	
	FunctionButton Add = new FunctionButton("+", new Button(shell, SWT.PUSH));
	FunctionButton Subtract = new FunctionButton("-", new Button(shell, SWT.PUSH));
	FunctionButton Multiply = new FunctionButton("*", new Button(shell, SWT.PUSH));
	FunctionButton Divide = new FunctionButton("/", new Button(shell, SWT.PUSH));
	FunctionButton Equals = new FunctionButton("=", new Button(shell, SWT.PUSH));
	
	FunctionButton[] FunctionButtons = {Add, Subtract, Multiply, Divide, Equals};
	
	for(FunctionButton i:FunctionButtons){
		i.button.setText(i.symbol);
		i.add_custom_listener(text);
	};

	shell.pack();
    
    while (!shell.isDisposed ()) {
		if (!display.readAndDispatch ()) display.sleep ();
	}
	display.dispose ();
}}
