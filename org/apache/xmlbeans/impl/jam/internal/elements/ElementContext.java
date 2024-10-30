package org.apache.xmlbeans.impl.jam.internal.elements;

import org.apache.xmlbeans.impl.jam.JamClassLoader;
import org.apache.xmlbeans.impl.jam.annotation.AnnotationProxy;
import org.apache.xmlbeans.impl.jam.provider.JamLogger;

public interface ElementContext extends JamLogger {
  JamLogger getLogger();
  
  JamClassLoader getClassLoader();
  
  AnnotationProxy createAnnotationProxy(String paramString);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\internal\elements\ElementContext.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */