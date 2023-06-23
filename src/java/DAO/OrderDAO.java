/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Cart;
import Model.Category;
import Model.Item;
import Model.Product;
import Model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aver
 */
public class OrderDAO extends DBContext {

    public List<Product> getAllProduct() {
        List<Product> products = new ArrayList<>();
        try {
            String sql = "select * from Products";
            PreparedStatement stm = connection.prepareCall(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product fl = new Product();
                fl.setProductId(rs.getInt("productID"));
                fl.setProductName(rs.getString("productName"));
                fl.setDescript(rs.getString("descript"));
                fl.setImage(rs.getString("imagee"));
                fl.setPrice(rs.getFloat("price"));
                Category cat = new Category();
                cat.setCategoryId(rs.getInt("categoryId"));
                fl.setCategory(cat);
                products.add(fl);
            }
            return products;
        } catch (SQLException ex) {
            Logger.getLogger(productDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public void addOrder(User c, Cart cart) {
        LocalDate curDate = LocalDate.now();
        String date = curDate.toString();
        try {
            //add order
            String sql = "insert into [orders] values(?,?,?)";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, c.getId());
            st.setString(2, date);
            st.setDouble(3, cart.getTotalMoney());
            st.executeUpdate();
            //lay id cua order vua add
            String sql1 = "select top 1 orderID from [Orders] order by orderID desc";
            PreparedStatement st1 = connection.prepareStatement(sql1);
            ResultSet rs = st1.executeQuery();
            //add bang OrderDetail
            if (rs.next()) {
                int oid = rs.getInt("orderID");
                for (Item i: cart.getItems()) {
                    String sql2 = "insert into [OrderItems] values(?,?,?,?)";
                    PreparedStatement st2 = connection.prepareStatement(sql2);
                    st2.setInt(1, i.getProduct().getProductId());
                    st2.setInt(2, oid);
                    st2.setFloat(3, i.getPrice());
                    st2.setInt(4, i.getQuantity());
                    st2.executeUpdate();
                }
            }

        } catch (SQLException e) {

        }
    }
    public int getOrderId(int id) {
        try {
            String sql = "select top 1 orderID from [Orders] order by orderID desc";
            PreparedStatement stm = connection.prepareCall(sql);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                int count = rs.getInt("orderID");
                return count;
            }
            return 0;
        } catch (SQLException ex) {
            Logger.getLogger(productDao.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    public static void main(String[] args) {
    }
}
