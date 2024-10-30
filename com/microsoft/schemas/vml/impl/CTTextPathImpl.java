package com.microsoft.schemas.vml.impl;

import com.microsoft.schemas.vml.CTTextPath;
import com.microsoft.schemas.vml.STTrueFalse;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

public class CTTextPathImpl extends XmlComplexContentImpl implements CTTextPath {
  private static final b ID$0 = new b("", "id");
  
  private static final b STYLE$2 = new b("", "style");
  
  private static final b ON$4 = new b("", "on");
  
  private static final b FITSHAPE$6 = new b("", "fitshape");
  
  private static final b FITPATH$8 = new b("", "fitpath");
  
  private static final b TRIM$10 = new b("", "trim");
  
  private static final b XSCALE$12 = new b("", "xscale");
  
  private static final b STRING$14 = new b("", "string");
  
  public CTTextPathImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public String getId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID$0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetId() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(ID$0);
      return xmlString;
    } 
  }
  
  public boolean isSetId() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ID$0) != null);
    } 
  }
  
  public void setId(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ID$0); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetId(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(ID$0);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(ID$0); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetId() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ID$0);
    } 
  }
  
  public String getStyle() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(STYLE$2);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetStyle() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(STYLE$2);
      return xmlString;
    } 
  }
  
  public boolean isSetStyle() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(STYLE$2) != null);
    } 
  }
  
  public void setStyle(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(STYLE$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(STYLE$2); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetStyle(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(STYLE$2);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(STYLE$2); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetStyle() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(STYLE$2);
    } 
  }
  
  public STTrueFalse.Enum getOn() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ON$4);
      if (simpleValue == null)
        return null; 
      return (STTrueFalse.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalse xgetOn() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(ON$4);
      return sTTrueFalse;
    } 
  }
  
  public boolean isSetOn() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ON$4) != null);
    } 
  }
  
  public void setOn(STTrueFalse.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ON$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ON$4); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetOn(STTrueFalse paramSTTrueFalse) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(ON$4);
      if (sTTrueFalse == null)
        sTTrueFalse = (STTrueFalse)get_store().add_attribute_user(ON$4); 
      sTTrueFalse.set((XmlObject)paramSTTrueFalse);
    } 
  }
  
  public void unsetOn() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ON$4);
    } 
  }
  
  public STTrueFalse.Enum getFitshape() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FITSHAPE$6);
      if (simpleValue == null)
        return null; 
      return (STTrueFalse.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalse xgetFitshape() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(FITSHAPE$6);
      return sTTrueFalse;
    } 
  }
  
  public boolean isSetFitshape() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(FITSHAPE$6) != null);
    } 
  }
  
  public void setFitshape(STTrueFalse.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FITSHAPE$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FITSHAPE$6); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetFitshape(STTrueFalse paramSTTrueFalse) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(FITSHAPE$6);
      if (sTTrueFalse == null)
        sTTrueFalse = (STTrueFalse)get_store().add_attribute_user(FITSHAPE$6); 
      sTTrueFalse.set((XmlObject)paramSTTrueFalse);
    } 
  }
  
  public void unsetFitshape() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(FITSHAPE$6);
    } 
  }
  
  public STTrueFalse.Enum getFitpath() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FITPATH$8);
      if (simpleValue == null)
        return null; 
      return (STTrueFalse.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalse xgetFitpath() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(FITPATH$8);
      return sTTrueFalse;
    } 
  }
  
  public boolean isSetFitpath() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(FITPATH$8) != null);
    } 
  }
  
  public void setFitpath(STTrueFalse.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FITPATH$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FITPATH$8); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetFitpath(STTrueFalse paramSTTrueFalse) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(FITPATH$8);
      if (sTTrueFalse == null)
        sTTrueFalse = (STTrueFalse)get_store().add_attribute_user(FITPATH$8); 
      sTTrueFalse.set((XmlObject)paramSTTrueFalse);
    } 
  }
  
  public void unsetFitpath() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(FITPATH$8);
    } 
  }
  
  public STTrueFalse.Enum getTrim() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TRIM$10);
      if (simpleValue == null)
        return null; 
      return (STTrueFalse.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalse xgetTrim() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(TRIM$10);
      return sTTrueFalse;
    } 
  }
  
  public boolean isSetTrim() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(TRIM$10) != null);
    } 
  }
  
  public void setTrim(STTrueFalse.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TRIM$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TRIM$10); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetTrim(STTrueFalse paramSTTrueFalse) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(TRIM$10);
      if (sTTrueFalse == null)
        sTTrueFalse = (STTrueFalse)get_store().add_attribute_user(TRIM$10); 
      sTTrueFalse.set((XmlObject)paramSTTrueFalse);
    } 
  }
  
  public void unsetTrim() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(TRIM$10);
    } 
  }
  
  public STTrueFalse.Enum getXscale() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(XSCALE$12);
      if (simpleValue == null)
        return null; 
      return (STTrueFalse.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalse xgetXscale() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(XSCALE$12);
      return sTTrueFalse;
    } 
  }
  
  public boolean isSetXscale() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(XSCALE$12) != null);
    } 
  }
  
  public void setXscale(STTrueFalse.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(XSCALE$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(XSCALE$12); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetXscale(STTrueFalse paramSTTrueFalse) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(XSCALE$12);
      if (sTTrueFalse == null)
        sTTrueFalse = (STTrueFalse)get_store().add_attribute_user(XSCALE$12); 
      sTTrueFalse.set((XmlObject)paramSTTrueFalse);
    } 
  }
  
  public void unsetXscale() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(XSCALE$12);
    } 
  }
  
  public String getString() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(STRING$14);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetString() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(STRING$14);
      return xmlString;
    } 
  }
  
  public boolean isSetString() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(STRING$14) != null);
    } 
  }
  
  public void setString(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(STRING$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(STRING$14); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetString(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(STRING$14);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(STRING$14); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetString() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(STRING$14);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\vml\impl\CTTextPathImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */