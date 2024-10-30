package org.a.b.c.a;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.a.d.a.F;
import org.a.d.a.H;
import org.a.d.a.w;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
@w
@F(a = {H.RECEIVER, H.RETURN})
public @interface b {}


/* Location:              C:\Arremate\Arremate.jar!\org\a\b\c\a\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */