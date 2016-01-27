'use strict';

// Blog Module
var blogModule = angular.module('blogModule', []);

blogModule.controller('BlogController', [ '$http', function($http) {
    var vm = this;
    this.selectedBlog = null;
    this.blogs = [];

    this.search = function() {
	$http({
	    method : 'GET',
	    url : '/rest/blogs/search',
	    params : {
		query : vm.searchStr
	    }
	}).then(function successCallback(response) {
	    vm.blogs = response.data;
	    vm.selectedBlog = {};
	}, function errorCallback(response) {
	    vm.errorMsg = response;
	});
    };

    $http({
	method : 'GET',
	url : '/rest/blogs'
    }).then(function successCallback(response) {
	vm.blogs = response.data;
    }, function errorCallback(response) {
	vm.errorMsg = response;
    });

} ]);
