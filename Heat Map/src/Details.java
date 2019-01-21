import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Details {

	public static void show(String key) throws JSONException, IOException{
		Map<String,String> stockDetails = new HashMap<String,String>();
		stockDetails = Stocks.getDetails(key);
		
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle(key);
		stage.setMinHeight(300);
		
		VBox pane = new VBox(20);
		
		Label name = new Label(stockDetails.get("name"));
		name.setStyle("-fx-font: 25 arial;-fx-font-weight: bold;");
		name.setPadding(new Insets(0,10,0,10));
		
		Label lastTrade = new Label("Last Trade: " + stockDetails.get("latestPrice")); 
		lastTrade.setStyle("-fx-font: 20 arial;");
		Label hiLo = new Label("High: "+ stockDetails.get("high") +
				"\tLow: " + stockDetails.get("low"));
		hiLo.setStyle("-fx-font: 20 arial;");
		hiLo.setPadding(new Insets(0,10,0,10));
		Label open = new Label("Open: "+ stockDetails.get("open"));
		open.setStyle("-fx-font: 20 arial;");
		Label change = new Label("Change: "+ stockDetails.get("change")+
				" ("+stockDetails.get("percent")+")");
		change.setStyle("-fx-font: 20 arial;");
		
		Button okButton = new Button();
		okButton.setText("OK");
		okButton.setOnAction(e -> stage.close());
		
		pane.getChildren().addAll(name,lastTrade,hiLo,open,change,okButton);
		pane.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.showAndWait();
	}
}
