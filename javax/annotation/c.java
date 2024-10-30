package javax.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.annotation.b.g;

@Documented
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.TYPE, ElementType.PACKAGE})
@Retention(RetentionPolicy.RUNTIME)
public @interface c {
  g a() default g.ALWAYS;
}


/* Location:              C:\Arremate\Arremate.jar!\javax\annotation\c.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */