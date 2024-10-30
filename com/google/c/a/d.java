package com.google.c.a;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.PACKAGE})
@Retention(RetentionPolicy.CLASS)
public @interface d {
  String value();
}


/* Location:              C:\Arremate\Arremate.jar!\com\google\c\a\d.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */