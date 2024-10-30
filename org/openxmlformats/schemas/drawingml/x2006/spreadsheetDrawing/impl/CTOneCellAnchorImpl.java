package org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTAnchorClientData;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTConnector;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGraphicalObjectFrame;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShape;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTMarker;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTOneCellAnchor;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTPicture;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape;

public class CTOneCellAnchorImpl extends XmlComplexContentImpl implements CTOneCellAnchor {
  private static final b FROM$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "from");
  
  private static final b EXT$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "ext");
  
  private static final b SP$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "sp");
  
  private static final b GRPSP$6 = new b("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "grpSp");
  
  private static final b GRAPHICFRAME$8 = new b("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "graphicFrame");
  
  private static final b CXNSP$10 = new b("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "cxnSp");
  
  private static final b PIC$12 = new b("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "pic");
  
  private static final b CLIENTDATA$14 = new b("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "clientData");
  
  public CTOneCellAnchorImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTMarker getFrom() {
    synchronized (monitor()) {
      check_orphaned();
      CTMarker cTMarker = null;
      cTMarker = (CTMarker)get_store().find_element_user(FROM$0, 0);
      if (cTMarker == null)
        return null; 
      return cTMarker;
    } 
  }
  
  public void setFrom(CTMarker paramCTMarker) {
    synchronized (monitor()) {
      check_orphaned();
      CTMarker cTMarker = null;
      cTMarker = (CTMarker)get_store().find_element_user(FROM$0, 0);
      if (cTMarker == null)
        cTMarker = (CTMarker)get_store().add_element_user(FROM$0); 
      cTMarker.set((XmlObject)paramCTMarker);
    } 
  }
  
  public CTMarker addNewFrom() {
    synchronized (monitor()) {
      check_orphaned();
      CTMarker cTMarker = null;
      cTMarker = (CTMarker)get_store().add_element_user(FROM$0);
      return cTMarker;
    } 
  }
  
  public CTPositiveSize2D getExt() {
    synchronized (monitor()) {
      check_orphaned();
      CTPositiveSize2D cTPositiveSize2D = null;
      cTPositiveSize2D = (CTPositiveSize2D)get_store().find_element_user(EXT$2, 0);
      if (cTPositiveSize2D == null)
        return null; 
      return cTPositiveSize2D;
    } 
  }
  
  public void setExt(CTPositiveSize2D paramCTPositiveSize2D) {
    synchronized (monitor()) {
      check_orphaned();
      CTPositiveSize2D cTPositiveSize2D = null;
      cTPositiveSize2D = (CTPositiveSize2D)get_store().find_element_user(EXT$2, 0);
      if (cTPositiveSize2D == null)
        cTPositiveSize2D = (CTPositiveSize2D)get_store().add_element_user(EXT$2); 
      cTPositiveSize2D.set((XmlObject)paramCTPositiveSize2D);
    } 
  }
  
  public CTPositiveSize2D addNewExt() {
    synchronized (monitor()) {
      check_orphaned();
      CTPositiveSize2D cTPositiveSize2D = null;
      cTPositiveSize2D = (CTPositiveSize2D)get_store().add_element_user(EXT$2);
      return cTPositiveSize2D;
    } 
  }
  
  public CTShape getSp() {
    synchronized (monitor()) {
      check_orphaned();
      CTShape cTShape = null;
      cTShape = (CTShape)get_store().find_element_user(SP$4, 0);
      if (cTShape == null)
        return null; 
      return cTShape;
    } 
  }
  
  public boolean isSetSp() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SP$4) != 0);
    } 
  }
  
  public void setSp(CTShape paramCTShape) {
    synchronized (monitor()) {
      check_orphaned();
      CTShape cTShape = null;
      cTShape = (CTShape)get_store().find_element_user(SP$4, 0);
      if (cTShape == null)
        cTShape = (CTShape)get_store().add_element_user(SP$4); 
      cTShape.set((XmlObject)paramCTShape);
    } 
  }
  
  public CTShape addNewSp() {
    synchronized (monitor()) {
      check_orphaned();
      CTShape cTShape = null;
      cTShape = (CTShape)get_store().add_element_user(SP$4);
      return cTShape;
    } 
  }
  
  public void unsetSp() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SP$4, 0);
    } 
  }
  
  public CTGroupShape getGrpSp() {
    synchronized (monitor()) {
      check_orphaned();
      CTGroupShape cTGroupShape = null;
      cTGroupShape = (CTGroupShape)get_store().find_element_user(GRPSP$6, 0);
      if (cTGroupShape == null)
        return null; 
      return cTGroupShape;
    } 
  }
  
  public boolean isSetGrpSp() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(GRPSP$6) != 0);
    } 
  }
  
  public void setGrpSp(CTGroupShape paramCTGroupShape) {
    synchronized (monitor()) {
      check_orphaned();
      CTGroupShape cTGroupShape = null;
      cTGroupShape = (CTGroupShape)get_store().find_element_user(GRPSP$6, 0);
      if (cTGroupShape == null)
        cTGroupShape = (CTGroupShape)get_store().add_element_user(GRPSP$6); 
      cTGroupShape.set((XmlObject)paramCTGroupShape);
    } 
  }
  
  public CTGroupShape addNewGrpSp() {
    synchronized (monitor()) {
      check_orphaned();
      CTGroupShape cTGroupShape = null;
      cTGroupShape = (CTGroupShape)get_store().add_element_user(GRPSP$6);
      return cTGroupShape;
    } 
  }
  
  public void unsetGrpSp() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(GRPSP$6, 0);
    } 
  }
  
  public CTGraphicalObjectFrame getGraphicFrame() {
    synchronized (monitor()) {
      check_orphaned();
      CTGraphicalObjectFrame cTGraphicalObjectFrame = null;
      cTGraphicalObjectFrame = (CTGraphicalObjectFrame)get_store().find_element_user(GRAPHICFRAME$8, 0);
      if (cTGraphicalObjectFrame == null)
        return null; 
      return cTGraphicalObjectFrame;
    } 
  }
  
  public boolean isSetGraphicFrame() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(GRAPHICFRAME$8) != 0);
    } 
  }
  
  public void setGraphicFrame(CTGraphicalObjectFrame paramCTGraphicalObjectFrame) {
    synchronized (monitor()) {
      check_orphaned();
      CTGraphicalObjectFrame cTGraphicalObjectFrame = null;
      cTGraphicalObjectFrame = (CTGraphicalObjectFrame)get_store().find_element_user(GRAPHICFRAME$8, 0);
      if (cTGraphicalObjectFrame == null)
        cTGraphicalObjectFrame = (CTGraphicalObjectFrame)get_store().add_element_user(GRAPHICFRAME$8); 
      cTGraphicalObjectFrame.set((XmlObject)paramCTGraphicalObjectFrame);
    } 
  }
  
  public CTGraphicalObjectFrame addNewGraphicFrame() {
    synchronized (monitor()) {
      check_orphaned();
      CTGraphicalObjectFrame cTGraphicalObjectFrame = null;
      cTGraphicalObjectFrame = (CTGraphicalObjectFrame)get_store().add_element_user(GRAPHICFRAME$8);
      return cTGraphicalObjectFrame;
    } 
  }
  
  public void unsetGraphicFrame() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(GRAPHICFRAME$8, 0);
    } 
  }
  
  public CTConnector getCxnSp() {
    synchronized (monitor()) {
      check_orphaned();
      CTConnector cTConnector = null;
      cTConnector = (CTConnector)get_store().find_element_user(CXNSP$10, 0);
      if (cTConnector == null)
        return null; 
      return cTConnector;
    } 
  }
  
  public boolean isSetCxnSp() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(CXNSP$10) != 0);
    } 
  }
  
  public void setCxnSp(CTConnector paramCTConnector) {
    synchronized (monitor()) {
      check_orphaned();
      CTConnector cTConnector = null;
      cTConnector = (CTConnector)get_store().find_element_user(CXNSP$10, 0);
      if (cTConnector == null)
        cTConnector = (CTConnector)get_store().add_element_user(CXNSP$10); 
      cTConnector.set((XmlObject)paramCTConnector);
    } 
  }
  
  public CTConnector addNewCxnSp() {
    synchronized (monitor()) {
      check_orphaned();
      CTConnector cTConnector = null;
      cTConnector = (CTConnector)get_store().add_element_user(CXNSP$10);
      return cTConnector;
    } 
  }
  
  public void unsetCxnSp() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CXNSP$10, 0);
    } 
  }
  
  public CTPicture getPic() {
    synchronized (monitor()) {
      check_orphaned();
      CTPicture cTPicture = null;
      cTPicture = (CTPicture)get_store().find_element_user(PIC$12, 0);
      if (cTPicture == null)
        return null; 
      return cTPicture;
    } 
  }
  
  public boolean isSetPic() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PIC$12) != 0);
    } 
  }
  
  public void setPic(CTPicture paramCTPicture) {
    synchronized (monitor()) {
      check_orphaned();
      CTPicture cTPicture = null;
      cTPicture = (CTPicture)get_store().find_element_user(PIC$12, 0);
      if (cTPicture == null)
        cTPicture = (CTPicture)get_store().add_element_user(PIC$12); 
      cTPicture.set((XmlObject)paramCTPicture);
    } 
  }
  
  public CTPicture addNewPic() {
    synchronized (monitor()) {
      check_orphaned();
      CTPicture cTPicture = null;
      cTPicture = (CTPicture)get_store().add_element_user(PIC$12);
      return cTPicture;
    } 
  }
  
  public void unsetPic() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PIC$12, 0);
    } 
  }
  
  public CTAnchorClientData getClientData() {
    synchronized (monitor()) {
      check_orphaned();
      CTAnchorClientData cTAnchorClientData = null;
      cTAnchorClientData = (CTAnchorClientData)get_store().find_element_user(CLIENTDATA$14, 0);
      if (cTAnchorClientData == null)
        return null; 
      return cTAnchorClientData;
    } 
  }
  
  public void setClientData(CTAnchorClientData paramCTAnchorClientData) {
    synchronized (monitor()) {
      check_orphaned();
      CTAnchorClientData cTAnchorClientData = null;
      cTAnchorClientData = (CTAnchorClientData)get_store().find_element_user(CLIENTDATA$14, 0);
      if (cTAnchorClientData == null)
        cTAnchorClientData = (CTAnchorClientData)get_store().add_element_user(CLIENTDATA$14); 
      cTAnchorClientData.set((XmlObject)paramCTAnchorClientData);
    } 
  }
  
  public CTAnchorClientData addNewClientData() {
    synchronized (monitor()) {
      check_orphaned();
      CTAnchorClientData cTAnchorClientData = null;
      cTAnchorClientData = (CTAnchorClientData)get_store().add_element_user(CLIENTDATA$14);
      return cTAnchorClientData;
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\spreadsheetDrawing\impl\CTOneCellAnchorImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */