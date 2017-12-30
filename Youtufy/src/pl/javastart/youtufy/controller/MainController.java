package pl.javastart.youtufy.controller;
 
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
 
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import pl.javastart.youtufy.data.YoutubeVideo;
import pl.javastart.youtufy.main.Youtube;
 
public class MainController implements Initializable {
     
    @FXML
    private ContentPaneController contentPaneController;
     
    @FXML
    private ControlPaneController controlPaneController;
     
    @FXML
    private MenuPaneController menuPaneController;
     
    @FXML
    private SearchPaneController searchPaneController;
     
    private Youtube youtubeInstance;
 
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        TextField searchField = searchPaneController.getSearchTextField();
        TableView<YoutubeVideo> resultsTable = contentPaneController.getResultTableView();
         
        youtubeInstance = new Youtube();
        youtubeInstance.getSearchQuery().bind(searchField.textProperty());
        resultsTable.setItems(youtubeInstance.getYoutubeVideos());
         
        searchField.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode() == KeyCode.ENTER) {
                    try {
                        youtubeInstance.search();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
         
        ListView<String> searchHistory = searchPaneController.getHistoryListView();
        searchHistory.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(event.getClickCount() == 2) {
                    String searchText = searchHistory.getSelectionModel().getSelectedItem();
                    searchField.setText(searchText);
                    try {
                        youtubeInstance.search();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}