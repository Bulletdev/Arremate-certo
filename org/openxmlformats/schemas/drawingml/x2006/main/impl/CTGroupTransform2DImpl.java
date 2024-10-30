package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGroupTransform2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.openxmlformats.schemas.drawingml.x2006.main.STAngle;

public class CTGroupTransform2DImpl extends XmlComplexContentImpl implements CTGroupTransform2D {
  private static final b OFF$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "off");
  
  private static final b EXT$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "ext");
  
  private static final b CHOFF$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "chOff");
  
  private static final b CHEXT$6 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "chExt");
  
  private static final b ROT$8 = new b("", "rot");
  
  private static final b FLIPH$10 = new b("", "flipH");
  
  private static final b FLIPV$12 = new b("", "flipV");
  
  public CTGroupTransform2DImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTPoint2D getOff() {
    synchronized (monitor()) {
      check_orphaned();
      CTPoint2D cTPoint2D = null;
      cTPoint2D = (CTPoint2D)get_store().find_element_user(OFF$0, 0);
      if (cTPoint2D == null)
        return null; 
      return cTPoint2D;
    } 
  }
  
  public boolean isSetOff() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(OFF$0) != 0);
    } 
  }
  
  public void setOff(CTPoint2D paramCTPoint2D) {
    synchronized (monitor()) {
      check_orphaned();
      CTPoint2D cTPoint2D = null;
      cTPoint2D = (CTPoint2D)get_store().find_element_user(OFF$0, 0);
      if (cTPoint2D == null)
        cTPoint2D = (CTPoint2D)get_store().add_element_user(OFF$0); 
      cTPoint2D.set((XmlObject)paramCTPoint2D);
    } 
  }
  
  public CTPoint2D addNewOff() {
    synchronized (monitor()) {
      check_orphaned();
      CTPoint2D cTPoint2D = null;
      cTPoint2D = (CTPoint2D)get_store().add_element_user(OFF$0);
      return cTPoint2D;
    } 
  }
  
  public void unsetOff() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(OFF$0, 0);
    } 
  }
  
  public CTPositiveSize2D getExt() {
    synchronized (monitor()) {
      check_orphaned();
      CTPositiveSize2D cTPositiveSize2D = null;
      cTPositiveSize2D = (CTPositiveSize2D)get_store().find_element_user(EXT$2, 0);
      if (cTPositiveSize2D == null)
        return null; 
      return cTPositiveSize2D;
    } 
  }
  
  public boolean isSetExt() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXT$2) != 0);
    } 
  }
  
  public void setExt(CTPositiveSize2D paramCTPositiveSize2D) {
    synchronized (monitor()) {
      check_orphaned();
      CTPositiveSize2D cTPositiveSize2D = null;
      cTPositiveSize2D = (CTPositiveSize2D)get_store().find_element_user(EXT$2, 0);
      if (cTPositiveSize2D == null)
        cTPositiveSize2D = (CTPositiveSize2D)get_store().add_element_user(EXT$2); 
      cTPositiveSize2D.set((XmlObject)paramCTPositiveSize2D);
    } 
  }
  
  public CTPositiveSize2D addNewExt() {
    synchronized (monitor()) {
      check_orphaned();
      CTPositiveSize2D cTPositiveSize2D = null;
      cTPositiveSize2D = (CTPositiveSize2D)get_store().add_element_user(EXT$2);
      return cTPositiveSize2D;
    } 
  }
  
  public void unsetExt() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXT$2, 0);
    } 
  }
  
  public CTPoint2D getChOff() {
    synchronized (monitor()) {
      check_orphaned();
      CTPoint2D cTPoint2D = null;
      cTPoint2D = (CTPoint2D)get_store().find_element_user(CHOFF$4, 0);
      if (cTPoint2D == null)
        return null; 
      return cTPoint2D;
    } 
  }
  
  public boolean isSetChOff() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(CHOFF$4) != 0);
    } 
  }
  
  public void setChOff(CTPoint2D paramCTPoint2D) {
    synchronized (monitor()) {
      check_orphaned();
      CTPoint2D cTPoint2D = null;
      cTPoint2D = (CTPoint2D)get_store().find_element_user(CHOFF$4, 0);
      if (cTPoint2D == null)
        cTPoint2D = (CTPoint2D)get_store().add_element_user(CHOFF$4); 
      cTPoint2D.set((XmlObject)paramCTPoint2D);
    } 
  }
  
  public CTPoint2D addNewChOff() {
    synchronized (monitor()) {
      check_orphaned();
      CTPoint2D cTPoint2D = null;
      cTPoint2D = (CTPoint2D)get_store().add_element_user(CHOFF$4);
      return cTPoint2D;
    } 
  }
  
  public void unsetChOff() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CHOFF$4, 0);
    } 
  }
  
  public CTPositiveSize2D getChExt() {
    synchronized (monitor()) {
      check_orphaned();
      CTPositiveSize2D cTPositiveSize2D = null;
      cTPositiveSize2D = (CTPositiveSize2D)get_store().find_element_user(CHEXT$6, 0);
      if (cTPositiveSize2D == null)
        return null; 
      return cTPositiveSize2D;
    } 
  }
  
  public boolean isSetChExt() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(CHEXT$6) != 0);
    } 
  }
  
  public void setChExt(CTPositiveSize2D paramCTPositiveSize2D) {
    synchronized (monitor()) {
      check_orphaned();
      CTPositiveSize2D cTPositiveSize2D = null;
      cTPositiveSize2D = (CTPositiveSize2D)get_store().find_element_user(CHEXT$6, 0);
      if (cTPositiveSize2D == null)
        cTPositiveSize2D = (CTPositiveSize2D)get_store().add_element_user(CHEXT$6); 
      cTPositiveSize2D.set((XmlObject)paramCTPositiveSize2D);
    } 
  }
  
  public CTPositiveSize2D addNewChExt() {
    synchronized (monitor()) {
      check_orphaned();
      CTPositiveSize2D cTPositiveSize2D = null;
      cTPositiveSize2D = (CTPositiveSize2D)get_store().add_element_user(CHEXT$6);
      return cTPositiveSize2D;
    } 
  }
  
  public void unsetChExt() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CHEXT$6, 0);
    } 
  }
  
  public int getRot() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ROT$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(ROT$8); 
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public STAngle xgetRot() {
    synchronized (monitor()) {
      check_orphaned();
      STAngle sTAngle = null;
      sTAngle = (STAngle)get_store().find_attribute_user(ROT$8);
      if (sTAngle == null)
        sTAngle = (STAngle)get_default_attribute_value(ROT$8); 
      return sTAngle;
    } 
  }
  
  public boolean isSetRot() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ROT$8) != null);
    } 
  }
  
  public void setRot(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ROT$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ROT$8); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetRot(STAngle paramSTAngle) {
    synchronized (monitor()) {
      check_orphaned();
      STAngle sTAngle = null;
      sTAngle = (STAngle)get_store().find_attribute_user(ROT$8);
      if (sTAngle == null)
        sTAngle = (STAngle)get_store().add_attribute_user(ROT$8); 
      sTAngle.set((XmlObject)paramSTAngle);
    } 
  }
  
  public void unsetRot() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ROT$8);
    } 
  }
  
  public boolean getFlipH() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FLIPH$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(FLIPH$10); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetFlipH() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(FLIPH$10);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(FLIPH$10); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetFlipH() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(FLIPH$10) != null);
    } 
  }
  
  public void setFlipH(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FLIPH$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FLIPH$10); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetFlipH(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(FLIPH$10);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(FLIPH$10); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetFlipH() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(FLIPH$10);
    } 
  }
  
  public boolean getFlipV() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FLIPV$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(FLIPV$12); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetFlipV() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(FLIPV$12);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(FLIPV$12); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetFlipV() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(FLIPV$12) != null);
    } 
  }
  
  public void setFlipV(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FLIPV$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FLIPV$12); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetFlipV(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(FLIPV$12);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(FLIPV$12); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetFlipV() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(FLIPV$12);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTGroupTransform2DImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */