import java.awt.event.*;

public class MyScene extends GBScene
{
	
	boolean moveOut;
	int count;
	public void mousePressed(MouseEvent e)
	{
		if (count%3 == 0)
		{
			moveOut = false;
		}
		else
		{
			moveOut = true;
		}
		GBSprite[] children = getChildren();
		if (moveOut)
		{
			children[0].moveNorthwest(999,20);
			children[1].moveNorth(999,20);
			children[2].moveNortheast(999,20);
			children[3].moveWest(999,20);
			children[5].moveEast(999,20);
			children[6].moveSouthwest(999,20);
			children[7].moveSouth(999,20);
			children[8].moveSoutheast(999,20);
		}
		else
		{
			children[0].moveSoutheast(999,20);
			children[1].moveSouth(999,20);
			children[2].moveSouthwest(999,20);
			children[3].moveEast(999,20);
			children[5].moveWest(999,20);
			children[6].moveNortheast(999,20);
			children[7].moveNorth(999,20);
			children[8].moveNorthwest(999,20);
		}
		count++;
	}
	public MyScene()
	{
		moveOut = true;
		count = 1;
		addMouseListener(this);
	}
	
}