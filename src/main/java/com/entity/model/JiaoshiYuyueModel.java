package com.entity.model;

import com.entity.JiaoshiYuyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 预约信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JiaoshiYuyueModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 预约编号
     */
    private String jiaoshiYuyueUuidNumber;


    /**
     * 教师
     */
    private Integer jiaoshiId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 预约信息
     */
    private String jiaoshiYuyueText;


    /**
     * 预约时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date jiaoshiYuyueTime;


    /**
     * 审核状态
     */
    private Integer jiaoshiYuyueYesnoTypes;


    /**
     * 审核回复
     */
    private String jiaoshiYuyueYesnoText;


    /**
     * 预约状态
     */
    private Integer jiaoshiYuyueTypes;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
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
	 * 获取：预约编号
	 */
    public String getJiaoshiYuyueUuidNumber() {
        return jiaoshiYuyueUuidNumber;
    }


    /**
	 * 设置：预约编号
	 */
    public void setJiaoshiYuyueUuidNumber(String jiaoshiYuyueUuidNumber) {
        this.jiaoshiYuyueUuidNumber = jiaoshiYuyueUuidNumber;
    }
    /**
	 * 获取：教师
	 */
    public Integer getJiaoshiId() {
        return jiaoshiId;
    }


    /**
	 * 设置：教师
	 */
    public void setJiaoshiId(Integer jiaoshiId) {
        this.jiaoshiId = jiaoshiId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：预约信息
	 */
    public String getJiaoshiYuyueText() {
        return jiaoshiYuyueText;
    }


    /**
	 * 设置：预约信息
	 */
    public void setJiaoshiYuyueText(String jiaoshiYuyueText) {
        this.jiaoshiYuyueText = jiaoshiYuyueText;
    }
    /**
	 * 获取：预约时间
	 */
    public Date getJiaoshiYuyueTime() {
        return jiaoshiYuyueTime;
    }


    /**
	 * 设置：预约时间
	 */
    public void setJiaoshiYuyueTime(Date jiaoshiYuyueTime) {
        this.jiaoshiYuyueTime = jiaoshiYuyueTime;
    }
    /**
	 * 获取：审核状态
	 */
    public Integer getJiaoshiYuyueYesnoTypes() {
        return jiaoshiYuyueYesnoTypes;
    }


    /**
	 * 设置：审核状态
	 */
    public void setJiaoshiYuyueYesnoTypes(Integer jiaoshiYuyueYesnoTypes) {
        this.jiaoshiYuyueYesnoTypes = jiaoshiYuyueYesnoTypes;
    }
    /**
	 * 获取：审核回复
	 */
    public String getJiaoshiYuyueYesnoText() {
        return jiaoshiYuyueYesnoText;
    }


    /**
	 * 设置：审核回复
	 */
    public void setJiaoshiYuyueYesnoText(String jiaoshiYuyueYesnoText) {
        this.jiaoshiYuyueYesnoText = jiaoshiYuyueYesnoText;
    }
    /**
	 * 获取：预约状态
	 */
    public Integer getJiaoshiYuyueTypes() {
        return jiaoshiYuyueTypes;
    }


    /**
	 * 设置：预约状态
	 */
    public void setJiaoshiYuyueTypes(Integer jiaoshiYuyueTypes) {
        this.jiaoshiYuyueTypes = jiaoshiYuyueTypes;
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
	 * 获取：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
