/*
Copyright (c) 2021
*/
package org.zberlin.zri.bank.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Connect read information and disconnect.
 */
public class BankDBAccess {

    private static final String DRIVER = "com.mysql.jdbc.Driver";

    private static final String usr = "botlistfriend";

    private static final String pwd = "b80t1st";

    private static final String url = "jdbc:mysql://localhost:3306/zribankdb_development?serverTimezone=UTC";

    public static final String SCENARIO1_SQL_READ_ALL_USERS = "select username from users";

    public static final String  SCENARIO3_SQL_PASSWORD_CHECK = "select username, password from users where username = '";

    // The comment is in play and the single quote is ignored, nullifying the queryå
    // SELECT * FROM products WHERE category = 'Gifts'--' AND released = 1
    // SELECT * FROM products WHERE category = 'Gifts${param} AND released = 1
    public static final String SCENARIO2_SQL_READ_ALL_USERSA = "select username from users where username = '";
    public static final String SCENARIO2_SQL_READ_ALL_USERSB = " OR username like 'amy%' ";

    public static final int SCENARIO1_ID_READ_ALL_USERS = 1;

    public static final int SCENARIO2_ID_READ_FILTER_USERS = 2;

    public static final int SCENARIO3_ID_READ_LOGIN_CHECK = 3;

    public static final int SCENARIO4_ID_READ_BANK_ACCOUNTS = 4;

    public static final int SCENARIO5_ID_BANK_TRANSFER = 5;

    public static final int SCENARIO6_ID_FORUM = 6;

