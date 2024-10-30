package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTFontReference;
import org.openxmlformats.schemas.drawingml.x2006.main.CTHslColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTScRgbColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSchemeColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor;
import org.openxmlformats.schemas.drawingml.x2006.main.STFontCollectionIndex;

public class CTFontReferenceImpl extends XmlComplexContentImpl implements CTFontReference {
  private static final b SCRGBCLR$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "scrgbClr");
  
  private static final b SRGBCLR$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "srgbClr");
  
  private static final b HSLCLR$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "hslClr");
  
  private static final b SYSCLR$6 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "sysClr");
  
  private static final b SCHEMECLR$8 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "schemeClr");
  
  private static final b PRSTCLR$10 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "prstClr");
  
  private static final b IDX$12 = new b("", "idx");
  
  public CTFontReferenceImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTScRgbColor getScrgbClr() {
    synchronized (monitor()) {
      check_orphaned();
      CTScRgbColor cTScRgbColor = null;
      cTScRgbColor = (CTScRgbColor)get_store().find_element_user(SCRGBCLR$0, 0);
      if (cTScRgbColor == null)
        return null; 
      return cTScRgbColor;
    } 
  }
  
  public boolean isSetScrgbClr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SCRGBCLR$0) != 0);
    } 
  }
  
  public void setScrgbClr(CTScRgbColor paramCTScRgbColor) {
    synchronized (monitor()) {
      check_orphaned();
      CTScRgbColor cTScRgbColor = null;
      cTScRgbColor = (CTScRgbColor)get_store().find_element_user(SCRGBCLR$0, 0);
      if (cTScRgbColor == null)
        cTScRgbColor = (CTScRgbColor)get_store().add_element_user(SCRGBCLR$0); 
      cTScRgbColor.set((XmlObject)paramCTScRgbColor);
    } 
  }
  
  public CTScRgbColor addNewScrgbClr() {
    synchronized (monitor()) {
      check_orphaned();
      CTScRgbColor cTScRgbColor = null;
      cTScRgbColor = (CTScRgbColor)get_store().add_element_user(SCRGBCLR$0);
      return cTScRgbColor;
    } 
  }
  
  public void unsetScrgbClr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SCRGBCLR$0, 0);
    } 
  }
  
  public CTSRgbColor getSrgbClr() {
    synchronized (monitor()) {
      check_orphaned();
      CTSRgbColor cTSRgbColor = null;
      cTSRgbColor = (CTSRgbColor)get_store().find_element_user(SRGBCLR$2, 0);
      if (cTSRgbColor == null)
        return null; 
      return cTSRgbColor;
    } 
  }
  
  public boolean isSetSrgbClr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SRGBCLR$2) != 0);
    } 
  }
  
  public void setSrgbClr(CTSRgbColor paramCTSRgbColor) {
    synchronized (monitor()) {
      check_orphaned();
      CTSRgbColor cTSRgbColor = null;
      cTSRgbColor = (CTSRgbColor)get_store().find_element_user(SRGBCLR$2, 0);
      if (cTSRgbColor == null)
        cTSRgbColor = (CTSRgbColor)get_store().add_element_user(SRGBCLR$2); 
      cTSRgbColor.set((XmlObject)paramCTSRgbColor);
    } 
  }
  
  public CTSRgbColor addNewSrgbClr() {
    synchronized (monitor()) {
      check_orphaned();
      CTSRgbColor cTSRgbColor = null;
      cTSRgbColor = (CTSRgbColor)get_store().add_element_user(SRGBCLR$2);
      return cTSRgbColor;
    } 
  }
  
  public void unsetSrgbClr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SRGBCLR$2, 0);
    } 
  }
  
  public CTHslColor getHslClr() {
    synchronized (monitor()) {
      check_orphaned();
      CTHslColor cTHslColor = null;
      cTHslColor = (CTHslColor)get_store().find_element_user(HSLCLR$4, 0);
      if (cTHslColor == null)
        return null; 
      return cTHslColor;
    } 
  }
  
  public boolean isSetHslClr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(HSLCLR$4) != 0);
    } 
  }
  
  public void setHslClr(CTHslColor paramCTHslColor) {
    synchronized (monitor()) {
      check_orphaned();
      CTHslColor cTHslColor = null;
      cTHslColor = (CTHslColor)get_store().find_element_user(HSLCLR$4, 0);
      if (cTHslColor == null)
        cTHslColor = (CTHslColor)get_store().add_element_user(HSLCLR$4); 
      cTHslColor.set((XmlObject)paramCTHslColor);
    } 
  }
  
  public CTHslColor addNewHslClr() {
    synchronized (monitor()) {
      check_orphaned();
      CTHslColor cTHslColor = null;
      cTHslColor = (CTHslColor)get_store().add_element_user(HSLCLR$4);
      return cTHslColor;
    } 
  }
  
  public void unsetHslClr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(HSLCLR$4, 0);
    } 
  }
  
  public CTSystemColor getSysClr() {
    synchronized (monitor()) {
      check_orphaned();
      CTSystemColor cTSystemColor = null;
      cTSystemColor = (CTSystemColor)get_store().find_element_user(SYSCLR$6, 0);
      if (cTSystemColor == null)
        return null; 
      return cTSystemColor;
    } 
  }
  
  public boolean isSetSysClr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SYSCLR$6) != 0);
    } 
  }
  
  public void setSysClr(CTSystemColor paramCTSystemColor) {
    synchronized (monitor()) {
      check_orphaned();
      CTSystemColor cTSystemColor = null;
      cTSystemColor = (CTSystemColor)get_store().find_element_user(SYSCLR$6, 0);
      if (cTSystemColor == null)
        cTSystemColor = (CTSystemColor)get_store().add_element_user(SYSCLR$6); 
      cTSystemColor.set((XmlObject)paramCTSystemColor);
    } 
  }
  
  public CTSystemColor addNewSysClr() {
    synchronized (monitor()) {
      check_orphaned();
      CTSystemColor cTSystemColor = null;
      cTSystemColor = (CTSystemColor)get_store().add_element_user(SYSCLR$6);
      return cTSystemColor;
    } 
  }
  
  public void unsetSysClr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SYSCLR$6, 0);
    } 
  }
  
  public CTSchemeColor getSchemeClr() {
    synchronized (monitor()) {
      check_orphaned();
      CTSchemeColor cTSchemeColor = null;
      cTSchemeColor = (CTSchemeColor)get_store().find_element_user(SCHEMECLR$8, 0);
      if (cTSchemeColor == null)
        return null; 
      return cTSchemeColor;
    } 
  }
  
  public boolean isSetSchemeClr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SCHEMECLR$8) != 0);
    } 
  }
  
  public void setSchemeClr(CTSchemeColor paramCTSchemeColor) {
    synchronized (monitor()) {
      check_orphaned();
      CTSchemeColor cTSchemeColor = null;
      cTSchemeColor = (CTSchemeColor)get_store().find_element_user(SCHEMECLR$8, 0);
      if (cTSchemeColor == null)
        cTSchemeColor = (CTSchemeColor)get_store().add_element_user(SCHEMECLR$8); 
      cTSchemeColor.set((XmlObject)paramCTSchemeColor);
    } 
  }
  
  public CTSchemeColor addNewSchemeClr() {
    synchronized (monitor()) {
      check_orphaned();
      CTSchemeColor cTSchemeColor = null;
      cTSchemeColor = (CTSchemeColor)get_store().add_element_user(SCHEMECLR$8);
      return cTSchemeColor;
    } 
  }
  
  public void unsetSchemeClr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SCHEMECLR$8, 0);
    } 
  }
  
  public CTPresetColor getPrstClr() {
    synchronized (monitor()) {
      check_orphaned();
      CTPresetColor cTPresetColor = null;
      cTPresetColor = (CTPresetColor)get_store().find_element_user(PRSTCLR$10, 0);
      if (cTPresetColor == null)
        return null; 
      return cTPresetColor;
    } 
  }
  
  public boolean isSetPrstClr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PRSTCLR$10) != 0);
    } 
  }
  
  public void setPrstClr(CTPresetColor paramCTPresetColor) {
    synchronized (monitor()) {
      check_orphaned();
      CTPresetColor cTPresetColor = null;
      cTPresetColor = (CTPresetColor)get_store().find_element_user(PRSTCLR$10, 0);
      if (cTPresetColor == null)
        cTPresetColor = (CTPresetColor)get_store().add_element_user(PRSTCLR$10); 
      cTPresetColor.set((XmlObject)paramCTPresetColor);
    } 
  }
  
  public CTPresetColor addNewPrstClr() {
    synchronized (monitor()) {
      check_orphaned();
      CTPresetColor cTPresetColor = null;
      cTPresetColor = (CTPresetColor)get_store().add_element_user(PRSTCLR$10);
      return cTPresetColor;
    } 
  }
  
  public void unsetPrstClr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PRSTCLR$10, 0);
    } 
  }
  
  public STFontCollectionIndex.Enum getIdx() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(IDX$12);
      if (simpleValue == null)
        return null; 
      return (STFontCollectionIndex.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STFontCollectionIndex xgetIdx() {
    synchronized (monitor()) {
      check_orphaned();
      STFontCollectionIndex sTFontCollectionIndex = null;
      sTFontCollectionIndex = (STFontCollectionIndex)get_store().find_attribute_user(IDX$12);
      return sTFontCollectionIndex;
    } 
  }
  
  public void setIdx(STFontCollectionIndex.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(IDX$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(IDX$12); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetIdx(STFontCollectionIndex paramSTFontCollectionIndex) {
    synchronized (monitor()) {
      check_orphaned();
      STFontCollectionIndex sTFontCollectionIndex = null;
      sTFontCollectionIndex = (STFontCollectionIndex)get_store().find_attribute_user(IDX$12);
      if (sTFontCollectionIndex == null)
        sTFontCollectionIndex = (STFontCollectionIndex)get_store().add_attribute_user(IDX$12); 
      sTFontCollectionIndex.set((XmlObject)paramSTFontCollectionIndex);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTFontReferenceImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */