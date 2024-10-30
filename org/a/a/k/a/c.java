package org.a.a.k.a;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.a.d.a.p;
import org.a.d.a.r;
import org.a.d.a.z;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@org.a.d.a.c(h = f.class)
@p
@Repeatable(c.a.class)
public @interface c {
  boolean eu();
  
  String[] f();
  
  @r
  @z("value")
  String[] g();
  
  @Documented
  @Retention(RetentionPolicy.RUNTIME)
  @Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
  @org.a.d.a.c(h = f.class)
  @p
  public static @interface a {
    c[] a();
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\a\a\k\a\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */