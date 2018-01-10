<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Log In</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<!--  <div ng-bind="username==''?'empty':username" style="color:#000; height:30px; width:200px; border:solid 1px #000;"></div> -->
					<label>Username:</label><input ng-model="data.email" type="text"
						class="form-control" id="login-email" name="email"
						placeholder="Email/username" required> <label>Password:</label><input
						ng-model="data.password" type="password" class="form-control"
						id="password" name="password" placeholder="Password" required>

				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary" id="login"
						ng-click="login()">Log In</button>
				</div>
			</div>
		</div>
	</div>
	<!--  END Modal login -->
	<!-- Modal -->
	<div class="modal fade" id="registerModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<form ng-submit="register(user)">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Register</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>

				<div class="modal-body">
					<div ngIf="regError" class="alert alert-danger" id="error-form">
						
					</div>
					<br /> 
						
						<label>Name:</label><input ng-bind="user.firstname" type="text"
						class="form-control" id="reg-name" name="reg-n-name"
						placeholder="Name" required> <label>Last Name:</label><input
						ng-bind="user.lastname" type="text" class="form-control"
						id="reg-lastname" name="reg-n-lastname" placeholder="Last Name"
						required>
						<label>Username:</label><input ng-bind="user.username" type="text"
						class="form-control" id="reg-username" name="reg-n-username"
						placeholder="Username" required>
						 <label>Email:</label><input
						ng-bind="user.email" type="email" class="form-control"
						id="reg-email" name="reg-n-email"
						placeholder="username@domain.com" required> <label>Password:</label><input
						ng-bind="user.password" type="password" class="form-control"
						id="reg-password" name="reg-n-password" placeholder="********"
						required> <label>Re-Password:</label><input
						type="password" class="form-control" id="reg-re-password"
						name="reg-n-re-password" placeholder="********" required>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>

					<button type="submit" class="btn btn-primary" id="register"
						>Register</button>
				</div>
			</div>
		</div>
		</form>
</div>