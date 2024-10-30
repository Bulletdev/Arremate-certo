package org.a.a.j.a;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.a.d.a.c;
import org.a.d.a.p;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@c(h = h.class)
@p
@Repeatable(b.a.class)
public @interface b {
  String[] f();
  
  boolean eu();
  
  @Documented
  @Retention(RetentionPolicy.RUNTIME)
  @Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
  @c(h = h.class)
  @p
  public static @interface a {
    b[] a();
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\a\a\j\a\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */