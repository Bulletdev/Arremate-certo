package javax.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.b.c;
import javax.annotation.b.g;

@Documented
@c(e = CharSequence.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface o {
  String value();
  
  g a() default g.ALWAYS;
}


/* Location:              C:\Arremate\Arremate.jar!\javax\annotation\o.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */