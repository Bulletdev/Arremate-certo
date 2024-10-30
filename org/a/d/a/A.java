package org.a.d.a;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.PACKAGE})
public @interface a {
  String[] value();
}


/* Location:              C:\Arremate\Arremate.jar!\org\a\d\a\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */