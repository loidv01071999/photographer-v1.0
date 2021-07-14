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

import dao.ImageDAO;
import dao.impl.ImageDAOImpl;

/**
 * This class contain entities of Image Contain methods which use to get and set
 * all of attributes 2 Constructor with parameter and no parameter
 * <p>
 * Bugs: None
 *
 * @author KhaTran
 */
public class Gallery {

    private int id;
    private String title;
    private String description;
    private String name;
    private String image;

    /**
     * Used to initialize Gallery with no parameter
     */
    public Gallery() {
    }

    /**
     * Used to initialize Gallery with its properties as parameters
     *
     * @param id the id of Gallery. It is an int number
     * @param title the title of Gallery. It is a <code>java.lang.String</code>
     * object
     * @param description the description of Gallery. It is a
     * <code>java.lang.String</code> object
     * @param name the name of Gallery. It is a <code>java.lang.String</code>
     * object
     * @param image the image of Gallery. It is a <code>java.lang.String</code>
     * object
     */
    public Gallery(int id, String title, String description, String name, String image) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.name = name;
        this.image = image;
    }

    /**
     * Get value from id attribute of <code>Gallery</code> object
     *
     * @return id of <code>Gallery</code> objects. It is an int number
     */
    public int getId() {
        return id;
    }

    /**
     * Set new value for id attribute of <code>Gallery</code> object
     *
     * @param id the id of Gallery. It is an int number
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get value from title attribute of <code>Gallery</code> object
     *
     * @return title of <code>Gallery</code> object. It is a
     * <code>java.lang.String</code> object
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set new value for title attribute of <code>Gallery</code> object
     *
     * @param title the title of Gallery. It is a <code>java.lang.String</code>
     * object
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get value from description attribute of <code>Gallery</code> object
     *
     * @return description of <code>Gallery</code> object. It is a
     * <code>java.lang.String</code> object
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set new value for description attribute of <code>Gallery</code> object
     *
     * @param description the description of Gallery. It is a
     * <code>java.lang.String</code> object
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get value from name attribute of <code>Gallery</code> object
     *
     * @return name of <code>Gallery</code> object. It is a
     * <code>java.lang.String</code> object
     */
    public String getName() {
        return name;
    }

    /**
     * Set new value for name attribute of <code>Gallery</code> object
     *
     * @param name the name of Gallery. It is a <code>java.lang.String</code>
     * object
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get value of image attribute from PhotoDAOImpl
     *
     * @return image of <code>Gallery</code> object. It is a
     * <code>java.lang.String</code> object
     */
    public String getImage() throws Exception {
        ImageDAO imageDAO = new ImageDAOImpl();
        return imageDAO.getImageByGalleryID(id);
    }

    /**
     * Set new value for image attribute of <code>Gallery</code> object
     *
     * @param image the image of Gallery. It is a <code>java.lang.String</code>
     * object
     */
    public void setImage(String image) {
        this.image = image;
    }

}
