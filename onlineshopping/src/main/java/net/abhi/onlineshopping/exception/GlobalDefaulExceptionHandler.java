package net.abhi.onlineshopping.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaulExceptionHandler {

	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException() {
              ModelAndView mv = new ModelAndView("error");
              
              mv.addObject("errorTitle", "The Page is not Constructed yet !!");
              mv.addObject("errorDescription", "The Page you are looking for is not vailable now");
              
              mv.addObject("title", "404 error page");
              return mv;
	}
	
	@ExceptionHandler(ProductNotFindException.class)
	public ModelAndView handlerProductNotFindException() {
              ModelAndView mv = new ModelAndView("error");
              
              mv.addObject("errorTitle", "The Product is not available yet !!");
              mv.addObject("errorDescription", "Sorry for the inconveinience.");
              
              mv.addObject("title", "404 error page");
              return mv;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception ex) {
              ModelAndView mv = new ModelAndView("error");
              
              //TO print whole stack trace of exception 
            /*  StringWriter sw = new StringWriter();
              PrintWriter pw =new PrintWriter(sw);
              ex.printStackTrace(pw);*/
              
              mv.addObject("errorTitle", "Contact Your Administrator");
              mv.addObject("errorDescription", ex.toString());
              
              mv.addObject("title", "Error");
              return mv;
	}
}
