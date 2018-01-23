<div class="container" ng-controller="SearchController">
	<div class="container mt-sm-3">
		<div class="row justify-content-center">
			<div class="col-12 col-md-8 col-lg-6 card">
				<div class="card-body">
					<h2 class="card-title text-dark">Search City</h2>
					<div class="form-row mb-2">
						<div class="col">
							<label class="col-form-label text-right" for="searchQuery">
								<span ng-if="query">{{ 'search for: ' + query}}</span>
								<div ng-if="(query).length<=2">
								
								  <div ng-init="clearSearch()"></div> 
								</div>
							</label>
						</div>
						<!-- label -->

						<div class="col-12">
							<input class="form-control form-control-lg" id="searchQuery"
								placeholder="Search for cities" autofocus ng-model="query"
								ng-change="autoComplateCall()">
						</div>
						<!-- col-12 -->
					</div>
					<!-- form-row -->

				
					<!-- form-row -->

				</div>
				<!-- card-body -->
			</div>
			<!-- col-12 -->
		</div>
		<!-- row -->
	</div>
	<!-- col-container -->

	<div class="cities-list container" ng-show="query" >
		<div class="row justify-content-center">
			<div class="col-12 col-sm-9 col-md-7 col-lg-5">
				<ul class=" list-group">

					 <button ng-repeat="city in cities| orderBy:city" type="button"
						class="list-group-item list-group-item-action"
						ng-click="currentWeatherByCityCall(city.id,city.name,city)" ng-hide="cityListHide">
						
						<div class="media d-flex align-items-center">
							<h5 class="my-0 text-dark">{{city.name}}</h5>
							<div class="media-body">
								<div class="text-secondary font-italic">a city in :{{city.country.name}}</div>
							</div>
						</div>
					</button>
                  
				</ul>
			</div>
			<!-- col-12 -->
		</div>
		<!-- row -->
	</div>
	
</div>
