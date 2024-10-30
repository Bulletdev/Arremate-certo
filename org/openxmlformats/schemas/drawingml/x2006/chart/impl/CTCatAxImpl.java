package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTAxPos;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBoolean;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTChartLines;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTCrosses;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTDouble;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLblAlgn;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLblOffset;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumFmt;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTScaling;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTSkip;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTTickLblPos;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTTickMark;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTTitle;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTUnsignedInt;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;

public class CTCatAxImpl extends XmlComplexContentImpl implements CTCatAx {
  private static final b AXID$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "axId");
  
  private static final b SCALING$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "scaling");
  
  private static final b DELETE$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "delete");
  
  private static final b AXPOS$6 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "axPos");
  
  private static final b MAJORGRIDLINES$8 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "majorGridlines");
  
  private static final b MINORGRIDLINES$10 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "minorGridlines");
  
  private static final b TITLE$12 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "title");
  
  private static final b NUMFMT$14 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "numFmt");
  
  private static final b MAJORTICKMARK$16 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "majorTickMark");
  
  private static final b MINORTICKMARK$18 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "minorTickMark");
  
  private static final b TICKLBLPOS$20 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "tickLblPos");
  
  private static final b SPPR$22 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "spPr");
  
  private static final b TXPR$24 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "txPr");
  
  private static final b CROSSAX$26 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "crossAx");
  
  private static final b CROSSES$28 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "crosses");
  
  private static final b CROSSESAT$30 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "crossesAt");
  
  private static final b AUTO$32 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "auto");
  
  private static final b LBLALGN$34 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "lblAlgn");
  
  private static final b LBLOFFSET$36 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "lblOffset");
  
  private static final b TICKLBLSKIP$38 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "tickLblSkip");
  
  private static final b TICKMARKSKIP$40 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "tickMarkSkip");
  
  private static final b NOMULTILVLLBL$42 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "noMultiLvlLbl");
  
  private static final b EXTLST$44 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "extLst");
  
  public CTCatAxImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTUnsignedInt getAxId() {
    synchronized (monitor()) {
      check_orphaned();
      CTUnsignedInt cTUnsignedInt = null;
      cTUnsignedInt = (CTUnsignedInt)get_store().find_element_user(AXID$0, 0);
      if (cTUnsignedInt == null)
        return null; 
      return cTUnsignedInt;
    } 
  }
  
  public void setAxId(CTUnsignedInt paramCTUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTUnsignedInt cTUnsignedInt = null;
      cTUnsignedInt = (CTUnsignedInt)get_store().find_element_user(AXID$0, 0);
      if (cTUnsignedInt == null)
        cTUnsignedInt = (CTUnsignedInt)get_store().add_element_user(AXID$0); 
      cTUnsignedInt.set((XmlObject)paramCTUnsignedInt);
    } 
  }
  
  public CTUnsignedInt addNewAxId() {
    synchronized (monitor()) {
      check_orphaned();
      CTUnsignedInt cTUnsignedInt = null;
      cTUnsignedInt = (CTUnsignedInt)get_store().add_element_user(AXID$0);
      return cTUnsignedInt;
    } 
  }
  
  public CTScaling getScaling() {
    synchronized (monitor()) {
      check_orphaned();
      CTScaling cTScaling = null;
      cTScaling = (CTScaling)get_store().find_element_user(SCALING$2, 0);
      if (cTScaling == null)
        return null; 
      return cTScaling;
    } 
  }
  
  public void setScaling(CTScaling paramCTScaling) {
    synchronized (monitor()) {
      check_orphaned();
      CTScaling cTScaling = null;
      cTScaling = (CTScaling)get_store().find_element_user(SCALING$2, 0);
      if (cTScaling == null)
        cTScaling = (CTScaling)get_store().add_element_user(SCALING$2); 
      cTScaling.set((XmlObject)paramCTScaling);
    } 
  }
  
  public CTScaling addNewScaling() {
    synchronized (monitor()) {
      check_orphaned();
      CTScaling cTScaling = null;
      cTScaling = (CTScaling)get_store().add_element_user(SCALING$2);
      return cTScaling;
    } 
  }
  
  public CTBoolean getDelete() {
    synchronized (monitor()) {
      check_orphaned();
      CTBoolean cTBoolean = null;
      cTBoolean = (CTBoolean)get_store().find_element_user(DELETE$4, 0);
      if (cTBoolean == null)
        return null; 
      return cTBoolean;
    } 
  }
  
  public boolean isSetDelete() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DELETE$4) != 0);
    } 
  }
  
  public void setDelete(CTBoolean paramCTBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      CTBoolean cTBoolean = null;
      cTBoolean = (CTBoolean)get_store().find_element_user(DELETE$4, 0);
      if (cTBoolean == null)
        cTBoolean = (CTBoolean)get_store().add_element_user(DELETE$4); 
      cTBoolean.set((XmlObject)paramCTBoolean);
    } 
  }
  
  public CTBoolean addNewDelete() {
    synchronized (monitor()) {
      check_orphaned();
      CTBoolean cTBoolean = null;
      cTBoolean = (CTBoolean)get_store().add_element_user(DELETE$4);
      return cTBoolean;
    } 
  }
  
  public void unsetDelete() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DELETE$4, 0);
    } 
  }
  
  public CTAxPos getAxPos() {
    synchronized (monitor()) {
      check_orphaned();
      CTAxPos cTAxPos = null;
      cTAxPos = (CTAxPos)get_store().find_element_user(AXPOS$6, 0);
      if (cTAxPos == null)
        return null; 
      return cTAxPos;
    } 
  }
  
  public void setAxPos(CTAxPos paramCTAxPos) {
    synchronized (monitor()) {
      check_orphaned();
      CTAxPos cTAxPos = null;
      cTAxPos = (CTAxPos)get_store().find_element_user(AXPOS$6, 0);
      if (cTAxPos == null)
        cTAxPos = (CTAxPos)get_store().add_element_user(AXPOS$6); 
      cTAxPos.set((XmlObject)paramCTAxPos);
    } 
  }
  
  public CTAxPos addNewAxPos() {
    synchronized (monitor()) {
      check_orphaned();
      CTAxPos cTAxPos = null;
      cTAxPos = (CTAxPos)get_store().add_element_user(AXPOS$6);
      return cTAxPos;
    } 
  }
  
  public CTChartLines getMajorGridlines() {
    synchronized (monitor()) {
      check_orphaned();
      CTChartLines cTChartLines = null;
      cTChartLines = (CTChartLines)get_store().find_element_user(MAJORGRIDLINES$8, 0);
      if (cTChartLines == null)
        return null; 
      return cTChartLines;
    } 
  }
  
  public boolean isSetMajorGridlines() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(MAJORGRIDLINES$8) != 0);
    } 
  }
  
  public void setMajorGridlines(CTChartLines paramCTChartLines) {
    synchronized (monitor()) {
      check_orphaned();
      CTChartLines cTChartLines = null;
      cTChartLines = (CTChartLines)get_store().find_element_user(MAJORGRIDLINES$8, 0);
      if (cTChartLines == null)
        cTChartLines = (CTChartLines)get_store().add_element_user(MAJORGRIDLINES$8); 
      cTChartLines.set((XmlObject)paramCTChartLines);
    } 
  }
  
  public CTChartLines addNewMajorGridlines() {
    synchronized (monitor()) {
      check_orphaned();
      CTChartLines cTChartLines = null;
      cTChartLines = (CTChartLines)get_store().add_element_user(MAJORGRIDLINES$8);
      return cTChartLines;
    } 
  }
  
  public void unsetMajorGridlines() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(MAJORGRIDLINES$8, 0);
    } 
  }
  
  public CTChartLines getMinorGridlines() {
    synchronized (monitor()) {
      check_orphaned();
      CTChartLines cTChartLines = null;
      cTChartLines = (CTChartLines)get_store().find_element_user(MINORGRIDLINES$10, 0);
      if (cTChartLines == null)
        return null; 
      return cTChartLines;
    } 
  }
  
  public boolean isSetMinorGridlines() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(MINORGRIDLINES$10) != 0);
    } 
  }
  
  public void setMinorGridlines(CTChartLines paramCTChartLines) {
    synchronized (monitor()) {
      check_orphaned();
      CTChartLines cTChartLines = null;
      cTChartLines = (CTChartLines)get_store().find_element_user(MINORGRIDLINES$10, 0);
      if (cTChartLines == null)
        cTChartLines = (CTChartLines)get_store().add_element_user(MINORGRIDLINES$10); 
      cTChartLines.set((XmlObject)paramCTChartLines);
    } 
  }
  
  public CTChartLines addNewMinorGridlines() {
    synchronized (monitor()) {
      check_orphaned();
      CTChartLines cTChartLines = null;
      cTChartLines = (CTChartLines)get_store().add_element_user(MINORGRIDLINES$10);
      return cTChartLines;
    } 
  }
  
  public void unsetMinorGridlines() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(MINORGRIDLINES$10, 0);
    } 
  }
  
  public CTTitle getTitle() {
    synchronized (monitor()) {
      check_orphaned();
      CTTitle cTTitle = null;
      cTTitle = (CTTitle)get_store().find_element_user(TITLE$12, 0);
      if (cTTitle == null)
        return null; 
      return cTTitle;
    } 
  }
  
  public boolean isSetTitle() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TITLE$12) != 0);
    } 
  }
  
  public void setTitle(CTTitle paramCTTitle) {
    synchronized (monitor()) {
      check_orphaned();
      CTTitle cTTitle = null;
      cTTitle = (CTTitle)get_store().find_element_user(TITLE$12, 0);
      if (cTTitle == null)
        cTTitle = (CTTitle)get_store().add_element_user(TITLE$12); 
      cTTitle.set((XmlObject)paramCTTitle);
    } 
  }
  
  public CTTitle addNewTitle() {
    synchronized (monitor()) {
      check_orphaned();
      CTTitle cTTitle = null;
      cTTitle = (CTTitle)get_store().add_element_user(TITLE$12);
      return cTTitle;
    } 
  }
  
  public void unsetTitle() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TITLE$12, 0);
    } 
  }
  
  public CTNumFmt getNumFmt() {
    synchronized (monitor()) {
      check_orphaned();
      CTNumFmt cTNumFmt = null;
      cTNumFmt = (CTNumFmt)get_store().find_element_user(NUMFMT$14, 0);
      if (cTNumFmt == null)
        return null; 
      return cTNumFmt;
    } 
  }
  
  public boolean isSetNumFmt() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(NUMFMT$14) != 0);
    } 
  }
  
  public void setNumFmt(CTNumFmt paramCTNumFmt) {
    synchronized (monitor()) {
      check_orphaned();
      CTNumFmt cTNumFmt = null;
      cTNumFmt = (CTNumFmt)get_store().find_element_user(NUMFMT$14, 0);
      if (cTNumFmt == null)
        cTNumFmt = (CTNumFmt)get_store().add_element_user(NUMFMT$14); 
      cTNumFmt.set((XmlObject)paramCTNumFmt);
    } 
  }
  
  public CTNumFmt addNewNumFmt() {
    synchronized (monitor()) {
      check_orphaned();
      CTNumFmt cTNumFmt = null;
      cTNumFmt = (CTNumFmt)get_store().add_element_user(NUMFMT$14);
      return cTNumFmt;
    } 
  }
  
  public void unsetNumFmt() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(NUMFMT$14, 0);
    } 
  }
  
  public CTTickMark getMajorTickMark() {
    synchronized (monitor()) {
      check_orphaned();
      CTTickMark cTTickMark = null;
      cTTickMark = (CTTickMark)get_store().find_element_user(MAJORTICKMARK$16, 0);
      if (cTTickMark == null)
        return null; 
      return cTTickMark;
    } 
  }
  
  public boolean isSetMajorTickMark() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(MAJORTICKMARK$16) != 0);
    } 
  }
  
  public void setMajorTickMark(CTTickMark paramCTTickMark) {
    synchronized (monitor()) {
      check_orphaned();
      CTTickMark cTTickMark = null;
      cTTickMark = (CTTickMark)get_store().find_element_user(MAJORTICKMARK$16, 0);
      if (cTTickMark == null)
        cTTickMark = (CTTickMark)get_store().add_element_user(MAJORTICKMARK$16); 
      cTTickMark.set((XmlObject)paramCTTickMark);
    } 
  }
  
  public CTTickMark addNewMajorTickMark() {
    synchronized (monitor()) {
      check_orphaned();
      CTTickMark cTTickMark = null;
      cTTickMark = (CTTickMark)get_store().add_element_user(MAJORTICKMARK$16);
      return cTTickMark;
    } 
  }
  
  public void unsetMajorTickMark() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(MAJORTICKMARK$16, 0);
    } 
  }
  
  public CTTickMark getMinorTickMark() {
    synchronized (monitor()) {
      check_orphaned();
      CTTickMark cTTickMark = null;
      cTTickMark = (CTTickMark)get_store().find_element_user(MINORTICKMARK$18, 0);
      if (cTTickMark == null)
        return null; 
      return cTTickMark;
    } 
  }
  
  public boolean isSetMinorTickMark() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(MINORTICKMARK$18) != 0);
    } 
  }
  
  public void setMinorTickMark(CTTickMark paramCTTickMark) {
    synchronized (monitor()) {
      check_orphaned();
      CTTickMark cTTickMark = null;
      cTTickMark = (CTTickMark)get_store().find_element_user(MINORTICKMARK$18, 0);
      if (cTTickMark == null)
        cTTickMark = (CTTickMark)get_store().add_element_user(MINORTICKMARK$18); 
      cTTickMark.set((XmlObject)paramCTTickMark);
    } 
  }
  
  public CTTickMark addNewMinorTickMark() {
    synchronized (monitor()) {
      check_orphaned();
      CTTickMark cTTickMark = null;
      cTTickMark = (CTTickMark)get_store().add_element_user(MINORTICKMARK$18);
      return cTTickMark;
    } 
  }
  
  public void unsetMinorTickMark() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(MINORTICKMARK$18, 0);
    } 
  }
  
  public CTTickLblPos getTickLblPos() {
    synchronized (monitor()) {
      check_orphaned();
      CTTickLblPos cTTickLblPos = null;
      cTTickLblPos = (CTTickLblPos)get_store().find_element_user(TICKLBLPOS$20, 0);
      if (cTTickLblPos == null)
        return null; 
      return cTTickLblPos;
    } 
  }
  
  public boolean isSetTickLblPos() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TICKLBLPOS$20) != 0);
    } 
  }
  
  public void setTickLblPos(CTTickLblPos paramCTTickLblPos) {
    synchronized (monitor()) {
      check_orphaned();
      CTTickLblPos cTTickLblPos = null;
      cTTickLblPos = (CTTickLblPos)get_store().find_element_user(TICKLBLPOS$20, 0);
      if (cTTickLblPos == null)
        cTTickLblPos = (CTTickLblPos)get_store().add_element_user(TICKLBLPOS$20); 
      cTTickLblPos.set((XmlObject)paramCTTickLblPos);
    } 
  }
  
  public CTTickLblPos addNewTickLblPos() {
    synchronized (monitor()) {
      check_orphaned();
      CTTickLblPos cTTickLblPos = null;
      cTTickLblPos = (CTTickLblPos)get_store().add_element_user(TICKLBLPOS$20);
      return cTTickLblPos;
    } 
  }
  
  public void unsetTickLblPos() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TICKLBLPOS$20, 0);
    } 
  }
  
  public CTShapeProperties getSpPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTShapeProperties cTShapeProperties = null;
      cTShapeProperties = (CTShapeProperties)get_store().find_element_user(SPPR$22, 0);
      if (cTShapeProperties == null)
        return null; 
      return cTShapeProperties;
    } 
  }
  
  public boolean isSetSpPr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SPPR$22) != 0);
    } 
  }
  
  public void setSpPr(CTShapeProperties paramCTShapeProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTShapeProperties cTShapeProperties = null;
      cTShapeProperties = (CTShapeProperties)get_store().find_element_user(SPPR$22, 0);
      if (cTShapeProperties == null)
        cTShapeProperties = (CTShapeProperties)get_store().add_element_user(SPPR$22); 
      cTShapeProperties.set((XmlObject)paramCTShapeProperties);
    } 
  }
  
  public CTShapeProperties addNewSpPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTShapeProperties cTShapeProperties = null;
      cTShapeProperties = (CTShapeProperties)get_store().add_element_user(SPPR$22);
      return cTShapeProperties;
    } 
  }
  
  public void unsetSpPr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SPPR$22, 0);
    } 
  }
  
  public CTTextBody getTxPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextBody cTTextBody = null;
      cTTextBody = (CTTextBody)get_store().find_element_user(TXPR$24, 0);
      if (cTTextBody == null)
        return null; 
      return cTTextBody;
    } 
  }
  
  public boolean isSetTxPr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TXPR$24) != 0);
    } 
  }
  
  public void setTxPr(CTTextBody paramCTTextBody) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextBody cTTextBody = null;
      cTTextBody = (CTTextBody)get_store().find_element_user(TXPR$24, 0);
      if (cTTextBody == null)
        cTTextBody = (CTTextBody)get_store().add_element_user(TXPR$24); 
      cTTextBody.set((XmlObject)paramCTTextBody);
    } 
  }
  
  public CTTextBody addNewTxPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextBody cTTextBody = null;
      cTTextBody = (CTTextBody)get_store().add_element_user(TXPR$24);
      return cTTextBody;
    } 
  }
  
  public void unsetTxPr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TXPR$24, 0);
    } 
  }
  
  public CTUnsignedInt getCrossAx() {
    synchronized (monitor()) {
      check_orphaned();
      CTUnsignedInt cTUnsignedInt = null;
      cTUnsignedInt = (CTUnsignedInt)get_store().find_element_user(CROSSAX$26, 0);
      if (cTUnsignedInt == null)
        return null; 
      return cTUnsignedInt;
    } 
  }
  
  public void setCrossAx(CTUnsignedInt paramCTUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTUnsignedInt cTUnsignedInt = null;
      cTUnsignedInt = (CTUnsignedInt)get_store().find_element_user(CROSSAX$26, 0);
      if (cTUnsignedInt == null)
        cTUnsignedInt = (CTUnsignedInt)get_store().add_element_user(CROSSAX$26); 
      cTUnsignedInt.set((XmlObject)paramCTUnsignedInt);
    } 
  }
  
  public CTUnsignedInt addNewCrossAx() {
    synchronized (monitor()) {
      check_orphaned();
      CTUnsignedInt cTUnsignedInt = null;
      cTUnsignedInt = (CTUnsignedInt)get_store().add_element_user(CROSSAX$26);
      return cTUnsignedInt;
    } 
  }
  
  public CTCrosses getCrosses() {
    synchronized (monitor()) {
      check_orphaned();
      CTCrosses cTCrosses = null;
      cTCrosses = (CTCrosses)get_store().find_element_user(CROSSES$28, 0);
      if (cTCrosses == null)
        return null; 
      return cTCrosses;
    } 
  }
  
  public boolean isSetCrosses() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(CROSSES$28) != 0);
    } 
  }
  
  public void setCrosses(CTCrosses paramCTCrosses) {
    synchronized (monitor()) {
      check_orphaned();
      CTCrosses cTCrosses = null;
      cTCrosses = (CTCrosses)get_store().find_element_user(CROSSES$28, 0);
      if (cTCrosses == null)
        cTCrosses = (CTCrosses)get_store().add_element_user(CROSSES$28); 
      cTCrosses.set((XmlObject)paramCTCrosses);
    } 
  }
  
  public CTCrosses addNewCrosses() {
    synchronized (monitor()) {
      check_orphaned();
      CTCrosses cTCrosses = null;
      cTCrosses = (CTCrosses)get_store().add_element_user(CROSSES$28);
      return cTCrosses;
    } 
  }
  
  public void unsetCrosses() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CROSSES$28, 0);
    } 
  }
  
  public CTDouble getCrossesAt() {
    synchronized (monitor()) {
      check_orphaned();
      CTDouble cTDouble = null;
      cTDouble = (CTDouble)get_store().find_element_user(CROSSESAT$30, 0);
      if (cTDouble == null)
        return null; 
      return cTDouble;
    } 
  }
  
  public boolean isSetCrossesAt() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(CROSSESAT$30) != 0);
    } 
  }
  
  public void setCrossesAt(CTDouble paramCTDouble) {
    synchronized (monitor()) {
      check_orphaned();
      CTDouble cTDouble = null;
      cTDouble = (CTDouble)get_store().find_element_user(CROSSESAT$30, 0);
      if (cTDouble == null)
        cTDouble = (CTDouble)get_store().add_element_user(CROSSESAT$30); 
      cTDouble.set((XmlObject)paramCTDouble);
    } 
  }
  
  public CTDouble addNewCrossesAt() {
    synchronized (monitor()) {
      check_orphaned();
      CTDouble cTDouble = null;
      cTDouble = (CTDouble)get_store().add_element_user(CROSSESAT$30);
      return cTDouble;
    } 
  }
  
  public void unsetCrossesAt() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CROSSESAT$30, 0);
    } 
  }
  
  public CTBoolean getAuto() {
    synchronized (monitor()) {
      check_orphaned();
      CTBoolean cTBoolean = null;
      cTBoolean = (CTBoolean)get_store().find_element_user(AUTO$32, 0);
      if (cTBoolean == null)
        return null; 
      return cTBoolean;
    } 
  }
  
  public boolean isSetAuto() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(AUTO$32) != 0);
    } 
  }
  
  public void setAuto(CTBoolean paramCTBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      CTBoolean cTBoolean = null;
      cTBoolean = (CTBoolean)get_store().find_element_user(AUTO$32, 0);
      if (cTBoolean == null)
        cTBoolean = (CTBoolean)get_store().add_element_user(AUTO$32); 
      cTBoolean.set((XmlObject)paramCTBoolean);
    } 
  }
  
  public CTBoolean addNewAuto() {
    synchronized (monitor()) {
      check_orphaned();
      CTBoolean cTBoolean = null;
      cTBoolean = (CTBoolean)get_store().add_element_user(AUTO$32);
      return cTBoolean;
    } 
  }
  
  public void unsetAuto() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(AUTO$32, 0);
    } 
  }
  
  public CTLblAlgn getLblAlgn() {
    synchronized (monitor()) {
      check_orphaned();
      CTLblAlgn cTLblAlgn = null;
      cTLblAlgn = (CTLblAlgn)get_store().find_element_user(LBLALGN$34, 0);
      if (cTLblAlgn == null)
        return null; 
      return cTLblAlgn;
    } 
  }
  
  public boolean isSetLblAlgn() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(LBLALGN$34) != 0);
    } 
  }
  
  public void setLblAlgn(CTLblAlgn paramCTLblAlgn) {
    synchronized (monitor()) {
      check_orphaned();
      CTLblAlgn cTLblAlgn = null;
      cTLblAlgn = (CTLblAlgn)get_store().find_element_user(LBLALGN$34, 0);
      if (cTLblAlgn == null)
        cTLblAlgn = (CTLblAlgn)get_store().add_element_user(LBLALGN$34); 
      cTLblAlgn.set((XmlObject)paramCTLblAlgn);
    } 
  }
  
  public CTLblAlgn addNewLblAlgn() {
    synchronized (monitor()) {
      check_orphaned();
      CTLblAlgn cTLblAlgn = null;
      cTLblAlgn = (CTLblAlgn)get_store().add_element_user(LBLALGN$34);
      return cTLblAlgn;
    } 
  }
  
  public void unsetLblAlgn() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LBLALGN$34, 0);
    } 
  }
  
  public CTLblOffset getLblOffset() {
    synchronized (monitor()) {
      check_orphaned();
      CTLblOffset cTLblOffset = null;
      cTLblOffset = (CTLblOffset)get_store().find_element_user(LBLOFFSET$36, 0);
      if (cTLblOffset == null)
        return null; 
      return cTLblOffset;
    } 
  }
  
  public boolean isSetLblOffset() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(LBLOFFSET$36) != 0);
    } 
  }
  
  public void setLblOffset(CTLblOffset paramCTLblOffset) {
    synchronized (monitor()) {
      check_orphaned();
      CTLblOffset cTLblOffset = null;
      cTLblOffset = (CTLblOffset)get_store().find_element_user(LBLOFFSET$36, 0);
      if (cTLblOffset == null)
        cTLblOffset = (CTLblOffset)get_store().add_element_user(LBLOFFSET$36); 
      cTLblOffset.set((XmlObject)paramCTLblOffset);
    } 
  }
  
  public CTLblOffset addNewLblOffset() {
    synchronized (monitor()) {
      check_orphaned();
      CTLblOffset cTLblOffset = null;
      cTLblOffset = (CTLblOffset)get_store().add_element_user(LBLOFFSET$36);
      return cTLblOffset;
    } 
  }
  
  public void unsetLblOffset() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LBLOFFSET$36, 0);
    } 
  }
  
  public CTSkip getTickLblSkip() {
    synchronized (monitor()) {
      check_orphaned();
      CTSkip cTSkip = null;
      cTSkip = (CTSkip)get_store().find_element_user(TICKLBLSKIP$38, 0);
      if (cTSkip == null)
        return null; 
      return cTSkip;
    } 
  }
  
  public boolean isSetTickLblSkip() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TICKLBLSKIP$38) != 0);
    } 
  }
  
  public void setTickLblSkip(CTSkip paramCTSkip) {
    synchronized (monitor()) {
      check_orphaned();
      CTSkip cTSkip = null;
      cTSkip = (CTSkip)get_store().find_element_user(TICKLBLSKIP$38, 0);
      if (cTSkip == null)
        cTSkip = (CTSkip)get_store().add_element_user(TICKLBLSKIP$38); 
      cTSkip.set((XmlObject)paramCTSkip);
    } 
  }
  
  public CTSkip addNewTickLblSkip() {
    synchronized (monitor()) {
      check_orphaned();
      CTSkip cTSkip = null;
      cTSkip = (CTSkip)get_store().add_element_user(TICKLBLSKIP$38);
      return cTSkip;
    } 
  }
  
  public void unsetTickLblSkip() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TICKLBLSKIP$38, 0);
    } 
  }
  
  public CTSkip getTickMarkSkip() {
    synchronized (monitor()) {
      check_orphaned();
      CTSkip cTSkip = null;
      cTSkip = (CTSkip)get_store().find_element_user(TICKMARKSKIP$40, 0);
      if (cTSkip == null)
        return null; 
      return cTSkip;
    } 
  }
  
  public boolean isSetTickMarkSkip() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TICKMARKSKIP$40) != 0);
    } 
  }
  
  public void setTickMarkSkip(CTSkip paramCTSkip) {
    synchronized (monitor()) {
      check_orphaned();
      CTSkip cTSkip = null;
      cTSkip = (CTSkip)get_store().find_element_user(TICKMARKSKIP$40, 0);
      if (cTSkip == null)
        cTSkip = (CTSkip)get_store().add_element_user(TICKMARKSKIP$40); 
      cTSkip.set((XmlObject)paramCTSkip);
    } 
  }
  
  public CTSkip addNewTickMarkSkip() {
    synchronized (monitor()) {
      check_orphaned();
      CTSkip cTSkip = null;
      cTSkip = (CTSkip)get_store().add_element_user(TICKMARKSKIP$40);
      return cTSkip;
    } 
  }
  
  public void unsetTickMarkSkip() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TICKMARKSKIP$40, 0);
    } 
  }
  
  public CTBoolean getNoMultiLvlLbl() {
    synchronized (monitor()) {
      check_orphaned();
      CTBoolean cTBoolean = null;
      cTBoolean = (CTBoolean)get_store().find_element_user(NOMULTILVLLBL$42, 0);
      if (cTBoolean == null)
        return null; 
      return cTBoolean;
    } 
  }
  
  public boolean isSetNoMultiLvlLbl() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(NOMULTILVLLBL$42) != 0);
    } 
  }
  
  public void setNoMultiLvlLbl(CTBoolean paramCTBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      CTBoolean cTBoolean = null;
      cTBoolean = (CTBoolean)get_store().find_element_user(NOMULTILVLLBL$42, 0);
      if (cTBoolean == null)
        cTBoolean = (CTBoolean)get_store().add_element_user(NOMULTILVLLBL$42); 
      cTBoolean.set((XmlObject)paramCTBoolean);
    } 
  }
  
  public CTBoolean addNewNoMultiLvlLbl() {
    synchronized (monitor()) {
      check_orphaned();
      CTBoolean cTBoolean = null;
      cTBoolean = (CTBoolean)get_store().add_element_user(NOMULTILVLLBL$42);
      return cTBoolean;
    } 
  }
  
  public void unsetNoMultiLvlLbl() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(NOMULTILVLLBL$42, 0);
    } 
  }
  
  public CTExtensionList getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$44, 0);
      if (cTExtensionList == null)
        return null; 
      return cTExtensionList;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$44) != 0);
    } 
  }
  
  public void setExtLst(CTExtensionList paramCTExtensionList) {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$44, 0);
      if (cTExtensionList == null)
        cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$44); 
      cTExtensionList.set((XmlObject)paramCTExtensionList);
    } 
  }
  
  public CTExtensionList addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$44);
      return cTExtensionList;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$44, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\impl\CTCatAxImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */