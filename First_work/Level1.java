package First_Work;


import isel.leic.pg.Console;
import First_Work.model.Snake;

import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import javax.swing.RepaintManager;
import javax.swing.text.View;


public class Level1 extends Snake{


	GameView view1 ;
	static Dir dir;
	static Dir dirBefore;
	Snake snake1 ;
	Level1 level;
	static boolean first = true;
	static boolean firstStep = false;
	static boolean secondStep = false;


	static int idx = 0;

	static int linha ;
	static int coluna;



	private String title = "SNAKE";
	private static int maxLines = 20;
	private static int maxColums = 20;
	public static String [][] board = new String [maxLines][maxColums];
	//	public static char [][] snake = new char [maxLines][maxColums];
	public static char [][] snake = new char [maxLines][maxColums];



	public String getTitle(){
		return title;
	}

	public int getMaxLines(){
		return maxLines;
	}

	public int getMaxColumns(){
		return maxColums;
	}



	// Dir dir
	public void move(Dir dir){
		SnakeView<Character>  skView= new SnakeView<Character>();
		LinkedList<Character> sk1 = new LinkedList<>();
		boolean isEnd = false;
		this.dir = dir;

		if(first){	level = GameView.level1;	first =false;	}

		linha = level.getLinha();
		coluna = level.getColuna();

		// Valida se o movimento é permitido. ex: <-- -->
		isEnd = validate( dirBefore,  dir);

		if(dir == dir.UP){level.setLinha(--linha); }
		if(dir == dir.DOWN){level.setLinha(++linha); }
		if(dir == dir.LEFT){level.setColuna(--coluna);}
		if(dir == dir.RIGHT){level.setColuna(++coluna);}

		dirBefore = dir;
		if(isEnd){	
			level.setColuna(0); }
		else{	GameView.repaint(level); }

		System.out.println("linha_end " +linha + " coluna_end "+ coluna);
		if(!isOver())
			skView.paint(level, level.body, level.getLinha(), level.getColuna(), dir); 
	}

	public boolean validate(Dir dirBefore, Dir dir){
		if(dirBefore == dir.UP && dir == dir.DOWN || dirBefore == dir.DOWN && dir == dir.UP
				|| dirBefore == dir.LEFT && dir == dir.RIGHT || dirBefore == dir.RIGHT && dir == dir.LEFT	){
			return true;
		}

		return false;
	}

	public void update(SnakeView<Character>  skView, int linha, int coluna){

		snake[linha][coluna] = view1.s.headS;
		skView.paint(view1.s, view1.s.headS, linha, coluna, dir);
	}

	public void setElementListener(GameView view) {
		//	this.view1 = view;
	}

	public boolean isOver() {
		if(level.getLinha() == maxLines-1 || level.getLinha() == 0 ||
				level.getColuna() == maxColums-1 || level.getColuna() == 0){
			System.out.println("isOver");
			return true;
		}

		return false;
	}

	public boolean isSnakeDead() {
		if(isOver()) return true;

		return false;
	}




	public  void load(String file2, Console console){
		try{
			FileReader file = new FileReader(file2);
			BufferedReader readFile = new BufferedReader(file);

			// As 3 primeiras linhas não preciso desenhar
			// mas é preciso guardar os valores de linha e coluna
			String linha1 = readFile.readLine();
			String linha2 = readFile.readLine();
			String linha3 = readFile.readLine();
			String linha = readFile.readLine();

			String [][]saveBoard = new String[maxLines][maxColums];

			for (int i = 0; linha != null; i++) {

				//	System.out.print("linha  "+ linha);
				for (int j = 0; j < linha.length(); j++) {
					char c = linha.charAt(j);

					saveBoard[i][j] = ""+c;
					System.out.print(saveBoard[i][j]);
				}
				linha = readFile.readLine();
				System.out.println();
			}

			// Guardar a string que compoe board
			for (int i = 0; i<saveBoard[1].length; i++){
				for (int j = 0; j < saveBoard[1].length; j++) {

					board[i][j] = saveBoard[i][j];
					//		System.out.print(saveBoard[i][j]);
				}
				//	System.out.println();
			}
		}
		catch(IOException e){ 
			System.out.println("erro ao abrir o arquivo");
			e.getMessage();
		}
	}	




}


