package org.apache.xmlbeans.impl.soap;

public interface SOAPEnvelope extends SOAPElement {
  Name createName(String paramString1, String paramString2, String paramString3) throws SOAPException;
  
  Name createName(String paramString) throws SOAPException;
  
  SOAPHeader getHeader() throws SOAPException;
  
  SOAPBody getBody() throws SOAPException;
  
  SOAPHeader addHeader() throws SOAPException;
  
  SOAPBody addBody() throws SOAPException;
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\soap\SOAPEnvelope.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */