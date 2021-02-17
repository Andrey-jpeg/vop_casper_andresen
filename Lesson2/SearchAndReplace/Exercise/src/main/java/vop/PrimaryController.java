package vop;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class PrimaryController implements javafx.fxml.Initializable{

    FileChooser fileChooser = new FileChooser();

    @FXML
    private TextField searchField;

    @FXML
    private TextField replaceField;

    @FXML
    private TextArea fileTextArea;

    @FXML
    private Button replaceAlleButton;

    @FXML
    private Button openFileButton;

    @FXML
    private Button saveAsButton;

    @FXML
    void openFile(MouseEvent event) throws NullPointerException {
        Node node = (Node) event.getSource();
        Stage thisStage = (Stage) node.getScene().getWindow();
        fileChooser.setTitle("Open Resource File");
        File selectedFile = fileChooser.showOpenDialog(thisStage);

        try (InputStream inputStream = getClass().getResourceAsStream(selectedFile.getName());
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            fileTextArea.setText(reader.lines()
                    .collect(Collectors.joining(System.lineSeparator())));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e){
            System.out.println("You can only open .txt files!");
        }

    }

    @FXML
    void saveAs(MouseEvent event) {
        Node node = (Node) event.getSource();
        Stage thisStage = (Stage) node.getScene().getWindow();
        fileChooser.setTitle("Save");
        File file = fileChooser.showSaveDialog(thisStage);

        if (file != null) {
            saveTextToFile(fileTextArea.getText(), file);
        }

    }

    private void saveTextToFile(String content, File file) {
        try {
            PrintWriter writer;
            writer = new PrintWriter(file);
            writer.println(content);
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @FXML
    void replaceAll(MouseEvent event){
        String currentText = fileTextArea.getText();
        fileTextArea.setText(currentText.replaceAll(searchField.getText(), replaceField.getText()));
    }

    public void initialize(URL var1, ResourceBundle var2){
        fileChooser.setInitialDirectory(new File("."));
    }


}
