package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBaseStyles;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorScheme;
import org.openxmlformats.schemas.drawingml.x2006.main.CTFontScheme;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrix;

public class CTBaseStylesImpl extends XmlComplexContentImpl implements CTBaseStyles {
  private static final b CLRSCHEME$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "clrScheme");
  
  private static final b FONTSCHEME$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "fontScheme");
  
  private static final b FMTSCHEME$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "fmtScheme");
  
  private static final b EXTLST$6 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "extLst");
  
  public CTBaseStylesImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTColorScheme getClrScheme() {
    synchronized (monitor()) {
      check_orphaned();
      CTColorScheme cTColorScheme = null;
      cTColorScheme = (CTColorScheme)get_store().find_element_user(CLRSCHEME$0, 0);
      if (cTColorScheme == null)
        return null; 
      return cTColorScheme;
    } 
  }
  
  public void setClrScheme(CTColorScheme paramCTColorScheme) {
    synchronized (monitor()) {
      check_orphaned();
      CTColorScheme cTColorScheme = null;
      cTColorScheme = (CTColorScheme)get_store().find_element_user(CLRSCHEME$0, 0);
      if (cTColorScheme == null)
        cTColorScheme = (CTColorScheme)get_store().add_element_user(CLRSCHEME$0); 
      cTColorScheme.set((XmlObject)paramCTColorScheme);
    } 
  }
  
  public CTColorScheme addNewClrScheme() {
    synchronized (monitor()) {
      check_orphaned();
      CTColorScheme cTColorScheme = null;
      cTColorScheme = (CTColorScheme)get_store().add_element_user(CLRSCHEME$0);
      return cTColorScheme;
    } 
  }
  
  public CTFontScheme getFontScheme() {
    synchronized (monitor()) {
      check_orphaned();
      CTFontScheme cTFontScheme = null;
      cTFontScheme = (CTFontScheme)get_store().find_element_user(FONTSCHEME$2, 0);
      if (cTFontScheme == null)
        return null; 
      return cTFontScheme;
    } 
  }
  
  public void setFontScheme(CTFontScheme paramCTFontScheme) {
    synchronized (monitor()) {
      check_orphaned();
      CTFontScheme cTFontScheme = null;
      cTFontScheme = (CTFontScheme)get_store().find_element_user(FONTSCHEME$2, 0);
      if (cTFontScheme == null)
        cTFontScheme = (CTFontScheme)get_store().add_element_user(FONTSCHEME$2); 
      cTFontScheme.set((XmlObject)paramCTFontScheme);
    } 
  }
  
  public CTFontScheme addNewFontScheme() {
    synchronized (monitor()) {
      check_orphaned();
      CTFontScheme cTFontScheme = null;
      cTFontScheme = (CTFontScheme)get_store().add_element_user(FONTSCHEME$2);
      return cTFontScheme;
    } 
  }
  
  public CTStyleMatrix getFmtScheme() {
    synchronized (monitor()) {
      check_orphaned();
      CTStyleMatrix cTStyleMatrix = null;
      cTStyleMatrix = (CTStyleMatrix)get_store().find_element_user(FMTSCHEME$4, 0);
      if (cTStyleMatrix == null)
        return null; 
      return cTStyleMatrix;
    } 
  }
  
  public void setFmtScheme(CTStyleMatrix paramCTStyleMatrix) {
    synchronized (monitor()) {
      check_orphaned();
      CTStyleMatrix cTStyleMatrix = null;
      cTStyleMatrix = (CTStyleMatrix)get_store().find_element_user(FMTSCHEME$4, 0);
      if (cTStyleMatrix == null)
        cTStyleMatrix = (CTStyleMatrix)get_store().add_element_user(FMTSCHEME$4); 
      cTStyleMatrix.set((XmlObject)paramCTStyleMatrix);
    } 
  }
  
  public CTStyleMatrix addNewFmtScheme() {
    synchronized (monitor()) {
      check_orphaned();
      CTStyleMatrix cTStyleMatrix = null;
      cTStyleMatrix = (CTStyleMatrix)get_store().add_element_user(FMTSCHEME$4);
      return cTStyleMatrix;
    } 
  }
  
  public CTOfficeArtExtensionList getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().find_element_user(EXTLST$6, 0);
      if (cTOfficeArtExtensionList == null)
        return null; 
      return cTOfficeArtExtensionList;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$6) != 0);
    } 
  }
  
  public void setExtLst(CTOfficeArtExtensionList paramCTOfficeArtExtensionList) {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().find_element_user(EXTLST$6, 0);
      if (cTOfficeArtExtensionList == null)
        cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().add_element_user(EXTLST$6); 
      cTOfficeArtExtensionList.set((XmlObject)paramCTOfficeArtExtensionList);
    } 
  }
  
  public CTOfficeArtExtensionList addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().add_element_user(EXTLST$6);
      return cTOfficeArtExtensionList;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$6, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTBaseStylesImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */