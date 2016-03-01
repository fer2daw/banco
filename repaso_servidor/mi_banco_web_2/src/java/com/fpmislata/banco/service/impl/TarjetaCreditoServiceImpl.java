package com.fpmislata.banco.service.impl;

import com.fpmislata.banco.dominio.CuentaBancaria;
import com.fpmislata.banco.dominio.TarjetaCredito;
import com.fpmislata.banco.dominio.TipoTarjeta;
import com.fpmislata.banco.persistencia.dao.BussinessException;
import com.fpmislata.banco.persistencia.dao.CuentaBancariaDAO;
import com.fpmislata.banco.persistencia.dao.TarjetaCreditoDAO;
import com.fpmislata.banco.persistencia.dao.impl.hibernate.CuentaBancariaDAOImplHibernate;
import com.fpmislata.banco.persistencia.dao.impl.hibernate.TarjetaCreditoDAOImplHibernate;
import com.fpmislata.banco.service.TarjetaCreditoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author fernandoarenasdev
 */
public class TarjetaCreditoServiceImpl implements TarjetaCreditoService {

    //Falla el autowired
    TarjetaCreditoDAO tarjetaCreditoDAO = new TarjetaCreditoDAOImplHibernate();

    CuentaBancariaDAO cuentaBancariaDAO = new CuentaBancariaDAOImplHibernate();

    TipoTarjeta tipoTarjeta;

    @Override
    public TarjetaCredito get(int id) throws BussinessException {
        return tarjetaCreditoDAO.get(id);
    }

    @Override
    public TarjetaCredito insert(TarjetaCredito tarjetacredito) throws BussinessException {
        CuentaBancaria cuentaBancaria = cuentaBancariaDAO.get(tarjetacredito.getIdCuentaBancaria());

        List<TarjetaCredito> tarjetas = findAll();
        for (TarjetaCredito tarjeta : tarjetas) {
            if (tarjeta.getNumero().equals(tarjetacredito.getNumero())) {
                throw new BussinessException("Repeticion", "La tarjeta ya existe.");
            } else {
            }

        }

        if (tarjetacredito.getTipoTarjeta() == tipoTarjeta.GOLD && cuentaBancaria.getSaldoCuentaBancaria() < 1000.00) {
            throw new BussinessException("Tipo", "No puede ser gold.");
        } else {

        }
        return tarjetaCreditoDAO.insert(tarjetacredito);
    }

    @Override
    public TarjetaCredito update(TarjetaCredito tarjetacredito) throws BussinessException {
        return tarjetaCreditoDAO.update(tarjetacredito);
    }

    @Override
    public void delete(int id) throws BussinessException {
        tarjetaCreditoDAO.delete(id);
    }

    @Override
    public List<TarjetaCredito> findAll() throws BussinessException {
        return tarjetaCreditoDAO.findAll();
    }

}
