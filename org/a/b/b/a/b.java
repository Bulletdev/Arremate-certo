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
@E(d = {l.class})
public @interface b {
  String[] value();
}


/* Location:              C:\Arremate\Arremate.jar!\org\a\b\b\a\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */