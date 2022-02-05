package practice;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.*;

public class FunctionButton {
	String symbol;
	Button button;
	
	FunctionButton(String symbol, Button button){
		this.symbol = symbol;
		this.button = button;
	}
	
void add_custom_listener(Text TextBox){
	this.button.addSelectionListener(new SelectionAdapter() {
	@Override
    public void widgetSelected(SelectionEvent e) {
	    HelloWorld.Calculation.add(symbol);
	    HelloWorld.Calculation.add("");
	    HelloWorld.j++;
	    HelloWorld.j++;
		String Calc_Concat = "";
		for (int k = 0; k < HelloWorld.Calculation.size(); k++) {
			Calc_Concat = Calc_Concat.concat(HelloWorld.Calculation.get(k));
		}
		TextBox.setText(Calc_Concat);
        TextBox.forceFocus();
}});}

}
