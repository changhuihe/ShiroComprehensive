package com.hch.bind;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.hch.constants.Constants;

@Target({ ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CurrentUser {
	/**
	 * ��ǰ�û���request�е�����
	 *
	 * @return
	 */
	String value() default Constants.CURRENT_USER;

}
