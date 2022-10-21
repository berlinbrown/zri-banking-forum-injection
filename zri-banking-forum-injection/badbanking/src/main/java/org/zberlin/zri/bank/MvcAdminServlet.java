/**
 * Copyright berlin
 */
package org.zberlin.zri.bank;

import org.zberlin.zri.bank.db.BankDBAccess;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Pure servlet, output the data.
 */
@WebServlet(name = "MvcAdminServlet", urlPatterns = "/mvc-admin-servlet")
public class MvcAdminServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        final HttpSession session = request.getSession();
        session.setAttribute("LOGGED_IN", "true");

        // If amount is not null
        // SELECT * FROM products WHERE category = 'Gifts'--' AND released = 1
        // Select * from account where type = xxxx '--' AND released = 1

        final String amount = request.getParameter("amount");
        System.out.println("Sending this amount and part of query ...[[ " + amount);

        // Connect to database
        final BankDBAccess db = new BankDBAccess();

        List<List<String>> dataResponse = db.readRecords("thesql", BankDBAccess.SCENARIO1_ID_READ_ALL_USERS,
                amount, null, null, null, null, null, null);

        System.out.println(dataResponse.size());

        request.setAttribute("USER_RESULT_SET", dataResponse);
        System.out.println("Forwarding to: /superadmin.jsp");
        request.getRequestDispatcher("/superadmin.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        this.doPost(request, response);
    }


    public void init() throws ServletException {
        // Initialization code like set up database etc....
    }

    public void destroy() {
        //
    }


}
