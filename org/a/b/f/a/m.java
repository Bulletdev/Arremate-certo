package org.a.b.f.a;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Inherited
public @interface m {
  int[] g();
  
  String[] j();
}


/* Location:              C:\Arremate\Arremate.jar!\org\a\b\f\a\m.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */