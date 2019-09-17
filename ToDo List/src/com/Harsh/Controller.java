package com.Harsh;



import com.Harsh.DataModel.ToDoData;
import com.Harsh.DataModel.ToDoItem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private List<ToDoItem>toDoItems;
    @FXML
    private ListView<ToDoItem> todoListView;
    @FXML
    private TextArea itemDetailsTextArea;
    @FXML
    private Label deadline;
   /* @FXML
    public void intialize(){

    }*/

    @Override
    public void initialize ( URL location, ResourceBundle resources ) {
/*     ToDoItem item1=new ToDoItem ( "Aptitude Prepration", "Reasoning Practice 📙 ", LocalDate.of ( 2019, Month.JUNE,27 ) );
        ToDoItem item2=new ToDoItem ( "Project Restraunt Billing Management", "Make a Project for Restraunt Billing Management 🏆", LocalDate.of ( 2019, Month.JUNE,28 ) );
        ToDoItem item3=new ToDoItem ( "GeeksForGeeks DSA#3", "Reasoning Practice 💡", LocalDate.of ( 2019, Month.JUNE,29 ) );
        ToDoItem item4=new ToDoItem ( "Enjoy Your Life", "Live Your Life to the Fullest 🦁🧬 ", LocalDate.of ( 2019, Month.MARCH,8 ) );

        toDoItems =new ArrayList<ToDoItem> (  );
        toDoItems.add ( item1 );
        toDoItems.add ( item2 );
        toDoItems.add ( item3 );
        toDoItems.add ( item4 );
        ToDoData.getInstance ().setTodoitem ( toDoItems );*/
        todoListView.getSelectionModel ().selectedItemProperty ().addListener ( new ChangeListener<ToDoItem> ( ) {
            @Override
            public void changed ( ObservableValue<? extends ToDoItem> observable, ToDoItem oldValue, ToDoItem newValue ) {
                if(newValue!=null){
                    ToDoItem item=todoListView.getSelectionModel ().getSelectedItem ();
                    itemDetailsTextArea.setText ( item.getDetails () );
                    handleClickListView ();
                }
            }
        } );
        //todoListView.getItems ().setAll ( toDoItems );
        todoListView.getItems ().setAll ( ToDoData.getInstance ().getTodoitem () );
        todoListView.getSelectionModel ().setSelectionMode ( SelectionMode.SINGLE );
        todoListView.getSelectionModel ().selectFirst ();
    }
    @FXML
    public void handleClickListView(){
        ToDoItem item= todoListView.getSelectionModel ().getSelectedItem ();
        //    System.out.println ("The selected Item is "+item );
        //   itemDetailsTextArea.setText ( item.getDetails () );
        /*StringBuilder sb=new StringBuilder ( item.getDetails () );
        sb.append ( "\n\n\n\n\t" );
        sb.append ( "Due Date: " );
        sb.append ( item.getDeadline () );
        itemDetailsTextArea.setText ( sb.toString () );*/
        DateTimeFormatter df=DateTimeFormatter.ofPattern ( "MMMM d, yyyy " );
        itemDetailsTextArea.setText ( item.getDetails () );
        deadline.setText ( df.format ( item.getDeadline ()));


    }



}
