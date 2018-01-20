/***
 * 	Author: Haze
 */


function Notifications(notification_list){
	
	var notifications = [];
	
	for (var i = 0; i < notification_list.length; i++) {
		notifications[i] = new NotificationDecoder(notification_list[i]);

	}
	
	this.notification_list = notifications;

}


function NotificationDecoder(notification_list){
	this.cityName = notification_list.weatherData.city.name;
	this.message = notification_list.notificationReason+": "+notification_list.messageForUser;
}


