package com.google.b.a;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.lang.model.element.Modifier;

@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)
@k(a = {Modifier.FINAL})
public @interface r {}


/* Location:              C:\Arremate\Arremate.jar!\com\google\b\a\r.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */