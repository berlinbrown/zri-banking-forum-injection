/**
 * Copyright berlin
 */
package org.zberlin.zri.bank;

import org.zberlin.zri.bank.db.BankDBAccess;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Pure servlet, output the data.
 */
@WebServlet(name = "AdminServlet", urlPatterns = "/admin-servlet")
public class AdminServlet extends HttpServlet {

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

        PrintWriter out;
        response.setContentType("text/html");
        out = response.getWriter();

        // Connect to database
        final BankDBAccess db = new BankDBAccess();

        db.readRecords("thesql", BankDBAccess.SCENARIO1_ID_READ_ALL_USERS,
                amount, null, null, null, null, null, null);

        out.println("<HTML><HEAD><TITLE>Banking Admin Servlet</TITLE></HEAD><BODY BGCOLOR=\"#FBFFEE\">");
        out.println("<h1>Banking Admin Servlet</h1>");
        out.println("<h2>Requested URL:</h2>");
        out.println("<TABLE Border=\"2\" WIDTH=\"68%\" BGCOLOR=\"#FDDBFF\">");
        out.println("<tr><td>" + request.getRequestURL().toString() + "</td></tr></table><BR><BR>");

        out.println("<h2>Admin Servlet Info:</h2>");
        out.println("<TABLE Border=\"2\" WIDTH=\"68%\" BGCOLOR=\"#FDDBFF\">");
        out.println("<tr><td>" + getServletConfig().getServletName() + "</td></tr></table><BR><BR>");

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
