package org.apache.xmlbeans.impl.jam.mutable;

import org.apache.xmlbeans.impl.jam.JAnnotation;
import org.apache.xmlbeans.impl.jam.JClass;

public interface MAnnotation extends JAnnotation, MElement {
  void setAnnotationInstance(Object paramObject);
  
  void setSimpleValue(String paramString, Object paramObject, JClass paramJClass);
  
  MAnnotation createNestedValue(String paramString1, String paramString2);
  
  MAnnotation[] createNestedValueArray(String paramString1, String paramString2, int paramInt);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\mutable\MAnnotation.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */