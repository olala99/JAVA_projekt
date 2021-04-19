package package_symulacja;

import javax.swing.*;
import java.awt.*;

public class Menu extends JMenuBar {
	
	private JMenu menu;
	private JMenuItem language;
	private JMenuItem read;
	private JMenuItem save;
	private JMenuItem clean;
	
	public Menu() {
		menu = new JMenu("MENU");
		
		language = new JMenuItem("Zmien jezyk");
		read = new JMenuItem("Wczytaj");
		save = new JMenuItem("Zapisz");
		clean = new JMenuItem("Wyczysc");
		
		menu.add(language);
		menu.add(read);
		menu.add(save);
		menu.add(clean);
		
		this.add(menu);
	}
}

