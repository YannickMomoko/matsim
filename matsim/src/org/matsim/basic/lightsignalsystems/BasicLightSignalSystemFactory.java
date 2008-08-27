/* *********************************************************************** *
 * project: org.matsim.*
 * KmlNetworkWriter.java
 *                                                                         *
 * *********************************************************************** *
 *                                                                         *
 * copyright       : (C) 2007 by the members listed in the COPYING,        *
 *                   LICENSE and WARRANTY file.                            *
 * email           : info at matsim dot org                                *
 *                                                                         *
 * *********************************************************************** *
 *                                                                         *
 *   This program is free software; you can redistribute it and/or modify  *
 *   it under the terms of the GNU General Public License as published by  *
 *   the Free Software Foundation; either version 2 of the License, or     *
 *   (at your option) any later version.                                   *
 *   See also COPYING, LICENSE and WARRANTY file                           *
 *                                                                         *
 * *********************************************************************** */
package org.matsim.basic.lightsignalsystems;

import org.matsim.basic.v01.Id;


/**
 * @author dgrether
 *
 */
public class BasicLightSignalSystemFactory {

	
	public BasicLanesToLinkAssignment createLanesToLinkAssignment(Id id) {
		return new BasicLanesToLinkAssignment(id);
	}

	public BasicLane createLane(Id id) {
		return new BasicLane(id);
	}

	public BasicLightSignalSystemDefinition createLightSignalSystemDefinition(
			Id id) {
		return new BasicLightSignalSystemDefinition(id);
	}

	public BasicLightSignalGroupDefinition createLightSignalGroupDefinition(
			Id id) {
		return new BasicLightSignalGroupDefinition(id);
	}
	
}
