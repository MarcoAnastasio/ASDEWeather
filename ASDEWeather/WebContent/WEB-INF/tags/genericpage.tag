<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
	<head>
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
			
		<link rel="stylesheet" type="text/css" href="resources/css/generic_page.css">
			
	</head>
	
	
  <body>
	<jsp:include page="/WEB-INF/views/standard/menu.jsp"/>
  	
  	
    <div id="myBody">
    	<div class="col-sm-2"></div>
    	<div id="realBody" class="col-sm-8">
	      <jsp:doBody/>
    	</div>
    	<div class="col-sm-2"></div>
    </div>
    
      <jsp:include page="/WEB-INF/views/standard/footer.jsp"/>
  </body>
  
  <script type="text/javascript">
  $(window).resize(function () { 
	   $('#myBody').css('padding-top', parseInt($('#myNavbar2').css("height")));
	   $('#myBody').css('padding-bottom', parseInt($('#footer').css("height")));
	   
	});

	$(window).ready(function () { 
	   $('#myBody').css('padding-top', parseInt($('#myNavbar2').css("height")));      
	   $('#myBody').css('padding-bottom', parseInt($('#footer').css("height")));
	}); 
  
  </script>
  
</html>