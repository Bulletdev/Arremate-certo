package com.microsoft.schemas.office.x2006.digsig.impl;

import com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1;
import com.microsoft.schemas.office.x2006.digsig.SignatureInfoV1Document;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

public class SignatureInfoV1DocumentImpl extends XmlComplexContentImpl implements SignatureInfoV1Document {
  private static final b SIGNATUREINFOV1$0 = new b("http://schemas.microsoft.com/office/2006/digsig", "SignatureInfoV1");
  
  public SignatureInfoV1DocumentImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTSignatureInfoV1 getSignatureInfoV1() {
    synchronized (monitor()) {
      check_orphaned();
      CTSignatureInfoV1 cTSignatureInfoV1 = null;
      cTSignatureInfoV1 = (CTSignatureInfoV1)get_store().find_element_user(SIGNATUREINFOV1$0, 0);
      if (cTSignatureInfoV1 == null)
        return null; 
      return cTSignatureInfoV1;
    } 
  }
  
  public void setSignatureInfoV1(CTSignatureInfoV1 paramCTSignatureInfoV1) {
    synchronized (monitor()) {
      check_orphaned();
      CTSignatureInfoV1 cTSignatureInfoV1 = null;
      cTSignatureInfoV1 = (CTSignatureInfoV1)get_store().find_element_user(SIGNATUREINFOV1$0, 0);
      if (cTSignatureInfoV1 == null)
        cTSignatureInfoV1 = (CTSignatureInfoV1)get_store().add_element_user(SIGNATUREINFOV1$0); 
      cTSignatureInfoV1.set((XmlObject)paramCTSignatureInfoV1);
    } 
  }
  
  public CTSignatureInfoV1 addNewSignatureInfoV1() {
    synchronized (monitor()) {
      check_orphaned();
      CTSignatureInfoV1 cTSignatureInfoV1 = null;
      cTSignatureInfoV1 = (CTSignatureInfoV1)get_store().add_element_user(SIGNATUREINFOV1$0);
      return cTSignatureInfoV1;
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\x2006\digsig\impl\SignatureInfoV1DocumentImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */