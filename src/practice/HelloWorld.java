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
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import java.util.ArrayList;

public class HelloWorld {
	
    static ArrayList<String> Calculation = new ArrayList<String>();
    static int j = 0;

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
	
    
	ArrayList<Button> ButtonList = new ArrayList<Button>();
	
	for(int i = 0; i < 9; i++) {
		ButtonList.add(new Button(shell, SWT.PUSH));
	    ButtonList.get(i).setText(Integer.toString(i+1));
	};
	
    Button AddButton = new Button(shell, SWT.PUSH);
    AddButton.setText("+");
	
    Button SubtractButton = new Button(shell, SWT.PUSH);
    SubtractButton.setText("-");
    
    Button EqualsButton = new Button(shell, SWT.PUSH);
    EqualsButton.setText("=");
    
    
    
    for(int i = 0; i < ButtonList.size(); i++) {
    	int i_ = i;
    	ButtonList.get(i).addSelectionListener(new SelectionAdapter() {
    	@Override
        public void widgetSelected(SelectionEvent e) {
        	
    		Calculation.set(j, Calculation.get(j).concat(Integer.toString(i_ + 1)));
    		String Calc_Concat = "";
    		for (int k = 0; k < Calculation.size(); k++) {
    			Calc_Concat = Calc_Concat.concat(Calculation.get(k));
    		}
    		text.setText(Calc_Concat);
            text.forceFocus();
        }
    });}
    

   
	AddButton.addSelectionListener(new SelectionAdapter() {
	@Override
    public void widgetSelected(SelectionEvent e) {
	    j++;
	    j++;
	    Calculation.add("+");
	    Calculation.add("");
		String Calc_Concat = "";
		for (int k = 0; k < Calculation.size(); k++) {
			Calc_Concat = Calc_Concat.concat(Calculation.get(k));
		}
		text.setText(Calc_Concat);
	    text.forceFocus();
    }
});

	shell.pack();
    
    while (!shell.isDisposed ()) {
		if (!display.readAndDispatch ()) display.sleep ();
	}
	display.dispose ();
}}
