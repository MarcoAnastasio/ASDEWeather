<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
	<div class="container-fluid">
		<a class="navbar-brand js-scroll-trigger" id="top-page-btn">ASDEWeather</a>

		<!-- Drop down button (collapse) -->
		<button class="navbar-toggler navbar-toggler-right" type="button"
			data-toggle="collapse" data-target="#navbarResponsive"
			aria-controls="navbarResponsive" aria-expanded="false"
			aria-label="Toggle navigation">
			<i class="fa fa-bars"></i>
		</button>


		<!-- Navbar elements left  -->
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item" ng-show="status==1"><a class="nav-link js-scroll-trigger"
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


			<!-- Navabar login form -->
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
					<button class="btn btn-primary" id="mob-login" type="submit">Submit</button>


				</form>

			</div>

			<!-- NavBar logged user  -->
			<div class="form-inline my-2 my-lg-0" ng-if="$storage.status == 1">
				<ul class=" navbar-nav">
					<li class="nav-item" ng-controller ="NotificationController" ng-init="getNotifications()">
					
					<a class="nav-link dropdown" ng-if="notificationsStatus > 0"> 
					<i	class="fa fa-bell drop-down-toggle" data-toggle ="dropdown" aria-haspopup="true" aria-expanded="false"
							style="font-size: 24px; color: #8B0000">
							
							</i>
							<div class="dropdown-menu dropdown-menu-right"
							aria-labelledby="navbarDropdown"  style="overflow-y:scroll; max-height:300px;">
								<span class="dropdown-item" ng-repeat="w in notificationList">
								{{w.weatherData.city.name}}</br />
								{{w.notificationReason}} <br /> 
								{{w.messageForUser}}
								<hr>
								</span>
								
								<button class="btn btn-sm btn-primary">clear</button>
							</div>
							
					</a>
							
					
					<a class="nav-link" ng-if="notificationsStatus == 0" 
						> <i
							class="fa fa-bell  drop-down-toggle" data-toggle ="dropdown" aria-haspopup="true"  style="font-size: 24px; color: #FFF">
					</i>
						<div class="dropdown-menu dropdown-menu-right"
							aria-labelledby="navbarDropdown">
								
								<span class="dropdown-item">No Weather Notifications for your cities</span>
							
								
							</div>
					
					</a>
							
					</li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false"> <i class="fa fa-user-circle"
							style="font-size: 24px"></i>
					</a>
						<div class="dropdown-menu dropdown-menu-right"
							aria-labelledby="navbarDropdown">
							<a class="dropdown-item">Hi {{$storage.userData.username}},</a> <a
								class="dropdown-item" href="" class="btn btn-primary"
								data-toggle="modal" data-target=".bd-example-modal-lg"">Settings</a>
							<a class="dropdown-item" href="">Edit Profile</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" ng-click="logout()">Log Out</a>
						</div></li>
				</ul>
			</div>

			<div ng-show=" $storage.status == 0" class="white-class">
				<a class='both-margin'> Or </a>
			</div>

			<button ng-show=" $storage.status == 0" id="show-register-modal"
				class="btn btn-primary 5-margin-left">Register</button>
		</div>
	</div>
</nav>



