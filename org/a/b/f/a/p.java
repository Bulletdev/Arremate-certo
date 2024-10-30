package org.a.b.f.a;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.a.d.a.E;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
@E(d = {q.class})
public @interface p {
  String[] value();
}


/* Location:              C:\Arremate\Arremate.jar!\org\a\b\f\a\p.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */