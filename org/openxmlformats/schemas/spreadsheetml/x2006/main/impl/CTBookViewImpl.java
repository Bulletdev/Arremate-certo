package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STVisibility;

public class CTBookViewImpl extends XmlComplexContentImpl implements CTBookView {
  private static final b EXTLST$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "extLst");
  
  private static final b VISIBILITY$2 = new b("", "visibility");
  
  private static final b MINIMIZED$4 = new b("", "minimized");
  
  private static final b SHOWHORIZONTALSCROLL$6 = new b("", "showHorizontalScroll");
  
  private static final b SHOWVERTICALSCROLL$8 = new b("", "showVerticalScroll");
  
  private static final b SHOWSHEETTABS$10 = new b("", "showSheetTabs");
  
  private static final b XWINDOW$12 = new b("", "xWindow");
  
  private static final b YWINDOW$14 = new b("", "yWindow");
  
  private static final b WINDOWWIDTH$16 = new b("", "windowWidth");
  
  private static final b WINDOWHEIGHT$18 = new b("", "windowHeight");
  
  private static final b TABRATIO$20 = new b("", "tabRatio");
  
  private static final b FIRSTSHEET$22 = new b("", "firstSheet");
  
  private static final b ACTIVETAB$24 = new b("", "activeTab");
  
  private static final b AUTOFILTERDATEGROUPING$26 = new b("", "autoFilterDateGrouping");
  
  public CTBookViewImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTExtensionList getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$0, 0);
      if (cTExtensionList == null)
        return null; 
      return cTExtensionList;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$0) != 0);
    } 
  }
  
  public void setExtLst(CTExtensionList paramCTExtensionList) {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$0, 0);
      if (cTExtensionList == null)
        cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$0); 
      cTExtensionList.set((XmlObject)paramCTExtensionList);
    } 
  }
  
  public CTExtensionList addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$0);
      return cTExtensionList;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$0, 0);
    } 
  }
  
  public STVisibility.Enum getVisibility() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VISIBILITY$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(VISIBILITY$2); 
      if (simpleValue == null)
        return null; 
      return (STVisibility.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STVisibility xgetVisibility() {
    synchronized (monitor()) {
      check_orphaned();
      STVisibility sTVisibility = null;
      sTVisibility = (STVisibility)get_store().find_attribute_user(VISIBILITY$2);
      if (sTVisibility == null)
        sTVisibility = (STVisibility)get_default_attribute_value(VISIBILITY$2); 
      return sTVisibility;
    } 
  }
  
  public boolean isSetVisibility() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(VISIBILITY$2) != null);
    } 
  }
  
  public void setVisibility(STVisibility.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VISIBILITY$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(VISIBILITY$2); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetVisibility(STVisibility paramSTVisibility) {
    synchronized (monitor()) {
      check_orphaned();
      STVisibility sTVisibility = null;
      sTVisibility = (STVisibility)get_store().find_attribute_user(VISIBILITY$2);
      if (sTVisibility == null)
        sTVisibility = (STVisibility)get_store().add_attribute_user(VISIBILITY$2); 
      sTVisibility.set((XmlObject)paramSTVisibility);
    } 
  }
  
  public void unsetVisibility() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(VISIBILITY$2);
    } 
  }
  
  public boolean getMinimized() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MINIMIZED$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(MINIMIZED$4); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetMinimized() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(MINIMIZED$4);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(MINIMIZED$4); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetMinimized() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(MINIMIZED$4) != null);
    } 
  }
  
  public void setMinimized(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MINIMIZED$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(MINIMIZED$4); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetMinimized(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(MINIMIZED$4);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(MINIMIZED$4); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetMinimized() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(MINIMIZED$4);
    } 
  }
  
  public boolean getShowHorizontalScroll() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWHORIZONTALSCROLL$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SHOWHORIZONTALSCROLL$6); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetShowHorizontalScroll() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWHORIZONTALSCROLL$6);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(SHOWHORIZONTALSCROLL$6); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetShowHorizontalScroll() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SHOWHORIZONTALSCROLL$6) != null);
    } 
  }
  
  public void setShowHorizontalScroll(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWHORIZONTALSCROLL$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SHOWHORIZONTALSCROLL$6); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetShowHorizontalScroll(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWHORIZONTALSCROLL$6);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SHOWHORIZONTALSCROLL$6); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetShowHorizontalScroll() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SHOWHORIZONTALSCROLL$6);
    } 
  }
  
  public boolean getShowVerticalScroll() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWVERTICALSCROLL$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SHOWVERTICALSCROLL$8); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetShowVerticalScroll() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWVERTICALSCROLL$8);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(SHOWVERTICALSCROLL$8); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetShowVerticalScroll() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SHOWVERTICALSCROLL$8) != null);
    } 
  }
  
  public void setShowVerticalScroll(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWVERTICALSCROLL$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SHOWVERTICALSCROLL$8); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetShowVerticalScroll(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWVERTICALSCROLL$8);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SHOWVERTICALSCROLL$8); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetShowVerticalScroll() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SHOWVERTICALSCROLL$8);
    } 
  }
  
  public boolean getShowSheetTabs() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWSHEETTABS$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SHOWSHEETTABS$10); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetShowSheetTabs() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWSHEETTABS$10);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(SHOWSHEETTABS$10); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetShowSheetTabs() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SHOWSHEETTABS$10) != null);
    } 
  }
  
  public void setShowSheetTabs(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWSHEETTABS$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SHOWSHEETTABS$10); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetShowSheetTabs(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWSHEETTABS$10);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SHOWSHEETTABS$10); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetShowSheetTabs() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SHOWSHEETTABS$10);
    } 
  }
  
  public int getXWindow() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(XWINDOW$12);
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public XmlInt xgetXWindow() {
    synchronized (monitor()) {
      check_orphaned();
      XmlInt xmlInt = null;
      xmlInt = (XmlInt)get_store().find_attribute_user(XWINDOW$12);
      return xmlInt;
    } 
  }
  
  public boolean isSetXWindow() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(XWINDOW$12) != null);
    } 
  }
  
  public void setXWindow(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(XWINDOW$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(XWINDOW$12); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetXWindow(XmlInt paramXmlInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInt xmlInt = null;
      xmlInt = (XmlInt)get_store().find_attribute_user(XWINDOW$12);
      if (xmlInt == null)
        xmlInt = (XmlInt)get_store().add_attribute_user(XWINDOW$12); 
      xmlInt.set((XmlObject)paramXmlInt);
    } 
  }
  
  public void unsetXWindow() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(XWINDOW$12);
    } 
  }
  
  public int getYWindow() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(YWINDOW$14);
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public XmlInt xgetYWindow() {
    synchronized (monitor()) {
      check_orphaned();
      XmlInt xmlInt = null;
      xmlInt = (XmlInt)get_store().find_attribute_user(YWINDOW$14);
      return xmlInt;
    } 
  }
  
  public boolean isSetYWindow() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(YWINDOW$14) != null);
    } 
  }
  
  public void setYWindow(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(YWINDOW$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(YWINDOW$14); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetYWindow(XmlInt paramXmlInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInt xmlInt = null;
      xmlInt = (XmlInt)get_store().find_attribute_user(YWINDOW$14);
      if (xmlInt == null)
        xmlInt = (XmlInt)get_store().add_attribute_user(YWINDOW$14); 
      xmlInt.set((XmlObject)paramXmlInt);
    } 
  }
  
  public void unsetYWindow() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(YWINDOW$14);
    } 
  }
  
  public long getWindowWidth() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(WINDOWWIDTH$16);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetWindowWidth() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(WINDOWWIDTH$16);
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetWindowWidth() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(WINDOWWIDTH$16) != null);
    } 
  }
  
  public void setWindowWidth(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(WINDOWWIDTH$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(WINDOWWIDTH$16); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetWindowWidth(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(WINDOWWIDTH$16);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(WINDOWWIDTH$16); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetWindowWidth() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(WINDOWWIDTH$16);
    } 
  }
  
  public long getWindowHeight() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(WINDOWHEIGHT$18);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetWindowHeight() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(WINDOWHEIGHT$18);
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetWindowHeight() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(WINDOWHEIGHT$18) != null);
    } 
  }
  
  public void setWindowHeight(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(WINDOWHEIGHT$18);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(WINDOWHEIGHT$18); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetWindowHeight(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(WINDOWHEIGHT$18);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(WINDOWHEIGHT$18); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetWindowHeight() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(WINDOWHEIGHT$18);
    } 
  }
  
  public long getTabRatio() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TABRATIO$20);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(TABRATIO$20); 
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetTabRatio() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(TABRATIO$20);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_default_attribute_value(TABRATIO$20); 
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetTabRatio() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(TABRATIO$20) != null);
    } 
  }
  
  public void setTabRatio(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TABRATIO$20);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TABRATIO$20); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetTabRatio(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(TABRATIO$20);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(TABRATIO$20); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetTabRatio() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(TABRATIO$20);
    } 
  }
  
  public long getFirstSheet() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FIRSTSHEET$22);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(FIRSTSHEET$22); 
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetFirstSheet() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(FIRSTSHEET$22);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_default_attribute_value(FIRSTSHEET$22); 
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetFirstSheet() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(FIRSTSHEET$22) != null);
    } 
  }
  
  public void setFirstSheet(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FIRSTSHEET$22);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FIRSTSHEET$22); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetFirstSheet(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(FIRSTSHEET$22);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(FIRSTSHEET$22); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetFirstSheet() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(FIRSTSHEET$22);
    } 
  }
  
  public long getActiveTab() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ACTIVETAB$24);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(ACTIVETAB$24); 
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetActiveTab() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(ACTIVETAB$24);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_default_attribute_value(ACTIVETAB$24); 
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetActiveTab() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ACTIVETAB$24) != null);
    } 
  }
  
  public void setActiveTab(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ACTIVETAB$24);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ACTIVETAB$24); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetActiveTab(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(ACTIVETAB$24);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(ACTIVETAB$24); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetActiveTab() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ACTIVETAB$24);
    } 
  }
  
  public boolean getAutoFilterDateGrouping() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(AUTOFILTERDATEGROUPING$26);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(AUTOFILTERDATEGROUPING$26); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetAutoFilterDateGrouping() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(AUTOFILTERDATEGROUPING$26);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(AUTOFILTERDATEGROUPING$26); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetAutoFilterDateGrouping() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(AUTOFILTERDATEGROUPING$26) != null);
    } 
  }
  
  public void setAutoFilterDateGrouping(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(AUTOFILTERDATEGROUPING$26);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(AUTOFILTERDATEGROUPING$26); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetAutoFilterDateGrouping(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(AUTOFILTERDATEGROUPING$26);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(AUTOFILTERDATEGROUPING$26); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetAutoFilterDateGrouping() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(AUTOFILTERDATEGROUPING$26);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTBookViewImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */