import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Cell extends Rectangle {
	private static final long serialVersionUID = 1L;

	public static int cellSize = 5;//10
	public boolean isAlive = false;

	public Cell(int x, int y) {
		setBounds(x * cellSize,y * cellSize,cellSize,cellSize);
	}

	public void render(Graphics g){
		g.setColor(Color.RED);
		if(isAlive){
			g.fillRect(x,y,width,height);
		}
	}
}