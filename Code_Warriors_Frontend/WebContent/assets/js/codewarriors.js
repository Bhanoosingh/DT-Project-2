/// <reference path="assets/js/angular.min.js" />

var myApp=angular.module("myApp",['ngRoute',,'ngCookies']);

myApp.config(function($routeProvider)
{
	console.log('I am in templateUrl');
	$routeProvider
	.when("/",{
		templateUrl:"home.html"
	})
	.when("/contact",{
		templateUrl:"contactus.html"
	})
	.when("/login",{
		templateUrl:"c_user/login.html"
	})
	.when("/register",{
		templateUrl:"c_user/register.html"
	})
	.when("/blog",{
		templateUrl:"c_blog/blog.html"
	})
	.when("/forum",{
		templateUrl:"c_forum/forum.html",
	})
	.when("/job",{
		templateUrl:"c_job/job.html"
	})
	.when("/UserHome",{
		templateUrl:"user/UserHome.html"
	})
	.when("/logout",{
		templateUrl:"user/LogOut.html"
	})
	.when("/about",{
		templateUrl:"aboutus.html"
	})
	.when("/addBlog",{
		templateUrl:"blog/AddBlog.html"
	})
	.when("/displayProfile",{
		templateUrl:"user/UploadProfilePicture.html"
	})
	.when("/uploadProfilePicture",{
		templateUrl:"user/UploadProfilePicture.html"
	})

});


myApp.run(function($rootScope,$cookieStore)
		{
			console.log('I am in run function');
			console.log($rootScope.currentUser);
			
				if($rootScope.currentUser==undefined)
				{
				$rootScope.currentUser=$cookieStore.get('userDetails');
				}
				else
				{
				console.log($rootScope.currentUser.userName);
				console.log($rootScope.currentUser.role);
				}
});