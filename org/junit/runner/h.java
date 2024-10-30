package org.junit.runner;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.junit.g.f;
import org.junit.runner.a.h;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Inherited
@f(i.class)
public @interface h {
  Class<? extends h.b> value();
}


/* Location:              C:\Arremate\Arremate.jar!\org\junit\runner\h.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */