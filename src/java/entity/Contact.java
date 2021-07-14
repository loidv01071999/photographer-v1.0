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
public class Contact {

    private String telephone;
    private String email;
    private String facebookUrl;
    private String twitterUrl;
    private String googleUrl;
    private String about;
    private String address;
    private String city;
    private String country;
    private String mapUrl;
    private String mainImage;
    private String facebookIcon;
    private String twitterIcon;
    private String googleIcon;

    /**
     * Used to initialize Contact with no parameter
     */
    public Contact() {
    }

    /**
     * Used to initialize Contact with its properties as parameters
     *
     * @param telephone the telephone of Contact. It is a
     * <code>java.lang.String</code> object
     * @param email the email of Contact. It is a <code>java.lang.String</code>
     * object
     * @param facebookUrl the Facebook's URL of Contact. It is a
     * <code>java.lang.String</code> object
     * @param twitterUrl the Twitter's URL of Contact. It is a
     * <code>java.lang.String</code> object
     * @param googleUrl the Google's URL of Contact. It is a
     * <code>java.lang.String</code> object
     * @param about the about of Contact. It is a <code>java.lang.String</code>
     * object
     * @param address the address of Contact. It is a
     * <code>java.lang.String</code> object
     * @param city the city of Contact. It is a <code>java.lang.String</code>
     * object
     * @param country the country of Contact. It is a
     * <code>java.lang.String</code> object
     * @param mapUrl the Map's URL of Contact. It is a
     * <code>java.lang.String</code> object
     * @param mainImage the main image of Contact. It is a
     * <code>java.lang.String</code> object
     * @param facebookIcon the Facebook's icon of Contact. It is a
     * <code>java.lang.String</code> object
     * @param twitterIcon the Twitter's icon of Contact. It is a
     * <code>java.lang.String</code> object
     * @param googleIcon the Google's icon of Contact. It is a
     * <code>java.lang.String</code> object
     */
    public Contact(String telephone, String email, String facebookUrl,
            String twitterUrl, String googleUrl, String about, String address,
            String city, String country, String mapUrl, String mainImage,
            String facebookIcon, String twitterIcon, String googleIcon) {
        this.telephone = telephone;
        this.email = email;
        this.facebookUrl = facebookUrl;
        this.twitterUrl = twitterUrl;
        this.googleUrl = googleUrl;
        this.about = about;
        this.address = address;
        this.city = city;
        this.country = country;
        this.mapUrl = mapUrl;
        this.mainImage = mainImage;
        this.facebookIcon = facebookIcon;
        this.twitterIcon = twitterIcon;
        this.googleIcon = googleIcon;
    }

    /**
     * Get value from telephone attribute of <code>Contact</code> object
     *
     * @return telephone of <code>Contact</code> object. It is a
     * <code>java.lang.String</code> object
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * Set new value for telephone attribute of <code>Contact</code> object
     *
     * @param telephone the telephone of Contact. It is a
     * <code>java.lang.String</code> object
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * Get value from email attribute of <code>Contact</code> object
     *
     * @return email of <code>Contact</code> object. It is a
     * <code>java.lang.String</code> object
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set new value for email attribute of <code>Contact</code> object
     *
     * @param email the email of Contact. It is a <code>java.lang.String</code>
     * object
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get value from facebookUrl attribute of <code>Contact</code> object
     *
     * @return facebookUrl of <code>Contact</code> object. It is a
     * <code>java.lang.String</code> object
     */
    public String getFacebookUrl() {
        return facebookUrl;
    }

    /**
     * Set new value for facebookUrl attribute of <code>Contact</code> object
     *
     * @param facebookUrl the Facebook's URL of Contact. It is a
     * <code>java.lang.String</code> object
     */
    public void setFacebookUrl(String facebookUrl) {
        this.facebookUrl = facebookUrl;
    }

    /**
     * Get value from twitterUrl attribute of <code>Contact</code> object
     *
     * @return twitterUrl of <code>Contact</code> objects. It is a
     * <code>java.lang.String</code> object
     */
    public String getTwitterUrl() {
        return twitterUrl;
    }

    /**
     * Set new value for twitterUrl attribute of <code>Contact</code> object
     *
     * @param twitterUrl the Twitter's URL of Contact. It is a
     * <code>java.lang.String</code> object
     */
    public void setTwitterUrl(String twitterUrl) {
        this.twitterUrl = twitterUrl;
    }

    /**
     * Get value from googleUrl attribute of <code>Contact</code> object
     *
     * @return googleUrl of <code>Contact</code> object. It is a
     * <code>java.lang.String</code> object
     */
    public String getGoogleUrl() {
        return googleUrl;
    }

