package com.fpmislata.banco.presentacion.controller;

import com.fpmislata.banco.common.json.JsonTransformer;
import com.fpmislata.banco.common.json.JsonTransformerImplJackson;
import com.fpmislata.banco.dominio.TarjetaCredito;
import com.fpmislata.banco.persistencia.dao.BussinessException;
import com.fpmislata.banco.persistencia.dao.BussinessMessage;
import com.fpmislata.banco.persistencia.dao.TarjetaCreditoDAO;
import com.fpmislata.banco.persistencia.dao.impl.hibernate.TarjetaCreditoDAOImplHibernate;
import com.fpmislata.banco.service.TarjetaCreditoService;
import com.fpmislata.banco.service.impl.TarjetaCreditoServiceImpl;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TarjetaCreditoController {

    //@Autowired
    JsonTransformer jsonTransformer = new JsonTransformerImplJackson();

    TarjetaCreditoDAO tarjetaCreditoDAO = new TarjetaCreditoDAOImplHibernate();

    TarjetaCreditoService tarjetaCreditoService = new TarjetaCreditoServiceImpl();

    @RequestMapping(value = "/tarjetacredito/{idTarjetaCredito}", method = RequestMethod.GET, produces = "application/json")
    public void read(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable("idTarjetaCredito") int idTarjetaCredito) {
        try {
            TarjetaCredito tarjetaCredito = tarjetaCreditoService.get(idTarjetaCredito);
            String jsonSalida = jsonTransformer.toJson(tarjetaCredito);

            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            httpServletResponse.getWriter().println(jsonSalida);

        } catch (BussinessException ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);

        } catch (Exception ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

        }

    }

    @RequestMapping(value = "/tarjetacredito", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public void insert(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada) {
        try {
            TarjetaCredito seguroMedico = (TarjetaCredito) jsonTransformer.fromJson(jsonEntrada, TarjetaCredito.class);
            tarjetaCreditoService.insert(seguroMedico);
            String jsonSalida = jsonTransformer.toJson(seguroMedico);

            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.getWriter().println(jsonSalida);

        } catch (BussinessException ex) {
            List<BussinessMessage> bussinessMessage = ex.getBussinessMessageList();
            String jsonSalida = jsonTransformer.toJson(bussinessMessage);

            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            try {
                httpServletResponse.getWriter().println(jsonSalida);
            } catch (IOException ex1) {
                Logger.getLogger(TarjetaCreditoController.class.getName()).log(Level.SEVERE, null, ex1);
            }

        } catch (Exception ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (IOException ex2) {
                Logger.getLogger(TarjetaCreditoController.class.getName()).log(Level.SEVERE, null, ex2);
            }

        }
    }
    
    
    @RequestMapping(value = "/tarjetacredito", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public void update(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada) {
        try {
            TarjetaCredito tarjetaCredito = (TarjetaCredito) jsonTransformer.fromJson(jsonEntrada, TarjetaCredito.class);
            tarjetaCreditoService.update(tarjetaCredito);
            String jsonSalida = jsonTransformer.toJson(tarjetaCredito);

            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.getWriter().println(jsonSalida);

        } catch (BussinessException ex) {
            List<BussinessMessage> bussinessMessage = ex.getBussinessMessageList();
            String jsonSalida = jsonTransformer.toJson(bussinessMessage);

            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            try {
                httpServletResponse.getWriter().println(jsonSalida);
            } catch (IOException ex1) {
                Logger.getLogger(TarjetaCreditoController.class.getName()).log(Level.SEVERE, null, ex1);
            }

        } catch (Exception ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (IOException ex2) {
                Logger.getLogger(TarjetaCreditoController.class.getName()).log(Level.SEVERE, null, ex2);
            }

        }
    }
    
    

    @RequestMapping(value = "/tarjetas", method = RequestMethod.GET, produces = "application/json")
    public void find(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        try {
            List<TarjetaCredito> tarjetas = tarjetaCreditoService.findAll();
            String jsonSalida = jsonTransformer.toJson(tarjetas);

            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.getWriter().println(jsonSalida);

        } catch (BussinessException ex) {
            List<BussinessMessage> bussinessMessage = ex.getBussinessMessageList();
            String jsonSalida = jsonTransformer.toJson(bussinessMessage);

            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            try {
                httpServletResponse.getWriter().println(jsonSalida);
            } catch (IOException ex1) {
                Logger.getLogger(TarjetaCreditoController.class.getName()).log(Level.SEVERE, null, ex1);
            }

        } catch (Exception ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (IOException ex2) {
                Logger.getLogger(TarjetaCreditoController.class.getName()).log(Level.SEVERE, null, ex2);
            }

        }

    }

    @RequestMapping(value = "/tarjetacredito/{idTarjetaCredito}", method = RequestMethod.DELETE, produces = "application/json")
    public void delete(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable("idTarjetaCredito") int idTarjetaCredito) {
        try {
            tarjetaCreditoService.delete(idTarjetaCredito);

            httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);

        } catch (BussinessException ex) {
            List<BussinessMessage> bussinessMessage = ex.getBussinessMessageList();
            String jsonSalida = jsonTransformer.toJson(bussinessMessage);

            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            try {
                httpServletResponse.getWriter().println(jsonSalida);
            } catch (IOException ex1) {
                Logger.getLogger(TarjetaCreditoController.class.getName()).log(Level.SEVERE, null, ex1);
            }

        } catch (Exception ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (IOException ex2) {
                Logger.getLogger(TarjetaCreditoController.class.getName()).log(Level.SEVERE, null, ex2);
            }

        }

    }

}
