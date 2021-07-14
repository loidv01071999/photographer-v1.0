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
import dao.ImageDAO;
import entity.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * This class has methods for retrieving data from image table in database. The
 * method will return an object of the class <code> java.lang.Exception</code>
 * when there is any error querying the data.
 * <p>
 * Bugs: None
 *
 * @author KhaTran
 */
public class ImageDAOImpl extends DBContext implements ImageDAO {

    /**
     * Find the number of Image. All the Images have Gallery ID matches with
     * searched id will be returned. The result contain an int number.
     *
     * @param id the id of a Gallery. It is an int number
     * @return an int number <code>entity.Digital</code> object
     * @throws java.lang.Exception
     */
    @Override
    public int countImage(int id) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT count(*) from image where galery_id = ?";
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
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
     * Find the Image by Gallery ID. The first Image has Gallery ID matched with
     * searched ID will be returned. The result contains Image URL of
     * <code>java.lang.String</code> object
     *
     * @param id the id of a Gallery. It is an int number
     * @return a image URL of <code>Image</code> objects. It is a
     * <code>java.lang.String</code> object
     * @throws java.lang.Exception
     */
    @Override
    public String getImageByGalleryID(int id) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select top 1 image_url from image where galery_id = ?";
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            int count = 0;
            while (rs.next()) {
                return rs.getString(1);
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
     * Find the list Image by Gallery ID. All the Image matched with id order
     * ascending, Gallery ID matched with searched ID and between
     * pageSize*(pageIndex - 1) + 1 and pageSize * pageIndex will be returned.
     * The result contain a list of <code>entity.Image</code> objects with id,
     * galleryId, imageUrl
     *
     * @param galleryID the id of a Gallery. It is an int number
     * @param pageIndex the index of page. It is an int number
     * @param pageSize the max number of Gallery in each page. It is an int
     * number
     * @return a list of <code>Image</code> objects. It is a
     * <code>java.util.List</code> object
     * @throws java.lang.Exception
     */
    @Override
    public List<Image> getListImageWithPaging(int galleryID, int pageIndex, int pageSize) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Image> list = new ArrayList<>();
        int size = countImage(galleryID);
        try {
            String sql = "select * from ( select ROW_NUMBER() over (order by id ASC) as rn , * from  image where galery_id = ?) "
                    + "as b where rn between ((?*?) - ?)and (?*?)";
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, galleryID);
            ps.setInt(2, pageSize);
            ps.setInt(3, pageIndex);
            ps.setInt(4, pageSize - 1);
            ps.setInt(5, pageSize);
            ps.setInt(6, pageIndex);
            rs = ps.executeQuery();
            while (rs.next()) {
                Image image = new Image();
                image.setId(rs.getInt("ID"));
                image.setGalleryId(rs.getInt("galery_id"));
                image.setImageUrl(rs.getString("image_url"));
                list.add(image);
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
     * Find the Image by id. The Image has id matches with searched Image ID and
     * Gallery ID will be returned. The result contain a Image of
     * <code>entity.Image</code> objects with id, galleryId, imageUrl
     *
     * @param imageId the id of Image. It is an int number
     * @param galleryId the id of Gallery. It is an int number
     * @return a Image of <code>Image</code> objects. It is a
     * <code>entity.Image</code> object
     * @throws java.lang.Exception
     */
    @Override
    public Image getImageByID(int imageId, int galleryId) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "SELECT * from image where id = ? and galery_id = ?";
            conn = getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, imageId);
            ps.setInt(2, galleryId);
            rs = ps.executeQuery();
            while (rs.next()) {
                Image image = new Image();
                image.setId(rs.getInt("ID"));
                image.setGalleryId(rs.getInt("galery_id"));
                image.setImageUrl(rs.getString("image_url"));
                return image;
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
     * Find the Image by Gallery ID. The first Image has Gallery id matches with
     * searched id will be returned. The result contains a image of
     * <code>entity.Image</code> objects with id, galleryId, imageUrl
     *
     * @param galleryId the id of Gallery. It is an int number
     * @return a Image of <code>Image</code> objects. It is a
     * <code>entity.Image</code> object
     * @throws java.lang.Exception
     */
    @Override
    public Image getTop1ImageGallery(int galleryId) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "SELECT top 1 * from image where galery_id = ?";
            conn = getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, galleryId);
            rs = ps.executeQuery();
            while (rs.next()) {
                Image image = new Image();
                image.setId(rs.getInt("ID"));
                image.setGalleryId(rs.getInt("galery_id"));
                image.setImageUrl(rs.getString("image_url"));
                return image;
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

}
