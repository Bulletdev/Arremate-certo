package org.apache.xmlbeans.impl.jam;

public interface JProperty extends JAnnotatedElement {
  JClass getType();
  
  JMethod getSetter();
  
  JMethod getGetter();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\JProperty.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */