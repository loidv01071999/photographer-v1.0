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

/**
 * This class declares method to get data from View table in database
 * <p>
 * Bugs: None
 *
 * @author KhaTran
 */
public interface PageviewDAO {

    /**
     * Find the number of views page from database. The result contain an int
     * number
     *
     * @return an int number
     * @throws java.lang.Exception
     */
    public int getNumberOfViewsPage() throws Exception;

    /**
     * Update the number of views page in database. The number of views page
     * will be increased by 1 every time accessed the page
     *
     * @throws java.lang.Exception
     */
    public void updateNumberOfViewsPage() throws Exception;
}
