package org.openxmlformats.schemas.drawingml.x2006.picture.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.picture.CTPicture;
import org.openxmlformats.schemas.drawingml.x2006.picture.PicDocument;

public class PicDocumentImpl extends XmlComplexContentImpl implements PicDocument {
  private static final b PIC$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/picture", "pic");
  
  public PicDocumentImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTPicture getPic() {
    synchronized (monitor()) {
      check_orphaned();
      CTPicture cTPicture = null;
      cTPicture = (CTPicture)get_store().find_element_user(PIC$0, 0);
      if (cTPicture == null)
        return null; 
      return cTPicture;
    } 
  }
  
  public void setPic(CTPicture paramCTPicture) {
    synchronized (monitor()) {
      check_orphaned();
      CTPicture cTPicture = null;
      cTPicture = (CTPicture)get_store().find_element_user(PIC$0, 0);
      if (cTPicture == null)
        cTPicture = (CTPicture)get_store().add_element_user(PIC$0); 
      cTPicture.set((XmlObject)paramCTPicture);
    } 
  }
  
  public CTPicture addNewPic() {
    synchronized (monitor()) {
      check_orphaned();
      CTPicture cTPicture = null;
      cTPicture = (CTPicture)get_store().add_element_user(PIC$0);
      return cTPicture;
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\picture\impl\PicDocumentImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */