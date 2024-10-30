package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlip;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTRelativeRect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTStretchInfoProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTileInfoProperties;

public class CTBlipFillPropertiesImpl extends XmlComplexContentImpl implements CTBlipFillProperties {
  private static final b BLIP$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "blip");
  
  private static final b SRCRECT$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "srcRect");
  
  private static final b TILE$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "tile");
  
  private static final b STRETCH$6 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "stretch");
  
  private static final b DPI$8 = new b("", "dpi");
  
  private static final b ROTWITHSHAPE$10 = new b("", "rotWithShape");
  
  public CTBlipFillPropertiesImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTBlip getBlip() {
    synchronized (monitor()) {
      check_orphaned();
      CTBlip cTBlip = null;
      cTBlip = (CTBlip)get_store().find_element_user(BLIP$0, 0);
      if (cTBlip == null)
        return null; 
      return cTBlip;
    } 
  }
  
  public boolean isSetBlip() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(BLIP$0) != 0);
    } 
  }
  
  public void setBlip(CTBlip paramCTBlip) {
    synchronized (monitor()) {
      check_orphaned();
      CTBlip cTBlip = null;
      cTBlip = (CTBlip)get_store().find_element_user(BLIP$0, 0);
      if (cTBlip == null)
        cTBlip = (CTBlip)get_store().add_element_user(BLIP$0); 
      cTBlip.set((XmlObject)paramCTBlip);
    } 
  }
  
  public CTBlip addNewBlip() {
    synchronized (monitor()) {
      check_orphaned();
      CTBlip cTBlip = null;
      cTBlip = (CTBlip)get_store().add_element_user(BLIP$0);
      return cTBlip;
    } 
  }
  
  public void unsetBlip() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BLIP$0, 0);
    } 
  }
  
  public CTRelativeRect getSrcRect() {
    synchronized (monitor()) {
      check_orphaned();
      CTRelativeRect cTRelativeRect = null;
      cTRelativeRect = (CTRelativeRect)get_store().find_element_user(SRCRECT$2, 0);
      if (cTRelativeRect == null)
        return null; 
      return cTRelativeRect;
    } 
  }
  
  public boolean isSetSrcRect() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SRCRECT$2) != 0);
    } 
  }
  
  public void setSrcRect(CTRelativeRect paramCTRelativeRect) {
    synchronized (monitor()) {
      check_orphaned();
      CTRelativeRect cTRelativeRect = null;
      cTRelativeRect = (CTRelativeRect)get_store().find_element_user(SRCRECT$2, 0);
      if (cTRelativeRect == null)
        cTRelativeRect = (CTRelativeRect)get_store().add_element_user(SRCRECT$2); 
      cTRelativeRect.set((XmlObject)paramCTRelativeRect);
    } 
  }
  
  public CTRelativeRect addNewSrcRect() {
    synchronized (monitor()) {
      check_orphaned();
      CTRelativeRect cTRelativeRect = null;
      cTRelativeRect = (CTRelativeRect)get_store().add_element_user(SRCRECT$2);
      return cTRelativeRect;
    } 
  }
  
  public void unsetSrcRect() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SRCRECT$2, 0);
    } 
  }
  
  public CTTileInfoProperties getTile() {
    synchronized (monitor()) {
      check_orphaned();
      CTTileInfoProperties cTTileInfoProperties = null;
      cTTileInfoProperties = (CTTileInfoProperties)get_store().find_element_user(TILE$4, 0);
      if (cTTileInfoProperties == null)
        return null; 
      return cTTileInfoProperties;
    } 
  }
  
  public boolean isSetTile() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TILE$4) != 0);
    } 
  }
  
  public void setTile(CTTileInfoProperties paramCTTileInfoProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTTileInfoProperties cTTileInfoProperties = null;
      cTTileInfoProperties = (CTTileInfoProperties)get_store().find_element_user(TILE$4, 0);
      if (cTTileInfoProperties == null)
        cTTileInfoProperties = (CTTileInfoProperties)get_store().add_element_user(TILE$4); 
      cTTileInfoProperties.set((XmlObject)paramCTTileInfoProperties);
    } 
  }
  
  public CTTileInfoProperties addNewTile() {
    synchronized (monitor()) {
      check_orphaned();
      CTTileInfoProperties cTTileInfoProperties = null;
      cTTileInfoProperties = (CTTileInfoProperties)get_store().add_element_user(TILE$4);
      return cTTileInfoProperties;
    } 
  }
  
  public void unsetTile() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TILE$4, 0);
    } 
  }
  
  public CTStretchInfoProperties getStretch() {
    synchronized (monitor()) {
      check_orphaned();
      CTStretchInfoProperties cTStretchInfoProperties = null;
      cTStretchInfoProperties = (CTStretchInfoProperties)get_store().find_element_user(STRETCH$6, 0);
      if (cTStretchInfoProperties == null)
        return null; 
      return cTStretchInfoProperties;
    } 
  }
  
  public boolean isSetStretch() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(STRETCH$6) != 0);
    } 
  }
  
  public void setStretch(CTStretchInfoProperties paramCTStretchInfoProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTStretchInfoProperties cTStretchInfoProperties = null;
      cTStretchInfoProperties = (CTStretchInfoProperties)get_store().find_element_user(STRETCH$6, 0);
      if (cTStretchInfoProperties == null)
        cTStretchInfoProperties = (CTStretchInfoProperties)get_store().add_element_user(STRETCH$6); 
      cTStretchInfoProperties.set((XmlObject)paramCTStretchInfoProperties);
    } 
  }
  
  public CTStretchInfoProperties addNewStretch() {
    synchronized (monitor()) {
      check_orphaned();
      CTStretchInfoProperties cTStretchInfoProperties = null;
      cTStretchInfoProperties = (CTStretchInfoProperties)get_store().add_element_user(STRETCH$6);
      return cTStretchInfoProperties;
    } 
  }
  
  public void unsetStretch() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(STRETCH$6, 0);
    } 
  }
  
  public long getDpi() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DPI$8);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetDpi() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(DPI$8);
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetDpi() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DPI$8) != null);
    } 
  }
  
  public void setDpi(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DPI$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DPI$8); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetDpi(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(DPI$8);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(DPI$8); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetDpi() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DPI$8);
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTBlipFillPropertiesImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */