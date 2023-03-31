package com.example.common.util;

public interface LogUtil {

	public abstract void trace(String message);

	public abstract void traceUrl();

	public abstract void debug(String message);

	public abstract void debugUrl();

	public abstract void info(String message);

	public abstract void infoUrl();

	public abstract void warn(String message);

	public abstract void warnUrl();

	public abstract void error(String message);

	public abstract void errorUrl();

	public abstract String getUrl();

	public abstract void writeException(Exception e);

}
