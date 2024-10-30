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
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTLineJoinRound extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTLineJoinRound.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctlinejoinround7be1type");
  
  public static final class Factory {
    public static CTLineJoinRound newInstance() {
      return (CTLineJoinRound)POIXMLTypeLoader.newInstance(CTLineJoinRound.type, null);
    }
    
    public static CTLineJoinRound newInstance(XmlOptions param1XmlOptions) {
      return (CTLineJoinRound)POIXMLTypeLoader.newInstance(CTLineJoinRound.type, param1XmlOptions);
    }
    
    public static CTLineJoinRound parse(String param1String) throws XmlException {
      return (CTLineJoinRound)POIXMLTypeLoader.parse(param1String, CTLineJoinRound.type, null);
    }
    
    public static CTLineJoinRound parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTLineJoinRound)POIXMLTypeLoader.parse(param1String, CTLineJoinRound.type, param1XmlOptions);
    }
    
    public static CTLineJoinRound parse(File param1File) throws XmlException, IOException {
      return (CTLineJoinRound)POIXMLTypeLoader.parse(param1File, CTLineJoinRound.type, null);
    }
    
    public static CTLineJoinRound parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLineJoinRound)POIXMLTypeLoader.parse(param1File, CTLineJoinRound.type, param1XmlOptions);
    }
    
    public static CTLineJoinRound parse(URL param1URL) throws XmlException, IOException {
      return (CTLineJoinRound)POIXMLTypeLoader.parse(param1URL, CTLineJoinRound.type, null);
    }
    
    public static CTLineJoinRound parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLineJoinRound)POIXMLTypeLoader.parse(param1URL, CTLineJoinRound.type, param1XmlOptions);
    }
    
    public static CTLineJoinRound parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTLineJoinRound)POIXMLTypeLoader.parse(param1InputStream, CTLineJoinRound.type, null);
    }
    
    public static CTLineJoinRound parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLineJoinRound)POIXMLTypeLoader.parse(param1InputStream, CTLineJoinRound.type, param1XmlOptions);
    }
    
    public static CTLineJoinRound parse(Reader param1Reader) throws XmlException, IOException {
      return (CTLineJoinRound)POIXMLTypeLoader.parse(param1Reader, CTLineJoinRound.type, null);
    }
    
    public static CTLineJoinRound parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLineJoinRound)POIXMLTypeLoader.parse(param1Reader, CTLineJoinRound.type, param1XmlOptions);
    }
    
    public static CTLineJoinRound parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTLineJoinRound)POIXMLTypeLoader.parse(param1XMLStreamReader, CTLineJoinRound.type, null);
    }
    
    public static CTLineJoinRound parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTLineJoinRound)POIXMLTypeLoader.parse(param1XMLStreamReader, CTLineJoinRound.type, param1XmlOptions);
    }
    
    public static CTLineJoinRound parse(Node param1Node) throws XmlException {
      return (CTLineJoinRound)POIXMLTypeLoader.parse(param1Node, CTLineJoinRound.type, null);
    }
    
    public static CTLineJoinRound parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTLineJoinRound)POIXMLTypeLoader.parse(param1Node, CTLineJoinRound.type, param1XmlOptions);
    }
    
    public static CTLineJoinRound parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTLineJoinRound)POIXMLTypeLoader.parse(param1XMLInputStream, CTLineJoinRound.type, null);
    }
    
    public static CTLineJoinRound parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTLineJoinRound)POIXMLTypeLoader.parse(param1XMLInputStream, CTLineJoinRound.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTLineJoinRound.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTLineJoinRound.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTLineJoinRound.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */