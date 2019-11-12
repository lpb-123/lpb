/** 
 * <pre>项目名称:ssm-user-wdd 
 * 文件名称:DeptBean.java 
 * 包名:com.jk.wdd.pojo 
 * 创建日期:2019年9月3日上午9:18:41 
 * Copyright (c) 2019, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.model;

import java.util.List;

/** 
 * <pre>项目名称：ssm-user-wdd    
 * 类名称：DeptBean    
 * 类描述：    
 * 创建人：wdd   
 * 创建时间：2019年9月3日 上午9:18:41    
 * 修改人：wdd 
 * 修改时间：2019年9月3日 上午9:18:41    
 * 修改备注：       
 * @version </pre>    
 */
public class DeptModel {
	    private Integer did;

	    private String text;

	    private Integer pid;
	    
	    private List<DeptModel> children;

		public Integer getDid() {
			return did;
		}

		public void setDid(Integer did) {
			this.did = did;
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

		public List<DeptModel> getChildren() {
			return children;
		}

		public void setChildren(List<DeptModel> children) {
			this.children = children;
		}

	
}
