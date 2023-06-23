/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Category;
import Model.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aver
 */
public class productDao extends DBContext {

    public int countProductActive() {
        try {
            String sql = "select count(productID) as countProduct from Products where productStatus = 1";
            PreparedStatement stm = connection.prepareCall(sql);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                int count = rs.getInt("countProduct");
                return count;
            }
            return 0;
        } catch (SQLException ex) {
            Logger.getLogger(productDao.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

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
                cat.setCategoryName(rs.getString("categoryName"));
                fl.setCategory(cat);
                products.add(fl);
            }
            return products;
        } catch (SQLException ex) {
            Logger.getLogger(productDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<Product> getNewProductTop3() {
        List<Product> product = new ArrayList<>();
        try {
            String sql = "select top 3 * from Products f \n"
                    + "left join category g on f.categoryID = g.categoryID \n";
            PreparedStatement stm = connection.prepareCall(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product fl = new Product();
                fl.setProductId(rs.getInt("productID"));
                fl.setProductName(rs.getString("productName"));
                fl.setImage(rs.getString("imagee"));
                fl.setDescript(rs.getString("descript"));
                Category cat = new Category();
                cat.setCategoryId(rs.getInt("categoryID"));
                cat.setCategoryName(rs.getString("categoryName"));
                fl.setCategory(cat);               
                product.add(fl);
            }
            return product;
        } catch (SQLException ex) {
            Logger.getLogger(productDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }


    public List<Product> getAllProduct(String name) {
        List<Product> products = new ArrayList<>();
        try {
            String sql = "select * from Products f \n"
                    + " left join Category g on f.categoryID = g.categoryID \n"
                    + " where [productStatus] = 1 and f.[productName] like '%" + name + "%'";
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
                cat.setCategoryName(rs.getString("categoryName"));
                fl.setCategory(cat);
                products.add(fl);
            }
            return products;
        } catch (SQLException ex) {
            Logger.getLogger(productDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<Product> getProductByCondition(String proName, String category, int page, int page_Size) {
        List<Product> product = new ArrayList<>();
        try {
            String sql = "select * from Products f left join Category g on f.categoryID = g.categoryID \n"
                    + "where productName like ?\n"
                    + "and g.categoryName like ?\n"
                    + "order by [price] offset (?-1)*? row fetch next ? row only";
            PreparedStatement stm = connection.prepareCall(sql);
            stm.setString(1, "%" + proName + "%");
            stm.setString(2, "%" + category + "%");
            stm.setInt(3, page);
            stm.setInt(4, page_Size);
            stm.setInt(5, page_Size);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product fl = new Product();
                fl.setProductId(rs.getInt("productID"));
                fl.setProductName(rs.getString("productName"));
                fl.setImage(rs.getString("imagee"));
                fl.setPrice(rs.getFloat("price"));
                fl.setStatus(rs.getBoolean("productStatus"));
                fl.setDescript(rs.getString("descript"));
                Category cat = new Category();
                cat.setCategoryId(rs.getInt("categoryID"));
                cat.setCategoryName(rs.getString("categoryName"));
                fl.setCategory(cat);

                product.add(fl);
            }
            return product;
        } catch (SQLException ex) {
            Logger.getLogger(productDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public int totalProductByCondition(String name, String category) {
        try {
            String sql = "select count(*) as count from Products f  left join Category g on f.categoryID = g.categoryID \n"
                    + "where productName like ? \n"
                    + "and f.categoryID like ?\n";
            PreparedStatement stm = connection.prepareCall(sql);
            stm.setString(1, "%" + name + "%");
            stm.setString(2, "%" + category + "%");
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                int count = rs.getInt("count");
                return count;
            }
            return 0;
        } catch (SQLException ex) {
            Logger.getLogger(productDao.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public int registerProduct(int categoryID, String proName, String description, String image, float proPrice) {
        try {
            String sql = "INSERT INTO [dbo].[Products]\n"
                    + "           ([categoryID]\n"
                    + "           ,[productName]\n"
                    + "           ,[descript]\n"
                    + "           ,[imagee]\n"
                    + "           ,[price]\n"
                    + "           ,[productStatus])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";
            PreparedStatement stm = connection.prepareCall(sql);
            stm.setInt(1, categoryID);
            stm.setString(2, proName);
            stm.setString(3, description);
            stm.setString(4, image);
            stm.setFloat(5, proPrice);
            stm.setInt(6, 1);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(productDao.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        return 1;
    }

    public Product getProductByID(int productId) {
        try {
            String sql = "select * from Products f \n"
                    + "left join Category g on f.categoryID = g.categoryID \n"
                    + "where productId = ?";
            PreparedStatement stm = connection.prepareCall(sql);
            stm.setInt(1, productId);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Product fl = new Product();
                fl.setProductId(rs.getInt("productID"));
                fl.setProductName(rs.getString("productName"));
                fl.setImage(rs.getString("imagee"));
                fl.setDescript(rs.getString("descript"));
                fl.setPrice(rs.getFloat("price"));
                Category cat = new Category();
                cat.setCategoryId(rs.getInt("categoryId"));
                cat.setCategoryName(rs.getString("categoryName"));
                fl.setCategory(cat);
                return fl;
            }
        } catch (SQLException ex) {
            Logger.getLogger(productDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Product> getProductByCategory(int categoryId) {
        List<Product> product = new ArrayList<>();
        try {
            String sql = "select * from Products f \n"
                    + "left join Category g on f.categoryID = g.CategoryID \n"
                    + "where f.categoryID = ?";
            PreparedStatement stm = connection.prepareCall(sql);
            stm.setInt(1, categoryId);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product fl = new Product();
                fl.setProductId(rs.getInt("productID"));
                fl.setProductName(rs.getString("productName"));
                fl.setImage(rs.getString("imagee"));
                fl.setDescript(rs.getString("descript"));
                fl.setPrice(rs.getFloat("price"));
                Category cat = new Category();
                cat.setCategoryId(rs.getInt("categoryID"));
                cat.setCategoryName(rs.getString("categoryName"));
                fl.setCategory(cat);
                product.add(fl);
            }
            return product;
        } catch (SQLException ex) {
            Logger.getLogger(productDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public int deleteProduct(int proId) {
        try {
            String sql = "DELETE FROM [dbo].[Products] \n"
                    + "      WHERE productId = ?";
            PreparedStatement stm = connection.prepareCall(sql);
            stm.setInt(1, proId);
            stm.executeUpdate();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(productDao.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

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

    public int updateStatusProduct(int productId) {
        try {
            String sql = "UPDATE [dbo].[Products]\n"
                    + "   SET [productStatus] = 0\n"
                    + " WHERE productID = ?";
            PreparedStatement stm = connection.prepareCall(sql);
            stm.setInt(1, productId);
            stm.executeUpdate();
            return (1);
        } catch (SQLException ex) {
            Logger.getLogger(productDao.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public int updateProduct(int categoryId, String name, String img, float price, int status, String descrition, int productId) {
        try {
            String sql = "UPDATE [dbo].[Products]\n"
                    + "   SET [categoryID] = ?\n"
                    + "      ,[productName] = ?\n"
                    + "      ,[imagee] = ?\n"
                    + "      ,[price] = ?\n"
                    + "      ,[productStatus]= ?\n"
                    + "      ,[descript] = ?\n"
                    + " WHERE productID = ?";
            PreparedStatement stm = connection.prepareCall(sql);
            stm.setInt(1, categoryId);
            stm.setString(2, name);
            stm.setString(3, img);
            stm.setFloat(4, price);
            stm.setInt(5, status);
            stm.setString(6, descrition);
            stm.setInt(7, productId);
            stm.executeUpdate();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(productDao.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public static void main(String[] args) {
        productDao db = new productDao();
//        List<Film> film = db.getFilmByCondition("", "", "", "", " filmid asc", 1, 10);
//        db.registerProduct(1, "test", "null", "test", 100);
//        db.getProductByCondition("test", "monman", 1, 10);   
//        System.out.println(db.getProductByCondition("Bun cha", "saltly food", 1, 10));
        db.deleteProduct(18);
    }
}
