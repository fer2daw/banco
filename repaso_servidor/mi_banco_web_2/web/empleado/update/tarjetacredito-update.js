app.controller("TarjetaCreditoUpdateController", ['$scope', '$rootScope', "$location", "tarjetaCreditoService", '$routeParams',
    function ($scope, $rootScope, $location, TarjetaCreditoService, $routeParams) {
        $scope.on = 'Angular ON!';

        TarjetaCreditoService.get($routeParams.idTarjetaCredito).success(function (data, status, headers, config) {
            $scope.tarjetaCredito = data;
        }).error(function (data, status, headers, config) {
            alert("Ha fallado la petición. Estado HTTP:" + status);
        });

        $scope.update = function () {
            TarjetaCreditoService.update($scope.tarjetaCredito).success(function (data, status, headers, config) {
                alert("Actualizado");
            }).error(function (data, status, headers, config) {
                alert("Ha fallado la petición. Estado HTTP:" + status);
            });
        };



    }]);


