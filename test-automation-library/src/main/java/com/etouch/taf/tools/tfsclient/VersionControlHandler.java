/*
 * 
 */
package com.etouch.taf.tools.tfsclient;
 
import java.io.File;
import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;

import com.microsoft.tfs.core.TFSTeamProjectCollection;
import com.microsoft.tfs.core.clients.versioncontrol.GetOptions;
import com.microsoft.tfs.core.clients.versioncontrol.PendChangesOptions;
import com.microsoft.tfs.core.clients.versioncontrol.WorkspaceLocation;
import com.microsoft.tfs.core.clients.versioncontrol.WorkspacePermissionProfile;
import com.microsoft.tfs.core.clients.versioncontrol.exceptions.CheckinException;
import com.microsoft.tfs.core.clients.versioncontrol.exceptions.ServerPathFormatException;
import com.microsoft.tfs.core.clients.versioncontrol.path.LocalPath;
import com.microsoft.tfs.core.clients.versioncontrol.soapextensions.Changeset;
import com.microsoft.tfs.core.clients.versioncontrol.soapextensions.GetRequest;
import com.microsoft.tfs.core.clients.versioncontrol.soapextensions.LockLevel;
import com.microsoft.tfs.core.clients.versioncontrol.soapextensions.PendingChange;
import com.microsoft.tfs.core.clients.versioncontrol.soapextensions.PendingSet;
import com.microsoft.tfs.core.clients.versioncontrol.soapextensions.RecursionType;
import com.microsoft.tfs.core.clients.versioncontrol.soapextensions.WorkingFolder;
import com.microsoft.tfs.core.clients.versioncontrol.soapextensions.Workspace;
import com.microsoft.tfs.core.clients.versioncontrol.specs.ItemSpec;
import com.microsoft.tfs.core.clients.versioncontrol.specs.version.LatestVersionSpec;
import com.microsoft.tfs.core.exceptions.TECoreException;
import com.microsoft.tfs.core.util.FileEncoding;
import com.etouch.taf.tools.tfsclient.event.*;
import com.etouch.taf.util.LogUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class VersionControlHandler.
 *
 * @author ngoctran
 */
public class VersionControlHandler {
	
	/** The log. */
	private static Log log = LogUtil.getLog(VersionControlHandler.class);
 
	/** The encoding. */
	public static FileEncoding ENCODING = null;
	
    /**
     * Clone project from tfs.
     */
    public static void cloneProjectFromTFS()
    {
    	try {
     
	    	TFSTeamProjectCollection tpc = getTFSTeamProjectCollection();
	        if ( tpc != null) {
		        // Create and map a new workspace
	        	Workspace workspace	= createAndMapWorkspace(tpc);
		         
		
		        // Listen to the get event
		        addGetEventListeners(tpc);
		
		        // Get latest on a project
		        getLatest(workspace);
		        
		        // checkout a file
		        //final File newFile = new File(ConsoleConnection.MAPPING_LOCAL_PATH, "TestProject1/src/com/etouch/tfs/SampleAppFile");
		        //checkoutFromTFS(workspace, newFile, "checkout file");
		        
		        // Do some pending changes
		        //checkinPendingChanges(workspace,"checkin");
 
		        // View history on the branched file
		        //displayFileHistory(workspace, branchFile);
		
		        // Delete the workspace for clean up
		        //tpc.getVersionControlClient().deleteWorkspace(workspace);
		        //System.out.println("Deleted the workspace");
	        }
	    }catch(Exception ex) {
	    	log.error(ex.getMessage(), ex);
	    }
    }
    
    /**
     * Gets the TFS team project collection.
     *
     * @return the TFS team project collection
     * @throws Exception the exception
     */
    public static TFSTeamProjectCollection getTFSTeamProjectCollection() throws Exception {
    	TFSTeamProjectCollection tpc = null;
    	 
    	int i = 0;
    	int maxReConnections = ConsoleConnection.MAX_RECONNECTIONS;
    	
    	while ( i < maxReConnections) { 
	    	try { 
	    	    // Connect to TFS
    			tpc = ConsoleConnection.connectToTFS();
    			
    			i = maxReConnections;
	    	}catch(TECoreException ex) {
	    		i++;
	    		try {
                    Thread.sleep(5000); //milliseconds  
	    		} catch (InterruptedException e) {
	    		}
	    		
	    		log.error(ex.getMessage(), ex);
	    	} catch(Exception ex) {
	    		i=maxReConnections;
	    		log.error(ex.getMessage(), ex);
	    	}
    	}
        return tpc;
    }
    
    /**
     * Creates the and map workspace.
     *
     * @param tpc the tpc
     * @return the workspace
     */
    public static Workspace createAndMapWorkspace(final TFSTeamProjectCollection tpc)
    {
        final String workspaceName = ConsoleConnection.WORKSPACE_NAME; //+ System.currentTimeMillis();
     
        // Get the workspace
        Workspace workspace = tpc.getVersionControlClient().tryGetWorkspace(ConsoleConnection.MAPPING_LOCAL_PATH);

        // Create and map the workspace if it does not exist
        if (workspace == null)
        {
            workspace =
                tpc.getVersionControlClient().createWorkspace(
                    null,
                    workspaceName,
                    "Workspace comment",
                    WorkspaceLocation.SERVER,
                    null,
                    WorkspacePermissionProfile.getPrivateProfile());

            // Map the workspace
            WorkingFolder workingFolder =
                new WorkingFolder(
                    ConsoleConnection.MAPPING_SERVER_PATH,
                    LocalPath.canonicalize(ConsoleConnection.MAPPING_LOCAL_PATH));
            workspace.createWorkingFolder(workingFolder);
        }
        else {
        	log.debug("workspace already exist");
        }

        log.info("Workspace '" + workspaceName + "' now exists and is mapped");

        return workspace;
    }

    /**
     * Adds the get event listeners.
     *
     * @param tpc the tpc
     */
    public static void addGetEventListeners(final TFSTeamProjectCollection tpc)
    {
        // Adding a get operation started event listener, this is fired once per
        // get call
        CustomGetOperationStartedListener getOperationStartedListener = new CustomGetOperationStartedListener();
        tpc.getVersionControlClient().getEventEngine().addOperationStartedListener(getOperationStartedListener);

        // Adding a get event listener, this fired once per get operation(which
        // might be multiple times per get call)
        CustomGetEventListener getListener = new CustomGetEventListener();
        tpc.getVersionControlClient().getEventEngine().addGetListener(getListener);

        // Adding a get operation completed event listener, this is fired once
        // per get call
        CustomGetOperationCompletedListener getOperationCompletedListener = new CustomGetOperationCompletedListener();
        tpc.getVersionControlClient().getEventEngine().addOperationCompletedListener(getOperationCompletedListener);
    }
    
    /**
     * Gets the latest.
     *
     * @param workspace the workspace
     * @return the latest
     */
    public static void getLatest(final Workspace workspace)
    {
        ItemSpec spec = new ItemSpec(ConsoleConnection.MAPPING_LOCAL_PATH, RecursionType.FULL);
        GetRequest request = new GetRequest(spec, LatestVersionSpec.INSTANCE);
        
        workspace.get(request, GetOptions.OVERWRITE);
    }
 
    /**
     * Checkin pending changes.
     *
     * @param workspace the workspace
     * @param comment the comment
     * @return the int
     */
    public static int checkinPendingChanges(final Workspace workspace, final String comment)
    {
    	log.debug("checkin pending changes");
        PendingSet pendingSet = workspace.getPendingChanges();
        int cs = 0;

        if (pendingSet != null)
        {
            PendingChange[] pendingChanges = pendingSet.getPendingChanges();
            if (pendingChanges != null)
            {
                try {
                	cs = workspace.checkIn(pendingChanges, comment);
                }
                catch(CheckinException ex) {
                	log.error(ex.getMessage(),ex);
                	//if ( ex.getMessage().contains("No files checked in due to conflicting changes")) {	
                	//}
                	
                }
            }

        }

        return cs;
    }
    
    /**
     * Checkout from tfs.
     *
     * @param workspace the workspace
     * @param file the file
     * @param comment the comment
     * @return the int
     */
    public static int checkoutFromTFS(final Workspace workspace, File file, final String comment)
    {
    	log.debug("checkout from TFS");
        //PendingSet pendingSet = workspace.getPendingChanges();
        int cs = 0;

        // if (pendingSet != null)
        // {
          //   PendingChange[] pendingChanges = pendingSet.getPendingChanges();
             
          //  if (pendingChanges != null) {
             // Pend edit
            	log.debug("pending changes");
	            ItemSpec fileSpec = new ItemSpec(file.getAbsolutePath(), RecursionType.NONE);
	             
	            cs = workspace.pendEdit(new ItemSpec[]
	            		{
	            			fileSpec
	            		}
	             , LockLevel.UNCHANGED, ENCODING, GetOptions.NONE, PendChangesOptions.GET_LATEST_ON_CHECKOUT);
	
	      // }
        // }
     
        return cs;
    }

    /**
     * Display file history.
     *
     * @param workspace the workspace
     * @param file the file
     */
    public static void displayFileHistory(final Workspace workspace, final File file)
    {
    	log.debug("History for file " + file.getAbsolutePath());

        Changeset[] cs = null;
        try
        {
            cs =
                workspace.queryHistory(
                    file.getCanonicalPath(),
                    LatestVersionSpec.INSTANCE,
                    0,
                    RecursionType.NONE,
                    null,
                    null,
                    LatestVersionSpec.INSTANCE,
                    Integer.MAX_VALUE,
                    true,
                    false,
                    false,
                    false);
        }
        catch (ServerPathFormatException e)
        {

            e.printStackTrace();
        }
        catch (IOException e)
        {

            e.printStackTrace();
        }

        for (Changeset changeset : cs)
        {
        	log.debug("CS#:"
                + changeset.getChangesetID()
                + " ChangeType:"
                + changeset.getChanges()[0].getChangeType().toUIString(true, changeset.getChanges()[0]));

        }
    }

    
}
 
