package com.flyrui.exception;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.rmi.RemoteException;

public class FRException extends Exception {
	private Throwable cause;
	private FRError error;

	public FRException(FRError paramFRError) {
		this.error = paramFRError;
	}

	public FRException(FRError frError, String errorMessage) {
		super(errorMessage);
		this.error = frError;
	}

	public FRException(FRError frError, Throwable throwable) {
		super(throwable.getMessage());
		this.cause = throwable;
		this.error = frError;
	}

	public FRException(FRError frError, String paramString, Throwable throwable) {
		super(paramString);
		if (throwable instanceof RemoteException) {
			this.cause = ((RemoteException) throwable).detail;
		} else {
			this.cause = throwable;
		}
		this.error = frError;
	}

	public Throwable getCause() {
		return this.cause;
	}

	public FRError getError() {
		return this.error;
	}

	public String getMessage() {
		StringBuffer sb = new StringBuffer((getError() == null) ? ""
				: getError().toString());

		sb.append(" ");
		String str = super.getMessage();
		if (str != null) {
			sb.append(str);
		} else if (getCause() != null) {
			sb.append(getCause().getMessage());
		}
		return sb.toString();
	}

	public String toString() {
		return getMessage();
	}

	public final void printStackTrace() {
		printStackTrace(System.err);
	}

	public final String getStackTraceAsString() {
		StringWriter localStringWriter = new StringWriter();
		PrintWriter localPrintWriter = new PrintWriter(localStringWriter);
		printStackTrace(localPrintWriter);
		return localStringWriter.toString();
	}

	public final void printStackTrace(PrintStream printStream) {
		Throwable localThrowable = getCause();
		if (localThrowable == null)
			super.printStackTrace(printStream);
		while (true) {
			if (localThrowable == null)
				return;
			if (localThrowable instanceof FRException) {
				localThrowable = ((FRException) localThrowable).getCause();
			}
			if (localThrowable instanceof RemoteException) {
				localThrowable = ((RemoteException) localThrowable).detail;
			} else {
				break;
			}
		}

		localThrowable.printStackTrace(printStream);
	}

	public final void printStackTrace(PrintWriter paramPrintWriter) {
		Throwable localThrowable = getCause();
		if (localThrowable == null)
			super.printStackTrace(paramPrintWriter);
		while (true) {
			if (localThrowable == null)
				return;
			if (localThrowable instanceof FRException) {
				localThrowable = ((FRException) localThrowable).getCause();
			}
			if (localThrowable instanceof RemoteException) {
				localThrowable = ((RemoteException) localThrowable).detail;
			} else {
				break;
			}
		}

		localThrowable.printStackTrace(paramPrintWriter);
	}

	public static void main(String[] paramArrayOfString) {
		Exception localException1 = new Exception("exception");
		Exception localException2 = new Exception("exception2", localException1);
		Exception localException3 = new Exception("exception2", localException2);
		FRException localUOSException = new FRException(new FRError(
				"ORDER_ERR000"));
		System.out.println(localUOSException.getMessage());
	}
}