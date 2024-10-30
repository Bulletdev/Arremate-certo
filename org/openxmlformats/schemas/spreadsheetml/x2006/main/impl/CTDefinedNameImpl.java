package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.JavaStringHolderEx;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDefinedName;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STXstring;

public class CTDefinedNameImpl extends JavaStringHolderEx implements CTDefinedName {
  private static final b NAME$0 = new b("", "name");
  
  private static final b COMMENT$2 = new b("", "comment");
  
  private static final b CUSTOMMENU$4 = new b("", "customMenu");
  
  private static final b DESCRIPTION$6 = new b("", "description");
  
  private static final b HELP$8 = new b("", "help");
  
  private static final b STATUSBAR$10 = new b("", "statusBar");
  
  private static final b LOCALSHEETID$12 = new b("", "localSheetId");
  
  private static final b HIDDEN$14 = new b("", "hidden");
  
  private static final b FUNCTION$16 = new b("", "function");
  
  private static final b VBPROCEDURE$18 = new b("", "vbProcedure");
  
  private static final b XLM$20 = new b("", "xlm");
  
  private static final b FUNCTIONGROUPID$22 = new b("", "functionGroupId");
  
  private static final b SHORTCUTKEY$24 = new b("", "shortcutKey");
  
  private static final b PUBLISHTOSERVER$26 = new b("", "publishToServer");
  
  private static final b WORKBOOKPARAMETER$28 = new b("", "workbookParameter");
  
  public CTDefinedNameImpl(SchemaType paramSchemaType) {
    super(paramSchemaType, true);
  }
  
  protected CTDefinedNameImpl(SchemaType paramSchemaType, boolean paramBoolean) {
    super(paramSchemaType, paramBoolean);
  }
  
  public String getName() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STXstring xgetName() {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(NAME$0);
      return sTXstring;
    } 
  }
  
  public void setName(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(NAME$0); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetName(STXstring paramSTXstring) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(NAME$0);
      if (sTXstring == null)
        sTXstring = (STXstring)get_store().add_attribute_user(NAME$0); 
      sTXstring.set((XmlObject)paramSTXstring);
    } 
  }
  
  public String getComment() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COMMENT$2);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STXstring xgetComment() {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(COMMENT$2);
      return sTXstring;
    } 
  }
  
  public boolean isSetComment() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(COMMENT$2) != null);
    } 
  }
  
  public void setComment(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COMMENT$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(COMMENT$2); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetComment(STXstring paramSTXstring) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(COMMENT$2);
      if (sTXstring == null)
        sTXstring = (STXstring)get_store().add_attribute_user(COMMENT$2); 
      sTXstring.set((XmlObject)paramSTXstring);
    } 
  }
  
  public void unsetComment() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(COMMENT$2);
    } 
  }
  
  public String getCustomMenu() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CUSTOMMENU$4);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STXstring xgetCustomMenu() {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(CUSTOMMENU$4);
      return sTXstring;
    } 
  }
  
  public boolean isSetCustomMenu() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(CUSTOMMENU$4) != null);
    } 
  }
  
  public void setCustomMenu(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CUSTOMMENU$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CUSTOMMENU$4); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetCustomMenu(STXstring paramSTXstring) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(CUSTOMMENU$4);
      if (sTXstring == null)
        sTXstring = (STXstring)get_store().add_attribute_user(CUSTOMMENU$4); 
      sTXstring.set((XmlObject)paramSTXstring);
    } 
  }
  
  public void unsetCustomMenu() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(CUSTOMMENU$4);
    } 
  }
  
  public String getDescription() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DESCRIPTION$6);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STXstring xgetDescription() {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(DESCRIPTION$6);
      return sTXstring;
    } 
  }
  
  public boolean isSetDescription() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DESCRIPTION$6) != null);
    } 
  }
  
  public void setDescription(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DESCRIPTION$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DESCRIPTION$6); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetDescription(STXstring paramSTXstring) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(DESCRIPTION$6);
      if (sTXstring == null)
        sTXstring = (STXstring)get_store().add_attribute_user(DESCRIPTION$6); 
      sTXstring.set((XmlObject)paramSTXstring);
    } 
  }
  
  public void unsetDescription() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DESCRIPTION$6);
    } 
  }
  
  public String getHelp() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HELP$8);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STXstring xgetHelp() {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(HELP$8);
      return sTXstring;
    } 
  }
  
  public boolean isSetHelp() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(HELP$8) != null);
    } 
  }
  
  public void setHelp(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HELP$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(HELP$8); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetHelp(STXstring paramSTXstring) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(HELP$8);
      if (sTXstring == null)
        sTXstring = (STXstring)get_store().add_attribute_user(HELP$8); 
      sTXstring.set((XmlObject)paramSTXstring);
    } 
  }
  
  public void unsetHelp() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(HELP$8);
    } 
  }
  
  public String getStatusBar() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(STATUSBAR$10);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STXstring xgetStatusBar() {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(STATUSBAR$10);
      return sTXstring;
    } 
  }
  
  public boolean isSetStatusBar() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(STATUSBAR$10) != null);
    } 
  }
  
  public void setStatusBar(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(STATUSBAR$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(STATUSBAR$10); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetStatusBar(STXstring paramSTXstring) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(STATUSBAR$10);
      if (sTXstring == null)
        sTXstring = (STXstring)get_store().add_attribute_user(STATUSBAR$10); 
      sTXstring.set((XmlObject)paramSTXstring);
    } 
  }
  
  public void unsetStatusBar() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(STATUSBAR$10);
    } 
  }
  
  public long getLocalSheetId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(LOCALSHEETID$12);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetLocalSheetId() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(LOCALSHEETID$12);
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetLocalSheetId() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(LOCALSHEETID$12) != null);
    } 
  }
  
  public void setLocalSheetId(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(LOCALSHEETID$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(LOCALSHEETID$12); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetLocalSheetId(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(LOCALSHEETID$12);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(LOCALSHEETID$12); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetLocalSheetId() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(LOCALSHEETID$12);
    } 
  }
  
  public boolean getHidden() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HIDDEN$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(HIDDEN$14); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetHidden() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(HIDDEN$14);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(HIDDEN$14); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetHidden() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(HIDDEN$14) != null);
    } 
  }
  
  public void setHidden(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HIDDEN$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(HIDDEN$14); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetHidden(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(HIDDEN$14);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(HIDDEN$14); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetHidden() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(HIDDEN$14);
    } 
  }
  
  public boolean getFunction() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FUNCTION$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(FUNCTION$16); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetFunction() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(FUNCTION$16);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(FUNCTION$16); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetFunction() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(FUNCTION$16) != null);
    } 
  }
  
  public void setFunction(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FUNCTION$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FUNCTION$16); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetFunction(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(FUNCTION$16);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(FUNCTION$16); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetFunction() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(FUNCTION$16);
    } 
  }
  
  public boolean getVbProcedure() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VBPROCEDURE$18);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(VBPROCEDURE$18); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetVbProcedure() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(VBPROCEDURE$18);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(VBPROCEDURE$18); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetVbProcedure() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(VBPROCEDURE$18) != null);
    } 
  }
  
  public void setVbProcedure(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VBPROCEDURE$18);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(VBPROCEDURE$18); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetVbProcedure(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(VBPROCEDURE$18);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(VBPROCEDURE$18); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetVbProcedure() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(VBPROCEDURE$18);
    } 
  }
  
  public boolean getXlm() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(XLM$20);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(XLM$20); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetXlm() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(XLM$20);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(XLM$20); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetXlm() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(XLM$20) != null);
    } 
  }
  
  public void setXlm(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(XLM$20);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(XLM$20); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetXlm(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(XLM$20);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(XLM$20); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetXlm() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(XLM$20);
    } 
  }
  
  public long getFunctionGroupId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FUNCTIONGROUPID$22);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetFunctionGroupId() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(FUNCTIONGROUPID$22);
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetFunctionGroupId() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(FUNCTIONGROUPID$22) != null);
    } 
  }
  
  public void setFunctionGroupId(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FUNCTIONGROUPID$22);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FUNCTIONGROUPID$22); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetFunctionGroupId(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(FUNCTIONGROUPID$22);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(FUNCTIONGROUPID$22); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetFunctionGroupId() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(FUNCTIONGROUPID$22);
    } 
  }
  
  public String getShortcutKey() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHORTCUTKEY$24);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STXstring xgetShortcutKey() {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(SHORTCUTKEY$24);
      return sTXstring;
    } 
  }
  
  public boolean isSetShortcutKey() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SHORTCUTKEY$24) != null);
    } 
  }
  
  public void setShortcutKey(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHORTCUTKEY$24);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SHORTCUTKEY$24); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetShortcutKey(STXstring paramSTXstring) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(SHORTCUTKEY$24);
      if (sTXstring == null)
        sTXstring = (STXstring)get_store().add_attribute_user(SHORTCUTKEY$24); 
      sTXstring.set((XmlObject)paramSTXstring);
    } 
  }
  
  public void unsetShortcutKey() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SHORTCUTKEY$24);
    } 
  }
  
  public boolean getPublishToServer() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PUBLISHTOSERVER$26);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(PUBLISHTOSERVER$26); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetPublishToServer() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(PUBLISHTOSERVER$26);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(PUBLISHTOSERVER$26); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetPublishToServer() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(PUBLISHTOSERVER$26) != null);
    } 
  }
  
  public void setPublishToServer(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PUBLISHTOSERVER$26);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(PUBLISHTOSERVER$26); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetPublishToServer(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(PUBLISHTOSERVER$26);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(PUBLISHTOSERVER$26); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetPublishToServer() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(PUBLISHTOSERVER$26);
    } 
  }
  
  public boolean getWorkbookParameter() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(WORKBOOKPARAMETER$28);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(WORKBOOKPARAMETER$28); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetWorkbookParameter() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(WORKBOOKPARAMETER$28);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(WORKBOOKPARAMETER$28); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetWorkbookParameter() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(WORKBOOKPARAMETER$28) != null);
    } 
  }
  
  public void setWorkbookParameter(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(WORKBOOKPARAMETER$28);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(WORKBOOKPARAMETER$28); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetWorkbookParameter(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(WORKBOOKPARAMETER$28);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(WORKBOOKPARAMETER$28); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetWorkbookParameter() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(WORKBOOKPARAMETER$28);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTDefinedNameImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */