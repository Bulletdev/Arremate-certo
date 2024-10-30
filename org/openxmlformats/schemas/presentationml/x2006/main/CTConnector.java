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
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeStyle;
import org.w3c.dom.Node;

public interface CTConnector extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTConnector.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctconnector3522type");
  
  CTConnectorNonVisual getNvCxnSpPr();
  
  void setNvCxnSpPr(CTConnectorNonVisual paramCTConnectorNonVisual);
  
  CTConnectorNonVisual addNewNvCxnSpPr();
  
  CTShapeProperties getSpPr();
  
  void setSpPr(CTShapeProperties paramCTShapeProperties);
  
  CTShapeProperties addNewSpPr();
  
  CTShapeStyle getStyle();
  
  boolean isSetStyle();
  
  void setStyle(CTShapeStyle paramCTShapeStyle);
  
  CTShapeStyle addNewStyle();
  
  void unsetStyle();
  
  CTExtensionListModify getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTExtensionListModify paramCTExtensionListModify);
  
  CTExtensionListModify addNewExtLst();
  
  void unsetExtLst();
  
  public static final class Factory {
    public static CTConnector newInstance() {
      return (CTConnector)POIXMLTypeLoader.newInstance(CTConnector.type, null);
    }
    
    public static CTConnector newInstance(XmlOptions param1XmlOptions) {
      return (CTConnector)POIXMLTypeLoader.newInstance(CTConnector.type, param1XmlOptions);
    }
    
    public static CTConnector parse(String param1String) throws XmlException {
      return (CTConnector)POIXMLTypeLoader.parse(param1String, CTConnector.type, null);
    }
    
    public static CTConnector parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTConnector)POIXMLTypeLoader.parse(param1String, CTConnector.type, param1XmlOptions);
    }
    
    public static CTConnector parse(File param1File) throws XmlException, IOException {
      return (CTConnector)POIXMLTypeLoader.parse(param1File, CTConnector.type, null);
    }
    
    public static CTConnector parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTConnector)POIXMLTypeLoader.parse(param1File, CTConnector.type, param1XmlOptions);
    }
    
    public static CTConnector parse(URL param1URL) throws XmlException, IOException {
      return (CTConnector)POIXMLTypeLoader.parse(param1URL, CTConnector.type, null);
    }
    
    public static CTConnector parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTConnector)POIXMLTypeLoader.parse(param1URL, CTConnector.type, param1XmlOptions);
    }
    
    public static CTConnector parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTConnector)POIXMLTypeLoader.parse(param1InputStream, CTConnector.type, null);
    }
    
    public static CTConnector parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTConnector)POIXMLTypeLoader.parse(param1InputStream, CTConnector.type, param1XmlOptions);
    }
    
    public static CTConnector parse(Reader param1Reader) throws XmlException, IOException {
      return (CTConnector)POIXMLTypeLoader.parse(param1Reader, CTConnector.type, null);
    }
    
    public static CTConnector parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTConnector)POIXMLTypeLoader.parse(param1Reader, CTConnector.type, param1XmlOptions);
    }
    
    public static CTConnector parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTConnector)POIXMLTypeLoader.parse(param1XMLStreamReader, CTConnector.type, null);
    }
    
    public static CTConnector parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTConnector)POIXMLTypeLoader.parse(param1XMLStreamReader, CTConnector.type, param1XmlOptions);
    }
    
    public static CTConnector parse(Node param1Node) throws XmlException {
      return (CTConnector)POIXMLTypeLoader.parse(param1Node, CTConnector.type, null);
    }
    
    public static CTConnector parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTConnector)POIXMLTypeLoader.parse(param1Node, CTConnector.type, param1XmlOptions);
    }
    
    public static CTConnector parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTConnector)POIXMLTypeLoader.parse(param1XMLInputStream, CTConnector.type, null);
    }
    
    public static CTConnector parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTConnector)POIXMLTypeLoader.parse(param1XMLInputStream, CTConnector.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTConnector.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTConnector.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\CTConnector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */