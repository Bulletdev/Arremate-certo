package org.apache.xmlbeans.impl.soap;

import java.util.Locale;
import org.w3c.dom.Document;

public interface SOAPBody extends SOAPElement {
  SOAPFault addFault() throws SOAPException;
  
  boolean hasFault();
  
  SOAPFault getFault();
  
  SOAPBodyElement addBodyElement(Name paramName) throws SOAPException;
  
  SOAPFault addFault(Name paramName, String paramString, Locale paramLocale) throws SOAPException;
  
  SOAPFault addFault(Name paramName, String paramString) throws SOAPException;
  
  SOAPBodyElement addDocument(Document paramDocument) throws SOAPException;
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\soap\SOAPBody.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */