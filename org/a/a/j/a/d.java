package org.a.a.j.a;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.a.d.a.E;
import org.a.d.a.G;
import org.a.d.a.H;
import org.a.d.a.e;
import org.a.d.a.h;
import org.a.d.a.r;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
@E(d = {f.class})
@h
@e(a = {H.EXCEPTION_PARAMETER, H.UPPER_BOUND}, a = {G.BOOLEAN, G.BYTE, G.CHAR, G.DOUBLE, G.FLOAT, G.INT, G.LONG, G.SHORT}, c = {String.class, Void.class})
public @interface d {
  @r
  String[] value() default {};
}


/* Location:              C:\Arremate\Arremate.jar!\org\a\a\j\a\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */