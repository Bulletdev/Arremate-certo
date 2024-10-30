package org.openxmlformats.schemas.spreadsheetml.x2006.main;

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
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface STNumFmtId extends XmlUnsignedInt {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STNumFmtId.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stnumfmtid76fbtype");
  
  public static final class Factory {
    public static STNumFmtId newValue(Object param1Object) {
      return (STNumFmtId)STNumFmtId.type.newValue(param1Object);
    }
    
    public static STNumFmtId newInstance() {
      return (STNumFmtId)POIXMLTypeLoader.newInstance(STNumFmtId.type, null);
    }
    
    public static STNumFmtId newInstance(XmlOptions param1XmlOptions) {
      return (STNumFmtId)POIXMLTypeLoader.newInstance(STNumFmtId.type, param1XmlOptions);
    }
    
    public static STNumFmtId parse(String param1String) throws XmlException {
      return (STNumFmtId)POIXMLTypeLoader.parse(param1String, STNumFmtId.type, null);
    }
    
    public static STNumFmtId parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STNumFmtId)POIXMLTypeLoader.parse(param1String, STNumFmtId.type, param1XmlOptions);
    }
    
    public static STNumFmtId parse(File param1File) throws XmlException, IOException {
      return (STNumFmtId)POIXMLTypeLoader.parse(param1File, STNumFmtId.type, null);
    }
    
    public static STNumFmtId parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STNumFmtId)POIXMLTypeLoader.parse(param1File, STNumFmtId.type, param1XmlOptions);
    }
    
    public static STNumFmtId parse(URL param1URL) throws XmlException, IOException {
      return (STNumFmtId)POIXMLTypeLoader.parse(param1URL, STNumFmtId.type, null);
    }
    
    public static STNumFmtId parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STNumFmtId)POIXMLTypeLoader.parse(param1URL, STNumFmtId.type, param1XmlOptions);
    }
    
    public static STNumFmtId parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STNumFmtId)POIXMLTypeLoader.parse(param1InputStream, STNumFmtId.type, null);
    }
    
    public static STNumFmtId parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STNumFmtId)POIXMLTypeLoader.parse(param1InputStream, STNumFmtId.type, param1XmlOptions);
    }
    
    public static STNumFmtId parse(Reader param1Reader) throws XmlException, IOException {
      return (STNumFmtId)POIXMLTypeLoader.parse(param1Reader, STNumFmtId.type, null);
    }
    
    public static STNumFmtId parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STNumFmtId)POIXMLTypeLoader.parse(param1Reader, STNumFmtId.type, param1XmlOptions);
    }
    
    public static STNumFmtId parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STNumFmtId)POIXMLTypeLoader.parse(param1XMLStreamReader, STNumFmtId.type, null);
    }
    
    public static STNumFmtId parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STNumFmtId)POIXMLTypeLoader.parse(param1XMLStreamReader, STNumFmtId.type, param1XmlOptions);
    }
    
    public static STNumFmtId parse(Node param1Node) throws XmlException {
      return (STNumFmtId)POIXMLTypeLoader.parse(param1Node, STNumFmtId.type, null);
    }
    
    public static STNumFmtId parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STNumFmtId)POIXMLTypeLoader.parse(param1Node, STNumFmtId.type, param1XmlOptions);
    }
    
    public static STNumFmtId parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STNumFmtId)POIXMLTypeLoader.parse(param1XMLInputStream, STNumFmtId.type, null);
    }
    
    public static STNumFmtId parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STNumFmtId)POIXMLTypeLoader.parse(param1XMLInputStream, STNumFmtId.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STNumFmtId.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STNumFmtId.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\STNumFmtId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */