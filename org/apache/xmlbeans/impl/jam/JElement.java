package org.apache.xmlbeans.impl.jam;

import org.apache.xmlbeans.impl.jam.visitor.JVisitor;

public interface JElement {
  JElement getParent();
  
  String getSimpleName();
  
  String getQualifiedName();
  
  JSourcePosition getSourcePosition();
  
  void accept(JVisitor paramJVisitor);
  
  Object getArtifact();
  
  String toString();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\JElement.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */