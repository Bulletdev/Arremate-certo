package com.microsoft.schemas.vml.impl;

import com.microsoft.schemas.vml.CTH;
import com.microsoft.schemas.vml.STTrueFalse;
import com.microsoft.schemas.vml.STTrueFalseBlank;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

public class CTHImpl extends XmlComplexContentImpl implements CTH {
  private static final b POSITION$0 = new b("", "position");
  
  private static final b POLAR$2 = new b("", "polar");
  
  private static final b MAP$4 = new b("", "map");
  
  private static final b INVX$6 = new b("", "invx");
  
  private static final b INVY$8 = new b("", "invy");
  
  private static final b SWITCH$10 = new b("", "switch");
  
  private static final b XRANGE$12 = new b("", "xrange");
  
  private static final b YRANGE$14 = new b("", "yrange");
  
  private static final b RADIUSRANGE$16 = new b("", "radiusrange");
  
  public CTHImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public String getPosition() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(POSITION$0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetPosition() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(POSITION$0);
      return xmlString;
    } 
  }
  
  public boolean isSetPosition() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(POSITION$0) != null);
    } 
  }
  
  public void setPosition(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(POSITION$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(POSITION$0); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetPosition(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(POSITION$0);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(POSITION$0); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetPosition() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(POSITION$0);
    } 
  }
  
  public String getPolar() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(POLAR$2);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetPolar() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(POLAR$2);
      return xmlString;
    } 
  }
  
  public boolean isSetPolar() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(POLAR$2) != null);
    } 
  }
  
  public void setPolar(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(POLAR$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(POLAR$2); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetPolar(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(POLAR$2);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(POLAR$2); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetPolar() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(POLAR$2);
    } 
  }
  
  public String getMap() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MAP$4);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetMap() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(MAP$4);
      return xmlString;
    } 
  }
  
  public boolean isSetMap() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(MAP$4) != null);
    } 
  }
  
  public void setMap(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MAP$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(MAP$4); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetMap(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(MAP$4);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(MAP$4); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetMap() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(MAP$4);
    } 
  }
  
  public STTrueFalse.Enum getInvx() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(INVX$6);
      if (simpleValue == null)
        return null; 
      return (STTrueFalse.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalse xgetInvx() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(INVX$6);
      return sTTrueFalse;
    } 
  }
  
  public boolean isSetInvx() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(INVX$6) != null);
    } 
  }
  
  public void setInvx(STTrueFalse.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(INVX$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(INVX$6); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetInvx(STTrueFalse paramSTTrueFalse) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(INVX$6);
      if (sTTrueFalse == null)
        sTTrueFalse = (STTrueFalse)get_store().add_attribute_user(INVX$6); 
      sTTrueFalse.set((XmlObject)paramSTTrueFalse);
    } 
  }
  
  public void unsetInvx() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(INVX$6);
    } 
  }
  
  public STTrueFalse.Enum getInvy() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(INVY$8);
      if (simpleValue == null)
        return null; 
      return (STTrueFalse.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalse xgetInvy() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(INVY$8);
      return sTTrueFalse;
    } 
  }
  
  public boolean isSetInvy() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(INVY$8) != null);
    } 
  }
  
  public void setInvy(STTrueFalse.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(INVY$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(INVY$8); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetInvy(STTrueFalse paramSTTrueFalse) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(INVY$8);
      if (sTTrueFalse == null)
        sTTrueFalse = (STTrueFalse)get_store().add_attribute_user(INVY$8); 
      sTTrueFalse.set((XmlObject)paramSTTrueFalse);
    } 
  }
  
  public void unsetInvy() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(INVY$8);
    } 
  }
  
  public STTrueFalseBlank.Enum getSwitch() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SWITCH$10);
      if (simpleValue == null)
        return null; 
      return (STTrueFalseBlank.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalseBlank xgetSwitch() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().find_attribute_user(SWITCH$10);
      return sTTrueFalseBlank;
    } 
  }
  
  public boolean isSetSwitch() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SWITCH$10) != null);
    } 
  }
  
  public void setSwitch(STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SWITCH$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SWITCH$10); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetSwitch(STTrueFalseBlank paramSTTrueFalseBlank) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().find_attribute_user(SWITCH$10);
      if (sTTrueFalseBlank == null)
        sTTrueFalseBlank = (STTrueFalseBlank)get_store().add_attribute_user(SWITCH$10); 
      sTTrueFalseBlank.set((XmlObject)paramSTTrueFalseBlank);
    } 
  }
  
  public void unsetSwitch() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SWITCH$10);
    } 
  }
  
  public String getXrange() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(XRANGE$12);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetXrange() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(XRANGE$12);
      return xmlString;
    } 
  }
  
  public boolean isSetXrange() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(XRANGE$12) != null);
    } 
  }
  
  public void setXrange(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(XRANGE$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(XRANGE$12); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetXrange(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(XRANGE$12);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(XRANGE$12); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetXrange() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(XRANGE$12);
    } 
  }
  
  public String getYrange() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(YRANGE$14);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetYrange() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(YRANGE$14);
      return xmlString;
    } 
  }
  
  public boolean isSetYrange() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(YRANGE$14) != null);
    } 
  }
  
  public void setYrange(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(YRANGE$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(YRANGE$14); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetYrange(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(YRANGE$14);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(YRANGE$14); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetYrange() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(YRANGE$14);
    } 
  }
  
  public String getRadiusrange() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(RADIUSRANGE$16);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetRadiusrange() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(RADIUSRANGE$16);
      return xmlString;
    } 
  }
  
  public boolean isSetRadiusrange() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(RADIUSRANGE$16) != null);
    } 
  }
  
  public void setRadiusrange(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(RADIUSRANGE$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(RADIUSRANGE$16); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetRadiusrange(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(RADIUSRANGE$16);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(RADIUSRANGE$16); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetRadiusrange() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(RADIUSRANGE$16);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\vml\impl\CTHImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */