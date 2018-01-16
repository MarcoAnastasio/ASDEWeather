<!-- 
<nav class="navbar navbar-expand-lg navbar-dark fixed-top navbar-shrink"
	id="mainNav" style="align: left">

	<div class="container-fluid">
		<a class="navbar-brand js-scroll-trigger" href="#page-top">Weather</a>

		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav navbar-list-left">
				<li class="nav-item"><a class="nav-link js-scroll-trigger"
					href="#portfolio" data-toggle="collapse"
					data-target="#navbarResponsive">My cities</a></li>
				<li class="nav-item"><a class="nav-link js-scroll-trigger"
					href="#other-cities" data-toggle="collapse"
					data-target="#navbarResponsive">Other cities</a></li>
				<li class="nav-item"><a class="nav-link js-scroll-trigger"
					href="#about" data-toggle="collapse"
					data-target="#navbarResponsive">About</a></li>
				<li class="nav-item"><a class="nav-link js-scroll-trigger"
					href="#team" data-toggle="collapse" data-target="#navbarResponsive">Team</a></li>
				<li class="nav-item"><a class="nav-link js-scroll-trigger"
					href="#contact" data-toggle="collapse"
					data-target="#navbarResponsive">Contact</a></li>
				<li class="nav-item">
					<a class="nav-link  js-scroll-trigger d-md-none d-lg-none"
					href="#contact" id="mob-login" data-toggle="modal collapse"
					data-target="#exampleModal #navbarResponsive">
					Login</a>
				</li>
				<li class="nav-item">
					<a class="nav-link js-scroll-trigger d-md-none d-lg-none" href="#contact" id="mob-reg">
					 Register
					 </a>
			</li>
			</ul>
		</div>




		<div class="form-inline my-2 my-lg-0" ng-if="$storage.status == 1">
			<ul class=" navbar-nav">
				<li class="nav-item"><a class="nav-link"> <i
						class="fa fa-bell" style="font-size: 24px; color: #FFF"></i></a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> <i class="fa fa-user-circle"
						style="font-size: 24px"></i>
				</a>
					<div class="dropdown-menu dropdown-menu-right"
						aria-labelledby="navbarDropdown">
						<a class="dropdown-item">Hi {{$storage.userData.username}},</a> <a
							class="dropdown-item" href="#" class="btn btn-primary"
							data-toggle="modal" data-target=".bd-example-modal-lg"">Settings</a>
						<a class="dropdown-item" href="#">Edit Profile</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" ng-click="logout()">Log Out</a>
					</div></li>
			</ul>
			<div style="float: right;">
				<i class="fa fa-bell" style="font-size:36px; color:#FFF"></i>
			</div>
			<div style="float: right;">
				<button class="btn btn-primary btn-md hidden-sm visible-md"
					id="logout-top" ng-click="logout()">Log Out</button>
			</div>

		</div>
			<div class="tooltip bs-tooltip-top" role="tooltip" id="notifyUser">
				<div class="arrow"></div>
				<div class="tooltip-inner">Please Check your username or password!</div>
			</div>
		<div ng-show="$storage.status == 0" id="user-top-bar"
			class="hidden-sm visible-md">
		
			<form ng-submit="login(userInfo)">


/*
				
				  <div class="form-row">
				    <div class="col">
				      <input type="text" ng-model="userInfo.username" class="form-control form-control-sm" placeholder="Username" required>
				    </div>
				    <div class="col">
				      <input type="password" ng-model="userInfo.password" class="form-control form-control-sm"  placeholder="*******" required>
				    </div>
				    <div class="col">
				    	<button type="submit"
*/

				<div class="form-row">
					<div class="col">
						<input type="text" ng-model="userInfo.username"
							class="form-control form-control-sm" placeholder="Username"
							required>
					</div>
					<div class="col">
						<input type="password" ng-model="userInfo.password"
							class="form-control form-control-sm" placeholder="*******"
							required>
					</div>
					<div class="col">
						<button type="submit"
							class="btn btn-primary btn-sm d-none d-sm-none d-md-inline d-lg-inline"
							id="login-top">Log In</button>
					</div>
					<div class="col">
						<button
							class="btn btn-primary btn-sm  d-none d-sm-none d-md-inline d-lg-inline"
							id="register-top">Register</button>
					</div>
				</div>
			</form>

			<button

				class="btn btn-primary btn-sm d-none d-sm-none d-md-inline d-lg-inline"
				id="login-top" data-toggle="modal" data-target="#exampleModal">
				Log In</button>
		</div>
		<button class="navbar-toggler" data-toggle="collapse"
			data-target="#navbarResponsive"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
	</div>

