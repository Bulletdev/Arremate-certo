package org.a.b.d.a;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import org.a.d.a.E;
import org.a.d.a.F;
import org.a.d.a.H;

@Documented
@E(d = {})
@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
@F(a = {H.EXPLICIT_LOWER_BOUND, H.EXPLICIT_UPPER_BOUND})
public @interface a {}


/* Location:              C:\Arremate\Arremate.jar!\org\a\b\d\a\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */