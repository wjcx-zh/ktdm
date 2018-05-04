package com.hc.ktdm.domain;

import java.util.List;

public class DataSet {
	private long total;
	private List<?> rows;
	@Override
	public String toString() {
		return "DataSet [total=" + total + ", rows=" + rows + "]";
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	
}
