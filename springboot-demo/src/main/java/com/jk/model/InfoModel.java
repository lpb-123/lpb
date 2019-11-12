package com.jk.model;

public class InfoModel {
    private Integer infoid;

    private String infoname;

    private String info;

    
    public Integer getInfoid() {
		return infoid;
	}

	public void setInfoid(Integer infoid) {
		this.infoid = infoid;
	}

	
    
	public String getInfoname() {
		return infoname;
	}

	public void setInfoname(String infoname) {
		this.infoname = infoname;
	}

	public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }
}