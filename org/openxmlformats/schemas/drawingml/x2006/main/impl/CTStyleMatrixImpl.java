package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTEffectStyleList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTFillStyleList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTLineStyleList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrix;

public class CTStyleMatrixImpl extends XmlComplexContentImpl implements CTStyleMatrix {
  private static final b FILLSTYLELST$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "fillStyleLst");
  
  private static final b LNSTYLELST$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "lnStyleLst");
  
  private static final b EFFECTSTYLELST$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "effectStyleLst");
  
  private static final b BGFILLSTYLELST$6 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "bgFillStyleLst");
  
  private static final b NAME$8 = new b("", "name");
  
  public CTStyleMatrixImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTFillStyleList getFillStyleLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTFillStyleList cTFillStyleList = null;
      cTFillStyleList = (CTFillStyleList)get_store().find_element_user(FILLSTYLELST$0, 0);
      if (cTFillStyleList == null)
        return null; 
      return cTFillStyleList;
    } 
  }
  
  public void setFillStyleLst(CTFillStyleList paramCTFillStyleList) {
    synchronized (monitor()) {
      check_orphaned();
      CTFillStyleList cTFillStyleList = null;
      cTFillStyleList = (CTFillStyleList)get_store().find_element_user(FILLSTYLELST$0, 0);
      if (cTFillStyleList == null)
        cTFillStyleList = (CTFillStyleList)get_store().add_element_user(FILLSTYLELST$0); 
      cTFillStyleList.set((XmlObject)paramCTFillStyleList);
    } 
  }
  
  public CTFillStyleList addNewFillStyleLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTFillStyleList cTFillStyleList = null;
      cTFillStyleList = (CTFillStyleList)get_store().add_element_user(FILLSTYLELST$0);
      return cTFillStyleList;
    } 
  }
  
  public CTLineStyleList getLnStyleLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTLineStyleList cTLineStyleList = null;
      cTLineStyleList = (CTLineStyleList)get_store().find_element_user(LNSTYLELST$2, 0);
      if (cTLineStyleList == null)
        return null; 
      return cTLineStyleList;
    } 
  }
  
  public void setLnStyleLst(CTLineStyleList paramCTLineStyleList) {
    synchronized (monitor()) {
      check_orphaned();
      CTLineStyleList cTLineStyleList = null;
      cTLineStyleList = (CTLineStyleList)get_store().find_element_user(LNSTYLELST$2, 0);
      if (cTLineStyleList == null)
        cTLineStyleList = (CTLineStyleList)get_store().add_element_user(LNSTYLELST$2); 
      cTLineStyleList.set((XmlObject)paramCTLineStyleList);
    } 
  }
  
  public CTLineStyleList addNewLnStyleLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTLineStyleList cTLineStyleList = null;
      cTLineStyleList = (CTLineStyleList)get_store().add_element_user(LNSTYLELST$2);
      return cTLineStyleList;
    } 
  }
  
  public CTEffectStyleList getEffectStyleLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTEffectStyleList cTEffectStyleList = null;
      cTEffectStyleList = (CTEffectStyleList)get_store().find_element_user(EFFECTSTYLELST$4, 0);
      if (cTEffectStyleList == null)
        return null; 
      return cTEffectStyleList;
    } 
  }
  
  public void setEffectStyleLst(CTEffectStyleList paramCTEffectStyleList) {
    synchronized (monitor()) {
      check_orphaned();
      CTEffectStyleList cTEffectStyleList = null;
      cTEffectStyleList = (CTEffectStyleList)get_store().find_element_user(EFFECTSTYLELST$4, 0);
      if (cTEffectStyleList == null)
        cTEffectStyleList = (CTEffectStyleList)get_store().add_element_user(EFFECTSTYLELST$4); 
      cTEffectStyleList.set((XmlObject)paramCTEffectStyleList);
    } 
  }
  
  public CTEffectStyleList addNewEffectStyleLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTEffectStyleList cTEffectStyleList = null;
      cTEffectStyleList = (CTEffectStyleList)get_store().add_element_user(EFFECTSTYLELST$4);
      return cTEffectStyleList;
    } 
  }
  
  public CTBackgroundFillStyleList getBgFillStyleLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTBackgroundFillStyleList cTBackgroundFillStyleList = null;
      cTBackgroundFillStyleList = (CTBackgroundFillStyleList)get_store().find_element_user(BGFILLSTYLELST$6, 0);
      if (cTBackgroundFillStyleList == null)
        return null; 
      return cTBackgroundFillStyleList;
    } 
  }
  
  public void setBgFillStyleLst(CTBackgroundFillStyleList paramCTBackgroundFillStyleList) {
    synchronized (monitor()) {
      check_orphaned();
      CTBackgroundFillStyleList cTBackgroundFillStyleList = null;
      cTBackgroundFillStyleList = (CTBackgroundFillStyleList)get_store().find_element_user(BGFILLSTYLELST$6, 0);
      if (cTBackgroundFillStyleList == null)
        cTBackgroundFillStyleList = (CTBackgroundFillStyleList)get_store().add_element_user(BGFILLSTYLELST$6); 
      cTBackgroundFillStyleList.set((XmlObject)paramCTBackgroundFillStyleList);
    } 
  }
  
  public CTBackgroundFillStyleList addNewBgFillStyleLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTBackgroundFillStyleList cTBackgroundFillStyleList = null;
      cTBackgroundFillStyleList = (CTBackgroundFillStyleList)get_store().add_element_user(BGFILLSTYLELST$6);
      return cTBackgroundFillStyleList;
    } 
  }
  
  public String getName() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(NAME$8); 
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetName() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(NAME$8);
      if (xmlString == null)
        xmlString = (XmlString)get_default_attribute_value(NAME$8); 
      return xmlString;
    } 
  }
  
  public boolean isSetName() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(NAME$8) != null);
    } 
  }
  
  public void setName(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(NAME$8); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetName(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(NAME$8);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(NAME$8); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetName() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(NAME$8);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTStyleMatrixImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */