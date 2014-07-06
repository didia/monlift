package me.didia.monlift.marshallers;


public interface IMarshaller<Out, In> {
	public Out marshall(In o);
}
