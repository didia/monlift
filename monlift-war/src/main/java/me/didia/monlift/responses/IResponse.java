package me.didia.monlift.responses;


public interface IResponse<In> {
	public void build(In o);
}
