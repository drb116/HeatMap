import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Finder {
	
	private String symbol = "DIS";
	
	public void show(){
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle("Find Stock");
		stage.setMinWidth(250);
		
		TextField symbolText = new TextField();
		symbolText.setPromptText("Symbol");
		symbolText.setMaxWidth(50);
		
		Label symbolLabel = new Label();
		symbolLabel.setText("Symbol: ");
		
		HBox symbolPane = new HBox(10);
		symbolPane.setAlignment(Pos.CENTER);
		symbolPane.getChildren().addAll(symbolLabel, symbolText);
		
		
		Button okButton = new Button();
		okButton.setText("OK");
		okButton.setOnAction(e -> {
			symbol = symbolText.getText().toUpperCase();
			stage.close();
		});
		
		Button cancelButton = new Button();
		cancelButton.setText("Cancel");
		cancelButton.setOnAction(e -> stage.close());
		
		HBox buttons = new HBox(10);
		buttons.setAlignment(Pos.CENTER);
		buttons.getChildren().addAll(okButton,cancelButton);

		
		VBox pane = new VBox(20);
		pane.setPrefSize(250, 100);
		pane.setStyle("-fx-background-color: skyblue");
		pane.getChildren().addAll(symbolPane,buttons);
		pane.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.showAndWait();
	}
	
	public String getSymbol(){
		return symbol;
	}
}