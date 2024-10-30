package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STDataValidationErrorStyle;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STDataValidationImeMode;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STDataValidationOperator;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STDataValidationType;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STFormula;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STSqref;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STXstring;

public class CTDataValidationImpl extends XmlComplexContentImpl implements CTDataValidation {
  private static final b FORMULA1$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "formula1");
  
  private static final b FORMULA2$2 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "formula2");
  
  private static final b TYPE$4 = new b("", "type");
  
  private static final b ERRORSTYLE$6 = new b("", "errorStyle");
  
  private static final b IMEMODE$8 = new b("", "imeMode");
  
  private static final b OPERATOR$10 = new b("", "operator");
  
  private static final b ALLOWBLANK$12 = new b("", "allowBlank");
  
  private static final b SHOWDROPDOWN$14 = new b("", "showDropDown");
  
  private static final b SHOWINPUTMESSAGE$16 = new b("", "showInputMessage");
  
  private static final b SHOWERRORMESSAGE$18 = new b("", "showErrorMessage");
  
  private static final b ERRORTITLE$20 = new b("", "errorTitle");
  
  private static final b ERROR$22 = new b("", "error");
  
  private static final b PROMPTTITLE$24 = new b("", "promptTitle");
  
  private static final b PROMPT$26 = new b("", "prompt");
  
  private static final b SQREF$28 = new b("", "sqref");
  
  public CTDataValidationImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public String getFormula1() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(FORMULA1$0, 0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STFormula xgetFormula1() {
    synchronized (monitor()) {
      check_orphaned();
      STFormula sTFormula = null;
      sTFormula = (STFormula)get_store().find_element_user(FORMULA1$0, 0);
      return sTFormula;
    } 
  }
  
  public boolean isSetFormula1() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(FORMULA1$0) != 0);
    } 
  }
  
  public void setFormula1(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(FORMULA1$0, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(FORMULA1$0); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetFormula1(STFormula paramSTFormula) {
    synchronized (monitor()) {
      check_orphaned();
      STFormula sTFormula = null;
      sTFormula = (STFormula)get_store().find_element_user(FORMULA1$0, 0);
      if (sTFormula == null)
        sTFormula = (STFormula)get_store().add_element_user(FORMULA1$0); 
      sTFormula.set((XmlObject)paramSTFormula);
    } 
  }
  
  public void unsetFormula1() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(FORMULA1$0, 0);
    } 
  }
  
  public String getFormula2() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(FORMULA2$2, 0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STFormula xgetFormula2() {
    synchronized (monitor()) {
      check_orphaned();
      STFormula sTFormula = null;
      sTFormula = (STFormula)get_store().find_element_user(FORMULA2$2, 0);
      return sTFormula;
    } 
  }
  
  public boolean isSetFormula2() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(FORMULA2$2) != 0);
    } 
  }
  
  public void setFormula2(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(FORMULA2$2, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(FORMULA2$2); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetFormula2(STFormula paramSTFormula) {
    synchronized (monitor()) {
      check_orphaned();
      STFormula sTFormula = null;
      sTFormula = (STFormula)get_store().find_element_user(FORMULA2$2, 0);
      if (sTFormula == null)
        sTFormula = (STFormula)get_store().add_element_user(FORMULA2$2); 
      sTFormula.set((XmlObject)paramSTFormula);
    } 
  }
  
  public void unsetFormula2() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(FORMULA2$2, 0);
    } 
  }
  
  public STDataValidationType.Enum getType() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TYPE$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(TYPE$4); 
      if (simpleValue == null)
        return null; 
      return (STDataValidationType.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STDataValidationType xgetType() {
    synchronized (monitor()) {
      check_orphaned();
      STDataValidationType sTDataValidationType = null;
      sTDataValidationType = (STDataValidationType)get_store().find_attribute_user(TYPE$4);
      if (sTDataValidationType == null)
        sTDataValidationType = (STDataValidationType)get_default_attribute_value(TYPE$4); 
      return sTDataValidationType;
    } 
  }
  
  public boolean isSetType() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(TYPE$4) != null);
    } 
  }
  
  public void setType(STDataValidationType.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TYPE$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TYPE$4); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetType(STDataValidationType paramSTDataValidationType) {
    synchronized (monitor()) {
      check_orphaned();
      STDataValidationType sTDataValidationType = null;
      sTDataValidationType = (STDataValidationType)get_store().find_attribute_user(TYPE$4);
      if (sTDataValidationType == null)
        sTDataValidationType = (STDataValidationType)get_store().add_attribute_user(TYPE$4); 
      sTDataValidationType.set((XmlObject)paramSTDataValidationType);
    } 
  }
  
  public void unsetType() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(TYPE$4);
    } 
  }
  
  public STDataValidationErrorStyle.Enum getErrorStyle() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ERRORSTYLE$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(ERRORSTYLE$6); 
      if (simpleValue == null)
        return null; 
      return (STDataValidationErrorStyle.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STDataValidationErrorStyle xgetErrorStyle() {
    synchronized (monitor()) {
      check_orphaned();
      STDataValidationErrorStyle sTDataValidationErrorStyle = null;
      sTDataValidationErrorStyle = (STDataValidationErrorStyle)get_store().find_attribute_user(ERRORSTYLE$6);
      if (sTDataValidationErrorStyle == null)
        sTDataValidationErrorStyle = (STDataValidationErrorStyle)get_default_attribute_value(ERRORSTYLE$6); 
      return sTDataValidationErrorStyle;
    } 
  }
  
  public boolean isSetErrorStyle() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ERRORSTYLE$6) != null);
    } 
  }
  
  public void setErrorStyle(STDataValidationErrorStyle.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ERRORSTYLE$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ERRORSTYLE$6); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetErrorStyle(STDataValidationErrorStyle paramSTDataValidationErrorStyle) {
    synchronized (monitor()) {
      check_orphaned();
      STDataValidationErrorStyle sTDataValidationErrorStyle = null;
      sTDataValidationErrorStyle = (STDataValidationErrorStyle)get_store().find_attribute_user(ERRORSTYLE$6);
      if (sTDataValidationErrorStyle == null)
        sTDataValidationErrorStyle = (STDataValidationErrorStyle)get_store().add_attribute_user(ERRORSTYLE$6); 
      sTDataValidationErrorStyle.set((XmlObject)paramSTDataValidationErrorStyle);
    } 
  }
  
  public void unsetErrorStyle() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ERRORSTYLE$6);
    } 
  }
  
  public STDataValidationImeMode.Enum getImeMode() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(IMEMODE$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(IMEMODE$8); 
      if (simpleValue == null)
        return null; 
      return (STDataValidationImeMode.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STDataValidationImeMode xgetImeMode() {
    synchronized (monitor()) {
      check_orphaned();
      STDataValidationImeMode sTDataValidationImeMode = null;
      sTDataValidationImeMode = (STDataValidationImeMode)get_store().find_attribute_user(IMEMODE$8);
      if (sTDataValidationImeMode == null)
        sTDataValidationImeMode = (STDataValidationImeMode)get_default_attribute_value(IMEMODE$8); 
      return sTDataValidationImeMode;
    } 
  }
  
  public boolean isSetImeMode() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(IMEMODE$8) != null);
    } 
  }
  
  public void setImeMode(STDataValidationImeMode.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(IMEMODE$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(IMEMODE$8); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetImeMode(STDataValidationImeMode paramSTDataValidationImeMode) {
    synchronized (monitor()) {
      check_orphaned();
      STDataValidationImeMode sTDataValidationImeMode = null;
      sTDataValidationImeMode = (STDataValidationImeMode)get_store().find_attribute_user(IMEMODE$8);
      if (sTDataValidationImeMode == null)
        sTDataValidationImeMode = (STDataValidationImeMode)get_store().add_attribute_user(IMEMODE$8); 
      sTDataValidationImeMode.set((XmlObject)paramSTDataValidationImeMode);
    } 
  }
  
  public void unsetImeMode() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(IMEMODE$8);
    } 
  }
  
  public STDataValidationOperator.Enum getOperator() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(OPERATOR$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(OPERATOR$10); 
      if (simpleValue == null)
        return null; 
      return (STDataValidationOperator.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STDataValidationOperator xgetOperator() {
    synchronized (monitor()) {
      check_orphaned();
      STDataValidationOperator sTDataValidationOperator = null;
      sTDataValidationOperator = (STDataValidationOperator)get_store().find_attribute_user(OPERATOR$10);
      if (sTDataValidationOperator == null)
        sTDataValidationOperator = (STDataValidationOperator)get_default_attribute_value(OPERATOR$10); 
      return sTDataValidationOperator;
    } 
  }
  
  public boolean isSetOperator() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(OPERATOR$10) != null);
    } 
  }
  
  public void setOperator(STDataValidationOperator.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(OPERATOR$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(OPERATOR$10); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetOperator(STDataValidationOperator paramSTDataValidationOperator) {
    synchronized (monitor()) {
      check_orphaned();
      STDataValidationOperator sTDataValidationOperator = null;
      sTDataValidationOperator = (STDataValidationOperator)get_store().find_attribute_user(OPERATOR$10);
      if (sTDataValidationOperator == null)
        sTDataValidationOperator = (STDataValidationOperator)get_store().add_attribute_user(OPERATOR$10); 
      sTDataValidationOperator.set((XmlObject)paramSTDataValidationOperator);
    } 
  }
  
  public void unsetOperator() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(OPERATOR$10);
    } 
  }
  
  public boolean getAllowBlank() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ALLOWBLANK$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(ALLOWBLANK$12); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetAllowBlank() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ALLOWBLANK$12);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(ALLOWBLANK$12); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetAllowBlank() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ALLOWBLANK$12) != null);
    } 
  }
  
  public void setAllowBlank(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ALLOWBLANK$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ALLOWBLANK$12); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetAllowBlank(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ALLOWBLANK$12);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(ALLOWBLANK$12); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetAllowBlank() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ALLOWBLANK$12);
    } 
  }
  
  public boolean getShowDropDown() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWDROPDOWN$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SHOWDROPDOWN$14); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetShowDropDown() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWDROPDOWN$14);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(SHOWDROPDOWN$14); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetShowDropDown() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SHOWDROPDOWN$14) != null);
    } 
  }
  
  public void setShowDropDown(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWDROPDOWN$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SHOWDROPDOWN$14); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetShowDropDown(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWDROPDOWN$14);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SHOWDROPDOWN$14); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetShowDropDown() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SHOWDROPDOWN$14);
    } 
  }
  
  public boolean getShowInputMessage() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWINPUTMESSAGE$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SHOWINPUTMESSAGE$16); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetShowInputMessage() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWINPUTMESSAGE$16);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(SHOWINPUTMESSAGE$16); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetShowInputMessage() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SHOWINPUTMESSAGE$16) != null);
    } 
  }
  
  public void setShowInputMessage(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWINPUTMESSAGE$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SHOWINPUTMESSAGE$16); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetShowInputMessage(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWINPUTMESSAGE$16);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SHOWINPUTMESSAGE$16); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetShowInputMessage() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SHOWINPUTMESSAGE$16);
    } 
  }
  
  public boolean getShowErrorMessage() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWERRORMESSAGE$18);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SHOWERRORMESSAGE$18); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetShowErrorMessage() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWERRORMESSAGE$18);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(SHOWERRORMESSAGE$18); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetShowErrorMessage() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SHOWERRORMESSAGE$18) != null);
    } 
  }
  
  public void setShowErrorMessage(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWERRORMESSAGE$18);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SHOWERRORMESSAGE$18); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetShowErrorMessage(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWERRORMESSAGE$18);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SHOWERRORMESSAGE$18); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetShowErrorMessage() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SHOWERRORMESSAGE$18);
    } 
  }
  
  public String getErrorTitle() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ERRORTITLE$20);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STXstring xgetErrorTitle() {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(ERRORTITLE$20);
      return sTXstring;
    } 
  }
  
  public boolean isSetErrorTitle() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ERRORTITLE$20) != null);
    } 
  }
  
  public void setErrorTitle(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ERRORTITLE$20);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ERRORTITLE$20); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetErrorTitle(STXstring paramSTXstring) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(ERRORTITLE$20);
      if (sTXstring == null)
        sTXstring = (STXstring)get_store().add_attribute_user(ERRORTITLE$20); 
      sTXstring.set((XmlObject)paramSTXstring);
    } 
  }
  
  public void unsetErrorTitle() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ERRORTITLE$20);
    } 
  }
  
  public String getError() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ERROR$22);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STXstring xgetError() {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(ERROR$22);
      return sTXstring;
    } 
  }
  
  public boolean isSetError() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ERROR$22) != null);
    } 
  }
  
  public void setError(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ERROR$22);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ERROR$22); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetError(STXstring paramSTXstring) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(ERROR$22);
      if (sTXstring == null)
        sTXstring = (STXstring)get_store().add_attribute_user(ERROR$22); 
      sTXstring.set((XmlObject)paramSTXstring);
    } 
  }
  
  public void unsetError() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ERROR$22);
    } 
  }
  
  public String getPromptTitle() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PROMPTTITLE$24);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STXstring xgetPromptTitle() {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(PROMPTTITLE$24);
      return sTXstring;
    } 
  }
  
  public boolean isSetPromptTitle() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(PROMPTTITLE$24) != null);
    } 
  }
  
  public void setPromptTitle(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PROMPTTITLE$24);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(PROMPTTITLE$24); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetPromptTitle(STXstring paramSTXstring) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(PROMPTTITLE$24);
      if (sTXstring == null)
        sTXstring = (STXstring)get_store().add_attribute_user(PROMPTTITLE$24); 
      sTXstring.set((XmlObject)paramSTXstring);
    } 
  }
  
  public void unsetPromptTitle() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(PROMPTTITLE$24);
    } 
  }
  
  public String getPrompt() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PROMPT$26);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STXstring xgetPrompt() {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(PROMPT$26);
      return sTXstring;
    } 
  }
  
  public boolean isSetPrompt() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(PROMPT$26) != null);
    } 
  }
  
  public void setPrompt(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PROMPT$26);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(PROMPT$26); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetPrompt(STXstring paramSTXstring) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(PROMPT$26);
      if (sTXstring == null)
        sTXstring = (STXstring)get_store().add_attribute_user(PROMPT$26); 
      sTXstring.set((XmlObject)paramSTXstring);
    } 
  }
  
  public void unsetPrompt() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(PROMPT$26);
    } 
  }
  
  public List getSqref() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SQREF$28);
      if (simpleValue == null)
        return null; 
      return simpleValue.getListValue();
    } 
  }
  
  public STSqref xgetSqref() {
    synchronized (monitor()) {
      check_orphaned();
      STSqref sTSqref = null;
      sTSqref = (STSqref)get_store().find_attribute_user(SQREF$28);
      return sTSqref;
    } 
  }
  
  public void setSqref(List paramList) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SQREF$28);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SQREF$28); 
      simpleValue.setListValue(paramList);
    } 
  }
  
  public void xsetSqref(STSqref paramSTSqref) {
    synchronized (monitor()) {
      check_orphaned();
      STSqref sTSqref = null;
      sTSqref = (STSqref)get_store().find_attribute_user(SQREF$28);
      if (sTSqref == null)
        sTSqref = (STSqref)get_store().add_attribute_user(SQREF$28); 
      sTSqref.set((XmlObject)paramSTSqref);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTDataValidationImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */