package com.codetutr;


import java.util.Collection;

/**
 * Created by jguidoux on 28/10/15.
 */
public class Mapping {

	private Collection<String> mappings;
	private String className;

	public Mapping(final String _className, final Collection<String> _mappings) {

		mappings = _mappings;
		className = _className;
	}

	public Collection<String> getMappings() {

		return mappings;
	}
	public void setMappings(final Collection<String> _mappings) {

		mappings = _mappings;
	}
	public String getClassName() {

		return className;
	}
	public void setClassName(final String _className) {

		className = _className;
	}

	@Override
	public String toString() {

		return "Mapping{" +
				"mappings=" + mappings +
				", className='" + className + '\'' +
				'}';
	}
}
