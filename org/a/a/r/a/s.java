package org.a.a.r.a;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface s {
  Class<? extends Annotation> g();
  
  m b() default m.one;
}


/* Location:              C:\Arremate\Arremate.jar!\org\a\a\r\a\s.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */