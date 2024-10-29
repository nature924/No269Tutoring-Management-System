package com.entity.model;

import com.entity.JiaoshiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 教师
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JiaoshiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 教师名称
     */
    private String jiaoshiName;


    /**
     * 教师手机号
     */
    private String jiaoshiPhone;


    /**
     * 教师头像
     */
    private String jiaoshiPhoto;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 教师邮箱
     */
    private String jiaoshiEmail;


    /**
     * 预约价格
     */
    private Double jiaoshiMone;


    /**
     * 教师类型
     */
    private Integer jiaoshiTypes;


    /**
     * 现有余额
     */
    private Double newMoney;


    /**
     * 个人介绍
     */
    private String jiaoshiContent;


    /**
     * 逻辑删除
     */
    private Integer jiaoshiDelete;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 设置：账户
	 */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 设置：密码
	 */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：教师名称
	 */
    public String getJiaoshiName() {
        return jiaoshiName;
    }


    /**
	 * 设置：教师名称
	 */
    public void setJiaoshiName(String jiaoshiName) {
        this.jiaoshiName = jiaoshiName;
    }
    /**
	 * 获取：教师手机号
	 */
    public String getJiaoshiPhone() {
        return jiaoshiPhone;
    }


    /**
	 * 设置：教师手机号
	 */
    public void setJiaoshiPhone(String jiaoshiPhone) {
        this.jiaoshiPhone = jiaoshiPhone;
    }
    /**
	 * 获取：教师头像
	 */
    public String getJiaoshiPhoto() {
        return jiaoshiPhoto;
    }


    /**
	 * 设置：教师头像
	 */
    public void setJiaoshiPhoto(String jiaoshiPhoto) {
        this.jiaoshiPhoto = jiaoshiPhoto;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：教师邮箱
	 */
    public String getJiaoshiEmail() {
        return jiaoshiEmail;
    }


    /**
	 * 设置：教师邮箱
	 */
    public void setJiaoshiEmail(String jiaoshiEmail) {
        this.jiaoshiEmail = jiaoshiEmail;
    }
    /**
	 * 获取：预约价格
	 */
    public Double getJiaoshiMone() {
        return jiaoshiMone;
    }


    /**
	 * 设置：预约价格
	 */
    public void setJiaoshiMone(Double jiaoshiMone) {
        this.jiaoshiMone = jiaoshiMone;
    }
    /**
	 * 获取：教师类型
	 */
    public Integer getJiaoshiTypes() {
        return jiaoshiTypes;
    }


    /**
	 * 设置：教师类型
	 */
    public void setJiaoshiTypes(Integer jiaoshiTypes) {
        this.jiaoshiTypes = jiaoshiTypes;
    }
    /**
	 * 获取：现有余额
	 */
    public Double getNewMoney() {
        return newMoney;
    }


    /**
	 * 设置：现有余额
	 */
    public void setNewMoney(Double newMoney) {
        this.newMoney = newMoney;
    }
    /**
	 * 获取：个人介绍
	 */
    public String getJiaoshiContent() {
        return jiaoshiContent;
    }


    /**
	 * 设置：个人介绍
	 */
    public void setJiaoshiContent(String jiaoshiContent) {
        this.jiaoshiContent = jiaoshiContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getJiaoshiDelete() {
        return jiaoshiDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setJiaoshiDelete(Integer jiaoshiDelete) {
        this.jiaoshiDelete = jiaoshiDelete;
    }
    /**
	 * 获取：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：添加时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
