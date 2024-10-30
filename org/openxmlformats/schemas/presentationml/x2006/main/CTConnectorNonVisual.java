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
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualConnectorProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.w3c.dom.Node;

public interface CTConnectorNonVisual extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTConnectorNonVisual.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctconnectornonvisual0f45type");
  
  CTNonVisualDrawingProps getCNvPr();
  
  void setCNvPr(CTNonVisualDrawingProps paramCTNonVisualDrawingProps);
  
  CTNonVisualDrawingProps addNewCNvPr();
  
  CTNonVisualConnectorProperties getCNvCxnSpPr();
  
  void setCNvCxnSpPr(CTNonVisualConnectorProperties paramCTNonVisualConnectorProperties);
  
  CTNonVisualConnectorProperties addNewCNvCxnSpPr();
  
  CTApplicationNonVisualDrawingProps getNvPr();
  
  void setNvPr(CTApplicationNonVisualDrawingProps paramCTApplicationNonVisualDrawingProps);
  
  CTApplicationNonVisualDrawingProps addNewNvPr();
  
  public static final class Factory {
    public static CTConnectorNonVisual newInstance() {
      return (CTConnectorNonVisual)POIXMLTypeLoader.newInstance(CTConnectorNonVisual.type, null);
    }
    
    public static CTConnectorNonVisual newInstance(XmlOptions param1XmlOptions) {
      return (CTConnectorNonVisual)POIXMLTypeLoader.newInstance(CTConnectorNonVisual.type, param1XmlOptions);
    }
    
    public static CTConnectorNonVisual parse(String param1String) throws XmlException {
      return (CTConnectorNonVisual)POIXMLTypeLoader.parse(param1String, CTConnectorNonVisual.type, null);
    }
    
    public static CTConnectorNonVisual parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTConnectorNonVisual)POIXMLTypeLoader.parse(param1String, CTConnectorNonVisual.type, param1XmlOptions);
    }
    
    public static CTConnectorNonVisual parse(File param1File) throws XmlException, IOException {
      return (CTConnectorNonVisual)POIXMLTypeLoader.parse(param1File, CTConnectorNonVisual.type, null);
    }
    
    public static CTConnectorNonVisual parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTConnectorNonVisual)POIXMLTypeLoader.parse(param1File, CTConnectorNonVisual.type, param1XmlOptions);
    }
    
    public static CTConnectorNonVisual parse(URL param1URL) throws XmlException, IOException {
      return (CTConnectorNonVisual)POIXMLTypeLoader.parse(param1URL, CTConnectorNonVisual.type, null);
    }
    
    public static CTConnectorNonVisual parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTConnectorNonVisual)POIXMLTypeLoader.parse(param1URL, CTConnectorNonVisual.type, param1XmlOptions);
    }
    
    public static CTConnectorNonVisual parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTConnectorNonVisual)POIXMLTypeLoader.parse(param1InputStream, CTConnectorNonVisual.type, null);
    }
    
    public static CTConnectorNonVisual parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTConnectorNonVisual)POIXMLTypeLoader.parse(param1InputStream, CTConnectorNonVisual.type, param1XmlOptions);
    }
    
    public static CTConnectorNonVisual parse(Reader param1Reader) throws XmlException, IOException {
      return (CTConnectorNonVisual)POIXMLTypeLoader.parse(param1Reader, CTConnectorNonVisual.type, null);
    }
    
    public static CTConnectorNonVisual parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTConnectorNonVisual)POIXMLTypeLoader.parse(param1Reader, CTConnectorNonVisual.type, param1XmlOptions);
    }
    
    public static CTConnectorNonVisual parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTConnectorNonVisual)POIXMLTypeLoader.parse(param1XMLStreamReader, CTConnectorNonVisual.type, null);
    }
    
    public static CTConnectorNonVisual parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTConnectorNonVisual)POIXMLTypeLoader.parse(param1XMLStreamReader, CTConnectorNonVisual.type, param1XmlOptions);
    }
    
    public static CTConnectorNonVisual parse(Node param1Node) throws XmlException {
      return (CTConnectorNonVisual)POIXMLTypeLoader.parse(param1Node, CTConnectorNonVisual.type, null);
    }
    
    public static CTConnectorNonVisual parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTConnectorNonVisual)POIXMLTypeLoader.parse(param1Node, CTConnectorNonVisual.type, param1XmlOptions);
    }
    
    public static CTConnectorNonVisual parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTConnectorNonVisual)POIXMLTypeLoader.parse(param1XMLInputStream, CTConnectorNonVisual.type, null);
    }
    
    public static CTConnectorNonVisual parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTConnectorNonVisual)POIXMLTypeLoader.parse(param1XMLInputStream, CTConnectorNonVisual.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTConnectorNonVisual.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTConnectorNonVisual.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\CTConnectorNonVisual.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */