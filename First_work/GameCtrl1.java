package First_Work;

//package isel.leic.poo.snake.Console;


import isel.leic.pg.Console; 
import static isel.leic.pg.Console.*;

import java.awt.event.KeyEvent;

import isel.leic.pg.Console;
import static isel.leic.pg.Console.*; 

//import isel.leic.poo.snake.model.*;  // Classes do modelo do jogo

public class GameCtrl1 {                             // Controller
//	private final Level1 level = new Level1();       // Model
	private final Level1 level = new Level1();       // Model
	private final GameView view = new GameView();    // View
	static boolean first;

	static Console console;
	private long time;                              // Tempo absoluto (em milisegundos) para cada movimento
	private static final int STEP_TIME = 500;       // Tempo entre movimentos
	private static final boolean TIMED = true;      // Movimentos temporizados (true) ou por cada tecla premida (false)

	public static void main(String[] args) {
		GameCtrl1 game = new GameCtrl1();

		//console.open("Snake", 20, 20);
		if ( game.loadLevel("level01.txt") ){
			game.run();
		}
	}

	private void run() {
		Console.open(level.getTitle(),level.getMaxLines(),level.getMaxColumns());
		level.setElementListener(view);             // Para atualizações de cada elemento
		int key;
		Dir dir = Dir.UP;                           // Direção corrente
		time = System.currentTimeMillis();          // Inicia com o tempo atual
		view.repaint(level);                        // Inicialmente desenha tudo
		do {
			key = getKey();
			if (key== KeyEvent.VK_ESCAPE) break;
			switch (key) {
			case KeyEvent.VK_UP: dir=Dir.UP; break;
			case KeyEvent.VK_DOWN: dir=Dir.DOWN; break;
			case KeyEvent.VK_LEFT: dir=Dir.LEFT; break;
			case KeyEvent.VK_RIGHT: dir=Dir.RIGHT; break;
			}
			level.move(dir);                        // Progride um passo no modelo
		} while( ! level.isOver() );
		toast(level.isSnakeDead() ? "GAME OVER" : "TERMINATED");
		Console.close();
	}

	private int getKey() {
		int key;
		if (TIMED) {
			time += STEP_TIME;                      // Acerta o tempo para o proximo movimento
			key = Console.getKeyPressedUntil(time); // Obtém tecla premida e espera que o tempo decorra
		} else {
			key = Console.waitKeyPressed(0);        // Espera indefinidamente por uma tecla premida
			Console.waitKeyReleased(key);           // Espera que a tecla seja libertada
		}
		return key;
	}

	private void toast(String msg) {
		Console.cursor(0, (level.getMaxColumns()-msg.length())/2);
		Console.color(Console.RED,Console.YELLOW);
		Console.print(msg);
		while( Console.isKeyPressed() )
			;
		Console.waitKeyPressed(5000);
	}

	private boolean loadLevel(String fileName) {
		// try (InputStream file = new FileInputStream(fileName)) {
		try{
			level.load(fileName, console);
			System.out.println("TRUEEEE");
			return true;
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("FALSE");
			return false;
		}
	}
}
