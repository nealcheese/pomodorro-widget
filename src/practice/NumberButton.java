package practice;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.*;

public class NumberButton {
	String number;
	Button button;
	
	NumberButton(String number, Button button){
		this.number = number;
		this.button = button;
	}
	
void add_custom_listener(Text TextBox){
	this.button.addSelectionListener(new SelectionAdapter() {
	@Override
    public void widgetSelected(SelectionEvent e) {
    	
		HelloWorld.Calculation.set(HelloWorld.j, HelloWorld.Calculation.get(HelloWorld.j).concat(number));
		String Calc_Concat = "";
		for (int k = 0; k < HelloWorld.Calculation.size(); k++) {
			Calc_Concat = Calc_Concat.concat(HelloWorld.Calculation.get(k));
		}
		TextBox.setText(Calc_Concat);
        TextBox.forceFocus();
}});}

}
