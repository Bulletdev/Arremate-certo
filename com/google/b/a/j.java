package com.google.b.a;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface j {
  String[] a() default {};
}


/* Location:              C:\Arremate\Arremate.jar!\com\google\b\a\j.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */