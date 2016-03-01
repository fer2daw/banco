app.controller("TarjetaCreditoDeleteController", ['$scope', '$rootScope', "$location", "tarjetaCreditoService", '$routeParams', 
    function ($scope, $rootScope, $location, TarjetaCreditoService, $routeParams) {
        //$scope.tarjetaCredito = TarjetaCreditoService.get(1);
        
        
        

    TarjetaCreditoService.get($routeParams.idTarjetaCredito).success(function (data, status, headers, config) {
        $scope.tarjetaCredito = data;
    }).error(function (data, status, headers, config) {
        alert("Ha fallado la petición. Estado HTTP:" + status);
    });
        

        
        $scope.delete = function () {
            TarjetaCreditoService.delete($routeParams.idTarjetaCredito);
            $location.path('/');
        };

    }]);


