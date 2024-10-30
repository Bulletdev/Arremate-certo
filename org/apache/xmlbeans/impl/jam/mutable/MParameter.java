package org.apache.xmlbeans.impl.jam.mutable;

import org.apache.xmlbeans.impl.jam.JClass;
import org.apache.xmlbeans.impl.jam.JParameter;

public interface MParameter extends JParameter, MMember {
  void setType(String paramString);
  
  void setType(JClass paramJClass);
  
  void setUnqualifiedType(String paramString);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\mutable\MParameter.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */