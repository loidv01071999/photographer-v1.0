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
import dao.ContactDAO;
import entity.Contact;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * This class has methods for retrieving data from contact table in database.
 * The method will return an object of the class
 * <code>java.lang.Exception</code> when there is any error querying the data.
 * <p>
 * Bugs: None
 *
 * @author KhaTran
 */
public class ContactDAOImpl extends DBContext implements ContactDAO {

    /**
     * Find the Contact. The first Contact in table Contact will be return. The
     * result contain a Contact of <code>entity.Contact</code> objects with
     * telephone, email, about, address, city, country, mapUrl, mainImage.
     *
     * @return a contact of <code>Contact</code> objects. It is a
     * <code>entity.Contact</code> object
     * @throws java.lang.Exception
     */
    @Override
    public Contact getContact() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT top 1 * from contact";
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Contact contact = new Contact();
                contact.setTelephone(rs.getString("telephone"));
                contact.setEmail(rs.getString("email"));
                contact.setFacebookUrl(rs.getString("face_url"));
                contact.setTwitterUrl(rs.getString("twitter_url"));
                contact.setGoogleUrl(rs.getString("google_url"));
                contact.setAbout(rs.getString("about"));
                contact.setAddress(rs.getString("address"));
                contact.setCity(rs.getString("city"));
                contact.setCountry(rs.getString("country"));
                contact.setMapUrl(rs.getString("map_url"));
                contact.setMainImage(rs.getString("image_main"));
                contact.setFacebookIcon(rs.getString("icon_face"));
                contact.setTwitterIcon(rs.getString("icon_twitter"));
                contact.setGoogleIcon(rs.getString("icon_google"));
                return contact;
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
     * Find the Contact. The result contain a Contact of
     * <code>entity.Contact</code> objects with facebookUrl, twitterUrl,
     * googleUrl mainImage, facebookIcon, twitterIcon, googleIcon .
     *
     * @return a contact of <code>Contact</code> objects. It is a
     * <code>entity.Contact</code> object
     * @throws java.lang.Exception
     */
    @Override
    public Contact getSocialContact() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT top 1 * from contact";
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Contact contact = new Contact();
                contact.setFacebookUrl(rs.getString("face_url"));
                contact.setTwitterUrl(rs.getString("twitter_url"));
                contact.setGoogleUrl(rs.getString("google_url"));
                contact.setMainImage(rs.getString("image_main"));
                contact.setFacebookIcon(rs.getString("icon_face"));
                contact.setTwitterIcon(rs.getString("icon_twitter"));
                contact.setGoogleIcon(rs.getString("icon_google"));
                return contact;
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
