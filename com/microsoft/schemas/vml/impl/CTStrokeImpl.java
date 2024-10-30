package com.microsoft.schemas.vml.impl;

import com.microsoft.schemas.office.office.CTStrokeChild;
import com.microsoft.schemas.office.office.STRelationshipId;
import com.microsoft.schemas.office.office.STTrueFalse;
import com.microsoft.schemas.vml.CTStroke;
import com.microsoft.schemas.vml.STColorType;
import com.microsoft.schemas.vml.STFillType;
import com.microsoft.schemas.vml.STImageAspect;
import com.microsoft.schemas.vml.STStrokeArrowLength;
import com.microsoft.schemas.vml.STStrokeArrowType;
import com.microsoft.schemas.vml.STStrokeArrowWidth;
import com.microsoft.schemas.vml.STStrokeEndCap;
import com.microsoft.schemas.vml.STStrokeJoinStyle;
import com.microsoft.schemas.vml.STStrokeLineStyle;
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

public class CTStrokeImpl extends XmlComplexContentImpl implements CTStroke {
  private static final b LEFT$0 = new b("urn:schemas-microsoft-com:office:office", "left");
  
  private static final b TOP$2 = new b("urn:schemas-microsoft-com:office:office", "top");
  
  private static final b RIGHT$4 = new b("urn:schemas-microsoft-com:office:office", "right");
  
  private static final b BOTTOM$6 = new b("urn:schemas-microsoft-com:office:office", "bottom");
  
  private static final b COLUMN$8 = new b("urn:schemas-microsoft-com:office:office", "column");
  
  private static final b ID$10 = new b("", "id");
  
  private static final b ON$12 = new b("", "on");
  
  private static final b WEIGHT$14 = new b("", "weight");
  
  private static final b COLOR$16 = new b("", "color");
  
  private static final b OPACITY$18 = new b("", "opacity");
  
  private static final b LINESTYLE$20 = new b("", "linestyle");
  
  private static final b MITERLIMIT$22 = new b("", "miterlimit");
  
  private static final b JOINSTYLE$24 = new b("", "joinstyle");
  
  private static final b ENDCAP$26 = new b("", "endcap");
  
  private static final b DASHSTYLE$28 = new b("", "dashstyle");
  
  private static final b FILLTYPE$30 = new b("", "filltype");
  
  private static final b SRC$32 = new b("", "src");
  
  private static final b IMAGEASPECT$34 = new b("", "imageaspect");
  
  private static final b IMAGESIZE$36 = new b("", "imagesize");
  
  private static final b IMAGEALIGNSHAPE$38 = new b("", "imagealignshape");
  
  private static final b COLOR2$40 = new b("", "color2");
  
  private static final b STARTARROW$42 = new b("", "startarrow");
  
  private static final b STARTARROWWIDTH$44 = new b("", "startarrowwidth");
  
  private static final b STARTARROWLENGTH$46 = new b("", "startarrowlength");
  
  private static final b ENDARROW$48 = new b("", "endarrow");
  
  private static final b ENDARROWWIDTH$50 = new b("", "endarrowwidth");
  
  private static final b ENDARROWLENGTH$52 = new b("", "endarrowlength");
  
  private static final b HREF$54 = new b("urn:schemas-microsoft-com:office:office", "href");
  
  private static final b ALTHREF$56 = new b("urn:schemas-microsoft-com:office:office", "althref");
  
  private static final b TITLE$58 = new b("urn:schemas-microsoft-com:office:office", "title");
  
  private static final b FORCEDASH$60 = new b("urn:schemas-microsoft-com:office:office", "forcedash");
  
  private static final b ID2$62 = new b("http://schemas.openxmlformats.org/officeDocument/2006/relationships", "id");
  
  private static final b INSETPEN$64 = new b("", "insetpen");
  
  private static final b RELID$66 = new b("urn:schemas-microsoft-com:office:office", "relid");
  
  public CTStrokeImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTStrokeChild getLeft() {
    synchronized (monitor()) {
      check_orphaned();
      CTStrokeChild cTStrokeChild = null;
      cTStrokeChild = (CTStrokeChild)get_store().find_element_user(LEFT$0, 0);
      if (cTStrokeChild == null)
        return null; 
      return cTStrokeChild;
    } 
  }
  
  public boolean isSetLeft() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(LEFT$0) != 0);
    } 
  }
  
  public void setLeft(CTStrokeChild paramCTStrokeChild) {
    synchronized (monitor()) {
      check_orphaned();
      CTStrokeChild cTStrokeChild = null;
      cTStrokeChild = (CTStrokeChild)get_store().find_element_user(LEFT$0, 0);
      if (cTStrokeChild == null)
        cTStrokeChild = (CTStrokeChild)get_store().add_element_user(LEFT$0); 
      cTStrokeChild.set((XmlObject)paramCTStrokeChild);
    } 
  }
  
  public CTStrokeChild addNewLeft() {
    synchronized (monitor()) {
      check_orphaned();
      CTStrokeChild cTStrokeChild = null;
      cTStrokeChild = (CTStrokeChild)get_store().add_element_user(LEFT$0);
      return cTStrokeChild;
    } 
  }
  
  public void unsetLeft() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LEFT$0, 0);
    } 
  }
  
  public CTStrokeChild getTop() {
    synchronized (monitor()) {
      check_orphaned();
      CTStrokeChild cTStrokeChild = null;
      cTStrokeChild = (CTStrokeChild)get_store().find_element_user(TOP$2, 0);
      if (cTStrokeChild == null)
        return null; 
      return cTStrokeChild;
    } 
  }
  
  public boolean isSetTop() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TOP$2) != 0);
    } 
  }
  
  public void setTop(CTStrokeChild paramCTStrokeChild) {
    synchronized (monitor()) {
      check_orphaned();
      CTStrokeChild cTStrokeChild = null;
      cTStrokeChild = (CTStrokeChild)get_store().find_element_user(TOP$2, 0);
      if (cTStrokeChild == null)
        cTStrokeChild = (CTStrokeChild)get_store().add_element_user(TOP$2); 
      cTStrokeChild.set((XmlObject)paramCTStrokeChild);
    } 
  }
  
  public CTStrokeChild addNewTop() {
    synchronized (monitor()) {
      check_orphaned();
      CTStrokeChild cTStrokeChild = null;
      cTStrokeChild = (CTStrokeChild)get_store().add_element_user(TOP$2);
      return cTStrokeChild;
    } 
  }
  
  public void unsetTop() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TOP$2, 0);
    } 
  }
  
  public CTStrokeChild getRight() {
    synchronized (monitor()) {
      check_orphaned();
      CTStrokeChild cTStrokeChild = null;
      cTStrokeChild = (CTStrokeChild)get_store().find_element_user(RIGHT$4, 0);
      if (cTStrokeChild == null)
        return null; 
      return cTStrokeChild;
    } 
  }
  
  public boolean isSetRight() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(RIGHT$4) != 0);
    } 
  }
  
  public void setRight(CTStrokeChild paramCTStrokeChild) {
    synchronized (monitor()) {
      check_orphaned();
      CTStrokeChild cTStrokeChild = null;
      cTStrokeChild = (CTStrokeChild)get_store().find_element_user(RIGHT$4, 0);
      if (cTStrokeChild == null)
        cTStrokeChild = (CTStrokeChild)get_store().add_element_user(RIGHT$4); 
      cTStrokeChild.set((XmlObject)paramCTStrokeChild);
    } 
  }
  
  public CTStrokeChild addNewRight() {
    synchronized (monitor()) {
      check_orphaned();
      CTStrokeChild cTStrokeChild = null;
      cTStrokeChild = (CTStrokeChild)get_store().add_element_user(RIGHT$4);
      return cTStrokeChild;
    } 
  }
  
  public void unsetRight() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(RIGHT$4, 0);
    } 
  }
  
  public CTStrokeChild getBottom() {
    synchronized (monitor()) {
      check_orphaned();
      CTStrokeChild cTStrokeChild = null;
      cTStrokeChild = (CTStrokeChild)get_store().find_element_user(BOTTOM$6, 0);
      if (cTStrokeChild == null)
        return null; 
      return cTStrokeChild;
    } 
  }
  
  public boolean isSetBottom() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(BOTTOM$6) != 0);
    } 
  }
  
  public void setBottom(CTStrokeChild paramCTStrokeChild) {
    synchronized (monitor()) {
      check_orphaned();
      CTStrokeChild cTStrokeChild = null;
      cTStrokeChild = (CTStrokeChild)get_store().find_element_user(BOTTOM$6, 0);
      if (cTStrokeChild == null)
        cTStrokeChild = (CTStrokeChild)get_store().add_element_user(BOTTOM$6); 
      cTStrokeChild.set((XmlObject)paramCTStrokeChild);
    } 
  }
  
  public CTStrokeChild addNewBottom() {
    synchronized (monitor()) {
      check_orphaned();
      CTStrokeChild cTStrokeChild = null;
      cTStrokeChild = (CTStrokeChild)get_store().add_element_user(BOTTOM$6);
      return cTStrokeChild;
    } 
  }
  
  public void unsetBottom() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BOTTOM$6, 0);
    } 
  }
  
  public CTStrokeChild getColumn() {
    synchronized (monitor()) {
      check_orphaned();
      CTStrokeChild cTStrokeChild = null;
      cTStrokeChild = (CTStrokeChild)get_store().find_element_user(COLUMN$8, 0);
      if (cTStrokeChild == null)
        return null; 
      return cTStrokeChild;
    } 
  }
  
  public boolean isSetColumn() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(COLUMN$8) != 0);
    } 
  }
  
  public void setColumn(CTStrokeChild paramCTStrokeChild) {
    synchronized (monitor()) {
      check_orphaned();
      CTStrokeChild cTStrokeChild = null;
      cTStrokeChild = (CTStrokeChild)get_store().find_element_user(COLUMN$8, 0);
      if (cTStrokeChild == null)
        cTStrokeChild = (CTStrokeChild)get_store().add_element_user(COLUMN$8); 
      cTStrokeChild.set((XmlObject)paramCTStrokeChild);
    } 
  }
  
  public CTStrokeChild addNewColumn() {
    synchronized (monitor()) {
      check_orphaned();
      CTStrokeChild cTStrokeChild = null;
      cTStrokeChild = (CTStrokeChild)get_store().add_element_user(COLUMN$8);
      return cTStrokeChild;
    } 
  }
  
  public void unsetColumn() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(COLUMN$8, 0);
    } 
  }
  
  public String getId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID$10);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetId() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(ID$10);
      return xmlString;
    } 
  }
  
  public boolean isSetId() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ID$10) != null);
    } 
  }
  
  public void setId(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ID$10); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetId(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(ID$10);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(ID$10); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetId() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ID$10);
    } 
  }
  
  public STTrueFalse.Enum getOn() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ON$12);
      if (simpleValue == null)
        return null; 
      return (STTrueFalse.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalse xgetOn() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(ON$12);
      return sTTrueFalse;
    } 
  }
  
  public boolean isSetOn() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ON$12) != null);
    } 
  }
  
  public void setOn(STTrueFalse.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ON$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ON$12); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetOn(STTrueFalse paramSTTrueFalse) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(ON$12);
      if (sTTrueFalse == null)
        sTTrueFalse = (STTrueFalse)get_store().add_attribute_user(ON$12); 
      sTTrueFalse.set((XmlObject)paramSTTrueFalse);
    } 
  }
  
  public void unsetOn() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ON$12);
    } 
  }
  
  public String getWeight() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(WEIGHT$14);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetWeight() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(WEIGHT$14);
      return xmlString;
    } 
  }
  
  public boolean isSetWeight() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(WEIGHT$14) != null);
    } 
  }
  
  public void setWeight(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(WEIGHT$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(WEIGHT$14); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetWeight(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(WEIGHT$14);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(WEIGHT$14); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetWeight() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(WEIGHT$14);
    } 
  }
  
  public String getColor() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COLOR$16);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STColorType xgetColor() {
    synchronized (monitor()) {
      check_orphaned();
      STColorType sTColorType = null;
      sTColorType = (STColorType)get_store().find_attribute_user(COLOR$16);
      return sTColorType;
    } 
  }
  
  public boolean isSetColor() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(COLOR$16) != null);
    } 
  }
  
  public void setColor(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COLOR$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(COLOR$16); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetColor(STColorType paramSTColorType) {
    synchronized (monitor()) {
      check_orphaned();
      STColorType sTColorType = null;
      sTColorType = (STColorType)get_store().find_attribute_user(COLOR$16);
      if (sTColorType == null)
        sTColorType = (STColorType)get_store().add_attribute_user(COLOR$16); 
      sTColorType.set((XmlObject)paramSTColorType);
    } 
  }
  
  public void unsetColor() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(COLOR$16);
    } 
  }
  
  public String getOpacity() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(OPACITY$18);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetOpacity() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(OPACITY$18);
      return xmlString;
    } 
  }
  
  public boolean isSetOpacity() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(OPACITY$18) != null);
    } 
  }
  
  public void setOpacity(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(OPACITY$18);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(OPACITY$18); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetOpacity(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(OPACITY$18);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(OPACITY$18); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetOpacity() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(OPACITY$18);
    } 
  }
  
  public STStrokeLineStyle.Enum getLinestyle() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(LINESTYLE$20);
      if (simpleValue == null)
        return null; 
      return (STStrokeLineStyle.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STStrokeLineStyle xgetLinestyle() {
    synchronized (monitor()) {
      check_orphaned();
      STStrokeLineStyle sTStrokeLineStyle = null;
      sTStrokeLineStyle = (STStrokeLineStyle)get_store().find_attribute_user(LINESTYLE$20);
      return sTStrokeLineStyle;
    } 
  }
  
  public boolean isSetLinestyle() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(LINESTYLE$20) != null);
    } 
  }
  
  public void setLinestyle(STStrokeLineStyle.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(LINESTYLE$20);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(LINESTYLE$20); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetLinestyle(STStrokeLineStyle paramSTStrokeLineStyle) {
    synchronized (monitor()) {
      check_orphaned();
      STStrokeLineStyle sTStrokeLineStyle = null;
      sTStrokeLineStyle = (STStrokeLineStyle)get_store().find_attribute_user(LINESTYLE$20);
      if (sTStrokeLineStyle == null)
        sTStrokeLineStyle = (STStrokeLineStyle)get_store().add_attribute_user(LINESTYLE$20); 
      sTStrokeLineStyle.set((XmlObject)paramSTStrokeLineStyle);
    } 
  }
  
  public void unsetLinestyle() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(LINESTYLE$20);
    } 
  }
  
  public BigDecimal getMiterlimit() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MITERLIMIT$22);
      if (simpleValue == null)
        return null; 
      return simpleValue.getBigDecimalValue();
    } 
  }
  
  public XmlDecimal xgetMiterlimit() {
    synchronized (monitor()) {
      check_orphaned();
      XmlDecimal xmlDecimal = null;
      xmlDecimal = (XmlDecimal)get_store().find_attribute_user(MITERLIMIT$22);
      return xmlDecimal;
    } 
  }
  
  public boolean isSetMiterlimit() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(MITERLIMIT$22) != null);
    } 
  }
  
  public void setMiterlimit(BigDecimal paramBigDecimal) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MITERLIMIT$22);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(MITERLIMIT$22); 
      simpleValue.setBigDecimalValue(paramBigDecimal);
    } 
  }
  
  public void xsetMiterlimit(XmlDecimal paramXmlDecimal) {
    synchronized (monitor()) {
      check_orphaned();
      XmlDecimal xmlDecimal = null;
      xmlDecimal = (XmlDecimal)get_store().find_attribute_user(MITERLIMIT$22);
      if (xmlDecimal == null)
        xmlDecimal = (XmlDecimal)get_store().add_attribute_user(MITERLIMIT$22); 
      xmlDecimal.set((XmlObject)paramXmlDecimal);
    } 
  }
  
  public void unsetMiterlimit() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(MITERLIMIT$22);
    } 
  }
  
  public STStrokeJoinStyle.Enum getJoinstyle() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(JOINSTYLE$24);
      if (simpleValue == null)
        return null; 
      return (STStrokeJoinStyle.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STStrokeJoinStyle xgetJoinstyle() {
    synchronized (monitor()) {
      check_orphaned();
      STStrokeJoinStyle sTStrokeJoinStyle = null;
      sTStrokeJoinStyle = (STStrokeJoinStyle)get_store().find_attribute_user(JOINSTYLE$24);
      return sTStrokeJoinStyle;
    } 
  }
  
  public boolean isSetJoinstyle() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(JOINSTYLE$24) != null);
    } 
  }
  
  public void setJoinstyle(STStrokeJoinStyle.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(JOINSTYLE$24);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(JOINSTYLE$24); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetJoinstyle(STStrokeJoinStyle paramSTStrokeJoinStyle) {
    synchronized (monitor()) {
      check_orphaned();
      STStrokeJoinStyle sTStrokeJoinStyle = null;
      sTStrokeJoinStyle = (STStrokeJoinStyle)get_store().find_attribute_user(JOINSTYLE$24);
      if (sTStrokeJoinStyle == null)
        sTStrokeJoinStyle = (STStrokeJoinStyle)get_store().add_attribute_user(JOINSTYLE$24); 
      sTStrokeJoinStyle.set((XmlObject)paramSTStrokeJoinStyle);
    } 
  }
  
  public void unsetJoinstyle() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(JOINSTYLE$24);
    } 
  }
  
  public STStrokeEndCap.Enum getEndcap() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ENDCAP$26);
      if (simpleValue == null)
        return null; 
      return (STStrokeEndCap.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STStrokeEndCap xgetEndcap() {
    synchronized (monitor()) {
      check_orphaned();
      STStrokeEndCap sTStrokeEndCap = null;
      sTStrokeEndCap = (STStrokeEndCap)get_store().find_attribute_user(ENDCAP$26);
      return sTStrokeEndCap;
    } 
  }
  
  public boolean isSetEndcap() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ENDCAP$26) != null);
    } 
  }
  
  public void setEndcap(STStrokeEndCap.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ENDCAP$26);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ENDCAP$26); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetEndcap(STStrokeEndCap paramSTStrokeEndCap) {
    synchronized (monitor()) {
      check_orphaned();
      STStrokeEndCap sTStrokeEndCap = null;
      sTStrokeEndCap = (STStrokeEndCap)get_store().find_attribute_user(ENDCAP$26);
      if (sTStrokeEndCap == null)
        sTStrokeEndCap = (STStrokeEndCap)get_store().add_attribute_user(ENDCAP$26); 
      sTStrokeEndCap.set((XmlObject)paramSTStrokeEndCap);
    } 
  }
  
  public void unsetEndcap() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ENDCAP$26);
    } 
  }
  
  public String getDashstyle() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DASHSTYLE$28);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetDashstyle() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(DASHSTYLE$28);
      return xmlString;
    } 
  }
  
  public boolean isSetDashstyle() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DASHSTYLE$28) != null);
    } 
  }
  
  public void setDashstyle(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DASHSTYLE$28);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DASHSTYLE$28); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetDashstyle(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(DASHSTYLE$28);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(DASHSTYLE$28); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetDashstyle() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DASHSTYLE$28);
    } 
  }
  
  public STFillType.Enum getFilltype() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FILLTYPE$30);
      if (simpleValue == null)
        return null; 
      return (STFillType.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STFillType xgetFilltype() {
    synchronized (monitor()) {
      check_orphaned();
      STFillType sTFillType = null;
      sTFillType = (STFillType)get_store().find_attribute_user(FILLTYPE$30);
      return sTFillType;
    } 
  }
  
  public boolean isSetFilltype() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(FILLTYPE$30) != null);
    } 
  }
  
  public void setFilltype(STFillType.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FILLTYPE$30);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FILLTYPE$30); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetFilltype(STFillType paramSTFillType) {
    synchronized (monitor()) {
      check_orphaned();
      STFillType sTFillType = null;
      sTFillType = (STFillType)get_store().find_attribute_user(FILLTYPE$30);
      if (sTFillType == null)
        sTFillType = (STFillType)get_store().add_attribute_user(FILLTYPE$30); 
      sTFillType.set((XmlObject)paramSTFillType);
    } 
  }
  
  public void unsetFilltype() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(FILLTYPE$30);
    } 
  }
  
  public String getSrc() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SRC$32);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetSrc() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(SRC$32);
      return xmlString;
    } 
  }
  
  public boolean isSetSrc() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SRC$32) != null);
    } 
  }
  
  public void setSrc(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SRC$32);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SRC$32); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetSrc(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(SRC$32);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(SRC$32); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetSrc() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SRC$32);
    } 
  }
  
  public STImageAspect.Enum getImageaspect() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(IMAGEASPECT$34);
      if (simpleValue == null)
        return null; 
      return (STImageAspect.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STImageAspect xgetImageaspect() {
    synchronized (monitor()) {
      check_orphaned();
      STImageAspect sTImageAspect = null;
      sTImageAspect = (STImageAspect)get_store().find_attribute_user(IMAGEASPECT$34);
      return sTImageAspect;
    } 
  }
  
  public boolean isSetImageaspect() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(IMAGEASPECT$34) != null);
    } 
  }
  
  public void setImageaspect(STImageAspect.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(IMAGEASPECT$34);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(IMAGEASPECT$34); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetImageaspect(STImageAspect paramSTImageAspect) {
    synchronized (monitor()) {
      check_orphaned();
      STImageAspect sTImageAspect = null;
      sTImageAspect = (STImageAspect)get_store().find_attribute_user(IMAGEASPECT$34);
      if (sTImageAspect == null)
        sTImageAspect = (STImageAspect)get_store().add_attribute_user(IMAGEASPECT$34); 
      sTImageAspect.set((XmlObject)paramSTImageAspect);
    } 
  }
  
  public void unsetImageaspect() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(IMAGEASPECT$34);
    } 
  }
  
  public String getImagesize() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(IMAGESIZE$36);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetImagesize() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(IMAGESIZE$36);
      return xmlString;
    } 
  }
  
  public boolean isSetImagesize() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(IMAGESIZE$36) != null);
    } 
  }
  
  public void setImagesize(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(IMAGESIZE$36);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(IMAGESIZE$36); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetImagesize(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(IMAGESIZE$36);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(IMAGESIZE$36); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetImagesize() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(IMAGESIZE$36);
    } 
  }
  
  public STTrueFalse.Enum getImagealignshape() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(IMAGEALIGNSHAPE$38);
      if (simpleValue == null)
        return null; 
      return (STTrueFalse.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalse xgetImagealignshape() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(IMAGEALIGNSHAPE$38);
      return sTTrueFalse;
    } 
  }
  
  public boolean isSetImagealignshape() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(IMAGEALIGNSHAPE$38) != null);
    } 
  }
  
  public void setImagealignshape(STTrueFalse.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(IMAGEALIGNSHAPE$38);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(IMAGEALIGNSHAPE$38); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetImagealignshape(STTrueFalse paramSTTrueFalse) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(IMAGEALIGNSHAPE$38);
      if (sTTrueFalse == null)
        sTTrueFalse = (STTrueFalse)get_store().add_attribute_user(IMAGEALIGNSHAPE$38); 
      sTTrueFalse.set((XmlObject)paramSTTrueFalse);
    } 
  }
  
  public void unsetImagealignshape() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(IMAGEALIGNSHAPE$38);
    } 
  }
  
  public String getColor2() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COLOR2$40);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STColorType xgetColor2() {
    synchronized (monitor()) {
      check_orphaned();
      STColorType sTColorType = null;
      sTColorType = (STColorType)get_store().find_attribute_user(COLOR2$40);
      return sTColorType;
    } 
  }
  
  public boolean isSetColor2() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(COLOR2$40) != null);
    } 
  }
  
  public void setColor2(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COLOR2$40);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(COLOR2$40); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetColor2(STColorType paramSTColorType) {
    synchronized (monitor()) {
      check_orphaned();
      STColorType sTColorType = null;
      sTColorType = (STColorType)get_store().find_attribute_user(COLOR2$40);
      if (sTColorType == null)
        sTColorType = (STColorType)get_store().add_attribute_user(COLOR2$40); 
      sTColorType.set((XmlObject)paramSTColorType);
    } 
  }
  
  public void unsetColor2() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(COLOR2$40);
    } 
  }
  
  public STStrokeArrowType.Enum getStartarrow() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(STARTARROW$42);
      if (simpleValue == null)
        return null; 
      return (STStrokeArrowType.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STStrokeArrowType xgetStartarrow() {
    synchronized (monitor()) {
      check_orphaned();
      STStrokeArrowType sTStrokeArrowType = null;
      sTStrokeArrowType = (STStrokeArrowType)get_store().find_attribute_user(STARTARROW$42);
      return sTStrokeArrowType;
    } 
  }
  
  public boolean isSetStartarrow() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(STARTARROW$42) != null);
    } 
  }
  
  public void setStartarrow(STStrokeArrowType.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(STARTARROW$42);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(STARTARROW$42); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetStartarrow(STStrokeArrowType paramSTStrokeArrowType) {
    synchronized (monitor()) {
      check_orphaned();
      STStrokeArrowType sTStrokeArrowType = null;
      sTStrokeArrowType = (STStrokeArrowType)get_store().find_attribute_user(STARTARROW$42);
      if (sTStrokeArrowType == null)
        sTStrokeArrowType = (STStrokeArrowType)get_store().add_attribute_user(STARTARROW$42); 
      sTStrokeArrowType.set((XmlObject)paramSTStrokeArrowType);
    } 
  }
  
  public void unsetStartarrow() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(STARTARROW$42);
    } 
  }
  
  public STStrokeArrowWidth.Enum getStartarrowwidth() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(STARTARROWWIDTH$44);
      if (simpleValue == null)
        return null; 
      return (STStrokeArrowWidth.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STStrokeArrowWidth xgetStartarrowwidth() {
    synchronized (monitor()) {
      check_orphaned();
      STStrokeArrowWidth sTStrokeArrowWidth = null;
      sTStrokeArrowWidth = (STStrokeArrowWidth)get_store().find_attribute_user(STARTARROWWIDTH$44);
      return sTStrokeArrowWidth;
    } 
  }
  
  public boolean isSetStartarrowwidth() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(STARTARROWWIDTH$44) != null);
    } 
  }
  
  public void setStartarrowwidth(STStrokeArrowWidth.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(STARTARROWWIDTH$44);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(STARTARROWWIDTH$44); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetStartarrowwidth(STStrokeArrowWidth paramSTStrokeArrowWidth) {
    synchronized (monitor()) {
      check_orphaned();
      STStrokeArrowWidth sTStrokeArrowWidth = null;
      sTStrokeArrowWidth = (STStrokeArrowWidth)get_store().find_attribute_user(STARTARROWWIDTH$44);
      if (sTStrokeArrowWidth == null)
        sTStrokeArrowWidth = (STStrokeArrowWidth)get_store().add_attribute_user(STARTARROWWIDTH$44); 
      sTStrokeArrowWidth.set((XmlObject)paramSTStrokeArrowWidth);
    } 
  }
  
  public void unsetStartarrowwidth() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(STARTARROWWIDTH$44);
    } 
  }
  
  public STStrokeArrowLength.Enum getStartarrowlength() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(STARTARROWLENGTH$46);
      if (simpleValue == null)
        return null; 
      return (STStrokeArrowLength.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STStrokeArrowLength xgetStartarrowlength() {
    synchronized (monitor()) {
      check_orphaned();
      STStrokeArrowLength sTStrokeArrowLength = null;
      sTStrokeArrowLength = (STStrokeArrowLength)get_store().find_attribute_user(STARTARROWLENGTH$46);
      return sTStrokeArrowLength;
    } 
  }
  
  public boolean isSetStartarrowlength() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(STARTARROWLENGTH$46) != null);
    } 
  }
  
  public void setStartarrowlength(STStrokeArrowLength.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(STARTARROWLENGTH$46);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(STARTARROWLENGTH$46); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetStartarrowlength(STStrokeArrowLength paramSTStrokeArrowLength) {
    synchronized (monitor()) {
      check_orphaned();
      STStrokeArrowLength sTStrokeArrowLength = null;
      sTStrokeArrowLength = (STStrokeArrowLength)get_store().find_attribute_user(STARTARROWLENGTH$46);
      if (sTStrokeArrowLength == null)
        sTStrokeArrowLength = (STStrokeArrowLength)get_store().add_attribute_user(STARTARROWLENGTH$46); 
      sTStrokeArrowLength.set((XmlObject)paramSTStrokeArrowLength);
    } 
  }
  
  public void unsetStartarrowlength() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(STARTARROWLENGTH$46);
    } 
  }
  
  public STStrokeArrowType.Enum getEndarrow() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ENDARROW$48);
      if (simpleValue == null)
        return null; 
      return (STStrokeArrowType.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STStrokeArrowType xgetEndarrow() {
    synchronized (monitor()) {
      check_orphaned();
      STStrokeArrowType sTStrokeArrowType = null;
      sTStrokeArrowType = (STStrokeArrowType)get_store().find_attribute_user(ENDARROW$48);
      return sTStrokeArrowType;
    } 
  }
  
  public boolean isSetEndarrow() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ENDARROW$48) != null);
    } 
  }
  
  public void setEndarrow(STStrokeArrowType.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ENDARROW$48);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ENDARROW$48); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetEndarrow(STStrokeArrowType paramSTStrokeArrowType) {
    synchronized (monitor()) {
      check_orphaned();
      STStrokeArrowType sTStrokeArrowType = null;
      sTStrokeArrowType = (STStrokeArrowType)get_store().find_attribute_user(ENDARROW$48);
      if (sTStrokeArrowType == null)
        sTStrokeArrowType = (STStrokeArrowType)get_store().add_attribute_user(ENDARROW$48); 
      sTStrokeArrowType.set((XmlObject)paramSTStrokeArrowType);
    } 
  }
  
  public void unsetEndarrow() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ENDARROW$48);
    } 
  }
  
  public STStrokeArrowWidth.Enum getEndarrowwidth() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ENDARROWWIDTH$50);
      if (simpleValue == null)
        return null; 
      return (STStrokeArrowWidth.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STStrokeArrowWidth xgetEndarrowwidth() {
    synchronized (monitor()) {
      check_orphaned();
      STStrokeArrowWidth sTStrokeArrowWidth = null;
      sTStrokeArrowWidth = (STStrokeArrowWidth)get_store().find_attribute_user(ENDARROWWIDTH$50);
      return sTStrokeArrowWidth;
    } 
  }
  
  public boolean isSetEndarrowwidth() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ENDARROWWIDTH$50) != null);
    } 
  }
  
  public void setEndarrowwidth(STStrokeArrowWidth.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ENDARROWWIDTH$50);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ENDARROWWIDTH$50); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetEndarrowwidth(STStrokeArrowWidth paramSTStrokeArrowWidth) {
    synchronized (monitor()) {
      check_orphaned();
      STStrokeArrowWidth sTStrokeArrowWidth = null;
      sTStrokeArrowWidth = (STStrokeArrowWidth)get_store().find_attribute_user(ENDARROWWIDTH$50);
      if (sTStrokeArrowWidth == null)
        sTStrokeArrowWidth = (STStrokeArrowWidth)get_store().add_attribute_user(ENDARROWWIDTH$50); 
      sTStrokeArrowWidth.set((XmlObject)paramSTStrokeArrowWidth);
    } 
  }
  
  public void unsetEndarrowwidth() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ENDARROWWIDTH$50);
    } 
  }
  
  public STStrokeArrowLength.Enum getEndarrowlength() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ENDARROWLENGTH$52);
      if (simpleValue == null)
        return null; 
      return (STStrokeArrowLength.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STStrokeArrowLength xgetEndarrowlength() {
    synchronized (monitor()) {
      check_orphaned();
      STStrokeArrowLength sTStrokeArrowLength = null;
      sTStrokeArrowLength = (STStrokeArrowLength)get_store().find_attribute_user(ENDARROWLENGTH$52);
      return sTStrokeArrowLength;
    } 
  }
  
  public boolean isSetEndarrowlength() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ENDARROWLENGTH$52) != null);
    } 
  }
  
  public void setEndarrowlength(STStrokeArrowLength.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ENDARROWLENGTH$52);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ENDARROWLENGTH$52); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetEndarrowlength(STStrokeArrowLength paramSTStrokeArrowLength) {
    synchronized (monitor()) {
      check_orphaned();
      STStrokeArrowLength sTStrokeArrowLength = null;
      sTStrokeArrowLength = (STStrokeArrowLength)get_store().find_attribute_user(ENDARROWLENGTH$52);
      if (sTStrokeArrowLength == null)
        sTStrokeArrowLength = (STStrokeArrowLength)get_store().add_attribute_user(ENDARROWLENGTH$52); 
      sTStrokeArrowLength.set((XmlObject)paramSTStrokeArrowLength);
    } 
  }
  
  public void unsetEndarrowlength() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ENDARROWLENGTH$52);
    } 
  }
  
  public String getHref() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HREF$54);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetHref() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(HREF$54);
      return xmlString;
    } 
  }
  
  public boolean isSetHref() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(HREF$54) != null);
    } 
  }
  
  public void setHref(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HREF$54);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(HREF$54); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetHref(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(HREF$54);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(HREF$54); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetHref() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(HREF$54);
    } 
  }
  
  public String getAlthref() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ALTHREF$56);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetAlthref() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(ALTHREF$56);
      return xmlString;
    } 
  }
  
  public boolean isSetAlthref() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ALTHREF$56) != null);
    } 
  }
  
  public void setAlthref(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ALTHREF$56);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ALTHREF$56); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetAlthref(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(ALTHREF$56);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(ALTHREF$56); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetAlthref() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ALTHREF$56);
    } 
  }
  
  public String getTitle() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TITLE$58);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetTitle() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(TITLE$58);
      return xmlString;
    } 
  }
  
  public boolean isSetTitle() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(TITLE$58) != null);
    } 
  }
  
  public void setTitle(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TITLE$58);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TITLE$58); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetTitle(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(TITLE$58);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(TITLE$58); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetTitle() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(TITLE$58);
    } 
  }
  
  public STTrueFalse.Enum getForcedash() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FORCEDASH$60);
      if (simpleValue == null)
        return null; 
      return (STTrueFalse.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalse xgetForcedash() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(FORCEDASH$60);
      return sTTrueFalse;
    } 
  }
  
  public boolean isSetForcedash() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(FORCEDASH$60) != null);
    } 
  }
  
  public void setForcedash(STTrueFalse.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FORCEDASH$60);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FORCEDASH$60); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetForcedash(STTrueFalse paramSTTrueFalse) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(FORCEDASH$60);
      if (sTTrueFalse == null)
        sTTrueFalse = (STTrueFalse)get_store().add_attribute_user(FORCEDASH$60); 
      sTTrueFalse.set((XmlObject)paramSTTrueFalse);
    } 
  }
  
  public void unsetForcedash() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(FORCEDASH$60);
    } 
  }
  
  public String getId2() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID2$62);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STRelationshipId xgetId2() {
    synchronized (monitor()) {
      check_orphaned();
      STRelationshipId sTRelationshipId = null;
      sTRelationshipId = (STRelationshipId)get_store().find_attribute_user(ID2$62);
      return sTRelationshipId;
    } 
  }
  
  public boolean isSetId2() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ID2$62) != null);
    } 
  }
  
  public void setId2(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID2$62);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ID2$62); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetId2(STRelationshipId paramSTRelationshipId) {
    synchronized (monitor()) {
      check_orphaned();
      STRelationshipId sTRelationshipId = null;
      sTRelationshipId = (STRelationshipId)get_store().find_attribute_user(ID2$62);
      if (sTRelationshipId == null)
        sTRelationshipId = (STRelationshipId)get_store().add_attribute_user(ID2$62); 
      sTRelationshipId.set((XmlObject)paramSTRelationshipId);
    } 
  }
  
  public void unsetId2() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ID2$62);
    } 
  }
  
  public STTrueFalse.Enum getInsetpen() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(INSETPEN$64);
      if (simpleValue == null)
        return null; 
      return (STTrueFalse.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalse xgetInsetpen() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(INSETPEN$64);
      return sTTrueFalse;
    } 
  }
  
  public boolean isSetInsetpen() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(INSETPEN$64) != null);
    } 
  }
  
  public void setInsetpen(STTrueFalse.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(INSETPEN$64);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(INSETPEN$64); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetInsetpen(STTrueFalse paramSTTrueFalse) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(INSETPEN$64);
      if (sTTrueFalse == null)
        sTTrueFalse = (STTrueFalse)get_store().add_attribute_user(INSETPEN$64); 
      sTTrueFalse.set((XmlObject)paramSTTrueFalse);
    } 
  }
  
  public void unsetInsetpen() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(INSETPEN$64);
    } 
  }
  
  public String getRelid() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(RELID$66);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STRelationshipId xgetRelid() {
    synchronized (monitor()) {
      check_orphaned();
      STRelationshipId sTRelationshipId = null;
      sTRelationshipId = (STRelationshipId)get_store().find_attribute_user(RELID$66);
      return sTRelationshipId;
    } 
  }
  
  public boolean isSetRelid() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(RELID$66) != null);
    } 
  }
  
  public void setRelid(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(RELID$66);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(RELID$66); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetRelid(STRelationshipId paramSTRelationshipId) {
    synchronized (monitor()) {
      check_orphaned();
      STRelationshipId sTRelationshipId = null;
      sTRelationshipId = (STRelationshipId)get_store().find_attribute_user(RELID$66);
      if (sTRelationshipId == null)
        sTRelationshipId = (STRelationshipId)get_store().add_attribute_user(RELID$66); 
      sTRelationshipId.set((XmlObject)paramSTRelationshipId);
    } 
  }
  
  public void unsetRelid() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(RELID$66);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\vml\impl\CTStrokeImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */