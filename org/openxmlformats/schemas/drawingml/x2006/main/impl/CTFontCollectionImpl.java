package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTFontCollection;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSupplementalFont;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextFont;

public class CTFontCollectionImpl extends XmlComplexContentImpl implements CTFontCollection {
  private static final b LATIN$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "latin");
  
  private static final b EA$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "ea");
  
  private static final b CS$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "cs");
  
  private static final b FONT$6 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "font");
  
  private static final b EXTLST$8 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "extLst");
  
  public CTFontCollectionImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTTextFont getLatin() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextFont cTTextFont = null;
      cTTextFont = (CTTextFont)get_store().find_element_user(LATIN$0, 0);
      if (cTTextFont == null)
        return null; 
      return cTTextFont;
    } 
  }
  
  public void setLatin(CTTextFont paramCTTextFont) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextFont cTTextFont = null;
      cTTextFont = (CTTextFont)get_store().find_element_user(LATIN$0, 0);
      if (cTTextFont == null)
        cTTextFont = (CTTextFont)get_store().add_element_user(LATIN$0); 
      cTTextFont.set((XmlObject)paramCTTextFont);
    } 
  }
  
  public CTTextFont addNewLatin() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextFont cTTextFont = null;
      cTTextFont = (CTTextFont)get_store().add_element_user(LATIN$0);
      return cTTextFont;
    } 
  }
  
  public CTTextFont getEa() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextFont cTTextFont = null;
      cTTextFont = (CTTextFont)get_store().find_element_user(EA$2, 0);
      if (cTTextFont == null)
        return null; 
      return cTTextFont;
    } 
  }
  
  public void setEa(CTTextFont paramCTTextFont) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextFont cTTextFont = null;
      cTTextFont = (CTTextFont)get_store().find_element_user(EA$2, 0);
      if (cTTextFont == null)
        cTTextFont = (CTTextFont)get_store().add_element_user(EA$2); 
      cTTextFont.set((XmlObject)paramCTTextFont);
    } 
  }
  
  public CTTextFont addNewEa() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextFont cTTextFont = null;
      cTTextFont = (CTTextFont)get_store().add_element_user(EA$2);
      return cTTextFont;
    } 
  }
  
  public CTTextFont getCs() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextFont cTTextFont = null;
      cTTextFont = (CTTextFont)get_store().find_element_user(CS$4, 0);
      if (cTTextFont == null)
        return null; 
      return cTTextFont;
    } 
  }
  
  public void setCs(CTTextFont paramCTTextFont) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextFont cTTextFont = null;
      cTTextFont = (CTTextFont)get_store().find_element_user(CS$4, 0);
      if (cTTextFont == null)
        cTTextFont = (CTTextFont)get_store().add_element_user(CS$4); 
      cTTextFont.set((XmlObject)paramCTTextFont);
    } 
  }
  
  public CTTextFont addNewCs() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextFont cTTextFont = null;
      cTTextFont = (CTTextFont)get_store().add_element_user(CS$4);
      return cTTextFont;
    } 
  }
  
  public List<CTSupplementalFont> getFontList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTSupplementalFont>)new FontList(this);
    } 
  }
  
  public CTSupplementalFont[] getFontArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(FONT$6, arrayList);
      CTSupplementalFont[] arrayOfCTSupplementalFont = new CTSupplementalFont[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTSupplementalFont);
      return arrayOfCTSupplementalFont;
    } 
  }
  
  public CTSupplementalFont getFontArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTSupplementalFont cTSupplementalFont = null;
      cTSupplementalFont = (CTSupplementalFont)get_store().find_element_user(FONT$6, paramInt);
      if (cTSupplementalFont == null)
        throw new IndexOutOfBoundsException(); 
      return cTSupplementalFont;
    } 
  }
  
  public int sizeOfFontArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(FONT$6);
    } 
  }
  
  public void setFontArray(CTSupplementalFont[] paramArrayOfCTSupplementalFont) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTSupplementalFont, FONT$6);
    } 
  }
  
  public void setFontArray(int paramInt, CTSupplementalFont paramCTSupplementalFont) {
    synchronized (monitor()) {
      check_orphaned();
      CTSupplementalFont cTSupplementalFont = null;
      cTSupplementalFont = (CTSupplementalFont)get_store().find_element_user(FONT$6, paramInt);
      if (cTSupplementalFont == null)
        throw new IndexOutOfBoundsException(); 
      cTSupplementalFont.set((XmlObject)paramCTSupplementalFont);
    } 
  }
  
  public CTSupplementalFont insertNewFont(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTSupplementalFont cTSupplementalFont = null;
      cTSupplementalFont = (CTSupplementalFont)get_store().insert_element_user(FONT$6, paramInt);
      return cTSupplementalFont;
    } 
  }
  
  public CTSupplementalFont addNewFont() {
    synchronized (monitor()) {
      check_orphaned();
      CTSupplementalFont cTSupplementalFont = null;
      cTSupplementalFont = (CTSupplementalFont)get_store().add_element_user(FONT$6);
      return cTSupplementalFont;
    } 
  }
  
  public void removeFont(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(FONT$6, paramInt);
    } 
  }
  
  public CTOfficeArtExtensionList getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().find_element_user(EXTLST$8, 0);
      if (cTOfficeArtExtensionList == null)
        return null; 
      return cTOfficeArtExtensionList;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$8) != 0);
    } 
  }
  
  public void setExtLst(CTOfficeArtExtensionList paramCTOfficeArtExtensionList) {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().find_element_user(EXTLST$8, 0);
      if (cTOfficeArtExtensionList == null)
        cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().add_element_user(EXTLST$8); 
      cTOfficeArtExtensionList.set((XmlObject)paramCTOfficeArtExtensionList);
    } 
  }
  
  public CTOfficeArtExtensionList addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().add_element_user(EXTLST$8);
      return cTOfficeArtExtensionList;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$8, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTFontCollectionImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */