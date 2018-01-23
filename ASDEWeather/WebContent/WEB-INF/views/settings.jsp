<!-- Settings modal -->
<div class="modal fade bd-example-modal-lg" tabindex="-1" id="settingsModal" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">Settings</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      <div class="row">
       <div class="col col-3">
       		<ul class="list-group">
			  <li class="list-group-item active">Personal Details</li>
			</ul>
       </div>
       <div class="col col-9">
       	
       		<form ng-submit="profileUpdate($storage.userData)">
       			<div ng-if ="userUPdateError"></div>
			   <div class="form-group">
			    <label for="exampleInputPassword1">First Name</label>
			    <input type="text"   ng-model="$storage.userData.firstname" ng-bind="userInfo.username" class="form-control" required>
			   </div>
			   <div class="form-group">
			    <label for="exampleInputPassword1">Last Name</label>
			    <input type="text" name ="userInfo.lastname" class="form-control" ng-model="$storage.userData.lastname"  required>
			    </div>
			  <div>
			    <label for="exampleInputEmail1">Email address</label>
			    <input type="email"   ng-model="$storage.userData.email"  class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email" required>
			    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
			  </div>
	 	
      	
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
		        <button type="submit" class="btn btn-primary">Save changes</button>
		      </div>
      	</form>
      	</div>
    </div>
  </div>
</div>