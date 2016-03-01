package com.fpmislata.banco.dominio;

import java.io.Serializable;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

/**
 *
 * @author logongas
 */
public class TarjetaCredito implements Serializable{

    private int idTarjetaCredito;

    private String numero;

    private int mesCaducidad;

    @Max(12)
    private int anyoCaducidad;

    private String nombreTitular;

    private int cvv;

    private int idCuentaBancaria;

    private TipoTarjeta tipoTarjeta;

    public TarjetaCredito() {
    }

    public TarjetaCredito(String numero, int mesCaducidad, int anyoCaducidad, String nombreTitular, int cvv, int idCuentaBancaria, TipoTarjeta tipoTarjeta) {
        this.numero = numero;
        this.mesCaducidad = mesCaducidad;
        this.anyoCaducidad = anyoCaducidad;
        this.nombreTitular = nombreTitular;
        this.cvv = cvv;
        this.idCuentaBancaria = idCuentaBancaria;
        this.tipoTarjeta = tipoTarjeta;
    }
    
    

    /**
     * @return the idTarjetaCredito
     */
    public int getIdTarjetaCredito() {
        return idTarjetaCredito;
    }

    /**
     * @param idTarjetaCredito the idTarjetaCredito to set
     */
    public void setIdTarjetaCredito(int idTarjetaCredito) {
        this.idTarjetaCredito = idTarjetaCredito;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the mesCaducidad
     */
    public int getMesCaducidad() {
        return mesCaducidad;
    }

    /**
     * @param mesCaducidad the mesCaducidad to set
     */
    public void setMesCaducidad(int mesCaducidad) {
        this.mesCaducidad = mesCaducidad;
    }

    /**
     * @return the anyoCaducidad
     */
    public int getAnyoCaducidad() {
        return anyoCaducidad;
    }

    /**
     * @param anyoCaducidad the anyoCaducidad to set
     */
    public void setAnyoCaducidad(int anyoCaducidad) {
        this.anyoCaducidad = anyoCaducidad;
    }

    /**
     * @return the nombreTitular
     */
    public String getNombreTitular() {
        return nombreTitular;
    }

    /**
     * @param nombreTitular the nombreTitular to set
     */
    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    /**
     * @return the cvv
     */
    public int getCvv() {
        return cvv;
    }

    /**
     * @param cvv the cvv to set
     */
    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    /**
     * @return the idCuentaBancaria
     */
    public int getIdCuentaBancaria() {
        return idCuentaBancaria;
    }

    /**
     * @param idCuentaBancaria the idCuentaBancaria to set
     */
    public void setIdCuentaBancaria(int idCuentaBancaria) {
        this.idCuentaBancaria = idCuentaBancaria;
    }

    /**
     * @return the tipoTarjeta
     */
    public TipoTarjeta getTipoTarjeta() {
        return tipoTarjeta;
    }

    /**
     * @param tipoTarjeta the tipoTarjeta to set
     */
    public void setTipoTarjeta(TipoTarjeta tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

}
