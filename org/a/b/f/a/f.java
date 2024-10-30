package org.a.b.f.a;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.a.d.a.c;
import org.a.d.a.p;
import org.a.d.a.z;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@c(h = l.class)
@p
@Repeatable(f.a.class)
public @interface f {
  String[] f();
  
  boolean eu();
  
  @z("value")
  int bm() default 0;
  
  @Documented
  @Retention(RetentionPolicy.RUNTIME)
  @Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
  @c(h = l.class)
  @p
  public static @interface a {
    f[] a();
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\a\b\f\a\f.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */