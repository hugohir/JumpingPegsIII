/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jumpingpegsiii;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.image.Image;


/**
 *
 * @author hhira
 */
public class JumpingPegsController {
    

       @FXML
    private Label labelMovingNow;

    @FXML
    private ImageView imageView9;

    @FXML
    private ImageView imageView14;

    @FXML
    private ImageView imageView8;

    @FXML
    private ImageView imageView13;

    @FXML
    private ImageView imageView12;

    @FXML
    private HBox hboxPegBoard;

    @FXML
    private ImageView imageView11;

    @FXML
    private ImageView imgViewBackground;

    @FXML
    private ImageView imageView5;

    @FXML
    private ImageView imageView4;

    @FXML
    private Label labelSwaps;

    @FXML
    private ImageView imageView7;

    @FXML
    private TextField textFieldSystemMsg;

    @FXML
    private ImageView imageView6;

    @FXML
    private ImageView imageView1;

    @FXML
    private Button ButtonMove;

    @FXML
    private ImageView imageView3;

    @FXML
    private ImageView imageView2;

    @FXML
    private Label labelSystemMsg;

    @FXML
    private ImageView imageView10;

    @FXML
    private TextField TextFieldSwaps;

    @FXML
    private TextField textFieldMoveNow;

    @FXML
    private AnchorPane anchorPanelMain;



    private Image[] iconImage;
   private Image[] iconImage1;
   private Image[] iconImage2;
    private Image blankImage;
   
    
   public void initialize() {
    

        int qtyleftpegs = 3;
        int qtyrightpegs =3;
        
        iconImage = new Image[qtyleftpegs+qtyrightpegs];
        
        iconImage2 = new Image[qtyrightpegs];
        
        iconImage[0]=new Image("file:C\\jumpingPegs\\img\\car1.jpg");
        iconImage[1]=new Image("file:C\\jumpingPegs\\img\\car1.jpg");
        iconImage[2]=new Image("file:C\\jumpingPegs\\img\\car1.jpg");
        iconImage[4]=new Image("file:C\\jumpingPegs\\img\\car2.jpg");
        iconImage[5]=new Image("file:C\\jumpingPegs\\img\\car2.jpg");
        iconImage[6]=new Image("file:C\\jumpingPegs\\img\\car2.jpg");

       // imageView5.setImage(iconImage[0]);
       // imageView6.setImage(iconImage[1]);
       // imageView7.setImage(iconImage[2]);
       // imageView9.setImage(iconImage[4]);
       // imageView10.setImage(iconImage[5]);
      //  imageView11.setImage(iconImage[6]);
        
    }
   
   
   public void buttonMoveListener()
   {
   // console message
       System.out.println("MOVE");
       


}

}