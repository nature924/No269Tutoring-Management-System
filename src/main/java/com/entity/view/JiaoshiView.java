package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.JiaoshiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 教师
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("jiaoshi")
public class JiaoshiView extends JiaoshiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 性别的值
	*/
	@ColumnInfo(comment="性别的字典表值",type="varchar(200)")
	private String sexValue;
	/**
	* 教师类型的值
	*/
	@ColumnInfo(comment="教师类型的字典表值",type="varchar(200)")
	private String jiaoshiValue;




	public JiaoshiView() {

	}

	public JiaoshiView(JiaoshiEntity jiaoshiEntity) {
		try {
			BeanUtils.copyProperties(this, jiaoshiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 性别的值
	*/
	public String getSexValue() {
		return sexValue;
	}
	/**
	* 设置： 性别的值
	*/
	public void setSexValue(String sexValue) {
		this.sexValue = sexValue;
	}
	//当前表的
	/**
	* 获取： 教师类型的值
	*/
	public String getJiaoshiValue() {
		return jiaoshiValue;
	}
	/**
	* 设置： 教师类型的值
	*/
	public void setJiaoshiValue(String jiaoshiValue) {
		this.jiaoshiValue = jiaoshiValue;
	}




	@Override
	public String toString() {
		return "JiaoshiView{" +
			", sexValue=" + sexValue +
			", jiaoshiValue=" + jiaoshiValue +
			"} " + super.toString();
	}
}
