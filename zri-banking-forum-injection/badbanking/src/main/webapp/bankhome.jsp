<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>ZRI and BEMORY Forum Banking and User Form Application</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/badbanking/support/w3.css">
<link rel="stylesheet" href="/badbanking/support/fonts.css">
<link rel="stylesheet" href="/badbanking/support/awesome.css>
<style>
body {font-family: "Lato", sans-serif}
.mySlides {display: none}

table, th, td {
  border: 1px solid black;
}

</style>
</head>
<body>

<!-- Navbar -->
<div class="w3-top">
  <div class="w3-bar w3-black w3-card">
    <a class="w3-bar-item w3-button w3-padding-large w3-hide-medium w3-hide-large w3-right" href="javascript:void(0)" onclick="myFunction()" title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a>
    <a href="#" class="w3-bar-item w3-button w3-padding-large">HOME</a>
    <a href="#contact" class="w3-bar-item w3-button w3-padding-large w3-hide-small">CONTACT</a>
    <div class="w3-dropdown-hover w3-hide-small">
      <button class="w3-padding-large w3-button" title="More">MORE <i class="fa fa-caret-down"></i></button>
      <div class="w3-dropdown-content w3-bar-block w3-card-4">
        <a href="#" class="w3-bar-item w3-button">Extras</a>
        <a href="#" class="w3-bar-item w3-button">Media</a>
      </div>
    </div>
    <a href="javascript:void(0)" class="w3-padding-large w3-hover-red w3-hide-small w3-right"><i class="fa fa-search"></i></a>
  </div>
</div>

