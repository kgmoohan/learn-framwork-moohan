package com.moohan.data.entity.demo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.moohan.common.core.base.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Student extends BaseEntity {

	@TableId(type = IdType.AUTO)
	private Integer sid;
	private String name;
	private Integer sex;
	private String email;

}
