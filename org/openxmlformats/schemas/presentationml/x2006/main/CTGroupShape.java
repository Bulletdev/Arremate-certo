package org.openxmlformats.schemas.presentationml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties;
import org.w3c.dom.Node;

public interface CTGroupShape extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTGroupShape.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctgroupshape5b43type");
  
  CTGroupShapeNonVisual getNvGrpSpPr();
  
  void setNvGrpSpPr(CTGroupShapeNonVisual paramCTGroupShapeNonVisual);
  
  CTGroupShapeNonVisual addNewNvGrpSpPr();
  
  CTGroupShapeProperties getGrpSpPr();
  
  void setGrpSpPr(CTGroupShapeProperties paramCTGroupShapeProperties);
  
  CTGroupShapeProperties addNewGrpSpPr();
  
  List<CTShape> getSpList();
  
  CTShape[] getSpArray();
  
  CTShape getSpArray(int paramInt);
  
  int sizeOfSpArray();
  
  void setSpArray(CTShape[] paramArrayOfCTShape);
  
  void setSpArray(int paramInt, CTShape paramCTShape);
  
  CTShape insertNewSp(int paramInt);
  
  CTShape addNewSp();
  
  void removeSp(int paramInt);
  
  List<CTGroupShape> getGrpSpList();
  
  CTGroupShape[] getGrpSpArray();
  
  CTGroupShape getGrpSpArray(int paramInt);
  
  int sizeOfGrpSpArray();
  
  void setGrpSpArray(CTGroupShape[] paramArrayOfCTGroupShape);
  
  void setGrpSpArray(int paramInt, CTGroupShape paramCTGroupShape);
  
  CTGroupShape insertNewGrpSp(int paramInt);
  
  CTGroupShape addNewGrpSp();
  
  void removeGrpSp(int paramInt);
  
  List<CTGraphicalObjectFrame> getGraphicFrameList();
  
  CTGraphicalObjectFrame[] getGraphicFrameArray();
  
  CTGraphicalObjectFrame getGraphicFrameArray(int paramInt);
  
  int sizeOfGraphicFrameArray();
  
  void setGraphicFrameArray(CTGraphicalObjectFrame[] paramArrayOfCTGraphicalObjectFrame);
  
  void setGraphicFrameArray(int paramInt, CTGraphicalObjectFrame paramCTGraphicalObjectFrame);
  
  CTGraphicalObjectFrame insertNewGraphicFrame(int paramInt);
  
  CTGraphicalObjectFrame addNewGraphicFrame();
  
  void removeGraphicFrame(int paramInt);
  
  List<CTConnector> getCxnSpList();
  
  CTConnector[] getCxnSpArray();
  
  CTConnector getCxnSpArray(int paramInt);
  
  int sizeOfCxnSpArray();
  
  void setCxnSpArray(CTConnector[] paramArrayOfCTConnector);
  
  void setCxnSpArray(int paramInt, CTConnector paramCTConnector);
  
  CTConnector insertNewCxnSp(int paramInt);
  
  CTConnector addNewCxnSp();
  
  void removeCxnSp(int paramInt);
  
  List<CTPicture> getPicList();
  
  CTPicture[] getPicArray();
  
  CTPicture getPicArray(int paramInt);
  
  int sizeOfPicArray();
  
  void setPicArray(CTPicture[] paramArrayOfCTPicture);
  
  void setPicArray(int paramInt, CTPicture paramCTPicture);
  
  CTPicture insertNewPic(int paramInt);
  
  CTPicture addNewPic();
  
  void removePic(int paramInt);
  
  CTExtensionListModify getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTExtensionListModify paramCTExtensionListModify);
  
  CTExtensionListModify addNewExtLst();
  
  void unsetExtLst();
  
  public static final class Factory {
    public static CTGroupShape newInstance() {
      return (CTGroupShape)POIXMLTypeLoader.newInstance(CTGroupShape.type, null);
    }
    
    public static CTGroupShape newInstance(XmlOptions param1XmlOptions) {
      return (CTGroupShape)POIXMLTypeLoader.newInstance(CTGroupShape.type, param1XmlOptions);
    }
    
    public static CTGroupShape parse(String param1String) throws XmlException {
      return (CTGroupShape)POIXMLTypeLoader.parse(param1String, CTGroupShape.type, null);
    }
    
    public static CTGroupShape parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTGroupShape)POIXMLTypeLoader.parse(param1String, CTGroupShape.type, param1XmlOptions);
    }
    
    public static CTGroupShape parse(File param1File) throws XmlException, IOException {
      return (CTGroupShape)POIXMLTypeLoader.parse(param1File, CTGroupShape.type, null);
    }
    
    public static CTGroupShape parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTGroupShape)POIXMLTypeLoader.parse(param1File, CTGroupShape.type, param1XmlOptions);
    }
    
    public static CTGroupShape parse(URL param1URL) throws XmlException, IOException {
      return (CTGroupShape)POIXMLTypeLoader.parse(param1URL, CTGroupShape.type, null);
    }
    
    public static CTGroupShape parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTGroupShape)POIXMLTypeLoader.parse(param1URL, CTGroupShape.type, param1XmlOptions);
    }
    
    public static CTGroupShape parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTGroupShape)POIXMLTypeLoader.parse(param1InputStream, CTGroupShape.type, null);
    }
    
    public static CTGroupShape parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTGroupShape)POIXMLTypeLoader.parse(param1InputStream, CTGroupShape.type, param1XmlOptions);
    }
    
    public static CTGroupShape parse(Reader param1Reader) throws XmlException, IOException {
      return (CTGroupShape)POIXMLTypeLoader.parse(param1Reader, CTGroupShape.type, null);
    }
    
    public static CTGroupShape parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTGroupShape)POIXMLTypeLoader.parse(param1Reader, CTGroupShape.type, param1XmlOptions);
    }
    
    public static CTGroupShape parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTGroupShape)POIXMLTypeLoader.parse(param1XMLStreamReader, CTGroupShape.type, null);
    }
    
    public static CTGroupShape parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTGroupShape)POIXMLTypeLoader.parse(param1XMLStreamReader, CTGroupShape.type, param1XmlOptions);
    }
    
    public static CTGroupShape parse(Node param1Node) throws XmlException {
      return (CTGroupShape)POIXMLTypeLoader.parse(param1Node, CTGroupShape.type, null);
    }
    
    public static CTGroupShape parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTGroupShape)POIXMLTypeLoader.parse(param1Node, CTGroupShape.type, param1XmlOptions);
    }
    
    public static CTGroupShape parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTGroupShape)POIXMLTypeLoader.parse(param1XMLInputStream, CTGroupShape.type, null);
    }
    
    public static CTGroupShape parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTGroupShape)POIXMLTypeLoader.parse(param1XMLInputStream, CTGroupShape.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTGroupShape.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTGroupShape.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\CTGroupShape.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */