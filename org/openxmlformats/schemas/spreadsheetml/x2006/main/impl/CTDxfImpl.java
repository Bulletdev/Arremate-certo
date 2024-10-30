package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellAlignment;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellProtection;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxf;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFill;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTNumFmt;

public class CTDxfImpl extends XmlComplexContentImpl implements CTDxf {
  private static final b FONT$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "font");
  
  private static final b NUMFMT$2 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "numFmt");
  
  private static final b FILL$4 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "fill");
  
  private static final b ALIGNMENT$6 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "alignment");
  
  private static final b BORDER$8 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "border");
  
  private static final b PROTECTION$10 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "protection");
  
  private static final b EXTLST$12 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "extLst");
  
  public CTDxfImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTFont getFont() {
    synchronized (monitor()) {
      check_orphaned();
      CTFont cTFont = null;
      cTFont = (CTFont)get_store().find_element_user(FONT$0, 0);
      if (cTFont == null)
        return null; 
      return cTFont;
    } 
  }
  
  public boolean isSetFont() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(FONT$0) != 0);
    } 
  }
  
  public void setFont(CTFont paramCTFont) {
    synchronized (monitor()) {
      check_orphaned();
      CTFont cTFont = null;
      cTFont = (CTFont)get_store().find_element_user(FONT$0, 0);
      if (cTFont == null)
        cTFont = (CTFont)get_store().add_element_user(FONT$0); 
      cTFont.set((XmlObject)paramCTFont);
    } 
  }
  
  public CTFont addNewFont() {
    synchronized (monitor()) {
      check_orphaned();
      CTFont cTFont = null;
      cTFont = (CTFont)get_store().add_element_user(FONT$0);
      return cTFont;
    } 
  }
  
  public void unsetFont() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(FONT$0, 0);
    } 
  }
  
  public CTNumFmt getNumFmt() {
    synchronized (monitor()) {
      check_orphaned();
      CTNumFmt cTNumFmt = null;
      cTNumFmt = (CTNumFmt)get_store().find_element_user(NUMFMT$2, 0);
      if (cTNumFmt == null)
        return null; 
      return cTNumFmt;
    } 
  }
  
  public boolean isSetNumFmt() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(NUMFMT$2) != 0);
    } 
  }
  
  public void setNumFmt(CTNumFmt paramCTNumFmt) {
    synchronized (monitor()) {
      check_orphaned();
      CTNumFmt cTNumFmt = null;
      cTNumFmt = (CTNumFmt)get_store().find_element_user(NUMFMT$2, 0);
      if (cTNumFmt == null)
        cTNumFmt = (CTNumFmt)get_store().add_element_user(NUMFMT$2); 
      cTNumFmt.set((XmlObject)paramCTNumFmt);
    } 
  }
  
  public CTNumFmt addNewNumFmt() {
    synchronized (monitor()) {
      check_orphaned();
      CTNumFmt cTNumFmt = null;
      cTNumFmt = (CTNumFmt)get_store().add_element_user(NUMFMT$2);
      return cTNumFmt;
    } 
  }
  
  public void unsetNumFmt() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(NUMFMT$2, 0);
    } 
  }
  
  public CTFill getFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTFill cTFill = null;
      cTFill = (CTFill)get_store().find_element_user(FILL$4, 0);
      if (cTFill == null)
        return null; 
      return cTFill;
    } 
  }
  
  public boolean isSetFill() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(FILL$4) != 0);
    } 
  }
  
  public void setFill(CTFill paramCTFill) {
    synchronized (monitor()) {
      check_orphaned();
      CTFill cTFill = null;
      cTFill = (CTFill)get_store().find_element_user(FILL$4, 0);
      if (cTFill == null)
        cTFill = (CTFill)get_store().add_element_user(FILL$4); 
      cTFill.set((XmlObject)paramCTFill);
    } 
  }
  
  public CTFill addNewFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTFill cTFill = null;
      cTFill = (CTFill)get_store().add_element_user(FILL$4);
      return cTFill;
    } 
  }
  
  public void unsetFill() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(FILL$4, 0);
    } 
  }
  
  public CTCellAlignment getAlignment() {
    synchronized (monitor()) {
      check_orphaned();
      CTCellAlignment cTCellAlignment = null;
      cTCellAlignment = (CTCellAlignment)get_store().find_element_user(ALIGNMENT$6, 0);
      if (cTCellAlignment == null)
        return null; 
      return cTCellAlignment;
    } 
  }
  
  public boolean isSetAlignment() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(ALIGNMENT$6) != 0);
    } 
  }
  
  public void setAlignment(CTCellAlignment paramCTCellAlignment) {
    synchronized (monitor()) {
      check_orphaned();
      CTCellAlignment cTCellAlignment = null;
      cTCellAlignment = (CTCellAlignment)get_store().find_element_user(ALIGNMENT$6, 0);
      if (cTCellAlignment == null)
        cTCellAlignment = (CTCellAlignment)get_store().add_element_user(ALIGNMENT$6); 
      cTCellAlignment.set((XmlObject)paramCTCellAlignment);
    } 
  }
  
  public CTCellAlignment addNewAlignment() {
    synchronized (monitor()) {
      check_orphaned();
      CTCellAlignment cTCellAlignment = null;
      cTCellAlignment = (CTCellAlignment)get_store().add_element_user(ALIGNMENT$6);
      return cTCellAlignment;
    } 
  }
  
  public void unsetAlignment() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ALIGNMENT$6, 0);
    } 
  }
  
  public CTBorder getBorder() {
    synchronized (monitor()) {
      check_orphaned();
      CTBorder cTBorder = null;
      cTBorder = (CTBorder)get_store().find_element_user(BORDER$8, 0);
      if (cTBorder == null)
        return null; 
      return cTBorder;
    } 
  }
  
  public boolean isSetBorder() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(BORDER$8) != 0);
    } 
  }
  
  public void setBorder(CTBorder paramCTBorder) {
    synchronized (monitor()) {
      check_orphaned();
      CTBorder cTBorder = null;
      cTBorder = (CTBorder)get_store().find_element_user(BORDER$8, 0);
      if (cTBorder == null)
        cTBorder = (CTBorder)get_store().add_element_user(BORDER$8); 
      cTBorder.set((XmlObject)paramCTBorder);
    } 
  }
  
  public CTBorder addNewBorder() {
    synchronized (monitor()) {
      check_orphaned();
      CTBorder cTBorder = null;
      cTBorder = (CTBorder)get_store().add_element_user(BORDER$8);
      return cTBorder;
    } 
  }
  
  public void unsetBorder() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BORDER$8, 0);
    } 
  }
  
  public CTCellProtection getProtection() {
    synchronized (monitor()) {
      check_orphaned();
      CTCellProtection cTCellProtection = null;
      cTCellProtection = (CTCellProtection)get_store().find_element_user(PROTECTION$10, 0);
      if (cTCellProtection == null)
        return null; 
      return cTCellProtection;
    } 
  }
  
  public boolean isSetProtection() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PROTECTION$10) != 0);
    } 
  }
  
  public void setProtection(CTCellProtection paramCTCellProtection) {
    synchronized (monitor()) {
      check_orphaned();
      CTCellProtection cTCellProtection = null;
      cTCellProtection = (CTCellProtection)get_store().find_element_user(PROTECTION$10, 0);
      if (cTCellProtection == null)
        cTCellProtection = (CTCellProtection)get_store().add_element_user(PROTECTION$10); 
      cTCellProtection.set((XmlObject)paramCTCellProtection);
    } 
  }
  
  public CTCellProtection addNewProtection() {
    synchronized (monitor()) {
      check_orphaned();
      CTCellProtection cTCellProtection = null;
      cTCellProtection = (CTCellProtection)get_store().add_element_user(PROTECTION$10);
      return cTCellProtection;
    } 
  }
  
  public void unsetProtection() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PROTECTION$10, 0);
    } 
  }
  
  public CTExtensionList getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$12, 0);
      if (cTExtensionList == null)
        return null; 
      return cTExtensionList;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$12) != 0);
    } 
  }
  
  public void setExtLst(CTExtensionList paramCTExtensionList) {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$12, 0);
      if (cTExtensionList == null)
        cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$12); 
      cTExtensionList.set((XmlObject)paramCTExtensionList);
    } 
  }
  
  public CTExtensionList addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$12);
      return cTExtensionList;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$12, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTDxfImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */