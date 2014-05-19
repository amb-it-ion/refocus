package com.amb_it_ion.refocus.control.usecase.impl;

import java.util.Collection;

import rx.Observable;

import com.amb_it_ion.refocus.business.data.NavigationSection;
import com.amb_it_ion.refocus.control.flow.api.Flow;
import com.amb_it_ion.refocus.control.flow.impl.navigation.NavigationFlow;
import com.amb_it_ion.refocus.control.usecase.api.UseCase;

public class UseCaseImpl implements UseCase {

	/*
	 * State
	 */
	
	private String name;

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	
	private Collection<Flow> alternativeFlows;
	
	@Override
	public Collection<Flow> getAlternativeFlows() {
		return alternativeFlows;
	}

	public void setAlternativeFlows(Collection<Flow> alternativeFlows) {
		this.alternativeFlows = alternativeFlows;
	}
	
	
	
	private Flow activeFlow;
	
	public Flow getActiveFlow()
	{
		return activeFlow;
	}
	
	
	
	private UseCaseLevelEnum level;
	
	public void setLevel(UseCaseLevelEnum level) {
		this.level = level;
	}

	@Override
	public UseCaseLevelEnum getLevel() {
		return level;
	}



	private Flow baseFlow = new NavigationFlow();

	public void setBaseFlow(Flow baseFlow) {
		this.baseFlow = baseFlow;
	}

	@Override
	public Flow getBaseFlow() {
		return baseFlow;
	}
	
	
	
	/*
	 * Constructor
	 */
	
	public UseCaseImpl( String name ) {
		super();
		this.name = name;
	}
	
	

	

}
