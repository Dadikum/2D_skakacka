import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Main extends Application{
	
	private Pane root;
	private boolean isRunning = false;
	private Thread thread;
	GraphicsContext gc;
	Player player;
	
	private Parent createContent() {
		root = new Pane();
		root.setPrefSize(800, 600);
		root.getCursor();
		Canvas platno = new Canvas(800,600);
		gc = platno.getGraphicsContext2D();
		gc.save();
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, 800, 600);
		gc.restore();
		root.getChildren().add(platno);		
		return root;
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		
		isRunning = true;
		thread = new Thread();
		thread.start();
		
		stage.setTitle("Zklamání v lese");
		stage.setScene(new Scene(createContent()));
		stage.show();
		napisText("Hlavní nabídka");
		Player player = new Player(100,100);
	}
	public void stop() {
		isRunning = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void run(){
        long lastTime = System.nanoTime();
        final double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        int updates = 0;
        int frames = 0;
        long timer = System.currentTimeMillis();

        while(isRunning){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if(delta >= 1){
                tick();
                updates++;
                delta--;
            }
            render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                System.out.println(updates + " Ticks, Fps " + frames);
                updates = 0;
                frames = 0;
            }

        }
        stop();
    }
	
	public void napisText(String text) {
		gc.setFill( Color.BLACK );
	    gc.setStroke( Color.BLACK );
	    gc.setLineWidth(2);
	    Font theFont = Font.font( "Calibri", FontWeight.BOLD, 48 );
	    gc.setFont( theFont );
		gc.fillText(text, 150, 100);
		
	}
	
	
	
	public static void main(String args[]) {
		launch(args);
		
	}
	public void tick() {
		
	}
	
	public void render() {
		player.render();
	}

}

