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
import org.w3c.dom.Node;

public interface CTTwoCellAnchor extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTTwoCellAnchor.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttwocellanchor1e8dtype");
  
  CTMarker getFrom();
  
  void setFrom(CTMarker paramCTMarker);
  
  CTMarker addNewFrom();
  
  CTMarker getTo();
  
  void setTo(CTMarker paramCTMarker);
  
  CTMarker addNewTo();
  
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
  
  STEditAs.Enum getEditAs();
  
  STEditAs xgetEditAs();
  
  boolean isSetEditAs();
  
  void setEditAs(STEditAs.Enum paramEnum);
  
  void xsetEditAs(STEditAs paramSTEditAs);
  
  void unsetEditAs();
  
  public static final class Factory {
    public static CTTwoCellAnchor newInstance() {
      return (CTTwoCellAnchor)POIXMLTypeLoader.newInstance(CTTwoCellAnchor.type, null);
    }
    
    public static CTTwoCellAnchor newInstance(XmlOptions param1XmlOptions) {
      return (CTTwoCellAnchor)POIXMLTypeLoader.newInstance(CTTwoCellAnchor.type, param1XmlOptions);
    }
    
    public static CTTwoCellAnchor parse(String param1String) throws XmlException {
      return (CTTwoCellAnchor)POIXMLTypeLoader.parse(param1String, CTTwoCellAnchor.type, null);
    }
    
    public static CTTwoCellAnchor parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTwoCellAnchor)POIXMLTypeLoader.parse(param1String, CTTwoCellAnchor.type, param1XmlOptions);
    }
    
    public static CTTwoCellAnchor parse(File param1File) throws XmlException, IOException {
      return (CTTwoCellAnchor)POIXMLTypeLoader.parse(param1File, CTTwoCellAnchor.type, null);
    }
    
    public static CTTwoCellAnchor parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTwoCellAnchor)POIXMLTypeLoader.parse(param1File, CTTwoCellAnchor.type, param1XmlOptions);
    }
    
    public static CTTwoCellAnchor parse(URL param1URL) throws XmlException, IOException {
      return (CTTwoCellAnchor)POIXMLTypeLoader.parse(param1URL, CTTwoCellAnchor.type, null);
    }
    
    public static CTTwoCellAnchor parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTwoCellAnchor)POIXMLTypeLoader.parse(param1URL, CTTwoCellAnchor.type, param1XmlOptions);
    }
    
    public static CTTwoCellAnchor parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTTwoCellAnchor)POIXMLTypeLoader.parse(param1InputStream, CTTwoCellAnchor.type, null);
    }
    
    public static CTTwoCellAnchor parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTwoCellAnchor)POIXMLTypeLoader.parse(param1InputStream, CTTwoCellAnchor.type, param1XmlOptions);
    }
    
    public static CTTwoCellAnchor parse(Reader param1Reader) throws XmlException, IOException {
      return (CTTwoCellAnchor)POIXMLTypeLoader.parse(param1Reader, CTTwoCellAnchor.type, null);
    }
    
    public static CTTwoCellAnchor parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTwoCellAnchor)POIXMLTypeLoader.parse(param1Reader, CTTwoCellAnchor.type, param1XmlOptions);
    }
    
    public static CTTwoCellAnchor parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTTwoCellAnchor)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTwoCellAnchor.type, null);
    }
    
    public static CTTwoCellAnchor parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTwoCellAnchor)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTwoCellAnchor.type, param1XmlOptions);
    }
    
    public static CTTwoCellAnchor parse(Node param1Node) throws XmlException {
      return (CTTwoCellAnchor)POIXMLTypeLoader.parse(param1Node, CTTwoCellAnchor.type, null);
    }
    
    public static CTTwoCellAnchor parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTwoCellAnchor)POIXMLTypeLoader.parse(param1Node, CTTwoCellAnchor.type, param1XmlOptions);
    }
    
    public static CTTwoCellAnchor parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTTwoCellAnchor)POIXMLTypeLoader.parse(param1XMLInputStream, CTTwoCellAnchor.type, null);
    }
    
    public static CTTwoCellAnchor parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTTwoCellAnchor)POIXMLTypeLoader.parse(param1XMLInputStream, CTTwoCellAnchor.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTwoCellAnchor.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTwoCellAnchor.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\spreadsheetDrawing\CTTwoCellAnchor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */