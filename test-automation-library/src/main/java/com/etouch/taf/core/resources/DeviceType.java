/*
 * 
 */
package com.etouch.taf.core.resources;

// TODO: Auto-generated Javadoc
/**
 * The Enum DeviceType.
 */
public enum DeviceType {

	/** The Device. */
	Device("Device"),
	
	/** The Emulator. */
	Emulator("Emulator"),
	
	/** The Simulator. */
	Simulator("Simulator"),
	
	/** The i phone. */
	iPhone("iPhone"),
	
	/** The i pad. */
	iPad("iPad");
	
	/** The device type. */
	private String deviceType;
	
	/**
	 * Instantiates a new device type.
	 *
	 * @param type the type
	 */
	private DeviceType(String type){
		this.deviceType=type;
	}
	
	/**
	 * Gets the device type.
	 *
	 * @return the device type
	 */
	public String getDeviceType(){
		return deviceType;
	}
}
