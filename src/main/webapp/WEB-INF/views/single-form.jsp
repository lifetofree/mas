<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Single Form</title>
    </head>
    <body>
 
        <form name="input" action="display-single-form.jsp" method="post">
 
        <strong>Single Form</strong><br>
 
        <!-- START SINGLE FORM -->
        First name: <input type="text" name="firstname"><br>
        Last name: <input type="text" name="lastname"><br>
        Age: <select name="age">
            <% for(int i=15; i<25; i++){ %>
            <option value="<%=i%>"><%=i%></option>
            <% } %>
            </select>
        <!-- END SINGLE FORM -->  
 
        <br>
 
        <input type="submit" value="Submit">
        </form>
 
    </body>
</html>