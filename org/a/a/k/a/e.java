package org.a.a.k.a;

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
@c(h = i.class)
@p
@Repeatable(e.a.class)
public @interface e {
  String[] f();
  
  boolean eu();
  
  @Documented
  @Retention(RetentionPolicy.RUNTIME)
  @Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
  @c(h = i.class)
  @p
  public static @interface a {
    e[] a();
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\a\a\k\a\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */