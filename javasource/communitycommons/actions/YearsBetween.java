// This file was generated by Mendix Studio Pro.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package communitycommons.actions;

import java.util.Date;
import communitycommons.DateTime;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;

/**
 * Calculates the number of years between two dates. 
 * - dateTime : the original (oldest) dateTime
 * - compareDate: the second date. If EMPTY, the current datetime will be used. Effectively this means that the age of the dateTime is calculated.
 */
public class YearsBetween extends CustomJavaAction<java.lang.Long>
{
	private java.util.Date dateTime;
	private java.util.Date compareDate;

	public YearsBetween(IContext context, java.util.Date dateTime, java.util.Date compareDate)
	{
		super(context);
		this.dateTime = dateTime;
		this.compareDate = compareDate;
	}

	@java.lang.Override
	public java.lang.Long executeAction() throws Exception
	{
		// BEGIN USER CODE
		try {
			return DateTime.yearsBetween(this.dateTime, compareDate == null ? new Date() : compareDate);
		} catch (Exception e) {
			return -1L;
		}
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@java.lang.Override
	public java.lang.String toString()
	{
		return "YearsBetween";
	}

	// BEGIN EXTRA CODE

	// END EXTRA CODE
}
