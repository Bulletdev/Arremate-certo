package org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTConnector;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGraphicalObjectFrame;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShape;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShapeNonVisual;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTPicture;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape;

public class CTGroupShapeImpl extends XmlComplexContentImpl implements CTGroupShape {
  private static final b NVGRPSPPR$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "nvGrpSpPr");
  
  private static final b GRPSPPR$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "grpSpPr");
  
  private static final b SP$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "sp");
  
  private static final b GRPSP$6 = new b("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "grpSp");
  
  private static final b GRAPHICFRAME$8 = new b("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "graphicFrame");
  
  private static final b CXNSP$10 = new b("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "cxnSp");
  
  private static final b PIC$12 = new b("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "pic");
  
  public CTGroupShapeImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTGroupShapeNonVisual getNvGrpSpPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTGroupShapeNonVisual cTGroupShapeNonVisual = null;
      cTGroupShapeNonVisual = (CTGroupShapeNonVisual)get_store().find_element_user(NVGRPSPPR$0, 0);
      if (cTGroupShapeNonVisual == null)
        return null; 
      return cTGroupShapeNonVisual;
    } 
  }
  
  public void setNvGrpSpPr(CTGroupShapeNonVisual paramCTGroupShapeNonVisual) {
    synchronized (monitor()) {
      check_orphaned();
      CTGroupShapeNonVisual cTGroupShapeNonVisual = null;
      cTGroupShapeNonVisual = (CTGroupShapeNonVisual)get_store().find_element_user(NVGRPSPPR$0, 0);
      if (cTGroupShapeNonVisual == null)
        cTGroupShapeNonVisual = (CTGroupShapeNonVisual)get_store().add_element_user(NVGRPSPPR$0); 
      cTGroupShapeNonVisual.set((XmlObject)paramCTGroupShapeNonVisual);
    } 
  }
  
  public CTGroupShapeNonVisual addNewNvGrpSpPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTGroupShapeNonVisual cTGroupShapeNonVisual = null;
      cTGroupShapeNonVisual = (CTGroupShapeNonVisual)get_store().add_element_user(NVGRPSPPR$0);
      return cTGroupShapeNonVisual;
    } 
  }
  
  public CTGroupShapeProperties getGrpSpPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTGroupShapeProperties cTGroupShapeProperties = null;
      cTGroupShapeProperties = (CTGroupShapeProperties)get_store().find_element_user(GRPSPPR$2, 0);
      if (cTGroupShapeProperties == null)
        return null; 
      return cTGroupShapeProperties;
    } 
  }
  
  public void setGrpSpPr(CTGroupShapeProperties paramCTGroupShapeProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTGroupShapeProperties cTGroupShapeProperties = null;
      cTGroupShapeProperties = (CTGroupShapeProperties)get_store().find_element_user(GRPSPPR$2, 0);
      if (cTGroupShapeProperties == null)
        cTGroupShapeProperties = (CTGroupShapeProperties)get_store().add_element_user(GRPSPPR$2); 
      cTGroupShapeProperties.set((XmlObject)paramCTGroupShapeProperties);
    } 
  }
  
  public CTGroupShapeProperties addNewGrpSpPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTGroupShapeProperties cTGroupShapeProperties = null;
      cTGroupShapeProperties = (CTGroupShapeProperties)get_store().add_element_user(GRPSPPR$2);
      return cTGroupShapeProperties;
    } 
  }
  
  public List<CTShape> getSpList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTShape>)new SpList(this);
    } 
  }
  
  public CTShape[] getSpArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(SP$4, arrayList);
      CTShape[] arrayOfCTShape = new CTShape[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTShape);
      return arrayOfCTShape;
    } 
  }
  
  public CTShape getSpArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTShape cTShape = null;
      cTShape = (CTShape)get_store().find_element_user(SP$4, paramInt);
      if (cTShape == null)
        throw new IndexOutOfBoundsException(); 
      return cTShape;
    } 
  }
  
  public int sizeOfSpArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(SP$4);
    } 
  }
  
  public void setSpArray(CTShape[] paramArrayOfCTShape) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTShape, SP$4);
    } 
  }
  
  public void setSpArray(int paramInt, CTShape paramCTShape) {
    synchronized (monitor()) {
      check_orphaned();
      CTShape cTShape = null;
      cTShape = (CTShape)get_store().find_element_user(SP$4, paramInt);
      if (cTShape == null)
        throw new IndexOutOfBoundsException(); 
      cTShape.set((XmlObject)paramCTShape);
    } 
  }
  
  public CTShape insertNewSp(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTShape cTShape = null;
      cTShape = (CTShape)get_store().insert_element_user(SP$4, paramInt);
      return cTShape;
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
  
  public void removeSp(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SP$4, paramInt);
    } 
  }
  
  public List<CTGroupShape> getGrpSpList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTGroupShape>)new GrpSpList(this);
    } 
  }
  
  public CTGroupShape[] getGrpSpArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(GRPSP$6, arrayList);
      CTGroupShape[] arrayOfCTGroupShape = new CTGroupShape[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTGroupShape);
      return arrayOfCTGroupShape;
    } 
  }
  
  public CTGroupShape getGrpSpArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTGroupShape cTGroupShape = null;
      cTGroupShape = (CTGroupShape)get_store().find_element_user(GRPSP$6, paramInt);
      if (cTGroupShape == null)
        throw new IndexOutOfBoundsException(); 
      return cTGroupShape;
    } 
  }
  
  public int sizeOfGrpSpArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(GRPSP$6);
    } 
  }
  
  public void setGrpSpArray(CTGroupShape[] paramArrayOfCTGroupShape) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTGroupShape, GRPSP$6);
    } 
  }
  
  public void setGrpSpArray(int paramInt, CTGroupShape paramCTGroupShape) {
    synchronized (monitor()) {
      check_orphaned();
      CTGroupShape cTGroupShape = null;
      cTGroupShape = (CTGroupShape)get_store().find_element_user(GRPSP$6, paramInt);
      if (cTGroupShape == null)
        throw new IndexOutOfBoundsException(); 
      cTGroupShape.set((XmlObject)paramCTGroupShape);
    } 
  }
  
  public CTGroupShape insertNewGrpSp(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTGroupShape cTGroupShape = null;
      cTGroupShape = (CTGroupShape)get_store().insert_element_user(GRPSP$6, paramInt);
      return cTGroupShape;
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
  
  public void removeGrpSp(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(GRPSP$6, paramInt);
    } 
  }
  
  public List<CTGraphicalObjectFrame> getGraphicFrameList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTGraphicalObjectFrame>)new GraphicFrameList(this);
    } 
  }
  
  public CTGraphicalObjectFrame[] getGraphicFrameArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(GRAPHICFRAME$8, arrayList);
      CTGraphicalObjectFrame[] arrayOfCTGraphicalObjectFrame = new CTGraphicalObjectFrame[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTGraphicalObjectFrame);
      return arrayOfCTGraphicalObjectFrame;
    } 
  }
  
  public CTGraphicalObjectFrame getGraphicFrameArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTGraphicalObjectFrame cTGraphicalObjectFrame = null;
      cTGraphicalObjectFrame = (CTGraphicalObjectFrame)get_store().find_element_user(GRAPHICFRAME$8, paramInt);
      if (cTGraphicalObjectFrame == null)
        throw new IndexOutOfBoundsException(); 
      return cTGraphicalObjectFrame;
    } 
  }
  
  public int sizeOfGraphicFrameArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(GRAPHICFRAME$8);
    } 
  }
  
  public void setGraphicFrameArray(CTGraphicalObjectFrame[] paramArrayOfCTGraphicalObjectFrame) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTGraphicalObjectFrame, GRAPHICFRAME$8);
    } 
  }
  
  public void setGraphicFrameArray(int paramInt, CTGraphicalObjectFrame paramCTGraphicalObjectFrame) {
    synchronized (monitor()) {
      check_orphaned();
      CTGraphicalObjectFrame cTGraphicalObjectFrame = null;
      cTGraphicalObjectFrame = (CTGraphicalObjectFrame)get_store().find_element_user(GRAPHICFRAME$8, paramInt);
      if (cTGraphicalObjectFrame == null)
        throw new IndexOutOfBoundsException(); 
      cTGraphicalObjectFrame.set((XmlObject)paramCTGraphicalObjectFrame);
    } 
  }
  
  public CTGraphicalObjectFrame insertNewGraphicFrame(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTGraphicalObjectFrame cTGraphicalObjectFrame = null;
      cTGraphicalObjectFrame = (CTGraphicalObjectFrame)get_store().insert_element_user(GRAPHICFRAME$8, paramInt);
      return cTGraphicalObjectFrame;
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
  
  public void removeGraphicFrame(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(GRAPHICFRAME$8, paramInt);
    } 
  }
  
  public List<CTConnector> getCxnSpList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTConnector>)new CxnSpList(this);
    } 
  }
  
  public CTConnector[] getCxnSpArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(CXNSP$10, arrayList);
      CTConnector[] arrayOfCTConnector = new CTConnector[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTConnector);
      return arrayOfCTConnector;
    } 
  }
  
  public CTConnector getCxnSpArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTConnector cTConnector = null;
      cTConnector = (CTConnector)get_store().find_element_user(CXNSP$10, paramInt);
      if (cTConnector == null)
        throw new IndexOutOfBoundsException(); 
      return cTConnector;
    } 
  }
  
  public int sizeOfCxnSpArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(CXNSP$10);
    } 
  }
  
  public void setCxnSpArray(CTConnector[] paramArrayOfCTConnector) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTConnector, CXNSP$10);
    } 
  }
  
  public void setCxnSpArray(int paramInt, CTConnector paramCTConnector) {
    synchronized (monitor()) {
      check_orphaned();
      CTConnector cTConnector = null;
      cTConnector = (CTConnector)get_store().find_element_user(CXNSP$10, paramInt);
      if (cTConnector == null)
        throw new IndexOutOfBoundsException(); 
      cTConnector.set((XmlObject)paramCTConnector);
    } 
  }
  
  public CTConnector insertNewCxnSp(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTConnector cTConnector = null;
      cTConnector = (CTConnector)get_store().insert_element_user(CXNSP$10, paramInt);
      return cTConnector;
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
  
  public void removeCxnSp(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CXNSP$10, paramInt);
    } 
  }
  
  public List<CTPicture> getPicList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTPicture>)new PicList(this);
    } 
  }
  
  public CTPicture[] getPicArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(PIC$12, arrayList);
      CTPicture[] arrayOfCTPicture = new CTPicture[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTPicture);
      return arrayOfCTPicture;
    } 
  }
  
  public CTPicture getPicArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPicture cTPicture = null;
      cTPicture = (CTPicture)get_store().find_element_user(PIC$12, paramInt);
      if (cTPicture == null)
        throw new IndexOutOfBoundsException(); 
      return cTPicture;
    } 
  }
  
  public int sizeOfPicArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(PIC$12);
    } 
  }
  
  public void setPicArray(CTPicture[] paramArrayOfCTPicture) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTPicture, PIC$12);
    } 
  }
  
  public void setPicArray(int paramInt, CTPicture paramCTPicture) {
    synchronized (monitor()) {
      check_orphaned();
      CTPicture cTPicture = null;
      cTPicture = (CTPicture)get_store().find_element_user(PIC$12, paramInt);
      if (cTPicture == null)
        throw new IndexOutOfBoundsException(); 
      cTPicture.set((XmlObject)paramCTPicture);
    } 
  }
  
  public CTPicture insertNewPic(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPicture cTPicture = null;
      cTPicture = (CTPicture)get_store().insert_element_user(PIC$12, paramInt);
      return cTPicture;
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
  
  public void removePic(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PIC$12, paramInt);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\spreadsheetDrawing\impl\CTGroupShapeImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */