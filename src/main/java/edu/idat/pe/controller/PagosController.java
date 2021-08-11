package edu.idat.pe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.idat.pe.model.Pagos;
import edu.idat.pe.model.response.ResultadoResponse;
import edu.idat.pe.repository.PagosRepository;
import edu.idat.pe.service.PagosService;

@Controller
@RequestMapping("/Pagar")
public class PagosController {
@Autowired
 private PagosService pagosService;

@PostMapping("/registrarPago")
@ResponseBody
public ResultadoResponse guardarPagos(@RequestBody Pagos objCurso) {
    String mensaje = "Pago registrado correctamente";
    Boolean respuesta = true;
    try {
    	pagosService.guardarPagos(objCurso);
    }catch(Exception ex) {
        mensaje = "Pago registrado correctamente";
        respuesta = false;
    }
    return new ResultadoResponse(respuesta, mensaje);
}
}
