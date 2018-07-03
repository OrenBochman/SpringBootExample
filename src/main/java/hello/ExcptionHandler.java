package hello;

import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import hello.user.ApplicationException;

@ControllerAdvice
@RequestMapping(produces = "application/vnd.error+json") 
public class ExcptionHandler {
	@ExceptionHandler(Throwable.class)
	public void //ResponseEntity<ApplicationException> 
	handleConflict(HttpServletResponse reponse, Throwable e) {
		if(e instanceof ApplicationException){
		}else {
			e.printStackTrace();
		}
		final String errorMessage = Optional.of(e.getLocalizedMessage()).orElse(e.getClass().getSimpleName());
		reponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		reponse.setHeader("errorMessage",errorMessage);
        //return new ResponseEntity <ApplicationException> notFoundException(e, HttpStatus.INTERNAL_SERVER_ERROR);

	}

}
