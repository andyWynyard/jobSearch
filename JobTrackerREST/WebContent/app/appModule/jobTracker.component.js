angular.module('appModule')
	.component('jobTracker', {
	templateUrl : 'app/appModule/jobTracker.component.html',
	controller : function(jobService) {
		var vm = this;
		
		vm.selected = null;

		vm.jobs = [];

		vm.index = function() {
			jobService.index().then(function(res) {
				console.log(res.data);
				vm.jobs = res.data;

			})

		}
		vm.index();

		vm.addJob = function(job) {
			console.log("Before Create Called");
			jobService.create(job).then(function(res) {
				console.log(res.data);
				vm.index();
			});
			console.log("After Create called");
		

		}
		
		vm.setEditJob = function(job) {
			vm.selected = angular.copy(job);
			console.log(vm.selected);
			console.log(vm.selected.id);
			
		}
		
		vm.editJob = function(id, job) {
			console.log(id);
			jobService.update(id, job).then(function(res) {
				console.log(res.data);
				vm.index(); 
				
			});
		}
		

		vm.deleteJob = function(id) {
			jobService.destroy(id).then(function(res) {
				vm.index();
			});

		}

	},
	controllerAs : 'vm'
});
