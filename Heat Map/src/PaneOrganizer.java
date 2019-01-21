import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.json.JSONException;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.util.Duration;

public class PaneOrganizer {
	private FlowPane main;
	int count;
	public PaneOrganizer() throws IOException, JSONException, InterruptedException{
		main = new FlowPane();
		main.setVgap(1);
		main.setHgap(1);
		main.setPrefHeight(670);
		main.setPrefWidth(1102);
		main.setStyle("-fx-background-color: grey");
		addStocks();
		//stockAnimation();
	}
	
	public Pane getRoot(){
		return main;
	}
	
	private void stockAnimation(){
		KeyFrame kf = new KeyFrame(Duration.millis(5000), e-> {
			try {
				addStocks();
			} catch (IOException | JSONException | InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		Timeline objTimeline = new Timeline(kf);
		objTimeline.setCycleCount(Animation.INDEFINITE);
		objTimeline.play();
	}
	private void addStocks() throws IOException, JSONException, InterruptedException{
		Map<String,ArrayList<Double>> stockMap = Stocks.getData();
		//Sort by percent change
		List<String> keys = stockMap
  	          .entrySet()
  	          .stream()
  	          .sorted((left, right) ->
  	              Double.compare(right.getValue().get(1), left.getValue().get(1)))
  	          .map(entry -> entry.getKey())
  	          .collect(Collectors.toList());

		main.getChildren().clear();
  	    for (String key : keys) {
  	    	Button box = new Button();
  	    	box.setPrefSize(37, 37);
  	    	box.setId(key);

  	    	double change = stockMap.get(key).get(1);
  	    	NumberFormat formatter = new DecimalFormat("0.00");

  	    	if (change>0) 
  	    		box.setStyle("-fx-background-color: #00FF00;-fx-font: 7 arial;-fx-border-color: black;");
  	    	else if (change<0) 
  	    		box.setStyle("-fx-background-color: #FF0000;-fx-font: 7 arial;-fx-border-color: black;");
  	    	else  
  	    		box.setStyle("-fx-background-color: #FFFFFF;-fx-font: 7 arial;-fx-border-color: black;");
  	    
  	    	box.setText(key + "\n" + formatter.format(change*100)+"%");
  	    	box.setOnAction((e)-> {
				try {
					Details.show(key);
				} catch (JSONException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
  	    	main.getChildren().add(box);
  	    }
  	    Region spacer1 = new Region();
  	    spacer1.setPrefWidth(50);
  	    Region spacer2 = new Region();
	    spacer2.setPrefWidth(25);
	    Region spacer3 = new Region();
	    spacer3.setPrefWidth(25);
	    
  	    Button refreshButton = new Button();
		refreshButton.setText("Refresh");
		refreshButton.setOnAction(e-> {
			try {
				addStocks();
			} catch (IOException | JSONException | InterruptedException e1) {
				e1.printStackTrace();
			}
		});
		
		Button findButton = new Button();
		findButton.setText("Find");
		findButton.setOnAction(e-> {
			Finder find = new Finder();
			find.show();
			String lookup = find.getSymbol();
			count=0;
			
			try {
			String originalStyle = main.lookup("#"+lookup).getStyle();
			KeyFrame kf = new KeyFrame(Duration.millis(100), flash->{
				if (count%2==0)
					main.lookup("#"+lookup).setStyle("-fx-background-color: #0000FF;");
				else
					main.lookup("#"+lookup).setStyle(originalStyle);
				count++;
				
			});
			Timeline objTimeline = new Timeline(kf);
			objTimeline.setCycleCount(10);
			objTimeline.play();}
		catch (Exception e1){
			ErrorBox.show();
		}
		});
			
		
  	    Button exitButton = new Button();
		exitButton.setText("Exit");
		exitButton.setOnAction(e-> Platform.exit());
		main.getChildren().addAll(spacer1,refreshButton,spacer2,findButton,spacer3,exitButton);
	}
}
