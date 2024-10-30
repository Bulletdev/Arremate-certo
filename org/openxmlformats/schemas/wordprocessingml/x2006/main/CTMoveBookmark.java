package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.Calendar;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTMoveBookmark extends CTBookmark {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTMoveBookmark.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctmovebookmarkf7a1type");
  
  String getAuthor();
  
  STString xgetAuthor();
  
  void setAuthor(String paramString);
  
  void xsetAuthor(STString paramSTString);
  
  Calendar getDate();
  
  STDateTime xgetDate();
  
  void setDate(Calendar paramCalendar);
  
  void xsetDate(STDateTime paramSTDateTime);
  
  public static final class Factory {
    public static CTMoveBookmark newInstance() {
      return (CTMoveBookmark)POIXMLTypeLoader.newInstance(CTMoveBookmark.type, null);
    }
    
    public static CTMoveBookmark newInstance(XmlOptions param1XmlOptions) {
      return (CTMoveBookmark)POIXMLTypeLoader.newInstance(CTMoveBookmark.type, param1XmlOptions);
    }
    
    public static CTMoveBookmark parse(String param1String) throws XmlException {
      return (CTMoveBookmark)POIXMLTypeLoader.parse(param1String, CTMoveBookmark.type, null);
    }
    
    public static CTMoveBookmark parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTMoveBookmark)POIXMLTypeLoader.parse(param1String, CTMoveBookmark.type, param1XmlOptions);
    }
    
    public static CTMoveBookmark parse(File param1File) throws XmlException, IOException {
      return (CTMoveBookmark)POIXMLTypeLoader.parse(param1File, CTMoveBookmark.type, null);
    }
    
    public static CTMoveBookmark parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTMoveBookmark)POIXMLTypeLoader.parse(param1File, CTMoveBookmark.type, param1XmlOptions);
    }
    
    public static CTMoveBookmark parse(URL param1URL) throws XmlException, IOException {
      return (CTMoveBookmark)POIXMLTypeLoader.parse(param1URL, CTMoveBookmark.type, null);
    }
    
    public static CTMoveBookmark parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTMoveBookmark)POIXMLTypeLoader.parse(param1URL, CTMoveBookmark.type, param1XmlOptions);
    }
    
    public static CTMoveBookmark parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTMoveBookmark)POIXMLTypeLoader.parse(param1InputStream, CTMoveBookmark.type, null);
    }
    
    public static CTMoveBookmark parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTMoveBookmark)POIXMLTypeLoader.parse(param1InputStream, CTMoveBookmark.type, param1XmlOptions);
    }
    
    public static CTMoveBookmark parse(Reader param1Reader) throws XmlException, IOException {
      return (CTMoveBookmark)POIXMLTypeLoader.parse(param1Reader, CTMoveBookmark.type, null);
    }
    
    public static CTMoveBookmark parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTMoveBookmark)POIXMLTypeLoader.parse(param1Reader, CTMoveBookmark.type, param1XmlOptions);
    }
    
    public static CTMoveBookmark parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTMoveBookmark)POIXMLTypeLoader.parse(param1XMLStreamReader, CTMoveBookmark.type, null);
    }
    
    public static CTMoveBookmark parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTMoveBookmark)POIXMLTypeLoader.parse(param1XMLStreamReader, CTMoveBookmark.type, param1XmlOptions);
    }
    
    public static CTMoveBookmark parse(Node param1Node) throws XmlException {
      return (CTMoveBookmark)POIXMLTypeLoader.parse(param1Node, CTMoveBookmark.type, null);
    }
    
    public static CTMoveBookmark parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTMoveBookmark)POIXMLTypeLoader.parse(param1Node, CTMoveBookmark.type, param1XmlOptions);
    }
    
    public static CTMoveBookmark parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTMoveBookmark)POIXMLTypeLoader.parse(param1XMLInputStream, CTMoveBookmark.type, null);
    }
    
    public static CTMoveBookmark parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTMoveBookmark)POIXMLTypeLoader.parse(param1XMLInputStream, CTMoveBookmark.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTMoveBookmark.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTMoveBookmark.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTMoveBookmark.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */