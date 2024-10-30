package org.junit.f.a;

import java.lang.annotation.Annotation;

public interface a {
  Annotation[] getAnnotations();
  
  <T extends Annotation> T getAnnotation(Class<T> paramClass);
}


/* Location:              C:\Arremate\Arremate.jar!\org\junit\f\a\a.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */