package com.amb_it_ion.refocus.persistence;

import javax.persistence.*;

public aspect UserAnnotations {
	declare @field : * UserEntity : @Column(name = "name", length = 128, nullable = true);
	
	// http://www.eclipse.org/aspectj/doc/released/devguide/bytecode-concepts.html
	declare @type : com.amb_it_ion.refocus.business.data.User : @MappedSuperclass;
}
