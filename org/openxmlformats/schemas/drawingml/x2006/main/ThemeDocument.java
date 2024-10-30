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

public interface ThemeDocument extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(ThemeDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("themefd26doctype");
  
  CTOfficeStyleSheet getTheme();
  
  void setTheme(CTOfficeStyleSheet paramCTOfficeStyleSheet);
  
  CTOfficeStyleSheet addNewTheme();
  
  public static final class Factory {
    public static ThemeDocument newInstance() {
      return (ThemeDocument)POIXMLTypeLoader.newInstance(ThemeDocument.type, null);
    }
    
    public static ThemeDocument newInstance(XmlOptions param1XmlOptions) {
      return (ThemeDocument)POIXMLTypeLoader.newInstance(ThemeDocument.type, param1XmlOptions);
    }
    
    public static ThemeDocument parse(String param1String) throws XmlException {
      return (ThemeDocument)POIXMLTypeLoader.parse(param1String, ThemeDocument.type, null);
    }
    
    public static ThemeDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (ThemeDocument)POIXMLTypeLoader.parse(param1String, ThemeDocument.type, param1XmlOptions);
    }
    
    public static ThemeDocument parse(File param1File) throws XmlException, IOException {
      return (ThemeDocument)POIXMLTypeLoader.parse(param1File, ThemeDocument.type, null);
    }
    
    public static ThemeDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (ThemeDocument)POIXMLTypeLoader.parse(param1File, ThemeDocument.type, param1XmlOptions);
    }
    
    public static ThemeDocument parse(URL param1URL) throws XmlException, IOException {
      return (ThemeDocument)POIXMLTypeLoader.parse(param1URL, ThemeDocument.type, null);
    }
    
    public static ThemeDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (ThemeDocument)POIXMLTypeLoader.parse(param1URL, ThemeDocument.type, param1XmlOptions);
    }
    
    public static ThemeDocument parse(InputStream param1InputStream) throws XmlException, IOException {
      return (ThemeDocument)POIXMLTypeLoader.parse(param1InputStream, ThemeDocument.type, null);
    }
    
    public static ThemeDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (ThemeDocument)POIXMLTypeLoader.parse(param1InputStream, ThemeDocument.type, param1XmlOptions);
    }
    
    public static ThemeDocument parse(Reader param1Reader) throws XmlException, IOException {
      return (ThemeDocument)POIXMLTypeLoader.parse(param1Reader, ThemeDocument.type, null);
    }
    
    public static ThemeDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (ThemeDocument)POIXMLTypeLoader.parse(param1Reader, ThemeDocument.type, param1XmlOptions);
    }
    
    public static ThemeDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (ThemeDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, ThemeDocument.type, null);
    }
    
    public static ThemeDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (ThemeDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, ThemeDocument.type, param1XmlOptions);
    }
    
    public static ThemeDocument parse(Node param1Node) throws XmlException {
      return (ThemeDocument)POIXMLTypeLoader.parse(param1Node, ThemeDocument.type, null);
    }
    
    public static ThemeDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (ThemeDocument)POIXMLTypeLoader.parse(param1Node, ThemeDocument.type, param1XmlOptions);
    }
    
    public static ThemeDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (ThemeDocument)POIXMLTypeLoader.parse(param1XMLInputStream, ThemeDocument.type, null);
    }
    
    public static ThemeDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (ThemeDocument)POIXMLTypeLoader.parse(param1XMLInputStream, ThemeDocument.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, ThemeDocument.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, ThemeDocument.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\ThemeDocument.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */