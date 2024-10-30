package org.junit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface m {
  Class<? extends Throwable> k() default a.class;
  
  long am() default 0L;
  
  public static class a extends Throwable {
    private static final long serialVersionUID = 1L;
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\junit\m.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */