package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorders;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellStyleXfs;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellStyles;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellXfs;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColors;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxfs;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFills;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFonts;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTNumFmts;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyles;

public class CTStylesheetImpl extends XmlComplexContentImpl implements CTStylesheet {
  private static final b NUMFMTS$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "numFmts");
  
  private static final b FONTS$2 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "fonts");
  
  private static final b FILLS$4 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "fills");
  
  private static final b BORDERS$6 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "borders");
  
  private static final b CELLSTYLEXFS$8 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "cellStyleXfs");
  
  private static final b CELLXFS$10 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "cellXfs");
  
  private static final b CELLSTYLES$12 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "cellStyles");
  
  private static final b DXFS$14 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "dxfs");
  
  private static final b TABLESTYLES$16 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "tableStyles");
  
  private static final b COLORS$18 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "colors");
  
  private static final b EXTLST$20 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "extLst");
  
  public CTStylesheetImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTNumFmts getNumFmts() {
    synchronized (monitor()) {
      check_orphaned();
      CTNumFmts cTNumFmts = null;
      cTNumFmts = (CTNumFmts)get_store().find_element_user(NUMFMTS$0, 0);
      if (cTNumFmts == null)
        return null; 
      return cTNumFmts;
    } 
  }
  
  public boolean isSetNumFmts() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(NUMFMTS$0) != 0);
    } 
  }
  
  public void setNumFmts(CTNumFmts paramCTNumFmts) {
    synchronized (monitor()) {
      check_orphaned();
      CTNumFmts cTNumFmts = null;
      cTNumFmts = (CTNumFmts)get_store().find_element_user(NUMFMTS$0, 0);
      if (cTNumFmts == null)
        cTNumFmts = (CTNumFmts)get_store().add_element_user(NUMFMTS$0); 
      cTNumFmts.set((XmlObject)paramCTNumFmts);
    } 
  }
  
  public CTNumFmts addNewNumFmts() {
    synchronized (monitor()) {
      check_orphaned();
      CTNumFmts cTNumFmts = null;
      cTNumFmts = (CTNumFmts)get_store().add_element_user(NUMFMTS$0);
      return cTNumFmts;
    } 
  }
  
  public void unsetNumFmts() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(NUMFMTS$0, 0);
    } 
  }
  
  public CTFonts getFonts() {
    synchronized (monitor()) {
      check_orphaned();
      CTFonts cTFonts = null;
      cTFonts = (CTFonts)get_store().find_element_user(FONTS$2, 0);
      if (cTFonts == null)
        return null; 
      return cTFonts;
    } 
  }
  
  public boolean isSetFonts() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(FONTS$2) != 0);
    } 
  }
  
  public void setFonts(CTFonts paramCTFonts) {
    synchronized (monitor()) {
      check_orphaned();
      CTFonts cTFonts = null;
      cTFonts = (CTFonts)get_store().find_element_user(FONTS$2, 0);
      if (cTFonts == null)
        cTFonts = (CTFonts)get_store().add_element_user(FONTS$2); 
      cTFonts.set((XmlObject)paramCTFonts);
    } 
  }
  
  public CTFonts addNewFonts() {
    synchronized (monitor()) {
      check_orphaned();
      CTFonts cTFonts = null;
      cTFonts = (CTFonts)get_store().add_element_user(FONTS$2);
      return cTFonts;
    } 
  }
  
  public void unsetFonts() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(FONTS$2, 0);
    } 
  }
  
  public CTFills getFills() {
    synchronized (monitor()) {
      check_orphaned();
      CTFills cTFills = null;
      cTFills = (CTFills)get_store().find_element_user(FILLS$4, 0);
      if (cTFills == null)
        return null; 
      return cTFills;
    } 
  }
  
  public boolean isSetFills() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(FILLS$4) != 0);
    } 
  }
  
  public void setFills(CTFills paramCTFills) {
    synchronized (monitor()) {
      check_orphaned();
      CTFills cTFills = null;
      cTFills = (CTFills)get_store().find_element_user(FILLS$4, 0);
      if (cTFills == null)
        cTFills = (CTFills)get_store().add_element_user(FILLS$4); 
      cTFills.set((XmlObject)paramCTFills);
    } 
  }
  
  public CTFills addNewFills() {
    synchronized (monitor()) {
      check_orphaned();
      CTFills cTFills = null;
      cTFills = (CTFills)get_store().add_element_user(FILLS$4);
      return cTFills;
    } 
  }
  
  public void unsetFills() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(FILLS$4, 0);
    } 
  }
  
  public CTBorders getBorders() {
    synchronized (monitor()) {
      check_orphaned();
      CTBorders cTBorders = null;
      cTBorders = (CTBorders)get_store().find_element_user(BORDERS$6, 0);
      if (cTBorders == null)
        return null; 
      return cTBorders;
    } 
  }
  
  public boolean isSetBorders() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(BORDERS$6) != 0);
    } 
  }
  
  public void setBorders(CTBorders paramCTBorders) {
    synchronized (monitor()) {
      check_orphaned();
      CTBorders cTBorders = null;
      cTBorders = (CTBorders)get_store().find_element_user(BORDERS$6, 0);
      if (cTBorders == null)
        cTBorders = (CTBorders)get_store().add_element_user(BORDERS$6); 
      cTBorders.set((XmlObject)paramCTBorders);
    } 
  }
  
  public CTBorders addNewBorders() {
    synchronized (monitor()) {
      check_orphaned();
      CTBorders cTBorders = null;
      cTBorders = (CTBorders)get_store().add_element_user(BORDERS$6);
      return cTBorders;
    } 
  }
  
  public void unsetBorders() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BORDERS$6, 0);
    } 
  }
  
  public CTCellStyleXfs getCellStyleXfs() {
    synchronized (monitor()) {
      check_orphaned();
      CTCellStyleXfs cTCellStyleXfs = null;
      cTCellStyleXfs = (CTCellStyleXfs)get_store().find_element_user(CELLSTYLEXFS$8, 0);
      if (cTCellStyleXfs == null)
        return null; 
      return cTCellStyleXfs;
    } 
  }
  
  public boolean isSetCellStyleXfs() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(CELLSTYLEXFS$8) != 0);
    } 
  }
  
  public void setCellStyleXfs(CTCellStyleXfs paramCTCellStyleXfs) {
    synchronized (monitor()) {
      check_orphaned();
      CTCellStyleXfs cTCellStyleXfs = null;
      cTCellStyleXfs = (CTCellStyleXfs)get_store().find_element_user(CELLSTYLEXFS$8, 0);
      if (cTCellStyleXfs == null)
        cTCellStyleXfs = (CTCellStyleXfs)get_store().add_element_user(CELLSTYLEXFS$8); 
      cTCellStyleXfs.set((XmlObject)paramCTCellStyleXfs);
    } 
  }
  
  public CTCellStyleXfs addNewCellStyleXfs() {
    synchronized (monitor()) {
      check_orphaned();
      CTCellStyleXfs cTCellStyleXfs = null;
      cTCellStyleXfs = (CTCellStyleXfs)get_store().add_element_user(CELLSTYLEXFS$8);
      return cTCellStyleXfs;
    } 
  }
  
  public void unsetCellStyleXfs() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CELLSTYLEXFS$8, 0);
    } 
  }
  
  public CTCellXfs getCellXfs() {
    synchronized (monitor()) {
      check_orphaned();
      CTCellXfs cTCellXfs = null;
      cTCellXfs = (CTCellXfs)get_store().find_element_user(CELLXFS$10, 0);
      if (cTCellXfs == null)
        return null; 
      return cTCellXfs;
    } 
  }
  
  public boolean isSetCellXfs() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(CELLXFS$10) != 0);
    } 
  }
  
  public void setCellXfs(CTCellXfs paramCTCellXfs) {
    synchronized (monitor()) {
      check_orphaned();
      CTCellXfs cTCellXfs = null;
      cTCellXfs = (CTCellXfs)get_store().find_element_user(CELLXFS$10, 0);
      if (cTCellXfs == null)
        cTCellXfs = (CTCellXfs)get_store().add_element_user(CELLXFS$10); 
      cTCellXfs.set((XmlObject)paramCTCellXfs);
    } 
  }
  
  public CTCellXfs addNewCellXfs() {
    synchronized (monitor()) {
      check_orphaned();
      CTCellXfs cTCellXfs = null;
      cTCellXfs = (CTCellXfs)get_store().add_element_user(CELLXFS$10);
      return cTCellXfs;
    } 
  }
  
  public void unsetCellXfs() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CELLXFS$10, 0);
    } 
  }
  
  public CTCellStyles getCellStyles() {
    synchronized (monitor()) {
      check_orphaned();
      CTCellStyles cTCellStyles = null;
      cTCellStyles = (CTCellStyles)get_store().find_element_user(CELLSTYLES$12, 0);
      if (cTCellStyles == null)
        return null; 
      return cTCellStyles;
    } 
  }
  
  public boolean isSetCellStyles() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(CELLSTYLES$12) != 0);
    } 
  }
  
  public void setCellStyles(CTCellStyles paramCTCellStyles) {
    synchronized (monitor()) {
      check_orphaned();
      CTCellStyles cTCellStyles = null;
      cTCellStyles = (CTCellStyles)get_store().find_element_user(CELLSTYLES$12, 0);
      if (cTCellStyles == null)
        cTCellStyles = (CTCellStyles)get_store().add_element_user(CELLSTYLES$12); 
      cTCellStyles.set((XmlObject)paramCTCellStyles);
    } 
  }
  
  public CTCellStyles addNewCellStyles() {
    synchronized (monitor()) {
      check_orphaned();
      CTCellStyles cTCellStyles = null;
      cTCellStyles = (CTCellStyles)get_store().add_element_user(CELLSTYLES$12);
      return cTCellStyles;
    } 
  }
  
  public void unsetCellStyles() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CELLSTYLES$12, 0);
    } 
  }
  
  public CTDxfs getDxfs() {
    synchronized (monitor()) {
      check_orphaned();
      CTDxfs cTDxfs = null;
      cTDxfs = (CTDxfs)get_store().find_element_user(DXFS$14, 0);
      if (cTDxfs == null)
        return null; 
      return cTDxfs;
    } 
  }
  
  public boolean isSetDxfs() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DXFS$14) != 0);
    } 
  }
  
  public void setDxfs(CTDxfs paramCTDxfs) {
    synchronized (monitor()) {
      check_orphaned();
      CTDxfs cTDxfs = null;
      cTDxfs = (CTDxfs)get_store().find_element_user(DXFS$14, 0);
      if (cTDxfs == null)
        cTDxfs = (CTDxfs)get_store().add_element_user(DXFS$14); 
      cTDxfs.set((XmlObject)paramCTDxfs);
    } 
  }
  
  public CTDxfs addNewDxfs() {
    synchronized (monitor()) {
      check_orphaned();
      CTDxfs cTDxfs = null;
      cTDxfs = (CTDxfs)get_store().add_element_user(DXFS$14);
      return cTDxfs;
    } 
  }
  
  public void unsetDxfs() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DXFS$14, 0);
    } 
  }
  
  public CTTableStyles getTableStyles() {
    synchronized (monitor()) {
      check_orphaned();
      CTTableStyles cTTableStyles = null;
      cTTableStyles = (CTTableStyles)get_store().find_element_user(TABLESTYLES$16, 0);
      if (cTTableStyles == null)
        return null; 
      return cTTableStyles;
    } 
  }
  
  public boolean isSetTableStyles() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TABLESTYLES$16) != 0);
    } 
  }
  
  public void setTableStyles(CTTableStyles paramCTTableStyles) {
    synchronized (monitor()) {
      check_orphaned();
      CTTableStyles cTTableStyles = null;
      cTTableStyles = (CTTableStyles)get_store().find_element_user(TABLESTYLES$16, 0);
      if (cTTableStyles == null)
        cTTableStyles = (CTTableStyles)get_store().add_element_user(TABLESTYLES$16); 
      cTTableStyles.set((XmlObject)paramCTTableStyles);
    } 
  }
  
  public CTTableStyles addNewTableStyles() {
    synchronized (monitor()) {
      check_orphaned();
      CTTableStyles cTTableStyles = null;
      cTTableStyles = (CTTableStyles)get_store().add_element_user(TABLESTYLES$16);
      return cTTableStyles;
    } 
  }
  
  public void unsetTableStyles() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TABLESTYLES$16, 0);
    } 
  }
  
  public CTColors getColors() {
    synchronized (monitor()) {
      check_orphaned();
      CTColors cTColors = null;
      cTColors = (CTColors)get_store().find_element_user(COLORS$18, 0);
      if (cTColors == null)
        return null; 
      return cTColors;
    } 
  }
  
  public boolean isSetColors() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(COLORS$18) != 0);
    } 
  }
  
  public void setColors(CTColors paramCTColors) {
    synchronized (monitor()) {
      check_orphaned();
      CTColors cTColors = null;
      cTColors = (CTColors)get_store().find_element_user(COLORS$18, 0);
      if (cTColors == null)
        cTColors = (CTColors)get_store().add_element_user(COLORS$18); 
      cTColors.set((XmlObject)paramCTColors);
    } 
  }
  
  public CTColors addNewColors() {
    synchronized (monitor()) {
      check_orphaned();
      CTColors cTColors = null;
      cTColors = (CTColors)get_store().add_element_user(COLORS$18);
      return cTColors;
    } 
  }
  
  public void unsetColors() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(COLORS$18, 0);
    } 
  }
  
  public CTExtensionList getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$20, 0);
      if (cTExtensionList == null)
        return null; 
      return cTExtensionList;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$20) != 0);
    } 
  }
  
  public void setExtLst(CTExtensionList paramCTExtensionList) {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$20, 0);
      if (cTExtensionList == null)
        cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$20); 
      cTExtensionList.set((XmlObject)paramCTExtensionList);
    } 
  }
  
  public CTExtensionList addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$20);
      return cTExtensionList;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$20, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTStylesheetImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */