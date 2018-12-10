import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Player {

	int health;
	int velX;
	int velY;
	GraphicsContext gc;
	int x;
	int y;
	
	Player (int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	void start() 
	{
		
	}
	
	public void Update()
	{
		x += velX;
		y += velY;
		
		
	}
	public void render()
	{
		gc.setFill(Color.AQUA);
		gc.fillRect(x,y,16,16);
	}
}
