package practice;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.*;
import java.util.ArrayList;

public class FunctionButton {
	String symbol;
	Button button;
	
	FunctionButton(String symbol, Button button){
		this.symbol = symbol;
		this.button = button;
	}
	
void addlistener(ArrayList<String> Calculation){
	this.button.addSelectionListener(new SelectionAdapter() {
	@Override
    public void widgetSelected(SelectionEvent e) {
	    Calculation.add(symbol);
	    Calculation.add("");
}});}

}
