/*
 * Copyright(C) 2021,  FPT University
 * J3.L.P0017
 * Photographer Online
 *
 * Record of change:
 * DATE                Version           AUTHOR            DESCRIPTION
 * 16/6/2021             1.0              KhaTran         Fix code
 * 21/6/2021             2.0              KhaTran         Fix comment
 */
package dao.impl;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import dao.PageviewDAO;

/**
 * This class has methods for retrieving and update data to view table in
 * database. The method will return an object of the class
 * <code> java.lang.Exception</code> when there is any error querying the data.
 * <p>
 * Bugs: None
 *
 * @author KhaTran
 */
public class PageviewDAOImpl extends DBContext implements PageviewDAO {

    /**
     * Load the number of views page from database. The result is an int number
     *
     * @return an int number
     * @throws java.lang.Exception
     */
    @Override
    public int getNumberOfViewsPage() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select * from [view]";
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            int count = 0;
            while (rs.next()) {
                count = rs.getInt(1);
            }
            return count;
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
    }

    /**
     * Update the number of views page in database. The number of views page
     * will be increased by 1 every time accessed the page
     *
     * @throws java.lang.Exception
     */
    @Override
    public void updateNumberOfViewsPage() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "UPDATE [view] SET numberOfViewsPage = numberOfViewsPage + 1";
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
    }

}
