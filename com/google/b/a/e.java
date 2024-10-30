package com.google.b.a;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target({ElementType.METHOD})
public @interface e {
  String value() default "";
}


/* Location:              C:\Arremate\Arremate.jar!\com\google\b\a\e.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */