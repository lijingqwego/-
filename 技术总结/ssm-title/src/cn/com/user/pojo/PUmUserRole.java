package cn.com.user.pojo;

public class PUmUserRole {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column P_UM_USER_ROLE.USERID
     *
     * @mbggenerated Fri Aug 04 17:04:42 CST 2017
     */
    private String userid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column P_UM_USER_ROLE.ROLEID
     *
     * @mbggenerated Fri Aug 04 17:04:42 CST 2017
     */
    private String roleid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column P_UM_USER_ROLE.FLAGINFO
     *
     * @mbggenerated Fri Aug 04 17:04:42 CST 2017
     */
    private String flaginfo;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column P_UM_USER_ROLE.USERID
     *
     * @return the value of P_UM_USER_ROLE.USERID
     *
     * @mbggenerated Fri Aug 04 17:04:42 CST 2017
     */
    public String getUserid() {
        return userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column P_UM_USER_ROLE.USERID
     *
     * @param userid the value for P_UM_USER_ROLE.USERID
     *
     * @mbggenerated Fri Aug 04 17:04:42 CST 2017
     */
    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column P_UM_USER_ROLE.ROLEID
     *
     * @return the value of P_UM_USER_ROLE.ROLEID
     *
     * @mbggenerated Fri Aug 04 17:04:42 CST 2017
     */
    public String getRoleid() {
        return roleid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column P_UM_USER_ROLE.ROLEID
     *
     * @param roleid the value for P_UM_USER_ROLE.ROLEID
     *
     * @mbggenerated Fri Aug 04 17:04:42 CST 2017
     */
    public void setRoleid(String roleid) {
        this.roleid = roleid == null ? null : roleid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column P_UM_USER_ROLE.FLAGINFO
     *
     * @return the value of P_UM_USER_ROLE.FLAGINFO
     *
     * @mbggenerated Fri Aug 04 17:04:42 CST 2017
     */
    public String getFlaginfo() {
        return flaginfo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column P_UM_USER_ROLE.FLAGINFO
     *
     * @param flaginfo the value for P_UM_USER_ROLE.FLAGINFO
     *
     * @mbggenerated Fri Aug 04 17:04:42 CST 2017
     */
    public void setFlaginfo(String flaginfo) {
        this.flaginfo = flaginfo == null ? null : flaginfo.trim();
    }

	public PUmUserRole(String userid, String roleid, String flaginfo) {
		super();
		this.userid = userid;
		this.roleid = roleid;
		this.flaginfo = flaginfo;
	}

	public PUmUserRole() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}