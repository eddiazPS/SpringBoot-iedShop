package co.com.ied.shop.iedshop.exception;
import co.com.ied.shop.iedshop.models.DTO.ErrorResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class RestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponseDTO> handlerException (DataNotFoundException exc){

        HttpStatus code =  HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(respuestaGenericaError(exc, code) , code);
    }

    private ErrorResponseDTO respuestaGenericaError (Throwable ex , HttpStatus code , String msj){
        return respuestaMsj(ex,code,msj);
    }

    private ErrorResponseDTO respuestaGenericaError (Throwable ex , HttpStatus code){
        return respuestaMsj(ex,code,"");

    }

    private ErrorResponseDTO respuestaMsj(Throwable ex , HttpStatus code , String msj){
        ErrorResponseDTO error = new ErrorResponseDTO();
        error.setStatus(code.value());
        error.setMessage(ex.getMessage().concat(ex.getCause() == null?"":" - "+ex.getCause().getMessage()+msj == ""? "" :" - "+msj) );
        error.setTimeStamp(System.currentTimeMillis());
      //  log.error("*********** Ocurrio una Excepcion, code: "+code+" Mensaje :"+error.getMessage()+" ####StackTrace: "+ex.getStackTrace().toString());
        return error;
    }

}
