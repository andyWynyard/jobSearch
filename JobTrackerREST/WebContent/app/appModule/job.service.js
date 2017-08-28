angular.module('appModule')
	.factory('jobService', function($http) {
	var service = {};

	// var BASE_URL = 'http://localhost:8080/JobTrackerREST/api/jobs/';

	service.index = function() {
		return $http({
			method : 'GET',
			url : 'api/jobs'
		})
	};

	service.create = function(job) {
		return $http({
			method : 'POST',
			url : 'api/jobs',
			headers : {
				'Content-Type' : 'application/json'
			},
			data : job
		})

	};
	
	service.update = function(id, job) {
	    return $http({
	      method : 'PUT',
	      url : "api/jobs/" + id,
	      headers : {
	        'Content-Type' : 'application/json'
	      },
	      data : job
	    })
	  };

	service.destroy = function(id) {
		return $http({
			method : 'DELETE',
			url : "api/jobs/" + id
		})
	}

	return service;
})
