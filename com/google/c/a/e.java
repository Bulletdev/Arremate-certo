package com.google.c.a;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.FIELD})
public @interface e {
  String value() default "";
}


/* Location:              C:\Arremate\Arremate.jar!\com\google\c\a\e.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */