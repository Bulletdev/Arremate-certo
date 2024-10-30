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
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface STTextFontScalePercent extends STPercentage {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STTextFontScalePercent.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("sttextfontscalepercente6c2type");
  
  public static final class Factory {
    public static STTextFontScalePercent newValue(Object param1Object) {
      return (STTextFontScalePercent)STTextFontScalePercent.type.newValue(param1Object);
    }
    
    public static STTextFontScalePercent newInstance() {
      return (STTextFontScalePercent)POIXMLTypeLoader.newInstance(STTextFontScalePercent.type, null);
    }
    
    public static STTextFontScalePercent newInstance(XmlOptions param1XmlOptions) {
      return (STTextFontScalePercent)POIXMLTypeLoader.newInstance(STTextFontScalePercent.type, param1XmlOptions);
    }
    
    public static STTextFontScalePercent parse(String param1String) throws XmlException {
      return (STTextFontScalePercent)POIXMLTypeLoader.parse(param1String, STTextFontScalePercent.type, null);
    }
    
    public static STTextFontScalePercent parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STTextFontScalePercent)POIXMLTypeLoader.parse(param1String, STTextFontScalePercent.type, param1XmlOptions);
    }
    
    public static STTextFontScalePercent parse(File param1File) throws XmlException, IOException {
      return (STTextFontScalePercent)POIXMLTypeLoader.parse(param1File, STTextFontScalePercent.type, null);
    }
    
    public static STTextFontScalePercent parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextFontScalePercent)POIXMLTypeLoader.parse(param1File, STTextFontScalePercent.type, param1XmlOptions);
    }
    
    public static STTextFontScalePercent parse(URL param1URL) throws XmlException, IOException {
      return (STTextFontScalePercent)POIXMLTypeLoader.parse(param1URL, STTextFontScalePercent.type, null);
    }
    
    public static STTextFontScalePercent parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextFontScalePercent)POIXMLTypeLoader.parse(param1URL, STTextFontScalePercent.type, param1XmlOptions);
    }
    
    public static STTextFontScalePercent parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STTextFontScalePercent)POIXMLTypeLoader.parse(param1InputStream, STTextFontScalePercent.type, null);
    }
    
    public static STTextFontScalePercent parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextFontScalePercent)POIXMLTypeLoader.parse(param1InputStream, STTextFontScalePercent.type, param1XmlOptions);
    }
    
    public static STTextFontScalePercent parse(Reader param1Reader) throws XmlException, IOException {
      return (STTextFontScalePercent)POIXMLTypeLoader.parse(param1Reader, STTextFontScalePercent.type, null);
    }
    
    public static STTextFontScalePercent parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextFontScalePercent)POIXMLTypeLoader.parse(param1Reader, STTextFontScalePercent.type, param1XmlOptions);
    }
    
    public static STTextFontScalePercent parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STTextFontScalePercent)POIXMLTypeLoader.parse(param1XMLStreamReader, STTextFontScalePercent.type, null);
    }
    
    public static STTextFontScalePercent parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STTextFontScalePercent)POIXMLTypeLoader.parse(param1XMLStreamReader, STTextFontScalePercent.type, param1XmlOptions);
    }
    
    public static STTextFontScalePercent parse(Node param1Node) throws XmlException {
      return (STTextFontScalePercent)POIXMLTypeLoader.parse(param1Node, STTextFontScalePercent.type, null);
    }
    
    public static STTextFontScalePercent parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STTextFontScalePercent)POIXMLTypeLoader.parse(param1Node, STTextFontScalePercent.type, param1XmlOptions);
    }
    
    public static STTextFontScalePercent parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STTextFontScalePercent)POIXMLTypeLoader.parse(param1XMLInputStream, STTextFontScalePercent.type, null);
    }
    
    public static STTextFontScalePercent parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STTextFontScalePercent)POIXMLTypeLoader.parse(param1XMLInputStream, STTextFontScalePercent.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STTextFontScalePercent.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STTextFontScalePercent.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\STTextFontScalePercent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */