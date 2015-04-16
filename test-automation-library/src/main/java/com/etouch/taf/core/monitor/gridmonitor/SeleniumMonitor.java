/*
 * 
 */
/*package com.etouch.taf.core.monitor.gridmonitor;
import com.etouch.taf.core.exception.MonitorException;
import com.etouch.taf.util.CommonUtil;
import com.etouch.taf.util.LogUtil;

import java.net.URL;

import org.apache.commons.logging.Log;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.entity.StringEntity;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.remote.internal.HttpClientFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;

import org.apache.http.message.BasicHttpEntityEnclosingRequest;
import org.apache.http.message.BasicHttpRequest;


// TODO: Auto-generated Javadoc
/**
 * SeleniumMonitor checks on the Selenium Availability and start/stop of server.
 * 
 * @author eTouch Systems Corporation
 * @version 1.0
 *
 */
/*public class SeleniumMonitor {
	
	/** The log. */
	/*private static Log log = LogUtil.getLog(SeleniumMonitor.class);
	
	/**
	 * Detects the hub is available or not.
	 *
	 * @param sHubURL the s hub url
	 * @return true, if is hub available
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	/*public boolean isHubAvailable(String sHubURL) throws IOException{
		URL hubURL = new URL(sHubURL);
        HttpClientFactory clientFactory = new HttpClientFactory();
        HttpClient client = clientFactory.getHttpClient();
        URL regUrl = null;
        String reg = String.format(
                "%s://%s%s%s",
                hubURL.getProtocol(),
                hubURL.getHost(),
                hubURL.getPort() != -1 ? ":" + hubURL.getPort()  : "",
                "/grid/register"
        );

        try {
            regUrl = new URL(reg);
        }catch (MalformedURLException me){
           	log.error("Hub URL is not specified or not well formed.");
            return false;
        }

        try{

            BasicHttpEntityEnclosingRequest r =
                    new BasicHttpEntityEnclosingRequest("POST", regUrl.toExternalForm());

           
		String json =
                    String.format(
                            "{" +
                            "  \"capabilities\": []," +
                            "  \"configuration\": {" +
                            "    \"port\": 0," +
                            "    \"register\": true," +
                            "    \"host\": \"%s\"," +
                            "    \"proxy\": \"org.openqa.grid.selenium.proxy.DefaultRemoteProxy\"," +
                            "    \"maxSession\": 0,\n" +
                            "    \"hubHost\": \"%s\"," +
                            "    \"role\": \"node\"," +
                            "    \"registerCycle\": 5000," +
                            "    \"hub\": \"%s\"," +
                            "    \"hubPort\": %d ," +
                            "    \"url\": \"http://%s\"," +
                            "    \"remoteHost\": \"http://%s\"" +
                            "  }\n" +
                            "}" ,
                            regUrl.getHost(),
                            regUrl.getHost(),
                            reg,
                            (regUrl.getPort() != -1 ? regUrl.getPort() : 2222 ),
                            regUrl.getHost(),
                            regUrl.getHost()
                            
                    );
		
     
		CommonUtil.sop("\n\n"+json);

		r.setEntity(new StringEntity(json));

		HttpHost host = new HttpHost(regUrl.getHost(), regUrl.getPort());

		HttpResponse response = client.execute(host, r);

		CommonUtil.sop("\n\n"+response.toString());
		if (response.getStatusLine().getStatusCode() != 200) {
			throw new RuntimeException("Error sending the registration request.");
		}
		System.out.println("Hub is available " + hubURL.toString());
		
        	} catch (Exception e) {
            e.printStackTrace();
            CommonUtil.sop("Hub is unavailable "+ hubURL.toString());
            return false;
        } finally {
            clientFactory.close();
        }

        return true;
    }
	
	/**
	 * Detects if the node is available or not.
	 *
	 * @param strHubURL - URL to the Hub (Ex. <a href="http://localhost:5555" rel="nofollow">http://localhost:5555</a>)
	 * @param strNodeURl - URL to the Node
	 * @return true, if is node available
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	/*public boolean isNodeAvailable(String strHubURL, String strNodeURl) throws IOException{
		URL hubURL = new URL(strHubURL);
		URL nodeURL = new URL(strNodeURl);
        HttpClientFactory clientFactory = new HttpClientFactory();
        HttpClient client = clientFactory.getHttpClient();
        URL regUrl = null;
        String reg = String.format(
                "%s://%s%s%s",
                hubURL.getProtocol(),
                hubURL.getHost(),
                hubURL.getPort() != -1 ? ":" + hubURL.getPort()  : "",
                "/grid/api/proxy"
        );
        
        System.out.println(reg);
        
        try {
            regUrl = new URL(reg);
        }catch (MalformedURLException me){
            CommonUtil.sop("Node URL is not specified or not well formed.");
            return false;
        }
        
        try{

        	BasicHttpRequest r =
                    new BasicHttpRequest("GET", regUrl.toExternalForm() + "?id=" + strNodeURl);
            
            HttpHost host = new HttpHost(regUrl.getHost(), regUrl.getPort());

    		HttpResponse response = client.execute(host, r);

    		CommonUtil.sop("\n\n"+response.toString());
    		if (response.getStatusLine().getStatusCode() != 200) {
    			throw new RuntimeException("Error in requesting node information.");
    		}
    		JSONObject res = extractObject(response);
    		if(!res.has("id") || (res.has("id") && !res.get("id").toString().equals(strNodeURl))){
    			throw new RuntimeException("Error in requesting node information.");
    		}
    		CommonUtil.sop("Node is available " + nodeURL.toString());
    		
        } catch (Exception e) {
            e.printStackTrace();
            CommonUtil.sop("Node is unavailable "+ nodeURL.toString());
            return false;                   
        } finally {
            clientFactory.close();
        }
        
        return true;
	}
	
	/**
	 * ssh to a remote machine and run a cmd to start selenium
	 * In order to run cmd from windows cmd line, use: Runtime.getRuntime().exec(new String[]{"cmd.exe", "/c", "start", fileName})
	 * In order to run cmd from cygwin: Runtime.getRuntime().exec(new String[]{"c:\\cygwin64\\bin\\ssh.exe", remotehost, fileName})
	 *
	 * @param remotehost - URL to host (eg: root@ipaddress)
	 * @param setupCmd - cmd or batch/script file
	 * @param machine - name of machine (eg: http://localhost:4444)
	 * @throws MonitorException the monitor exception
	 */	
	/*public void runSelOnRemoteMachine(String remotehost, String setupCmd, String machine) throws MonitorException{
		try{
			Process pr = Runtime.getRuntime().exec(new String[]{"ssh", remotehost, setupCmd});
		}catch (NullPointerException ex) {
			throw new MonitorException("failed to start " + machine + ", message : " + ex.toString());
		}catch (IndexOutOfBoundsException ex) {
			throw new MonitorException("failed to start " + machine + ", message : " + ex.toString());
		} catch (IOException ex) {
			throw new MonitorException("failed to start " + machine + ", message : " + ex.toString());
		}
	}
	
	/**
	 * In case of delay loop until either hub is available or end of loop condition.
	 *
	 * @param hubURL - URL to the Hub
	 * @param sleepTime - sleep time
	 * @return true, if successful
	 * @throws MonitorException the monitor exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	/*public boolean waitUntilHubAvailable(String hubURL, long sleepTime ) throws MonitorException, IOException{
		for(int i=0;i<10;i++){
			if(isHubAvailable(hubURL)){
				return true;
			}else{
				try{
					Thread.sleep(sleepTime);
				}catch (InterruptedException ex){
					System.err.println(ex.getMessage());						
				}
			}
		}
		return false;
	}

	/**
	 * In case of delay loop until all nodes are available or end of loop condition.
	 *
	 * @param hubURL - URL to the Hub
	 * @param nodeURLs - array of node URLs
	 * @param sleepTime - sleep time
	 * @return true, if successful
	 * @throws MonitorException the monitor exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */	
	/*public boolean waitUntilNodesAvailable(String hubURL, String[] nodeURLs, long sleepTime ) throws MonitorException, IOException{
		//TODO: add a class variable which will hold the error msg that specifies which node has failed.
		boolean avail;
		for(String nurl: nodeURLs){
			avail = false;
			for(int i=0;i<10;i++){
				if(isNodeAvailable(hubURL, nurl)){
					avail = true;
					break;
				}else{
					try{
						Thread.sleep(sleepTime);
					}catch (InterruptedException ex){
						System.err.println(ex.getMessage());						
					}
				}
			}
			if(!avail){
				return false;
			}			
		}
		return true;
	}
	
	/**
	 * Extract JSON object from the HttpResponse.
	 *
	 * @param resp - HttpResponse
	 * @return JSONObject
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws JSONException the JSON exception
	 */	
	/*private JSONObject extractObject(HttpResponse resp) throws IOException, JSONException {
	    BufferedReader rd = new BufferedReader(new InputStreamReader(resp.getEntity().getContent()));
	    StringBuilder s = new StringBuilder();
	    String line;
	    while ((line = rd.readLine()) != null) {
	      s.append(line);
	    }
	    rd.close();
	    return new JSONObject(s.toString());
	  }
	
}*/
