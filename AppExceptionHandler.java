import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.vrex.sprint.rngesus.dto.Message;
import org.vrex.sprint.rngesus.util.ApplicationException;

@ControllerAdvice
public class AppExceptionHandler {

	private static final String GENERIC_ERROR_MESSAGE = "Something went wrong";

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Message> handleGenericException(Exception exception) {
		exception.printStackTrace();
		return new ResponseEntity<Message>(new Message.MessageBuilder().setText(GENERIC_ERROR_MESSAGE).build(),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(ApplicationException.class)
	public ResponseEntity<Message> handleCustomException(ApplicationException exception) {
		System.out.println(exception.getStatus() + " : " + exception.getErrorMessage());
		return new ResponseEntity<Message>(
				new Message.MessageBuilder().setText(GENERIC_ERROR_MESSAGE).setData(exception).build(),
				exception.getStatus() != null ? exception.getStatus() : HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
