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
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface STStyleMatrixColumnIndex extends XmlUnsignedInt {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STStyleMatrixColumnIndex.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ststylematrixcolumnindex1755type");
  
  public static final class Factory {
    public static STStyleMatrixColumnIndex newValue(Object param1Object) {
      return (STStyleMatrixColumnIndex)STStyleMatrixColumnIndex.type.newValue(param1Object);
    }
    
    public static STStyleMatrixColumnIndex newInstance() {
      return (STStyleMatrixColumnIndex)POIXMLTypeLoader.newInstance(STStyleMatrixColumnIndex.type, null);
    }
    
    public static STStyleMatrixColumnIndex newInstance(XmlOptions param1XmlOptions) {
      return (STStyleMatrixColumnIndex)POIXMLTypeLoader.newInstance(STStyleMatrixColumnIndex.type, param1XmlOptions);
    }
    
    public static STStyleMatrixColumnIndex parse(String param1String) throws XmlException {
      return (STStyleMatrixColumnIndex)POIXMLTypeLoader.parse(param1String, STStyleMatrixColumnIndex.type, null);
    }
    
    public static STStyleMatrixColumnIndex parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STStyleMatrixColumnIndex)POIXMLTypeLoader.parse(param1String, STStyleMatrixColumnIndex.type, param1XmlOptions);
    }
    
    public static STStyleMatrixColumnIndex parse(File param1File) throws XmlException, IOException {
      return (STStyleMatrixColumnIndex)POIXMLTypeLoader.parse(param1File, STStyleMatrixColumnIndex.type, null);
    }
    
    public static STStyleMatrixColumnIndex parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STStyleMatrixColumnIndex)POIXMLTypeLoader.parse(param1File, STStyleMatrixColumnIndex.type, param1XmlOptions);
    }
    
    public static STStyleMatrixColumnIndex parse(URL param1URL) throws XmlException, IOException {
      return (STStyleMatrixColumnIndex)POIXMLTypeLoader.parse(param1URL, STStyleMatrixColumnIndex.type, null);
    }
    
    public static STStyleMatrixColumnIndex parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STStyleMatrixColumnIndex)POIXMLTypeLoader.parse(param1URL, STStyleMatrixColumnIndex.type, param1XmlOptions);
    }
    
    public static STStyleMatrixColumnIndex parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STStyleMatrixColumnIndex)POIXMLTypeLoader.parse(param1InputStream, STStyleMatrixColumnIndex.type, null);
    }
    
    public static STStyleMatrixColumnIndex parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STStyleMatrixColumnIndex)POIXMLTypeLoader.parse(param1InputStream, STStyleMatrixColumnIndex.type, param1XmlOptions);
    }
    
    public static STStyleMatrixColumnIndex parse(Reader param1Reader) throws XmlException, IOException {
      return (STStyleMatrixColumnIndex)POIXMLTypeLoader.parse(param1Reader, STStyleMatrixColumnIndex.type, null);
    }
    
    public static STStyleMatrixColumnIndex parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STStyleMatrixColumnIndex)POIXMLTypeLoader.parse(param1Reader, STStyleMatrixColumnIndex.type, param1XmlOptions);
    }
    
    public static STStyleMatrixColumnIndex parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STStyleMatrixColumnIndex)POIXMLTypeLoader.parse(param1XMLStreamReader, STStyleMatrixColumnIndex.type, null);
    }
    
    public static STStyleMatrixColumnIndex parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STStyleMatrixColumnIndex)POIXMLTypeLoader.parse(param1XMLStreamReader, STStyleMatrixColumnIndex.type, param1XmlOptions);
    }
    
    public static STStyleMatrixColumnIndex parse(Node param1Node) throws XmlException {
      return (STStyleMatrixColumnIndex)POIXMLTypeLoader.parse(param1Node, STStyleMatrixColumnIndex.type, null);
    }
    
    public static STStyleMatrixColumnIndex parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STStyleMatrixColumnIndex)POIXMLTypeLoader.parse(param1Node, STStyleMatrixColumnIndex.type, param1XmlOptions);
    }
    
    public static STStyleMatrixColumnIndex parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STStyleMatrixColumnIndex)POIXMLTypeLoader.parse(param1XMLInputStream, STStyleMatrixColumnIndex.type, null);
    }
    
    public static STStyleMatrixColumnIndex parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STStyleMatrixColumnIndex)POIXMLTypeLoader.parse(param1XMLInputStream, STStyleMatrixColumnIndex.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STStyleMatrixColumnIndex.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STStyleMatrixColumnIndex.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\STStyleMatrixColumnIndex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */