package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBoolean;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTChartSpace;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTExternalData;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPivotSource;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPrintSettings;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTProtection;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTRelId;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTStyle;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTTextLanguageID;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;

public class CTChartSpaceImpl extends XmlComplexContentImpl implements CTChartSpace {
  private static final b DATE1904$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "date1904");
  
  private static final b LANG$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "lang");
  
  private static final b ROUNDEDCORNERS$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "roundedCorners");
  
  private static final b STYLE$6 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "style");
  
  private static final b CLRMAPOVR$8 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "clrMapOvr");
  
  private static final b PIVOTSOURCE$10 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "pivotSource");
  
  private static final b PROTECTION$12 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "protection");
  
  private static final b CHART$14 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "chart");
  
  private static final b SPPR$16 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "spPr");
  
  private static final b TXPR$18 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "txPr");
  
  private static final b EXTERNALDATA$20 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "externalData");
  
  private static final b PRINTSETTINGS$22 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "printSettings");
  
  private static final b USERSHAPES$24 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "userShapes");
  
  private static final b EXTLST$26 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "extLst");
  
  public CTChartSpaceImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTBoolean getDate1904() {
    synchronized (monitor()) {
      check_orphaned();
      CTBoolean cTBoolean = null;
      cTBoolean = (CTBoolean)get_store().find_element_user(DATE1904$0, 0);
      if (cTBoolean == null)
        return null; 
      return cTBoolean;
    } 
  }
  
  public boolean isSetDate1904() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DATE1904$0) != 0);
    } 
  }
  
  public void setDate1904(CTBoolean paramCTBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      CTBoolean cTBoolean = null;
      cTBoolean = (CTBoolean)get_store().find_element_user(DATE1904$0, 0);
      if (cTBoolean == null)
        cTBoolean = (CTBoolean)get_store().add_element_user(DATE1904$0); 
      cTBoolean.set((XmlObject)paramCTBoolean);
    } 
  }
  
  public CTBoolean addNewDate1904() {
    synchronized (monitor()) {
      check_orphaned();
      CTBoolean cTBoolean = null;
      cTBoolean = (CTBoolean)get_store().add_element_user(DATE1904$0);
      return cTBoolean;
    } 
  }
  
  public void unsetDate1904() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DATE1904$0, 0);
    } 
  }
  
  public CTTextLanguageID getLang() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextLanguageID cTTextLanguageID = null;
      cTTextLanguageID = (CTTextLanguageID)get_store().find_element_user(LANG$2, 0);
      if (cTTextLanguageID == null)
        return null; 
      return cTTextLanguageID;
    } 
  }
  
  public boolean isSetLang() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(LANG$2) != 0);
    } 
  }
  
  public void setLang(CTTextLanguageID paramCTTextLanguageID) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextLanguageID cTTextLanguageID = null;
      cTTextLanguageID = (CTTextLanguageID)get_store().find_element_user(LANG$2, 0);
      if (cTTextLanguageID == null)
        cTTextLanguageID = (CTTextLanguageID)get_store().add_element_user(LANG$2); 
      cTTextLanguageID.set((XmlObject)paramCTTextLanguageID);
    } 
  }
  
  public CTTextLanguageID addNewLang() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextLanguageID cTTextLanguageID = null;
      cTTextLanguageID = (CTTextLanguageID)get_store().add_element_user(LANG$2);
      return cTTextLanguageID;
    } 
  }
  
  public void unsetLang() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LANG$2, 0);
    } 
  }
  
  public CTBoolean getRoundedCorners() {
    synchronized (monitor()) {
      check_orphaned();
      CTBoolean cTBoolean = null;
      cTBoolean = (CTBoolean)get_store().find_element_user(ROUNDEDCORNERS$4, 0);
      if (cTBoolean == null)
        return null; 
      return cTBoolean;
    } 
  }
  
  public boolean isSetRoundedCorners() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(ROUNDEDCORNERS$4) != 0);
    } 
  }
  
  public void setRoundedCorners(CTBoolean paramCTBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      CTBoolean cTBoolean = null;
      cTBoolean = (CTBoolean)get_store().find_element_user(ROUNDEDCORNERS$4, 0);
      if (cTBoolean == null)
        cTBoolean = (CTBoolean)get_store().add_element_user(ROUNDEDCORNERS$4); 
      cTBoolean.set((XmlObject)paramCTBoolean);
    } 
  }
  
  public CTBoolean addNewRoundedCorners() {
    synchronized (monitor()) {
      check_orphaned();
      CTBoolean cTBoolean = null;
      cTBoolean = (CTBoolean)get_store().add_element_user(ROUNDEDCORNERS$4);
      return cTBoolean;
    } 
  }
  
  public void unsetRoundedCorners() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ROUNDEDCORNERS$4, 0);
    } 
  }
  
  public CTStyle getStyle() {
    synchronized (monitor()) {
      check_orphaned();
      CTStyle cTStyle = null;
      cTStyle = (CTStyle)get_store().find_element_user(STYLE$6, 0);
      if (cTStyle == null)
        return null; 
      return cTStyle;
    } 
  }
  
  public boolean isSetStyle() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(STYLE$6) != 0);
    } 
  }
  
  public void setStyle(CTStyle paramCTStyle) {
    synchronized (monitor()) {
      check_orphaned();
      CTStyle cTStyle = null;
      cTStyle = (CTStyle)get_store().find_element_user(STYLE$6, 0);
      if (cTStyle == null)
        cTStyle = (CTStyle)get_store().add_element_user(STYLE$6); 
      cTStyle.set((XmlObject)paramCTStyle);
    } 
  }
  
  public CTStyle addNewStyle() {
    synchronized (monitor()) {
      check_orphaned();
      CTStyle cTStyle = null;
      cTStyle = (CTStyle)get_store().add_element_user(STYLE$6);
      return cTStyle;
    } 
  }
  
  public void unsetStyle() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(STYLE$6, 0);
    } 
  }
  
  public CTColorMapping getClrMapOvr() {
    synchronized (monitor()) {
      check_orphaned();
      CTColorMapping cTColorMapping = null;
      cTColorMapping = (CTColorMapping)get_store().find_element_user(CLRMAPOVR$8, 0);
      if (cTColorMapping == null)
        return null; 
      return cTColorMapping;
    } 
  }
  
  public boolean isSetClrMapOvr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(CLRMAPOVR$8) != 0);
    } 
  }
  
  public void setClrMapOvr(CTColorMapping paramCTColorMapping) {
    synchronized (monitor()) {
      check_orphaned();
      CTColorMapping cTColorMapping = null;
      cTColorMapping = (CTColorMapping)get_store().find_element_user(CLRMAPOVR$8, 0);
      if (cTColorMapping == null)
        cTColorMapping = (CTColorMapping)get_store().add_element_user(CLRMAPOVR$8); 
      cTColorMapping.set((XmlObject)paramCTColorMapping);
    } 
  }
  
  public CTColorMapping addNewClrMapOvr() {
    synchronized (monitor()) {
      check_orphaned();
      CTColorMapping cTColorMapping = null;
      cTColorMapping = (CTColorMapping)get_store().add_element_user(CLRMAPOVR$8);
      return cTColorMapping;
    } 
  }
  
  public void unsetClrMapOvr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CLRMAPOVR$8, 0);
    } 
  }
  
  public CTPivotSource getPivotSource() {
    synchronized (monitor()) {
      check_orphaned();
      CTPivotSource cTPivotSource = null;
      cTPivotSource = (CTPivotSource)get_store().find_element_user(PIVOTSOURCE$10, 0);
      if (cTPivotSource == null)
        return null; 
      return cTPivotSource;
    } 
  }
  
  public boolean isSetPivotSource() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PIVOTSOURCE$10) != 0);
    } 
  }
  
  public void setPivotSource(CTPivotSource paramCTPivotSource) {
    synchronized (monitor()) {
      check_orphaned();
      CTPivotSource cTPivotSource = null;
      cTPivotSource = (CTPivotSource)get_store().find_element_user(PIVOTSOURCE$10, 0);
      if (cTPivotSource == null)
        cTPivotSource = (CTPivotSource)get_store().add_element_user(PIVOTSOURCE$10); 
      cTPivotSource.set((XmlObject)paramCTPivotSource);
    } 
  }
  
  public CTPivotSource addNewPivotSource() {
    synchronized (monitor()) {
      check_orphaned();
      CTPivotSource cTPivotSource = null;
      cTPivotSource = (CTPivotSource)get_store().add_element_user(PIVOTSOURCE$10);
      return cTPivotSource;
    } 
  }
  
  public void unsetPivotSource() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PIVOTSOURCE$10, 0);
    } 
  }
  
  public CTProtection getProtection() {
    synchronized (monitor()) {
      check_orphaned();
      CTProtection cTProtection = null;
      cTProtection = (CTProtection)get_store().find_element_user(PROTECTION$12, 0);
      if (cTProtection == null)
        return null; 
      return cTProtection;
    } 
  }
  
  public boolean isSetProtection() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PROTECTION$12) != 0);
    } 
  }
  
  public void setProtection(CTProtection paramCTProtection) {
    synchronized (monitor()) {
      check_orphaned();
      CTProtection cTProtection = null;
      cTProtection = (CTProtection)get_store().find_element_user(PROTECTION$12, 0);
      if (cTProtection == null)
        cTProtection = (CTProtection)get_store().add_element_user(PROTECTION$12); 
      cTProtection.set((XmlObject)paramCTProtection);
    } 
  }
  
  public CTProtection addNewProtection() {
    synchronized (monitor()) {
      check_orphaned();
      CTProtection cTProtection = null;
      cTProtection = (CTProtection)get_store().add_element_user(PROTECTION$12);
      return cTProtection;
    } 
  }
  
  public void unsetProtection() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PROTECTION$12, 0);
    } 
  }
  
  public CTChart getChart() {
    synchronized (monitor()) {
      check_orphaned();
      CTChart cTChart = null;
      cTChart = (CTChart)get_store().find_element_user(CHART$14, 0);
      if (cTChart == null)
        return null; 
      return cTChart;
    } 
  }
  
  public void setChart(CTChart paramCTChart) {
    synchronized (monitor()) {
      check_orphaned();
      CTChart cTChart = null;
      cTChart = (CTChart)get_store().find_element_user(CHART$14, 0);
      if (cTChart == null)
        cTChart = (CTChart)get_store().add_element_user(CHART$14); 
      cTChart.set((XmlObject)paramCTChart);
    } 
  }
  
  public CTChart addNewChart() {
    synchronized (monitor()) {
      check_orphaned();
      CTChart cTChart = null;
      cTChart = (CTChart)get_store().add_element_user(CHART$14);
      return cTChart;
    } 
  }
  
  public CTShapeProperties getSpPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTShapeProperties cTShapeProperties = null;
      cTShapeProperties = (CTShapeProperties)get_store().find_element_user(SPPR$16, 0);
      if (cTShapeProperties == null)
        return null; 
      return cTShapeProperties;
    } 
  }
  
  public boolean isSetSpPr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SPPR$16) != 0);
    } 
  }
  
  public void setSpPr(CTShapeProperties paramCTShapeProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTShapeProperties cTShapeProperties = null;
      cTShapeProperties = (CTShapeProperties)get_store().find_element_user(SPPR$16, 0);
      if (cTShapeProperties == null)
        cTShapeProperties = (CTShapeProperties)get_store().add_element_user(SPPR$16); 
      cTShapeProperties.set((XmlObject)paramCTShapeProperties);
    } 
  }
  
  public CTShapeProperties addNewSpPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTShapeProperties cTShapeProperties = null;
      cTShapeProperties = (CTShapeProperties)get_store().add_element_user(SPPR$16);
      return cTShapeProperties;
    } 
  }
  
  public void unsetSpPr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SPPR$16, 0);
    } 
  }
  
  public CTTextBody getTxPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextBody cTTextBody = null;
      cTTextBody = (CTTextBody)get_store().find_element_user(TXPR$18, 0);
      if (cTTextBody == null)
        return null; 
      return cTTextBody;
    } 
  }
  
  public boolean isSetTxPr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TXPR$18) != 0);
    } 
  }
  
  public void setTxPr(CTTextBody paramCTTextBody) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextBody cTTextBody = null;
      cTTextBody = (CTTextBody)get_store().find_element_user(TXPR$18, 0);
      if (cTTextBody == null)
        cTTextBody = (CTTextBody)get_store().add_element_user(TXPR$18); 
      cTTextBody.set((XmlObject)paramCTTextBody);
    } 
  }
  
  public CTTextBody addNewTxPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextBody cTTextBody = null;
      cTTextBody = (CTTextBody)get_store().add_element_user(TXPR$18);
      return cTTextBody;
    } 
  }
  
  public void unsetTxPr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TXPR$18, 0);
    } 
  }
  
  public CTExternalData getExternalData() {
    synchronized (monitor()) {
      check_orphaned();
      CTExternalData cTExternalData = null;
      cTExternalData = (CTExternalData)get_store().find_element_user(EXTERNALDATA$20, 0);
      if (cTExternalData == null)
        return null; 
      return cTExternalData;
    } 
  }
  
  public boolean isSetExternalData() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTERNALDATA$20) != 0);
    } 
  }
  
  public void setExternalData(CTExternalData paramCTExternalData) {
    synchronized (monitor()) {
      check_orphaned();
      CTExternalData cTExternalData = null;
      cTExternalData = (CTExternalData)get_store().find_element_user(EXTERNALDATA$20, 0);
      if (cTExternalData == null)
        cTExternalData = (CTExternalData)get_store().add_element_user(EXTERNALDATA$20); 
      cTExternalData.set((XmlObject)paramCTExternalData);
    } 
  }
  
  public CTExternalData addNewExternalData() {
    synchronized (monitor()) {
      check_orphaned();
      CTExternalData cTExternalData = null;
      cTExternalData = (CTExternalData)get_store().add_element_user(EXTERNALDATA$20);
      return cTExternalData;
    } 
  }
  
  public void unsetExternalData() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTERNALDATA$20, 0);
    } 
  }
  
  public CTPrintSettings getPrintSettings() {
    synchronized (monitor()) {
      check_orphaned();
      CTPrintSettings cTPrintSettings = null;
      cTPrintSettings = (CTPrintSettings)get_store().find_element_user(PRINTSETTINGS$22, 0);
      if (cTPrintSettings == null)
        return null; 
      return cTPrintSettings;
    } 
  }
  
  public boolean isSetPrintSettings() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PRINTSETTINGS$22) != 0);
    } 
  }
  
  public void setPrintSettings(CTPrintSettings paramCTPrintSettings) {
    synchronized (monitor()) {
      check_orphaned();
      CTPrintSettings cTPrintSettings = null;
      cTPrintSettings = (CTPrintSettings)get_store().find_element_user(PRINTSETTINGS$22, 0);
      if (cTPrintSettings == null)
        cTPrintSettings = (CTPrintSettings)get_store().add_element_user(PRINTSETTINGS$22); 
      cTPrintSettings.set((XmlObject)paramCTPrintSettings);
    } 
  }
  
  public CTPrintSettings addNewPrintSettings() {
    synchronized (monitor()) {
      check_orphaned();
      CTPrintSettings cTPrintSettings = null;
      cTPrintSettings = (CTPrintSettings)get_store().add_element_user(PRINTSETTINGS$22);
      return cTPrintSettings;
    } 
  }
  
  public void unsetPrintSettings() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PRINTSETTINGS$22, 0);
    } 
  }
  
  public CTRelId getUserShapes() {
    synchronized (monitor()) {
      check_orphaned();
      CTRelId cTRelId = null;
      cTRelId = (CTRelId)get_store().find_element_user(USERSHAPES$24, 0);
      if (cTRelId == null)
        return null; 
      return cTRelId;
    } 
  }
  
  public boolean isSetUserShapes() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(USERSHAPES$24) != 0);
    } 
  }
  
  public void setUserShapes(CTRelId paramCTRelId) {
    synchronized (monitor()) {
      check_orphaned();
      CTRelId cTRelId = null;
      cTRelId = (CTRelId)get_store().find_element_user(USERSHAPES$24, 0);
      if (cTRelId == null)
        cTRelId = (CTRelId)get_store().add_element_user(USERSHAPES$24); 
      cTRelId.set((XmlObject)paramCTRelId);
    } 
  }
  
  public CTRelId addNewUserShapes() {
    synchronized (monitor()) {
      check_orphaned();
      CTRelId cTRelId = null;
      cTRelId = (CTRelId)get_store().add_element_user(USERSHAPES$24);
      return cTRelId;
    } 
  }
  
  public void unsetUserShapes() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(USERSHAPES$24, 0);
    } 
  }
  
  public CTExtensionList getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$26, 0);
      if (cTExtensionList == null)
        return null; 
      return cTExtensionList;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$26) != 0);
    } 
  }
  
  public void setExtLst(CTExtensionList paramCTExtensionList) {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$26, 0);
      if (cTExtensionList == null)
        cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$26); 
      cTExtensionList.set((XmlObject)paramCTExtensionList);
    } 
  }
  
  public CTExtensionList addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$26);
      return cTExtensionList;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$26, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\impl\CTChartSpaceImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */