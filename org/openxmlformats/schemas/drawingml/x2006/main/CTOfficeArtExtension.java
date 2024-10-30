package org.openxmlformats.schemas.drawingml.x2006.main;

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
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTOfficeArtExtension extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTOfficeArtExtension.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctofficeartextension8e53type");
  
  String getUri();
  
  XmlToken xgetUri();
  
  boolean isSetUri();
  
  void setUri(String paramString);
  
  void xsetUri(XmlToken paramXmlToken);
  
  void unsetUri();
  
  public static final class Factory {
    public static CTOfficeArtExtension newInstance() {
      return (CTOfficeArtExtension)POIXMLTypeLoader.newInstance(CTOfficeArtExtension.type, null);
    }
    
    public static CTOfficeArtExtension newInstance(XmlOptions param1XmlOptions) {
      return (CTOfficeArtExtension)POIXMLTypeLoader.newInstance(CTOfficeArtExtension.type, param1XmlOptions);
    }
    
    public static CTOfficeArtExtension parse(String param1String) throws XmlException {
      return (CTOfficeArtExtension)POIXMLTypeLoader.parse(param1String, CTOfficeArtExtension.type, null);
    }
    
    public static CTOfficeArtExtension parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTOfficeArtExtension)POIXMLTypeLoader.parse(param1String, CTOfficeArtExtension.type, param1XmlOptions);
    }
    
    public static CTOfficeArtExtension parse(File param1File) throws XmlException, IOException {
      return (CTOfficeArtExtension)POIXMLTypeLoader.parse(param1File, CTOfficeArtExtension.type, null);
    }
    
    public static CTOfficeArtExtension parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTOfficeArtExtension)POIXMLTypeLoader.parse(param1File, CTOfficeArtExtension.type, param1XmlOptions);
    }
    
    public static CTOfficeArtExtension parse(URL param1URL) throws XmlException, IOException {
      return (CTOfficeArtExtension)POIXMLTypeLoader.parse(param1URL, CTOfficeArtExtension.type, null);
    }
    
    public static CTOfficeArtExtension parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTOfficeArtExtension)POIXMLTypeLoader.parse(param1URL, CTOfficeArtExtension.type, param1XmlOptions);
    }
    
    public static CTOfficeArtExtension parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTOfficeArtExtension)POIXMLTypeLoader.parse(param1InputStream, CTOfficeArtExtension.type, null);
    }
    
    public static CTOfficeArtExtension parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTOfficeArtExtension)POIXMLTypeLoader.parse(param1InputStream, CTOfficeArtExtension.type, param1XmlOptions);
    }
    
    public static CTOfficeArtExtension parse(Reader param1Reader) throws XmlException, IOException {
      return (CTOfficeArtExtension)POIXMLTypeLoader.parse(param1Reader, CTOfficeArtExtension.type, null);
    }
    
    public static CTOfficeArtExtension parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTOfficeArtExtension)POIXMLTypeLoader.parse(param1Reader, CTOfficeArtExtension.type, param1XmlOptions);
    }
    
    public static CTOfficeArtExtension parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTOfficeArtExtension)POIXMLTypeLoader.parse(param1XMLStreamReader, CTOfficeArtExtension.type, null);
    }
    
    public static CTOfficeArtExtension parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTOfficeArtExtension)POIXMLTypeLoader.parse(param1XMLStreamReader, CTOfficeArtExtension.type, param1XmlOptions);
    }
    
    public static CTOfficeArtExtension parse(Node param1Node) throws XmlException {
      return (CTOfficeArtExtension)POIXMLTypeLoader.parse(param1Node, CTOfficeArtExtension.type, null);
    }
    
    public static CTOfficeArtExtension parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTOfficeArtExtension)POIXMLTypeLoader.parse(param1Node, CTOfficeArtExtension.type, param1XmlOptions);
    }
    
    public static CTOfficeArtExtension parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTOfficeArtExtension)POIXMLTypeLoader.parse(param1XMLInputStream, CTOfficeArtExtension.type, null);
    }
    
    public static CTOfficeArtExtension parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTOfficeArtExtension)POIXMLTypeLoader.parse(param1XMLInputStream, CTOfficeArtExtension.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTOfficeArtExtension.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTOfficeArtExtension.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTOfficeArtExtension.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */