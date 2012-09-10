import java.io.*;
import java.awt.Point;

public class TestGame
{
	
	public static void main(String[] args)
	{
		MyScene scene = new MyScene();
		GBApplication window = new GBApplication(scene,200,100,400,600);
		// Adding all the sprites to the scene
		int row = -1;
		for (int i = 0; i < 9; i ++)
		{
			if (i%3 == 0)
			{
				row++;
			}
			GBSprite sprite = new GBSprite(new File("sprite"+i+".png"));
			sprite.setPosition(new Point(110+60*(i%3),210+60*row));
			sprite.setTag(i);
			scene.addChild(sprite);
		}
		GBSprite[] children = scene.getChildren();
		for (int i = 0; i < children.length; i++)
		{
			if (children[i] == null)
			{
				break;
			}
			else
			{
				System.out.println(children[i].getTag());
			}
		}
	}
}