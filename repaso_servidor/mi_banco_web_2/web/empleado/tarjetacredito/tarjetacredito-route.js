app.config(['$routeProvider', function ($routeProvider) {

        $routeProvider.when('/tarjetacredito/new', {
            templateUrl: "tarjetacredito/tarjetacredito-detail.html",
            controller: "TarjetaCreditoController"
        });

        $routeProvider.when('/tarjetacredito/delete/:idTarjetaCredito', {
            templateUrl: "delete/tarjetacredito-delete.html",
            controller: "TarjetaCreditoDeleteController"
        });

    }]);
