package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorScheme;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;

public class CTColorSchemeImpl extends XmlComplexContentImpl implements CTColorScheme {
  private static final b DK1$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "dk1");
  
  private static final b LT1$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "lt1");
  
  private static final b DK2$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "dk2");
  
  private static final b LT2$6 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "lt2");
  
  private static final b ACCENT1$8 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "accent1");
  
  private static final b ACCENT2$10 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "accent2");
  
  private static final b ACCENT3$12 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "accent3");
  
  private static final b ACCENT4$14 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "accent4");
  
  private static final b ACCENT5$16 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "accent5");
  
  private static final b ACCENT6$18 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "accent6");
  
  private static final b HLINK$20 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "hlink");
  
  private static final b FOLHLINK$22 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "folHlink");
  
  private static final b EXTLST$24 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "extLst");
  
  private static final b NAME$26 = new b("", "name");
  
  public CTColorSchemeImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTColor getDk1() {
    synchronized (monitor()) {
      check_orphaned();
      CTColor cTColor = null;
      cTColor = (CTColor)get_store().find_element_user(DK1$0, 0);
      if (cTColor == null)
        return null; 
      return cTColor;
    } 
  }
  
  public void setDk1(CTColor paramCTColor) {
    synchronized (monitor()) {
      check_orphaned();
      CTColor cTColor = null;
      cTColor = (CTColor)get_store().find_element_user(DK1$0, 0);
      if (cTColor == null)
        cTColor = (CTColor)get_store().add_element_user(DK1$0); 
      cTColor.set((XmlObject)paramCTColor);
    } 
  }
  
  public CTColor addNewDk1() {
    synchronized (monitor()) {
      check_orphaned();
      CTColor cTColor = null;
      cTColor = (CTColor)get_store().add_element_user(DK1$0);
      return cTColor;
    } 
  }
  
  public CTColor getLt1() {
    synchronized (monitor()) {
      check_orphaned();
      CTColor cTColor = null;
      cTColor = (CTColor)get_store().find_element_user(LT1$2, 0);
      if (cTColor == null)
        return null; 
      return cTColor;
    } 
  }
  
  public void setLt1(CTColor paramCTColor) {
    synchronized (monitor()) {
      check_orphaned();
      CTColor cTColor = null;
      cTColor = (CTColor)get_store().find_element_user(LT1$2, 0);
      if (cTColor == null)
        cTColor = (CTColor)get_store().add_element_user(LT1$2); 
      cTColor.set((XmlObject)paramCTColor);
    } 
  }
  
  public CTColor addNewLt1() {
    synchronized (monitor()) {
      check_orphaned();
      CTColor cTColor = null;
      cTColor = (CTColor)get_store().add_element_user(LT1$2);
      return cTColor;
    } 
  }
  
  public CTColor getDk2() {
    synchronized (monitor()) {
      check_orphaned();
      CTColor cTColor = null;
      cTColor = (CTColor)get_store().find_element_user(DK2$4, 0);
      if (cTColor == null)
        return null; 
      return cTColor;
    } 
  }
  
  public void setDk2(CTColor paramCTColor) {
    synchronized (monitor()) {
      check_orphaned();
      CTColor cTColor = null;
      cTColor = (CTColor)get_store().find_element_user(DK2$4, 0);
      if (cTColor == null)
        cTColor = (CTColor)get_store().add_element_user(DK2$4); 
      cTColor.set((XmlObject)paramCTColor);
    } 
  }
  
  public CTColor addNewDk2() {
    synchronized (monitor()) {
      check_orphaned();
      CTColor cTColor = null;
      cTColor = (CTColor)get_store().add_element_user(DK2$4);
      return cTColor;
    } 
  }
  
  public CTColor getLt2() {
    synchronized (monitor()) {
      check_orphaned();
      CTColor cTColor = null;
      cTColor = (CTColor)get_store().find_element_user(LT2$6, 0);
      if (cTColor == null)
        return null; 
      return cTColor;
    } 
  }
  
  public void setLt2(CTColor paramCTColor) {
    synchronized (monitor()) {
      check_orphaned();
      CTColor cTColor = null;
      cTColor = (CTColor)get_store().find_element_user(LT2$6, 0);
      if (cTColor == null)
        cTColor = (CTColor)get_store().add_element_user(LT2$6); 
      cTColor.set((XmlObject)paramCTColor);
    } 
  }
  
  public CTColor addNewLt2() {
    synchronized (monitor()) {
      check_orphaned();
      CTColor cTColor = null;
      cTColor = (CTColor)get_store().add_element_user(LT2$6);
      return cTColor;
    } 
  }
  
  public CTColor getAccent1() {
    synchronized (monitor()) {
      check_orphaned();
      CTColor cTColor = null;
      cTColor = (CTColor)get_store().find_element_user(ACCENT1$8, 0);
      if (cTColor == null)
        return null; 
      return cTColor;
    } 
  }
  
  public void setAccent1(CTColor paramCTColor) {
    synchronized (monitor()) {
      check_orphaned();
      CTColor cTColor = null;
      cTColor = (CTColor)get_store().find_element_user(ACCENT1$8, 0);
      if (cTColor == null)
        cTColor = (CTColor)get_store().add_element_user(ACCENT1$8); 
      cTColor.set((XmlObject)paramCTColor);
    } 
  }
  
  public CTColor addNewAccent1() {
    synchronized (monitor()) {
      check_orphaned();
      CTColor cTColor = null;
      cTColor = (CTColor)get_store().add_element_user(ACCENT1$8);
      return cTColor;
    } 
  }
  
  public CTColor getAccent2() {
    synchronized (monitor()) {
      check_orphaned();
      CTColor cTColor = null;
      cTColor = (CTColor)get_store().find_element_user(ACCENT2$10, 0);
      if (cTColor == null)
        return null; 
      return cTColor;
    } 
  }
  
  public void setAccent2(CTColor paramCTColor) {
    synchronized (monitor()) {
      check_orphaned();
      CTColor cTColor = null;
      cTColor = (CTColor)get_store().find_element_user(ACCENT2$10, 0);
      if (cTColor == null)
        cTColor = (CTColor)get_store().add_element_user(ACCENT2$10); 
      cTColor.set((XmlObject)paramCTColor);
    } 
  }
  
  public CTColor addNewAccent2() {
    synchronized (monitor()) {
      check_orphaned();
      CTColor cTColor = null;
      cTColor = (CTColor)get_store().add_element_user(ACCENT2$10);
      return cTColor;
    } 
  }
  
  public CTColor getAccent3() {
    synchronized (monitor()) {
      check_orphaned();
      CTColor cTColor = null;
      cTColor = (CTColor)get_store().find_element_user(ACCENT3$12, 0);
      if (cTColor == null)
        return null; 
      return cTColor;
    } 
  }
  
  public void setAccent3(CTColor paramCTColor) {
    synchronized (monitor()) {
      check_orphaned();
      CTColor cTColor = null;
      cTColor = (CTColor)get_store().find_element_user(ACCENT3$12, 0);
      if (cTColor == null)
        cTColor = (CTColor)get_store().add_element_user(ACCENT3$12); 
      cTColor.set((XmlObject)paramCTColor);
    } 
  }
  
  public CTColor addNewAccent3() {
    synchronized (monitor()) {
      check_orphaned();
      CTColor cTColor = null;
      cTColor = (CTColor)get_store().add_element_user(ACCENT3$12);
      return cTColor;
    } 
  }
  
  public CTColor getAccent4() {
    synchronized (monitor()) {
      check_orphaned();
      CTColor cTColor = null;
      cTColor = (CTColor)get_store().find_element_user(ACCENT4$14, 0);
      if (cTColor == null)
        return null; 
      return cTColor;
    } 
  }
  
  public void setAccent4(CTColor paramCTColor) {
    synchronized (monitor()) {
      check_orphaned();
      CTColor cTColor = null;
      cTColor = (CTColor)get_store().find_element_user(ACCENT4$14, 0);
      if (cTColor == null)
        cTColor = (CTColor)get_store().add_element_user(ACCENT4$14); 
      cTColor.set((XmlObject)paramCTColor);
    } 
  }
  
  public CTColor addNewAccent4() {
    synchronized (monitor()) {
      check_orphaned();
      CTColor cTColor = null;
      cTColor = (CTColor)get_store().add_element_user(ACCENT4$14);
      return cTColor;
    } 
  }
  
  public CTColor getAccent5() {
    synchronized (monitor()) {
      check_orphaned();
      CTColor cTColor = null;
      cTColor = (CTColor)get_store().find_element_user(ACCENT5$16, 0);
      if (cTColor == null)
        return null; 
      return cTColor;
    } 
  }
  
  public void setAccent5(CTColor paramCTColor) {
    synchronized (monitor()) {
      check_orphaned();
      CTColor cTColor = null;
      cTColor = (CTColor)get_store().find_element_user(ACCENT5$16, 0);
      if (cTColor == null)
        cTColor = (CTColor)get_store().add_element_user(ACCENT5$16); 
      cTColor.set((XmlObject)paramCTColor);
    } 
  }
  
  public CTColor addNewAccent5() {
    synchronized (monitor()) {
      check_orphaned();
      CTColor cTColor = null;
      cTColor = (CTColor)get_store().add_element_user(ACCENT5$16);
      return cTColor;
    } 
  }
  
  public CTColor getAccent6() {
    synchronized (monitor()) {
      check_orphaned();
      CTColor cTColor = null;
      cTColor = (CTColor)get_store().find_element_user(ACCENT6$18, 0);
      if (cTColor == null)
        return null; 
      return cTColor;
    } 
  }
  
  public void setAccent6(CTColor paramCTColor) {
    synchronized (monitor()) {
      check_orphaned();
      CTColor cTColor = null;
      cTColor = (CTColor)get_store().find_element_user(ACCENT6$18, 0);
      if (cTColor == null)
        cTColor = (CTColor)get_store().add_element_user(ACCENT6$18); 
      cTColor.set((XmlObject)paramCTColor);
    } 
  }
  
  public CTColor addNewAccent6() {
    synchronized (monitor()) {
      check_orphaned();
      CTColor cTColor = null;
      cTColor = (CTColor)get_store().add_element_user(ACCENT6$18);
      return cTColor;
    } 
  }
  
  public CTColor getHlink() {
    synchronized (monitor()) {
      check_orphaned();
      CTColor cTColor = null;
      cTColor = (CTColor)get_store().find_element_user(HLINK$20, 0);
      if (cTColor == null)
        return null; 
      return cTColor;
    } 
  }
  
  public void setHlink(CTColor paramCTColor) {
    synchronized (monitor()) {
      check_orphaned();
      CTColor cTColor = null;
      cTColor = (CTColor)get_store().find_element_user(HLINK$20, 0);
      if (cTColor == null)
        cTColor = (CTColor)get_store().add_element_user(HLINK$20); 
      cTColor.set((XmlObject)paramCTColor);
    } 
  }
  
  public CTColor addNewHlink() {
    synchronized (monitor()) {
      check_orphaned();
      CTColor cTColor = null;
      cTColor = (CTColor)get_store().add_element_user(HLINK$20);
      return cTColor;
    } 
  }
  
  public CTColor getFolHlink() {
    synchronized (monitor()) {
      check_orphaned();
      CTColor cTColor = null;
      cTColor = (CTColor)get_store().find_element_user(FOLHLINK$22, 0);
      if (cTColor == null)
        return null; 
      return cTColor;
    } 
  }
  
  public void setFolHlink(CTColor paramCTColor) {
    synchronized (monitor()) {
      check_orphaned();
      CTColor cTColor = null;
      cTColor = (CTColor)get_store().find_element_user(FOLHLINK$22, 0);
      if (cTColor == null)
        cTColor = (CTColor)get_store().add_element_user(FOLHLINK$22); 
      cTColor.set((XmlObject)paramCTColor);
    } 
  }
  
  public CTColor addNewFolHlink() {
    synchronized (monitor()) {
      check_orphaned();
      CTColor cTColor = null;
      cTColor = (CTColor)get_store().add_element_user(FOLHLINK$22);
      return cTColor;
    } 
  }
  
  public CTOfficeArtExtensionList getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().find_element_user(EXTLST$24, 0);
      if (cTOfficeArtExtensionList == null)
        return null; 
      return cTOfficeArtExtensionList;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$24) != 0);
    } 
  }
  
  public void setExtLst(CTOfficeArtExtensionList paramCTOfficeArtExtensionList) {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().find_element_user(EXTLST$24, 0);
      if (cTOfficeArtExtensionList == null)
        cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().add_element_user(EXTLST$24); 
      cTOfficeArtExtensionList.set((XmlObject)paramCTOfficeArtExtensionList);
    } 
  }
  
  public CTOfficeArtExtensionList addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().add_element_user(EXTLST$24);
      return cTOfficeArtExtensionList;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$24, 0);
    } 
  }
  
  public String getName() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$26);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetName() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(NAME$26);
      return xmlString;
    } 
  }
  
  public void setName(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$26);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(NAME$26); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetName(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(NAME$26);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(NAME$26); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTColorSchemeImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */