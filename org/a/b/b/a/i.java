package org.a.b.b.a;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.a.d.a.E;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
@E(d = {m.class})
public @interface i {
  String[] h();
  
  String[] i();
  
  int[] e();
}


/* Location:              C:\Arremate\Arremate.jar!\org\a\b\b\a\i.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */