/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aver
 */
public class ShipDao extends DBContext {

    public int addInfo(int oid, int uid, String fullname, String phone, String address, int status) {
        try {
            String sql = "INSERT INTO [dbo].[Ship] VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,1)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, oid);
            stm.setInt(2, uid);
            stm.setString(3, fullname);
            stm.setString(4, phone);
            stm.setString(5, address);
            stm.setInt(6, 1);
            stm.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        return 1;
    }
}
