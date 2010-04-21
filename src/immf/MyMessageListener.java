package immf;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.subethamail.smtp.RejectException;
import org.subethamail.smtp.TooMuchDataException;

public interface MyMessageListener {
	/**
	 * Called once for every RCPT TO during a SMTP exchange.  Each accepted recipient
	 * will result in a separate deliver() call later.
	 *
	 * @param from is a rfc822-compliant email address.
	 * @param recipient is a rfc822-compliant email address.
	 *
	 * @return true if the listener wants delivery of the message, false if the
	 *         message is not for this listener.
	 */
	public boolean accept(String from, String recipient);

	/**
	 * When message data arrives, this method will be called for every recipient
	 * this listener accepted.
	 *
	 * @param from is the envelope sender in rfc822 form
	 * @param recipient will be an accepted recipient in rfc822 form
	 * @param data will be the smtp data stream, stripped of any extra '.' chars.  The
	 * 			data stream is only valid for the duration of this call.
	 *
	 * @throws TooMuchDataException if the listener can't handle that much data.
	 *         An error will be reported to the client.
	 * @throws IOException if there is an IO error reading the input data.
	 */
	public void deliver(String from, List<String> recipient, InputStream data)
			throws TooMuchDataException, RejectException,IOException;
}
