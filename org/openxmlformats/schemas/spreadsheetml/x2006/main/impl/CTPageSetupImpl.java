package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCellComments;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STOrientation;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STPageOrder;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STPrintError;

public class CTPageSetupImpl extends XmlComplexContentImpl implements CTPageSetup {
  private static final b PAPERSIZE$0 = new b("", "paperSize");
  
  private static final b SCALE$2 = new b("", "scale");
  
  private static final b FIRSTPAGENUMBER$4 = new b("", "firstPageNumber");
  
  private static final b FITTOWIDTH$6 = new b("", "fitToWidth");
  
  private static final b FITTOHEIGHT$8 = new b("", "fitToHeight");
  
  private static final b PAGEORDER$10 = new b("", "pageOrder");
  
  private static final b ORIENTATION$12 = new b("", "orientation");
  
  private static final b USEPRINTERDEFAULTS$14 = new b("", "usePrinterDefaults");
  
  private static final b BLACKANDWHITE$16 = new b("", "blackAndWhite");
  
  private static final b DRAFT$18 = new b("", "draft");
  
  private static final b CELLCOMMENTS$20 = new b("", "cellComments");
  
  private static final b USEFIRSTPAGENUMBER$22 = new b("", "useFirstPageNumber");
  
  private static final b ERRORS$24 = new b("", "errors");
  
  private static final b HORIZONTALDPI$26 = new b("", "horizontalDpi");
  
  private static final b VERTICALDPI$28 = new b("", "verticalDpi");
  
  private static final b COPIES$30 = new b("", "copies");
  
  private static final b ID$32 = new b("http://schemas.openxmlformats.org/officeDocument/2006/relationships", "id");
  
  public CTPageSetupImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public long getPaperSize() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PAPERSIZE$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(PAPERSIZE$0); 
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetPaperSize() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(PAPERSIZE$0);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_default_attribute_value(PAPERSIZE$0); 
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetPaperSize() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(PAPERSIZE$0) != null);
    } 
  }
  
  public void setPaperSize(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PAPERSIZE$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(PAPERSIZE$0); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetPaperSize(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(PAPERSIZE$0);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(PAPERSIZE$0); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetPaperSize() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(PAPERSIZE$0);
    } 
  }
  
  public long getScale() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SCALE$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SCALE$2); 
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetScale() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(SCALE$2);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_default_attribute_value(SCALE$2); 
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetScale() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SCALE$2) != null);
    } 
  }
  
  public void setScale(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SCALE$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SCALE$2); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetScale(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(SCALE$2);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(SCALE$2); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetScale() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SCALE$2);
    } 
  }
  
  public long getFirstPageNumber() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FIRSTPAGENUMBER$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(FIRSTPAGENUMBER$4); 
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetFirstPageNumber() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(FIRSTPAGENUMBER$4);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_default_attribute_value(FIRSTPAGENUMBER$4); 
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetFirstPageNumber() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(FIRSTPAGENUMBER$4) != null);
    } 
  }
  
  public void setFirstPageNumber(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FIRSTPAGENUMBER$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FIRSTPAGENUMBER$4); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetFirstPageNumber(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(FIRSTPAGENUMBER$4);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(FIRSTPAGENUMBER$4); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetFirstPageNumber() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(FIRSTPAGENUMBER$4);
    } 
  }
  
  public long getFitToWidth() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FITTOWIDTH$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(FITTOWIDTH$6); 
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetFitToWidth() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(FITTOWIDTH$6);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_default_attribute_value(FITTOWIDTH$6); 
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetFitToWidth() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(FITTOWIDTH$6) != null);
    } 
  }
  
  public void setFitToWidth(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FITTOWIDTH$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FITTOWIDTH$6); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetFitToWidth(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(FITTOWIDTH$6);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(FITTOWIDTH$6); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetFitToWidth() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(FITTOWIDTH$6);
    } 
  }
  
  public long getFitToHeight() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FITTOHEIGHT$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(FITTOHEIGHT$8); 
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetFitToHeight() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(FITTOHEIGHT$8);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_default_attribute_value(FITTOHEIGHT$8); 
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetFitToHeight() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(FITTOHEIGHT$8) != null);
    } 
  }
  
  public void setFitToHeight(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FITTOHEIGHT$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FITTOHEIGHT$8); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetFitToHeight(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(FITTOHEIGHT$8);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(FITTOHEIGHT$8); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetFitToHeight() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(FITTOHEIGHT$8);
    } 
  }
  
  public STPageOrder.Enum getPageOrder() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PAGEORDER$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(PAGEORDER$10); 
      if (simpleValue == null)
        return null; 
      return (STPageOrder.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STPageOrder xgetPageOrder() {
    synchronized (monitor()) {
      check_orphaned();
      STPageOrder sTPageOrder = null;
      sTPageOrder = (STPageOrder)get_store().find_attribute_user(PAGEORDER$10);
      if (sTPageOrder == null)
        sTPageOrder = (STPageOrder)get_default_attribute_value(PAGEORDER$10); 
      return sTPageOrder;
    } 
  }
  
  public boolean isSetPageOrder() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(PAGEORDER$10) != null);
    } 
  }
  
  public void setPageOrder(STPageOrder.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PAGEORDER$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(PAGEORDER$10); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetPageOrder(STPageOrder paramSTPageOrder) {
    synchronized (monitor()) {
      check_orphaned();
      STPageOrder sTPageOrder = null;
      sTPageOrder = (STPageOrder)get_store().find_attribute_user(PAGEORDER$10);
      if (sTPageOrder == null)
        sTPageOrder = (STPageOrder)get_store().add_attribute_user(PAGEORDER$10); 
      sTPageOrder.set((XmlObject)paramSTPageOrder);
    } 
  }
  
  public void unsetPageOrder() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(PAGEORDER$10);
    } 
  }
  
  public STOrientation.Enum getOrientation() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ORIENTATION$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(ORIENTATION$12); 
      if (simpleValue == null)
        return null; 
      return (STOrientation.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STOrientation xgetOrientation() {
    synchronized (monitor()) {
      check_orphaned();
      STOrientation sTOrientation = null;
      sTOrientation = (STOrientation)get_store().find_attribute_user(ORIENTATION$12);
      if (sTOrientation == null)
        sTOrientation = (STOrientation)get_default_attribute_value(ORIENTATION$12); 
      return sTOrientation;
    } 
  }
  
  public boolean isSetOrientation() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ORIENTATION$12) != null);
    } 
  }
  
  public void setOrientation(STOrientation.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ORIENTATION$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ORIENTATION$12); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetOrientation(STOrientation paramSTOrientation) {
    synchronized (monitor()) {
      check_orphaned();
      STOrientation sTOrientation = null;
      sTOrientation = (STOrientation)get_store().find_attribute_user(ORIENTATION$12);
      if (sTOrientation == null)
        sTOrientation = (STOrientation)get_store().add_attribute_user(ORIENTATION$12); 
      sTOrientation.set((XmlObject)paramSTOrientation);
    } 
  }
  
  public void unsetOrientation() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ORIENTATION$12);
    } 
  }
  
  public boolean getUsePrinterDefaults() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(USEPRINTERDEFAULTS$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(USEPRINTERDEFAULTS$14); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetUsePrinterDefaults() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(USEPRINTERDEFAULTS$14);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(USEPRINTERDEFAULTS$14); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetUsePrinterDefaults() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(USEPRINTERDEFAULTS$14) != null);
    } 
  }
  
  public void setUsePrinterDefaults(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(USEPRINTERDEFAULTS$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(USEPRINTERDEFAULTS$14); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetUsePrinterDefaults(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(USEPRINTERDEFAULTS$14);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(USEPRINTERDEFAULTS$14); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetUsePrinterDefaults() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(USEPRINTERDEFAULTS$14);
    } 
  }
  
  public boolean getBlackAndWhite() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BLACKANDWHITE$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(BLACKANDWHITE$16); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetBlackAndWhite() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(BLACKANDWHITE$16);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(BLACKANDWHITE$16); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetBlackAndWhite() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(BLACKANDWHITE$16) != null);
    } 
  }
  
  public void setBlackAndWhite(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BLACKANDWHITE$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(BLACKANDWHITE$16); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetBlackAndWhite(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(BLACKANDWHITE$16);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(BLACKANDWHITE$16); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetBlackAndWhite() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(BLACKANDWHITE$16);
    } 
  }
  
  public boolean getDraft() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DRAFT$18);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(DRAFT$18); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetDraft() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(DRAFT$18);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(DRAFT$18); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetDraft() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DRAFT$18) != null);
    } 
  }
  
  public void setDraft(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DRAFT$18);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DRAFT$18); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetDraft(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(DRAFT$18);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(DRAFT$18); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetDraft() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DRAFT$18);
    } 
  }
  
  public STCellComments.Enum getCellComments() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CELLCOMMENTS$20);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(CELLCOMMENTS$20); 
      if (simpleValue == null)
        return null; 
      return (STCellComments.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STCellComments xgetCellComments() {
    synchronized (monitor()) {
      check_orphaned();
      STCellComments sTCellComments = null;
      sTCellComments = (STCellComments)get_store().find_attribute_user(CELLCOMMENTS$20);
      if (sTCellComments == null)
        sTCellComments = (STCellComments)get_default_attribute_value(CELLCOMMENTS$20); 
      return sTCellComments;
    } 
  }
  
  public boolean isSetCellComments() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(CELLCOMMENTS$20) != null);
    } 
  }
  
  public void setCellComments(STCellComments.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CELLCOMMENTS$20);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CELLCOMMENTS$20); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetCellComments(STCellComments paramSTCellComments) {
    synchronized (monitor()) {
      check_orphaned();
      STCellComments sTCellComments = null;
      sTCellComments = (STCellComments)get_store().find_attribute_user(CELLCOMMENTS$20);
      if (sTCellComments == null)
        sTCellComments = (STCellComments)get_store().add_attribute_user(CELLCOMMENTS$20); 
      sTCellComments.set((XmlObject)paramSTCellComments);
    } 
  }
  
  public void unsetCellComments() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(CELLCOMMENTS$20);
    } 
  }
  
  public boolean getUseFirstPageNumber() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(USEFIRSTPAGENUMBER$22);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(USEFIRSTPAGENUMBER$22); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetUseFirstPageNumber() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(USEFIRSTPAGENUMBER$22);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(USEFIRSTPAGENUMBER$22); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetUseFirstPageNumber() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(USEFIRSTPAGENUMBER$22) != null);
    } 
  }
  
  public void setUseFirstPageNumber(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(USEFIRSTPAGENUMBER$22);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(USEFIRSTPAGENUMBER$22); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetUseFirstPageNumber(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(USEFIRSTPAGENUMBER$22);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(USEFIRSTPAGENUMBER$22); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetUseFirstPageNumber() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(USEFIRSTPAGENUMBER$22);
    } 
  }
  
  public STPrintError.Enum getErrors() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ERRORS$24);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(ERRORS$24); 
      if (simpleValue == null)
        return null; 
      return (STPrintError.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STPrintError xgetErrors() {
    synchronized (monitor()) {
      check_orphaned();
      STPrintError sTPrintError = null;
      sTPrintError = (STPrintError)get_store().find_attribute_user(ERRORS$24);
      if (sTPrintError == null)
        sTPrintError = (STPrintError)get_default_attribute_value(ERRORS$24); 
      return sTPrintError;
    } 
  }
  
  public boolean isSetErrors() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ERRORS$24) != null);
    } 
  }
  
  public void setErrors(STPrintError.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ERRORS$24);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ERRORS$24); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetErrors(STPrintError paramSTPrintError) {
    synchronized (monitor()) {
      check_orphaned();
      STPrintError sTPrintError = null;
      sTPrintError = (STPrintError)get_store().find_attribute_user(ERRORS$24);
      if (sTPrintError == null)
        sTPrintError = (STPrintError)get_store().add_attribute_user(ERRORS$24); 
      sTPrintError.set((XmlObject)paramSTPrintError);
    } 
  }
  
  public void unsetErrors() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ERRORS$24);
    } 
  }
  
  public long getHorizontalDpi() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HORIZONTALDPI$26);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(HORIZONTALDPI$26); 
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetHorizontalDpi() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(HORIZONTALDPI$26);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_default_attribute_value(HORIZONTALDPI$26); 
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetHorizontalDpi() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(HORIZONTALDPI$26) != null);
    } 
  }
  
  public void setHorizontalDpi(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HORIZONTALDPI$26);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(HORIZONTALDPI$26); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetHorizontalDpi(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(HORIZONTALDPI$26);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(HORIZONTALDPI$26); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetHorizontalDpi() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(HORIZONTALDPI$26);
    } 
  }
  
  public long getVerticalDpi() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VERTICALDPI$28);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(VERTICALDPI$28); 
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetVerticalDpi() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(VERTICALDPI$28);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_default_attribute_value(VERTICALDPI$28); 
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetVerticalDpi() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(VERTICALDPI$28) != null);
    } 
  }
  
  public void setVerticalDpi(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VERTICALDPI$28);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(VERTICALDPI$28); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetVerticalDpi(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(VERTICALDPI$28);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(VERTICALDPI$28); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetVerticalDpi() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(VERTICALDPI$28);
    } 
  }
  
  public long getCopies() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COPIES$30);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(COPIES$30); 
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetCopies() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(COPIES$30);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_default_attribute_value(COPIES$30); 
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetCopies() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(COPIES$30) != null);
    } 
  }
  
  public void setCopies(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COPIES$30);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(COPIES$30); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetCopies(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(COPIES$30);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(COPIES$30); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetCopies() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(COPIES$30);
    } 
  }
  
  public String getId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID$32);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STRelationshipId xgetId() {
    synchronized (monitor()) {
      check_orphaned();
      STRelationshipId sTRelationshipId = null;
      sTRelationshipId = (STRelationshipId)get_store().find_attribute_user(ID$32);
      return sTRelationshipId;
    } 
  }
  
  public boolean isSetId() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ID$32) != null);
    } 
  }
  
  public void setId(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID$32);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ID$32); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetId(STRelationshipId paramSTRelationshipId) {
    synchronized (monitor()) {
      check_orphaned();
      STRelationshipId sTRelationshipId = null;
      sTRelationshipId = (STRelationshipId)get_store().find_attribute_user(ID$32);
      if (sTRelationshipId == null)
        sTRelationshipId = (STRelationshipId)get_store().add_attribute_user(ID$32); 
      sTRelationshipId.set((XmlObject)paramSTRelationshipId);
    } 
  }
  
  public void unsetId() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ID$32);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTPageSetupImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */