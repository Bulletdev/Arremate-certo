package org.apache.xmlbeans.impl.jam;

public interface JMember extends JAnnotatedElement {
  JClass getContainingClass();
  
  int getModifiers();
  
  boolean isPackagePrivate();
  
  boolean isPrivate();
  
  boolean isProtected();
  
  boolean isPublic();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\JMember.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */