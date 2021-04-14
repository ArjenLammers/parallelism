// This file was generated by Mendix Studio Pro.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package parallelism.actions;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import com.mendix.core.Core;
import com.mendix.core.CoreException;
import com.mendix.logging.ILogNode;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;
import parallelism.implementation.Parallelism;
import com.mendix.systemwideinterfaces.core.IMendixObject;

public class GetMfAsyncResult extends CustomJavaAction<IMendixObject>
{
	private IMendixObject __future;
	private parallelism.proxies.Future future;
	private java.lang.Long timeout;
	private java.lang.String resultEntity;

	public GetMfAsyncResult(IContext context, IMendixObject future, java.lang.Long timeout, java.lang.String resultEntity)
	{
		super(context);
		this.__future = future;
		this.timeout = timeout;
		this.resultEntity = resultEntity;
	}

	@java.lang.Override
	public IMendixObject executeAction() throws Exception
	{
		this.future = __future == null ? null : parallelism.proxies.Future.initialize(getContext(), __future);

		// BEGIN USER CODE
		Future<Object> future = Parallelism.getFutures(getContext()).get(this.future.getReference());
		
		if (future == null) {
			throw new CoreException("Expected a Future for " + this.future.getReference() + " but none was found!");
		}
		
		Object result;
		if (this.timeout == null || this.timeout == 0L) {
			result = future.get();
		} else {
			result = future.get(this.timeout, TimeUnit.MILLISECONDS);
		}
		
		if (result == null) {
			return null;
		} else if (result instanceof IMendixObject) {
			return (IMendixObject) result;
		} else {
			throw new CoreException("Microflow returned a (yet) unimplemented result: " + result.toString());
		}
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@java.lang.Override
	public java.lang.String toString()
	{
		return "GetMfAsyncResult";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}
