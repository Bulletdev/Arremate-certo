package org.junit.a.e;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface a {
  String[] value() default {};
  
  Class<? extends Throwable>[] f() default {};
}


/* Location:              C:\Arremate\Arremate.jar!\org\junit\a\e\a.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */