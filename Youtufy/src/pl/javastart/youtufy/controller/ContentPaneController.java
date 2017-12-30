package pl.javastart.youtufy.controller;
 
import java.net.URL;
import java.util.ResourceBundle;
 
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.web.WebView;
import pl.javastart.youtufy.data.YoutubeVideo;
 
public class ContentPaneController implements Initializable {
 
    @FXML
    private TableView<YoutubeVideo> resultTableView;
 
    @FXML
    private WebView videoWebView;
 
    public TableView<YoutubeVideo> getResultTableView() {
        return resultTableView;
    }
 
    public void setResultTableView(TableView<YoutubeVideo> resultTableView) {
        this.resultTableView = resultTableView;
    }
 
    public WebView getVideoWebView() {
        return videoWebView;
    }
 
    public void setVideoWebView(WebView videoWebView) {
        this.videoWebView = videoWebView;
    }
 
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TableColumn<YoutubeVideo, String> titleColumn = new TableColumn<>("Song");
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
         
        TableColumn<YoutubeVideo, String> authorColumn = new TableColumn<>("Youtube Author");
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
         
        resultTableView.getColumns().add(titleColumn);
        resultTableView.getColumns().add(authorColumn);
    }
}