package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.main.STColorSchemeIndex;

public class CTColorMappingImpl extends XmlComplexContentImpl implements CTColorMapping {
  private static final b EXTLST$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "extLst");
  
  private static final b BG1$2 = new b("", "bg1");
  
  private static final b TX1$4 = new b("", "tx1");
  
  private static final b BG2$6 = new b("", "bg2");
  
  private static final b TX2$8 = new b("", "tx2");
  
  private static final b ACCENT1$10 = new b("", "accent1");
  
  private static final b ACCENT2$12 = new b("", "accent2");
  
  private static final b ACCENT3$14 = new b("", "accent3");
  
  private static final b ACCENT4$16 = new b("", "accent4");
  
  private static final b ACCENT5$18 = new b("", "accent5");
  
  private static final b ACCENT6$20 = new b("", "accent6");
  
  private static final b HLINK$22 = new b("", "hlink");
  
  private static final b FOLHLINK$24 = new b("", "folHlink");
  
  public CTColorMappingImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTOfficeArtExtensionList getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().find_element_user(EXTLST$0, 0);
      if (cTOfficeArtExtensionList == null)
        return null; 
      return cTOfficeArtExtensionList;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$0) != 0);
    } 
  }
  
  public void setExtLst(CTOfficeArtExtensionList paramCTOfficeArtExtensionList) {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().find_element_user(EXTLST$0, 0);
      if (cTOfficeArtExtensionList == null)
        cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().add_element_user(EXTLST$0); 
      cTOfficeArtExtensionList.set((XmlObject)paramCTOfficeArtExtensionList);
    } 
  }
  
  public CTOfficeArtExtensionList addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().add_element_user(EXTLST$0);
      return cTOfficeArtExtensionList;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$0, 0);
    } 
  }
  
  public STColorSchemeIndex.Enum getBg1() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BG1$2);
      if (simpleValue == null)
        return null; 
      return (STColorSchemeIndex.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STColorSchemeIndex xgetBg1() {
    synchronized (monitor()) {
      check_orphaned();
      STColorSchemeIndex sTColorSchemeIndex = null;
      sTColorSchemeIndex = (STColorSchemeIndex)get_store().find_attribute_user(BG1$2);
      return sTColorSchemeIndex;
    } 
  }
  
  public void setBg1(STColorSchemeIndex.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BG1$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(BG1$2); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetBg1(STColorSchemeIndex paramSTColorSchemeIndex) {
    synchronized (monitor()) {
      check_orphaned();
      STColorSchemeIndex sTColorSchemeIndex = null;
      sTColorSchemeIndex = (STColorSchemeIndex)get_store().find_attribute_user(BG1$2);
      if (sTColorSchemeIndex == null)
        sTColorSchemeIndex = (STColorSchemeIndex)get_store().add_attribute_user(BG1$2); 
      sTColorSchemeIndex.set((XmlObject)paramSTColorSchemeIndex);
    } 
  }
  
  public STColorSchemeIndex.Enum getTx1() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TX1$4);
      if (simpleValue == null)
        return null; 
      return (STColorSchemeIndex.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STColorSchemeIndex xgetTx1() {
    synchronized (monitor()) {
      check_orphaned();
      STColorSchemeIndex sTColorSchemeIndex = null;
      sTColorSchemeIndex = (STColorSchemeIndex)get_store().find_attribute_user(TX1$4);
      return sTColorSchemeIndex;
    } 
  }
  
  public void setTx1(STColorSchemeIndex.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TX1$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TX1$4); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetTx1(STColorSchemeIndex paramSTColorSchemeIndex) {
    synchronized (monitor()) {
      check_orphaned();
      STColorSchemeIndex sTColorSchemeIndex = null;
      sTColorSchemeIndex = (STColorSchemeIndex)get_store().find_attribute_user(TX1$4);
      if (sTColorSchemeIndex == null)
        sTColorSchemeIndex = (STColorSchemeIndex)get_store().add_attribute_user(TX1$4); 
      sTColorSchemeIndex.set((XmlObject)paramSTColorSchemeIndex);
    } 
  }
  
  public STColorSchemeIndex.Enum getBg2() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BG2$6);
      if (simpleValue == null)
        return null; 
      return (STColorSchemeIndex.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STColorSchemeIndex xgetBg2() {
    synchronized (monitor()) {
      check_orphaned();
      STColorSchemeIndex sTColorSchemeIndex = null;
      sTColorSchemeIndex = (STColorSchemeIndex)get_store().find_attribute_user(BG2$6);
      return sTColorSchemeIndex;
    } 
  }
  
  public void setBg2(STColorSchemeIndex.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BG2$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(BG2$6); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetBg2(STColorSchemeIndex paramSTColorSchemeIndex) {
    synchronized (monitor()) {
      check_orphaned();
      STColorSchemeIndex sTColorSchemeIndex = null;
      sTColorSchemeIndex = (STColorSchemeIndex)get_store().find_attribute_user(BG2$6);
      if (sTColorSchemeIndex == null)
        sTColorSchemeIndex = (STColorSchemeIndex)get_store().add_attribute_user(BG2$6); 
      sTColorSchemeIndex.set((XmlObject)paramSTColorSchemeIndex);
    } 
  }
  
  public STColorSchemeIndex.Enum getTx2() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TX2$8);
      if (simpleValue == null)
        return null; 
      return (STColorSchemeIndex.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STColorSchemeIndex xgetTx2() {
    synchronized (monitor()) {
      check_orphaned();
      STColorSchemeIndex sTColorSchemeIndex = null;
      sTColorSchemeIndex = (STColorSchemeIndex)get_store().find_attribute_user(TX2$8);
      return sTColorSchemeIndex;
    } 
  }
  
  public void setTx2(STColorSchemeIndex.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TX2$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TX2$8); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetTx2(STColorSchemeIndex paramSTColorSchemeIndex) {
    synchronized (monitor()) {
      check_orphaned();
      STColorSchemeIndex sTColorSchemeIndex = null;
      sTColorSchemeIndex = (STColorSchemeIndex)get_store().find_attribute_user(TX2$8);
      if (sTColorSchemeIndex == null)
        sTColorSchemeIndex = (STColorSchemeIndex)get_store().add_attribute_user(TX2$8); 
      sTColorSchemeIndex.set((XmlObject)paramSTColorSchemeIndex);
    } 
  }
  
  public STColorSchemeIndex.Enum getAccent1() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ACCENT1$10);
      if (simpleValue == null)
        return null; 
      return (STColorSchemeIndex.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STColorSchemeIndex xgetAccent1() {
    synchronized (monitor()) {
      check_orphaned();
      STColorSchemeIndex sTColorSchemeIndex = null;
      sTColorSchemeIndex = (STColorSchemeIndex)get_store().find_attribute_user(ACCENT1$10);
      return sTColorSchemeIndex;
    } 
  }
  
  public void setAccent1(STColorSchemeIndex.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ACCENT1$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ACCENT1$10); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetAccent1(STColorSchemeIndex paramSTColorSchemeIndex) {
    synchronized (monitor()) {
      check_orphaned();
      STColorSchemeIndex sTColorSchemeIndex = null;
      sTColorSchemeIndex = (STColorSchemeIndex)get_store().find_attribute_user(ACCENT1$10);
      if (sTColorSchemeIndex == null)
        sTColorSchemeIndex = (STColorSchemeIndex)get_store().add_attribute_user(ACCENT1$10); 
      sTColorSchemeIndex.set((XmlObject)paramSTColorSchemeIndex);
    } 
  }
  
  public STColorSchemeIndex.Enum getAccent2() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ACCENT2$12);
      if (simpleValue == null)
        return null; 
      return (STColorSchemeIndex.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STColorSchemeIndex xgetAccent2() {
    synchronized (monitor()) {
      check_orphaned();
      STColorSchemeIndex sTColorSchemeIndex = null;
      sTColorSchemeIndex = (STColorSchemeIndex)get_store().find_attribute_user(ACCENT2$12);
      return sTColorSchemeIndex;
    } 
  }
  
  public void setAccent2(STColorSchemeIndex.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ACCENT2$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ACCENT2$12); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetAccent2(STColorSchemeIndex paramSTColorSchemeIndex) {
    synchronized (monitor()) {
      check_orphaned();
      STColorSchemeIndex sTColorSchemeIndex = null;
      sTColorSchemeIndex = (STColorSchemeIndex)get_store().find_attribute_user(ACCENT2$12);
      if (sTColorSchemeIndex == null)
        sTColorSchemeIndex = (STColorSchemeIndex)get_store().add_attribute_user(ACCENT2$12); 
      sTColorSchemeIndex.set((XmlObject)paramSTColorSchemeIndex);
    } 
  }
  
  public STColorSchemeIndex.Enum getAccent3() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ACCENT3$14);
      if (simpleValue == null)
        return null; 
      return (STColorSchemeIndex.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STColorSchemeIndex xgetAccent3() {
    synchronized (monitor()) {
      check_orphaned();
      STColorSchemeIndex sTColorSchemeIndex = null;
      sTColorSchemeIndex = (STColorSchemeIndex)get_store().find_attribute_user(ACCENT3$14);
      return sTColorSchemeIndex;
    } 
  }
  
  public void setAccent3(STColorSchemeIndex.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ACCENT3$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ACCENT3$14); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetAccent3(STColorSchemeIndex paramSTColorSchemeIndex) {
    synchronized (monitor()) {
      check_orphaned();
      STColorSchemeIndex sTColorSchemeIndex = null;
      sTColorSchemeIndex = (STColorSchemeIndex)get_store().find_attribute_user(ACCENT3$14);
      if (sTColorSchemeIndex == null)
        sTColorSchemeIndex = (STColorSchemeIndex)get_store().add_attribute_user(ACCENT3$14); 
      sTColorSchemeIndex.set((XmlObject)paramSTColorSchemeIndex);
    } 
  }
  
  public STColorSchemeIndex.Enum getAccent4() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ACCENT4$16);
      if (simpleValue == null)
        return null; 
      return (STColorSchemeIndex.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STColorSchemeIndex xgetAccent4() {
    synchronized (monitor()) {
      check_orphaned();
      STColorSchemeIndex sTColorSchemeIndex = null;
      sTColorSchemeIndex = (STColorSchemeIndex)get_store().find_attribute_user(ACCENT4$16);
      return sTColorSchemeIndex;
    } 
  }
  
  public void setAccent4(STColorSchemeIndex.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ACCENT4$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ACCENT4$16); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetAccent4(STColorSchemeIndex paramSTColorSchemeIndex) {
    synchronized (monitor()) {
      check_orphaned();
      STColorSchemeIndex sTColorSchemeIndex = null;
      sTColorSchemeIndex = (STColorSchemeIndex)get_store().find_attribute_user(ACCENT4$16);
      if (sTColorSchemeIndex == null)
        sTColorSchemeIndex = (STColorSchemeIndex)get_store().add_attribute_user(ACCENT4$16); 
      sTColorSchemeIndex.set((XmlObject)paramSTColorSchemeIndex);
    } 
  }
  
  public STColorSchemeIndex.Enum getAccent5() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ACCENT5$18);
      if (simpleValue == null)
        return null; 
      return (STColorSchemeIndex.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STColorSchemeIndex xgetAccent5() {
    synchronized (monitor()) {
      check_orphaned();
      STColorSchemeIndex sTColorSchemeIndex = null;
      sTColorSchemeIndex = (STColorSchemeIndex)get_store().find_attribute_user(ACCENT5$18);
      return sTColorSchemeIndex;
    } 
  }
  
  public void setAccent5(STColorSchemeIndex.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ACCENT5$18);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ACCENT5$18); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetAccent5(STColorSchemeIndex paramSTColorSchemeIndex) {
    synchronized (monitor()) {
      check_orphaned();
      STColorSchemeIndex sTColorSchemeIndex = null;
      sTColorSchemeIndex = (STColorSchemeIndex)get_store().find_attribute_user(ACCENT5$18);
      if (sTColorSchemeIndex == null)
        sTColorSchemeIndex = (STColorSchemeIndex)get_store().add_attribute_user(ACCENT5$18); 
      sTColorSchemeIndex.set((XmlObject)paramSTColorSchemeIndex);
    } 
  }
  
  public STColorSchemeIndex.Enum getAccent6() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ACCENT6$20);
      if (simpleValue == null)
        return null; 
      return (STColorSchemeIndex.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STColorSchemeIndex xgetAccent6() {
    synchronized (monitor()) {
      check_orphaned();
      STColorSchemeIndex sTColorSchemeIndex = null;
      sTColorSchemeIndex = (STColorSchemeIndex)get_store().find_attribute_user(ACCENT6$20);
      return sTColorSchemeIndex;
    } 
  }
  
  public void setAccent6(STColorSchemeIndex.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ACCENT6$20);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ACCENT6$20); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetAccent6(STColorSchemeIndex paramSTColorSchemeIndex) {
    synchronized (monitor()) {
      check_orphaned();
      STColorSchemeIndex sTColorSchemeIndex = null;
      sTColorSchemeIndex = (STColorSchemeIndex)get_store().find_attribute_user(ACCENT6$20);
      if (sTColorSchemeIndex == null)
        sTColorSchemeIndex = (STColorSchemeIndex)get_store().add_attribute_user(ACCENT6$20); 
      sTColorSchemeIndex.set((XmlObject)paramSTColorSchemeIndex);
    } 
  }
  
  public STColorSchemeIndex.Enum getHlink() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HLINK$22);
      if (simpleValue == null)
        return null; 
      return (STColorSchemeIndex.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STColorSchemeIndex xgetHlink() {
    synchronized (monitor()) {
      check_orphaned();
      STColorSchemeIndex sTColorSchemeIndex = null;
      sTColorSchemeIndex = (STColorSchemeIndex)get_store().find_attribute_user(HLINK$22);
      return sTColorSchemeIndex;
    } 
  }
  
  public void setHlink(STColorSchemeIndex.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HLINK$22);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(HLINK$22); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetHlink(STColorSchemeIndex paramSTColorSchemeIndex) {
    synchronized (monitor()) {
      check_orphaned();
      STColorSchemeIndex sTColorSchemeIndex = null;
      sTColorSchemeIndex = (STColorSchemeIndex)get_store().find_attribute_user(HLINK$22);
      if (sTColorSchemeIndex == null)
        sTColorSchemeIndex = (STColorSchemeIndex)get_store().add_attribute_user(HLINK$22); 
      sTColorSchemeIndex.set((XmlObject)paramSTColorSchemeIndex);
    } 
  }
  
  public STColorSchemeIndex.Enum getFolHlink() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FOLHLINK$24);
      if (simpleValue == null)
        return null; 
      return (STColorSchemeIndex.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STColorSchemeIndex xgetFolHlink() {
    synchronized (monitor()) {
      check_orphaned();
      STColorSchemeIndex sTColorSchemeIndex = null;
      sTColorSchemeIndex = (STColorSchemeIndex)get_store().find_attribute_user(FOLHLINK$24);
      return sTColorSchemeIndex;
    } 
  }
  
  public void setFolHlink(STColorSchemeIndex.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FOLHLINK$24);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FOLHLINK$24); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetFolHlink(STColorSchemeIndex paramSTColorSchemeIndex) {
    synchronized (monitor()) {
      check_orphaned();
      STColorSchemeIndex sTColorSchemeIndex = null;
      sTColorSchemeIndex = (STColorSchemeIndex)get_store().find_attribute_user(FOLHLINK$24);
      if (sTColorSchemeIndex == null)
        sTColorSchemeIndex = (STColorSchemeIndex)get_store().add_attribute_user(FOLHLINK$24); 
      sTColorSchemeIndex.set((XmlObject)paramSTColorSchemeIndex);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTColorMappingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */