/*
 * 
 */
package com.etouch.taf.tools.tfsclient.event;

import com.etouch.taf.util.LogUtil;
import com.microsoft.tfs.core.clients.versioncontrol.events.GetOperationStartedEvent;
import com.microsoft.tfs.core.clients.versioncontrol.events.OperationStartedEvent;
import com.microsoft.tfs.core.clients.versioncontrol.events.OperationStartedListener;
import com.microsoft.tfs.core.clients.versioncontrol.soapextensions.GetRequest;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;

// TODO: Auto-generated Javadoc
/**
 * The listener interface for receiving customGetOperationStarted events.
 * The class that is interested in processing a customGetOperationStarted
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addCustomGetOperationStartedListener<code> method. When
 * the customGetOperationStarted event occurs, that object's appropriate
 * method is invoked.
 *
 * @see CustomGetOperationStartedEvent
 */
public class CustomGetOperationStartedListener
    implements OperationStartedListener
{
	
	/** The log. */
	private static Log log = LogUtil.getLog(CustomGetOperationCompletedListener.class);
	
    /**
     * On get operation started.
     *
     * @param e the e
     */
    public void onGetOperationStarted(final GetOperationStartedEvent e)
    {
        for (GetRequest request : e.getRequests())
        {
            if (request.getItemSpec() != null)
            {
            	log.info("Started getting: " + request.getItemSpec().toString());
                //System.out.println("Started getting: " + request.getItemSpec().toString());
            }
        }
    }

    /* (non-Javadoc)
     * @see com.microsoft.tfs.core.clients.versioncontrol.events.OperationStartedListener#onOperationStarted(com.microsoft.tfs.core.clients.versioncontrol.events.OperationStartedEvent)
     */
    public void onOperationStarted(final OperationStartedEvent e)
    {
        if (e instanceof GetOperationStartedEvent)
        {
            onGetOperationStarted((GetOperationStartedEvent) e);
        }
    }
}
