package org.a.d.a;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.ANNOTATION_TYPE})
public @interface e {
  H[] a() default {};
  
  G[] a() default {};
  
  Class<?>[] c() default {};
}


/* Location:              C:\Arremate\Arremate.jar!\org\a\d\a\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */