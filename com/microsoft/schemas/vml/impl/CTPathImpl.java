package com.microsoft.schemas.vml.impl;

import com.microsoft.schemas.office.office.STConnectType;
import com.microsoft.schemas.office.office.STTrueFalse;
import com.microsoft.schemas.vml.CTPath;
import com.microsoft.schemas.vml.STTrueFalse;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

public class CTPathImpl extends XmlComplexContentImpl implements CTPath {
  private static final b ID$0 = new b("", "id");
  
  private static final b V$2 = new b("", "v");
  
  private static final b LIMO$4 = new b("", "limo");
  
  private static final b TEXTBOXRECT$6 = new b("", "textboxrect");
  
  private static final b FILLOK$8 = new b("", "fillok");
  
  private static final b STROKEOK$10 = new b("", "strokeok");
  
  private static final b SHADOWOK$12 = new b("", "shadowok");
  
  private static final b ARROWOK$14 = new b("", "arrowok");
  
  private static final b GRADIENTSHAPEOK$16 = new b("", "gradientshapeok");
  
  private static final b TEXTPATHOK$18 = new b("", "textpathok");
  
  private static final b INSETPENOK$20 = new b("", "insetpenok");
  
  private static final b CONNECTTYPE$22 = new b("urn:schemas-microsoft-com:office:office", "connecttype");
  
  private static final b CONNECTLOCS$24 = new b("urn:schemas-microsoft-com:office:office", "connectlocs");
  
  private static final b CONNECTANGLES$26 = new b("urn:schemas-microsoft-com:office:office", "connectangles");
  
  private static final b EXTRUSIONOK$28 = new b("urn:schemas-microsoft-com:office:office", "extrusionok");
  
  public CTPathImpl(SchemaType paramSchemaType) {
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
  
  public String getV() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(V$2);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetV() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(V$2);
      return xmlString;
    } 
  }
  
  public boolean isSetV() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(V$2) != null);
    } 
  }
  
  public void setV(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(V$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(V$2); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetV(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(V$2);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(V$2); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetV() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(V$2);
    } 
  }
  
  public String getLimo() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(LIMO$4);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetLimo() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(LIMO$4);
      return xmlString;
    } 
  }
  
  public boolean isSetLimo() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(LIMO$4) != null);
    } 
  }
  
  public void setLimo(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(LIMO$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(LIMO$4); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetLimo(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(LIMO$4);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(LIMO$4); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetLimo() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(LIMO$4);
    } 
  }
  
  public String getTextboxrect() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TEXTBOXRECT$6);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetTextboxrect() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(TEXTBOXRECT$6);
      return xmlString;
    } 
  }
  
  public boolean isSetTextboxrect() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(TEXTBOXRECT$6) != null);
    } 
  }
  
  public void setTextboxrect(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TEXTBOXRECT$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TEXTBOXRECT$6); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetTextboxrect(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(TEXTBOXRECT$6);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(TEXTBOXRECT$6); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetTextboxrect() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(TEXTBOXRECT$6);
    } 
  }
  
  public STTrueFalse.Enum getFillok() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FILLOK$8);
      if (simpleValue == null)
        return null; 
      return (STTrueFalse.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalse xgetFillok() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(FILLOK$8);
      return sTTrueFalse;
    } 
  }
  
  public boolean isSetFillok() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(FILLOK$8) != null);
    } 
  }
  
  public void setFillok(STTrueFalse.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FILLOK$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FILLOK$8); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetFillok(STTrueFalse paramSTTrueFalse) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(FILLOK$8);
      if (sTTrueFalse == null)
        sTTrueFalse = (STTrueFalse)get_store().add_attribute_user(FILLOK$8); 
      sTTrueFalse.set((XmlObject)paramSTTrueFalse);
    } 
  }
  
  public void unsetFillok() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(FILLOK$8);
    } 
  }
  
  public STTrueFalse.Enum getStrokeok() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(STROKEOK$10);
      if (simpleValue == null)
        return null; 
      return (STTrueFalse.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalse xgetStrokeok() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(STROKEOK$10);
      return sTTrueFalse;
    } 
  }
  
  public boolean isSetStrokeok() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(STROKEOK$10) != null);
    } 
  }
  
  public void setStrokeok(STTrueFalse.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(STROKEOK$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(STROKEOK$10); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetStrokeok(STTrueFalse paramSTTrueFalse) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(STROKEOK$10);
      if (sTTrueFalse == null)
        sTTrueFalse = (STTrueFalse)get_store().add_attribute_user(STROKEOK$10); 
      sTTrueFalse.set((XmlObject)paramSTTrueFalse);
    } 
  }
  
  public void unsetStrokeok() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(STROKEOK$10);
    } 
  }
  
  public STTrueFalse.Enum getShadowok() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHADOWOK$12);
      if (simpleValue == null)
        return null; 
      return (STTrueFalse.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalse xgetShadowok() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(SHADOWOK$12);
      return sTTrueFalse;
    } 
  }
  
  public boolean isSetShadowok() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SHADOWOK$12) != null);
    } 
  }
  
  public void setShadowok(STTrueFalse.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHADOWOK$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SHADOWOK$12); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetShadowok(STTrueFalse paramSTTrueFalse) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(SHADOWOK$12);
      if (sTTrueFalse == null)
        sTTrueFalse = (STTrueFalse)get_store().add_attribute_user(SHADOWOK$12); 
      sTTrueFalse.set((XmlObject)paramSTTrueFalse);
    } 
  }
  
  public void unsetShadowok() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SHADOWOK$12);
    } 
  }
  
  public STTrueFalse.Enum getArrowok() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ARROWOK$14);
      if (simpleValue == null)
        return null; 
      return (STTrueFalse.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalse xgetArrowok() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(ARROWOK$14);
      return sTTrueFalse;
    } 
  }
  
  public boolean isSetArrowok() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ARROWOK$14) != null);
    } 
  }
  
  public void setArrowok(STTrueFalse.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ARROWOK$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ARROWOK$14); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetArrowok(STTrueFalse paramSTTrueFalse) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(ARROWOK$14);
      if (sTTrueFalse == null)
        sTTrueFalse = (STTrueFalse)get_store().add_attribute_user(ARROWOK$14); 
      sTTrueFalse.set((XmlObject)paramSTTrueFalse);
    } 
  }
  
  public void unsetArrowok() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ARROWOK$14);
    } 
  }
  
  public STTrueFalse.Enum getGradientshapeok() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(GRADIENTSHAPEOK$16);
      if (simpleValue == null)
        return null; 
      return (STTrueFalse.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalse xgetGradientshapeok() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(GRADIENTSHAPEOK$16);
      return sTTrueFalse;
    } 
  }
  
  public boolean isSetGradientshapeok() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(GRADIENTSHAPEOK$16) != null);
    } 
  }
  
  public void setGradientshapeok(STTrueFalse.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(GRADIENTSHAPEOK$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(GRADIENTSHAPEOK$16); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetGradientshapeok(STTrueFalse paramSTTrueFalse) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(GRADIENTSHAPEOK$16);
      if (sTTrueFalse == null)
        sTTrueFalse = (STTrueFalse)get_store().add_attribute_user(GRADIENTSHAPEOK$16); 
      sTTrueFalse.set((XmlObject)paramSTTrueFalse);
    } 
  }
  
  public void unsetGradientshapeok() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(GRADIENTSHAPEOK$16);
    } 
  }
  
  public STTrueFalse.Enum getTextpathok() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TEXTPATHOK$18);
      if (simpleValue == null)
        return null; 
      return (STTrueFalse.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalse xgetTextpathok() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(TEXTPATHOK$18);
      return sTTrueFalse;
    } 
  }
  
  public boolean isSetTextpathok() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(TEXTPATHOK$18) != null);
    } 
  }
  
  public void setTextpathok(STTrueFalse.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TEXTPATHOK$18);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TEXTPATHOK$18); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetTextpathok(STTrueFalse paramSTTrueFalse) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(TEXTPATHOK$18);
      if (sTTrueFalse == null)
        sTTrueFalse = (STTrueFalse)get_store().add_attribute_user(TEXTPATHOK$18); 
      sTTrueFalse.set((XmlObject)paramSTTrueFalse);
    } 
  }
  
  public void unsetTextpathok() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(TEXTPATHOK$18);
    } 
  }
  
  public STTrueFalse.Enum getInsetpenok() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(INSETPENOK$20);
      if (simpleValue == null)
        return null; 
      return (STTrueFalse.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalse xgetInsetpenok() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(INSETPENOK$20);
      return sTTrueFalse;
    } 
  }
  
  public boolean isSetInsetpenok() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(INSETPENOK$20) != null);
    } 
  }
  
  public void setInsetpenok(STTrueFalse.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(INSETPENOK$20);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(INSETPENOK$20); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetInsetpenok(STTrueFalse paramSTTrueFalse) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(INSETPENOK$20);
      if (sTTrueFalse == null)
        sTTrueFalse = (STTrueFalse)get_store().add_attribute_user(INSETPENOK$20); 
      sTTrueFalse.set((XmlObject)paramSTTrueFalse);
    } 
  }
  
  public void unsetInsetpenok() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(INSETPENOK$20);
    } 
  }
  
  public STConnectType.Enum getConnecttype() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CONNECTTYPE$22);
      if (simpleValue == null)
        return null; 
      return (STConnectType.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STConnectType xgetConnecttype() {
    synchronized (monitor()) {
      check_orphaned();
      STConnectType sTConnectType = null;
      sTConnectType = (STConnectType)get_store().find_attribute_user(CONNECTTYPE$22);
      return sTConnectType;
    } 
  }
  
  public boolean isSetConnecttype() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(CONNECTTYPE$22) != null);
    } 
  }
  
  public void setConnecttype(STConnectType.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CONNECTTYPE$22);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CONNECTTYPE$22); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetConnecttype(STConnectType paramSTConnectType) {
    synchronized (monitor()) {
      check_orphaned();
      STConnectType sTConnectType = null;
      sTConnectType = (STConnectType)get_store().find_attribute_user(CONNECTTYPE$22);
      if (sTConnectType == null)
        sTConnectType = (STConnectType)get_store().add_attribute_user(CONNECTTYPE$22); 
      sTConnectType.set((XmlObject)paramSTConnectType);
    } 
  }
  
  public void unsetConnecttype() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(CONNECTTYPE$22);
    } 
  }
  
  public String getConnectlocs() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CONNECTLOCS$24);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetConnectlocs() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(CONNECTLOCS$24);
      return xmlString;
    } 
  }
  
  public boolean isSetConnectlocs() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(CONNECTLOCS$24) != null);
    } 
  }
  
  public void setConnectlocs(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CONNECTLOCS$24);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CONNECTLOCS$24); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetConnectlocs(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(CONNECTLOCS$24);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(CONNECTLOCS$24); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetConnectlocs() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(CONNECTLOCS$24);
    } 
  }
  
  public String getConnectangles() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CONNECTANGLES$26);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetConnectangles() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(CONNECTANGLES$26);
      return xmlString;
    } 
  }
  
  public boolean isSetConnectangles() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(CONNECTANGLES$26) != null);
    } 
  }
  
  public void setConnectangles(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CONNECTANGLES$26);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CONNECTANGLES$26); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetConnectangles(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(CONNECTANGLES$26);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(CONNECTANGLES$26); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetConnectangles() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(CONNECTANGLES$26);
    } 
  }
  
  public STTrueFalse.Enum getExtrusionok() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(EXTRUSIONOK$28);
      if (simpleValue == null)
        return null; 
      return (STTrueFalse.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalse xgetExtrusionok() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(EXTRUSIONOK$28);
      return sTTrueFalse;
    } 
  }
  
  public boolean isSetExtrusionok() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(EXTRUSIONOK$28) != null);
    } 
  }
  
  public void setExtrusionok(STTrueFalse.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(EXTRUSIONOK$28);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(EXTRUSIONOK$28); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetExtrusionok(STTrueFalse paramSTTrueFalse) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(EXTRUSIONOK$28);
      if (sTTrueFalse == null)
        sTTrueFalse = (STTrueFalse)get_store().add_attribute_user(EXTRUSIONOK$28); 
      sTTrueFalse.set((XmlObject)paramSTTrueFalse);
    } 
  }
  
  public void unsetExtrusionok() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(EXTRUSIONOK$28);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\vml\impl\CTPathImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */