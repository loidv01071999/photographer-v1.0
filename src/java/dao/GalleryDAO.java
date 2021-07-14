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

import entity.Gallery;
import java.util.List;

/**
 * This class declares method to get data from Gallery table in database
 * <p>
 * Bugs: None
 *
 * @author KhaTran
 */
public interface GalleryDAO {

    /**
     * Find the list Gallery in the top "number". The result contain a list of
     * <code>entity.Gallery</code> objects
     *
     * @param number the number of Gallery. It is an int number
     * @return a list of <code>Gallery</code> objects. It is a
     * <code>java.util.List</code> object
     * @throws java.lang.Exception
     */
    public List<Gallery> getTopGallery(int number) throws Exception;

    /**
     * Find the Gallery by id. The Gallery has id matches with searched id will
     * be returned. The result contain a Gallery of <code>entity.Gallery</code>
     * objects
     *
     * @param id the id of Gallery. It is an int number
     * @return a Gallery of <code>Gallery</code> objects. It is a
     * <code>entity.Gallery</code> object
     * @throws java.lang.Exception
     */
    public Gallery getGalleryById(int id) throws Exception;

    /**
     * Find the list Gallery. All the Gallery matched with id order ascending,
     * between pageSize*(pageIndex - 1) + 1 and pageSize * pageIndex will be
     * returned. The result contain a list of <code>entity.Gallery</code>
     * objects
     *
     * @param pageIndex the index of page. It is an int number
     * @param pageSize the max number of Gallery in each page. It is an int
     * number
     * @return a list of <code>Gallery</code> objects. It is a
     * <code>java.util.List</code> object
     * @throws java.lang.Exception
     */
    public List<Gallery> getListGalleryWithPaging(int pageIndex, int pageSize)
            throws Exception;

    /**
     * Find the number of Contact in database. The result contain an int number
     *
     * @return an int number
     * @throws java.lang.Exception
     */
    public int countNumberOfGallery() throws Exception;
}
