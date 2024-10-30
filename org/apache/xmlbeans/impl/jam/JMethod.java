package org.apache.xmlbeans.impl.jam;

public interface JMethod extends JInvokable {
  JClass getReturnType();
  
  boolean isFinal();
  
  boolean isStatic();
  
  boolean isAbstract();
  
  boolean isNative();
  
  boolean isSynchronized();
  
  String getQualifiedName();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\JMethod.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */