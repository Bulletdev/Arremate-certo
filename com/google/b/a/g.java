package com.google.b.a;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.lang.model.element.Modifier;

@Documented
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.METHOD})
@k(a = {Modifier.PUBLIC, Modifier.PRIVATE, Modifier.STATIC, Modifier.FINAL})
public @interface g {}


/* Location:              C:\Arremate\Arremate.jar!\com\google\b\a\g.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */