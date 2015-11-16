package First_Work;

import isel.leic.pg.Console;
import First_Work.model.Snake;


public class GameView extends Snake {

	//	private final  Snake snake;
	
	
	static boolean firstTime = true;
	static Snake s ;
	public static Level1 level1; // Level1 - é subClasse de Snake, por isso tem acesso as variáveis de Snake
	
	
	
	public static void print(char c){

		if(c=='X'){
			Console.color(Console.BLACK, Console.BROWN);
			Console.print(c);
		}
		else if(c=='A'){
			Console.color(Console.GREEN, Console.BLACK);
			Console.print('O');
		}
		else if(c=='@'){
			if(firstTime){
				Console.color(Console.RED, Console.YELLOW);
				firstTime = false;
			}
			else{
				Console.color(Console.BROWN, Console.BLUE);}
				
//			Snake s = new Snake();
			s.headS = c;
//			System.out.println("headSS");
			//	Console.print(c);
		}
		else if(c=='#'){
//			Snake s = new Snake();
			s.body = c;
			Console.print(c);
		}


	}

	public static void repaint(Level1 level) {
		//Console.color(Console.BLACK, Console.BLACK)
		Console.setBackground(Console.BLACK);
		Console.clear();
		
		String [][] board = level.board;
		s =  new Snake();
		level1 =level;
		
		for (int i = 0; i < board[0].length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				//	System.out.println(board[i][j]);
				if(board[i][j]  !=null){
					char c = board[i][j].charAt(0);
					Console.cursor(i,j);

					if(c=='@' && firstTime){
						
						level1.setLinha(i); 
						level1.setColuna(j);
						System.out.println("lin "+ level1.getLinha() + " col "+ level1.getColuna());
						level.snake[s.getLinha()][s.getColuna()] = c;

						SnakeView<Character> x = new SnakeView<Character>();
						x.paint(s, s.headS, level1.getLinha(), level1.getColuna(), level1.dir);
						firstTime = false;
						System.out.println("firstTime "+ firstTime);
					}

					print(c );
				}
			}
			//	System.out.println(" endLine");
		}
	
		
//		return s;


	}

}
