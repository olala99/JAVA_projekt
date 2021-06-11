  
  
/* panel gorny:

 * ustawienie przyciskow do wyboru absorbentow
 * 
 **/

package package_symulacja;

import javax.swing.*;

import java.awt.*;


public class AbsorbentButtonsPanel extends JPanel{
	
	JLabel chooseAbsorbentLabel;
	
	static JToggleButton buttonAl;
	static JToggleButton buttonCu;
	static JToggleButton buttonPb;
	
	public AbsorbentButtonsPanel() {
		
    	buttonAl = new JToggleButton("Al");
    	buttonCu = new JToggleButton("Cu");
    	buttonPb = new JToggleButton("Pb");
    	
    	chooseAbsorbentLabel = new JLabel();
    	chooseAbsorbentLabel.setText(Menu.resBundle.getString("choose_absorbent"));
    	
    	this.setLayout(new FlowLayout());
    	this.add(chooseAbsorbentLabel);
    	this.add(buttonAl);
    	this.add(buttonCu);
    	this.add(buttonPb);
	}
}