    /**
     * Set new value for googleUrl attribute of <code>Contact</code> object
     *
     * @param googleUrl the Google's URL of Contact. It is a
     * <code>java.lang.String</code> object
     */
    public void setGoogleUrl(String googleUrl) {
        this.googleUrl = googleUrl;
    }

    /**
     * Get value from about attribute of <code>Contact</code> object
     *
     * @return about of <code>Contact</code> object. It is a
     * <code>java.lang.String</code> object
     */
    public String getAbout() {
        return about;
    }

    /**
     * Set new value for about attribute of <code>Contact</code> object
     *
     * @param about the about of Contact. It is a <code>java.lang.String</code>
     * object
     */
    public void setAbout(String about) {
        this.about = about;
    }

    /**
     * Get value from address attribute of <code>Contact</code> object
     *
     * @return address of <code>Contact</code> object. It is a
     * <code>java.lang.String</code> object
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set new value for address attribute of <code>Contact</code> object
     *
     * @param address the address of Contact. It is a
     * <code>java.lang.String</code> object
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Get value from city attribute of <code>Contact</code> object
     *
     * @return city of <code>Contact</code> object. It is a
     * <code>java.lang.String</code> object
     */
    public String getCity() {
        return city;
    }

    /**
     * Set new value for city attribute of <code>Contact</code> object
     *
     * @param city the city of Contact. It is a <code>java.lang.String</code>
     * object
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Get value from country attribute of <code>Contact</code> object
     *
     * @return country of <code>Contact</code> object. It is a
     * <code>java.lang.String</code> object
     */
    public String getCountry() {
        return country;
    }

    /**
     * Set new value for country attribute of <code>Contact</code> object
     *
     * @param country the country of Contact. It is a
     * <code>java.lang.String</code> object
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Get value from mapUrl attribute of <code>Contact</code> object
     *
     * @return mapUrl of <code>Contact</code> object. It is a
     * <code>java.lang.String</code> object
     */
    public String getMapUrl() {
        return mapUrl;
    }

    /**
     * Set new value for mapUrl attribute of <code>Contact</code> object
     *
     * @param mapUrl the Map's URL of Contact. It is a
     * <code>java.lang.String</code> object
     */
    public void setMapUrl(String mapUrl) {
        this.mapUrl = mapUrl;
    }

    /**
     * Get value from mainImage attribute of <code>Contact</code> object
     *
     * @return mainImage of <code>Contact</code> object. It is a
     * <code>java.lang.String</code> object
     */
    public String getMainImage() {
        return mainImage;
    }

    /**
     * Set new value for mainImage attribute of <code>Contact</code> object
     *
     * @param mainImage the main image of Contact. It is a
     * <code>java.lang.String</code> object
     */
    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    /**
     * Get value from facebookIcon attribute of <code>Contact</code> object
     *
     * @return facebookIcon of <code>Contact</code> object. It is a
     * <code>java.lang.String</code> object
     */
    public String getFacebookIcon() {
        return facebookIcon;
    }

    /**
     * Set new value for facebookIcon attribute of <code>Contact</code> object
     *
     * @param facebookIcon the Facebook's icon of Contact. It is a
     * <code>java.lang.String</code> object
     */
    public void setFacebookIcon(String facebookIcon) {
        this.facebookIcon = facebookIcon;
    }

    /**
     * Get value from twitterIcon attribute of <code>Contact</code> object
     *
     * @return twitterIcon of <code>Contact</code> object. It is a
     * <code>java.lang.String</code> object
     */
    public String getTwitterIcon() {
        return twitterIcon;
    }

    /**
     * Set new value for twitterIcon attribute of <code>Contact</code> object
     *
     * @param twitterIcon the Twitter's icon of Contact. It is a
     * <code>java.lang.String</code> object
     */
    public void setTwitterIcon(String twitterIcon) {
        this.twitterIcon = twitterIcon;
    }

    /**
     * Get value from googleIcon attribute of <code>Contact</code> object
     *
     * @return googleIcon of <code>Contact</code> object. It is a
     * <code>java.lang.String</code> object
     */
    public String getGoogleIcon() {
        return googleIcon;
    }

    /**
     * Set new value for googleIcon attribute of <code>Contact</code> object
     *
     * @param googleIcon the Google's icon of Contact. It is a
     * <code>java.lang.String</code> object
     */
    public void setGoogleIcon(String googleIcon) {
        this.googleIcon = googleIcon;
    }

}
