package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Cycle extends Table{

    @Entity(type = "INTEGER", size = 32, primary = true)
    int id;

    @Entity(type = "VARCHAR", size = 50, isnull = false)
    String type;

    @Entity(type = "INTEGER", size = 32, isnull = false)
    int duration;

    @Entity(type = "FLOAT", size = 32, isnull = false)
    float price;

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }


  //  public ObservableList<Cycle> listOfCycles = FXCollections.observableArrayList();

   /* public void fillComboBox () throws Exception{
        String sql ="select type from Cycle";
        PreparedStatement query = Database.CONNECTION.prepareStatement(sql);
        query.setString(1, type);
        ResultSet rs = query.executeQuery();
        while(rs.next()){
            listOfCycles.add((Cycle) Cycle.get(Cycle.class,  rs.getInt(1)));
        }

        query.close();
        rs.close();

    }
*/
}
