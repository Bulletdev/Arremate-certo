package org.a.a.g.a;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.a.d.a.E;
import org.a.d.a.r;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
@E(d = {h.class})
public @interface i {
  @r
  String[] value();
  
  @r
  String[] e() default {};
}


/* Location:              C:\Arremate\Arremate.jar!\org\a\a\g\a\i.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */