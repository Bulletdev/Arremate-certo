package org.apache.xmlbeans.impl.jam.visitor;

import org.apache.xmlbeans.impl.jam.mutable.MAnnotation;
import org.apache.xmlbeans.impl.jam.mutable.MClass;
import org.apache.xmlbeans.impl.jam.mutable.MComment;
import org.apache.xmlbeans.impl.jam.mutable.MConstructor;
import org.apache.xmlbeans.impl.jam.mutable.MField;
import org.apache.xmlbeans.impl.jam.mutable.MMethod;
import org.apache.xmlbeans.impl.jam.mutable.MPackage;
import org.apache.xmlbeans.impl.jam.mutable.MParameter;

public abstract class MVisitor {
  public void visit(MPackage paramMPackage) {}
  
  public void visit(MClass paramMClass) {}
  
  public void visit(MConstructor paramMConstructor) {}
  
  public void visit(MField paramMField) {}
  
  public void visit(MMethod paramMMethod) {}
  
  public void visit(MParameter paramMParameter) {}
  
  public void visit(MAnnotation paramMAnnotation) {}
  
  public void visit(MComment paramMComment) {}
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\visitor\MVisitor.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */