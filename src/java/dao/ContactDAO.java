/*
 * Copyright(C) 2021,  FPT University
 * J3.L.P0017
 * Photographer Online
 *
 * Record of change:
 * DATE                Version           AUTHOR            DESCRIPTION
 * 16/6/2021             1.0              KhaTran         Fix code
 * 21/6/2021             2.0              KhaTran         Fix comment
 * 30/6/2021             3.0              KhaTran         Fix comment and code
 */
package dao;

import entity.Contact;

/**
 * This class declares method to get data from Contact table in database
 * <p>
 * Bugs: None
 *
 * @author KhaTran
 */
public interface ContactDAO {

    /**
     * Get information of contact table from database . The result contain a
     * Contact : telephone, email, about, address, city, country, mapUrl,
     * mainImage of <code>entity.Contact</code> objects
     *
     * @return a contact of <code>Contact</code> objects. It is a
     * <code>entity.Contact</code> object
     * @throws java.lang.Exception
     */
    public Contact getContact() throws Exception;

    /**
     * Get information of contact from database . The result contain a Contact :
     * facebookUrl, twitterUrl, googleUrl mainImage, facebookIcon, twitterIcon,
     * googleIcon of <code>entity.Contact</code> objects
     *
     * @return a contact of <code>Contact</code> objects. It is a
     * <code>entity.Contact</code> object
     * @throws java.lang.Exception
     */
    public Contact getSocialContact() throws Exception;
}
