'use strict';

// Blog Module
var blogModule = angular.module('blogModule', []);

blogModule.controller('BlogController', [ '$http', function($http) {
    var vm = this;
    this.selectedBlog = null;
    this.blogs = [];
    
    $http({
	method : 'GET',
	url : '/rest/blogs'
    }).then(function successCallback(response) {
	vm.blogs = response.data;
    }, function errorCallback(response) {
	vm.errorMsg = response;
    });

} ]);
