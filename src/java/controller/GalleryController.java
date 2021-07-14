/*
 * Copyright(C) 2021,  FPT University
 * J3.L.P0017
 * Photographer Online
 *
 * Record of change:
 * DATE                Version           AUTHOR            DESCRIPTION
 * 16/6/2021             1.0              KhaTran         Fix code
 * 21/6/2021             2.0              KhaTran         Fix comment
 * 01/7/2021             3.0              KhaTran         Fix comment and error message
 */
package controller;

import dao.ContactDAO;
import dao.GalleryDAO;
import dao.ImageDAO;
import dao.impl.ContactDAOImpl;
import dao.impl.GalleryDAOImpl;
import dao.impl.ImageDAOImpl;
import entity.Image;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This method gets top 3 Galleries, list images of a Gallery , Contact , a
 * total Image of gallery from <code>GalleryDAOImpl</code>, get parameter
 * galleryID , indexPage and find maxPage then forward to the
 * <code>Gallery.jsp</code>. When system has any error or an unannounced error,
 * the class will redirect to <code>Error.jsp</code> page .
 * <p>
 * Bugs: Error Message isn't correct Status : fixed
 *
 * @author KhaTran
 */
public class GalleryController extends HttpServlet {

    /**
     * This method gets top 3 Galleries, list images of a Gallery , Contact , a
     * total Image of gallery from <code>GalleryDAOImpl</code>,get parameter
     * galleryID ,indexPage and find maxPage then forward to the
     * <code>Gallery.jsp</code>. Each page has a maximum of 8 Image of Gallery
     * .When system has any error or an unannounced error, the class will
     * redirect to <code>Error.jsp</code> page
     *
     * @param request stores attribute such as : top3Gallery
     * ,listpagingImage,maxPage,index,image,contact,error to sent to the server.
     * It is a <code>javax.servlet.http.HttpServletRequest</code> object
     * @param response is used to encapsulate the data to send back to the
     * client's web browser. It is a
     * <code>javax.servlet.http.HttpServletResponse</code> object
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            GalleryDAO galleryDAO = new GalleryDAOImpl();
            ImageDAO imageDAO = new ImageDAOImpl();
            ContactDAO contactDAO = new ContactDAOImpl();
            String galleryId = request.getParameter("galeryId");
            int galleryID = 0;
            galleryID = Integer.parseInt(galleryId);
            int pageSize = 8;
            // Count total result 
            int totalRecord = imageDAO.countImage(galleryID);
            int maxPage = totalRecord / pageSize;
            // create one more page to contain Gallery
            if ((totalRecord % pageSize) != 0) {
                maxPage++;
            }
            String pageIndex = request.getParameter("index");
            int index = 0;
            // check index page
            if (pageIndex != null) {
                index = Integer.parseInt(pageIndex);
            } else {
                index = 1;
            }
            int imageId = 0;
            imageId = imageDAO.getTop1ImageGallery(galleryID).getId();
            request.setAttribute("top1Gallery", imageDAO.getImageByID(imageId, galleryID));
            //get list image with paging 
            List<Image> imageList = imageDAO.getListImageWithPaging(galleryID, index, pageSize);
            request.setAttribute("listImage", imageList);
            request.setAttribute("index", index);
            request.setAttribute("maxPage", maxPage);
            request.setAttribute("galeryID", galleryID);
            request.setAttribute("totalRecord", totalRecord);
            request.setAttribute("galery", galleryDAO.getGalleryById(galleryID));
            //get top 3 galery
            request.setAttribute("top3", galleryDAO.getTopGallery(3));
            //get contact infor
            request.setAttribute("contact", contactDAO.getSocialContact());
            request.setAttribute("active", galleryId);
            request.getRequestDispatcher("Gallery.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("errorMessage", e.getMessage());
            // when system is errors or unknown errors, Error page will be display     
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request provides important information about a client request to a
     * servlet. It is a <code>javax.servlet.http.HttpServletRequest</code>
     * object
     * @param response response respond to an HTTP Request to the browser. It is
     * a <code>javax.servlet.http.HttpServletResponse</code> object
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(GalleryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request provides important information about a client request to a
     * servlet. It is a <code>javax.servlet.http.HttpServletRequest</code>
     * object
     * @param response response respond to an HTTP Request to the browser. It is
     * a <code>javax.servlet.http.HttpServletResponse</code> object
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(GalleryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
