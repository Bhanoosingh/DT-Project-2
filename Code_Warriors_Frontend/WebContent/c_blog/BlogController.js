myApp.controller("BlogController",function($scope,$http,$location)
		{
			$scope.blog = {"blogId":0,"blogName":'',"blogContent":'',"createDate":'',"userName":'',"status":'',"likes":0};
			
			$scope.insertBlog = function(){
				
				console.log('inside insert Blog');
				$http.post('http://localhost:8085/CodeWarriaorsMiddleware/addBlog',$scope.blog)
				.then(function(response){
					console.log("status",response.statusText);
				});
			};
		});