package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPane;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotSelection;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSelection;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetView;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCellRef;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STSheetViewType;

public class CTSheetViewImpl extends XmlComplexContentImpl implements CTSheetView {
  private static final b PANE$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "pane");
  
  private static final b SELECTION$2 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "selection");
  
  private static final b PIVOTSELECTION$4 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "pivotSelection");
  
  private static final b EXTLST$6 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "extLst");
  
  private static final b WINDOWPROTECTION$8 = new b("", "windowProtection");
  
  private static final b SHOWFORMULAS$10 = new b("", "showFormulas");
  
  private static final b SHOWGRIDLINES$12 = new b("", "showGridLines");
  
  private static final b SHOWROWCOLHEADERS$14 = new b("", "showRowColHeaders");
  
  private static final b SHOWZEROS$16 = new b("", "showZeros");
  
  private static final b RIGHTTOLEFT$18 = new b("", "rightToLeft");
  
  private static final b TABSELECTED$20 = new b("", "tabSelected");
  
  private static final b SHOWRULER$22 = new b("", "showRuler");
  
  private static final b SHOWOUTLINESYMBOLS$24 = new b("", "showOutlineSymbols");
  
  private static final b DEFAULTGRIDCOLOR$26 = new b("", "defaultGridColor");
  
  private static final b SHOWWHITESPACE$28 = new b("", "showWhiteSpace");
  
  private static final b VIEW$30 = new b("", "view");
  
  private static final b TOPLEFTCELL$32 = new b("", "topLeftCell");
  
  private static final b COLORID$34 = new b("", "colorId");
  
  private static final b ZOOMSCALE$36 = new b("", "zoomScale");
  
  private static final b ZOOMSCALENORMAL$38 = new b("", "zoomScaleNormal");
  
  private static final b ZOOMSCALESHEETLAYOUTVIEW$40 = new b("", "zoomScaleSheetLayoutView");
  
  private static final b ZOOMSCALEPAGELAYOUTVIEW$42 = new b("", "zoomScalePageLayoutView");
  
  private static final b WORKBOOKVIEWID$44 = new b("", "workbookViewId");
  
  public CTSheetViewImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTPane getPane() {
    synchronized (monitor()) {
      check_orphaned();
      CTPane cTPane = null;
      cTPane = (CTPane)get_store().find_element_user(PANE$0, 0);
      if (cTPane == null)
        return null; 
      return cTPane;
    } 
  }
  
  public boolean isSetPane() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PANE$0) != 0);
    } 
  }
  
  public void setPane(CTPane paramCTPane) {
    synchronized (monitor()) {
      check_orphaned();
      CTPane cTPane = null;
      cTPane = (CTPane)get_store().find_element_user(PANE$0, 0);
      if (cTPane == null)
        cTPane = (CTPane)get_store().add_element_user(PANE$0); 
      cTPane.set((XmlObject)paramCTPane);
    } 
  }
  
  public CTPane addNewPane() {
    synchronized (monitor()) {
      check_orphaned();
      CTPane cTPane = null;
      cTPane = (CTPane)get_store().add_element_user(PANE$0);
      return cTPane;
    } 
  }
  
  public void unsetPane() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PANE$0, 0);
    } 
  }
  
  public List<CTSelection> getSelectionList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTSelection>)new SelectionList(this);
    } 
  }
  
  public CTSelection[] getSelectionArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(SELECTION$2, arrayList);
      CTSelection[] arrayOfCTSelection = new CTSelection[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTSelection);
      return arrayOfCTSelection;
    } 
  }
  
  public CTSelection getSelectionArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTSelection cTSelection = null;
      cTSelection = (CTSelection)get_store().find_element_user(SELECTION$2, paramInt);
      if (cTSelection == null)
        throw new IndexOutOfBoundsException(); 
      return cTSelection;
    } 
  }
  
  public int sizeOfSelectionArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(SELECTION$2);
    } 
  }
  
  public void setSelectionArray(CTSelection[] paramArrayOfCTSelection) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTSelection, SELECTION$2);
    } 
  }
  
  public void setSelectionArray(int paramInt, CTSelection paramCTSelection) {
    synchronized (monitor()) {
      check_orphaned();
      CTSelection cTSelection = null;
      cTSelection = (CTSelection)get_store().find_element_user(SELECTION$2, paramInt);
      if (cTSelection == null)
        throw new IndexOutOfBoundsException(); 
      cTSelection.set((XmlObject)paramCTSelection);
    } 
  }
  
  public CTSelection insertNewSelection(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTSelection cTSelection = null;
      cTSelection = (CTSelection)get_store().insert_element_user(SELECTION$2, paramInt);
      return cTSelection;
    } 
  }
  
  public CTSelection addNewSelection() {
    synchronized (monitor()) {
      check_orphaned();
      CTSelection cTSelection = null;
      cTSelection = (CTSelection)get_store().add_element_user(SELECTION$2);
      return cTSelection;
    } 
  }
  
  public void removeSelection(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SELECTION$2, paramInt);
    } 
  }
  
  public List<CTPivotSelection> getPivotSelectionList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTPivotSelection>)new PivotSelectionList(this);
    } 
  }
  
  public CTPivotSelection[] getPivotSelectionArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(PIVOTSELECTION$4, arrayList);
      CTPivotSelection[] arrayOfCTPivotSelection = new CTPivotSelection[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTPivotSelection);
      return arrayOfCTPivotSelection;
    } 
  }
  
  public CTPivotSelection getPivotSelectionArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPivotSelection cTPivotSelection = null;
      cTPivotSelection = (CTPivotSelection)get_store().find_element_user(PIVOTSELECTION$4, paramInt);
      if (cTPivotSelection == null)
        throw new IndexOutOfBoundsException(); 
      return cTPivotSelection;
    } 
  }
  
  public int sizeOfPivotSelectionArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(PIVOTSELECTION$4);
    } 
  }
  
  public void setPivotSelectionArray(CTPivotSelection[] paramArrayOfCTPivotSelection) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTPivotSelection, PIVOTSELECTION$4);
    } 
  }
  
  public void setPivotSelectionArray(int paramInt, CTPivotSelection paramCTPivotSelection) {
    synchronized (monitor()) {
      check_orphaned();
      CTPivotSelection cTPivotSelection = null;
      cTPivotSelection = (CTPivotSelection)get_store().find_element_user(PIVOTSELECTION$4, paramInt);
      if (cTPivotSelection == null)
        throw new IndexOutOfBoundsException(); 
      cTPivotSelection.set((XmlObject)paramCTPivotSelection);
    } 
  }
  
  public CTPivotSelection insertNewPivotSelection(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPivotSelection cTPivotSelection = null;
      cTPivotSelection = (CTPivotSelection)get_store().insert_element_user(PIVOTSELECTION$4, paramInt);
      return cTPivotSelection;
    } 
  }
  
  public CTPivotSelection addNewPivotSelection() {
    synchronized (monitor()) {
      check_orphaned();
      CTPivotSelection cTPivotSelection = null;
      cTPivotSelection = (CTPivotSelection)get_store().add_element_user(PIVOTSELECTION$4);
      return cTPivotSelection;
    } 
  }
  
  public void removePivotSelection(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PIVOTSELECTION$4, paramInt);
    } 
  }
  
  public CTExtensionList getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$6, 0);
      if (cTExtensionList == null)
        return null; 
      return cTExtensionList;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$6) != 0);
    } 
  }
  
  public void setExtLst(CTExtensionList paramCTExtensionList) {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$6, 0);
      if (cTExtensionList == null)
        cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$6); 
      cTExtensionList.set((XmlObject)paramCTExtensionList);
    } 
  }
  
  public CTExtensionList addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$6);
      return cTExtensionList;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$6, 0);
    } 
  }
  
  public boolean getWindowProtection() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(WINDOWPROTECTION$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(WINDOWPROTECTION$8); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetWindowProtection() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(WINDOWPROTECTION$8);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(WINDOWPROTECTION$8); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetWindowProtection() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(WINDOWPROTECTION$8) != null);
    } 
  }
  
  public void setWindowProtection(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(WINDOWPROTECTION$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(WINDOWPROTECTION$8); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetWindowProtection(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(WINDOWPROTECTION$8);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(WINDOWPROTECTION$8); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetWindowProtection() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(WINDOWPROTECTION$8);
    } 
  }
  
  public boolean getShowFormulas() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWFORMULAS$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SHOWFORMULAS$10); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetShowFormulas() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWFORMULAS$10);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(SHOWFORMULAS$10); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetShowFormulas() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SHOWFORMULAS$10) != null);
    } 
  }
  
  public void setShowFormulas(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWFORMULAS$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SHOWFORMULAS$10); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetShowFormulas(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWFORMULAS$10);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SHOWFORMULAS$10); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetShowFormulas() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SHOWFORMULAS$10);
    } 
  }
  
  public boolean getShowGridLines() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWGRIDLINES$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SHOWGRIDLINES$12); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetShowGridLines() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWGRIDLINES$12);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(SHOWGRIDLINES$12); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetShowGridLines() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SHOWGRIDLINES$12) != null);
    } 
  }
  
  public void setShowGridLines(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWGRIDLINES$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SHOWGRIDLINES$12); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetShowGridLines(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWGRIDLINES$12);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SHOWGRIDLINES$12); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetShowGridLines() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SHOWGRIDLINES$12);
    } 
  }
  
  public boolean getShowRowColHeaders() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWROWCOLHEADERS$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SHOWROWCOLHEADERS$14); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetShowRowColHeaders() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWROWCOLHEADERS$14);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(SHOWROWCOLHEADERS$14); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetShowRowColHeaders() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SHOWROWCOLHEADERS$14) != null);
    } 
  }
  
  public void setShowRowColHeaders(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWROWCOLHEADERS$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SHOWROWCOLHEADERS$14); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetShowRowColHeaders(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWROWCOLHEADERS$14);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SHOWROWCOLHEADERS$14); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetShowRowColHeaders() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SHOWROWCOLHEADERS$14);
    } 
  }
  
  public boolean getShowZeros() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWZEROS$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SHOWZEROS$16); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetShowZeros() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWZEROS$16);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(SHOWZEROS$16); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetShowZeros() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SHOWZEROS$16) != null);
    } 
  }
  
  public void setShowZeros(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWZEROS$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SHOWZEROS$16); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetShowZeros(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWZEROS$16);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SHOWZEROS$16); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetShowZeros() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SHOWZEROS$16);
    } 
  }
  
  public boolean getRightToLeft() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(RIGHTTOLEFT$18);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(RIGHTTOLEFT$18); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetRightToLeft() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(RIGHTTOLEFT$18);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(RIGHTTOLEFT$18); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetRightToLeft() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(RIGHTTOLEFT$18) != null);
    } 
  }
  
  public void setRightToLeft(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(RIGHTTOLEFT$18);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(RIGHTTOLEFT$18); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetRightToLeft(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(RIGHTTOLEFT$18);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(RIGHTTOLEFT$18); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetRightToLeft() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(RIGHTTOLEFT$18);
    } 
  }
  
  public boolean getTabSelected() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TABSELECTED$20);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(TABSELECTED$20); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetTabSelected() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(TABSELECTED$20);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(TABSELECTED$20); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetTabSelected() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(TABSELECTED$20) != null);
    } 
  }
  
  public void setTabSelected(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TABSELECTED$20);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TABSELECTED$20); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetTabSelected(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(TABSELECTED$20);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(TABSELECTED$20); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetTabSelected() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(TABSELECTED$20);
    } 
  }
  
  public boolean getShowRuler() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWRULER$22);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SHOWRULER$22); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetShowRuler() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWRULER$22);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(SHOWRULER$22); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetShowRuler() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SHOWRULER$22) != null);
    } 
  }
  
  public void setShowRuler(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWRULER$22);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SHOWRULER$22); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetShowRuler(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWRULER$22);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SHOWRULER$22); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetShowRuler() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SHOWRULER$22);
    } 
  }
  
  public boolean getShowOutlineSymbols() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWOUTLINESYMBOLS$24);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SHOWOUTLINESYMBOLS$24); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetShowOutlineSymbols() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWOUTLINESYMBOLS$24);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(SHOWOUTLINESYMBOLS$24); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetShowOutlineSymbols() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SHOWOUTLINESYMBOLS$24) != null);
    } 
  }
  
  public void setShowOutlineSymbols(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWOUTLINESYMBOLS$24);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SHOWOUTLINESYMBOLS$24); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetShowOutlineSymbols(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWOUTLINESYMBOLS$24);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SHOWOUTLINESYMBOLS$24); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetShowOutlineSymbols() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SHOWOUTLINESYMBOLS$24);
    } 
  }
  
  public boolean getDefaultGridColor() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DEFAULTGRIDCOLOR$26);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(DEFAULTGRIDCOLOR$26); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetDefaultGridColor() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(DEFAULTGRIDCOLOR$26);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(DEFAULTGRIDCOLOR$26); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetDefaultGridColor() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DEFAULTGRIDCOLOR$26) != null);
    } 
  }
  
  public void setDefaultGridColor(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DEFAULTGRIDCOLOR$26);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DEFAULTGRIDCOLOR$26); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetDefaultGridColor(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(DEFAULTGRIDCOLOR$26);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(DEFAULTGRIDCOLOR$26); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetDefaultGridColor() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DEFAULTGRIDCOLOR$26);
    } 
  }
  
  public boolean getShowWhiteSpace() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWWHITESPACE$28);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SHOWWHITESPACE$28); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetShowWhiteSpace() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWWHITESPACE$28);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(SHOWWHITESPACE$28); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetShowWhiteSpace() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SHOWWHITESPACE$28) != null);
    } 
  }
  
  public void setShowWhiteSpace(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWWHITESPACE$28);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SHOWWHITESPACE$28); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetShowWhiteSpace(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWWHITESPACE$28);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SHOWWHITESPACE$28); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetShowWhiteSpace() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SHOWWHITESPACE$28);
    } 
  }
  
  public STSheetViewType.Enum getView() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VIEW$30);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(VIEW$30); 
      if (simpleValue == null)
        return null; 
      return (STSheetViewType.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STSheetViewType xgetView() {
    synchronized (monitor()) {
      check_orphaned();
      STSheetViewType sTSheetViewType = null;
      sTSheetViewType = (STSheetViewType)get_store().find_attribute_user(VIEW$30);
      if (sTSheetViewType == null)
        sTSheetViewType = (STSheetViewType)get_default_attribute_value(VIEW$30); 
      return sTSheetViewType;
    } 
  }
  
  public boolean isSetView() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(VIEW$30) != null);
    } 
  }
  
  public void setView(STSheetViewType.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VIEW$30);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(VIEW$30); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetView(STSheetViewType paramSTSheetViewType) {
    synchronized (monitor()) {
      check_orphaned();
      STSheetViewType sTSheetViewType = null;
      sTSheetViewType = (STSheetViewType)get_store().find_attribute_user(VIEW$30);
      if (sTSheetViewType == null)
        sTSheetViewType = (STSheetViewType)get_store().add_attribute_user(VIEW$30); 
      sTSheetViewType.set((XmlObject)paramSTSheetViewType);
    } 
  }
  
  public void unsetView() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(VIEW$30);
    } 
  }
  
  public String getTopLeftCell() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TOPLEFTCELL$32);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STCellRef xgetTopLeftCell() {
    synchronized (monitor()) {
      check_orphaned();
      STCellRef sTCellRef = null;
      sTCellRef = (STCellRef)get_store().find_attribute_user(TOPLEFTCELL$32);
      return sTCellRef;
    } 
  }
  
  public boolean isSetTopLeftCell() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(TOPLEFTCELL$32) != null);
    } 
  }
  
  public void setTopLeftCell(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TOPLEFTCELL$32);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TOPLEFTCELL$32); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetTopLeftCell(STCellRef paramSTCellRef) {
    synchronized (monitor()) {
      check_orphaned();
      STCellRef sTCellRef = null;
      sTCellRef = (STCellRef)get_store().find_attribute_user(TOPLEFTCELL$32);
      if (sTCellRef == null)
        sTCellRef = (STCellRef)get_store().add_attribute_user(TOPLEFTCELL$32); 
      sTCellRef.set((XmlObject)paramSTCellRef);
    } 
  }
  
  public void unsetTopLeftCell() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(TOPLEFTCELL$32);
    } 
  }
  
  public long getColorId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COLORID$34);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(COLORID$34); 
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetColorId() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(COLORID$34);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_default_attribute_value(COLORID$34); 
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetColorId() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(COLORID$34) != null);
    } 
  }
  
  public void setColorId(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COLORID$34);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(COLORID$34); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetColorId(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(COLORID$34);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(COLORID$34); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetColorId() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(COLORID$34);
    } 
  }
  
  public long getZoomScale() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ZOOMSCALE$36);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(ZOOMSCALE$36); 
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetZoomScale() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(ZOOMSCALE$36);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_default_attribute_value(ZOOMSCALE$36); 
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetZoomScale() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ZOOMSCALE$36) != null);
    } 
  }
  
  public void setZoomScale(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ZOOMSCALE$36);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ZOOMSCALE$36); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetZoomScale(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(ZOOMSCALE$36);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(ZOOMSCALE$36); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetZoomScale() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ZOOMSCALE$36);
    } 
  }
  
  public long getZoomScaleNormal() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ZOOMSCALENORMAL$38);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(ZOOMSCALENORMAL$38); 
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetZoomScaleNormal() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(ZOOMSCALENORMAL$38);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_default_attribute_value(ZOOMSCALENORMAL$38); 
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetZoomScaleNormal() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ZOOMSCALENORMAL$38) != null);
    } 
  }
  
  public void setZoomScaleNormal(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ZOOMSCALENORMAL$38);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ZOOMSCALENORMAL$38); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetZoomScaleNormal(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(ZOOMSCALENORMAL$38);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(ZOOMSCALENORMAL$38); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetZoomScaleNormal() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ZOOMSCALENORMAL$38);
    } 
  }
  
  public long getZoomScaleSheetLayoutView() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ZOOMSCALESHEETLAYOUTVIEW$40);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(ZOOMSCALESHEETLAYOUTVIEW$40); 
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetZoomScaleSheetLayoutView() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(ZOOMSCALESHEETLAYOUTVIEW$40);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_default_attribute_value(ZOOMSCALESHEETLAYOUTVIEW$40); 
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetZoomScaleSheetLayoutView() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ZOOMSCALESHEETLAYOUTVIEW$40) != null);
    } 
  }
  
  public void setZoomScaleSheetLayoutView(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ZOOMSCALESHEETLAYOUTVIEW$40);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ZOOMSCALESHEETLAYOUTVIEW$40); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetZoomScaleSheetLayoutView(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(ZOOMSCALESHEETLAYOUTVIEW$40);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(ZOOMSCALESHEETLAYOUTVIEW$40); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetZoomScaleSheetLayoutView() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ZOOMSCALESHEETLAYOUTVIEW$40);
    } 
  }
  
  public long getZoomScalePageLayoutView() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ZOOMSCALEPAGELAYOUTVIEW$42);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(ZOOMSCALEPAGELAYOUTVIEW$42); 
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetZoomScalePageLayoutView() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(ZOOMSCALEPAGELAYOUTVIEW$42);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_default_attribute_value(ZOOMSCALEPAGELAYOUTVIEW$42); 
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetZoomScalePageLayoutView() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ZOOMSCALEPAGELAYOUTVIEW$42) != null);
    } 
  }
  
  public void setZoomScalePageLayoutView(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ZOOMSCALEPAGELAYOUTVIEW$42);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ZOOMSCALEPAGELAYOUTVIEW$42); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetZoomScalePageLayoutView(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(ZOOMSCALEPAGELAYOUTVIEW$42);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(ZOOMSCALEPAGELAYOUTVIEW$42); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetZoomScalePageLayoutView() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ZOOMSCALEPAGELAYOUTVIEW$42);
    } 
  }
  
  public long getWorkbookViewId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(WORKBOOKVIEWID$44);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetWorkbookViewId() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(WORKBOOKVIEWID$44);
      return xmlUnsignedInt;
    } 
  }
  
  public void setWorkbookViewId(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(WORKBOOKVIEWID$44);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(WORKBOOKVIEWID$44); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetWorkbookViewId(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(WORKBOOKVIEWID$44);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(WORKBOOKVIEWID$44); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTSheetViewImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */