/// <reference path="angular.min.js" />
var app = angular.module("myApp", ["ngRoute"]);
				app.config(function($routeProvider) {
				    $routeProvider
				    .when("/", {
				        templateUrl : "index.html"
				    })
				    .when("/blog", {
				        templateUrl : "c_blog/blog.html"
				    })
				    .when("/job", {
				        templateUrl : "c_blog/job.html"
				    })
				    .when("/forum", {
				        templateUrl : "c_blog/forum.html"
				    })
				    .when("/user", {
				        templateUrl : "c_blog/user.html"
				    })
				    .when("/login", {
				        templateUrl : "login.html"
				    })
				    .when("/register", {
				        templateUrl : "register.html"
				    })
				    .otherwise({
				        template : "index.html"
				    });
		});