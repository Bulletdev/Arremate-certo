package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties;
import org.openxmlformats.schemas.presentationml.x2006.main.CTConnector;
import org.openxmlformats.schemas.presentationml.x2006.main.CTExtensionListModify;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShapeNonVisual;
import org.openxmlformats.schemas.presentationml.x2006.main.CTPicture;
import org.openxmlformats.schemas.presentationml.x2006.main.CTShape;

public class CTGroupShapeImpl extends XmlComplexContentImpl implements CTGroupShape {
  private static final b NVGRPSPPR$0 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "nvGrpSpPr");
  
  private static final b GRPSPPR$2 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "grpSpPr");
  
  private static final b SP$4 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "sp");
  
  private static final b GRPSP$6 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "grpSp");
  
  private static final b GRAPHICFRAME$8 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "graphicFrame");
  
  private static final b CXNSP$10 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "cxnSp");
  
  private static final b PIC$12 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "pic");
  
  private static final b EXTLST$14 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "extLst");
  
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
      final class SpList extends AbstractList<CTShape> {
        public CTShape get(int param1Int) {
          return CTGroupShapeImpl.this.getSpArray(param1Int);
        }
        
        public CTShape set(int param1Int, CTShape param1CTShape) {
          CTShape cTShape = CTGroupShapeImpl.this.getSpArray(param1Int);
          CTGroupShapeImpl.this.setSpArray(param1Int, param1CTShape);
          return cTShape;
        }
        
        public void add(int param1Int, CTShape param1CTShape) {
          CTGroupShapeImpl.this.insertNewSp(param1Int).set((XmlObject)param1CTShape);
        }
        
        public CTShape remove(int param1Int) {
          CTShape cTShape = CTGroupShapeImpl.this.getSpArray(param1Int);
          CTGroupShapeImpl.this.removeSp(param1Int);
          return cTShape;
        }
        
        public int size() {
          return CTGroupShapeImpl.this.sizeOfSpArray();
        }
      };
      return new SpList();
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
      final class GrpSpList extends AbstractList<CTGroupShape> {
        public CTGroupShape get(int param1Int) {
          return CTGroupShapeImpl.this.getGrpSpArray(param1Int);
        }
        
        public CTGroupShape set(int param1Int, CTGroupShape param1CTGroupShape) {
          CTGroupShape cTGroupShape = CTGroupShapeImpl.this.getGrpSpArray(param1Int);
          CTGroupShapeImpl.this.setGrpSpArray(param1Int, param1CTGroupShape);
          return cTGroupShape;
        }
        
        public void add(int param1Int, CTGroupShape param1CTGroupShape) {
          CTGroupShapeImpl.this.insertNewGrpSp(param1Int).set((XmlObject)param1CTGroupShape);
        }
        
        public CTGroupShape remove(int param1Int) {
          CTGroupShape cTGroupShape = CTGroupShapeImpl.this.getGrpSpArray(param1Int);
          CTGroupShapeImpl.this.removeGrpSp(param1Int);
          return cTGroupShape;
        }
        
        public int size() {
          return CTGroupShapeImpl.this.sizeOfGrpSpArray();
        }
      };
      return new GrpSpList();
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
      final class GraphicFrameList extends AbstractList<CTGraphicalObjectFrame> {
        public CTGraphicalObjectFrame get(int param1Int) {
          return CTGroupShapeImpl.this.getGraphicFrameArray(param1Int);
        }
        
        public CTGraphicalObjectFrame set(int param1Int, CTGraphicalObjectFrame param1CTGraphicalObjectFrame) {
          CTGraphicalObjectFrame cTGraphicalObjectFrame = CTGroupShapeImpl.this.getGraphicFrameArray(param1Int);
          CTGroupShapeImpl.this.setGraphicFrameArray(param1Int, param1CTGraphicalObjectFrame);
          return cTGraphicalObjectFrame;
        }
        
        public void add(int param1Int, CTGraphicalObjectFrame param1CTGraphicalObjectFrame) {
          CTGroupShapeImpl.this.insertNewGraphicFrame(param1Int).set((XmlObject)param1CTGraphicalObjectFrame);
        }
        
        public CTGraphicalObjectFrame remove(int param1Int) {
          CTGraphicalObjectFrame cTGraphicalObjectFrame = CTGroupShapeImpl.this.getGraphicFrameArray(param1Int);
          CTGroupShapeImpl.this.removeGraphicFrame(param1Int);
          return cTGraphicalObjectFrame;
        }
        
        public int size() {
          return CTGroupShapeImpl.this.sizeOfGraphicFrameArray();
        }
      };
      return new GraphicFrameList();
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
      final class CxnSpList extends AbstractList<CTConnector> {
        public CTConnector get(int param1Int) {
          return CTGroupShapeImpl.this.getCxnSpArray(param1Int);
        }
        
        public CTConnector set(int param1Int, CTConnector param1CTConnector) {
          CTConnector cTConnector = CTGroupShapeImpl.this.getCxnSpArray(param1Int);
          CTGroupShapeImpl.this.setCxnSpArray(param1Int, param1CTConnector);
          return cTConnector;
        }
        
        public void add(int param1Int, CTConnector param1CTConnector) {
          CTGroupShapeImpl.this.insertNewCxnSp(param1Int).set((XmlObject)param1CTConnector);
        }
        
        public CTConnector remove(int param1Int) {
          CTConnector cTConnector = CTGroupShapeImpl.this.getCxnSpArray(param1Int);
          CTGroupShapeImpl.this.removeCxnSp(param1Int);
          return cTConnector;
        }
        
        public int size() {
          return CTGroupShapeImpl.this.sizeOfCxnSpArray();
        }
      };
      return new CxnSpList();
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
      final class PicList extends AbstractList<CTPicture> {
        public CTPicture get(int param1Int) {
          return CTGroupShapeImpl.this.getPicArray(param1Int);
        }
        
        public CTPicture set(int param1Int, CTPicture param1CTPicture) {
          CTPicture cTPicture = CTGroupShapeImpl.this.getPicArray(param1Int);
          CTGroupShapeImpl.this.setPicArray(param1Int, param1CTPicture);
          return cTPicture;
        }
        
        public void add(int param1Int, CTPicture param1CTPicture) {
          CTGroupShapeImpl.this.insertNewPic(param1Int).set((XmlObject)param1CTPicture);
        }
        
        public CTPicture remove(int param1Int) {
          CTPicture cTPicture = CTGroupShapeImpl.this.getPicArray(param1Int);
          CTGroupShapeImpl.this.removePic(param1Int);
          return cTPicture;
        }
        
        public int size() {
          return CTGroupShapeImpl.this.sizeOfPicArray();
        }
      };
      return new PicList();
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
  
  public CTExtensionListModify getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionListModify cTExtensionListModify = null;
      cTExtensionListModify = (CTExtensionListModify)get_store().find_element_user(EXTLST$14, 0);
      if (cTExtensionListModify == null)
        return null; 
      return cTExtensionListModify;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$14) != 0);
    } 
  }
  
  public void setExtLst(CTExtensionListModify paramCTExtensionListModify) {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionListModify cTExtensionListModify = null;
      cTExtensionListModify = (CTExtensionListModify)get_store().find_element_user(EXTLST$14, 0);
      if (cTExtensionListModify == null)
        cTExtensionListModify = (CTExtensionListModify)get_store().add_element_user(EXTLST$14); 
      cTExtensionListModify.set((XmlObject)paramCTExtensionListModify);
    } 
  }
  
  public CTExtensionListModify addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionListModify cTExtensionListModify = null;
      cTExtensionListModify = (CTExtensionListModify)get_store().add_element_user(EXTLST$14);
      return cTExtensionListModify;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$14, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\impl\CTGroupShapeImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */