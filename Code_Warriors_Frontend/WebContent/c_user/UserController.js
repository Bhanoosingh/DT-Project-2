/**
 * 
 */
myApp.controller("UserController",function($scope,$http,$location,$rootScope,$cookieStore){
	
	$scope.user={"name":'',"password":'',"email":'',"address":'',"phone":'',"role":'',"isOnline":''};
		
		$scope.register = function(){
			console.log("Registration function");
			$http.post('http://localhost:8085/CodeWarriaorsMiddleware/registerUser',$scope.user)
			.then(function(response)
				{
				console.log('Status text:' + response.statusText);
				});
		};
	
		$rootScope.login=function(){
			console.log("Logging function");
			
			$http.post("http://localhost:8085/CodeWarriaorsMiddleware/login",$scope.user)
			.then(function(response){
				console.log(response.status);
				$scope.user=response.data;
				$rootScope.currentUser=response.data;
				$cookieStore.put('userrecord',response.data);
				console.log($rootScope.currentUser.role);
				
				if($rootScope.currentUser.role=='Admin'){
					console.log("Admin");
				}
				if($rootScope.currentUser.role=='User'){
					console.log("User");
				}
				$location.path("home");
			});
		};
		
		
		$rootScope.displayDetails=function(){
			
			console.log("Display Details function called : ");
		};

	$rootScope.logout=function(){
		console.log('LogOut function');
		delete $rootScope.currentUser;
		$cookieStore.remove('userrecord');
		$location.path("logout");
	}	
});