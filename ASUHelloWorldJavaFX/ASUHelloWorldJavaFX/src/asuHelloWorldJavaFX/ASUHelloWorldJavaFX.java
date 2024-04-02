/* Saanvi Agrawal
 * 1221369175
 * 
 * CSE360 hw1
 * Carter Tu 1:30pm 
 * 
 * 
 */





package asuHelloWorldJavaFX;

import java.awt.Insets;
import java.awt.Label;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

 
public class ASUHelloWorldJavaFX extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    public void start(Stage primaryStage) {
    	System.out.println("ASU Hello World!");
    	System.out.println("It started!");
        primaryStage.setTitle("ASU Hello World Spring 2024");
        Button btn = new Button();
        btn.setText("Display: 'ASU says: Hello World!'");
        btn.setOnAction(new EventHandler<>() {
            public void handle(ActionEvent event) {
                System.out.println("ASU: Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
    
    /*
    //creating all the variables 
    private int totalCost;
    private Label eat, drink;
    private CheckBox eggSandwich, chickenSandwich, bagel, potatoSalad;
    private RadioButton blackTea, greenTea, coffee, orangeJuice;
    private TextArea billDisplay;
    
        
    @Override
    public void start(Stage primaryStage) {
    	System.out.println("It started!");
        primaryStage.setTitle("Joe's Deli");
        
        //The labels are not quiet working, not sure why
        Label titleLabel = new Label("Joe's Deli");
        Label eat = new Label("Eat:");
        Label drink = new Label("Drink:");

        eggSandwich = new CheckBox("Egg Sandwich");
        chickenSandwich = new CheckBox("Chicken Sandwich");
        bagel = new CheckBox("Bagel");
        potatoSalad = new CheckBox("Potato Salad");
        
        blackTea = new RadioButton("Black Tea");
        greenTea = new RadioButton("Green Tea");
        coffee = new RadioButton("Coffee");
        orangeJuice = new RadioButton("Orange Juice");
        
        ToggleGroup drinks = new ToggleGroup();
        coffee.setToggleGroup(drinks);
        greenTea.setToggleGroup(drinks);
        blackTea.setToggleGroup(drinks);
        orangeJuice.setToggleGroup(drinks);

        billDisplay = new TextArea();
        billDisplay.setEditable(false);
        
        //Creating the layout
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new javafx.geometry.Insets(20, 20, 20, 20));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        //gridPane.add(titleLabel, 0, 0, 2, 1); 
        //gridPane.add(eat, 0, 1);
        gridPane.add(eggSandwich, 0, 1);
        gridPane.add(chickenSandwich, 0, 2);
        gridPane.add(bagel, 0, 3);
        gridPane.add(potatoSalad, 0, 4);
        //gridPane.add(drink, 1, 1);
        gridPane.add(coffee, 1, 1);
        gridPane.add(greenTea, 1, 2);
        gridPane.add(blackTea, 1, 3);
        gridPane.add(orangeJuice, 1, 4);
        gridPane.add(billDisplay, 2, 1, 1, 10);
        
        //I was having trouble spacing everything out and 
        //this helps distribute the space between evenly in 1/3s
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(33.33);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(33.33);
        ColumnConstraints col3 = new ColumnConstraints();
        col3.setPercentWidth(33.33);

        gridPane.getColumnConstraints().addAll(col1, col2, col3);
        
        
        //making the 3 buttons on the bottom
        Button orderButton = new Button("Order");
        orderButton.setOnAction(e -> placeOrder());

        Button cancelButton = new Button("Cancel");
        cancelButton.setOnAction(e -> cancelOrder());

        Button confirmButton = new Button("Confirm");
        confirmButton.setOnAction(e -> confirmOrder());
        
        gridPane.add(orderButton, 0, 5);
        gridPane.add(cancelButton, 1, 5);
        gridPane.add(confirmButton, 2, 5);
        
        
        Scene scene = new Scene(gridPane, 500, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
        }
        
        
        
 	private Object confirmOrder() {
 		calculateTotalCost();
 	    displayBill();
		return null;
	}


	private Object cancelOrder() {
		clearSelections();
	    billDisplay.clear();
		return null;
	}


	private Object placeOrder() {
		clearSelections();
	    displayFinalBill();
		return null;
	}
    
	//Calculating total cost
	private void calculateTotalCost() {
	    totalCost = 0;
	    totalCost += eggSandwich.isSelected() ? 7.99 : 0;
	    totalCost += chickenSandwich.isSelected() ? 9.99 : 0;
	    totalCost += bagel.isSelected() ? 2.50 : 0;
	    totalCost += potatoSalad.isSelected() ? 4.49 : 0;

	    if (coffee.isSelected()) totalCost += 1.99;
	    else if (greenTea.isSelected()) totalCost += 0.99;
	    else if (blackTea.isSelected()) totalCost += 1.25;
	    else if (orangeJuice.isSelected()) totalCost += 2.25;

	    // Apply 7% sales tax
	    totalCost *= 1.07;
	}

	//Displaying the bill will all the costs assigned
	private void displayBill() {
	    billDisplay.setText("Ordered Items:\n");

	    if (eggSandwich.isSelected())
	        billDisplay.appendText("Egg Sandwich: $7.99\n");

	    if (chickenSandwich.isSelected())
	        billDisplay.appendText("Chicken Sandwich: $9.99\n");

	    if (bagel.isSelected())
	        billDisplay.appendText("Bagel: $2.50\n");

	    if (potatoSalad.isSelected())
	        billDisplay.appendText("Potato Salad: $4.49\n");

	    if (coffee.isSelected())
	        billDisplay.appendText("Coffee: $1.99\n");
	    else if (greenTea.isSelected())
	        billDisplay.appendText("Green Tea: $0.99\n");
	    else if (blackTea.isSelected())
	        billDisplay.appendText("Black Tea: $1.25\n");
	    else if (orangeJuice.isSelected())
	        billDisplay.appendText("Orange Juice: $2.25\n");

	    Object totalCost = null;
		billDisplay.appendText("\nTotal Cost: $" + String.format("%.2f", totalCost));
	}

	//Displaying the final bill 
	private void displayFinalBill() {
	    displayBill();
	    Alert confirmationAlert = new Alert(Alert.AlertType.INFORMATION);
	    confirmationAlert.setTitle("Order Confirmed");
	    confirmationAlert.setHeaderText(null);
	    confirmationAlert.setContentText("Thank you for your order!");
	    confirmationAlert.showAndWait();
	    billDisplay.clear();
	}

	private void clearSelections() {
	    eggSandwich.setSelected(false);
	    chickenSandwich.setSelected(false);
	    bagel.setSelected(false);
	    potatoSalad.setSelected(false);

	    coffee.setSelected(false);
	    greenTea.setSelected(false);
	    blackTea.setSelected(false);
	    orangeJuice.setSelected(false);
	}
     
    */
    
 /*   
    public void start(Stage primaryStage) {
    	System.out.println("ASU Hello World!");
    	System.out.println("It started!");
        primaryStage.setTitle("ASU Hello World Spring 2024");
        Button btn = new Button();
        btn.setText("Display: 'ASU says: Hello World!'");
        btn.setOnAction(new EventHandler<>() {
            public void handle(ActionEvent event) {
                System.out.println("ASU: Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
    
 */
}