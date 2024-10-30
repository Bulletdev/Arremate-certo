package com.microsoft.schemas.vml.impl;

import com.microsoft.schemas.vml.CTShadow;
import com.microsoft.schemas.vml.STColorType;
import com.microsoft.schemas.vml.STShadowType;
import com.microsoft.schemas.vml.STTrueFalse;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

public class CTShadowImpl extends XmlComplexContentImpl implements CTShadow {
  private static final b ID$0 = new b("", "id");
  
  private static final b ON$2 = new b("", "on");
  
  private static final b TYPE$4 = new b("", "type");
  
  private static final b OBSCURED$6 = new b("", "obscured");
  
  private static final b COLOR$8 = new b("", "color");
  
  private static final b OPACITY$10 = new b("", "opacity");
  
  private static final b OFFSET$12 = new b("", "offset");
  
  private static final b COLOR2$14 = new b("", "color2");
  
  private static final b OFFSET2$16 = new b("", "offset2");
  
  private static final b ORIGIN$18 = new b("", "origin");
  
  private static final b MATRIX$20 = new b("", "matrix");
  
  public CTShadowImpl(SchemaType paramSchemaType) {
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
  
  public STTrueFalse.Enum getOn() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ON$2);
      if (simpleValue == null)
        return null; 
      return (STTrueFalse.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalse xgetOn() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(ON$2);
      return sTTrueFalse;
    } 
  }
  
  public boolean isSetOn() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ON$2) != null);
    } 
  }
  
  public void setOn(STTrueFalse.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ON$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ON$2); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetOn(STTrueFalse paramSTTrueFalse) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(ON$2);
      if (sTTrueFalse == null)
        sTTrueFalse = (STTrueFalse)get_store().add_attribute_user(ON$2); 
      sTTrueFalse.set((XmlObject)paramSTTrueFalse);
    } 
  }
  
  public void unsetOn() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ON$2);
    } 
  }
  
  public STShadowType.Enum getType() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TYPE$4);
      if (simpleValue == null)
        return null; 
      return (STShadowType.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STShadowType xgetType() {
    synchronized (monitor()) {
      check_orphaned();
      STShadowType sTShadowType = null;
      sTShadowType = (STShadowType)get_store().find_attribute_user(TYPE$4);
      return sTShadowType;
    } 
  }
  
  public boolean isSetType() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(TYPE$4) != null);
    } 
  }
  
  public void setType(STShadowType.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TYPE$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TYPE$4); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetType(STShadowType paramSTShadowType) {
    synchronized (monitor()) {
      check_orphaned();
      STShadowType sTShadowType = null;
      sTShadowType = (STShadowType)get_store().find_attribute_user(TYPE$4);
      if (sTShadowType == null)
        sTShadowType = (STShadowType)get_store().add_attribute_user(TYPE$4); 
      sTShadowType.set((XmlObject)paramSTShadowType);
    } 
  }
  
  public void unsetType() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(TYPE$4);
    } 
  }
  
  public STTrueFalse.Enum getObscured() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(OBSCURED$6);
      if (simpleValue == null)
        return null; 
      return (STTrueFalse.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalse xgetObscured() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(OBSCURED$6);
      return sTTrueFalse;
    } 
  }
  
  public boolean isSetObscured() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(OBSCURED$6) != null);
    } 
  }
  
  public void setObscured(STTrueFalse.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(OBSCURED$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(OBSCURED$6); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetObscured(STTrueFalse paramSTTrueFalse) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(OBSCURED$6);
      if (sTTrueFalse == null)
        sTTrueFalse = (STTrueFalse)get_store().add_attribute_user(OBSCURED$6); 
      sTTrueFalse.set((XmlObject)paramSTTrueFalse);
    } 
  }
  
  public void unsetObscured() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(OBSCURED$6);
    } 
  }
  
  public String getColor() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COLOR$8);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STColorType xgetColor() {
    synchronized (monitor()) {
      check_orphaned();
      STColorType sTColorType = null;
      sTColorType = (STColorType)get_store().find_attribute_user(COLOR$8);
      return sTColorType;
    } 
  }
  
  public boolean isSetColor() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(COLOR$8) != null);
    } 
  }
  
  public void setColor(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COLOR$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(COLOR$8); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetColor(STColorType paramSTColorType) {
    synchronized (monitor()) {
      check_orphaned();
      STColorType sTColorType = null;
      sTColorType = (STColorType)get_store().find_attribute_user(COLOR$8);
      if (sTColorType == null)
        sTColorType = (STColorType)get_store().add_attribute_user(COLOR$8); 
      sTColorType.set((XmlObject)paramSTColorType);
    } 
  }
  
  public void unsetColor() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(COLOR$8);
    } 
  }
  
  public String getOpacity() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(OPACITY$10);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetOpacity() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(OPACITY$10);
      return xmlString;
    } 
  }
  
  public boolean isSetOpacity() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(OPACITY$10) != null);
    } 
  }
  
  public void setOpacity(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(OPACITY$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(OPACITY$10); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetOpacity(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(OPACITY$10);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(OPACITY$10); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetOpacity() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(OPACITY$10);
    } 
  }
  
  public String getOffset() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(OFFSET$12);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetOffset() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(OFFSET$12);
      return xmlString;
    } 
  }
  
  public boolean isSetOffset() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(OFFSET$12) != null);
    } 
  }
  
  public void setOffset(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(OFFSET$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(OFFSET$12); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetOffset(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(OFFSET$12);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(OFFSET$12); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetOffset() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(OFFSET$12);
    } 
  }
  
  public String getColor2() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COLOR2$14);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STColorType xgetColor2() {
    synchronized (monitor()) {
      check_orphaned();
      STColorType sTColorType = null;
      sTColorType = (STColorType)get_store().find_attribute_user(COLOR2$14);
      return sTColorType;
    } 
  }
  
  public boolean isSetColor2() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(COLOR2$14) != null);
    } 
  }
  
  public void setColor2(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COLOR2$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(COLOR2$14); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetColor2(STColorType paramSTColorType) {
    synchronized (monitor()) {
      check_orphaned();
      STColorType sTColorType = null;
      sTColorType = (STColorType)get_store().find_attribute_user(COLOR2$14);
      if (sTColorType == null)
        sTColorType = (STColorType)get_store().add_attribute_user(COLOR2$14); 
      sTColorType.set((XmlObject)paramSTColorType);
    } 
  }
  
  public void unsetColor2() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(COLOR2$14);
    } 
  }
  
  public String getOffset2() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(OFFSET2$16);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetOffset2() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(OFFSET2$16);
      return xmlString;
    } 
  }
  
  public boolean isSetOffset2() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(OFFSET2$16) != null);
    } 
  }
  
  public void setOffset2(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(OFFSET2$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(OFFSET2$16); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetOffset2(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(OFFSET2$16);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(OFFSET2$16); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetOffset2() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(OFFSET2$16);
    } 
  }
  
  public String getOrigin() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ORIGIN$18);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetOrigin() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(ORIGIN$18);
      return xmlString;
    } 
  }
  
  public boolean isSetOrigin() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ORIGIN$18) != null);
    } 
  }
  
  public void setOrigin(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ORIGIN$18);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ORIGIN$18); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetOrigin(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(ORIGIN$18);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(ORIGIN$18); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetOrigin() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ORIGIN$18);
    } 
  }
  
  public String getMatrix() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MATRIX$20);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetMatrix() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(MATRIX$20);
      return xmlString;
    } 
  }
  
  public boolean isSetMatrix() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(MATRIX$20) != null);
    } 
  }
  
  public void setMatrix(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MATRIX$20);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(MATRIX$20); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetMatrix(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(MATRIX$20);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(MATRIX$20); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetMatrix() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(MATRIX$20);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\vml\impl\CTShadowImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */