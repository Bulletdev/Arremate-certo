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
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTAnchorClientData extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTAnchorClientData.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctanchorclientdata02betype");
  
  boolean getFLocksWithSheet();
  
  XmlBoolean xgetFLocksWithSheet();
  
  boolean isSetFLocksWithSheet();
  
  void setFLocksWithSheet(boolean paramBoolean);
  
  void xsetFLocksWithSheet(XmlBoolean paramXmlBoolean);
  
  void unsetFLocksWithSheet();
  
  boolean getFPrintsWithSheet();
  
  XmlBoolean xgetFPrintsWithSheet();
  
  boolean isSetFPrintsWithSheet();
  
  void setFPrintsWithSheet(boolean paramBoolean);
  
  void xsetFPrintsWithSheet(XmlBoolean paramXmlBoolean);
  
  void unsetFPrintsWithSheet();
  
  public static final class Factory {
    public static CTAnchorClientData newInstance() {
      return (CTAnchorClientData)POIXMLTypeLoader.newInstance(CTAnchorClientData.type, null);
    }
    
    public static CTAnchorClientData newInstance(XmlOptions param1XmlOptions) {
      return (CTAnchorClientData)POIXMLTypeLoader.newInstance(CTAnchorClientData.type, param1XmlOptions);
    }
    
    public static CTAnchorClientData parse(String param1String) throws XmlException {
      return (CTAnchorClientData)POIXMLTypeLoader.parse(param1String, CTAnchorClientData.type, null);
    }
    
    public static CTAnchorClientData parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTAnchorClientData)POIXMLTypeLoader.parse(param1String, CTAnchorClientData.type, param1XmlOptions);
    }
    
    public static CTAnchorClientData parse(File param1File) throws XmlException, IOException {
      return (CTAnchorClientData)POIXMLTypeLoader.parse(param1File, CTAnchorClientData.type, null);
    }
    
    public static CTAnchorClientData parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTAnchorClientData)POIXMLTypeLoader.parse(param1File, CTAnchorClientData.type, param1XmlOptions);
    }
    
    public static CTAnchorClientData parse(URL param1URL) throws XmlException, IOException {
      return (CTAnchorClientData)POIXMLTypeLoader.parse(param1URL, CTAnchorClientData.type, null);
    }
    
    public static CTAnchorClientData parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTAnchorClientData)POIXMLTypeLoader.parse(param1URL, CTAnchorClientData.type, param1XmlOptions);
    }
    
    public static CTAnchorClientData parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTAnchorClientData)POIXMLTypeLoader.parse(param1InputStream, CTAnchorClientData.type, null);
    }
    
    public static CTAnchorClientData parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTAnchorClientData)POIXMLTypeLoader.parse(param1InputStream, CTAnchorClientData.type, param1XmlOptions);
    }
    
    public static CTAnchorClientData parse(Reader param1Reader) throws XmlException, IOException {
      return (CTAnchorClientData)POIXMLTypeLoader.parse(param1Reader, CTAnchorClientData.type, null);
    }
    
    public static CTAnchorClientData parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTAnchorClientData)POIXMLTypeLoader.parse(param1Reader, CTAnchorClientData.type, param1XmlOptions);
    }
    
    public static CTAnchorClientData parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTAnchorClientData)POIXMLTypeLoader.parse(param1XMLStreamReader, CTAnchorClientData.type, null);
    }
    
    public static CTAnchorClientData parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTAnchorClientData)POIXMLTypeLoader.parse(param1XMLStreamReader, CTAnchorClientData.type, param1XmlOptions);
    }
    
    public static CTAnchorClientData parse(Node param1Node) throws XmlException {
      return (CTAnchorClientData)POIXMLTypeLoader.parse(param1Node, CTAnchorClientData.type, null);
    }
    
    public static CTAnchorClientData parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTAnchorClientData)POIXMLTypeLoader.parse(param1Node, CTAnchorClientData.type, param1XmlOptions);
    }
    
    public static CTAnchorClientData parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTAnchorClientData)POIXMLTypeLoader.parse(param1XMLInputStream, CTAnchorClientData.type, null);
    }
    
    public static CTAnchorClientData parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTAnchorClientData)POIXMLTypeLoader.parse(param1XMLInputStream, CTAnchorClientData.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTAnchorClientData.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTAnchorClientData.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\spreadsheetDrawing\CTAnchorClientData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */