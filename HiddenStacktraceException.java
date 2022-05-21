/**
 * This class helps to throw exceptions without stack of traces shown to the
 * users. It extends exception.
 * 
 * @author ChangSu Nam
 * @UNI cn2521
 * @since Assignment 2 2.1
 */
public class HiddenStacktraceException extends Exception {

	/**
	 * 
	 * @param message            the error message
	 * @param suppressStacktrace true when trace should be hidden, false when trace
	 *                           is to be shown.
	 */
	public HiddenStacktraceException(String message, boolean suppressStacktrace) {
		super(message, null, suppressStacktrace, !suppressStacktrace);
		this.suppressStacktrace = suppressStacktrace;
	}

	@Override
	public String toString() {
		if (suppressStacktrace) {
			return getLocalizedMessage();
		} else {
			return super.toString();
		}
	}

	/**
	 * suppressStacktrace the boolean flag to determine whether traces are shown or
	 * not.
	 */
	private boolean suppressStacktrace = false;
}