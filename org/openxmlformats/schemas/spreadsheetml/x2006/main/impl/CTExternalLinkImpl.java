package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDdeLink;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalBook;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalLink;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleLink;

public class CTExternalLinkImpl extends XmlComplexContentImpl implements CTExternalLink {
  private static final b EXTERNALBOOK$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "externalBook");
  
  private static final b DDELINK$2 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "ddeLink");
  
  private static final b OLELINK$4 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "oleLink");
  
  private static final b EXTLST$6 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "extLst");
  
  public CTExternalLinkImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTExternalBook getExternalBook() {
    synchronized (monitor()) {
      check_orphaned();
      CTExternalBook cTExternalBook = null;
      cTExternalBook = (CTExternalBook)get_store().find_element_user(EXTERNALBOOK$0, 0);
      if (cTExternalBook == null)
        return null; 
      return cTExternalBook;
    } 
  }
  
  public boolean isSetExternalBook() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTERNALBOOK$0) != 0);
    } 
  }
  
  public void setExternalBook(CTExternalBook paramCTExternalBook) {
    synchronized (monitor()) {
      check_orphaned();
      CTExternalBook cTExternalBook = null;
      cTExternalBook = (CTExternalBook)get_store().find_element_user(EXTERNALBOOK$0, 0);
      if (cTExternalBook == null)
        cTExternalBook = (CTExternalBook)get_store().add_element_user(EXTERNALBOOK$0); 
      cTExternalBook.set((XmlObject)paramCTExternalBook);
    } 
  }
  
  public CTExternalBook addNewExternalBook() {
    synchronized (monitor()) {
      check_orphaned();
      CTExternalBook cTExternalBook = null;
      cTExternalBook = (CTExternalBook)get_store().add_element_user(EXTERNALBOOK$0);
      return cTExternalBook;
    } 
  }
  
  public void unsetExternalBook() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTERNALBOOK$0, 0);
    } 
  }
  
  public CTDdeLink getDdeLink() {
    synchronized (monitor()) {
      check_orphaned();
      CTDdeLink cTDdeLink = null;
      cTDdeLink = (CTDdeLink)get_store().find_element_user(DDELINK$2, 0);
      if (cTDdeLink == null)
        return null; 
      return cTDdeLink;
    } 
  }
  
  public boolean isSetDdeLink() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DDELINK$2) != 0);
    } 
  }
  
  public void setDdeLink(CTDdeLink paramCTDdeLink) {
    synchronized (monitor()) {
      check_orphaned();
      CTDdeLink cTDdeLink = null;
      cTDdeLink = (CTDdeLink)get_store().find_element_user(DDELINK$2, 0);
      if (cTDdeLink == null)
        cTDdeLink = (CTDdeLink)get_store().add_element_user(DDELINK$2); 
      cTDdeLink.set((XmlObject)paramCTDdeLink);
    } 
  }
  
  public CTDdeLink addNewDdeLink() {
    synchronized (monitor()) {
      check_orphaned();
      CTDdeLink cTDdeLink = null;
      cTDdeLink = (CTDdeLink)get_store().add_element_user(DDELINK$2);
      return cTDdeLink;
    } 
  }
  
  public void unsetDdeLink() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DDELINK$2, 0);
    } 
  }
  
  public CTOleLink getOleLink() {
    synchronized (monitor()) {
      check_orphaned();
      CTOleLink cTOleLink = null;
      cTOleLink = (CTOleLink)get_store().find_element_user(OLELINK$4, 0);
      if (cTOleLink == null)
        return null; 
      return cTOleLink;
    } 
  }
  
  public boolean isSetOleLink() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(OLELINK$4) != 0);
    } 
  }
  
  public void setOleLink(CTOleLink paramCTOleLink) {
    synchronized (monitor()) {
      check_orphaned();
      CTOleLink cTOleLink = null;
      cTOleLink = (CTOleLink)get_store().find_element_user(OLELINK$4, 0);
      if (cTOleLink == null)
        cTOleLink = (CTOleLink)get_store().add_element_user(OLELINK$4); 
      cTOleLink.set((XmlObject)paramCTOleLink);
    } 
  }
  
  public CTOleLink addNewOleLink() {
    synchronized (monitor()) {
      check_orphaned();
      CTOleLink cTOleLink = null;
      cTOleLink = (CTOleLink)get_store().add_element_user(OLELINK$4);
      return cTOleLink;
    } 
  }
  
  public void unsetOleLink() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(OLELINK$4, 0);
    } 
  }
  
  public CTExtensionList getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$6, 0);
      if (cTExtensionList == null)
        return null; 
      return cTExtensionList;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$6) != 0);
    } 
  }
  
  public void setExtLst(CTExtensionList paramCTExtensionList) {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$6, 0);
      if (cTExtensionList == null)
        cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$6); 
      cTExtensionList.set((XmlObject)paramCTExtensionList);
    } 
  }
  
  public CTExtensionList addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$6);
      return cTExtensionList;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$6, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTExternalLinkImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */