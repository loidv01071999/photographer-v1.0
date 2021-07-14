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
package entity;

/**
 * This class contain entities of Image Contain methods which use to get and set
 * all of attributes 2 Constructor with parameter and no parameter
 * <p>
 * Bugs: None
 *
 * @author KhaTran
 */
public class Image {

    private int id;
    private int galleryId;
    private String imageUrl;

    /**
     * Used to initialize Image with no parameter
     */
    public Image() {
    }

    /**
     * Used to initialize Image with its properties as parameters
     *
     * @param id the id of Image. It is an int number
     * @param galleryId the id of Gallery. It is an int number
     * @param imageUrl the URL of Image. It is a <code>java.lang.String</code>
     * object
     */
    public Image(int id, int galleryId, String imageUrl) {
        this.id = id;
        this.galleryId = galleryId;
        this.imageUrl = imageUrl;
    }

    /**
     * Get value from id attribute of <code>Image</code> object
     *
     * @return id of <code>Image</code> object. It is an int number
     */
    public int getId() {
        return id;
    }

    /**
     * Set new value for id attribute of <code>Image</code> object
     *
     * @param id the id of image. It is an int number
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get value from galleryId attribute of <code>Image</code> object
     *
     * @return galleryId of <code>Image</code> object. It is an int number
     */
    public int getGalleryId() {
        return galleryId;
    }

    /**
     * Set new value for galleryId attribute of <code>Image</code> object
     *
     * @param galleryId the id of gallery. It is an int number
     */
    public void setGalleryId(int galleryId) {
        this.galleryId = galleryId;
    }

    /**
     * Get value from imageUrl attribute of <code>Image</code> object
     *
     * @return imageUrl of <code>Image</code> object. It is a
     * <code>java.lang.String</code> object
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * Set new value for imageUrl attribute of <code>Image</code> object
     *
     * @param imageUrl the URL of image. It is a <code>java.lang.String</code>
     * object
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
