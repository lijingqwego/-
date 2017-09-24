package cn.com.user.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class AuthorityAndResource extends PUmResources{
	private String authorityid;

	public String getAuthorityid() {
		return authorityid;
	}

	public void setAuthorityid(String authorityid) {
		this.authorityid = authorityid;
	}

	public AuthorityAndResource(String resourceId, String resourceName, String resourceType, BigDecimal priority,
			String resourceUrl, String resourceDec, BigDecimal enabled, Date createTime, Date updateTime,
			String authorityid) {
		super(resourceId, resourceName, resourceType, priority, resourceUrl, resourceDec, enabled, createTime,
				updateTime);
		this.authorityid = authorityid;
	}

	public AuthorityAndResource() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuthorityAndResource(String resourceId, String resourceName, String resourceType, BigDecimal priority,
			String resourceUrl, String resourceDec, BigDecimal enabled, Date createTime, Date updateTime) {
		super(resourceId, resourceName, resourceType, priority, resourceUrl, resourceDec, enabled, createTime, updateTime);
		// TODO Auto-generated constructor stub
	}
}
