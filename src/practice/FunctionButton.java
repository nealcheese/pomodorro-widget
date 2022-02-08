package practice;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.*;

import bsh.EvalError;
import bsh.Interpreter;

public class FunctionButton {
	String symbol;
	Button button;
	
	FunctionButton(String symbol, Button button){
		this.symbol = symbol;
		this.button = button;
	}
	
void add_custom_operation_listener(Text TextBox){
	this.button.addSelectionListener(new SelectionAdapter() {
	@Override
    public void widgetSelected(SelectionEvent e) {
	    MasterScript.Calculation.add(symbol);
	    MasterScript.Calculation.add("");
	    MasterScript.j++;
	    MasterScript.j++;
		String Calc_Concat = "";
		for (int k = 0; k < MasterScript.Calculation.size(); k++) {
			Calc_Concat = Calc_Concat.concat(MasterScript.Calculation.get(k));
		}
		TextBox.setText(Calc_Concat);
        TextBox.forceFocus();
}});}

void add_custom_equals_listener(Text TextBox){
	this.button.addSelectionListener(new SelectionAdapter() {
	@Override
    public void widgetSelected(SelectionEvent e) {
	
		String Calc_String = "float foo =" + String.join(" ", MasterScript.Calculation);
		MasterScript.Calculation.clear();
		MasterScript.Calculation.add("");
		MasterScript.j = 0;
		Interpreter interpreter = new Interpreter();
		try {
			interpreter.eval(Calc_String);
			Float result = (Float) interpreter.get("foo");
			TextBox.setText(Float.toString(result));
		} catch (EvalError e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

				
		}});}

}
