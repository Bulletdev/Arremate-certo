package org.apache.poi.util;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface NotImplemented {
  String value() default "";
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\po\\util\NotImplemented.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */