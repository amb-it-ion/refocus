package com.amb_it_ion.refocus.control.usecase.api;

import java.util.Collection;

import com.amb_it_ion.refocus.control.flow.api.Flow;
import com.amb_it_ion.refocus.control.usecase.impl.UseCaseLevelEnum;

public interface UseCase {
	
	public String getName();
	public UseCaseLevelEnum getLevel();
	
	public Flow getBaseFlow();
	public Collection<Flow> getAlternativeFlows();

	public Flow getActiveFlow();
}
