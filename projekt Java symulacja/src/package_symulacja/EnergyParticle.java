package package_symulacja;
import java.awt.Color;

import java.awt.Graphics;
import java.util.Random;

public class EnergyParticle{

	  Random rand = new Random();
	  

	  private int xPos = 1; // x position
	  private int yPos = 1; // y posotion
	  private int vX = rand.nextInt(100);//-5; // x component velocity
	  private int vY = rand.nextInt(100);//-5; // y component velocity
	  private int d = 5; // diameter of the particle
	  private Color color = Color.BLACK; // particle colour
    
   
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
    
    /*public int getD() {
    	return d;
    }
    
    public void setD(int d) {
    	this.d = d;
    }*/

    public Color getColor() {
		return color;
  	}

	  public void setColor(Color color) {
		this.color = color;
	  }

	  public void paint(Graphics g){
        g.setColor(getColor());
        g.fillOval(xPos, yPos, d, d);
    }

}
