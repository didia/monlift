package me.didia.monlift.marshallers;

import java.util.List;


public interface IMarshaller<Out, In> {
	public Out marshall(In o);
	public List<Out> marshall(List<In> o);
}
