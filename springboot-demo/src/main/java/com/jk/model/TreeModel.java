/** 
 * <pre>项目名称:1905qq 
 * 文件名称:Tree.java 
 * 包名:com.jk.pojo 
 * 创建日期:2019年10月8日下午7:21:29 
 * Copyright (c) 2019, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.model;

import java.io.Serializable;
import java.util.List;

/** 
 * <pre>项目名称：1905qq    
 * 类名称：Tree    
 * 类描述：    
 * 创建人：刘朋博
 *
 * 励志语录: 业精于勤荒于嬉 行成于思毁于随  努力才有结果
 *
 * 创建时间：2019年10月8日 下午7:21:29
 * 修改人：刘朋博
 * 修改时间：2019年10月8日 下午7:21:29
 * 修改备注：       
 * @version </pre>     
 */
public class TreeModel  implements Serializable {
	private static final long serialVersionUID = -7470589936391688460L;
	private Integer id;
	private String text;
	private Integer pid;
	private  String url;
	private List<TreeModel> children;
	private String state;
    private boolean checked;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<TreeModel> getChildren() {
		return children;
	}
	public void setChildren(List<TreeModel> children) {
		this.children = children;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	

}
