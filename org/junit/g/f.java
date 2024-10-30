package org.junit.g;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.ANNOTATION_TYPE})
@Inherited
public @interface f {
  Class<? extends a> value();
}


/* Location:              C:\Arremate\Arremate.jar!\org\junit\g\f.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */