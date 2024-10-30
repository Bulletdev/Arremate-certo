package org.apache.xmlbeans.impl.soap;

import java.util.Iterator;

public interface SOAPHeader extends SOAPElement {
  SOAPHeaderElement addHeaderElement(Name paramName) throws SOAPException;
  
  Iterator examineHeaderElements(String paramString);
  
  Iterator extractHeaderElements(String paramString);
  
  Iterator examineMustUnderstandHeaderElements(String paramString);
  
  Iterator examineAllHeaderElements();
  
  Iterator extractAllHeaderElements();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\soap\SOAPHeader.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */