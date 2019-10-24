package ar.com.quidproalg.ws.rest.restService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ar.com.quidproalg.ws.rest.vo.VOUsuario;



@Path("/Algas")
public class ServiceLogInAlgas {
	@POST
	@Path("/validaUsuario")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public VOUsuario validaUsuario(VOUsuario pVo){
		pVo.setValido(false);
		if(pVo.getUsuario().equals("gcasas") && pVo.getPassword().equals("algo"))
			pVo.setValido(true);
		return pVo;
	}

}