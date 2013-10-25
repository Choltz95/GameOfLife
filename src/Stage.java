import java.awt.Graphics;
import java.util.Random;


public class Stage {
	public static Cell[][] cell;
	public static Cell[][] cell2;

	public Stage(){
		cell = new Cell[Main.width/Cell.cellSize][Main.height/Cell.cellSize];
		cell2 = new Cell[Main.width/Cell.cellSize][Main.height/Cell.cellSize];
		for(int i =0;i<cell.length;i++){
			for(int j =0;j<cell[0].length;j++){
				cell[i][j]=new Cell(i,j);
				cell2[i][j]=new Cell(i,j);
				cell[i][j].isAlive = new Random().nextInt(4) == 0;
			}
		}
	}

	public void tick(){
		for(int i =0;i<cell.length;i++){
			for(int j =0;j<cell[0].length;j++){
				cell2[i][j].isAlive = cell[i][j].isAlive;
			}
		}
		for(int i =0;i<cell.length;i++){
			for(int j =0;j<cell[0].length;j++){
				cell[i][j].isAlive = false;
			}
		}
		for(int i =0;i<cell.length;i++){
			for(int j =0;j<cell[0].length;j++){
				int n = 0;
				try{
					if(cell2[i-1][j].isAlive)n++;
				} catch(Exception e){}
				try{
					if(cell2[i-1][j-1].isAlive)n++;
				} catch(Exception e){}
				try{
					if(cell2[i][j-1].isAlive)n++;
				} catch(Exception e){}
				try{
					if(cell2[i+1][j-1].isAlive)n++;
				} catch(Exception e){}
				try{
					if(cell2[i+1][j].isAlive)n++;
				} catch(Exception e){}
				try{
					if(cell2[i+1][j+1].isAlive)n++;
				} catch(Exception e){}
				try{
					if(cell2[i][j+1].isAlive)n++;
				} catch(Exception e){}
				try{
					if(cell2[i-1][j+1].isAlive)n++;
				} catch(Exception e){}

				boolean b = false;
				if(cell2[i][j].isAlive){
					switch(n){
					case 1:
						b = false;
						break;
					case 2:
					case 3:
						b = true;
						break;
					default:
						b = false;
					}
				}
				else{
					switch(n){
					case 3:
						b = true;
						break;
					default:
						b = false;
					}
				}
				cell[i][j].isAlive = b;
			}
		}
	}

	public void render(Graphics g){
		for(int i =0;i<cell.length;i++){
			for(int j =0;j<cell[0].length;j++){
				cell[i][j].render(g);
			}
		}
	}
}
