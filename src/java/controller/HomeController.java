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
import dao.impl.ContactDAOImpl;
import dao.impl.GalleryDAOImpl;
import entity.Gallery;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class contains a method that calls <code>GalleryDAOImpl</code> to get
 * top 3 Gallery, list paging Gallery , Contact ,a total of the gallery to the
 * <code>HomePage.jsp</code>. When system occurs any error or an unannounced
 * error, the class will redirect to <code>Eror.jsp</code>.
 * <p>
 * Bugs: Error message isn't correct Status : fixed
 *
 * @author KhaTran
 */
public class HomeController extends HttpServlet {

    /**
     * This method calls <code>GalleryDAOImpl</code> to get top 3 gallery, total
     * of galleries ,list paging Image and Contact, a total of gallery , get
     * parameter index from the <code>HTTP</code> request and find maxPage then
     * forward to <code>HomePage.jsp</code>. When system is error or an
     * unannounced error, the class will redirect to an error page with error
     * message show on that pages.
     *
     * @param request stores attributes : top3Gallery ,
     * listPagingGallery,maxPage,index,contact,error to send to
     * <code>HomePage.jsp</code> . It is a
     * <code>javax.servlet.http.HttpServletRequest</code> object
     * @param response is used to encapsulate the data to send back to the
     * client's web browser. It is a
     * <code>javax.servlet.http.HttpServletResponse</code> object
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            GalleryDAO galleryDAO = new GalleryDAOImpl();
            ContactDAO contactDAO = new ContactDAOImpl();
//            request.getSession().setMaxInactiveInterval(300);
            // number of Gallery in each page
            int pageSize = 3;
            String pageIndex = request.getParameter("index");
            int index = 0;
            // check index page
            if (pageIndex != null) {
                index = Integer.parseInt(pageIndex);
            } else {
                index = 1;
            }
            // Count total result
            int totalRecord = galleryDAO.countNumberOfGallery();
            // No result
            if (totalRecord <= 0) {
                request.setAttribute("errorMessage", "No result!!");
            }
            int maxPage = totalRecord / pageSize;
            // create one more page to contain Gallery
            if ((totalRecord % pageSize) != 0) {
                maxPage++;
            }

            //get list galery with paging
            List<Gallery> listGallery = galleryDAO.getListGalleryWithPaging(index, pageSize);
            // set list gallery
            request.setAttribute("listGalery", listGallery);
            // set index of page
            request.setAttribute("index", index);
            // set number of page
            request.setAttribute("maxPage", maxPage);
            // set number of Gallery
            request.setAttribute("totalRecord", totalRecord);
            // set top 3 gallery
            request.setAttribute("top3", galleryDAO.getTopGallery(3));
            // set contact infor
            request.setAttribute("contact", contactDAO.getSocialContact());
            request.setAttribute("active", "0");
            request.getRequestDispatcher("HomePage.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("errorMessage", ex.getMessage());
            //when system is errors or unknown errors, Error page will be display     
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
        processRequest(request, response);
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
        processRequest(request, response);
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
