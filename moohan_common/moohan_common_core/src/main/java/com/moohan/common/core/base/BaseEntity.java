package com.moohan.common.core.base;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体类的父类
 */
@Data
public class BaseEntity implements Serializable {

	private Date createTime = new Date();
	private Date updateTime = new Date();
	private Integer status = 0;
	private Integer delFlag = 0;
}