</nav>

 -->

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
	<div class="container-fluid">
		<a class="navbar-brand js-scroll-trigger" id="top-page-btn">Weather</a>
		<button class="navbar-toggler navbar-toggler-right" type="button"
			data-toggle="collapse" data-target="#navbarResponsive"
			aria-controls="navbarResponsive" aria-expanded="false"
			aria-label="Toggle navigation">
			<i class="fa fa-bars"></i>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link js-scroll-trigger"
					id="MyCities-btn" data-toggle="collapse"
					data-target="#navbarResponsive">My cities</a></li>
				<li class="nav-item"><a class="nav-link js-scroll-trigger"
					id="Cities-btn" data-toggle="collapse"
					data-target="#navbarResponsive">Cities</a></li>
				<li class="nav-item"><a class="nav-link js-scroll-trigger"
					id="Guide-btn" data-toggle="collapse"
					data-target="#navbarResponsive">Guide</a></li>
				<!--  data-target="#navbarResponsive" -->
			</ul>
			<div ng-show="$storage.status == 0" id="user-top-bar">
				<form class="form-inline" ng-submit="login(userInfo)">
					<label class="sr-only" for="username">Username</label>
					<div class="input-group mb-2 mr-sm-2 mb-sm-0">
						<!-- 	<div class="input-group-addon">
							<i class="fa fa-user" aria-hidden="true"></i>
						</div> -->
						<input type="text" class="form-control mb-2 mr-sm-2 mb-sm-0"
							id="username" placeholder="username" ng-model="userInfo.username"
							required="required"> <label class="sr-only"
							for="password">Password</label>
					</div>
					<div class="input-group mb-2 mr-sm-2 mb-sm-0">
						<!-- 	<div class="input-group-addon">
							<i class="fa fa-key" aria-hidden="true"></i>
						</div> -->
						<input type="password" class="form-control" id="password"
							placeholder="******" ng-model="userInfo.password"
							required="required">
					</div>
					<button class="btn btn-primary" type="submit">Submit</button>


				</form>

			</div>

			<div class="form-inline my-2 my-lg-0" ng-show="$storage.status == 1">
				<ul class=" navbar-nav">
					<li class="nav-item"><a class="nav-link"> <i
							class="fa fa-bell" style="font-size: 24px; color: #FFF"></i></a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false"> <i class="fa fa-user-circle"
							style="font-size: 24px"></i>
					</a>
						<div class="dropdown-menu dropdown-menu-right"
							aria-labelledby="navbarDropdown">
							<a class="dropdown-item">Hi {{$storage.userData.username}},</a> <a
								class="dropdown-item" href="#" class="btn btn-primary"
								data-toggle="modal" data-target=".bd-example-modal-lg"">Settings</a>
							<a class="dropdown-item" href="#">Edit Profile</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" ng-click="logout()">Log Out</a>
						</div></li>
				</ul>
				<div style="float: right;">
					<i class="fa fa-bell" style="font-size: 36px; color: #FFF"></i>
				</div>
				<div style="float: right;">
					<button class="btn btn-primary btn-md hidden-sm visible-md"
						id="logout-top" ng-click="logout()">Log Out</button>
				</div>

			</div>


			<div ng-show=" $storage.status == 0" class="white-class">
				<a class='both-margin'> Or </a>
			</div>

			<button ng-show=" $storage.status == 0" id="show-register-modal"
				class="btn btn-primary 5-margin-left">Register</button>
		</div>
	</div>
</nav>



