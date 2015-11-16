package First_Work.model;

import java.util.LinkedList;

public class SnakeBoard {

	LinkedList<Character> x;

	Snake [][] sb = new Snake[20][20];
	public SnakeBoard(char [][] c, Snake sk, int lin, int col){
		sb[lin][col]= sk;
	}
	

}
