import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;

class Main extends Applet implements Runnable {

	private static final long serialVersionUID = 1L;

	public static String title = "Connway's Game of Life -- Chester Holtz";
	public static int width = 1000;
	public static int height = 1000;//650

	public static boolean isRunning =false;

	public static Graphics g;
	public static Image screen;	

	public static Stage stage;

	public static JFrame frame;
	public static void main(String[] args) {
		Main main = new Main();

		frame = new JFrame();
		frame.add(main);
		frame.setSize(width+6,height+26);
		frame.setTitle(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);

		main.start();
	}

	public void start(){
		init();

		isRunning = true;
		Thread th = new Thread(this);
		th.start();
	}

	public void init(){
		screen = createVolatileImage(width,height);
		stage = new Stage();
	}

	public void run() {
		while(isRunning){
			tick();
			render(g);
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void tick(){
		width = getWidth();
		height = getHeight();
		stage.tick();
	}

	public void render(Graphics g){
		screen =  createImage(width,height);
		g = screen.getGraphics();

		g.setColor(Color.BLACK);
		g.fillRect(0,0,width,height);

		stage.render(g);

		g = getGraphics();
		g.drawImage(screen,0,0,width,height,null);
	}
}


