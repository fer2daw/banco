app.config(['$routeProvider', function ($routeProvider) {
        
        $routeProvider.when('/tarjetacredito/update/:idTarjetaCredito', {
            templateUrl: "update/tarjetacredito-update.html",
            controller: "TarjetaCreditoUpdateController"
        });
        
    }]);
