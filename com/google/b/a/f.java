package com.google.b.a;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
public @interface f {
  String value() default "Create a real instance instead";
}


/* Location:              C:\Arremate\Arremate.jar!\com\google\b\a\f.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */