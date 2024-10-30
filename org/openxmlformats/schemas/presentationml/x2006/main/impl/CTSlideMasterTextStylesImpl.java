package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle;
import org.openxmlformats.schemas.presentationml.x2006.main.CTExtensionList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterTextStyles;

public class CTSlideMasterTextStylesImpl extends XmlComplexContentImpl implements CTSlideMasterTextStyles {
  private static final b TITLESTYLE$0 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "titleStyle");
  
  private static final b BODYSTYLE$2 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "bodyStyle");
  
  private static final b OTHERSTYLE$4 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "otherStyle");
  
  private static final b EXTLST$6 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "extLst");
  
  public CTSlideMasterTextStylesImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTTextListStyle getTitleStyle() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextListStyle cTTextListStyle = null;
      cTTextListStyle = (CTTextListStyle)get_store().find_element_user(TITLESTYLE$0, 0);
      if (cTTextListStyle == null)
        return null; 
      return cTTextListStyle;
    } 
  }
  
  public boolean isSetTitleStyle() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TITLESTYLE$0) != 0);
    } 
  }
  
  public void setTitleStyle(CTTextListStyle paramCTTextListStyle) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextListStyle cTTextListStyle = null;
      cTTextListStyle = (CTTextListStyle)get_store().find_element_user(TITLESTYLE$0, 0);
      if (cTTextListStyle == null)
        cTTextListStyle = (CTTextListStyle)get_store().add_element_user(TITLESTYLE$0); 
      cTTextListStyle.set((XmlObject)paramCTTextListStyle);
    } 
  }
  
  public CTTextListStyle addNewTitleStyle() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextListStyle cTTextListStyle = null;
      cTTextListStyle = (CTTextListStyle)get_store().add_element_user(TITLESTYLE$0);
      return cTTextListStyle;
    } 
  }
  
  public void unsetTitleStyle() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TITLESTYLE$0, 0);
    } 
  }
  
  public CTTextListStyle getBodyStyle() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextListStyle cTTextListStyle = null;
      cTTextListStyle = (CTTextListStyle)get_store().find_element_user(BODYSTYLE$2, 0);
      if (cTTextListStyle == null)
        return null; 
      return cTTextListStyle;
    } 
  }
  
  public boolean isSetBodyStyle() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(BODYSTYLE$2) != 0);
    } 
  }
  
  public void setBodyStyle(CTTextListStyle paramCTTextListStyle) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextListStyle cTTextListStyle = null;
      cTTextListStyle = (CTTextListStyle)get_store().find_element_user(BODYSTYLE$2, 0);
      if (cTTextListStyle == null)
        cTTextListStyle = (CTTextListStyle)get_store().add_element_user(BODYSTYLE$2); 
      cTTextListStyle.set((XmlObject)paramCTTextListStyle);
    } 
  }
  
  public CTTextListStyle addNewBodyStyle() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextListStyle cTTextListStyle = null;
      cTTextListStyle = (CTTextListStyle)get_store().add_element_user(BODYSTYLE$2);
      return cTTextListStyle;
    } 
  }
  
  public void unsetBodyStyle() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BODYSTYLE$2, 0);
    } 
  }
  
  public CTTextListStyle getOtherStyle() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextListStyle cTTextListStyle = null;
      cTTextListStyle = (CTTextListStyle)get_store().find_element_user(OTHERSTYLE$4, 0);
      if (cTTextListStyle == null)
        return null; 
      return cTTextListStyle;
    } 
  }
  
  public boolean isSetOtherStyle() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(OTHERSTYLE$4) != 0);
    } 
  }
  
  public void setOtherStyle(CTTextListStyle paramCTTextListStyle) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextListStyle cTTextListStyle = null;
      cTTextListStyle = (CTTextListStyle)get_store().find_element_user(OTHERSTYLE$4, 0);
      if (cTTextListStyle == null)
        cTTextListStyle = (CTTextListStyle)get_store().add_element_user(OTHERSTYLE$4); 
      cTTextListStyle.set((XmlObject)paramCTTextListStyle);
    } 
  }
  
  public CTTextListStyle addNewOtherStyle() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextListStyle cTTextListStyle = null;
      cTTextListStyle = (CTTextListStyle)get_store().add_element_user(OTHERSTYLE$4);
      return cTTextListStyle;
    } 
  }
  
  public void unsetOtherStyle() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(OTHERSTYLE$4, 0);
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\impl\CTSlideMasterTextStylesImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */