/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.Category;

/**
 *
 * @author int.thong.nk
 */
public class CategoryDao extends DBContext {

    public List<Category> getAllCategory() {
        List<Category> category = new ArrayList<>();
        String sql = "select * from [Category]";
        try {
            PreparedStatement stm = connection.prepareCall(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Category cat = new Category();
                cat.setCategoryId(rs.getInt("categoryID"));
                cat.setCategoryName(rs.getString("categoryName"));
                category.add(cat);
            }
            return category;
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static void main(String[] args) {
        CategoryDao db = new CategoryDao();
        List<Category> cat = db.getAllCategory();
        System.out.println(cat.size());
    }
}
