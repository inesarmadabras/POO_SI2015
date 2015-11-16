package First_Work;

import isel.leic.pg.Console;

import java.util.LinkedList;

import First_Work.model.Snake;

public class SnakeView<E> extends Snake {

	//	SlinkedList<Character> snake = new SlinkedList<Character>();
	boolean start = true;
	static int count = 0;

	static LinkedList<Character> sk1 = new LinkedList<>();


	public  void paint(Snake sk, char snake1, int lin, int col, Dir dir){
		initSnake( snake1);
		//		if(sk1.getFirst() == sk1.getLast()){
		//			Console.color(Console.RED, Console.YELLOW);
		//		}else{
		//			Console.color(Console.BLACK, Console.RED);
		//		}
		System.out.println("size "+ sk1.size());
		int contador = sk1.size(); int i = 0;
		while(contador > 0){


			if(contador-- == sk1.size()){
				Console.color(Console.BLUE, Console.YELLOW);
				Console.cursor(lin,col);   
				Console.print(sk1.getFirst());
			}

			else{
				if(dir == dir.UP){Console.cursor(++lin,col); }
				if(dir == dir.DOWN){Console.cursor(--lin,col);}
				if(dir == dir.LEFT){Console.cursor(lin,++col);
				//	upDateView( lin,  col);
				}
				if(dir == dir.RIGHT){Console.cursor(lin,--col);}
				Console.color(Console.BLACK, Console.RED);
				if(sk1.size() != 0)Console.print(sk1.get(++i));
			}
			count++;
		}
		count =0;

	}





	public void initSnake(char c){
		if(sk1.size() < 4)
			sk1.addLast(c);

	}

//	public void upDateView(int lin, int col){
//		for (int j = 0; j < sk1.size(); j++) {
//			if(j == count) break;
//			if(j == 0){
//				Console.cursor(lin,--col);
//				Console.print(sk1.get(j));
//			}
//			if(j == 1){
//				Console.cursor(--lin,col);
//				Console.print(sk1.get(j));
//			}
//			if(j == 2){
//				Console.cursor(--lin,col);
//				Console.print(sk1.get(j));
//			}
//
//
//		}
//	}

}




