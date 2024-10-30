package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColor;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOutlinePr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetUpPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STRef;

public class CTSheetPrImpl extends XmlComplexContentImpl implements CTSheetPr {
  private static final b TABCOLOR$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "tabColor");
  
  private static final b OUTLINEPR$2 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "outlinePr");
  
  private static final b PAGESETUPPR$4 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "pageSetUpPr");
  
  private static final b SYNCHORIZONTAL$6 = new b("", "syncHorizontal");
  
  private static final b SYNCVERTICAL$8 = new b("", "syncVertical");
  
  private static final b SYNCREF$10 = new b("", "syncRef");
  
  private static final b TRANSITIONEVALUATION$12 = new b("", "transitionEvaluation");
  
  private static final b TRANSITIONENTRY$14 = new b("", "transitionEntry");
  
  private static final b PUBLISHED$16 = new b("", "published");
  
  private static final b CODENAME$18 = new b("", "codeName");
  
  private static final b FILTERMODE$20 = new b("", "filterMode");
  
  private static final b ENABLEFORMATCONDITIONSCALCULATION$22 = new b("", "enableFormatConditionsCalculation");
  
  public CTSheetPrImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTColor getTabColor() {
    synchronized (monitor()) {
      check_orphaned();
      CTColor cTColor = null;
      cTColor = (CTColor)get_store().find_element_user(TABCOLOR$0, 0);
      if (cTColor == null)
        return null; 
      return cTColor;
    } 
  }
  
  public boolean isSetTabColor() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TABCOLOR$0) != 0);
    } 
  }
  
  public void setTabColor(CTColor paramCTColor) {
    synchronized (monitor()) {
      check_orphaned();
      CTColor cTColor = null;
      cTColor = (CTColor)get_store().find_element_user(TABCOLOR$0, 0);
      if (cTColor == null)
        cTColor = (CTColor)get_store().add_element_user(TABCOLOR$0); 
      cTColor.set((XmlObject)paramCTColor);
    } 
  }
  
  public CTColor addNewTabColor() {
    synchronized (monitor()) {
      check_orphaned();
      CTColor cTColor = null;
      cTColor = (CTColor)get_store().add_element_user(TABCOLOR$0);
      return cTColor;
    } 
  }
  
  public void unsetTabColor() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TABCOLOR$0, 0);
    } 
  }
  
  public CTOutlinePr getOutlinePr() {
    synchronized (monitor()) {
      check_orphaned();
      CTOutlinePr cTOutlinePr = null;
      cTOutlinePr = (CTOutlinePr)get_store().find_element_user(OUTLINEPR$2, 0);
      if (cTOutlinePr == null)
        return null; 
      return cTOutlinePr;
    } 
  }
  
  public boolean isSetOutlinePr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(OUTLINEPR$2) != 0);
    } 
  }
  
  public void setOutlinePr(CTOutlinePr paramCTOutlinePr) {
    synchronized (monitor()) {
      check_orphaned();
      CTOutlinePr cTOutlinePr = null;
      cTOutlinePr = (CTOutlinePr)get_store().find_element_user(OUTLINEPR$2, 0);
      if (cTOutlinePr == null)
        cTOutlinePr = (CTOutlinePr)get_store().add_element_user(OUTLINEPR$2); 
      cTOutlinePr.set((XmlObject)paramCTOutlinePr);
    } 
  }
  
  public CTOutlinePr addNewOutlinePr() {
    synchronized (monitor()) {
      check_orphaned();
      CTOutlinePr cTOutlinePr = null;
      cTOutlinePr = (CTOutlinePr)get_store().add_element_user(OUTLINEPR$2);
      return cTOutlinePr;
    } 
  }
  
  public void unsetOutlinePr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(OUTLINEPR$2, 0);
    } 
  }
  
  public CTPageSetUpPr getPageSetUpPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTPageSetUpPr cTPageSetUpPr = null;
      cTPageSetUpPr = (CTPageSetUpPr)get_store().find_element_user(PAGESETUPPR$4, 0);
      if (cTPageSetUpPr == null)
        return null; 
      return cTPageSetUpPr;
    } 
  }
  
  public boolean isSetPageSetUpPr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PAGESETUPPR$4) != 0);
    } 
  }
  
  public void setPageSetUpPr(CTPageSetUpPr paramCTPageSetUpPr) {
    synchronized (monitor()) {
      check_orphaned();
      CTPageSetUpPr cTPageSetUpPr = null;
      cTPageSetUpPr = (CTPageSetUpPr)get_store().find_element_user(PAGESETUPPR$4, 0);
      if (cTPageSetUpPr == null)
        cTPageSetUpPr = (CTPageSetUpPr)get_store().add_element_user(PAGESETUPPR$4); 
      cTPageSetUpPr.set((XmlObject)paramCTPageSetUpPr);
    } 
  }
  
  public CTPageSetUpPr addNewPageSetUpPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTPageSetUpPr cTPageSetUpPr = null;
      cTPageSetUpPr = (CTPageSetUpPr)get_store().add_element_user(PAGESETUPPR$4);
      return cTPageSetUpPr;
    } 
  }
  
  public void unsetPageSetUpPr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PAGESETUPPR$4, 0);
    } 
  }
  
  public boolean getSyncHorizontal() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SYNCHORIZONTAL$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SYNCHORIZONTAL$6); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetSyncHorizontal() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SYNCHORIZONTAL$6);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(SYNCHORIZONTAL$6); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetSyncHorizontal() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SYNCHORIZONTAL$6) != null);
    } 
  }
  
  public void setSyncHorizontal(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SYNCHORIZONTAL$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SYNCHORIZONTAL$6); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetSyncHorizontal(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SYNCHORIZONTAL$6);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SYNCHORIZONTAL$6); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetSyncHorizontal() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SYNCHORIZONTAL$6);
    } 
  }
  
  public boolean getSyncVertical() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SYNCVERTICAL$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SYNCVERTICAL$8); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetSyncVertical() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SYNCVERTICAL$8);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(SYNCVERTICAL$8); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetSyncVertical() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SYNCVERTICAL$8) != null);
    } 
  }
  
  public void setSyncVertical(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SYNCVERTICAL$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SYNCVERTICAL$8); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetSyncVertical(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SYNCVERTICAL$8);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SYNCVERTICAL$8); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetSyncVertical() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SYNCVERTICAL$8);
    } 
  }
  
  public String getSyncRef() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SYNCREF$10);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STRef xgetSyncRef() {
    synchronized (monitor()) {
      check_orphaned();
      STRef sTRef = null;
      sTRef = (STRef)get_store().find_attribute_user(SYNCREF$10);
      return sTRef;
    } 
  }
  
  public boolean isSetSyncRef() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SYNCREF$10) != null);
    } 
  }
  
  public void setSyncRef(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SYNCREF$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SYNCREF$10); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetSyncRef(STRef paramSTRef) {
    synchronized (monitor()) {
      check_orphaned();
      STRef sTRef = null;
      sTRef = (STRef)get_store().find_attribute_user(SYNCREF$10);
      if (sTRef == null)
        sTRef = (STRef)get_store().add_attribute_user(SYNCREF$10); 
      sTRef.set((XmlObject)paramSTRef);
    } 
  }
  
  public void unsetSyncRef() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SYNCREF$10);
    } 
  }
  
  public boolean getTransitionEvaluation() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TRANSITIONEVALUATION$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(TRANSITIONEVALUATION$12); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetTransitionEvaluation() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(TRANSITIONEVALUATION$12);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(TRANSITIONEVALUATION$12); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetTransitionEvaluation() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(TRANSITIONEVALUATION$12) != null);
    } 
  }
  
  public void setTransitionEvaluation(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TRANSITIONEVALUATION$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TRANSITIONEVALUATION$12); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetTransitionEvaluation(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(TRANSITIONEVALUATION$12);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(TRANSITIONEVALUATION$12); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetTransitionEvaluation() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(TRANSITIONEVALUATION$12);
    } 
  }
  
  public boolean getTransitionEntry() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TRANSITIONENTRY$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(TRANSITIONENTRY$14); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetTransitionEntry() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(TRANSITIONENTRY$14);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(TRANSITIONENTRY$14); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetTransitionEntry() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(TRANSITIONENTRY$14) != null);
    } 
  }
  
  public void setTransitionEntry(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TRANSITIONENTRY$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TRANSITIONENTRY$14); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetTransitionEntry(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(TRANSITIONENTRY$14);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(TRANSITIONENTRY$14); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetTransitionEntry() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(TRANSITIONENTRY$14);
    } 
  }
  
  public boolean getPublished() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PUBLISHED$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(PUBLISHED$16); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetPublished() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(PUBLISHED$16);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(PUBLISHED$16); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetPublished() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(PUBLISHED$16) != null);
    } 
  }
  
  public void setPublished(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PUBLISHED$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(PUBLISHED$16); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetPublished(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(PUBLISHED$16);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(PUBLISHED$16); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetPublished() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(PUBLISHED$16);
    } 
  }
  
  public String getCodeName() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CODENAME$18);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetCodeName() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(CODENAME$18);
      return xmlString;
    } 
  }
  
  public boolean isSetCodeName() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(CODENAME$18) != null);
    } 
  }
  
  public void setCodeName(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CODENAME$18);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CODENAME$18); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetCodeName(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(CODENAME$18);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(CODENAME$18); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetCodeName() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(CODENAME$18);
    } 
  }
  
  public boolean getFilterMode() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FILTERMODE$20);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(FILTERMODE$20); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetFilterMode() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(FILTERMODE$20);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(FILTERMODE$20); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetFilterMode() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(FILTERMODE$20) != null);
    } 
  }
  
  public void setFilterMode(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FILTERMODE$20);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FILTERMODE$20); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetFilterMode(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(FILTERMODE$20);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(FILTERMODE$20); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetFilterMode() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(FILTERMODE$20);
    } 
  }
  
  public boolean getEnableFormatConditionsCalculation() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ENABLEFORMATCONDITIONSCALCULATION$22);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(ENABLEFORMATCONDITIONSCALCULATION$22); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetEnableFormatConditionsCalculation() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ENABLEFORMATCONDITIONSCALCULATION$22);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(ENABLEFORMATCONDITIONSCALCULATION$22); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetEnableFormatConditionsCalculation() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ENABLEFORMATCONDITIONSCALCULATION$22) != null);
    } 
  }
  
  public void setEnableFormatConditionsCalculation(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ENABLEFORMATCONDITIONSCALCULATION$22);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ENABLEFORMATCONDITIONSCALCULATION$22); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetEnableFormatConditionsCalculation(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ENABLEFORMATCONDITIONSCALCULATION$22);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(ENABLEFORMATCONDITIONSCALCULATION$22); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetEnableFormatConditionsCalculation() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ENABLEFORMATCONDITIONSCALCULATION$22);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTSheetPrImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */