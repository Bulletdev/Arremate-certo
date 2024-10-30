package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTFontCollection;
import org.openxmlformats.schemas.drawingml.x2006.main.CTFontReference;
import org.openxmlformats.schemas.drawingml.x2006.main.CTHslColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTScRgbColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSchemeColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleTextStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.STOnOffStyleType;

public class CTTableStyleTextStyleImpl extends XmlComplexContentImpl implements CTTableStyleTextStyle {
  private static final b FONT$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "font");
  
  private static final b FONTREF$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "fontRef");
  
  private static final b SCRGBCLR$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "scrgbClr");
  
  private static final b SRGBCLR$6 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "srgbClr");
  
  private static final b HSLCLR$8 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "hslClr");
  
  private static final b SYSCLR$10 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "sysClr");
  
  private static final b SCHEMECLR$12 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "schemeClr");
  
  private static final b PRSTCLR$14 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "prstClr");
  
  private static final b EXTLST$16 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "extLst");
  
  private static final b B$18 = new b("", "b");
  
  private static final b I$20 = new b("", "i");
  
  public CTTableStyleTextStyleImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTFontCollection getFont() {
    synchronized (monitor()) {
      check_orphaned();
      CTFontCollection cTFontCollection = null;
      cTFontCollection = (CTFontCollection)get_store().find_element_user(FONT$0, 0);
      if (cTFontCollection == null)
        return null; 
      return cTFontCollection;
    } 
  }
  
  public boolean isSetFont() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(FONT$0) != 0);
    } 
  }
  
  public void setFont(CTFontCollection paramCTFontCollection) {
    synchronized (monitor()) {
      check_orphaned();
      CTFontCollection cTFontCollection = null;
      cTFontCollection = (CTFontCollection)get_store().find_element_user(FONT$0, 0);
      if (cTFontCollection == null)
        cTFontCollection = (CTFontCollection)get_store().add_element_user(FONT$0); 
      cTFontCollection.set((XmlObject)paramCTFontCollection);
    } 
  }
  
  public CTFontCollection addNewFont() {
    synchronized (monitor()) {
      check_orphaned();
      CTFontCollection cTFontCollection = null;
      cTFontCollection = (CTFontCollection)get_store().add_element_user(FONT$0);
      return cTFontCollection;
    } 
  }
  
  public void unsetFont() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(FONT$0, 0);
    } 
  }
  
  public CTFontReference getFontRef() {
    synchronized (monitor()) {
      check_orphaned();
      CTFontReference cTFontReference = null;
      cTFontReference = (CTFontReference)get_store().find_element_user(FONTREF$2, 0);
      if (cTFontReference == null)
        return null; 
      return cTFontReference;
    } 
  }
  
  public boolean isSetFontRef() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(FONTREF$2) != 0);
    } 
  }
  
  public void setFontRef(CTFontReference paramCTFontReference) {
    synchronized (monitor()) {
      check_orphaned();
      CTFontReference cTFontReference = null;
      cTFontReference = (CTFontReference)get_store().find_element_user(FONTREF$2, 0);
      if (cTFontReference == null)
        cTFontReference = (CTFontReference)get_store().add_element_user(FONTREF$2); 
      cTFontReference.set((XmlObject)paramCTFontReference);
    } 
  }
  
  public CTFontReference addNewFontRef() {
    synchronized (monitor()) {
      check_orphaned();
      CTFontReference cTFontReference = null;
      cTFontReference = (CTFontReference)get_store().add_element_user(FONTREF$2);
      return cTFontReference;
    } 
  }
  
  public void unsetFontRef() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(FONTREF$2, 0);
    } 
  }
  
  public CTScRgbColor getScrgbClr() {
    synchronized (monitor()) {
      check_orphaned();
      CTScRgbColor cTScRgbColor = null;
      cTScRgbColor = (CTScRgbColor)get_store().find_element_user(SCRGBCLR$4, 0);
      if (cTScRgbColor == null)
        return null; 
      return cTScRgbColor;
    } 
  }
  
  public boolean isSetScrgbClr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SCRGBCLR$4) != 0);
    } 
  }
  
  public void setScrgbClr(CTScRgbColor paramCTScRgbColor) {
    synchronized (monitor()) {
      check_orphaned();
      CTScRgbColor cTScRgbColor = null;
      cTScRgbColor = (CTScRgbColor)get_store().find_element_user(SCRGBCLR$4, 0);
      if (cTScRgbColor == null)
        cTScRgbColor = (CTScRgbColor)get_store().add_element_user(SCRGBCLR$4); 
      cTScRgbColor.set((XmlObject)paramCTScRgbColor);
    } 
  }
  
  public CTScRgbColor addNewScrgbClr() {
    synchronized (monitor()) {
      check_orphaned();
      CTScRgbColor cTScRgbColor = null;
      cTScRgbColor = (CTScRgbColor)get_store().add_element_user(SCRGBCLR$4);
      return cTScRgbColor;
    } 
  }
  
  public void unsetScrgbClr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SCRGBCLR$4, 0);
    } 
  }
  
  public CTSRgbColor getSrgbClr() {
    synchronized (monitor()) {
      check_orphaned();
      CTSRgbColor cTSRgbColor = null;
      cTSRgbColor = (CTSRgbColor)get_store().find_element_user(SRGBCLR$6, 0);
      if (cTSRgbColor == null)
        return null; 
      return cTSRgbColor;
    } 
  }
  
  public boolean isSetSrgbClr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SRGBCLR$6) != 0);
    } 
  }
  
  public void setSrgbClr(CTSRgbColor paramCTSRgbColor) {
    synchronized (monitor()) {
      check_orphaned();
      CTSRgbColor cTSRgbColor = null;
      cTSRgbColor = (CTSRgbColor)get_store().find_element_user(SRGBCLR$6, 0);
      if (cTSRgbColor == null)
        cTSRgbColor = (CTSRgbColor)get_store().add_element_user(SRGBCLR$6); 
      cTSRgbColor.set((XmlObject)paramCTSRgbColor);
    } 
  }
  
  public CTSRgbColor addNewSrgbClr() {
    synchronized (monitor()) {
      check_orphaned();
      CTSRgbColor cTSRgbColor = null;
      cTSRgbColor = (CTSRgbColor)get_store().add_element_user(SRGBCLR$6);
      return cTSRgbColor;
    } 
  }
  
  public void unsetSrgbClr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SRGBCLR$6, 0);
    } 
  }
  
  public CTHslColor getHslClr() {
    synchronized (monitor()) {
      check_orphaned();
      CTHslColor cTHslColor = null;
      cTHslColor = (CTHslColor)get_store().find_element_user(HSLCLR$8, 0);
      if (cTHslColor == null)
        return null; 
      return cTHslColor;
    } 
  }
  
  public boolean isSetHslClr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(HSLCLR$8) != 0);
    } 
  }
  
  public void setHslClr(CTHslColor paramCTHslColor) {
    synchronized (monitor()) {
      check_orphaned();
      CTHslColor cTHslColor = null;
      cTHslColor = (CTHslColor)get_store().find_element_user(HSLCLR$8, 0);
      if (cTHslColor == null)
        cTHslColor = (CTHslColor)get_store().add_element_user(HSLCLR$8); 
      cTHslColor.set((XmlObject)paramCTHslColor);
    } 
  }
  
  public CTHslColor addNewHslClr() {
    synchronized (monitor()) {
      check_orphaned();
      CTHslColor cTHslColor = null;
      cTHslColor = (CTHslColor)get_store().add_element_user(HSLCLR$8);
      return cTHslColor;
    } 
  }
  
  public void unsetHslClr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(HSLCLR$8, 0);
    } 
  }
  
  public CTSystemColor getSysClr() {
    synchronized (monitor()) {
      check_orphaned();
      CTSystemColor cTSystemColor = null;
      cTSystemColor = (CTSystemColor)get_store().find_element_user(SYSCLR$10, 0);
      if (cTSystemColor == null)
        return null; 
      return cTSystemColor;
    } 
  }
  
  public boolean isSetSysClr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SYSCLR$10) != 0);
    } 
  }
  
  public void setSysClr(CTSystemColor paramCTSystemColor) {
    synchronized (monitor()) {
      check_orphaned();
      CTSystemColor cTSystemColor = null;
      cTSystemColor = (CTSystemColor)get_store().find_element_user(SYSCLR$10, 0);
      if (cTSystemColor == null)
        cTSystemColor = (CTSystemColor)get_store().add_element_user(SYSCLR$10); 
      cTSystemColor.set((XmlObject)paramCTSystemColor);
    } 
  }
  
  public CTSystemColor addNewSysClr() {
    synchronized (monitor()) {
      check_orphaned();
      CTSystemColor cTSystemColor = null;
      cTSystemColor = (CTSystemColor)get_store().add_element_user(SYSCLR$10);
      return cTSystemColor;
    } 
  }
  
  public void unsetSysClr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SYSCLR$10, 0);
    } 
  }
  
  public CTSchemeColor getSchemeClr() {
    synchronized (monitor()) {
      check_orphaned();
      CTSchemeColor cTSchemeColor = null;
      cTSchemeColor = (CTSchemeColor)get_store().find_element_user(SCHEMECLR$12, 0);
      if (cTSchemeColor == null)
        return null; 
      return cTSchemeColor;
    } 
  }
  
  public boolean isSetSchemeClr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SCHEMECLR$12) != 0);
    } 
  }
  
  public void setSchemeClr(CTSchemeColor paramCTSchemeColor) {
    synchronized (monitor()) {
      check_orphaned();
      CTSchemeColor cTSchemeColor = null;
      cTSchemeColor = (CTSchemeColor)get_store().find_element_user(SCHEMECLR$12, 0);
      if (cTSchemeColor == null)
        cTSchemeColor = (CTSchemeColor)get_store().add_element_user(SCHEMECLR$12); 
      cTSchemeColor.set((XmlObject)paramCTSchemeColor);
    } 
  }
  
  public CTSchemeColor addNewSchemeClr() {
    synchronized (monitor()) {
      check_orphaned();
      CTSchemeColor cTSchemeColor = null;
      cTSchemeColor = (CTSchemeColor)get_store().add_element_user(SCHEMECLR$12);
      return cTSchemeColor;
    } 
  }
  
  public void unsetSchemeClr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SCHEMECLR$12, 0);
    } 
  }
  
  public CTPresetColor getPrstClr() {
    synchronized (monitor()) {
      check_orphaned();
      CTPresetColor cTPresetColor = null;
      cTPresetColor = (CTPresetColor)get_store().find_element_user(PRSTCLR$14, 0);
      if (cTPresetColor == null)
        return null; 
      return cTPresetColor;
    } 
  }
  
  public boolean isSetPrstClr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PRSTCLR$14) != 0);
    } 
  }
  
  public void setPrstClr(CTPresetColor paramCTPresetColor) {
    synchronized (monitor()) {
      check_orphaned();
      CTPresetColor cTPresetColor = null;
      cTPresetColor = (CTPresetColor)get_store().find_element_user(PRSTCLR$14, 0);
      if (cTPresetColor == null)
        cTPresetColor = (CTPresetColor)get_store().add_element_user(PRSTCLR$14); 
      cTPresetColor.set((XmlObject)paramCTPresetColor);
    } 
  }
  
  public CTPresetColor addNewPrstClr() {
    synchronized (monitor()) {
      check_orphaned();
      CTPresetColor cTPresetColor = null;
      cTPresetColor = (CTPresetColor)get_store().add_element_user(PRSTCLR$14);
      return cTPresetColor;
    } 
  }
  
  public void unsetPrstClr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PRSTCLR$14, 0);
    } 
  }
  
  public CTOfficeArtExtensionList getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().find_element_user(EXTLST$16, 0);
      if (cTOfficeArtExtensionList == null)
        return null; 
      return cTOfficeArtExtensionList;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$16) != 0);
    } 
  }
  
  public void setExtLst(CTOfficeArtExtensionList paramCTOfficeArtExtensionList) {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().find_element_user(EXTLST$16, 0);
      if (cTOfficeArtExtensionList == null)
        cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().add_element_user(EXTLST$16); 
      cTOfficeArtExtensionList.set((XmlObject)paramCTOfficeArtExtensionList);
    } 
  }
  
  public CTOfficeArtExtensionList addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().add_element_user(EXTLST$16);
      return cTOfficeArtExtensionList;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$16, 0);
    } 
  }
  
  public STOnOffStyleType.Enum getB() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(B$18);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(B$18); 
      if (simpleValue == null)
        return null; 
      return (STOnOffStyleType.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STOnOffStyleType xgetB() {
    synchronized (monitor()) {
      check_orphaned();
      STOnOffStyleType sTOnOffStyleType = null;
      sTOnOffStyleType = (STOnOffStyleType)get_store().find_attribute_user(B$18);
      if (sTOnOffStyleType == null)
        sTOnOffStyleType = (STOnOffStyleType)get_default_attribute_value(B$18); 
      return sTOnOffStyleType;
    } 
  }
  
  public boolean isSetB() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(B$18) != null);
    } 
  }
  
  public void setB(STOnOffStyleType.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(B$18);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(B$18); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetB(STOnOffStyleType paramSTOnOffStyleType) {
    synchronized (monitor()) {
      check_orphaned();
      STOnOffStyleType sTOnOffStyleType = null;
      sTOnOffStyleType = (STOnOffStyleType)get_store().find_attribute_user(B$18);
      if (sTOnOffStyleType == null)
        sTOnOffStyleType = (STOnOffStyleType)get_store().add_attribute_user(B$18); 
      sTOnOffStyleType.set((XmlObject)paramSTOnOffStyleType);
    } 
  }
  
  public void unsetB() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(B$18);
    } 
  }
  
  public STOnOffStyleType.Enum getI() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(I$20);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(I$20); 
      if (simpleValue == null)
        return null; 
      return (STOnOffStyleType.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STOnOffStyleType xgetI() {
    synchronized (monitor()) {
      check_orphaned();
      STOnOffStyleType sTOnOffStyleType = null;
      sTOnOffStyleType = (STOnOffStyleType)get_store().find_attribute_user(I$20);
      if (sTOnOffStyleType == null)
        sTOnOffStyleType = (STOnOffStyleType)get_default_attribute_value(I$20); 
      return sTOnOffStyleType;
    } 
  }
  
  public boolean isSetI() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(I$20) != null);
    } 
  }
  
  public void setI(STOnOffStyleType.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(I$20);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(I$20); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetI(STOnOffStyleType paramSTOnOffStyleType) {
    synchronized (monitor()) {
      check_orphaned();
      STOnOffStyleType sTOnOffStyleType = null;
      sTOnOffStyleType = (STOnOffStyleType)get_store().find_attribute_user(I$20);
      if (sTOnOffStyleType == null)
        sTOnOffStyleType = (STOnOffStyleType)get_store().add_attribute_user(I$20); 
      sTOnOffStyleType.set((XmlObject)paramSTOnOffStyleType);
    } 
  }
  
  public void unsetI() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(I$20);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTTableStyleTextStyleImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */