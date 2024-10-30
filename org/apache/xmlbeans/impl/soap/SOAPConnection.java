package org.apache.xmlbeans.impl.soap;

public abstract class SOAPConnection {
  public abstract SOAPMessage call(SOAPMessage paramSOAPMessage, Object paramObject) throws SOAPException;
  
  public abstract void close() throws SOAPException;
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\soap\SOAPConnection.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */