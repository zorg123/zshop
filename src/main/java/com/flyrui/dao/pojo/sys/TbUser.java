package com.flyrui.dao.pojo.sys;

import java.io.Serializable;
import java.util.Date;

public class TbUser implements Serializable {
    private String user_id;

    private String user_code;

    private String name;

    private String password;

    private String sex;

    private String mail;

    private String phone;

    private Integer org_id;

    private Date register_date;

    private String register_ip;

    private Date last_login_time;

    private String last_login_ip;

    private Integer login_count;

    private String state;
    
    private String bank_account;

    private String id_card;
    
    private String position_level;
    
    private String cas_account;
    
    private String current_goodsSum;
    
    private String pre_goodsSum;
    
    /** 手机号码 */
	private String user_phone;

	/** 交易密码 */
	private String trans_pwd;

	/** 父节点id */
	private String pid;

	/** 证件类型 */
	private String cert_type;

	/** 用户等级 -1到10 */
	private Integer user_level;

	/** 证件编码 */
	private String cert_id;

	/** 0:不参与结算 1:参与结算 */
	private Integer bus_state;

	/**  */
	private Date create_time;

	/** 注册人id */
	private String register_id;

	/** 激活时间 */
	private Date act_time;

	/**  */
	private Integer allchild_num;
	
	private String head_img;
	
	private String user_type;
	
	private String shareout_qua;
	
	private Integer allorder_num;
	
	private String notInChild;
	
	private String pre_smallMarket;
	
	private String current_smallMarket;
    
    private static final long serialVersionUID = 1L;
    

	public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_code() {
        return user_code;
    }

    public void setUser_code(String user_code) {
        this.user_code = user_code == null ? null : user_code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail == null ? null : mail.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getOrg_id() {
        return org_id;
    }

    public void setOrg_id(Integer org_id) {
        this.org_id = org_id;
    }

    public Date getRegister_date() {
        return register_date;
    }

    public void setRegister_date(Date register_date) {
        this.register_date = register_date;
    }

    public String getRegister_ip() {
        return register_ip;
    }

    public void setRegister_ip(String register_ip) {
        this.register_ip = register_ip == null ? null : register_ip.trim();
    }

    public Date getLast_login_time() {
        return last_login_time;
    }

    public void setLast_login_time(Date last_login_time) {
        this.last_login_time = last_login_time;
    }

    public String getLast_login_ip() {
        return last_login_ip;
    }

    public void setLast_login_ip(String last_login_ip) {
        this.last_login_ip = last_login_ip == null ? null : last_login_ip.trim();
    }

    public Integer getLogin_count() {
        return login_count;
    }

    public void setLogin_count(Integer login_count) {
        this.login_count = login_count;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

	public String getBank_account() {
		return bank_account;
	}

	public void setBank_account(String bankAccount) {
		bank_account = bankAccount;
	}

	public String getId_card() {
		return id_card;
	}

	public void setId_card(String idCard) {
		id_card = idCard;
	}

	public String getPosition_level() {
		return position_level;
	}

	public void setPosition_level(String positionLevel) {
		position_level = positionLevel;
	}

	public String getCas_account() {
		return cas_account;
	}

	public void setCas_account(String cas_account) {
		this.cas_account = cas_account;
	}
   
	public String getUser_phone() {
		return this.user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getTrans_pwd() {
		return this.trans_pwd;
	}

	public void setTrans_pwd(String trans_pwd) {
		this.trans_pwd = trans_pwd;
	}

	public String getPid() {
		return this.pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getCert_type() {
		return this.cert_type;
	}

	public void setCert_type(String cert_type) {
		this.cert_type = cert_type;
	}

	public Integer getUser_level() {
		return this.user_level;
	}

	public void setUser_level(Integer user_level) {
		this.user_level = user_level;
	}

	public String getCert_id() {
		return this.cert_id;
	}

	public void setCert_id(String cert_id) {
		this.cert_id = cert_id;
	}

	public Integer getBus_state() {
		return this.bus_state;
	}

	public void setBus_state(Integer bus_state) {
		this.bus_state = bus_state;
	}

	public Date getCreate_time() {
		return this.create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public String getRegister_id() {
		return this.register_id;
	}

	public void setRegister_id(String register_id) {
		this.register_id = register_id;
	}

	public Date getAct_time() {
		return this.act_time;
	}

	public void setAct_time(Date act_time) {
		this.act_time = act_time;
	}

	public Integer getAllchild_num() {
		return this.allchild_num;
	}

	public void setAllchild_num(Integer allchild_num) {
		this.allchild_num = allchild_num;
	}

	public String getHead_img() {
		return head_img;
	}

	public void setHead_img(String head_img) {
		this.head_img = head_img;
	}

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

	public String getShareout_qua() {
		return shareout_qua;
	}

	public void setShareout_qua(String shareout_qua) {
		this.shareout_qua = shareout_qua;
	}

	public Integer getAllorder_num() {
		return allorder_num;
	}

	public void setAllorder_num(Integer allorder_num) {
		this.allorder_num = allorder_num;
	}

	public String getCurrent_goodsSum() {
		return current_goodsSum;
	}

	public void setCurrent_goodsSum(String current_goodsSum) {
		this.current_goodsSum = current_goodsSum;
	}

	public String getPre_goodsSum() {
		return pre_goodsSum;
	}

	public void setPre_goodsSum(String pre_goodsSum) {
		this.pre_goodsSum = pre_goodsSum;
	}

	public String getNotInChild() {
		return notInChild;
	}

	public void setNotInChild(String notInChild) {
		this.notInChild = notInChild;
	}

	public String getPre_smallMarket() {
		return pre_smallMarket;
	}

	public void setPre_smallMarket(String pre_smallMarket) {
		this.pre_smallMarket = pre_smallMarket;
	}

	public String getCurrent_smallMarket() {
		return current_smallMarket;
	}

	public void setCurrent_smallMarket(String current_smallMarket) {
		this.current_smallMarket = current_smallMarket;
	}
}