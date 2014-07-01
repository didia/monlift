package me.didia.monlift.marshallers;

import me.didia.monlift.BaseException;



public interface IMarshaller<Out, In> {
	public Out marshall(In o);
	public Out marshall(BaseException e);
}
