/* panel centralny:
 * panel z tlem do animacji
 * panel z przyciskami kontrolujacymi AnimationControlPanel */

package package_symulacja;
import static java.util.concurrent.TimeUnit.MILLISECONDS;



import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import javax.imageio.ImageIO;
import javax.swing.JPanel;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import javax.swing.*;

public class AnimationPanel extends JPanel {
	Random rand = new Random();
	JPanel animationPanel;
	Absorbent absorbent;
	int licznik = 0;
	
	private static final long serialVersionUID = 1L;
	List<EnergyParticle> particles = new ArrayList<EnergyParticle>();
	int incr = 1;
	int iteracja = 0;
	
	public void addEnergyParticle(int x, int y, Color c, int absorbentThickness, double absorbentType){
		EnergyParticle particle = new EnergyParticle();
		particle.setX(x);
		particle.setY(y);
		//particle.setD(d);
		particle.setColor(c);
		
		for (int i = 0; i < absorbentThickness  ; i++) {
			
			int randomNumber = rand.nextInt(1000);
			if(Math.exp(-absorbentType) < rand.nextInt()) {
				particle.setVisible(false);
				licznik++;
				i=absorbentThickness;
			}
		
		}
		
		particles.add(particle);		
	}
	
//	public void particleGroup(int c) {
////		for (int i = 1; i<11 ; i++) {
//			for (int j = 1; j<100 ; j++) {
//				EnergyParticle particle = new EnergyParticle();	
//				particle.setX(c-rand.nextInt(100));
//				particle.setY(25+rand.nextInt(400));
//				particle.setColor(Color.black);
//				particles.add(particle);
//			}
////		}
//	}
//


	void moveParticles() {
		
		ScheduledExecutorService scheduler = Executors
				.newScheduledThreadPool(2);

		scheduler.scheduleAtFixedRate((new Runnable() {

			@Override
			public void run() {
//				EnergyParticle ep;
				for (EnergyParticle ep : particles){
		         		 ep.setX( ep.getX() + ep.getVX());

		         		 if(ep.getX()>getWidth()/2 && !ep.getVisible()) {
		         			 
		         			 ep.removeParticle(getBackground());
		         		 }
		         		 }
		    
				repaint();

			}
		}), 0, 100, MILLISECONDS);
		
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		for (EnergyParticle ep : particles) {
			ep.paint(g);
		}
	}
	
	public AnimationPanel() {
		this.setLayout(new BorderLayout());

		absorbent = new Absorbent();
//		 for(int i = 0; i < 10; i++ ) {
//			 this.particleGroup(-i*100);
//		 }
		
//		for (int i = 1; i < 1000; i++) this.addEnergyParticle( -520 + rand.nextInt(500), 30+rand.nextInt(370), Color.black);
		
//		this.moveParticles();
		this.add(absorbent);
		System.out.println(""+absorbent.getSize());
		System.out.println(""+ licznik);
//		this.add(animationPanel,BorderLayout.CENTER);
//		addParticles();
		this.setBackground(Color.white);
//		this.add(absorbent,BorderLayout.CENTER);
	}
}
