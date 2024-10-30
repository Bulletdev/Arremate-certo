package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGradientStopList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTLinearShadeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPathShadeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTRelativeRect;
import org.openxmlformats.schemas.drawingml.x2006.main.STTileFlipMode;

public class CTGradientFillPropertiesImpl extends XmlComplexContentImpl implements CTGradientFillProperties {
  private static final b GSLST$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "gsLst");
  
  private static final b LIN$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "lin");
  
  private static final b PATH$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "path");
  
  private static final b TILERECT$6 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "tileRect");
  
  private static final b FLIP$8 = new b("", "flip");
  
  private static final b ROTWITHSHAPE$10 = new b("", "rotWithShape");
  
  public CTGradientFillPropertiesImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTGradientStopList getGsLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTGradientStopList cTGradientStopList = null;
      cTGradientStopList = (CTGradientStopList)get_store().find_element_user(GSLST$0, 0);
      if (cTGradientStopList == null)
        return null; 
      return cTGradientStopList;
    } 
  }
  
  public boolean isSetGsLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(GSLST$0) != 0);
    } 
  }
  
  public void setGsLst(CTGradientStopList paramCTGradientStopList) {
    synchronized (monitor()) {
      check_orphaned();
      CTGradientStopList cTGradientStopList = null;
      cTGradientStopList = (CTGradientStopList)get_store().find_element_user(GSLST$0, 0);
      if (cTGradientStopList == null)
        cTGradientStopList = (CTGradientStopList)get_store().add_element_user(GSLST$0); 
      cTGradientStopList.set((XmlObject)paramCTGradientStopList);
    } 
  }
  
  public CTGradientStopList addNewGsLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTGradientStopList cTGradientStopList = null;
      cTGradientStopList = (CTGradientStopList)get_store().add_element_user(GSLST$0);
      return cTGradientStopList;
    } 
  }
  
  public void unsetGsLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(GSLST$0, 0);
    } 
  }
  
  public CTLinearShadeProperties getLin() {
    synchronized (monitor()) {
      check_orphaned();
      CTLinearShadeProperties cTLinearShadeProperties = null;
      cTLinearShadeProperties = (CTLinearShadeProperties)get_store().find_element_user(LIN$2, 0);
      if (cTLinearShadeProperties == null)
        return null; 
      return cTLinearShadeProperties;
    } 
  }
  
  public boolean isSetLin() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(LIN$2) != 0);
    } 
  }
  
  public void setLin(CTLinearShadeProperties paramCTLinearShadeProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTLinearShadeProperties cTLinearShadeProperties = null;
      cTLinearShadeProperties = (CTLinearShadeProperties)get_store().find_element_user(LIN$2, 0);
      if (cTLinearShadeProperties == null)
        cTLinearShadeProperties = (CTLinearShadeProperties)get_store().add_element_user(LIN$2); 
      cTLinearShadeProperties.set((XmlObject)paramCTLinearShadeProperties);
    } 
  }
  
  public CTLinearShadeProperties addNewLin() {
    synchronized (monitor()) {
      check_orphaned();
      CTLinearShadeProperties cTLinearShadeProperties = null;
      cTLinearShadeProperties = (CTLinearShadeProperties)get_store().add_element_user(LIN$2);
      return cTLinearShadeProperties;
    } 
  }
  
  public void unsetLin() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LIN$2, 0);
    } 
  }
  
  public CTPathShadeProperties getPath() {
    synchronized (monitor()) {
      check_orphaned();
      CTPathShadeProperties cTPathShadeProperties = null;
      cTPathShadeProperties = (CTPathShadeProperties)get_store().find_element_user(PATH$4, 0);
      if (cTPathShadeProperties == null)
        return null; 
      return cTPathShadeProperties;
    } 
  }
  
  public boolean isSetPath() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PATH$4) != 0);
    } 
  }
  
  public void setPath(CTPathShadeProperties paramCTPathShadeProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTPathShadeProperties cTPathShadeProperties = null;
      cTPathShadeProperties = (CTPathShadeProperties)get_store().find_element_user(PATH$4, 0);
      if (cTPathShadeProperties == null)
        cTPathShadeProperties = (CTPathShadeProperties)get_store().add_element_user(PATH$4); 
      cTPathShadeProperties.set((XmlObject)paramCTPathShadeProperties);
    } 
  }
  
  public CTPathShadeProperties addNewPath() {
    synchronized (monitor()) {
      check_orphaned();
      CTPathShadeProperties cTPathShadeProperties = null;
      cTPathShadeProperties = (CTPathShadeProperties)get_store().add_element_user(PATH$4);
      return cTPathShadeProperties;
    } 
  }
  
  public void unsetPath() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PATH$4, 0);
    } 
  }
  
  public CTRelativeRect getTileRect() {
    synchronized (monitor()) {
      check_orphaned();
      CTRelativeRect cTRelativeRect = null;
      cTRelativeRect = (CTRelativeRect)get_store().find_element_user(TILERECT$6, 0);
      if (cTRelativeRect == null)
        return null; 
      return cTRelativeRect;
    } 
  }
  
  public boolean isSetTileRect() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TILERECT$6) != 0);
    } 
  }
  
  public void setTileRect(CTRelativeRect paramCTRelativeRect) {
    synchronized (monitor()) {
      check_orphaned();
      CTRelativeRect cTRelativeRect = null;
      cTRelativeRect = (CTRelativeRect)get_store().find_element_user(TILERECT$6, 0);
      if (cTRelativeRect == null)
        cTRelativeRect = (CTRelativeRect)get_store().add_element_user(TILERECT$6); 
      cTRelativeRect.set((XmlObject)paramCTRelativeRect);
    } 
  }
  
  public CTRelativeRect addNewTileRect() {
    synchronized (monitor()) {
      check_orphaned();
      CTRelativeRect cTRelativeRect = null;
      cTRelativeRect = (CTRelativeRect)get_store().add_element_user(TILERECT$6);
      return cTRelativeRect;
    } 
  }
  
  public void unsetTileRect() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TILERECT$6, 0);
    } 
  }
  
  public STTileFlipMode.Enum getFlip() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FLIP$8);
      if (simpleValue == null)
        return null; 
      return (STTileFlipMode.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTileFlipMode xgetFlip() {
    synchronized (monitor()) {
      check_orphaned();
      STTileFlipMode sTTileFlipMode = null;
      sTTileFlipMode = (STTileFlipMode)get_store().find_attribute_user(FLIP$8);
      return sTTileFlipMode;
    } 
  }
  
  public boolean isSetFlip() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(FLIP$8) != null);
    } 
  }
  
  public void setFlip(STTileFlipMode.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FLIP$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FLIP$8); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetFlip(STTileFlipMode paramSTTileFlipMode) {
    synchronized (monitor()) {
      check_orphaned();
      STTileFlipMode sTTileFlipMode = null;
      sTTileFlipMode = (STTileFlipMode)get_store().find_attribute_user(FLIP$8);
      if (sTTileFlipMode == null)
        sTTileFlipMode = (STTileFlipMode)get_store().add_attribute_user(FLIP$8); 
      sTTileFlipMode.set((XmlObject)paramSTTileFlipMode);
    } 
  }
  
  public void unsetFlip() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(FLIP$8);
    } 
  }
  
  public boolean getRotWithShape() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ROTWITHSHAPE$10);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetRotWithShape() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ROTWITHSHAPE$10);
      return xmlBoolean;
    } 
  }
  
  public boolean isSetRotWithShape() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ROTWITHSHAPE$10) != null);
    } 
  }
  
  public void setRotWithShape(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ROTWITHSHAPE$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ROTWITHSHAPE$10); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetRotWithShape(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ROTWITHSHAPE$10);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(ROTWITHSHAPE$10); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetRotWithShape() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ROTWITHSHAPE$10);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTGradientFillPropertiesImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */