package package_symulacja;
package package1;


import java.awt.Color;

import java.awt.Graphics;
import java.util.Random;

public class EnergyParticle{

	  Random rand = new Random();
	  

	  private int xPos = 1; // x position
	  private int yPos = 1; // y posotion
	  private int vX = 6 + rand.nextInt(6);//-5; // x component velocity
	  private int vY = rand.nextInt(100);//-5; // y component velocity
	  private int d = 5; // diameter of the particle
	  private Color color = Color.BLACK; // particle colour
      private boolean visibleParticle = true; 
   
    public void setVX(int vx) {
		this.vX = vx;
   	}
    public void setVY(int vy) {
		this.vY = vy;
   	}
    
    public int getVX() {
		return vX;
  	}
    public int getVY() {
		return vY;
  	}
    
    public int getX() {
		return xPos;
  	}

	  public void setX(int xPos) {
		this.xPos = xPos;
	  }

    public void setY(int yPos){
        this.yPos = yPos;
    }

    public int getY(){
        return yPos;
    }
    
    public Color getColor() {
		return color;
  	}

	public void setColor(Color color) {
		 this.color = color;
	 }
	 
	 public void setVisible(boolean v) {
		 this.visibleParticle = v;
	 }
	 
	 public boolean getVisible() {
		 return visibleParticle; 
	 }
	 
	 public void removeParticle(Color c) {
		 this.setColor(c);
		 
	 }
	
	  public void paint(Graphics g){
        g.setColor(getColor());
        g.fillOval(xPos, yPos, d, d);
    }

}


