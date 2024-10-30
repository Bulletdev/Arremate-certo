package com.microsoft.schemas.vml.impl;

import com.microsoft.schemas.office.office.CTFill;
import com.microsoft.schemas.office.office.STRelationshipId;
import com.microsoft.schemas.office.office.STTrueFalse;
import com.microsoft.schemas.vml.CTFill;
import com.microsoft.schemas.vml.STColorType;
import com.microsoft.schemas.vml.STFillMethod;
import com.microsoft.schemas.vml.STFillType;
import com.microsoft.schemas.vml.STImageAspect;
import com.microsoft.schemas.vml.STTrueFalse;
import java.math.BigDecimal;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlDecimal;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;

public class CTFillImpl extends XmlComplexContentImpl implements CTFill {
  private static final b FILL$0 = new b("urn:schemas-microsoft-com:office:office", "fill");
  
  private static final b ID$2 = new b("", "id");
  
  private static final b TYPE$4 = new b("", "type");
  
  private static final b ON$6 = new b("", "on");
  
  private static final b COLOR$8 = new b("", "color");
  
  private static final b OPACITY$10 = new b("", "opacity");
  
  private static final b COLOR2$12 = new b("", "color2");
  
  private static final b SRC$14 = new b("", "src");
  
  private static final b HREF$16 = new b("urn:schemas-microsoft-com:office:office", "href");
  
  private static final b ALTHREF$18 = new b("urn:schemas-microsoft-com:office:office", "althref");
  
  private static final b SIZE$20 = new b("", "size");
  
  private static final b ORIGIN$22 = new b("", "origin");
  
  private static final b POSITION$24 = new b("", "position");
  
  private static final b ASPECT$26 = new b("", "aspect");
  
  private static final b COLORS$28 = new b("", "colors");
  
  private static final b ANGLE$30 = new b("", "angle");
  
  private static final b ALIGNSHAPE$32 = new b("", "alignshape");
  
  private static final b FOCUS$34 = new b("", "focus");
  
  private static final b FOCUSSIZE$36 = new b("", "focussize");
  
  private static final b FOCUSPOSITION$38 = new b("", "focusposition");
  
  private static final b METHOD$40 = new b("", "method");
  
  private static final b DETECTMOUSECLICK$42 = new b("urn:schemas-microsoft-com:office:office", "detectmouseclick");
  
  private static final b TITLE$44 = new b("urn:schemas-microsoft-com:office:office", "title");
  
  private static final b OPACITY2$46 = new b("urn:schemas-microsoft-com:office:office", "opacity2");
  
  private static final b RECOLOR$48 = new b("", "recolor");
  
  private static final b ROTATE$50 = new b("", "rotate");
  
  private static final b ID2$52 = new b("http://schemas.openxmlformats.org/officeDocument/2006/relationships", "id");
  
  private static final b RELID$54 = new b("urn:schemas-microsoft-com:office:office", "relid");
  
  public CTFillImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTFill getFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTFill cTFill = null;
      cTFill = (CTFill)get_store().find_element_user(FILL$0, 0);
      if (cTFill == null)
        return null; 
      return cTFill;
    } 
  }
  
  public boolean isSetFill() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(FILL$0) != 0);
    } 
  }
  
  public void setFill(CTFill paramCTFill) {
    synchronized (monitor()) {
      check_orphaned();
      CTFill cTFill = null;
      cTFill = (CTFill)get_store().find_element_user(FILL$0, 0);
      if (cTFill == null)
        cTFill = (CTFill)get_store().add_element_user(FILL$0); 
      cTFill.set((XmlObject)paramCTFill);
    } 
  }
  
  public CTFill addNewFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTFill cTFill = null;
      cTFill = (CTFill)get_store().add_element_user(FILL$0);
      return cTFill;
    } 
  }
  
  public void unsetFill() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(FILL$0, 0);
    } 
  }
  
  public String getId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID$2);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetId() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(ID$2);
      return xmlString;
    } 
  }
  
  public boolean isSetId() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ID$2) != null);
    } 
  }
  
  public void setId(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ID$2); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetId(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(ID$2);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(ID$2); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetId() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ID$2);
    } 
  }
  
  public STFillType.Enum getType() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TYPE$4);
      if (simpleValue == null)
        return null; 
      return (STFillType.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STFillType xgetType() {
    synchronized (monitor()) {
      check_orphaned();
      STFillType sTFillType = null;
      sTFillType = (STFillType)get_store().find_attribute_user(TYPE$4);
      return sTFillType;
    } 
  }
  
  public boolean isSetType() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(TYPE$4) != null);
    } 
  }
  
  public void setType(STFillType.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TYPE$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TYPE$4); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetType(STFillType paramSTFillType) {
    synchronized (monitor()) {
      check_orphaned();
      STFillType sTFillType = null;
      sTFillType = (STFillType)get_store().find_attribute_user(TYPE$4);
      if (sTFillType == null)
        sTFillType = (STFillType)get_store().add_attribute_user(TYPE$4); 
      sTFillType.set((XmlObject)paramSTFillType);
    } 
  }
  
  public void unsetType() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(TYPE$4);
    } 
  }
  
  public STTrueFalse.Enum getOn() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ON$6);
      if (simpleValue == null)
        return null; 
      return (STTrueFalse.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalse xgetOn() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(ON$6);
      return sTTrueFalse;
    } 
  }
  
  public boolean isSetOn() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ON$6) != null);
    } 
  }
  
  public void setOn(STTrueFalse.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ON$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ON$6); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetOn(STTrueFalse paramSTTrueFalse) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(ON$6);
      if (sTTrueFalse == null)
        sTTrueFalse = (STTrueFalse)get_store().add_attribute_user(ON$6); 
      sTTrueFalse.set((XmlObject)paramSTTrueFalse);
    } 
  }
  
  public void unsetOn() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ON$6);
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
  
  public String getColor2() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COLOR2$12);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STColorType xgetColor2() {
    synchronized (monitor()) {
      check_orphaned();
      STColorType sTColorType = null;
      sTColorType = (STColorType)get_store().find_attribute_user(COLOR2$12);
      return sTColorType;
    } 
  }
  
  public boolean isSetColor2() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(COLOR2$12) != null);
    } 
  }
  
  public void setColor2(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COLOR2$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(COLOR2$12); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetColor2(STColorType paramSTColorType) {
    synchronized (monitor()) {
      check_orphaned();
      STColorType sTColorType = null;
      sTColorType = (STColorType)get_store().find_attribute_user(COLOR2$12);
      if (sTColorType == null)
        sTColorType = (STColorType)get_store().add_attribute_user(COLOR2$12); 
      sTColorType.set((XmlObject)paramSTColorType);
    } 
  }
  
  public void unsetColor2() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(COLOR2$12);
    } 
  }
  
  public String getSrc() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SRC$14);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetSrc() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(SRC$14);
      return xmlString;
    } 
  }
  
  public boolean isSetSrc() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SRC$14) != null);
    } 
  }
  
  public void setSrc(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SRC$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SRC$14); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetSrc(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(SRC$14);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(SRC$14); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetSrc() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SRC$14);
    } 
  }
  
  public String getHref() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HREF$16);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetHref() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(HREF$16);
      return xmlString;
    } 
  }
  
  public boolean isSetHref() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(HREF$16) != null);
    } 
  }
  
  public void setHref(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HREF$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(HREF$16); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetHref(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(HREF$16);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(HREF$16); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetHref() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(HREF$16);
    } 
  }
  
  public String getAlthref() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ALTHREF$18);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetAlthref() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(ALTHREF$18);
      return xmlString;
    } 
  }
  
  public boolean isSetAlthref() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ALTHREF$18) != null);
    } 
  }
  
  public void setAlthref(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ALTHREF$18);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ALTHREF$18); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetAlthref(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(ALTHREF$18);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(ALTHREF$18); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetAlthref() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ALTHREF$18);
    } 
  }
  
  public String getSize() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SIZE$20);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetSize() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(SIZE$20);
      return xmlString;
    } 
  }
  
  public boolean isSetSize() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SIZE$20) != null);
    } 
  }
  
  public void setSize(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SIZE$20);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SIZE$20); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetSize(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(SIZE$20);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(SIZE$20); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetSize() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SIZE$20);
    } 
  }
  
  public String getOrigin() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ORIGIN$22);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetOrigin() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(ORIGIN$22);
      return xmlString;
    } 
  }
  
  public boolean isSetOrigin() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ORIGIN$22) != null);
    } 
  }
  
  public void setOrigin(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ORIGIN$22);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ORIGIN$22); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetOrigin(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(ORIGIN$22);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(ORIGIN$22); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetOrigin() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ORIGIN$22);
    } 
  }
  
  public String getPosition() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(POSITION$24);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetPosition() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(POSITION$24);
      return xmlString;
    } 
  }
  
  public boolean isSetPosition() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(POSITION$24) != null);
    } 
  }
  
  public void setPosition(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(POSITION$24);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(POSITION$24); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetPosition(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(POSITION$24);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(POSITION$24); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetPosition() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(POSITION$24);
    } 
  }
  
  public STImageAspect.Enum getAspect() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ASPECT$26);
      if (simpleValue == null)
        return null; 
      return (STImageAspect.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STImageAspect xgetAspect() {
    synchronized (monitor()) {
      check_orphaned();
      STImageAspect sTImageAspect = null;
      sTImageAspect = (STImageAspect)get_store().find_attribute_user(ASPECT$26);
      return sTImageAspect;
    } 
  }
  
  public boolean isSetAspect() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ASPECT$26) != null);
    } 
  }
  
  public void setAspect(STImageAspect.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ASPECT$26);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ASPECT$26); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetAspect(STImageAspect paramSTImageAspect) {
    synchronized (monitor()) {
      check_orphaned();
      STImageAspect sTImageAspect = null;
      sTImageAspect = (STImageAspect)get_store().find_attribute_user(ASPECT$26);
      if (sTImageAspect == null)
        sTImageAspect = (STImageAspect)get_store().add_attribute_user(ASPECT$26); 
      sTImageAspect.set((XmlObject)paramSTImageAspect);
    } 
  }
  
  public void unsetAspect() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ASPECT$26);
    } 
  }
  
  public String getColors() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COLORS$28);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetColors() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(COLORS$28);
      return xmlString;
    } 
  }
  
  public boolean isSetColors() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(COLORS$28) != null);
    } 
  }
  
  public void setColors(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COLORS$28);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(COLORS$28); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetColors(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(COLORS$28);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(COLORS$28); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetColors() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(COLORS$28);
    } 
  }
  
  public BigDecimal getAngle() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ANGLE$30);
      if (simpleValue == null)
        return null; 
      return simpleValue.getBigDecimalValue();
    } 
  }
  
  public XmlDecimal xgetAngle() {
    synchronized (monitor()) {
      check_orphaned();
      XmlDecimal xmlDecimal = null;
      xmlDecimal = (XmlDecimal)get_store().find_attribute_user(ANGLE$30);
      return xmlDecimal;
    } 
  }
  
  public boolean isSetAngle() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ANGLE$30) != null);
    } 
  }
  
  public void setAngle(BigDecimal paramBigDecimal) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ANGLE$30);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ANGLE$30); 
      simpleValue.setBigDecimalValue(paramBigDecimal);
    } 
  }
  
  public void xsetAngle(XmlDecimal paramXmlDecimal) {
    synchronized (monitor()) {
      check_orphaned();
      XmlDecimal xmlDecimal = null;
      xmlDecimal = (XmlDecimal)get_store().find_attribute_user(ANGLE$30);
      if (xmlDecimal == null)
        xmlDecimal = (XmlDecimal)get_store().add_attribute_user(ANGLE$30); 
      xmlDecimal.set((XmlObject)paramXmlDecimal);
    } 
  }
  
  public void unsetAngle() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ANGLE$30);
    } 
  }
  
  public STTrueFalse.Enum getAlignshape() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ALIGNSHAPE$32);
      if (simpleValue == null)
        return null; 
      return (STTrueFalse.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalse xgetAlignshape() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(ALIGNSHAPE$32);
      return sTTrueFalse;
    } 
  }
  
  public boolean isSetAlignshape() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ALIGNSHAPE$32) != null);
    } 
  }
  
  public void setAlignshape(STTrueFalse.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ALIGNSHAPE$32);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ALIGNSHAPE$32); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetAlignshape(STTrueFalse paramSTTrueFalse) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(ALIGNSHAPE$32);
      if (sTTrueFalse == null)
        sTTrueFalse = (STTrueFalse)get_store().add_attribute_user(ALIGNSHAPE$32); 
      sTTrueFalse.set((XmlObject)paramSTTrueFalse);
    } 
  }
  
  public void unsetAlignshape() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ALIGNSHAPE$32);
    } 
  }
  
  public String getFocus() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FOCUS$34);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetFocus() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(FOCUS$34);
      return xmlString;
    } 
  }
  
  public boolean isSetFocus() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(FOCUS$34) != null);
    } 
  }
  
  public void setFocus(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FOCUS$34);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FOCUS$34); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetFocus(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(FOCUS$34);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(FOCUS$34); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetFocus() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(FOCUS$34);
    } 
  }
  
  public String getFocussize() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FOCUSSIZE$36);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetFocussize() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(FOCUSSIZE$36);
      return xmlString;
    } 
  }
  
  public boolean isSetFocussize() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(FOCUSSIZE$36) != null);
    } 
  }
  
  public void setFocussize(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FOCUSSIZE$36);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FOCUSSIZE$36); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetFocussize(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(FOCUSSIZE$36);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(FOCUSSIZE$36); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetFocussize() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(FOCUSSIZE$36);
    } 
  }
  
  public String getFocusposition() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FOCUSPOSITION$38);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetFocusposition() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(FOCUSPOSITION$38);
      return xmlString;
    } 
  }
  
  public boolean isSetFocusposition() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(FOCUSPOSITION$38) != null);
    } 
  }
  
  public void setFocusposition(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FOCUSPOSITION$38);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FOCUSPOSITION$38); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetFocusposition(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(FOCUSPOSITION$38);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(FOCUSPOSITION$38); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetFocusposition() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(FOCUSPOSITION$38);
    } 
  }
  
  public STFillMethod.Enum getMethod() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(METHOD$40);
      if (simpleValue == null)
        return null; 
      return (STFillMethod.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STFillMethod xgetMethod() {
    synchronized (monitor()) {
      check_orphaned();
      STFillMethod sTFillMethod = null;
      sTFillMethod = (STFillMethod)get_store().find_attribute_user(METHOD$40);
      return sTFillMethod;
    } 
  }
  
  public boolean isSetMethod() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(METHOD$40) != null);
    } 
  }
  
  public void setMethod(STFillMethod.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(METHOD$40);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(METHOD$40); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetMethod(STFillMethod paramSTFillMethod) {
    synchronized (monitor()) {
      check_orphaned();
      STFillMethod sTFillMethod = null;
      sTFillMethod = (STFillMethod)get_store().find_attribute_user(METHOD$40);
      if (sTFillMethod == null)
        sTFillMethod = (STFillMethod)get_store().add_attribute_user(METHOD$40); 
      sTFillMethod.set((XmlObject)paramSTFillMethod);
    } 
  }
  
  public void unsetMethod() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(METHOD$40);
    } 
  }
  
  public STTrueFalse.Enum getDetectmouseclick() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DETECTMOUSECLICK$42);
      if (simpleValue == null)
        return null; 
      return (STTrueFalse.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalse xgetDetectmouseclick() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(DETECTMOUSECLICK$42);
      return sTTrueFalse;
    } 
  }
  
  public boolean isSetDetectmouseclick() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DETECTMOUSECLICK$42) != null);
    } 
  }
  
  public void setDetectmouseclick(STTrueFalse.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DETECTMOUSECLICK$42);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DETECTMOUSECLICK$42); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetDetectmouseclick(STTrueFalse paramSTTrueFalse) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(DETECTMOUSECLICK$42);
      if (sTTrueFalse == null)
        sTTrueFalse = (STTrueFalse)get_store().add_attribute_user(DETECTMOUSECLICK$42); 
      sTTrueFalse.set((XmlObject)paramSTTrueFalse);
    } 
  }
  
  public void unsetDetectmouseclick() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DETECTMOUSECLICK$42);
    } 
  }
  
  public String getTitle() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TITLE$44);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetTitle() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(TITLE$44);
      return xmlString;
    } 
  }
  
  public boolean isSetTitle() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(TITLE$44) != null);
    } 
  }
  
  public void setTitle(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TITLE$44);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TITLE$44); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetTitle(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(TITLE$44);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(TITLE$44); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetTitle() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(TITLE$44);
    } 
  }
  
  public String getOpacity2() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(OPACITY2$46);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetOpacity2() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(OPACITY2$46);
      return xmlString;
    } 
  }
  
  public boolean isSetOpacity2() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(OPACITY2$46) != null);
    } 
  }
  
  public void setOpacity2(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(OPACITY2$46);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(OPACITY2$46); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetOpacity2(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(OPACITY2$46);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(OPACITY2$46); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetOpacity2() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(OPACITY2$46);
    } 
  }
  
  public STTrueFalse.Enum getRecolor() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(RECOLOR$48);
      if (simpleValue == null)
        return null; 
      return (STTrueFalse.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalse xgetRecolor() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(RECOLOR$48);
      return sTTrueFalse;
    } 
  }
  
  public boolean isSetRecolor() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(RECOLOR$48) != null);
    } 
  }
  
  public void setRecolor(STTrueFalse.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(RECOLOR$48);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(RECOLOR$48); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetRecolor(STTrueFalse paramSTTrueFalse) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(RECOLOR$48);
      if (sTTrueFalse == null)
        sTTrueFalse = (STTrueFalse)get_store().add_attribute_user(RECOLOR$48); 
      sTTrueFalse.set((XmlObject)paramSTTrueFalse);
    } 
  }
  
  public void unsetRecolor() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(RECOLOR$48);
    } 
  }
  
  public STTrueFalse.Enum getRotate() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ROTATE$50);
      if (simpleValue == null)
        return null; 
      return (STTrueFalse.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalse xgetRotate() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(ROTATE$50);
      return sTTrueFalse;
    } 
  }
  
  public boolean isSetRotate() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ROTATE$50) != null);
    } 
  }
  
  public void setRotate(STTrueFalse.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ROTATE$50);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ROTATE$50); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetRotate(STTrueFalse paramSTTrueFalse) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(ROTATE$50);
      if (sTTrueFalse == null)
        sTTrueFalse = (STTrueFalse)get_store().add_attribute_user(ROTATE$50); 
      sTTrueFalse.set((XmlObject)paramSTTrueFalse);
    } 
  }
  
  public void unsetRotate() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ROTATE$50);
    } 
  }
  
  public String getId2() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID2$52);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STRelationshipId xgetId2() {
    synchronized (monitor()) {
      check_orphaned();
      STRelationshipId sTRelationshipId = null;
      sTRelationshipId = (STRelationshipId)get_store().find_attribute_user(ID2$52);
      return sTRelationshipId;
    } 
  }
  
  public boolean isSetId2() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ID2$52) != null);
    } 
  }
  
  public void setId2(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID2$52);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ID2$52); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetId2(STRelationshipId paramSTRelationshipId) {
    synchronized (monitor()) {
      check_orphaned();
      STRelationshipId sTRelationshipId = null;
      sTRelationshipId = (STRelationshipId)get_store().find_attribute_user(ID2$52);
      if (sTRelationshipId == null)
        sTRelationshipId = (STRelationshipId)get_store().add_attribute_user(ID2$52); 
      sTRelationshipId.set((XmlObject)paramSTRelationshipId);
    } 
  }
  
  public void unsetId2() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ID2$52);
    } 
  }
  
  public String getRelid() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(RELID$54);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STRelationshipId xgetRelid() {
    synchronized (monitor()) {
      check_orphaned();
      STRelationshipId sTRelationshipId = null;
      sTRelationshipId = (STRelationshipId)get_store().find_attribute_user(RELID$54);
      return sTRelationshipId;
    } 
  }
  
  public boolean isSetRelid() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(RELID$54) != null);
    } 
  }
  
  public void setRelid(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(RELID$54);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(RELID$54); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetRelid(STRelationshipId paramSTRelationshipId) {
    synchronized (monitor()) {
      check_orphaned();
      STRelationshipId sTRelationshipId = null;
      sTRelationshipId = (STRelationshipId)get_store().find_attribute_user(RELID$54);
      if (sTRelationshipId == null)
        sTRelationshipId = (STRelationshipId)get_store().add_attribute_user(RELID$54); 
      sTRelationshipId.set((XmlObject)paramSTRelationshipId);
    } 
  }
  
  public void unsetRelid() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(RELID$54);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\vml\impl\CTFillImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */