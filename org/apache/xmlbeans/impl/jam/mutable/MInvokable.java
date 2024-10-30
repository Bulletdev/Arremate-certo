package org.apache.xmlbeans.impl.jam.mutable;

import org.apache.xmlbeans.impl.jam.JClass;
import org.apache.xmlbeans.impl.jam.JInvokable;

public interface MInvokable extends JInvokable, MMember {
  void addException(String paramString);
  
  void addException(JClass paramJClass);
  
  void removeException(String paramString);
  
  void removeException(JClass paramJClass);
  
  MParameter addNewParameter();
  
  void removeParameter(MParameter paramMParameter);
  
  MParameter[] getMutableParameters();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\mutable\MInvokable.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */