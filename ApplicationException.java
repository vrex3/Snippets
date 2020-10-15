package org.vrex.sprint.rngesus.util;

import org.springframework.http.HttpStatus;

public class ApplicationException extends RuntimeException {

	private static final long serialVersionUID = 8159934445993571899L;

	private String errorMessage;
	private HttpStatus status;

	private ApplicationException(ExceptionBuilder builder) {
		this.errorMessage = builder.errorMessage;
		this.status = builder.status;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public static class ExceptionBuilder {

		private String errorMessage;
		private HttpStatus status;

		public ExceptionBuilder setErrorMessage(String errorMessage) {
			this.errorMessage = errorMessage;
			return this;
		}

		public ExceptionBuilder setStatus(HttpStatus status) {
			this.status = status;
			return this;
		}

		public ApplicationException build() {
			return new ApplicationException(this);
		}
	}

}
