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
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTVerticalAlignFontProperty extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTVerticalAlignFontProperty.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctverticalalignfontproperty89f2type");
  
  STVerticalAlignRun.Enum getVal();
  
  STVerticalAlignRun xgetVal();
  
  void setVal(STVerticalAlignRun.Enum paramEnum);
  
  void xsetVal(STVerticalAlignRun paramSTVerticalAlignRun);
  
  public static final class Factory {
    public static CTVerticalAlignFontProperty newInstance() {
      return (CTVerticalAlignFontProperty)POIXMLTypeLoader.newInstance(CTVerticalAlignFontProperty.type, null);
    }
    
    public static CTVerticalAlignFontProperty newInstance(XmlOptions param1XmlOptions) {
      return (CTVerticalAlignFontProperty)POIXMLTypeLoader.newInstance(CTVerticalAlignFontProperty.type, param1XmlOptions);
    }
    
    public static CTVerticalAlignFontProperty parse(String param1String) throws XmlException {
      return (CTVerticalAlignFontProperty)POIXMLTypeLoader.parse(param1String, CTVerticalAlignFontProperty.type, null);
    }
    
    public static CTVerticalAlignFontProperty parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTVerticalAlignFontProperty)POIXMLTypeLoader.parse(param1String, CTVerticalAlignFontProperty.type, param1XmlOptions);
    }
    
    public static CTVerticalAlignFontProperty parse(File param1File) throws XmlException, IOException {
      return (CTVerticalAlignFontProperty)POIXMLTypeLoader.parse(param1File, CTVerticalAlignFontProperty.type, null);
    }
    
    public static CTVerticalAlignFontProperty parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTVerticalAlignFontProperty)POIXMLTypeLoader.parse(param1File, CTVerticalAlignFontProperty.type, param1XmlOptions);
    }
    
    public static CTVerticalAlignFontProperty parse(URL param1URL) throws XmlException, IOException {
      return (CTVerticalAlignFontProperty)POIXMLTypeLoader.parse(param1URL, CTVerticalAlignFontProperty.type, null);
    }
    
    public static CTVerticalAlignFontProperty parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTVerticalAlignFontProperty)POIXMLTypeLoader.parse(param1URL, CTVerticalAlignFontProperty.type, param1XmlOptions);
    }
    
    public static CTVerticalAlignFontProperty parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTVerticalAlignFontProperty)POIXMLTypeLoader.parse(param1InputStream, CTVerticalAlignFontProperty.type, null);
    }
    
    public static CTVerticalAlignFontProperty parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTVerticalAlignFontProperty)POIXMLTypeLoader.parse(param1InputStream, CTVerticalAlignFontProperty.type, param1XmlOptions);
    }
    
    public static CTVerticalAlignFontProperty parse(Reader param1Reader) throws XmlException, IOException {
      return (CTVerticalAlignFontProperty)POIXMLTypeLoader.parse(param1Reader, CTVerticalAlignFontProperty.type, null);
    }
    
    public static CTVerticalAlignFontProperty parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTVerticalAlignFontProperty)POIXMLTypeLoader.parse(param1Reader, CTVerticalAlignFontProperty.type, param1XmlOptions);
    }
    
    public static CTVerticalAlignFontProperty parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTVerticalAlignFontProperty)POIXMLTypeLoader.parse(param1XMLStreamReader, CTVerticalAlignFontProperty.type, null);
    }
    
    public static CTVerticalAlignFontProperty parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTVerticalAlignFontProperty)POIXMLTypeLoader.parse(param1XMLStreamReader, CTVerticalAlignFontProperty.type, param1XmlOptions);
    }
    
    public static CTVerticalAlignFontProperty parse(Node param1Node) throws XmlException {
      return (CTVerticalAlignFontProperty)POIXMLTypeLoader.parse(param1Node, CTVerticalAlignFontProperty.type, null);
    }
    
    public static CTVerticalAlignFontProperty parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTVerticalAlignFontProperty)POIXMLTypeLoader.parse(param1Node, CTVerticalAlignFontProperty.type, param1XmlOptions);
    }
    
    public static CTVerticalAlignFontProperty parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTVerticalAlignFontProperty)POIXMLTypeLoader.parse(param1XMLInputStream, CTVerticalAlignFontProperty.type, null);
    }
    
    public static CTVerticalAlignFontProperty parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTVerticalAlignFontProperty)POIXMLTypeLoader.parse(param1XMLInputStream, CTVerticalAlignFontProperty.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTVerticalAlignFontProperty.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTVerticalAlignFontProperty.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTVerticalAlignFontProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */