<!-- Settings modal -->
<div class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
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
			  <li class="list-group-item">Preferences</li>
			</ul>
       </div>
       <div class="col col-9">
       	<table>
       		<tr>
       			<td >Username</td>
       			<td><input name="username" ng-model="$storage.userData.firstname" disabled />
       		</tr>
       		<tr>
       			<td >Username</td>
       			<td><input name="username" ng-model="$storage.userData.lastname" disabled />
       		</tr>
       		<tr>
       		<td >Email</td>
       			<td><input name="username" ng-model="$storage.userData.email" disabled />
       			<td ng-model="$storage.userData.firstName"></td>
       		</tr>
       	</table>
       </div>
      </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>