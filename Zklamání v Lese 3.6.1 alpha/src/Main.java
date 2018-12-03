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
	GraphicsContext gc;
	
	private Parent createContent() {
		root = new Pane();
		root.setPrefSize(800, 600);
		root.getCursor();
		Canvas platno = new Canvas(800,600);
		gc = platno.getGraphicsContext2D();
		gc.save();
		gc.setFill(Color.BLUEVIOLET);
		gc.fillRect(0, 0, 800, 600);
		gc.restore();
		root.getChildren().add(platno);		
		return root;
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		
		stage.setTitle("Zklamání v lese");
		stage.setScene(new Scene(createContent()));
		stage.show();
		napisText("Hlavní nabídka");
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
	

}

