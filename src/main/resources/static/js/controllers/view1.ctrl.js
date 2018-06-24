actionApp.controller('View1Ctrl',function ($rootScope,$scope,$http) {
    $scope.$on('$viewContentLoaded',function () {
        console.log('页面加载完成');
    });

    $scope.search = function () {
        var personName = $scope.personName;
        $http.get('/resJson',{
            params:{personName: personName}
        }).success(function (data) {
            $scope.person = data;
        });
    }
});