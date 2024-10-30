package org.apache.http.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
public @interface Contract {
  ThreadingBehavior threading() default ThreadingBehavior.UNSAFE;
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\annotation\Contract.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */