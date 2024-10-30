package org.junit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.junit.f.d;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface j {
  d a() default d.DEFAULT;
}


/* Location:              C:\Arremate\Arremate.jar!\org\junit\j.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */