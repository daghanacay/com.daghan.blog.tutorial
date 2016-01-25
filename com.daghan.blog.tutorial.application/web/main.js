'use strict';

// Blog Module
var blogModule = angular.module('blogModule',[]);

blogModule.controller('BlogController', function() {
    var vm = this;
    this.blogs = ["BLogFrontEnd1","BLogFrontEnd2"];
});
