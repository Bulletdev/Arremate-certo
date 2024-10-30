package org.a.a.g.a;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
public @interface f {
  String[] value();
}


/* Location:              C:\Arremate\Arremate.jar!\org\a\a\g\a\f.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */