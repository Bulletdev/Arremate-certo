package org.apache.commons.lang3.builder;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface ToStringExclude {}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\builder\ToStringExclude.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */