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
import java.util.List;

/**
 * Pure servlet, output the data.
 */
@WebServlet(name = "PostLoginAppsServlet", urlPatterns = "/post-login-servlet")
public class PostLoginAppsServlet extends HttpServlet {

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

        final String userId = request.getParameter("userid");
        final String password = request.getParameter("password");

        System.out.println("UserId ...[[ " + userId + " : password: " + password);

        if (userId == null || password == null) {
            throw new RuntimeException("Invalid Credentials");
        }

        // Connect to database
        final BankDBAccess db = new BankDBAccess();

        final List<List<String>> dataResponse = db.readRecords("thesql",
                BankDBAccess.SCENARIO3_ID_READ_LOGIN_CHECK,
                userId, password, null, null, null, null, null);

        System.out.println(dataResponse.size());

        session.setAttribute("REAL_LOGGED_IN", "true");
        session.setAttribute("REAL_LOGGED_MESSAGE", "You're winner, you have logged in successfully!");
        session.setAttribute("REAL_LOGGED_IN_USER", userId);

        request.setAttribute("USER_RESULT_SET", dataResponse);

        System.out.println("Forwarding to: /apps.jsp - successful login");
        request.getRequestDispatcher("/apps.jsp").forward(request, response);

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
