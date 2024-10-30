package org.a.d.a;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.PACKAGE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.FIELD, ElementType.LOCAL_VARIABLE, ElementType.PARAMETER})
@Repeatable(f.a.class)
public @interface f {
  Class<? extends Annotation> value();
  
  H[] b() default {H.ALL};
  
  @Documented
  @Retention(RetentionPolicy.RUNTIME)
  @Target({ElementType.PACKAGE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.FIELD, ElementType.LOCAL_VARIABLE, ElementType.PARAMETER})
  public static @interface a {
    f[] a();
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\a\d\a\f.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */