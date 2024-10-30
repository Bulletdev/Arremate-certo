package org.a.d.a;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@p
@Repeatable(i.a.class)
public @interface i {
  String[] f();
  
  Class<? extends Annotation> h();
  
  @Documented
  @Retention(RetentionPolicy.RUNTIME)
  @Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
  @p
  public static @interface a {
    i[] a();
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\a\d\a\i.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */