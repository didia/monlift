package me.didia.monlift.responses;

import me.didia.monlift.BaseException;

public interface IResponse<In> {
	public void build(In o);
	public void build(BaseException e);
}