    /**
     * Connect read information and disconnect.
     *
     * @param sqlName
     */
    public List<List<String>> readRecords(final String sqlName, final int scenario,
                                          final String misc1, final String misc2, final String misc3,
                                          final String misc4, final String misc5, final String misc6,
                                          final String misc7) {

        Connection conn = null;
        Statement ps = null;
        ResultSet rs = null;

        List<List<String>> vec = null;
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
        try {
            System.out.println(">> ReadRecords - sys prop token : url: " + url + " ; user: " + usr);

            System.out.println("Loading SCENARIO: "+scenario);

            conn = DriverManager.getConnection(url, usr, pwd);
            final Statement stmt = conn.createStatement();
            String badQuery = SCENARIO1_SQL_READ_ALL_USERS;
            //badQuery = SCENARIO2_SQL_READ_ALL_USERSA + misc1 + "'" +
            //        SCENARIO2_SQL_READ_ALL_USERSB;

            if (scenario == SCENARIO3_ID_READ_LOGIN_CHECK) {
                // This is bad!!
                badQuery = SCENARIO3_SQL_PASSWORD_CHECK + misc1 + "' AND password = '" + misc2 + "'";
                System.out.println(badQuery);
                rs = stmt.executeQuery(badQuery);
                if (rs != null) {
                    System.out.println("Entering password check");
                    vec = this.readPasswordCheck(rs, misc1, misc2);
                    System.out.println("Result set after reading configuration - sqlName:" + sqlName + " ; res:");
                    return vec;
                } else {
                    System.out.println("Invalid result set for " + sqlName);
                }

            } if (scenario == SCENARIO4_ID_READ_BANK_ACCOUNTS) {
                System.out.println("Scenario 4 - accounts");

                // This is bad code
                badQuery = "select user_name, account, account_type, balance, location, title, ts from zri_bank_accounts where user_name = '"
                        +misc1+"'";

                System.out.println(badQuery);
                rs = stmt.executeQuery(badQuery);
                if (rs != null) {
                    System.out.println(">>> Scenario 4 - get and read bank accounts");
                    vec = this.readAccounts(rs);
                    System.out.println("Result set after reading configuration - sqlName:" + sqlName + " ; res:");
                    return vec;
                } else {
                    System.out.println("Invalid result set for " + sqlName);
                }

                System.out.println("<<<< Exiting from: "+scenario);

            } else if (scenario == SCENARIO5_ID_BANK_TRANSFER) {
                // This is bad code
                //badQuery = "select user_name, account, account_type, balance, location, title, ts from zri_bank_accounts where user_name = '"
                //        +misc1+"'";
                String action = misc2;
                String accountType = misc6;
                String amt = misc4;
                String userId = misc1;
                String accountNumberTo = misc7;

                // Don't need from data
                System.out.println(">>> scenario database: " + action);
                badQuery = "update zri_bank_accounts set balance = '" + amt + "' where user_name = '" +
                        userId + "' and account_type= '" + accountType +
                        "' and account = '" + accountNumberTo + "'  ";

                System.out.println(badQuery);
                int rsx = stmt.executeUpdate(badQuery);
                System.out.println(rsx);
                System.out.println("Result set after reading configuration - sqlName:" + sqlName + " ; res:");
                final List<List<String>> fakeRes = new ArrayList<>();
                return fakeRes;

            } else if (scenario == SCENARIO6_ID_FORUM) {
                System.out.println("Scenario 6 - forums");

                // This is bad code
                String action = misc2;
                String accountType = misc3;

                if (action != null && accountType != null) {
                    badQuery = "select user_name, message, category, email, location, title, ts from zri_user_forum where user_name = '"
                            + misc1 + "' and location='"+ accountType + "'  ";
                } else {
                    badQuery = "select user_name, message, category, email, location, title, ts from zri_user_forum where user_name = '"
                            + misc1 + "'";
                }

                System.out.println(badQuery);
                rs = stmt.executeQuery(badQuery);
                if (rs != null) {
                    System.out.println(">>> Scenario 6");
                    vec = this.readForums(rs);
                    System.out.println("Result set after reading configuration - sqlName:" + sqlName + " ; res:");
                    return vec;
                } else {
                    System.out.println("Invalid result set for " + sqlName);
                }

                System.out.println("<<<< Exiting from: "+scenario);

            } else {
                badQuery = SCENARIO1_SQL_READ_ALL_USERS;
                System.out.println(badQuery);
                rs = stmt.executeQuery(badQuery);
                if (rs != null) {
                    vec = this.readAllUsers(rs);
                    System.out.println("Result set after reading configuration - sqlName:" + sqlName + " ; res:");
                } else {
                    System.out.println("Invalid result set for " + sqlName);
                }
            }
        } catch (final SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    System.err.println("Error closing connector");
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    System.err.println("Error closing connector");
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.err.println("Error closing connector");
                }
            }
        }
        return vec;
    }

    /**
     * Basic list of a list, read users
     * @param rs
     * @return
     */
    public List<List<String>> readAllUsers(final ResultSet rs) {
        try {
            int count = 0;
            // Rows of columns
            final List<List<String>> response = new ArrayList<>();
            while (rs.next()) {
                final String user = rs.getString(1);
                System.out.println(user);

                final List<String> cols = new ArrayList<>();
                cols.add(user);
                response.add(cols);
                count++;
            }
            return response;
        } catch(final Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<List<String>> readAccounts(final ResultSet rs) {
        try {
            // badQuery = "select user_name, account, account_type, balance, location, title, ts from zri_bank_accounts where user_name = '"
            //                        +misc1+"'";
            int count = 0;
            // Rows of columns
            final List<List<String>> response = new ArrayList<>();
            while (rs.next()) {
                final String user = rs.getString(1);
                System.out.println(">>>> " + user);

                final String accountId = rs.getString(2);
                System.out.println(">>>> " + accountId);

                final String acctType = rs.getString(3);
                final String balance = rs.getString(4);
                final String location = rs.getString(5);
                final String title = rs.getString(6);
                final String ts = rs.getString(7);

                final List<String> cols = new ArrayList<>();
                cols.add(user); // 1
                cols.add(accountId); // 2
                cols.add(acctType); /// 3
                cols.add(balance); // 4
                cols.add(location); // 5
                cols.add(title); // 6
                cols.add(ts); // 7

                System.out.println("+++ Size columns : "+cols.size());
                response.add(cols);
                count++;
            }
            return response;
        } catch(final Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<List<String>> readForums(final ResultSet rs) {
        try {
            int count = 0;
            // Rows of columns
            final List<List<String>> response = new ArrayList<>();
            while (rs.next()) {
                final String user = rs.getString(1);
                System.out.println(">>>> " + user);

                final String message = rs.getString(2);
                System.out.println(">>>> " + message);

                final String category = rs.getString(3);
                final String email = rs.getString(4);
                final String location = rs.getString(5);
                final String title = rs.getString(6);
                final String ts = rs.getString(7);

                final List<String> cols = new ArrayList<>();
                cols.add(user); // 1
                cols.add(message); // 2
                cols.add(category); /// 3
                cols.add(email); // 4
                cols.add(location); // 5
                cols.add(title); // 6
                cols.add(ts); // 7

                System.out.println("+++ Size columns : "+cols.size());
                response.add(cols);
                count++;
            }
            return response;
        } catch(final Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<List<String>> readPasswordCheck(final ResultSet rs, final String usr, final String pwd) {
        try {
            // Rows of columns
            int count = 0;
            final List<List<String>> response = new ArrayList<>();
            while (rs.next()) {
                final String userOut = rs.getString(1);
                final String pwdOut = rs.getString(2);
                System.out.println(userOut);
                System.out.println(pwdOut);

                if (userOut == null || pwdOut == null) {
                    throw new RuntimeException("Invalid Credentials, bad entry");
                }

                if (userOut != null && !userOut.equalsIgnoreCase(usr)
                        && pwdOut != null && !pwdOut.equalsIgnoreCase(pwd)) {
                    throw new RuntimeException("Invalid Credentials, bad entry");
                }
                final List<String> cols = new ArrayList<>();
                cols.add(userOut);
                response.add(cols);
                count++;
            }
            if (count == 0) {
                throw new RuntimeException("Invalid Credentials, not found");
            }
            return response;
        } catch(final SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
