package org.openxmlformats.schemas.xpackage.x2006.digitalSignature.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.xpackage.x2006.digitalSignature.CTSignatureTime;
import org.openxmlformats.schemas.xpackage.x2006.digitalSignature.SignatureTimeDocument;

public class SignatureTimeDocumentImpl extends XmlComplexContentImpl implements SignatureTimeDocument {
  private static final b SIGNATURETIME$0 = new b("http://schemas.openxmlformats.org/package/2006/digital-signature", "SignatureTime");
  
  public SignatureTimeDocumentImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTSignatureTime getSignatureTime() {
    synchronized (monitor()) {
      check_orphaned();
      CTSignatureTime cTSignatureTime = null;
      cTSignatureTime = (CTSignatureTime)get_store().find_element_user(SIGNATURETIME$0, 0);
      if (cTSignatureTime == null)
        return null; 
      return cTSignatureTime;
    } 
  }
  
  public void setSignatureTime(CTSignatureTime paramCTSignatureTime) {
    synchronized (monitor()) {
      check_orphaned();
      CTSignatureTime cTSignatureTime = null;
      cTSignatureTime = (CTSignatureTime)get_store().find_element_user(SIGNATURETIME$0, 0);
      if (cTSignatureTime == null)
        cTSignatureTime = (CTSignatureTime)get_store().add_element_user(SIGNATURETIME$0); 
      cTSignatureTime.set((XmlObject)paramCTSignatureTime);
    } 
  }
  
  public CTSignatureTime addNewSignatureTime() {
    synchronized (monitor()) {
      check_orphaned();
      CTSignatureTime cTSignatureTime = null;
      cTSignatureTime = (CTSignatureTime)get_store().add_element_user(SIGNATURETIME$0);
      return cTSignatureTime;
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\xpackage\x2006\digitalSignature\impl\SignatureTimeDocumentImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */