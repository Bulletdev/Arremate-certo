package org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.w3c.dom.Node;

public interface CTOneCellAnchor extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTOneCellAnchor.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctonecellanchor0527type");
  
  CTMarker getFrom();
  
  void setFrom(CTMarker paramCTMarker);
  
  CTMarker addNewFrom();
  
  CTPositiveSize2D getExt();
  
  void setExt(CTPositiveSize2D paramCTPositiveSize2D);
  
  CTPositiveSize2D addNewExt();
  
  CTShape getSp();
  
  boolean isSetSp();
  
  void setSp(CTShape paramCTShape);
  
  CTShape addNewSp();
  
  void unsetSp();
  
  CTGroupShape getGrpSp();
  
  boolean isSetGrpSp();
  
  void setGrpSp(CTGroupShape paramCTGroupShape);
  
  CTGroupShape addNewGrpSp();
  
  void unsetGrpSp();
  
  CTGraphicalObjectFrame getGraphicFrame();
  
  boolean isSetGraphicFrame();
  
  void setGraphicFrame(CTGraphicalObjectFrame paramCTGraphicalObjectFrame);
  
  CTGraphicalObjectFrame addNewGraphicFrame();
  
  void unsetGraphicFrame();
  
  CTConnector getCxnSp();
  
  boolean isSetCxnSp();
  
  void setCxnSp(CTConnector paramCTConnector);
  
  CTConnector addNewCxnSp();
  
  void unsetCxnSp();
  
  CTPicture getPic();
  
  boolean isSetPic();
  
  void setPic(CTPicture paramCTPicture);
  
  CTPicture addNewPic();
  
  void unsetPic();
  
  CTAnchorClientData getClientData();
  
  void setClientData(CTAnchorClientData paramCTAnchorClientData);
  
  CTAnchorClientData addNewClientData();
  
  public static final class Factory {
    public static CTOneCellAnchor newInstance() {
      return (CTOneCellAnchor)POIXMLTypeLoader.newInstance(CTOneCellAnchor.type, null);
    }
    
    public static CTOneCellAnchor newInstance(XmlOptions param1XmlOptions) {
      return (CTOneCellAnchor)POIXMLTypeLoader.newInstance(CTOneCellAnchor.type, param1XmlOptions);
    }
    
    public static CTOneCellAnchor parse(String param1String) throws XmlException {
      return (CTOneCellAnchor)POIXMLTypeLoader.parse(param1String, CTOneCellAnchor.type, null);
    }
    
    public static CTOneCellAnchor parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTOneCellAnchor)POIXMLTypeLoader.parse(param1String, CTOneCellAnchor.type, param1XmlOptions);
    }
    
    public static CTOneCellAnchor parse(File param1File) throws XmlException, IOException {
      return (CTOneCellAnchor)POIXMLTypeLoader.parse(param1File, CTOneCellAnchor.type, null);
    }
    
    public static CTOneCellAnchor parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTOneCellAnchor)POIXMLTypeLoader.parse(param1File, CTOneCellAnchor.type, param1XmlOptions);
    }
    
    public static CTOneCellAnchor parse(URL param1URL) throws XmlException, IOException {
      return (CTOneCellAnchor)POIXMLTypeLoader.parse(param1URL, CTOneCellAnchor.type, null);
    }
    
    public static CTOneCellAnchor parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTOneCellAnchor)POIXMLTypeLoader.parse(param1URL, CTOneCellAnchor.type, param1XmlOptions);
    }
    
    public static CTOneCellAnchor parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTOneCellAnchor)POIXMLTypeLoader.parse(param1InputStream, CTOneCellAnchor.type, null);
    }
    
    public static CTOneCellAnchor parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTOneCellAnchor)POIXMLTypeLoader.parse(param1InputStream, CTOneCellAnchor.type, param1XmlOptions);
    }
    
    public static CTOneCellAnchor parse(Reader param1Reader) throws XmlException, IOException {
      return (CTOneCellAnchor)POIXMLTypeLoader.parse(param1Reader, CTOneCellAnchor.type, null);
    }
    
    public static CTOneCellAnchor parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTOneCellAnchor)POIXMLTypeLoader.parse(param1Reader, CTOneCellAnchor.type, param1XmlOptions);
    }
    
    public static CTOneCellAnchor parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTOneCellAnchor)POIXMLTypeLoader.parse(param1XMLStreamReader, CTOneCellAnchor.type, null);
    }
    
    public static CTOneCellAnchor parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTOneCellAnchor)POIXMLTypeLoader.parse(param1XMLStreamReader, CTOneCellAnchor.type, param1XmlOptions);
    }
    
    public static CTOneCellAnchor parse(Node param1Node) throws XmlException {
      return (CTOneCellAnchor)POIXMLTypeLoader.parse(param1Node, CTOneCellAnchor.type, null);
    }
    
    public static CTOneCellAnchor parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTOneCellAnchor)POIXMLTypeLoader.parse(param1Node, CTOneCellAnchor.type, param1XmlOptions);
    }
    
    public static CTOneCellAnchor parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTOneCellAnchor)POIXMLTypeLoader.parse(param1XMLInputStream, CTOneCellAnchor.type, null);
    }
    
    public static CTOneCellAnchor parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTOneCellAnchor)POIXMLTypeLoader.parse(param1XMLInputStream, CTOneCellAnchor.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTOneCellAnchor.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTOneCellAnchor.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\spreadsheetDrawing\CTOneCellAnchor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */