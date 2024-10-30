package com.microsoft.schemas.office.visio.x2012.main;

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

public interface MastersDocument extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(MastersDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("masters0341doctype");
  
  MastersType getMasters();
  
  void setMasters(MastersType paramMastersType);
  
  MastersType addNewMasters();
  
  public static final class Factory {
    public static MastersDocument newInstance() {
      return (MastersDocument)POIXMLTypeLoader.newInstance(MastersDocument.type, null);
    }
    
    public static MastersDocument newInstance(XmlOptions param1XmlOptions) {
      return (MastersDocument)POIXMLTypeLoader.newInstance(MastersDocument.type, param1XmlOptions);
    }
    
    public static MastersDocument parse(String param1String) throws XmlException {
      return (MastersDocument)POIXMLTypeLoader.parse(param1String, MastersDocument.type, null);
    }
    
    public static MastersDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (MastersDocument)POIXMLTypeLoader.parse(param1String, MastersDocument.type, param1XmlOptions);
    }
    
    public static MastersDocument parse(File param1File) throws XmlException, IOException {
      return (MastersDocument)POIXMLTypeLoader.parse(param1File, MastersDocument.type, null);
    }
    
    public static MastersDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (MastersDocument)POIXMLTypeLoader.parse(param1File, MastersDocument.type, param1XmlOptions);
    }
    
    public static MastersDocument parse(URL param1URL) throws XmlException, IOException {
      return (MastersDocument)POIXMLTypeLoader.parse(param1URL, MastersDocument.type, null);
    }
    
    public static MastersDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (MastersDocument)POIXMLTypeLoader.parse(param1URL, MastersDocument.type, param1XmlOptions);
    }
    
    public static MastersDocument parse(InputStream param1InputStream) throws XmlException, IOException {
      return (MastersDocument)POIXMLTypeLoader.parse(param1InputStream, MastersDocument.type, null);
    }
    
    public static MastersDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (MastersDocument)POIXMLTypeLoader.parse(param1InputStream, MastersDocument.type, param1XmlOptions);
    }
    
    public static MastersDocument parse(Reader param1Reader) throws XmlException, IOException {
      return (MastersDocument)POIXMLTypeLoader.parse(param1Reader, MastersDocument.type, null);
    }
    
    public static MastersDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (MastersDocument)POIXMLTypeLoader.parse(param1Reader, MastersDocument.type, param1XmlOptions);
    }
    
    public static MastersDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (MastersDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, MastersDocument.type, null);
    }
    
    public static MastersDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (MastersDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, MastersDocument.type, param1XmlOptions);
    }
    
    public static MastersDocument parse(Node param1Node) throws XmlException {
      return (MastersDocument)POIXMLTypeLoader.parse(param1Node, MastersDocument.type, null);
    }
    
    public static MastersDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (MastersDocument)POIXMLTypeLoader.parse(param1Node, MastersDocument.type, param1XmlOptions);
    }
    
    public static MastersDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (MastersDocument)POIXMLTypeLoader.parse(param1XMLInputStream, MastersDocument.type, null);
    }
    
    public static MastersDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (MastersDocument)POIXMLTypeLoader.parse(param1XMLInputStream, MastersDocument.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, MastersDocument.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, MastersDocument.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\visio\x2012\main\MastersDocument.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */