package org.junit.a.e.b;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.junit.a.e.f;

@f(b.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER})
public @interface a {
  int[] h();
}


/* Location:              C:\Arremate\Arremate.jar!\org\junit\a\e\b\a.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */