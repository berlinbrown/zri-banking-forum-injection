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

@WebServlet(name = "BankServlet", urlPatterns = "/bank-home-servlet")
public class BankServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        final HttpSession session = request.getSession(false);
        if (session == null) {
            throw new RuntimeException("Invalid User Session");
        }

        final String loggedIn =  (String) session.getAttribute("REAL_LOGGED_IN");
        if (loggedIn == null) {
            throw new RuntimeException("Invalid User Session");
        }

        // If amount is not null
        // SELECT * FROM products WHERE category = 'Gifts'--' AND released = 1
        // Select * from account where type = xxxx '--' AND released = 1

        final String amount = request.getParameter("amount");
        System.out.println("Sending this amount and part of query ...[[ " + amount);

        // Default is read accounts
        final String action = request.getParameter("action");
        final String accountType = request.getParameter("accounttype");
        final String accountFrom = request.getParameter("accountnumber");
        final String transferAmount = request.getParameter("transferamount");

        final String accountTypeTo = request.getParameter("accounttypeto");
        final String accountNumberTo = request.getParameter("accountnumberto");

        final Integer transferAmountInt = (transferAmount == null) ? 0 : Integer.parseInt(transferAmount);

        final String userId =  (String) session.getAttribute("REAL_LOGGED_IN_USER");
        System.out.println(">>> User: "+userId);

        System.out.println("Action ...[[ " + action + " : accountType: " + accountType);
        System.out.println("TransferAmount ...[[ " + transferAmountInt);
        System.out.println("To ...[[ " + accountTypeTo + " : accountType: " + accountNumberTo);

        if (userId == null) {
            throw new RuntimeException("Invalid Session Credentials");
        }

        // Connect to database
        final BankDBAccess db = new BankDBAccess();
        List<List<String>> dataResponse;
        System.out.println(">>> Sending action: " + action);

        System.out.println("Moving into read records ... ");
        if ("DEFAULT".equalsIgnoreCase(action)) {

            dataResponse = db.readRecords("DefaultBankAccounts",
                    BankDBAccess.SCENARIO4_ID_READ_BANK_ACCOUNTS,
                    userId, action, accountType, transferAmount, null, null, null);

        } else if ("TRANSFER".equalsIgnoreCase(action)) {
            dataResponse = db.readRecords("TransferBank",
                        BankDBAccess.SCENARIO5_ID_BANK_TRANSFER,
                        userId, action, accountType, transferAmount, accountFrom, accountTypeTo, accountNumberTo);

            dataResponse = db.readRecords("DefaultBankAccounts",
                    BankDBAccess.SCENARIO4_ID_READ_BANK_ACCOUNTS,
                    userId, action, accountType, transferAmount,
                    null, null, null);

        } else {
            dataResponse = db.readRecords("DefaultBankAccounts",
                    BankDBAccess.SCENARIO4_ID_READ_BANK_ACCOUNTS,
                    userId, action, accountType, transferAmount,
                    null, null, null);
        }
        System.out.println("Moving into print response ... ");
        System.out.println("Has size: " + dataResponse.size());

        for (final List<String> cols : dataResponse) {
            System.out.println("For Size: " + cols.size());
        }
        request.setAttribute("BANK_RESULT_SET", dataResponse);
        System.out.println("Forwarding to: /bankhome.jsp - render home");
        request.getRequestDispatcher("/bankhome.jsp").forward(request, response);

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
