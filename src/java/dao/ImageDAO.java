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
package dao;

import entity.Image;
import java.util.List;

/**
 * This class declares method to get data from Image table in database
 * <p>
 * Bugs: None
 *
 * @author KhaTran
 */
public interface ImageDAO {

    /**
     * Find the number of Image. All the Image matches has Gallery ID matches
     * with searched id will be returned. The result contain an int number.
     *
     * @param id the id of a Gallery. It is an int number
     * @return an int number <code>entity.Digital</code> object
     * @throws java.lang.Exception
     */
    public int countImage(int id) throws Exception;

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
    public String getImageByGalleryID(int id) throws Exception;

    /**
     * Find the list Image by Gallery ID. All the Image matched with id order
     * ascending, Gallery ID matched with searched ID and between
     * pageSize*(pageIndex - 1) + 1 and pageSize * pageIndex will be returned.
     * The result contain a list of <code>entity.Image</code> objects
     *
     * @param galleryID the id of a Gallery. It is an int number
     * @param pageIndex the index of page. It is an int number
     * @param pageSize the max number of Gallery in each page. It is an int
     * number
     * @return a list of <code>Image</code> objects. It is a
     * <code>java.util.List</code> object
     * @throws java.lang.Exception
     */
    public List<Image> getListImageWithPaging(int galleryID, int pageIndex, int pageSize)
            throws Exception;

    /**
     * Find the Image by id. The Image has id matches with searched Image ID and
     * Gallery ID will be returned. The result contain a Image of
     * <code>entity.Image</code> objects
     *
     * @param imageId the id of Image. It is an int number
     * @param galleryId the id of Gallery. It is an int number
     * @return a Image of <code>Image</code> objects. It is a
     * <code>entity.Image</code> object
     * @throws java.lang.Exception
     */
    public Image getImageByID(int imageId, int galleryId) throws Exception;

    /**
     * Find the Image by Gallery ID. The first Image has Gallery id matches with
     * searched id will be returned. The result contains a image of
     * <code>entity.Image</code> objects
     *
     * @param galleryId the id of Gallery. It is an int number
     * @return a Image of <code>Image</code> objects. It is a
     * <code>entity.Image</code> object
     * @throws java.lang.Exception
     */
    public Image getTop1ImageGallery(int galleryId) throws Exception;
}
