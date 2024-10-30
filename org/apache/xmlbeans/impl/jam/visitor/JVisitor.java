package org.apache.xmlbeans.impl.jam.visitor;

import org.apache.xmlbeans.impl.jam.JAnnotation;
import org.apache.xmlbeans.impl.jam.JClass;
import org.apache.xmlbeans.impl.jam.JComment;
import org.apache.xmlbeans.impl.jam.JConstructor;
import org.apache.xmlbeans.impl.jam.JField;
import org.apache.xmlbeans.impl.jam.JMethod;
import org.apache.xmlbeans.impl.jam.JPackage;
import org.apache.xmlbeans.impl.jam.JParameter;
import org.apache.xmlbeans.impl.jam.JProperty;

public abstract class JVisitor {
  public void visit(JPackage paramJPackage) {}
  
  public void visit(JClass paramJClass) {}
  
  public void visit(JConstructor paramJConstructor) {}
  
  public void visit(JField paramJField) {}
  
  public void visit(JMethod paramJMethod) {}
  
  public void visit(JParameter paramJParameter) {}
  
  public void visit(JAnnotation paramJAnnotation) {}
  
  public void visit(JComment paramJComment) {}
  
  public void visit(JProperty paramJProperty) {}
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\visitor\JVisitor.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */