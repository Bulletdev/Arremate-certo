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

public interface STCellStyleXfId extends XmlUnsignedInt {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STCellStyleXfId.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stcellstylexfid70c7type");
  
  public static final class Factory {
    public static STCellStyleXfId newValue(Object param1Object) {
      return (STCellStyleXfId)STCellStyleXfId.type.newValue(param1Object);
    }
    
    public static STCellStyleXfId newInstance() {
      return (STCellStyleXfId)POIXMLTypeLoader.newInstance(STCellStyleXfId.type, null);
    }
    
    public static STCellStyleXfId newInstance(XmlOptions param1XmlOptions) {
      return (STCellStyleXfId)POIXMLTypeLoader.newInstance(STCellStyleXfId.type, param1XmlOptions);
    }
    
    public static STCellStyleXfId parse(String param1String) throws XmlException {
      return (STCellStyleXfId)POIXMLTypeLoader.parse(param1String, STCellStyleXfId.type, null);
    }
    
    public static STCellStyleXfId parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STCellStyleXfId)POIXMLTypeLoader.parse(param1String, STCellStyleXfId.type, param1XmlOptions);
    }
    
    public static STCellStyleXfId parse(File param1File) throws XmlException, IOException {
      return (STCellStyleXfId)POIXMLTypeLoader.parse(param1File, STCellStyleXfId.type, null);
    }
    
    public static STCellStyleXfId parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STCellStyleXfId)POIXMLTypeLoader.parse(param1File, STCellStyleXfId.type, param1XmlOptions);
    }
    
    public static STCellStyleXfId parse(URL param1URL) throws XmlException, IOException {
      return (STCellStyleXfId)POIXMLTypeLoader.parse(param1URL, STCellStyleXfId.type, null);
    }
    
    public static STCellStyleXfId parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STCellStyleXfId)POIXMLTypeLoader.parse(param1URL, STCellStyleXfId.type, param1XmlOptions);
    }
    
    public static STCellStyleXfId parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STCellStyleXfId)POIXMLTypeLoader.parse(param1InputStream, STCellStyleXfId.type, null);
    }
    
    public static STCellStyleXfId parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STCellStyleXfId)POIXMLTypeLoader.parse(param1InputStream, STCellStyleXfId.type, param1XmlOptions);
    }
    
    public static STCellStyleXfId parse(Reader param1Reader) throws XmlException, IOException {
      return (STCellStyleXfId)POIXMLTypeLoader.parse(param1Reader, STCellStyleXfId.type, null);
    }
    
    public static STCellStyleXfId parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STCellStyleXfId)POIXMLTypeLoader.parse(param1Reader, STCellStyleXfId.type, param1XmlOptions);
    }
    
    public static STCellStyleXfId parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STCellStyleXfId)POIXMLTypeLoader.parse(param1XMLStreamReader, STCellStyleXfId.type, null);
    }
    
    public static STCellStyleXfId parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STCellStyleXfId)POIXMLTypeLoader.parse(param1XMLStreamReader, STCellStyleXfId.type, param1XmlOptions);
    }
    
    public static STCellStyleXfId parse(Node param1Node) throws XmlException {
      return (STCellStyleXfId)POIXMLTypeLoader.parse(param1Node, STCellStyleXfId.type, null);
    }
    
    public static STCellStyleXfId parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STCellStyleXfId)POIXMLTypeLoader.parse(param1Node, STCellStyleXfId.type, param1XmlOptions);
    }
    
    public static STCellStyleXfId parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STCellStyleXfId)POIXMLTypeLoader.parse(param1XMLInputStream, STCellStyleXfId.type, null);
    }
    
    public static STCellStyleXfId parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STCellStyleXfId)POIXMLTypeLoader.parse(param1XMLInputStream, STCellStyleXfId.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STCellStyleXfId.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STCellStyleXfId.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\STCellStyleXfId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */