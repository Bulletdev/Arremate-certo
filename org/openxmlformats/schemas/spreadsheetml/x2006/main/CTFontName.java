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

public interface CTFontName extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTFontName.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctfontname2dc3type");
  
  String getVal();
  
  STXstring xgetVal();
  
  void setVal(String paramString);
  
  void xsetVal(STXstring paramSTXstring);
  
  public static final class Factory {
    public static CTFontName newInstance() {
      return (CTFontName)POIXMLTypeLoader.newInstance(CTFontName.type, null);
    }
    
    public static CTFontName newInstance(XmlOptions param1XmlOptions) {
      return (CTFontName)POIXMLTypeLoader.newInstance(CTFontName.type, param1XmlOptions);
    }
    
    public static CTFontName parse(String param1String) throws XmlException {
      return (CTFontName)POIXMLTypeLoader.parse(param1String, CTFontName.type, null);
    }
    
    public static CTFontName parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTFontName)POIXMLTypeLoader.parse(param1String, CTFontName.type, param1XmlOptions);
    }
    
    public static CTFontName parse(File param1File) throws XmlException, IOException {
      return (CTFontName)POIXMLTypeLoader.parse(param1File, CTFontName.type, null);
    }
    
    public static CTFontName parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTFontName)POIXMLTypeLoader.parse(param1File, CTFontName.type, param1XmlOptions);
    }
    
    public static CTFontName parse(URL param1URL) throws XmlException, IOException {
      return (CTFontName)POIXMLTypeLoader.parse(param1URL, CTFontName.type, null);
    }
    
    public static CTFontName parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTFontName)POIXMLTypeLoader.parse(param1URL, CTFontName.type, param1XmlOptions);
    }
    
    public static CTFontName parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTFontName)POIXMLTypeLoader.parse(param1InputStream, CTFontName.type, null);
    }
    
    public static CTFontName parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTFontName)POIXMLTypeLoader.parse(param1InputStream, CTFontName.type, param1XmlOptions);
    }
    
    public static CTFontName parse(Reader param1Reader) throws XmlException, IOException {
      return (CTFontName)POIXMLTypeLoader.parse(param1Reader, CTFontName.type, null);
    }
    
    public static CTFontName parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTFontName)POIXMLTypeLoader.parse(param1Reader, CTFontName.type, param1XmlOptions);
    }
    
    public static CTFontName parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTFontName)POIXMLTypeLoader.parse(param1XMLStreamReader, CTFontName.type, null);
    }
    
    public static CTFontName parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTFontName)POIXMLTypeLoader.parse(param1XMLStreamReader, CTFontName.type, param1XmlOptions);
    }
    
    public static CTFontName parse(Node param1Node) throws XmlException {
      return (CTFontName)POIXMLTypeLoader.parse(param1Node, CTFontName.type, null);
    }
    
    public static CTFontName parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTFontName)POIXMLTypeLoader.parse(param1Node, CTFontName.type, param1XmlOptions);
    }
    
    public static CTFontName parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTFontName)POIXMLTypeLoader.parse(param1XMLInputStream, CTFontName.type, null);
    }
    
    public static CTFontName parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTFontName)POIXMLTypeLoader.parse(param1XMLInputStream, CTFontName.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTFontName.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTFontName.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTFontName.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */