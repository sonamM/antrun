/*
 * 
 */
package com.etouch.taf.tools.tfsclient;
 
import com.etouch.taf.core.TestBedManager;
import com.etouch.taf.core.config.TFSConfig;
import com.etouch.taf.tools.rally.Rally;
import com.etouch.taf.util.LogUtil;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;

import com.microsoft.tfs.core.TFSTeamProjectCollection;
import com.microsoft.tfs.core.clients.build.IBuildServer;
import com.microsoft.tfs.core.httpclient.Credentials;
import com.microsoft.tfs.core.httpclient.DefaultNTCredentials;
import com.microsoft.tfs.core.httpclient.UsernamePasswordCredentials;
import com.microsoft.tfs.core.util.CredentialsUtils;
import com.microsoft.tfs.core.util.URIUtils;
 
// TODO: Auto-generated Javadoc
/**
 * The Class ConsoleConnection.
 *
 * @author ngoctran
 */
public class ConsoleConnection
{
	
	/** The log. */
	private static Log log = LogUtil.getLog(ConsoleConnection.class);




	/** The tfs config. */
	protected static TFSConfig tfsConfig = TestBedManager.INSTANCE.getTFSConfig();
	
	
	
	 
    /**
     * The URL to a TFS project collection, including virtual directory and
     * collection name (like "http://server:8080/tfs/DefaultCollection").
     */
    protected static String COLLECTION_URL = tfsConfig.getCollectionURL(); 
    
    

    /*
     * Authentication information. HTTP_PROXY_URL should be set to null if none
     * is desired.
     */

    /** The username. */
    protected static String USERNAME = tfsConfig.getUserName();
    
    /** The password. */
    protected static String PASSWORD =tfsConfig.getPassword();
     

    /**
     * A team project name (without the leading "$/") where files, work items,
     * and builds can be created and modified.
     */
    protected static String PROJECT_NAME = tfsConfig.getProjectName();

    /**
     * Set this to a writable TFS server folder (like "$/TeamProject/folder")
     * where you can create and modify files. To run {@link BuildSample} and
     * {@link GatedBuildSample}, this directory must contain a project that can
     * be built using the files in the {@link #BUILD_CONFIG_FOLDER_PATH} folder
     * path below.
     */
    protected static String MAPPING_SERVER_PATH =  tfsConfig.getMappingServerPath();

    /**
     * Set this to a writable local path (Windows or Unix style absolute path)
     * that will be mapped to {@link #MAPPING_SERVER_PATH}. Used for
     * {@link VersionControlSample}, {@link BuildSample}, and
     * {@link GatedBuildSample}.
     */
    protected static String MAPPING_LOCAL_PATH =  tfsConfig.getMappingLocalPath();
 
    /** The workspace name. */
    protected static String WORKSPACE_NAME =  tfsConfig.getWorkspaceName();
    
    /** The max reconnections. */
    protected static int MAX_RECONNECTIONS =  tfsConfig.getMaxReconections();
 
    /**
     * Connect to TFS using a set of credentials that uses the currently logged
     * user in case no user name was provided otherwise it uses the provided
     * credentials.
     *
     * @return The Team Project Collection connected to
     * @throws Exception the exception
     */
    public static TFSTeamProjectCollection connectToTFS() throws Exception {
 
    	log.debug("connectToTFS");
    	//System.out.println("TFS_JNI_NATIVE path is: " + tfsConfig.);
    	if ( System.getProperty("com.microsoft.tfs.jni.native.base-directory") == null ) {
    		System.setProperty("com.microsoft.tfs.jni.native.base-directory", tfsConfig.getJniNativeBaseDir());
    	}
 
        Credentials credentials;

        // In case no username is provided and the current platform supports
        // default credentials, use default credentials
        if ((USERNAME == null || USERNAME.length() == 0) && CredentialsUtils.supportsDefaultCredentials()) {
            credentials = new DefaultNTCredentials();
        }
        else {
            credentials = new UsernamePasswordCredentials(USERNAME, PASSWORD);
        }
      	  
    	TFSTeamProjectCollection tpc = new TFSTeamProjectCollection(URIUtils.newURI(COLLECTION_URL), credentials);
    	//Check if the build server version is supported
        if (isLessThanV3BuildServer(tpc.getBuildServer()))
         {
         	 
            throw new Exception("Less then V3BuildServer");
         }
         
	  
        return tpc;
    }

    /**
     * Checks if the build server version is older than TFS2010 and prints an
     * error message.
     *
     * @param buildServer        The build server to check its version
     * @return boolean true if the build server is older than TFS2010, false
     *         otherwise
     */
    public static boolean isLessThanV3BuildServer(IBuildServer buildServer)
    {
        if (buildServer.getBuildServerVersion().isLessThanV3())
        {
            log.warn("This sample does not support TFS servers older than TFS2010");
            return true;
        }
        return false;
    }
 
    
}
