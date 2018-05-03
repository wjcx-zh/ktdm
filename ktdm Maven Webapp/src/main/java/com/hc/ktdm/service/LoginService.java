package com.hc.ktdm.service;

public interface LoginService<T> {
	public T Exists(String name,String password);
	
}
