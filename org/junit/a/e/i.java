package org.junit.a.e;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface i {
  boolean gj() default true;
}


/* Location:              C:\Arremate\Arremate.jar!\org\junit\a\e\i.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */