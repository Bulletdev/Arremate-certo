package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData;
import org.openxmlformats.schemas.presentationml.x2006.main.CTExtensionListModify;
import org.openxmlformats.schemas.presentationml.x2006.main.CTHeaderFooter;
import org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMaster;

public class CTNotesMasterImpl extends XmlComplexContentImpl implements CTNotesMaster {
  private static final b CSLD$0 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "cSld");
  
  private static final b CLRMAP$2 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "clrMap");
  
  private static final b HF$4 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "hf");
  
  private static final b NOTESSTYLE$6 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "notesStyle");
  
  private static final b EXTLST$8 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "extLst");
  
  public CTNotesMasterImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTCommonSlideData getCSld() {
    synchronized (monitor()) {
      check_orphaned();
      CTCommonSlideData cTCommonSlideData = null;
      cTCommonSlideData = (CTCommonSlideData)get_store().find_element_user(CSLD$0, 0);
      if (cTCommonSlideData == null)
        return null; 
      return cTCommonSlideData;
    } 
  }
  
  public void setCSld(CTCommonSlideData paramCTCommonSlideData) {
    synchronized (monitor()) {
      check_orphaned();
      CTCommonSlideData cTCommonSlideData = null;
      cTCommonSlideData = (CTCommonSlideData)get_store().find_element_user(CSLD$0, 0);
      if (cTCommonSlideData == null)
        cTCommonSlideData = (CTCommonSlideData)get_store().add_element_user(CSLD$0); 
      cTCommonSlideData.set((XmlObject)paramCTCommonSlideData);
    } 
  }
  
  public CTCommonSlideData addNewCSld() {
    synchronized (monitor()) {
      check_orphaned();
      CTCommonSlideData cTCommonSlideData = null;
      cTCommonSlideData = (CTCommonSlideData)get_store().add_element_user(CSLD$0);
      return cTCommonSlideData;
    } 
  }
  
  public CTColorMapping getClrMap() {
    synchronized (monitor()) {
      check_orphaned();
      CTColorMapping cTColorMapping = null;
      cTColorMapping = (CTColorMapping)get_store().find_element_user(CLRMAP$2, 0);
      if (cTColorMapping == null)
        return null; 
      return cTColorMapping;
    } 
  }
  
  public void setClrMap(CTColorMapping paramCTColorMapping) {
    synchronized (monitor()) {
      check_orphaned();
      CTColorMapping cTColorMapping = null;
      cTColorMapping = (CTColorMapping)get_store().find_element_user(CLRMAP$2, 0);
      if (cTColorMapping == null)
        cTColorMapping = (CTColorMapping)get_store().add_element_user(CLRMAP$2); 
      cTColorMapping.set((XmlObject)paramCTColorMapping);
    } 
  }
  
  public CTColorMapping addNewClrMap() {
    synchronized (monitor()) {
      check_orphaned();
      CTColorMapping cTColorMapping = null;
      cTColorMapping = (CTColorMapping)get_store().add_element_user(CLRMAP$2);
      return cTColorMapping;
    } 
  }
  
  public CTHeaderFooter getHf() {
    synchronized (monitor()) {
      check_orphaned();
      CTHeaderFooter cTHeaderFooter = null;
      cTHeaderFooter = (CTHeaderFooter)get_store().find_element_user(HF$4, 0);
      if (cTHeaderFooter == null)
        return null; 
      return cTHeaderFooter;
    } 
  }
  
  public boolean isSetHf() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(HF$4) != 0);
    } 
  }
  
  public void setHf(CTHeaderFooter paramCTHeaderFooter) {
    synchronized (monitor()) {
      check_orphaned();
      CTHeaderFooter cTHeaderFooter = null;
      cTHeaderFooter = (CTHeaderFooter)get_store().find_element_user(HF$4, 0);
      if (cTHeaderFooter == null)
        cTHeaderFooter = (CTHeaderFooter)get_store().add_element_user(HF$4); 
      cTHeaderFooter.set((XmlObject)paramCTHeaderFooter);
    } 
  }
  
  public CTHeaderFooter addNewHf() {
    synchronized (monitor()) {
      check_orphaned();
      CTHeaderFooter cTHeaderFooter = null;
      cTHeaderFooter = (CTHeaderFooter)get_store().add_element_user(HF$4);
      return cTHeaderFooter;
    } 
  }
  
  public void unsetHf() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(HF$4, 0);
    } 
  }
  
  public CTTextListStyle getNotesStyle() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextListStyle cTTextListStyle = null;
      cTTextListStyle = (CTTextListStyle)get_store().find_element_user(NOTESSTYLE$6, 0);
      if (cTTextListStyle == null)
        return null; 
      return cTTextListStyle;
    } 
  }
  
  public boolean isSetNotesStyle() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(NOTESSTYLE$6) != 0);
    } 
  }
  
  public void setNotesStyle(CTTextListStyle paramCTTextListStyle) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextListStyle cTTextListStyle = null;
      cTTextListStyle = (CTTextListStyle)get_store().find_element_user(NOTESSTYLE$6, 0);
      if (cTTextListStyle == null)
        cTTextListStyle = (CTTextListStyle)get_store().add_element_user(NOTESSTYLE$6); 
      cTTextListStyle.set((XmlObject)paramCTTextListStyle);
    } 
  }
  
  public CTTextListStyle addNewNotesStyle() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextListStyle cTTextListStyle = null;
      cTTextListStyle = (CTTextListStyle)get_store().add_element_user(NOTESSTYLE$6);
      return cTTextListStyle;
    } 
  }
  
  public void unsetNotesStyle() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(NOTESSTYLE$6, 0);
    } 
  }
  
  public CTExtensionListModify getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionListModify cTExtensionListModify = null;
      cTExtensionListModify = (CTExtensionListModify)get_store().find_element_user(EXTLST$8, 0);
      if (cTExtensionListModify == null)
        return null; 
      return cTExtensionListModify;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$8) != 0);
    } 
  }
  
  public void setExtLst(CTExtensionListModify paramCTExtensionListModify) {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionListModify cTExtensionListModify = null;
      cTExtensionListModify = (CTExtensionListModify)get_store().find_element_user(EXTLST$8, 0);
      if (cTExtensionListModify == null)
        cTExtensionListModify = (CTExtensionListModify)get_store().add_element_user(EXTLST$8); 
      cTExtensionListModify.set((XmlObject)paramCTExtensionListModify);
    } 
  }
  
  public CTExtensionListModify addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionListModify cTExtensionListModify = null;
      cTExtensionListModify = (CTExtensionListModify)get_store().add_element_user(EXTLST$8);
      return cTExtensionListModify;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$8, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\impl\CTNotesMasterImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */