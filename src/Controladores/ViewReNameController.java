package Controladores;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javax.swing.JOptionPane;
/**
 * FXML Controller class
 *
 * @authores Johan & Yonier & Sebastián
 */
public class ViewReNameController implements Initializable {
    
    String contraseña;
    
    ViewUserInfoController miUser;
    
    private BorderPane main ;
    
    @FXML
    private TextField txtUser;
    
    @FXML
    private PasswordField txtPass;
    
    @FXML
    private Button btnCambiar,btnCancelar;
    
    @FXML
    private void guardarInfo(ActionEvent event){
        Object evt = event.getSource();
        
        if(evt.equals(btnCambiar)){
            if(!contraseña.equals(txtPass.getText())){
                JOptionPane.showMessageDialog(null, "Contraseña Incorrecta!");
                txtPass.setText("");
            }else if(txtUser.getText().contains(" ")){
                JOptionPane.showMessageDialog(null,"No debe contener espacios en blanco");
                txtUser.requestFocus();
            }else{
                JOptionPane.showMessageDialog(null, "Nombre cambiado correctamente");
                if(miUser != null) {
                    miUser.restore();
                    miUser.nameUser.setText(txtUser.getText());
                    miUser.contraseña = contraseña;
                }
            }
        }else if(evt.equals(btnCancelar)){
            miUser.restore();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    public void setMain(BorderPane borderPane){
        this.main = borderPane;
    }
    public void setMiUser(ViewUserInfoController controller) {
        this.miUser = controller;
    }
   
}