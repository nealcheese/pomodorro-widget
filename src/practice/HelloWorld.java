package practice;

/*
 * Display example snippet: create two one shot timers (5000 ms, 2000 ms)
*
* For a list of all SWT example snippets see
* http://www.eclipse.org/swt/snippets/
*/
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class HelloWorld {

public static void main (String [] args) {
	Display display = new Display ();
	Shell shell = new Shell (display);
	shell.setText("Hello World");
	shell.setSize (300, 200);
	shell.open ();
	
    RowLayout rowLayout = new RowLayout();
    rowLayout.marginLeft = 10;
    rowLayout.marginTop = 10;
    rowLayout.spacing = 15;
    shell.setLayout(rowLayout);
    
    Text text = new Text(shell, SWT.BORDER);
    text.setLayoutData(new RowData(150, SWT.DEFAULT));
    text.setText("1st Number");
    
    text.addListener(SWT.KeyDown, event -> 
    event.doit = event.keyCode == SWT.BS || event.keyCode == SWT.DEL ||
    event.keyCode == SWT.ARROW_LEFT || event.keyCode == SWT.ARROW_RIGHT ||
    Character.isDigit(event.character));
	
    Label label = new Label(shell, SWT.NONE);
    label.setText("+");
    
    Text text2 = new Text(shell, SWT.BORDER);
    text2.setLayoutData(new RowData(150, SWT.DEFAULT));
    text2.setText("2nd Number");
    
    text2.addListener(SWT.KeyDown, event -> 
    event.doit = event.keyCode == SWT.BS || event.keyCode == SWT.DEL ||
    event.keyCode == SWT.ARROW_LEFT || event.keyCode == SWT.ARROW_RIGHT ||
    Character.isDigit(event.character));

    Label label2 = new Label(shell, SWT.NONE);
    label2.setText("=");
    
    Text text3 = new Text(shell, SWT.BORDER);
    text3.setLayoutData(new RowData(150, SWT.DEFAULT));

    Button addButton = new Button(shell, SWT.PUSH);
    addButton.setText("Add");
    
    addButton.addSelectionListener(new SelectionAdapter() {
        @Override
        public void widgetSelected(SelectionEvent e) {
        	int number = Integer.parseInt(text.getText());
        	int number2 = Integer.parseInt(text2.getText());
            text3.setText(Integer.toString(number + number2));
            text3.forceFocus();
        }
    });
    
    shell.pack();
    shell.open();
    while (!shell.isDisposed ()) {
		if (!display.readAndDispatch ()) display.sleep ();
	}
	display.dispose ();
}
}