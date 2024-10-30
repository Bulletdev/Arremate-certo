package com.microsoft.schemas.vml.impl;

import com.microsoft.schemas.office.office.STInsetMode;
import com.microsoft.schemas.office.office.STTrueFalse;
import com.microsoft.schemas.vml.CTTextbox;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent;

public class CTTextboxImpl extends XmlComplexContentImpl implements CTTextbox {
  private static final b TXBXCONTENT$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "txbxContent");
  
  private static final b ID$2 = new b("", "id");
  
  private static final b STYLE$4 = new b("", "style");
  
  private static final b INSET$6 = new b("", "inset");
  
  private static final b SINGLECLICK$8 = new b("urn:schemas-microsoft-com:office:office", "singleclick");
  
  private static final b INSETMODE$10 = new b("urn:schemas-microsoft-com:office:office", "insetmode");
  
  public CTTextboxImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTTxbxContent getTxbxContent() {
    synchronized (monitor()) {
      check_orphaned();
      CTTxbxContent cTTxbxContent = null;
      cTTxbxContent = (CTTxbxContent)get_store().find_element_user(TXBXCONTENT$0, 0);
      if (cTTxbxContent == null)
        return null; 
      return cTTxbxContent;
    } 
  }
  
  public boolean isSetTxbxContent() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TXBXCONTENT$0) != 0);
    } 
  }
  
  public void setTxbxContent(CTTxbxContent paramCTTxbxContent) {
    synchronized (monitor()) {
      check_orphaned();
      CTTxbxContent cTTxbxContent = null;
      cTTxbxContent = (CTTxbxContent)get_store().find_element_user(TXBXCONTENT$0, 0);
      if (cTTxbxContent == null)
        cTTxbxContent = (CTTxbxContent)get_store().add_element_user(TXBXCONTENT$0); 
      cTTxbxContent.set((XmlObject)paramCTTxbxContent);
    } 
  }
  
  public CTTxbxContent addNewTxbxContent() {
    synchronized (monitor()) {
      check_orphaned();
      CTTxbxContent cTTxbxContent = null;
      cTTxbxContent = (CTTxbxContent)get_store().add_element_user(TXBXCONTENT$0);
      return cTTxbxContent;
    } 
  }
  
  public void unsetTxbxContent() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TXBXCONTENT$0, 0);
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
  
  public String getStyle() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(STYLE$4);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetStyle() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(STYLE$4);
      return xmlString;
    } 
  }
  
  public boolean isSetStyle() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(STYLE$4) != null);
    } 
  }
  
  public void setStyle(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(STYLE$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(STYLE$4); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetStyle(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(STYLE$4);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(STYLE$4); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetStyle() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(STYLE$4);
    } 
  }
  
  public String getInset() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(INSET$6);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetInset() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(INSET$6);
      return xmlString;
    } 
  }
  
  public boolean isSetInset() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(INSET$6) != null);
    } 
  }
  
  public void setInset(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(INSET$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(INSET$6); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetInset(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(INSET$6);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(INSET$6); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetInset() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(INSET$6);
    } 
  }
  
  public STTrueFalse.Enum getSingleclick() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SINGLECLICK$8);
      if (simpleValue == null)
        return null; 
      return (STTrueFalse.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalse xgetSingleclick() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(SINGLECLICK$8);
      return sTTrueFalse;
    } 
  }
  
  public boolean isSetSingleclick() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SINGLECLICK$8) != null);
    } 
  }
  
  public void setSingleclick(STTrueFalse.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SINGLECLICK$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SINGLECLICK$8); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetSingleclick(STTrueFalse paramSTTrueFalse) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(SINGLECLICK$8);
      if (sTTrueFalse == null)
        sTTrueFalse = (STTrueFalse)get_store().add_attribute_user(SINGLECLICK$8); 
      sTTrueFalse.set((XmlObject)paramSTTrueFalse);
    } 
  }
  
  public void unsetSingleclick() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SINGLECLICK$8);
    } 
  }
  
  public STInsetMode.Enum getInsetmode() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(INSETMODE$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(INSETMODE$10); 
      if (simpleValue == null)
        return null; 
      return (STInsetMode.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STInsetMode xgetInsetmode() {
    synchronized (monitor()) {
      check_orphaned();
      STInsetMode sTInsetMode = null;
      sTInsetMode = (STInsetMode)get_store().find_attribute_user(INSETMODE$10);
      if (sTInsetMode == null)
        sTInsetMode = (STInsetMode)get_default_attribute_value(INSETMODE$10); 
      return sTInsetMode;
    } 
  }
  
  public boolean isSetInsetmode() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(INSETMODE$10) != null);
    } 
  }
  
  public void setInsetmode(STInsetMode.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(INSETMODE$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(INSETMODE$10); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetInsetmode(STInsetMode paramSTInsetMode) {
    synchronized (monitor()) {
      check_orphaned();
      STInsetMode sTInsetMode = null;
      sTInsetMode = (STInsetMode)get_store().find_attribute_user(INSETMODE$10);
      if (sTInsetMode == null)
        sTInsetMode = (STInsetMode)get_store().add_attribute_user(INSETMODE$10); 
      sTInsetMode.set((XmlObject)paramSTInsetMode);
    } 
  }
  
  public void unsetInsetmode() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(INSETMODE$10);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\vml\impl\CTTextboxImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */