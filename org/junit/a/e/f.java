package org.junit.a.e;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.ANNOTATION_TYPE, ElementType.PARAMETER})
public @interface f {
  Class<? extends e> value();
}


/* Location:              C:\Arremate\Arremate.jar!\org\junit\a\e\f.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */