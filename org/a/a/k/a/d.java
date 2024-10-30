package org.a.a.k.a;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.a.d.a.p;
import org.a.d.a.x;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@x(h = i.class)
@p
@Repeatable(d.a.class)
public @interface d {
  String[] value();
  
  @Documented
  @Retention(RetentionPolicy.RUNTIME)
  @Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
  @x(h = i.class)
  @p
  public static @interface a {
    d[] a();
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\a\a\k\a\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */