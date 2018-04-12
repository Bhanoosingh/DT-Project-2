myApp.controller("BlogController",function($scope,$http,$location)
		{
			$scope.blog = {"blogName":'',"blogContent":'',"createDate":'',"userName":'',"status":'',"likes":0};
			$scope.blogData;
			$scope.insertBlog = function(){
				
				console.log('inside insert Blog');
				$http.post('http://localhost:8085/CodeWarriaorsMiddleware/addBlog',$scope.blog)
				.then(fetchAllBlog(), function(response) {
					//$location.reload();
					console.log('Status text:' + response.statusText);
				});
			};
			
			function fetchAllBlog()
			{
				console.log('Fetch All Blogs');
				$http.get("http://localhost:8085/CodeWarriaorsMiddleware/listBlog")
				.then(function(response)
				{
					$scope.blogData=response.data;
				})
			}
			$scope.editBlog = function(blogId) {
				$http.get('http://localhost:8085/CodeWarriaorsMiddleware/getBlog/' + blogId)
						.then(function(response) {
							console.log(response.status);
							$scope.blog = response.data;
							$location.path('/updateBlog');
							console.log('Status Text' + response.statusText);
							
						});
			};

			$scope.updateBlog = function(blogId){
				alert("in update blog");
				$http.put('http://localhost:8085/CodeWarriaorsMiddleware/updateBlog/'+ blogId, $scope.blog)
				.then(fetchAllBlogs(), function(response){
					console.log('updated blog'+ blogId+ ' successfully');
					// $location.path('/updateBlog');
					console.log(blogId +" updated successfully");
				// $location.reload();
				});
				
			};
			$scope.deleteBlog = function(blogId){
				// alert("in delete blog");
				$http.delete('http://localhost:8085/CodeWarriaorsMiddleware/deleteBlog/'+blogId)
				.then(fetchAllBlogs(), function(response){
					console.log('Blog deleted '+ blogId);
					console.log('Response Status ' + response.statusText);
				// $location.reload();
				});
			};
			$scope.incrementLike = function(blogId) {
				console.log('Into like increment');
				$http.post(
						'http://localhost:8085/CodeWarriaorsMiddleware/incrementLikes/'
								+ blogId, $scope.blog).then(fetchAllBlogs(),
						function(response) {
							console.log('Incremented likes');
							$location.path('/Blog')
						});
		}
			fetchAllBlog();
		});
