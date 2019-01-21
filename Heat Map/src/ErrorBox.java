import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ErrorBox {
	
	
	public static void show(){
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle("Error!");
	
		Label errorLabel = new Label();
		errorLabel.setText("That symbol is not found!");
		
		Button okButton = new Button();
		okButton.setText("OK");
		okButton.setOnAction(e -> {
			stage.close();
		});
	
		VBox pane = new VBox(20);
		pane.setPrefSize(200, 100);
		pane.setStyle("-fx-background-color: #AA2222");
		pane.getChildren().addAll(errorLabel,okButton);
		pane.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.showAndWait();
	}
	
}