/*
 * 
 */
package com.etouch.taf.tools.tfsclient.event;

import com.etouch.taf.tools.tfsclient.VersionControlHandler;
import com.etouch.taf.util.LogUtil;
import com.microsoft.tfs.core.clients.versioncontrol.events.GetEvent;
import com.microsoft.tfs.core.clients.versioncontrol.events.GetListener;
 

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;

// TODO: Auto-generated Javadoc
/**
 * The listener interface for receiving customGetEvent events.
 * The class that is interested in processing a customGetEvent
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addCustomGetEventListener<code> method. When
 * the customGetEvent event occurs, that object's appropriate
 * method is invoked.
 *
 * @see CustomGetEventEvent
 */
public class CustomGetEventListener implements GetListener
{
	
	/** The log. */
	private static Log log = LogUtil.getLog(CustomGetEventListener.class);
	
    /* (non-Javadoc)
     * @see com.microsoft.tfs.core.clients.versioncontrol.events.GetListener#onGet(com.microsoft.tfs.core.clients.versioncontrol.events.GetEvent)
     */
    public void onGet(final GetEvent e)
    {
        String item = e.getTargetLocalItem() != null ? e.getTargetLocalItem() : e.getServerItem();
        log.info("getting: " + item);
        //System.out.println("getting: " + item);
    }
}
