package javax.annotation.a;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
public @interface a {
  String value();
}


/* Location:              C:\Arremate\Arremate.jar!\javax\annotation\a\a.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */