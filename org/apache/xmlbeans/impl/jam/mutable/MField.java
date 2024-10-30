package org.apache.xmlbeans.impl.jam.mutable;

import org.apache.xmlbeans.impl.jam.JClass;
import org.apache.xmlbeans.impl.jam.JField;

public interface MField extends JField, MMember {
  void setType(String paramString);
  
  void setUnqualifiedType(String paramString);
  
  void setType(JClass paramJClass);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\mutable\MField.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */