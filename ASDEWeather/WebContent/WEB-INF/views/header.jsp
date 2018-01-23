<header class="masthead" style="padding-top: 60px;">
	<div class="container" >
			<div class="col" style="margin-top: 25px">
				<div ng-contoller="WeatherController">
					<div ng-if="!userLocationEnbled"  style="color: #fed136; background-color: rgba(8, 38, 68, 0.5);  ">
					Please allow our page a location access in order
					 for us to provide you the weather for your current location</div>
					 
					  <div ng-if="userLocationEnbled" style="color: #fed136; background-color: rgba(8, 38, 68, 0.5);  ">
					  	
					  	
						  <div class="col">{{locationWeatherData[0].city.name}} &nbsp &nbsp
						  <i class="wi wi-{{locationWeatherData[0].weather.icon}}"
									style="color: #fed136;"></i> </div>
						    <div class="col" style="">
									Temp:{{locationWeatherData[0].mainTemp.temp}}&deg C,
									humidity:{{locationWeatherData[0].mainTemp.humidity}}&#37
									</div>
						    <p class="card-text"></p>
						  </div>
						
					  	</div>
					 </div>
			</div>
		<div class="intro-text" style="maring-top:0px">
			
			<div class="intro-lead-in">Welcome To UNICAL Weather!</div>
			<%@include file="search.jsp"%>
			<div style="padding-top: 10px"><%@include file="searchCard.jsp"%>
			</div>
		</div>
</header>