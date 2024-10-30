package org.apache.xmlbeans.impl.soap;

public interface SOAPHeaderElement extends SOAPElement {
  void setActor(String paramString);
  
  String getActor();
  
  void setMustUnderstand(boolean paramBoolean);
  
  boolean getMustUnderstand();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\soap\SOAPHeaderElement.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */