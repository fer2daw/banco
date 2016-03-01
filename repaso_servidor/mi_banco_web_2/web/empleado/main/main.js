app.controller("MainController", ['$scope', '$rootScope', "$location", 'tarjetaCreditoService', function ($scope, $rootScope, $location, TarjetaCreditoService) {
        $scope.ta = 'On';       

        TarjetaCreditoService.find().then(function (result) {
            $scope.tarjetas = result.data;
        });
    }]);


