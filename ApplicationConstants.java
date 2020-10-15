import java.util.regex.Pattern;
import org.springframework.util.ObjectUtils;

public class ApplicationConstants {

	private ApplicationConstants() {
		// enforces singleton pattern
	}

	private static final String EMAIL_REGEX = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
	private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

	public static boolean isValidEmail(String email) {
		return ObjectUtils.isEmpty(email) ? false : EMAIL_PATTERN.matcher(email).matches();
	}

}
