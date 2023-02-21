package fx.masterclass.myContacts;

import fx.masterclass.myContacts.datamodel.Contact;
import fx.masterclass.myContacts.datamodel.ContactData;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.Optional;


public class Controller {

    @FXML
    private BorderPane mainPanel;

    @FXML
    private TableView<Contact> contactTable;

    private ContactData data;

    public void initialize(){
        data=new ContactData();
        data.loadContacts();
        contactTable.setItems(data.getContacts());
    }

    @FXML
    public void showAddContactDialog(){
        Dialog<ButtonType> dialog = new Dialog<>();

        FXMLLoader fxmlLoader = getFxmlLoader(dialog, "Add New Contact");

        Optional<ButtonType> result = dialog.showAndWait();

        if(result.isPresent() && result.get() == ButtonType.OK){
            ContactController contactController = fxmlLoader.getController();
            Contact newContact = contactController.getNewContact();
            data.addContact(newContact);
            data.saveContacts();
        }

    }

    @FXML
    public void showEditContactDialog(){
        Contact selectContact = getSelectedContact("Please select the contact you want to edit.");

        Dialog<ButtonType> dialog = new Dialog<>();

        FXMLLoader fxmlLoader = getFxmlLoader(dialog, "Edit Contact");

        ContactController contactController = fxmlLoader.getController();
        contactController.editContact(selectContact);

        Optional<ButtonType> result = dialog.showAndWait();

        if(result.isPresent() && result.get() == ButtonType.OK){
            contactController.updateContact(selectContact);
            data.saveContacts();
        }
    }

    private FXMLLoader getFxmlLoader(Dialog<ButtonType> dialog, String title) {
        dialog.initOwner(mainPanel.getScene().getWindow());
        dialog.setTitle(title);
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("contactDialog.fxml"));
        try{
            dialog.getDialogPane().setContent(fxmlLoader.load());
        }catch (IOException e){
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return null;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        return fxmlLoader;
    }


    @FXML
    public void deleteContact(){
        Contact selectContact = getSelectedContact("Please select the contact you want to delete.");

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Contact");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to delete  the selected contact: "+selectContact.getFirstName() +" "+ selectContact.getLastName());

        Optional<ButtonType> result = alert.showAndWait();

        if(result.isPresent() && result.get() == ButtonType.OK){
            data.deleteContact(selectContact);
            data.saveContacts();
        }
    }

    private Contact getSelectedContact(String alertContent) {
        Contact selectContact = contactTable.getSelectionModel().getSelectedItem();
        if(selectContact==null){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("No Contact Selected");
            alert.setHeaderText(null);
            alert.setContentText(alertContent);
            alert.showAndWait();
            return null;
        }
        return selectContact;
    }
}
