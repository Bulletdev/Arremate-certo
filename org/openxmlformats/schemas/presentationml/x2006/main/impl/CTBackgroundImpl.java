package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrixReference;
import org.openxmlformats.schemas.drawingml.x2006.main.STBlackWhiteMode;
import org.openxmlformats.schemas.presentationml.x2006.main.CTBackground;
import org.openxmlformats.schemas.presentationml.x2006.main.CTBackgroundProperties;

public class CTBackgroundImpl extends XmlComplexContentImpl implements CTBackground {
  private static final b BGPR$0 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "bgPr");
  
  private static final b BGREF$2 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "bgRef");
  
  private static final b BWMODE$4 = new b("", "bwMode");
  
  public CTBackgroundImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTBackgroundProperties getBgPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTBackgroundProperties cTBackgroundProperties = null;
      cTBackgroundProperties = (CTBackgroundProperties)get_store().find_element_user(BGPR$0, 0);
      if (cTBackgroundProperties == null)
        return null; 
      return cTBackgroundProperties;
    } 
  }
  
  public boolean isSetBgPr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(BGPR$0) != 0);
    } 
  }
  
  public void setBgPr(CTBackgroundProperties paramCTBackgroundProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTBackgroundProperties cTBackgroundProperties = null;
      cTBackgroundProperties = (CTBackgroundProperties)get_store().find_element_user(BGPR$0, 0);
      if (cTBackgroundProperties == null)
        cTBackgroundProperties = (CTBackgroundProperties)get_store().add_element_user(BGPR$0); 
      cTBackgroundProperties.set((XmlObject)paramCTBackgroundProperties);
    } 
  }
  
  public CTBackgroundProperties addNewBgPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTBackgroundProperties cTBackgroundProperties = null;
      cTBackgroundProperties = (CTBackgroundProperties)get_store().add_element_user(BGPR$0);
      return cTBackgroundProperties;
    } 
  }
  
  public void unsetBgPr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BGPR$0, 0);
    } 
  }
  
  public CTStyleMatrixReference getBgRef() {
    synchronized (monitor()) {
      check_orphaned();
      CTStyleMatrixReference cTStyleMatrixReference = null;
      cTStyleMatrixReference = (CTStyleMatrixReference)get_store().find_element_user(BGREF$2, 0);
      if (cTStyleMatrixReference == null)
        return null; 
      return cTStyleMatrixReference;
    } 
  }
  
  public boolean isSetBgRef() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(BGREF$2) != 0);
    } 
  }
  
  public void setBgRef(CTStyleMatrixReference paramCTStyleMatrixReference) {
    synchronized (monitor()) {
      check_orphaned();
      CTStyleMatrixReference cTStyleMatrixReference = null;
      cTStyleMatrixReference = (CTStyleMatrixReference)get_store().find_element_user(BGREF$2, 0);
      if (cTStyleMatrixReference == null)
        cTStyleMatrixReference = (CTStyleMatrixReference)get_store().add_element_user(BGREF$2); 
      cTStyleMatrixReference.set((XmlObject)paramCTStyleMatrixReference);
    } 
  }
  
  public CTStyleMatrixReference addNewBgRef() {
    synchronized (monitor()) {
      check_orphaned();
      CTStyleMatrixReference cTStyleMatrixReference = null;
      cTStyleMatrixReference = (CTStyleMatrixReference)get_store().add_element_user(BGREF$2);
      return cTStyleMatrixReference;
    } 
  }
  
  public void unsetBgRef() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BGREF$2, 0);
    } 
  }
  
  public STBlackWhiteMode.Enum getBwMode() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BWMODE$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(BWMODE$4); 
      if (simpleValue == null)
        return null; 
      return (STBlackWhiteMode.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STBlackWhiteMode xgetBwMode() {
    synchronized (monitor()) {
      check_orphaned();
      STBlackWhiteMode sTBlackWhiteMode = null;
      sTBlackWhiteMode = (STBlackWhiteMode)get_store().find_attribute_user(BWMODE$4);
      if (sTBlackWhiteMode == null)
        sTBlackWhiteMode = (STBlackWhiteMode)get_default_attribute_value(BWMODE$4); 
      return sTBlackWhiteMode;
    } 
  }
  
  public boolean isSetBwMode() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(BWMODE$4) != null);
    } 
  }
  
  public void setBwMode(STBlackWhiteMode.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BWMODE$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(BWMODE$4); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetBwMode(STBlackWhiteMode paramSTBlackWhiteMode) {
    synchronized (monitor()) {
      check_orphaned();
      STBlackWhiteMode sTBlackWhiteMode = null;
      sTBlackWhiteMode = (STBlackWhiteMode)get_store().find_attribute_user(BWMODE$4);
      if (sTBlackWhiteMode == null)
        sTBlackWhiteMode = (STBlackWhiteMode)get_store().add_attribute_user(BWMODE$4); 
      sTBlackWhiteMode.set((XmlObject)paramSTBlackWhiteMode);
    } 
  }
  
  public void unsetBwMode() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(BWMODE$4);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\impl\CTBackgroundImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */