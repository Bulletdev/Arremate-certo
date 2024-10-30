package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBoolean;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTDispBlanksAs;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPivotFmts;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTSurface;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTTitle;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTView3D;

public class CTChartImpl extends XmlComplexContentImpl implements CTChart {
  private static final b TITLE$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "title");
  
  private static final b AUTOTITLEDELETED$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "autoTitleDeleted");
  
  private static final b PIVOTFMTS$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "pivotFmts");
  
  private static final b VIEW3D$6 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "view3D");
  
  private static final b FLOOR$8 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "floor");
  
  private static final b SIDEWALL$10 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "sideWall");
  
  private static final b BACKWALL$12 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "backWall");
  
  private static final b PLOTAREA$14 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "plotArea");
  
  private static final b LEGEND$16 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "legend");
  
  private static final b PLOTVISONLY$18 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "plotVisOnly");
  
  private static final b DISPBLANKSAS$20 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "dispBlanksAs");
  
  private static final b SHOWDLBLSOVERMAX$22 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "showDLblsOverMax");
  
  private static final b EXTLST$24 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "extLst");
  
  public CTChartImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTTitle getTitle() {
    synchronized (monitor()) {
      check_orphaned();
      CTTitle cTTitle = null;
      cTTitle = (CTTitle)get_store().find_element_user(TITLE$0, 0);
      if (cTTitle == null)
        return null; 
      return cTTitle;
    } 
  }
  
  public boolean isSetTitle() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TITLE$0) != 0);
    } 
  }
  
  public void setTitle(CTTitle paramCTTitle) {
    synchronized (monitor()) {
      check_orphaned();
      CTTitle cTTitle = null;
      cTTitle = (CTTitle)get_store().find_element_user(TITLE$0, 0);
      if (cTTitle == null)
        cTTitle = (CTTitle)get_store().add_element_user(TITLE$0); 
      cTTitle.set((XmlObject)paramCTTitle);
    } 
  }
  
  public CTTitle addNewTitle() {
    synchronized (monitor()) {
      check_orphaned();
      CTTitle cTTitle = null;
      cTTitle = (CTTitle)get_store().add_element_user(TITLE$0);
      return cTTitle;
    } 
  }
  
  public void unsetTitle() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TITLE$0, 0);
    } 
  }
  
  public CTBoolean getAutoTitleDeleted() {
    synchronized (monitor()) {
      check_orphaned();
      CTBoolean cTBoolean = null;
      cTBoolean = (CTBoolean)get_store().find_element_user(AUTOTITLEDELETED$2, 0);
      if (cTBoolean == null)
        return null; 
      return cTBoolean;
    } 
  }
  
  public boolean isSetAutoTitleDeleted() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(AUTOTITLEDELETED$2) != 0);
    } 
  }
  
  public void setAutoTitleDeleted(CTBoolean paramCTBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      CTBoolean cTBoolean = null;
      cTBoolean = (CTBoolean)get_store().find_element_user(AUTOTITLEDELETED$2, 0);
      if (cTBoolean == null)
        cTBoolean = (CTBoolean)get_store().add_element_user(AUTOTITLEDELETED$2); 
      cTBoolean.set((XmlObject)paramCTBoolean);
    } 
  }
  
  public CTBoolean addNewAutoTitleDeleted() {
    synchronized (monitor()) {
      check_orphaned();
      CTBoolean cTBoolean = null;
      cTBoolean = (CTBoolean)get_store().add_element_user(AUTOTITLEDELETED$2);
      return cTBoolean;
    } 
  }
  
  public void unsetAutoTitleDeleted() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(AUTOTITLEDELETED$2, 0);
    } 
  }
  
  public CTPivotFmts getPivotFmts() {
    synchronized (monitor()) {
      check_orphaned();
      CTPivotFmts cTPivotFmts = null;
      cTPivotFmts = (CTPivotFmts)get_store().find_element_user(PIVOTFMTS$4, 0);
      if (cTPivotFmts == null)
        return null; 
      return cTPivotFmts;
    } 
  }
  
  public boolean isSetPivotFmts() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PIVOTFMTS$4) != 0);
    } 
  }
  
  public void setPivotFmts(CTPivotFmts paramCTPivotFmts) {
    synchronized (monitor()) {
      check_orphaned();
      CTPivotFmts cTPivotFmts = null;
      cTPivotFmts = (CTPivotFmts)get_store().find_element_user(PIVOTFMTS$4, 0);
      if (cTPivotFmts == null)
        cTPivotFmts = (CTPivotFmts)get_store().add_element_user(PIVOTFMTS$4); 
      cTPivotFmts.set((XmlObject)paramCTPivotFmts);
    } 
  }
  
  public CTPivotFmts addNewPivotFmts() {
    synchronized (monitor()) {
      check_orphaned();
      CTPivotFmts cTPivotFmts = null;
      cTPivotFmts = (CTPivotFmts)get_store().add_element_user(PIVOTFMTS$4);
      return cTPivotFmts;
    } 
  }
  
  public void unsetPivotFmts() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PIVOTFMTS$4, 0);
    } 
  }
  
  public CTView3D getView3D() {
    synchronized (monitor()) {
      check_orphaned();
      CTView3D cTView3D = null;
      cTView3D = (CTView3D)get_store().find_element_user(VIEW3D$6, 0);
      if (cTView3D == null)
        return null; 
      return cTView3D;
    } 
  }
  
  public boolean isSetView3D() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(VIEW3D$6) != 0);
    } 
  }
  
  public void setView3D(CTView3D paramCTView3D) {
    synchronized (monitor()) {
      check_orphaned();
      CTView3D cTView3D = null;
      cTView3D = (CTView3D)get_store().find_element_user(VIEW3D$6, 0);
      if (cTView3D == null)
        cTView3D = (CTView3D)get_store().add_element_user(VIEW3D$6); 
      cTView3D.set((XmlObject)paramCTView3D);
    } 
  }
  
  public CTView3D addNewView3D() {
    synchronized (monitor()) {
      check_orphaned();
      CTView3D cTView3D = null;
      cTView3D = (CTView3D)get_store().add_element_user(VIEW3D$6);
      return cTView3D;
    } 
  }
  
  public void unsetView3D() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(VIEW3D$6, 0);
    } 
  }
  
  public CTSurface getFloor() {
    synchronized (monitor()) {
      check_orphaned();
      CTSurface cTSurface = null;
      cTSurface = (CTSurface)get_store().find_element_user(FLOOR$8, 0);
      if (cTSurface == null)
        return null; 
      return cTSurface;
    } 
  }
  
  public boolean isSetFloor() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(FLOOR$8) != 0);
    } 
  }
  
  public void setFloor(CTSurface paramCTSurface) {
    synchronized (monitor()) {
      check_orphaned();
      CTSurface cTSurface = null;
      cTSurface = (CTSurface)get_store().find_element_user(FLOOR$8, 0);
      if (cTSurface == null)
        cTSurface = (CTSurface)get_store().add_element_user(FLOOR$8); 
      cTSurface.set((XmlObject)paramCTSurface);
    } 
  }
  
  public CTSurface addNewFloor() {
    synchronized (monitor()) {
      check_orphaned();
      CTSurface cTSurface = null;
      cTSurface = (CTSurface)get_store().add_element_user(FLOOR$8);
      return cTSurface;
    } 
  }
  
  public void unsetFloor() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(FLOOR$8, 0);
    } 
  }
  
  public CTSurface getSideWall() {
    synchronized (monitor()) {
      check_orphaned();
      CTSurface cTSurface = null;
      cTSurface = (CTSurface)get_store().find_element_user(SIDEWALL$10, 0);
      if (cTSurface == null)
        return null; 
      return cTSurface;
    } 
  }
  
  public boolean isSetSideWall() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SIDEWALL$10) != 0);
    } 
  }
  
  public void setSideWall(CTSurface paramCTSurface) {
    synchronized (monitor()) {
      check_orphaned();
      CTSurface cTSurface = null;
      cTSurface = (CTSurface)get_store().find_element_user(SIDEWALL$10, 0);
      if (cTSurface == null)
        cTSurface = (CTSurface)get_store().add_element_user(SIDEWALL$10); 
      cTSurface.set((XmlObject)paramCTSurface);
    } 
  }
  
  public CTSurface addNewSideWall() {
    synchronized (monitor()) {
      check_orphaned();
      CTSurface cTSurface = null;
      cTSurface = (CTSurface)get_store().add_element_user(SIDEWALL$10);
      return cTSurface;
    } 
  }
  
  public void unsetSideWall() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SIDEWALL$10, 0);
    } 
  }
  
  public CTSurface getBackWall() {
    synchronized (monitor()) {
      check_orphaned();
      CTSurface cTSurface = null;
      cTSurface = (CTSurface)get_store().find_element_user(BACKWALL$12, 0);
      if (cTSurface == null)
        return null; 
      return cTSurface;
    } 
  }
  
  public boolean isSetBackWall() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(BACKWALL$12) != 0);
    } 
  }
  
  public void setBackWall(CTSurface paramCTSurface) {
    synchronized (monitor()) {
      check_orphaned();
      CTSurface cTSurface = null;
      cTSurface = (CTSurface)get_store().find_element_user(BACKWALL$12, 0);
      if (cTSurface == null)
        cTSurface = (CTSurface)get_store().add_element_user(BACKWALL$12); 
      cTSurface.set((XmlObject)paramCTSurface);
    } 
  }
  
  public CTSurface addNewBackWall() {
    synchronized (monitor()) {
      check_orphaned();
      CTSurface cTSurface = null;
      cTSurface = (CTSurface)get_store().add_element_user(BACKWALL$12);
      return cTSurface;
    } 
  }
  
  public void unsetBackWall() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BACKWALL$12, 0);
    } 
  }
  
  public CTPlotArea getPlotArea() {
    synchronized (monitor()) {
      check_orphaned();
      CTPlotArea cTPlotArea = null;
      cTPlotArea = (CTPlotArea)get_store().find_element_user(PLOTAREA$14, 0);
      if (cTPlotArea == null)
        return null; 
      return cTPlotArea;
    } 
  }
  
  public void setPlotArea(CTPlotArea paramCTPlotArea) {
    synchronized (monitor()) {
      check_orphaned();
      CTPlotArea cTPlotArea = null;
      cTPlotArea = (CTPlotArea)get_store().find_element_user(PLOTAREA$14, 0);
      if (cTPlotArea == null)
        cTPlotArea = (CTPlotArea)get_store().add_element_user(PLOTAREA$14); 
      cTPlotArea.set((XmlObject)paramCTPlotArea);
    } 
  }
  
  public CTPlotArea addNewPlotArea() {
    synchronized (monitor()) {
      check_orphaned();
      CTPlotArea cTPlotArea = null;
      cTPlotArea = (CTPlotArea)get_store().add_element_user(PLOTAREA$14);
      return cTPlotArea;
    } 
  }
  
  public CTLegend getLegend() {
    synchronized (monitor()) {
      check_orphaned();
      CTLegend cTLegend = null;
      cTLegend = (CTLegend)get_store().find_element_user(LEGEND$16, 0);
      if (cTLegend == null)
        return null; 
      return cTLegend;
    } 
  }
  
  public boolean isSetLegend() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(LEGEND$16) != 0);
    } 
  }
  
  public void setLegend(CTLegend paramCTLegend) {
    synchronized (monitor()) {
      check_orphaned();
      CTLegend cTLegend = null;
      cTLegend = (CTLegend)get_store().find_element_user(LEGEND$16, 0);
      if (cTLegend == null)
        cTLegend = (CTLegend)get_store().add_element_user(LEGEND$16); 
      cTLegend.set((XmlObject)paramCTLegend);
    } 
  }
  
  public CTLegend addNewLegend() {
    synchronized (monitor()) {
      check_orphaned();
      CTLegend cTLegend = null;
      cTLegend = (CTLegend)get_store().add_element_user(LEGEND$16);
      return cTLegend;
    } 
  }
  
  public void unsetLegend() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LEGEND$16, 0);
    } 
  }
  
  public CTBoolean getPlotVisOnly() {
    synchronized (monitor()) {
      check_orphaned();
      CTBoolean cTBoolean = null;
      cTBoolean = (CTBoolean)get_store().find_element_user(PLOTVISONLY$18, 0);
      if (cTBoolean == null)
        return null; 
      return cTBoolean;
    } 
  }
  
  public boolean isSetPlotVisOnly() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PLOTVISONLY$18) != 0);
    } 
  }
  
  public void setPlotVisOnly(CTBoolean paramCTBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      CTBoolean cTBoolean = null;
      cTBoolean = (CTBoolean)get_store().find_element_user(PLOTVISONLY$18, 0);
      if (cTBoolean == null)
        cTBoolean = (CTBoolean)get_store().add_element_user(PLOTVISONLY$18); 
      cTBoolean.set((XmlObject)paramCTBoolean);
    } 
  }
  
  public CTBoolean addNewPlotVisOnly() {
    synchronized (monitor()) {
      check_orphaned();
      CTBoolean cTBoolean = null;
      cTBoolean = (CTBoolean)get_store().add_element_user(PLOTVISONLY$18);
      return cTBoolean;
    } 
  }
  
  public void unsetPlotVisOnly() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PLOTVISONLY$18, 0);
    } 
  }
  
  public CTDispBlanksAs getDispBlanksAs() {
    synchronized (monitor()) {
      check_orphaned();
      CTDispBlanksAs cTDispBlanksAs = null;
      cTDispBlanksAs = (CTDispBlanksAs)get_store().find_element_user(DISPBLANKSAS$20, 0);
      if (cTDispBlanksAs == null)
        return null; 
      return cTDispBlanksAs;
    } 
  }
  
  public boolean isSetDispBlanksAs() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DISPBLANKSAS$20) != 0);
    } 
  }
  
  public void setDispBlanksAs(CTDispBlanksAs paramCTDispBlanksAs) {
    synchronized (monitor()) {
      check_orphaned();
      CTDispBlanksAs cTDispBlanksAs = null;
      cTDispBlanksAs = (CTDispBlanksAs)get_store().find_element_user(DISPBLANKSAS$20, 0);
      if (cTDispBlanksAs == null)
        cTDispBlanksAs = (CTDispBlanksAs)get_store().add_element_user(DISPBLANKSAS$20); 
      cTDispBlanksAs.set((XmlObject)paramCTDispBlanksAs);
    } 
  }
  
  public CTDispBlanksAs addNewDispBlanksAs() {
    synchronized (monitor()) {
      check_orphaned();
      CTDispBlanksAs cTDispBlanksAs = null;
      cTDispBlanksAs = (CTDispBlanksAs)get_store().add_element_user(DISPBLANKSAS$20);
      return cTDispBlanksAs;
    } 
  }
  
  public void unsetDispBlanksAs() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DISPBLANKSAS$20, 0);
    } 
  }
  
  public CTBoolean getShowDLblsOverMax() {
    synchronized (monitor()) {
      check_orphaned();
      CTBoolean cTBoolean = null;
      cTBoolean = (CTBoolean)get_store().find_element_user(SHOWDLBLSOVERMAX$22, 0);
      if (cTBoolean == null)
        return null; 
      return cTBoolean;
    } 
  }
  
  public boolean isSetShowDLblsOverMax() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SHOWDLBLSOVERMAX$22) != 0);
    } 
  }
  
  public void setShowDLblsOverMax(CTBoolean paramCTBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      CTBoolean cTBoolean = null;
      cTBoolean = (CTBoolean)get_store().find_element_user(SHOWDLBLSOVERMAX$22, 0);
      if (cTBoolean == null)
        cTBoolean = (CTBoolean)get_store().add_element_user(SHOWDLBLSOVERMAX$22); 
      cTBoolean.set((XmlObject)paramCTBoolean);
    } 
  }
  
  public CTBoolean addNewShowDLblsOverMax() {
    synchronized (monitor()) {
      check_orphaned();
      CTBoolean cTBoolean = null;
      cTBoolean = (CTBoolean)get_store().add_element_user(SHOWDLBLSOVERMAX$22);
      return cTBoolean;
    } 
  }
  
  public void unsetShowDLblsOverMax() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SHOWDLBLSOVERMAX$22, 0);
    } 
  }
  
  public CTExtensionList getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$24, 0);
      if (cTExtensionList == null)
        return null; 
      return cTExtensionList;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$24) != 0);
    } 
  }
  
  public void setExtLst(CTExtensionList paramCTExtensionList) {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$24, 0);
      if (cTExtensionList == null)
        cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$24); 
      cTExtensionList.set((XmlObject)paramCTExtensionList);
    } 
  }
  
  public CTExtensionList addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$24);
      return cTExtensionList;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$24, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\impl\CTChartImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */