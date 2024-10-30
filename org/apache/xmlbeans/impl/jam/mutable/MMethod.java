package org.apache.xmlbeans.impl.jam.mutable;

import org.apache.xmlbeans.impl.jam.JClass;
import org.apache.xmlbeans.impl.jam.JMethod;

public interface MMethod extends JMethod, MInvokable {
  void setReturnType(String paramString);
  
  void setUnqualifiedReturnType(String paramString);
  
  void setReturnType(JClass paramJClass);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\mutable\MMethod.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */