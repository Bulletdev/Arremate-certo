package org.apache.poi.util;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Internal {
  String value() default "";
  
  String since() default "";
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\po\\util\Internal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */