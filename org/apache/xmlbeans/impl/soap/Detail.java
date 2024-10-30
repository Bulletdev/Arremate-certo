package org.apache.xmlbeans.impl.soap;

import java.util.Iterator;

public interface Detail extends SOAPFaultElement {
  DetailEntry addDetailEntry(Name paramName) throws SOAPException;
  
  Iterator getDetailEntries();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\soap\Detail.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */