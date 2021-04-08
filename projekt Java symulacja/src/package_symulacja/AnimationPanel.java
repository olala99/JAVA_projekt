/* autorka: Ola
 * panel centralny:
 * panel z tlem do animacji
 * panel z przyciskami kontrolujacymi AnimationControlPanel */

package package_symulacja;

import static java.util.concurrent.TimeUnit.MILLISECONDS;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import javax.swing.*;



public class AnimationPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	List<EnergyParticle> particles = new ArrayList<EnergyParticle>();

	//JPanel animationPanel;
	
	public void addEnergyParticle(int x, int y, Color c){
		EnergyParticle particle = new EnergyParticle();
		particle.setX(x);
		particle.setY(y);
		//particle.setD(d);
		particle.setColor(c);
		
		particles.add(particle);		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		for (EnergyParticle ep : particles) {
			ep.paint(g);
		}
	}
	
	void moveParticles() {

		ScheduledExecutorService scheduler = Executors
				.newScheduledThreadPool(2);

		scheduler.scheduleAtFixedRate((new Runnable() {

			@Override
			public void run() {

				int d = 5;
				
				
				for (EnergyParticle ep : particles) {
					if(ep.getX() >= d || ep.getX() <0) ep.setVX(-ep.getVX());
					if(ep.getY() >= d || ep.getY() <0) ep.setVY(-ep.getVY());
					
					ep.setX(ep.getX() + ep.getVX());
					ep.setY(ep.getY() + ep.getVY());
				}
				
				repaint();

			}
		}), 0, 5, MILLISECONDS);
		
	}

	public AnimationPanel() {
		//this.setLayout(new BorderLayout());
		//animationPanel = new JPanel();
		//animationPanel.setBackground(Color.white);
		
		//this.add(animationPanel,BorderLayout.CENTER);
		
		this.setBackground(Color.white);
	}
	
	/*public void addRandomEnergyParticle(){
		Random rand= new Random();
		
		EnergyParticle particle = new EnergyParticle();
		particle.setX(rand.nextInt(550));
		particle.setY(rand.nextInt(550));
		//particle.setWidth(rand.nextInt(80));
		//particle.setHeight(rand.nextInt(80));
		//p.setColor(new Color(rand.nextInt(255), r.nextInt(255), r.nextInt(255), r.nextInt(255)));
		
		particles.add(particle);		
	}*/
}
