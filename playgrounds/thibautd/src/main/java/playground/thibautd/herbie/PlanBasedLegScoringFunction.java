/* *********************************************************************** *
 * project: org.matsim.*
 * PlanBasedLegScoringFunction.java
 *                                                                         *
 * *********************************************************************** *
 *                                                                         *
 * copyright       : (C) 2012 by the members listed in the COPYING,        *
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
package playground.thibautd.herbie;

import herbie.running.scoring.LegScoringFunction;

import java.util.Iterator;

import org.matsim.api.core.v01.population.Leg;
import org.matsim.api.core.v01.population.Plan;
import org.matsim.api.core.v01.population.PlanElement;
import org.matsim.core.scoring.interfaces.BasicScoring;
import org.matsim.core.scoring.interfaces.LegScoring;

/**
 * Uses the plan elements from the plan rather than the ones constructed from the
 * events (equivalent to the "old approach").
 *
 * @author thibautd
 */
public class PlanBasedLegScoringFunction implements BasicScoring, LegScoring {
	private final Plan plan;
	private final LegScoringFunction delegate;
	private PlanElement currentLeg = null;
	private Iterator<PlanElement> planIterator = null;

	public PlanBasedLegScoringFunction(
			final Plan plan,
			final LegScoringFunction delegate) {
		this.plan = plan;
		this.delegate = delegate;
		reset();
	}

	@Override
	public void endLeg(final double time) {
		delegate.endLeg(time);
	}

	@Override
	public void finish() {
		delegate.finish();
	}

	@Override
	public double getScore() {
		return delegate.getScore();
	}

	@Override
	public int hashCode() {
		return delegate.hashCode();
	}

	@Override
	public void reset() {
		delegate.reset();
		planIterator = plan.getPlanElements().iterator();
	}

	@Override
	public void startLeg(final double time, final Leg leg) {
		do {
			// go to next leg
			currentLeg = planIterator.next();
		}
		while ( !(currentLeg instanceof Leg) );

		delegate.startLeg(time, (Leg) currentLeg);
	}

	@Override
	public String toString() {
		return delegate.toString();
	}
}

