package com.moohan.business.protocol.validHandler;

import com.moohan.business.protocol.input.StudentInput;
import com.moohan.common.web.valid.annotation.MoohanValid;
import com.moohan.common.web.valid.handler.MoohanValidHandler;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

@Component
public class BirthdayValidHandler implements MoohanValidHandler<StudentInput> {

    @Override
    public boolean valid(MoohanValid moohanValid, StudentInput data) {
        System.out.println("自定义的校验触发!");
        Date birthday = data.getBirthday();
        Integer age = data.getAge();
        if (null == birthday || null == age) return true;
        //当前时间
        Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        int nowYear = calendar.get(Calendar.YEAR);
        calendar.setTime(birthday);
        int birthYear = calendar.get(Calendar.YEAR);
        if (nowYear - birthYear == age) return true;
        return false;
    }
}
