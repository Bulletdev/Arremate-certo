package javax.annotation.b;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target({ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface c {
  Class<?> e() default Object.class;
}


/* Location:              C:\Arremate\Arremate.jar!\javax\annotation\b\c.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */