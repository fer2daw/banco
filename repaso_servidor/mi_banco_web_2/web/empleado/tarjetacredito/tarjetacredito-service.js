TarjetaCreditoService.$inject = ['$http'];

function TarjetaCreditoService($http) {

    this.insert = function (tarjetacredito) {
        var response = $http({
            method: "POST",
            url: "/banco/api/tarjetacredito",
            data: tarjetacredito
        });
        return response;
    };

    this.update = function (tarjetacredito) {
        var response = $http({
            method: "PUT",
            url: "/banco/api/tarjetacredito",
            data: tarjetacredito
        });
        return response;
    };

    this.find = function () {
        var response = $http({
            method: "GET",
            url: "/banco/api/tarjetas"
        });
        return response;
    };

    this.delete = function (idTarjetaCredito) {
        var response = $http({
            method: "DELETE",
            url: "/banco/api/tarjetacredito/" + idTarjetaCredito
        });
        return response;
    };

    this.get = function (idTarjetaCredito) {
        var response = $http({
            method: "GET",
            url: "/banco/api/tarjetacredito/" + idTarjetaCredito
        });
        return response;
    };

}
;

app.service("tarjetaCreditoService", TarjetaCreditoService);