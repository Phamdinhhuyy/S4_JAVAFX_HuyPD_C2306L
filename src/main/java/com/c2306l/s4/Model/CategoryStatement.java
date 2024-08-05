package com.c2306l.s4.Model;

import com.c2306l.s4.Entity.Category;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CategoryStatement {
    private static final long serialVersionUID = 1L;
    private static final Connection conn = MySQLStatement.getConnection();

    public static void insert(Category category){
        try{
            String sql = "INSERT INTO tblcategory(cat_code,cat_name,cat_description) VALUES(?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, category.getCode());
            ps.setString(2, category.getName());
            ps.setString(3, category.getDescription());
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void update(Category category){
        try{
            String sql = "UPDATE tblcategory SET cat_code=?, cat_name=?, cat_description=? WHERE id = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, category.getCode());
            ps.setString(2, category.getName());
            ps.setString(3, category.getDescription());
            ps.setInt(4, category.getId());
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void delete(Category category){
        try{
            String sql = "DELETE FROM tblcategory WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, category.getId());
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static ObservableList<Category> getAll(){
        ObservableList<Category> list = FXCollections.observableArrayList();
        try{
            String sql = "SELECT * FROM tblcategory";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setCode(rs.getString("cat_code"));
                category.setName(rs.getString("cat_name"));
                category.setDescription(rs.getString("cat_description"));
                list.add(category);
            }
            rs.close();
            ps.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public static Category getById(int id){
        Category category = new Category();
        try{
            String sql = "SELECT * FROM tblcategory WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeQuery();
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                category.setId(rs.getInt("id"));
                category.setCode(rs.getString("cat_code"));
                category.setName(rs.getString("cat_name"));
                category.setDescription(rs.getString("cat_description"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return category;
    }
}
