actionApp.controller('View2Ctrl',function ($rootScope,$scope) {
    $scope.$on('$viewContentLoaded',function () {
        console.log('页面加载完成');
    });
});