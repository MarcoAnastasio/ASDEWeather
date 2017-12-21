 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!-- Navigation bar -->
    <div  id="myNavbar2" class="navbar navbar-default navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">My Title</a>
        </div>
        <nav role="navigation" class="collapse navbar-collapse navbar-right">
          <ul class="navbar-nav nav">
            <li class="active"><a href="./">Home</a></li>
            <c:if test="${not empty user}">
				<li><a href="login2">logout</a></li>
			</c:if>
			<c:if test="${empty user}">
				<li><a href="login2">login</a></li>
			</c:if>
            <li><a href="#">License</a></li>
            <li><a href="#">Contacts</a></li>
          </ul>
        </nav>
      </div>
    </div><!-- End Navigation bar -->
    
    


    