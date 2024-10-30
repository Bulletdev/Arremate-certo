package org.a.a.g.a;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.a.d.a.c;
import org.a.d.a.p;
import org.a.d.a.r;
import org.a.d.a.z;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@c(h = i.class)
@p
@Repeatable(b.a.class)
public @interface b {
  String[] f();
  
  boolean eu();
  
  @r
  @z("value")
  String[] d();
  
  @r
  @z("offset")
  String[] e() default {};
  
  @Documented
  @Retention(RetentionPolicy.RUNTIME)
  @Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
  @c(h = i.class)
  @p
  public static @interface a {
    b[] a();
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\a\a\g\a\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */