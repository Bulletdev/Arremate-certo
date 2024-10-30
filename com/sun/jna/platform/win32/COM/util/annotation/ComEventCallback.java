package com.sun.jna.platform.win32.COM.util.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Inherited
@Deprecated
public @interface ComEventCallback {
  int dispid() default -1;
  
  String name() default "";
}


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\CO\\util\annotation\ComEventCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */