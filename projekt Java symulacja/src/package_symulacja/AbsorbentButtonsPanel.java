  
/* panel gorny:

 * ustawienie przyciskow do wyboru absorbentow
 * 
 **/

package package_symulacja;

import javax.swing.*;

import java.awt.*;


public class AbsorbentButtonsPanel extends JPanel{
	
	private JLabel chooseAbsorbentLabel;
	private AlButton buttonAl;
	private CuButton buttonCu;
	private PbButton buttonPb;
	
	public AbsorbentButtonsPanel() {
		
    	buttonAl = new AlButton();
    	buttonCu = new CuButton();
    	buttonPb = new PbButton();
    	
    	chooseAbsorbentLabel = new JLabel("Wybierz absorbent:");
    	
    	this.setLayout(new FlowLayout());
    	this.add(chooseAbsorbentLabel);
    	this.add(buttonAl);
    	this.add(buttonCu);
    	this.add(buttonPb);
	}
}