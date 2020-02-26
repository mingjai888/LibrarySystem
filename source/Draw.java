import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 * Draw class is a function available to users when selecting an avatar, they
 * can use the UI to create a custom drawing
 * 
 * @author Riyaad Islam and Oliver Nixon
 * @version 1.0.0
 */
public class Draw extends Application {

	private User curUser;

	@Override
	public void start(Stage primaryStage) {
		curUser = LoginController.getLoggedUser();

		/* Creating buttons for all functions */
		ToggleButton pencilbutton = new ToggleButton("Pencil");
		ToggleButton eraserbutton = new ToggleButton("Eraser");
		ToggleButton linebutton = new ToggleButton("Straight Line");
		ToggleButton rectanglebutton = new ToggleButton("Rectangle Shape");
		ToggleButton circlebutton = new ToggleButton("Circle Shape");
		ToggleButton clearbutton = new ToggleButton("Clear");

		ToggleButton[] toolsArray = { pencilbutton, eraserbutton, linebutton,
				rectanglebutton, circlebutton, clearbutton };

		ToggleGroup tools = new ToggleGroup();

		for (ToggleButton tool : toolsArray) {
			tool.setMinWidth(90);
			tool.setToggleGroup(tools);
			tool.setCursor(Cursor.HAND);
		}

		ColorPicker colourpickerLine = new ColorPicker(Color.BLACK);
		ColorPicker colourpickerFill = new ColorPicker(Color.TRANSPARENT);

		Slider slide = new Slider(1, 50, 3);
		slide.setShowTickLabels(true);

		Label line_colour = new Label("Line Colour");
		Label fill_colour = new Label("Fill Colour");
		Label line_width = new Label("Line Size");

		Button save = new Button("Save");

		Button[] basArray = { save };

		for (Button button : basArray) {
			button.setMinWidth(90);
			button.setCursor(Cursor.HAND);
			button.setTextFill(Color.BLACK);
			button.setStyle("-fx-background-color: #666;");
		}
		save.setStyle("-fx-background-color: #ffffff;");

		VBox buttons = new VBox(10);
		buttons.getChildren().addAll(pencilbutton, eraserbutton, linebutton,
				rectanglebutton, circlebutton, clearbutton, line_colour,
				colourpickerLine, fill_colour, colourpickerFill, line_width,
				slide, save);
		buttons.setPadding(new Insets(5));
		buttons.setStyle("-fx-background-color: #4169e1");
		buttons.setPrefWidth(100);

		/* Creating the canvas */
		Canvas sketchpad = new Canvas(400, 470);
		GraphicsContext gc;
		gc = sketchpad.getGraphicsContext2D();
		gc.setLineWidth(1);

		Line straightline = new Line();
		Rectangle rectangle = new Rectangle();
		Circle circle = new Circle();

		sketchpad.setOnMousePressed(e -> {
			if (pencilbutton.isSelected()) {
				gc.setStroke(colourpickerLine.getValue());
				gc.beginPath();
				gc.lineTo(e.getX(), e.getY());
			} else if (eraserbutton.isSelected()) {
				double lineWidth = gc.getLineWidth();
				gc.clearRect(e.getX() - lineWidth / 2, e.getY() - lineWidth / 2,
						lineWidth, lineWidth);
			} else if (linebutton.isSelected()) {
				gc.setStroke(colourpickerLine.getValue());
				straightline.setStartX(e.getX());
				straightline.setStartY(e.getY());
			} else if (rectanglebutton.isSelected()) {
				gc.setStroke(colourpickerLine.getValue());
				gc.setFill(colourpickerFill.getValue());
				rectangle.setX(e.getX());
				rectangle.setY(e.getY());

			} else if (circlebutton.isSelected()) {
				gc.setStroke(colourpickerLine.getValue());
				gc.setFill(colourpickerFill.getValue());
				circle.setCenterX(e.getX());
				circle.setCenterY(e.getY());

			} else if (clearbutton.isSelected()) {
				gc.setFill(colourpickerFill.getValue());
				gc.clearRect(0, 0, 400, 470);

			}
		});

		sketchpad.setOnMouseDragged(e -> {
			if (pencilbutton.isSelected()) {
				gc.lineTo(e.getX(), e.getY());
				gc.stroke();
			} else if (eraserbutton.isSelected()) {
				double lineWidth = gc.getLineWidth();
				gc.clearRect(e.getX() - lineWidth / 2, e.getY() - lineWidth / 2,
						lineWidth, lineWidth);
			}
		});

		sketchpad.setOnMouseReleased(e -> {
			if (pencilbutton.isSelected()) {
				gc.lineTo(e.getX(), e.getY());
				gc.stroke();
				gc.closePath();
			} else if (eraserbutton.isSelected()) {
				double lineWidth = gc.getLineWidth();
				gc.clearRect(e.getX() - lineWidth / 2, e.getY() - lineWidth / 2,
						lineWidth, lineWidth);
			} else if (linebutton.isSelected()) {

				straightline.setEndX(e.getX());
				straightline.setEndY(e.getY());
				gc.strokeLine(straightline.getStartX(),
						straightline.getStartY(), straightline.getEndX(),
						straightline.getEndY());

				// creates rectangle
			} else if (rectanglebutton.isSelected()) {
				rectangle.setWidth(Math.abs((e.getX() - rectangle.getX())));
				rectangle.setHeight(Math.abs((e.getY() - rectangle.getY())));

				if (rectangle.getX() > e.getX()) {
					rectangle.setX(e.getX());
				}

				if (rectangle.getY() > e.getY()) {
					rectangle.setY(e.getY());
				}

				gc.strokeRect(rectangle.getX(), rectangle.getY(),
						rectangle.getWidth(), rectangle.getHeight());
				gc.fillRect(rectangle.getX(), rectangle.getY(),
						rectangle.getWidth(), rectangle.getHeight());

				// creates circle
			} else if (circlebutton.isSelected()) {
				circle.setRadius((Math.abs(e.getX() - circle.getCenterX())
						+ Math.abs(e.getY() - circle.getCenterY())) / 2);

				if (circle.getCenterX() > e.getX()) {
					circle.setCenterX(e.getX());
				}
				if (circle.getCenterY() > e.getY()) {
					circle.setCenterY(e.getY());
				}

				gc.strokeOval(circle.getCenterX(), circle.getCenterY(),
						circle.getRadius(), circle.getRadius());
				gc.fillOval(circle.getCenterX(), circle.getCenterY(),
						circle.getRadius(), circle.getRadius());

			}

		});
		// gives the colour options
		colourpickerLine.setOnAction(e -> {
			gc.setStroke(colourpickerLine.getValue());
		});
		colourpickerFill.setOnAction(e -> {
			gc.setFill(colourpickerFill.getValue());
		});

		// slider
		slide.valueProperty().addListener(e -> {
			double width = slide.getValue();

			gc.setLineWidth(width);
		});

		/* Save feature created */

		save.setOnAction((e) -> {
			FileChooser savecreation = new FileChooser();
			savecreation.setTitle("Save File");

			File outputFile = new File(
					"src\\Avatar" + curUser.getUsername() + ".png");
			if (outputFile != null) {
				try {
					WritableImage writeImage = new WritableImage(1080, 790);
					sketchpad.snapshot(null, writeImage);
					RenderedImage rendImg = SwingFXUtils.fromFXImage(writeImage,
							null);
					ImageIO.write(rendImg, "png", outputFile);
				} catch (IOException ex) {
					System.out.println("Invalid");
				}
			}

		});

		/* The stage and scene */
		BorderPane pane = new BorderPane();
		pane.setLeft(buttons);
		pane.setCenter(sketchpad);

		Scene scene = new Scene(pane, 500, 480);

		primaryStage.setTitle("Avatar Paint");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}