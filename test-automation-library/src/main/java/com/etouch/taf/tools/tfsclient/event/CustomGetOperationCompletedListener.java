/*
 * 
 */
package com.etouch.taf.tools.tfsclient.event;

import com.etouch.taf.util.LogUtil;
import com.microsoft.tfs.core.clients.versioncontrol.events.GetOperationCompletedEvent;
import com.microsoft.tfs.core.clients.versioncontrol.events.OperationCompletedEvent;
import com.microsoft.tfs.core.clients.versioncontrol.events.OperationCompletedListener;
import com.microsoft.tfs.core.clients.versioncontrol.soapextensions.GetRequest;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;

// TODO: Auto-generated Javadoc
/**
 * The listener interface for receiving customGetOperationCompleted events.
 * The class that is interested in processing a customGetOperationCompleted
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addCustomGetOperationCompletedListener<code> method. When
 * the customGetOperationCompleted event occurs, that object's appropriate
 * method is invoked.
 *
 * @see CustomGetOperationCompletedEvent
 */
public class CustomGetOperationCompletedListener
    implements OperationCompletedListener
{
	
	/** The log. */
	private static Log log = LogUtil.getLog(CustomGetOperationCompletedListener.class);
	
    /**
     * On get operation completed.
     *
     * @param e the e
     */
    public void onGetOperationCompleted(final GetOperationCompletedEvent e)
    {
        for (GetRequest request : e.getRequests())
        {
            if (request.getItemSpec() != null)
            {
            	log.info("Completed getting: " + request.getItemSpec().toString());
                //System.out.println("Completed getting: " + request.getItemSpec().toString());
            }
        }
    }

    /* (non-Javadoc)
     * @see com.microsoft.tfs.core.clients.versioncontrol.events.OperationCompletedListener#onOperationCompleted(com.microsoft.tfs.core.clients.versioncontrol.events.OperationCompletedEvent)
     */
    public void onOperationCompleted(final OperationCompletedEvent e)
    {
        if (e instanceof GetOperationCompletedEvent)
        {
            onGetOperationCompleted((GetOperationCompletedEvent) e);
        }
    }
}
