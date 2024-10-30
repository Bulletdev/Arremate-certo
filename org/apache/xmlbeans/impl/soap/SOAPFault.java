package org.apache.xmlbeans.impl.soap;

import java.util.Locale;

public interface SOAPFault extends SOAPBodyElement {
  void setFaultCode(String paramString) throws SOAPException;
  
  String getFaultCode();
  
  void setFaultActor(String paramString) throws SOAPException;
  
  String getFaultActor();
  
  void setFaultString(String paramString) throws SOAPException;
  
  String getFaultString();
  
  Detail getDetail();
  
  Detail addDetail() throws SOAPException;
  
  void setFaultCode(Name paramName) throws SOAPException;
  
  Name getFaultCodeAsName();
  
  void setFaultString(String paramString, Locale paramLocale) throws SOAPException;
  
  Locale getFaultStringLocale();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\soap\SOAPFault.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */