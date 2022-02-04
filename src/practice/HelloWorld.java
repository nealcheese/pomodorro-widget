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

public class HelloWorld {

public static void main (String [] args) {
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
	
    Button Button1 = new Button(shell, SWT.PUSH);
    Button1.setText("1");
    
    Button Button2 = new Button(shell, SWT.PUSH);
    Button2.setText("2");
    
    Button Button3 = new Button(shell, SWT.PUSH);
    Button3.setText("3");
    
    Button AddButton = new Button(shell, SWT.PUSH);
    AddButton.setText("Add");
    
	GridData gridData2 = new GridData();
	gridData2.verticalAlignment = GridData.FILL;
	gridData2.verticalSpan = 3;
	AddButton.setLayoutData(gridData2);
    
    Button Button4 = new Button(shell, SWT.PUSH);
    Button4.setText("4");
    
    Button Button5 = new Button(shell, SWT.PUSH);
    Button5.setText("5");
    
    Button Button6 = new Button(shell, SWT.PUSH);
    Button6.setText("6");
    
    Button Button7 = new Button(shell, SWT.PUSH);
    Button7.setText("7");
    
    Button Button8 = new Button(shell, SWT.PUSH);
    Button8.setText("8");
    
    Button Button9 = new Button(shell, SWT.PUSH);
    Button9.setText("9");
    
    shell.pack();
    
    Button[] ButtonList = {Button1, Button2, Button3, Button4, Button5, Button6, Button7, Button8, Button9};
    
    for(int i = 0; i < ButtonList.length; i++) {
    	int i_ = i;
    	ButtonList[i].addSelectionListener(new SelectionAdapter() {
    	@Override
        public void widgetSelected(SelectionEvent e) {
        	
            text.setText(Integer.toString(i_ + 1));
            text.forceFocus();
        }
    });}
    
	AddButton.addSelectionListener(new SelectionAdapter() {
	@Override
    public void widgetSelected(SelectionEvent e) {
	    text.setText("+");
	    text.forceFocus();
    }
});

    
    while (!shell.isDisposed ()) {
		if (!display.readAndDispatch ()) display.sleep ();
	}
	display.dispose ();
}}
