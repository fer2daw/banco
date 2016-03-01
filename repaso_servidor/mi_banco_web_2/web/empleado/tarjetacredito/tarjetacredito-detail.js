app.controller("TarjetaCreditoController", ['$scope', '$rootScope', "$location", "tarjetaCreditoService", function ($scope, $rootScope, $location, TarjetaCreditoService) {
        $scope.on = 'Angular ON!';

        $scope.tarjetas = [
            {
                idTarjetaCredito: 2,
                nombre: "ELECTRON"
            },
            {
                idTarjetaCredito: 1,
                nombre: "GOLD"
            },
            {
                idTarjetaCredito: 3,
                nombre: "CLASSIC"
            }
        ];

        $scope.tarjetaCredito = {};

        $scope.listaTarjetas = {};

        TarjetaCreditoService.find().then(function (result) {
            $scope.listaTarjetas = result.data;
        });

        $scope.prueba = $scope.tarjetaCredito;

        $scope.insert = function () {

            if ($scope.miFormulario.$valid) {
                TarjetaCreditoService.insert($scope.tarjetaCredito).then(function (result) {
                    alert("Tarjeta Insertada con Éxito con el nombre: " + $scope.tarjetaCredito.numero);
                }, function (result) {
                    if (result.status === 500) {
                        alert("Ha fallado la petición. Estado HTTP:" + result.status);
                    } else {
                        $scope.businessMessages = result.data;
                    }
                });
            }
        };
    }]);


