package oshi.annotation.concurrent;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
public @interface GuardedBy {
  String value();
}


/* Location:              C:\Arremate\Arremate.jar!\oshi\annotation\concurrent\GuardedBy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */