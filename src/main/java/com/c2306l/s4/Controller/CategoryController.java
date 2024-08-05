package com.c2306l.s4.Controller;

import com.c2306l.s4.Entity.Category;
import com.c2306l.s4.Model.CategoryStatement;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.ObjDoubleConsumer;

public class CategoryController implements Initializable {
    @FXML private TableColumn<Category, String> cid;
    @FXML private TableColumn<Category, String> ccode;
    @FXML private TableColumn<Category, String> cname;
    @FXML private TableColumn<Category, String> cdescription;
    @FXML private TextField txtCode;
    @FXML private TextField txtName;
    @FXML private TextArea txtDescription;
    @FXML private Button btnNewCategory;
    @FXML private Button btnEditCategory;
    @FXML private TableView<Category> tableCategory = new TableView<Category>() ;
    private ObservableList<Category> categories;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        categories = CategoryStatement.getAll();
        tableCategory.setEditable(true);
        tableCategory.getColumns().get(0).setVisible(false);
        cid.setText("ID");
        cid.setCellValueFactory(new PropertyValueFactory<>("id"));
        ccode.setCellValueFactory(new PropertyValueFactory<>("code"));
        cname.setCellValueFactory(new PropertyValueFactory<>("name"));
        cdescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        tableCategory.setItems(categories);

        btnNewCategory.setOnAction(event -> {
            Category category = new Category();
            category.setCode(txtCode.getText());
            category.setName(txtName.getText());
            category.setDescription(txtDescription.getText());
            CategoryStatement.insert(category);
            tableCategory.getItems().clear();
            ObservableList<Category> categories = CategoryStatement.getAll();

            tableCategory.setItems(categories);
            tableCategory.refresh();
        });
    }

}


