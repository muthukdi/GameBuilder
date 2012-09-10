import java.awt.Point;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;

public class GBSprite implements ActionListener
{

	private BufferedImage image;
	private int x;
	private int y;
	private int tag;
	private int direction;
	private GBScene parent;
	private Timer timer;
	private int destX;
	private int destY;
	public void actionPerformed(ActionEvent e)
	{
		// If this sprite has reached its destination, then stop it
		if (x == destX && y == destY)
		{
			timer.stop();
		}
		else if (direction == 0)
		{
			x++;
		}
		else if (direction == 1)
		{
			x--;
		}
		else if (direction == 2)
		{
			y++;
		}
		else if (direction == 3)
		{
			y--;
		}
		else if (direction == 4)
		{
			x++;
			y++;
		}
		else if (direction == 5)
		{
			x--;
			y--;
		}
		else if (direction == 6)
		{
			x++;
			y--;
		}
		else if (direction == 7)
		{
			x--;
			y++;
		}
		parent.repaint();
	}
	public void moveEast(int speed, int distance)
	{
		if (speed > 999 || speed < 1 || distance < 1 || timer.isRunning())
		{
			return;
		}
		timer.setDelay(1000-speed);
		direction = 0;
		destX = x + distance;
		destY = y;
		timer.start();
	}
	public void moveWest(int speed, int distance)
	{
		if (speed > 999 || speed < 0 || distance < 1 || timer.isRunning())
		{
			return;
		}
		timer.setDelay(1000-speed);
		direction = 1;
		destX = x - distance;
		destY = y;
		timer.start();
	}
	public void moveSouth(int speed, int distance)
	{
		if (speed > 999 || speed < 0 || distance < 1 || timer.isRunning())
		{
			return;
		}
		timer.setDelay(1000-speed);
		direction = 2;
		destX = x;
		destY = y + distance;
		timer.start();
	}
	public void moveNorth(int speed, int distance)
	{
		if (speed > 999 || speed < 0 || distance < 1 || timer.isRunning())
		{
			return;
		}
		timer.setDelay(1000-speed);
		direction = 3;
		destX = x;
		destY = y - distance;
		timer.start();
	}
	public void moveSoutheast(int speed, int distance)
	{
		if (speed > 999 || speed < 0 || distance < 1 || timer.isRunning())
		{
			return;
		}
		timer.setDelay(1000-speed);
		direction = 4;
		destX = x + distance;
		destY = y + distance;
		timer.start();
	}
	public void moveNorthwest(int speed, int distance)
	{
		if (speed > 999 || speed < 0 || distance < 1 || timer.isRunning())
		{
			return;
		}
		timer.setDelay(1000-speed);
		direction = 5;
		destX = x - distance;
		destY = y - distance;
		timer.start();
	}
	public void moveNortheast(int speed, int distance)
	{
		if (speed > 999 || speed < 0 || distance < 1 || timer.isRunning())
		{
			return;
		}
		timer.setDelay(1000-speed);
		direction = 6;
		destX = x + distance;
		destY = y - distance;
		timer.start();
	}
	public void moveSouthwest(int speed, int distance)
	{
		if (speed > 999 || speed < 0 || distance < 1 || timer.isRunning())
		{
			return;
		}
		timer.setDelay(1000-speed);
		direction = 7;
		destX = x - distance;
		destY = y + distance;
		timer.start();
	}
	public GBScene getParent()
	{
		return parent;
	}
	public void setParent(GBScene scene)
	{
		parent = scene;
	}
	public int getTag()
	{
		return tag;
	}
	public void setTag(int tag)
	{
		if (tag < 1)
		{
			return;
		}
		this.tag = tag;
	}
	public Point getPosition()
	{
		return new Point(x,y);
	}
	public void setPosition(Point position)
	{
		x = (int)position.getX();
		y = (int)position.getY();
		if (parent != null)
		{
			parent.repaint();
		}
	}
	public BufferedImage getImage()
	{
		return image;
	}
	public GBSprite(File file)
	{
		try
		{
			image = ImageIO.read(file);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		x = 0;
		y = 0;
		tag = 1;
		direction = 0;
		destX = 0;
		destY = 0;
		parent = null;
		timer = new Timer(1,this);
	}

}