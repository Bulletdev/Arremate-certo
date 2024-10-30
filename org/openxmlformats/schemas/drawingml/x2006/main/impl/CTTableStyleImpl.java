package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableBackgroundStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTablePartStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.STGuid;

public class CTTableStyleImpl extends XmlComplexContentImpl implements CTTableStyle {
  private static final b TBLBG$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "tblBg");
  
  private static final b WHOLETBL$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "wholeTbl");
  
  private static final b BAND1H$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "band1H");
  
  private static final b BAND2H$6 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "band2H");
  
  private static final b BAND1V$8 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "band1V");
  
  private static final b BAND2V$10 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "band2V");
  
  private static final b LASTCOL$12 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "lastCol");
  
  private static final b FIRSTCOL$14 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "firstCol");
  
  private static final b LASTROW$16 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "lastRow");
  
  private static final b SECELL$18 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "seCell");
  
  private static final b SWCELL$20 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "swCell");
  
  private static final b FIRSTROW$22 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "firstRow");
  
  private static final b NECELL$24 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "neCell");
  
  private static final b NWCELL$26 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "nwCell");
  
  private static final b EXTLST$28 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "extLst");
  
  private static final b STYLEID$30 = new b("", "styleId");
  
  private static final b STYLENAME$32 = new b("", "styleName");
  
  public CTTableStyleImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTTableBackgroundStyle getTblBg() {
    synchronized (monitor()) {
      check_orphaned();
      CTTableBackgroundStyle cTTableBackgroundStyle = null;
      cTTableBackgroundStyle = (CTTableBackgroundStyle)get_store().find_element_user(TBLBG$0, 0);
      if (cTTableBackgroundStyle == null)
        return null; 
      return cTTableBackgroundStyle;
    } 
  }
  
  public boolean isSetTblBg() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TBLBG$0) != 0);
    } 
  }
  
  public void setTblBg(CTTableBackgroundStyle paramCTTableBackgroundStyle) {
    synchronized (monitor()) {
      check_orphaned();
      CTTableBackgroundStyle cTTableBackgroundStyle = null;
      cTTableBackgroundStyle = (CTTableBackgroundStyle)get_store().find_element_user(TBLBG$0, 0);
      if (cTTableBackgroundStyle == null)
        cTTableBackgroundStyle = (CTTableBackgroundStyle)get_store().add_element_user(TBLBG$0); 
      cTTableBackgroundStyle.set((XmlObject)paramCTTableBackgroundStyle);
    } 
  }
  
  public CTTableBackgroundStyle addNewTblBg() {
    synchronized (monitor()) {
      check_orphaned();
      CTTableBackgroundStyle cTTableBackgroundStyle = null;
      cTTableBackgroundStyle = (CTTableBackgroundStyle)get_store().add_element_user(TBLBG$0);
      return cTTableBackgroundStyle;
    } 
  }
  
  public void unsetTblBg() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TBLBG$0, 0);
    } 
  }
  
  public CTTablePartStyle getWholeTbl() {
    synchronized (monitor()) {
      check_orphaned();
      CTTablePartStyle cTTablePartStyle = null;
      cTTablePartStyle = (CTTablePartStyle)get_store().find_element_user(WHOLETBL$2, 0);
      if (cTTablePartStyle == null)
        return null; 
      return cTTablePartStyle;
    } 
  }
  
  public boolean isSetWholeTbl() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(WHOLETBL$2) != 0);
    } 
  }
  
  public void setWholeTbl(CTTablePartStyle paramCTTablePartStyle) {
    synchronized (monitor()) {
      check_orphaned();
      CTTablePartStyle cTTablePartStyle = null;
      cTTablePartStyle = (CTTablePartStyle)get_store().find_element_user(WHOLETBL$2, 0);
      if (cTTablePartStyle == null)
        cTTablePartStyle = (CTTablePartStyle)get_store().add_element_user(WHOLETBL$2); 
      cTTablePartStyle.set((XmlObject)paramCTTablePartStyle);
    } 
  }
  
  public CTTablePartStyle addNewWholeTbl() {
    synchronized (monitor()) {
      check_orphaned();
      CTTablePartStyle cTTablePartStyle = null;
      cTTablePartStyle = (CTTablePartStyle)get_store().add_element_user(WHOLETBL$2);
      return cTTablePartStyle;
    } 
  }
  
  public void unsetWholeTbl() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(WHOLETBL$2, 0);
    } 
  }
  
  public CTTablePartStyle getBand1H() {
    synchronized (monitor()) {
      check_orphaned();
      CTTablePartStyle cTTablePartStyle = null;
      cTTablePartStyle = (CTTablePartStyle)get_store().find_element_user(BAND1H$4, 0);
      if (cTTablePartStyle == null)
        return null; 
      return cTTablePartStyle;
    } 
  }
  
  public boolean isSetBand1H() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(BAND1H$4) != 0);
    } 
  }
  
  public void setBand1H(CTTablePartStyle paramCTTablePartStyle) {
    synchronized (monitor()) {
      check_orphaned();
      CTTablePartStyle cTTablePartStyle = null;
      cTTablePartStyle = (CTTablePartStyle)get_store().find_element_user(BAND1H$4, 0);
      if (cTTablePartStyle == null)
        cTTablePartStyle = (CTTablePartStyle)get_store().add_element_user(BAND1H$4); 
      cTTablePartStyle.set((XmlObject)paramCTTablePartStyle);
    } 
  }
  
  public CTTablePartStyle addNewBand1H() {
    synchronized (monitor()) {
      check_orphaned();
      CTTablePartStyle cTTablePartStyle = null;
      cTTablePartStyle = (CTTablePartStyle)get_store().add_element_user(BAND1H$4);
      return cTTablePartStyle;
    } 
  }
  
  public void unsetBand1H() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BAND1H$4, 0);
    } 
  }
  
  public CTTablePartStyle getBand2H() {
    synchronized (monitor()) {
      check_orphaned();
      CTTablePartStyle cTTablePartStyle = null;
      cTTablePartStyle = (CTTablePartStyle)get_store().find_element_user(BAND2H$6, 0);
      if (cTTablePartStyle == null)
        return null; 
      return cTTablePartStyle;
    } 
  }
  
  public boolean isSetBand2H() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(BAND2H$6) != 0);
    } 
  }
  
  public void setBand2H(CTTablePartStyle paramCTTablePartStyle) {
    synchronized (monitor()) {
      check_orphaned();
      CTTablePartStyle cTTablePartStyle = null;
      cTTablePartStyle = (CTTablePartStyle)get_store().find_element_user(BAND2H$6, 0);
      if (cTTablePartStyle == null)
        cTTablePartStyle = (CTTablePartStyle)get_store().add_element_user(BAND2H$6); 
      cTTablePartStyle.set((XmlObject)paramCTTablePartStyle);
    } 
  }
  
  public CTTablePartStyle addNewBand2H() {
    synchronized (monitor()) {
      check_orphaned();
      CTTablePartStyle cTTablePartStyle = null;
      cTTablePartStyle = (CTTablePartStyle)get_store().add_element_user(BAND2H$6);
      return cTTablePartStyle;
    } 
  }
  
  public void unsetBand2H() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BAND2H$6, 0);
    } 
  }
  
  public CTTablePartStyle getBand1V() {
    synchronized (monitor()) {
      check_orphaned();
      CTTablePartStyle cTTablePartStyle = null;
      cTTablePartStyle = (CTTablePartStyle)get_store().find_element_user(BAND1V$8, 0);
      if (cTTablePartStyle == null)
        return null; 
      return cTTablePartStyle;
    } 
  }
  
  public boolean isSetBand1V() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(BAND1V$8) != 0);
    } 
  }
  
  public void setBand1V(CTTablePartStyle paramCTTablePartStyle) {
    synchronized (monitor()) {
      check_orphaned();
      CTTablePartStyle cTTablePartStyle = null;
      cTTablePartStyle = (CTTablePartStyle)get_store().find_element_user(BAND1V$8, 0);
      if (cTTablePartStyle == null)
        cTTablePartStyle = (CTTablePartStyle)get_store().add_element_user(BAND1V$8); 
      cTTablePartStyle.set((XmlObject)paramCTTablePartStyle);
    } 
  }
  
  public CTTablePartStyle addNewBand1V() {
    synchronized (monitor()) {
      check_orphaned();
      CTTablePartStyle cTTablePartStyle = null;
      cTTablePartStyle = (CTTablePartStyle)get_store().add_element_user(BAND1V$8);
      return cTTablePartStyle;
    } 
  }
  
  public void unsetBand1V() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BAND1V$8, 0);
    } 
  }
  
  public CTTablePartStyle getBand2V() {
    synchronized (monitor()) {
      check_orphaned();
      CTTablePartStyle cTTablePartStyle = null;
      cTTablePartStyle = (CTTablePartStyle)get_store().find_element_user(BAND2V$10, 0);
      if (cTTablePartStyle == null)
        return null; 
      return cTTablePartStyle;
    } 
  }
  
  public boolean isSetBand2V() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(BAND2V$10) != 0);
    } 
  }
  
  public void setBand2V(CTTablePartStyle paramCTTablePartStyle) {
    synchronized (monitor()) {
      check_orphaned();
      CTTablePartStyle cTTablePartStyle = null;
      cTTablePartStyle = (CTTablePartStyle)get_store().find_element_user(BAND2V$10, 0);
      if (cTTablePartStyle == null)
        cTTablePartStyle = (CTTablePartStyle)get_store().add_element_user(BAND2V$10); 
      cTTablePartStyle.set((XmlObject)paramCTTablePartStyle);
    } 
  }
  
  public CTTablePartStyle addNewBand2V() {
    synchronized (monitor()) {
      check_orphaned();
      CTTablePartStyle cTTablePartStyle = null;
      cTTablePartStyle = (CTTablePartStyle)get_store().add_element_user(BAND2V$10);
      return cTTablePartStyle;
    } 
  }
  
  public void unsetBand2V() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BAND2V$10, 0);
    } 
  }
  
  public CTTablePartStyle getLastCol() {
    synchronized (monitor()) {
      check_orphaned();
      CTTablePartStyle cTTablePartStyle = null;
      cTTablePartStyle = (CTTablePartStyle)get_store().find_element_user(LASTCOL$12, 0);
      if (cTTablePartStyle == null)
        return null; 
      return cTTablePartStyle;
    } 
  }
  
  public boolean isSetLastCol() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(LASTCOL$12) != 0);
    } 
  }
  
  public void setLastCol(CTTablePartStyle paramCTTablePartStyle) {
    synchronized (monitor()) {
      check_orphaned();
      CTTablePartStyle cTTablePartStyle = null;
      cTTablePartStyle = (CTTablePartStyle)get_store().find_element_user(LASTCOL$12, 0);
      if (cTTablePartStyle == null)
        cTTablePartStyle = (CTTablePartStyle)get_store().add_element_user(LASTCOL$12); 
      cTTablePartStyle.set((XmlObject)paramCTTablePartStyle);
    } 
  }
  
  public CTTablePartStyle addNewLastCol() {
    synchronized (monitor()) {
      check_orphaned();
      CTTablePartStyle cTTablePartStyle = null;
      cTTablePartStyle = (CTTablePartStyle)get_store().add_element_user(LASTCOL$12);
      return cTTablePartStyle;
    } 
  }
  
  public void unsetLastCol() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LASTCOL$12, 0);
    } 
  }
  
  public CTTablePartStyle getFirstCol() {
    synchronized (monitor()) {
      check_orphaned();
      CTTablePartStyle cTTablePartStyle = null;
      cTTablePartStyle = (CTTablePartStyle)get_store().find_element_user(FIRSTCOL$14, 0);
      if (cTTablePartStyle == null)
        return null; 
      return cTTablePartStyle;
    } 
  }
  
  public boolean isSetFirstCol() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(FIRSTCOL$14) != 0);
    } 
  }
  
  public void setFirstCol(CTTablePartStyle paramCTTablePartStyle) {
    synchronized (monitor()) {
      check_orphaned();
      CTTablePartStyle cTTablePartStyle = null;
      cTTablePartStyle = (CTTablePartStyle)get_store().find_element_user(FIRSTCOL$14, 0);
      if (cTTablePartStyle == null)
        cTTablePartStyle = (CTTablePartStyle)get_store().add_element_user(FIRSTCOL$14); 
      cTTablePartStyle.set((XmlObject)paramCTTablePartStyle);
    } 
  }
  
  public CTTablePartStyle addNewFirstCol() {
    synchronized (monitor()) {
      check_orphaned();
      CTTablePartStyle cTTablePartStyle = null;
      cTTablePartStyle = (CTTablePartStyle)get_store().add_element_user(FIRSTCOL$14);
      return cTTablePartStyle;
    } 
  }
  
  public void unsetFirstCol() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(FIRSTCOL$14, 0);
    } 
  }
  
  public CTTablePartStyle getLastRow() {
    synchronized (monitor()) {
      check_orphaned();
      CTTablePartStyle cTTablePartStyle = null;
      cTTablePartStyle = (CTTablePartStyle)get_store().find_element_user(LASTROW$16, 0);
      if (cTTablePartStyle == null)
        return null; 
      return cTTablePartStyle;
    } 
  }
  
  public boolean isSetLastRow() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(LASTROW$16) != 0);
    } 
  }
  
  public void setLastRow(CTTablePartStyle paramCTTablePartStyle) {
    synchronized (monitor()) {
      check_orphaned();
      CTTablePartStyle cTTablePartStyle = null;
      cTTablePartStyle = (CTTablePartStyle)get_store().find_element_user(LASTROW$16, 0);
      if (cTTablePartStyle == null)
        cTTablePartStyle = (CTTablePartStyle)get_store().add_element_user(LASTROW$16); 
      cTTablePartStyle.set((XmlObject)paramCTTablePartStyle);
    } 
  }
  
  public CTTablePartStyle addNewLastRow() {
    synchronized (monitor()) {
      check_orphaned();
      CTTablePartStyle cTTablePartStyle = null;
      cTTablePartStyle = (CTTablePartStyle)get_store().add_element_user(LASTROW$16);
      return cTTablePartStyle;
    } 
  }
  
  public void unsetLastRow() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LASTROW$16, 0);
    } 
  }
  
  public CTTablePartStyle getSeCell() {
    synchronized (monitor()) {
      check_orphaned();
      CTTablePartStyle cTTablePartStyle = null;
      cTTablePartStyle = (CTTablePartStyle)get_store().find_element_user(SECELL$18, 0);
      if (cTTablePartStyle == null)
        return null; 
      return cTTablePartStyle;
    } 
  }
  
  public boolean isSetSeCell() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SECELL$18) != 0);
    } 
  }
  
  public void setSeCell(CTTablePartStyle paramCTTablePartStyle) {
    synchronized (monitor()) {
      check_orphaned();
      CTTablePartStyle cTTablePartStyle = null;
      cTTablePartStyle = (CTTablePartStyle)get_store().find_element_user(SECELL$18, 0);
      if (cTTablePartStyle == null)
        cTTablePartStyle = (CTTablePartStyle)get_store().add_element_user(SECELL$18); 
      cTTablePartStyle.set((XmlObject)paramCTTablePartStyle);
    } 
  }
  
  public CTTablePartStyle addNewSeCell() {
    synchronized (monitor()) {
      check_orphaned();
      CTTablePartStyle cTTablePartStyle = null;
      cTTablePartStyle = (CTTablePartStyle)get_store().add_element_user(SECELL$18);
      return cTTablePartStyle;
    } 
  }
  
  public void unsetSeCell() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SECELL$18, 0);
    } 
  }
  
  public CTTablePartStyle getSwCell() {
    synchronized (monitor()) {
      check_orphaned();
      CTTablePartStyle cTTablePartStyle = null;
      cTTablePartStyle = (CTTablePartStyle)get_store().find_element_user(SWCELL$20, 0);
      if (cTTablePartStyle == null)
        return null; 
      return cTTablePartStyle;
    } 
  }
  
  public boolean isSetSwCell() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SWCELL$20) != 0);
    } 
  }
  
  public void setSwCell(CTTablePartStyle paramCTTablePartStyle) {
    synchronized (monitor()) {
      check_orphaned();
      CTTablePartStyle cTTablePartStyle = null;
      cTTablePartStyle = (CTTablePartStyle)get_store().find_element_user(SWCELL$20, 0);
      if (cTTablePartStyle == null)
        cTTablePartStyle = (CTTablePartStyle)get_store().add_element_user(SWCELL$20); 
      cTTablePartStyle.set((XmlObject)paramCTTablePartStyle);
    } 
  }
  
  public CTTablePartStyle addNewSwCell() {
    synchronized (monitor()) {
      check_orphaned();
      CTTablePartStyle cTTablePartStyle = null;
      cTTablePartStyle = (CTTablePartStyle)get_store().add_element_user(SWCELL$20);
      return cTTablePartStyle;
    } 
  }
  
  public void unsetSwCell() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SWCELL$20, 0);
    } 
  }
  
  public CTTablePartStyle getFirstRow() {
    synchronized (monitor()) {
      check_orphaned();
      CTTablePartStyle cTTablePartStyle = null;
      cTTablePartStyle = (CTTablePartStyle)get_store().find_element_user(FIRSTROW$22, 0);
      if (cTTablePartStyle == null)
        return null; 
      return cTTablePartStyle;
    } 
  }
  
  public boolean isSetFirstRow() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(FIRSTROW$22) != 0);
    } 
  }
  
  public void setFirstRow(CTTablePartStyle paramCTTablePartStyle) {
    synchronized (monitor()) {
      check_orphaned();
      CTTablePartStyle cTTablePartStyle = null;
      cTTablePartStyle = (CTTablePartStyle)get_store().find_element_user(FIRSTROW$22, 0);
      if (cTTablePartStyle == null)
        cTTablePartStyle = (CTTablePartStyle)get_store().add_element_user(FIRSTROW$22); 
      cTTablePartStyle.set((XmlObject)paramCTTablePartStyle);
    } 
  }
  
  public CTTablePartStyle addNewFirstRow() {
    synchronized (monitor()) {
      check_orphaned();
      CTTablePartStyle cTTablePartStyle = null;
      cTTablePartStyle = (CTTablePartStyle)get_store().add_element_user(FIRSTROW$22);
      return cTTablePartStyle;
    } 
  }
  
  public void unsetFirstRow() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(FIRSTROW$22, 0);
    } 
  }
  
  public CTTablePartStyle getNeCell() {
    synchronized (monitor()) {
      check_orphaned();
      CTTablePartStyle cTTablePartStyle = null;
      cTTablePartStyle = (CTTablePartStyle)get_store().find_element_user(NECELL$24, 0);
      if (cTTablePartStyle == null)
        return null; 
      return cTTablePartStyle;
    } 
  }
  
  public boolean isSetNeCell() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(NECELL$24) != 0);
    } 
  }
  
  public void setNeCell(CTTablePartStyle paramCTTablePartStyle) {
    synchronized (monitor()) {
      check_orphaned();
      CTTablePartStyle cTTablePartStyle = null;
      cTTablePartStyle = (CTTablePartStyle)get_store().find_element_user(NECELL$24, 0);
      if (cTTablePartStyle == null)
        cTTablePartStyle = (CTTablePartStyle)get_store().add_element_user(NECELL$24); 
      cTTablePartStyle.set((XmlObject)paramCTTablePartStyle);
    } 
  }
  
  public CTTablePartStyle addNewNeCell() {
    synchronized (monitor()) {
      check_orphaned();
      CTTablePartStyle cTTablePartStyle = null;
      cTTablePartStyle = (CTTablePartStyle)get_store().add_element_user(NECELL$24);
      return cTTablePartStyle;
    } 
  }
  
  public void unsetNeCell() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(NECELL$24, 0);
    } 
  }
  
  public CTTablePartStyle getNwCell() {
    synchronized (monitor()) {
      check_orphaned();
      CTTablePartStyle cTTablePartStyle = null;
      cTTablePartStyle = (CTTablePartStyle)get_store().find_element_user(NWCELL$26, 0);
      if (cTTablePartStyle == null)
        return null; 
      return cTTablePartStyle;
    } 
  }
  
  public boolean isSetNwCell() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(NWCELL$26) != 0);
    } 
  }
  
  public void setNwCell(CTTablePartStyle paramCTTablePartStyle) {
    synchronized (monitor()) {
      check_orphaned();
      CTTablePartStyle cTTablePartStyle = null;
      cTTablePartStyle = (CTTablePartStyle)get_store().find_element_user(NWCELL$26, 0);
      if (cTTablePartStyle == null)
        cTTablePartStyle = (CTTablePartStyle)get_store().add_element_user(NWCELL$26); 
      cTTablePartStyle.set((XmlObject)paramCTTablePartStyle);
    } 
  }
  
  public CTTablePartStyle addNewNwCell() {
    synchronized (monitor()) {
      check_orphaned();
      CTTablePartStyle cTTablePartStyle = null;
      cTTablePartStyle = (CTTablePartStyle)get_store().add_element_user(NWCELL$26);
      return cTTablePartStyle;
    } 
  }
  
  public void unsetNwCell() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(NWCELL$26, 0);
    } 
  }
  
  public CTOfficeArtExtensionList getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().find_element_user(EXTLST$28, 0);
      if (cTOfficeArtExtensionList == null)
        return null; 
      return cTOfficeArtExtensionList;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$28) != 0);
    } 
  }
  
  public void setExtLst(CTOfficeArtExtensionList paramCTOfficeArtExtensionList) {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().find_element_user(EXTLST$28, 0);
      if (cTOfficeArtExtensionList == null)
        cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().add_element_user(EXTLST$28); 
      cTOfficeArtExtensionList.set((XmlObject)paramCTOfficeArtExtensionList);
    } 
  }
  
  public CTOfficeArtExtensionList addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().add_element_user(EXTLST$28);
      return cTOfficeArtExtensionList;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$28, 0);
    } 
  }
  
  public String getStyleId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(STYLEID$30);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STGuid xgetStyleId() {
    synchronized (monitor()) {
      check_orphaned();
      STGuid sTGuid = null;
      sTGuid = (STGuid)get_store().find_attribute_user(STYLEID$30);
      return sTGuid;
    } 
  }
  
  public void setStyleId(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(STYLEID$30);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(STYLEID$30); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetStyleId(STGuid paramSTGuid) {
    synchronized (monitor()) {
      check_orphaned();
      STGuid sTGuid = null;
      sTGuid = (STGuid)get_store().find_attribute_user(STYLEID$30);
      if (sTGuid == null)
        sTGuid = (STGuid)get_store().add_attribute_user(STYLEID$30); 
      sTGuid.set((XmlObject)paramSTGuid);
    } 
  }
  
  public String getStyleName() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(STYLENAME$32);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetStyleName() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(STYLENAME$32);
      return xmlString;
    } 
  }
  
  public void setStyleName(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(STYLENAME$32);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(STYLENAME$32); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetStyleName(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(STYLENAME$32);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(STYLENAME$32); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTTableStyleImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */