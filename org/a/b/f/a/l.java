package org.a.b.f.a;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
public @interface l {
  int value() default 0;
}


/* Location:              C:\Arremate\Arremate.jar!\org\a\b\f\a\l.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */