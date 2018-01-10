	<nav class="navbar navbar-expand-lg navbar-dark fixed-top navbar-shrink" id="mainNav"
		style="align:left">
	<div class="container">
		<a class="navbar-brand js-scroll-trigger" href="#page-top">Weather</a>

		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class=" navbar-nav text-uppercase navbar-list-left">
				<li class="nav-item"><a class="nav-link js-scroll-trigger"
					href="#portfolio">My cities</a></li>
				<li class="nav-item"><a class="nav-link js-scroll-trigger"
					href="#other-cities">Other cities</a></li>
				<li class="nav-item"><a class="nav-link js-scroll-trigger"
					href="#about">About</a></li>
				<li class="nav-item"><a class="nav-link js-scroll-trigger"
					href="#team">Team</a></li>
				<li class="nav-item"><a class="nav-link js-scroll-trigger"
					href="#contact">Contact</a></li>
				<li class="nav-item"><a
					class="nav-link js-scroll-trigger d-md-none d-lg-none"
					href="#contact">Login</a></li>
				<li class="nav-item"><a
					class="nav-link js-scroll-trigger d-md-none d-lg-none"
					href="#contact">Register</a></li>
			</ul>
		</div>

		<button class="navbar-toggler navbar-toggler-right" type="button"
			data-toggle="collapse" data-target="#navbarResponsive"
			aria-controls="navbarResponsive" aria-expanded="false"
			aria-label="Toggle navigation">
			Menu <i class="fa fa-bars"></i>
		</button>

		<div style="float: right;" ng-show="status==1">
			<div style="float: right;">
				<button class="btn btn-primary btn-md hidden-sm visible-md"
					id="logout-top" ng-click="logout()">Log Out</button>
			</div>
			<div style="float: right; color: #fff; padding-right: 5px;">Hi
				{{data.name}},</div>
		</div>

		<div ng-show="status==0" id="user-top-bar"
			class="hidden-sm visible-md">
			<button
				class="btn btn-primary btn-md d-none d-sm-none d-md-inline d-lg-inline"
				id="login-top" data-toggle="modal" data-target="#exampleModal">
				Log In</button>
			<button
				class="btn btn-primary btn-md  d-none d-sm-none d-md-inline d-lg-inline"
				id="register-top">Register</button>
		</div>

	</div>
	</nav>

	