<div class="w3-content" style="max-width:2000px;margin-top:46px">

    <!-- Header -->
    <header class="w3-display-container w3-content w3-wide" style="max-width:1500px;" id="home">
      <img class="w3-image" src="/badbanking/support/images/architect.jpg" alt="Architecture" width="1500" height="300">
      <div class="w3-display-middle w3-margin-top w3-center">
        <h1 class="w3-xxlarge w3-text-white"><span class="w3-padding w3-black w3-opacity-min"><b>BR</b></span> <span class="w3-hide-small w3-text-light-grey">ZRI Bank Bemory and User Form </span></h1>
      </div>
    </header>

      <div class="w3-container w3-content w3-padding-64" style="max-width:800px" id="contact">
          <h3>ZRI Bank Bemory User Form - Best Team Ever</h3>
          <br/>
          <h4>At Banking Account Listing Application Page </h4>

          <!-- Add new Content Here -->
          <a href="login.jsp">Navigate To Login</a>

          <h3>Account Information</h3>

          <table style="border: 1px; solid"  border="1" class="w3-table">
            <tr border="1">
              <th style="border: 1px; solid">User Name</th>
              <th style="border: 1px; solid">Account Number</th>
              <th style="border: 1px; solid">Account Type</th>
              <th style="border: 1px; solid">Balance</th>
              <th style="border: 1px; solid">Location</th>
              <th style="border: 1px; solid">Title</th>
              <th style="border: 1px; solid">Created On</th>
            </tr>

            <%
              final List<List<String>> dbResponse = (List<List<String>>) request.getAttribute("BANK_RESULT_SET");
              for (final List<String> cols : dbResponse) {
               System.out.println("Size of columns  .... " + cols.size());
                 final String user = cols.get(0);
                 final String accountId = cols.get(1);
                 final String acctType = cols.get(2);
                 final String balance = cols.get(3);
                 final String location = cols.get(4);
                 final String title = cols.get(5);
                 final String ts = cols.get(6);

            %>
            <tr>

              <td style="border: 1px; solid" border="1"> <%= user %> </td>
              <td style="border: 1px; solid"> <%= accountId %> </td>
              <td style="border: 1px; solid"> <%= acctType %> </td>
              <td style="border: 1px; solid"> $<%= balance %> </td>
              <td style="border: 1px; solid"> <%= location %> </td>
              <td style="border: 1px; solid"> <%= title %> </td>
              <td style="border: 1px; solid"> <%= ts %> </td>
            </tr>
            <%
                }
            %>

          </table>

          <h3> Transfer Funds </h3>

          <form action="/badbanking/bank-home-servlet" METHOD="GET" >
           <input type="hidden" required name="action" value="TRANSFER">

           <h4>  Transfer From </h4>
            <div>
               <div class="w3-row-padding" style="margin:0 -16px 8px -16px">
                 <div class="w3-half">
                   <input class="w3-input w3-border" type="text" placeholder="accountfrom" required name="accountfrom">
                 </div>
                 <div class="w3-half">
                    <input class="w3-input w3-border" type="text" placeholder="accounttype" required name="accounttype">
                </div>
                 <div class="w3-half">
                   <input class="w3-input w3-border" type="text" placeholder="transferamount" required name="transferamount">
                 </div>
               </div>
           </div>

           <p/>
           <br/>
           <hr/>

           <h4> Transfer To </h4>
            <div>

               <div class="w3-row-padding" style="margin:0 -16px 8px -16px">
                 <div class="w3-half">
                   <input class="w3-input w3-border" type="text" placeholder="accountnumberto" required name="accountnumberto">
                 </div>
                 <div class="w3-half">
                   <input class="w3-input w3-border" type="text" placeholder="accounttypeto" required name="accounttypeto">
                 </div>
               </div>
               <button class="w3-button w3-black w3-section w3-right" type="submit">SEND</button>
           </div>

          </form>

      </div>

   <!-- About Section -->
   <div class="w3-container w3-padding-32" id="about">
     <h3 class="w3-border-bottom w3-border-light-grey w3-padding-16">About</h3>
     <p>ZRI Bank Bemory and User Form - Best Team Ever.  Fake banking site to test SQL Injection. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Excepteur sint
       occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco
       laboris nisi ut aliquip ex ea commodo consequat.
     </p>
   </div>

  <div class="w3-row-padding w3-grayscale">
    <div class="w3-col l3 m6 w3-margin-bottom">
      <img src="/badbanking/support/images/team2.jpg" alt="John" style="width:100%">
      <h3>John Doe</h3>
      <p class="w3-opacity">CEO & Founder</p>
      <p>Phasellus eget enim eu lectus faucibus vestibulum. Suspendisse sodales pellentesque elementum.</p>
      <p><button class="w3-button w3-light-grey w3-block">Contact</button></p>
    </div>
    <div class="w3-col l3 m6 w3-margin-bottom">
      <img src="/badbanking/support/images/team1.jpg" alt="Jane" style="width:100%">
      <h3>Jane Doe</h3>
      <p class="w3-opacity">Architect</p>
      <p>Phasellus eget enim eu lectus faucibus vestibulum. Suspendisse sodales pellentesque elementum.</p>
      <p><button class="w3-button w3-light-grey w3-block">Contact</button></p>
    </div>
    <div class="w3-col l3 m6 w3-margin-bottom">
      <img src="/badbanking/support/images/team3.jpg" alt="Mike" style="width:100%">
      <h3>Mike Ross</h3>
      <p class="w3-opacity">Architect</p>
      <p>Phasellus eget enim eu lectus faucibus vestibulum. Suspendisse sodales pellentesque elementum.</p>
      <p><button class="w3-button w3-light-grey w3-block">Contact</button></p>
    </div>
    <div class="w3-col l3 m6 w3-margin-bottom">
      <img src="/badbanking/support/images/team4.jpg" alt="Dan" style="width:100%">
      <h3>Dan Star</h3>
      <p class="w3-opacity">Architect</p>
      <p>Phasellus eget enim eu lectus faucibus vestibulum. Suspendisse sodales pellentesque elementum.</p>
      <p><button class="w3-button w3-light-grey w3-block">Contact</button></p>
    </div>
  </div>

 <!-- The Contact Section -->
   <div class="w3-container w3-content w3-padding-64" style="max-width:800px" id="contact">

     <h2 class="w3-wide w3-center">CONTACT</h2>
     <p class="w3-opacity w3-center"><i>Fan? Drop a note!</i></p>
     <div class="w3-row w3-padding-32">
       <div class="w3-col m6 w3-large w3-margin-bottom">
         <i class="fa fa-map-marker" style="width:30px"></i> Atlanta, Ga<br>
         <i class="fa fa-phone" style="width:30px"></i> Phone: +404 555 5555<br>
         <i class="fa fa-envelope" style="width:30px"> </i> Email: mail@mail.com<br>
       </div>

       <div class="w3-col m6">
         <form action="/action_page.php" target="_blank">
           <div class="w3-row-padding" style="margin:0 -16px 8px -16px">
             <div class="w3-half">
               <input class="w3-input w3-border" type="text" placeholder="Name" required name="Name">
             </div>
             <div class="w3-half">
               <input class="w3-input w3-border" type="text" placeholder="Email" required name="Email">
             </div>
           </div>
           <input class="w3-input w3-border" type="text" placeholder="Message" required name="Message">
           <button class="w3-button w3-black w3-section w3-right" type="submit">SEND</button>
         </form>
       </div>

     </div>
   </div>

</div>

Note: site based on: https://www.w3schools.com/w3css/tryit.asp?filename=tryw3css_templates_band&stacked=h

</body>
</html>
