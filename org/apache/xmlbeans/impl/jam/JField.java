package org.apache.xmlbeans.impl.jam;

public interface JField extends JMember {
  JClass getType();
  
  boolean isFinal();
  
  boolean isStatic();
  
  boolean isVolatile();
  
  boolean isTransient();
  
  String getQualifiedName();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\JField.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */