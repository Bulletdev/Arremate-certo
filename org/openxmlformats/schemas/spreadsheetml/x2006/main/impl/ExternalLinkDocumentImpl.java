package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalLink;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.ExternalLinkDocument;

public class ExternalLinkDocumentImpl extends XmlComplexContentImpl implements ExternalLinkDocument {
  private static final b EXTERNALLINK$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "externalLink");
  
  public ExternalLinkDocumentImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTExternalLink getExternalLink() {
    synchronized (monitor()) {
      check_orphaned();
      CTExternalLink cTExternalLink = null;
      cTExternalLink = (CTExternalLink)get_store().find_element_user(EXTERNALLINK$0, 0);
      if (cTExternalLink == null)
        return null; 
      return cTExternalLink;
    } 
  }
  
  public void setExternalLink(CTExternalLink paramCTExternalLink) {
    synchronized (monitor()) {
      check_orphaned();
      CTExternalLink cTExternalLink = null;
      cTExternalLink = (CTExternalLink)get_store().find_element_user(EXTERNALLINK$0, 0);
      if (cTExternalLink == null)
        cTExternalLink = (CTExternalLink)get_store().add_element_user(EXTERNALLINK$0); 
      cTExternalLink.set((XmlObject)paramCTExternalLink);
    } 
  }
  
  public CTExternalLink addNewExternalLink() {
    synchronized (monitor()) {
      check_orphaned();
      CTExternalLink cTExternalLink = null;
      cTExternalLink = (CTExternalLink)get_store().add_element_user(EXTERNALLINK$0);
      return cTExternalLink;
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\ExternalLinkDocumentImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */