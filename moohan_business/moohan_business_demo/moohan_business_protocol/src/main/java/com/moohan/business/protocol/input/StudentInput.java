package com.moohan.business.protocol.input;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.moohan.business.protocol.validHandler.BirthdayValidHandler;
import com.moohan.common.web.valid.annotation.MoohanValid;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

@Data
@MoohanValid(message = "年龄和生日不匹配", handler = BirthdayValidHandler.class)
public class StudentInput {

    @NotNull(message = "姓名不能为空")
    private String name;
    @Min(value = 1, message = "年龄不能小于1岁")
    @Max(value = 20, message = "年龄不能大于20岁")
    private Integer age;
    @Email
    @NotNull(message = "邮箱不能为空")
    private String email;
    @NotNull(message = "性别不能为空")
    private Integer sex;
    @Past(message = "生日范围不正确")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date birthday;
}
