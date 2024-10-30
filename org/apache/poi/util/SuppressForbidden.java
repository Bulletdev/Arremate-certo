package org.apache.poi.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface SuppressForbidden {
  String value() default "";
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\po\\util\SuppressForbidden.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */