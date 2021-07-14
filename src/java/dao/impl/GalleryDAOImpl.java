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
import dao.GalleryDAO;
import entity.Gallery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * This class has methods for retrieving data from galery table in database. The
 * method will return an object of the class <code> java.lang.Exception</code>
 * when there is any error querying the data.
 * <p>
 * Bugs: None
 *
 * @author KhaTrans
 */
public class GalleryDAOImpl extends DBContext implements GalleryDAO {

    /**
     * Find the list Gallery in the top "number". The result contain a list of
     * <code>entity.Gallery</code> objects with id, title, description, name
     *
     * @param number the number of Gallery. It is an int number
     * @return a list of <code>Gallery</code> objects. It is a
     * <code>java.util.List</code> object
     */
    @Override
    public List<Gallery> getTopGallery(int number) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Gallery> listGalery = new ArrayList<>();
        try {
            String sql = "SELECT top (?) * from galery";
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, number);
            rs = ps.executeQuery();
            while (rs.next()) {
                Gallery galery = new Gallery();
                galery.setId(rs.getInt("ID"));
                galery.setTitle(rs.getString("title"));
                galery.setDescription(rs.getString("description"));
                galery.setName(rs.getString("name"));
                listGalery.add(galery);
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return listGalery;
    }

    /**
     * Find the Gallery by id. The Gallery has id matches with searched id will
     * be returned. The result contain a Gallery of <code>entity.Gallery</code>
     * objects with id, title, description, name
     *
     * @param id the id of Gallery. It is an int number
     * @return a Gallery of <code>Gallery</code> objects. It is a
     * <code>entity.Gallery</code> object
     */
    @Override
    public Gallery getGalleryById(int id) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT top 1 * from galery where ID = ?";
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Gallery galery = new Gallery();
                galery.setId(rs.getInt("ID"));
                galery.setTitle(rs.getString("title"));
                galery.setDescription(rs.getString("description"));
                galery.setName(rs.getString("name"));
                return galery;
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return null;
    }

    /**
     * Find the list Gallery. All the Gallery matched with id order ascending,
     * between pageSize*(pageIndex - 1) + 1 and pageSize * pageIndex will be
     * returned. The result contain a list of <code>entity.Gallery</code>
     * objects with id, title, description, name
     *
     * @param pageIndex the index of page. It is an int number
     * @param pageSize the max number of Gallery in each page. It is an int
     * number
     * @return a list of <code>Gallery</code> objects. It is a
     * <code>java.util.List</code> object
     * @throws java.lang.Exception
     */
    @Override
    public List<Gallery> getListGalleryWithPaging(int pageIndex, int pageSize) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Gallery> list = new ArrayList<>();
        int size = countNumberOfGallery();
        try {
            String sql = "select * from ( select ROW_NUMBER() over (order by id ASC) as rn , * from  galery )"
                    + " as b where rn between ((?*?) - ?)and (?*?)";
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, pageSize);
            ps.setInt(2, pageIndex);
            ps.setInt(3, pageSize - 1);
            ps.setInt(4, pageSize);
            ps.setInt(5, pageIndex);
            rs = ps.executeQuery();
            int count = 0;
            while (rs.next()) {
                Gallery gallery = new Gallery();
                gallery.setId(rs.getInt("ID"));
                gallery.setTitle(rs.getString("title"));
                gallery.setDescription(rs.getString("description"));
                gallery.setName(rs.getString("name"));
                list.add(gallery);
            }
            return list;
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
    }

    /**
     * Find the number of Contact in database. Number of Gallery will be return.
     * The result contain an int number
     *
     * @return an int number
     * @throws java.lang.Exception
     */
    @Override
    public int countNumberOfGallery() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT count(*) from galery";
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

}
