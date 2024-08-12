// This file was generated by Mendix Studio Pro.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package communitycommons.actions;

import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;
import com.mendix.webui.FeedbackHelper;

/**
 * Refreshes a certain domain object type in the client. Useful to enforce a datagrid to refresh for example.
 * 
 * -objectType : Type of the domain objects to refresh, such as System.User or MyModule.MyFirstEntity.
 *  (you can use getTypeAsString to determine this dynamically, so that the invoke of this action is not be sensitive to domain model changes).
 */
public class refreshClass extends CustomJavaAction<java.lang.Boolean>
{
	private java.lang.String objectType;

	public refreshClass(IContext context, java.lang.String objectType)
	{
		super(context);
		this.objectType = objectType;
	}

	@java.lang.Override
	public java.lang.Boolean executeAction() throws Exception
	{
		// BEGIN USER CODE
		FeedbackHelper.addRefreshClass(this.getContext(), objectType);
		return true;
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 * @return a string representation of this action
	 */
	@java.lang.Override
	public java.lang.String toString()
	{
		return "refreshClass";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}
