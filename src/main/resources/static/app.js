var actionApp = angular.module('actionApp',['ngRoute']);

actionApp.config(['$routeProvider',function ($routeProvider) {
    $routeProvider.when('/oper',{
        controller: 'View1Ctrl',
        templateUrl: 'templates/view1.html'
    }).when('/directive',{
        controller: 'View2Ctrl',
        templateUrl: 'templates/view2.html'
    }).when('/bootstrap',{
        controller: 'bootstrapCtrl',
        templateUrl: 'templates/bootstrap.html'
    });

}]);
