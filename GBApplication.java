import javax.swing.*;

public class GBApplication extends JFrame
{

	private GBScene scene;
	public GBApplication(GBScene scene, int x, int y, int width, int height)
	{
		this.scene = scene;
		setContentPane(scene);
		setLocation(x,y);
		setSize(width,height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
	public GBScene getScene()
	{
		return scene;
	}
	public void setScene(GBScene scene)
	{
		this.scene = scene;
	}

}