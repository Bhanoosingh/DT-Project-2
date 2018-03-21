/// <reference path="angular.min.js" />
var app = angular.module("myApp", ["ngRoute"]);
				app.config(function($routeProvider) {
				    $routeProvider
				    .when("/", {
				        templateUrl : "index.html"
				    })
				    .when("/blog", {
				        templateUrl : "blog.html"
				    })
				    .when("/job", {
				        templateUrl : "job.html"
				    })
				    .when("/forum", {
				        templateUrl : "forum.html"
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