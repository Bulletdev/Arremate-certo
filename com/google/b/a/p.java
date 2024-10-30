package com.google.b.a;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.CONSTRUCTOR, ElementType.METHOD})
public @interface p {
  String dx() default "RestrictedApi";
  
  String dy();
  
  String dz();
  
  String dA() default "";
  
  Class<? extends Annotation>[] a() default {};
  
  Class<? extends Annotation>[] b() default {};
}


/* Location:              C:\Arremate\Arremate.jar!\com\google\b\a\p.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */