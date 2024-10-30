package org.apache.http.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
public @interface Obsolete {}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\annotation\Obsolete.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */