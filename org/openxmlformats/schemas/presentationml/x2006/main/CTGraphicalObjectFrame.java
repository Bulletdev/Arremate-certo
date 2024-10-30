package org.openxmlformats.schemas.presentationml.x2006.main;

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
import org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTransform2D;
import org.w3c.dom.Node;

public interface CTGraphicalObjectFrame extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTGraphicalObjectFrame.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctgraphicalobjectframebfeatype");
  
  CTGraphicalObjectFrameNonVisual getNvGraphicFramePr();
  
  void setNvGraphicFramePr(CTGraphicalObjectFrameNonVisual paramCTGraphicalObjectFrameNonVisual);
  
  CTGraphicalObjectFrameNonVisual addNewNvGraphicFramePr();
  
  CTTransform2D getXfrm();
  
  void setXfrm(CTTransform2D paramCTTransform2D);
  
  CTTransform2D addNewXfrm();
  
  CTGraphicalObject getGraphic();
  
  void setGraphic(CTGraphicalObject paramCTGraphicalObject);
  
  CTGraphicalObject addNewGraphic();
  
  CTExtensionListModify getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTExtensionListModify paramCTExtensionListModify);
  
  CTExtensionListModify addNewExtLst();
  
  void unsetExtLst();
  
  public static final class Factory {
    public static CTGraphicalObjectFrame newInstance() {
      return (CTGraphicalObjectFrame)POIXMLTypeLoader.newInstance(CTGraphicalObjectFrame.type, null);
    }
    
    public static CTGraphicalObjectFrame newInstance(XmlOptions param1XmlOptions) {
      return (CTGraphicalObjectFrame)POIXMLTypeLoader.newInstance(CTGraphicalObjectFrame.type, param1XmlOptions);
    }
    
    public static CTGraphicalObjectFrame parse(String param1String) throws XmlException {
      return (CTGraphicalObjectFrame)POIXMLTypeLoader.parse(param1String, CTGraphicalObjectFrame.type, null);
    }
    
    public static CTGraphicalObjectFrame parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTGraphicalObjectFrame)POIXMLTypeLoader.parse(param1String, CTGraphicalObjectFrame.type, param1XmlOptions);
    }
    
    public static CTGraphicalObjectFrame parse(File param1File) throws XmlException, IOException {
      return (CTGraphicalObjectFrame)POIXMLTypeLoader.parse(param1File, CTGraphicalObjectFrame.type, null);
    }
    
    public static CTGraphicalObjectFrame parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTGraphicalObjectFrame)POIXMLTypeLoader.parse(param1File, CTGraphicalObjectFrame.type, param1XmlOptions);
    }
    
    public static CTGraphicalObjectFrame parse(URL param1URL) throws XmlException, IOException {
      return (CTGraphicalObjectFrame)POIXMLTypeLoader.parse(param1URL, CTGraphicalObjectFrame.type, null);
    }
    
    public static CTGraphicalObjectFrame parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTGraphicalObjectFrame)POIXMLTypeLoader.parse(param1URL, CTGraphicalObjectFrame.type, param1XmlOptions);
    }
    
    public static CTGraphicalObjectFrame parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTGraphicalObjectFrame)POIXMLTypeLoader.parse(param1InputStream, CTGraphicalObjectFrame.type, null);
    }
    
    public static CTGraphicalObjectFrame parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTGraphicalObjectFrame)POIXMLTypeLoader.parse(param1InputStream, CTGraphicalObjectFrame.type, param1XmlOptions);
    }
    
    public static CTGraphicalObjectFrame parse(Reader param1Reader) throws XmlException, IOException {
      return (CTGraphicalObjectFrame)POIXMLTypeLoader.parse(param1Reader, CTGraphicalObjectFrame.type, null);
    }
    
    public static CTGraphicalObjectFrame parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTGraphicalObjectFrame)POIXMLTypeLoader.parse(param1Reader, CTGraphicalObjectFrame.type, param1XmlOptions);
    }
    
    public static CTGraphicalObjectFrame parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTGraphicalObjectFrame)POIXMLTypeLoader.parse(param1XMLStreamReader, CTGraphicalObjectFrame.type, null);
    }
    
    public static CTGraphicalObjectFrame parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTGraphicalObjectFrame)POIXMLTypeLoader.parse(param1XMLStreamReader, CTGraphicalObjectFrame.type, param1XmlOptions);
    }
    
    public static CTGraphicalObjectFrame parse(Node param1Node) throws XmlException {
      return (CTGraphicalObjectFrame)POIXMLTypeLoader.parse(param1Node, CTGraphicalObjectFrame.type, null);
    }
    
    public static CTGraphicalObjectFrame parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTGraphicalObjectFrame)POIXMLTypeLoader.parse(param1Node, CTGraphicalObjectFrame.type, param1XmlOptions);
    }
    
    public static CTGraphicalObjectFrame parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTGraphicalObjectFrame)POIXMLTypeLoader.parse(param1XMLInputStream, CTGraphicalObjectFrame.type, null);
    }
    
    public static CTGraphicalObjectFrame parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTGraphicalObjectFrame)POIXMLTypeLoader.parse(param1XMLInputStream, CTGraphicalObjectFrame.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTGraphicalObjectFrame.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTGraphicalObjectFrame.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\CTGraphicalObjectFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */