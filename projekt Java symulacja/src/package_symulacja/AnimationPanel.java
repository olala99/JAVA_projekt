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

	
	private static final long serialVersionUID = 1L;
	List<EnergyParticle> particles = new ArrayList<EnergyParticle>();
	int incr = 1;
	int iteracja = 0;
	
	public void addEnergyParticle(int x, int y, Color c){
		EnergyParticle particle = new EnergyParticle();
		particle.setX(x);
		particle.setY(y);
		//particle.setD(d);
		particle.setColor(c);
		
		particles.add(particle);		
	}
	
public void particleGroup(int c) {
		
//		for (int i = 1; i<11 ; i++) {
			for (int j = 1; j<100 ; j++) {
				EnergyParticle particle = new EnergyParticle();	
				particle.setX(c-rand.nextInt(100));
				particle.setY(25+rand.nextInt(400));
				particle.setColor(Color.black);
				particles.add(particle);
			}
//		}
	}
	void moveParticles() {
		
		for(int i = 0; i < 10; i++ ) {
			particleGroup(-i*100);
		}
		
		ScheduledExecutorService scheduler = Executors
				.newScheduledThreadPool(2);

		scheduler.scheduleAtFixedRate((new Runnable() {

			@Override
			public void run() {

				for (EnergyParticle ep : particles){
		         		 ep.setX( ep.getX() + 1 );
		         		 
		         
		         		 }
		         	 
		       
				repaint();

			}
		}), 0, 10, MILLISECONDS);
		
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		for (EnergyParticle ep : particles) {
			ep.paint(g);
		}
	}
	
	public AnimationPanel() {
		this.setLayout(new BorderLayout());
//		animationPanel = new JPanel();
//		animationPanel.setLayout(new BorderLayout());
//		animationPanel.setBackground(Color.white);
		absorbent = new Absorbent();
//		 for(int i = 0; i < 10; i++ ) {
//			 this.particleGroup(-i*100);
//		 }
		
		this.moveParticles();
		this.add(absorbent);
//		System.out.println(""+absorbent.getSize());
//		this.add(animationPanel,BorderLayout.CENTER);
//		addParticles();
		this.setBackground(Color.white);
//		this.add(absorbent,BorderLayout.CENTER);
	}
}