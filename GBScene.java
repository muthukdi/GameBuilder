import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class GBScene extends JPanel implements MouseListener
{

	private GBSprite[] children;
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		GBSprite child;
		for (int i = 0; i < children.length; i++)
		{
			child = children[i];
			if (child != null)
			{
				Point position = child.getPosition();
				g.drawImage(child.getImage(),(int)position.getX(),(int)position.getY(),null);
			}
		}
	}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public GBSprite getChildByTag(int tag) 
					throws IllegalArgumentException
	{
		if (tag < 1)
		{
			throw new IllegalArgumentException();
		}
		GBSprite child;
		for (int i = 0; i < children.length; i++)
		{
			child = children[i];
			if (child.getTag() == tag)
			{
				return child;
			}
		}
		// If you don't find a child by that tag, then create one
		child = new GBSprite(new File("default.png"));
		child.setTag(tag);
		return child;
	}
	public void addChild(GBSprite sprite)
	{
		// Make sure a child with the same tag doesn't exist
		GBSprite child;
		for (int i = 0; i < children.length; i++)
		{
			child = children[i];
			if (child == null)
			{
				break;
			}
			if (child.getTag() == sprite.getTag())
			{
				break;
			}
			else if (i == children.length-1)
			{
				extendChildren();
				sprite.setParent(this);
				children[children.length-1] = sprite;
				repaint();
				return;
			}
		}
		// We need to assign this sprite a new tag reference
		sprite.setTag(createNewTag());
		extendChildren();
		sprite.setParent(this);
		children[children.length-1] = sprite;
		repaint();
	}
	private void extendChildren()
	{
		GBSprite[] temp = new GBSprite[children.length+1];
		for (int i = 0; i < children.length; i++)
		{
			temp[i] = children[i];
		}
		children = temp;
	}
	private int createNewTag()
	{
		int newTag = 1;
		for (int i = 0; i < children.length; i++)
		{
			if (children[i] == null)
			{
				break;
			}
			newTag += children[i].getTag();
		}
		return newTag;
	}
	public void removeChild(GBSprite child)
	{
		// Remove sprite from scene
	}
	public GBSprite[] getChildren()
	{
		return children;
	}
	public GBScene()
	{
		super();
		setBackground(Color.BLACK);
		children = new GBSprite[0];
		for (int i = 0; i < children.length; i++)
		{
			children[i] = null;
		}
	}
	
}