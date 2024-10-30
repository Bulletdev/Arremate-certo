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

public interface CTTrackChange extends CTMarkup {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTTrackChange.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttrackchangec317type");
  
  String getAuthor();
  
  STString xgetAuthor();
  
  void setAuthor(String paramString);
  
  void xsetAuthor(STString paramSTString);
  
  Calendar getDate();
  
  STDateTime xgetDate();
  
  boolean isSetDate();
  
  void setDate(Calendar paramCalendar);
  
  void xsetDate(STDateTime paramSTDateTime);
  
  void unsetDate();
  
  public static final class Factory {
    public static CTTrackChange newInstance() {
      return (CTTrackChange)POIXMLTypeLoader.newInstance(CTTrackChange.type, null);
    }
    
    public static CTTrackChange newInstance(XmlOptions param1XmlOptions) {
      return (CTTrackChange)POIXMLTypeLoader.newInstance(CTTrackChange.type, param1XmlOptions);
    }
    
    public static CTTrackChange parse(String param1String) throws XmlException {
      return (CTTrackChange)POIXMLTypeLoader.parse(param1String, CTTrackChange.type, null);
    }
    
    public static CTTrackChange parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTrackChange)POIXMLTypeLoader.parse(param1String, CTTrackChange.type, param1XmlOptions);
    }
    
    public static CTTrackChange parse(File param1File) throws XmlException, IOException {
      return (CTTrackChange)POIXMLTypeLoader.parse(param1File, CTTrackChange.type, null);
    }
    
    public static CTTrackChange parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTrackChange)POIXMLTypeLoader.parse(param1File, CTTrackChange.type, param1XmlOptions);
    }
    
    public static CTTrackChange parse(URL param1URL) throws XmlException, IOException {
      return (CTTrackChange)POIXMLTypeLoader.parse(param1URL, CTTrackChange.type, null);
    }
    
    public static CTTrackChange parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTrackChange)POIXMLTypeLoader.parse(param1URL, CTTrackChange.type, param1XmlOptions);
    }
    
    public static CTTrackChange parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTTrackChange)POIXMLTypeLoader.parse(param1InputStream, CTTrackChange.type, null);
    }
    
    public static CTTrackChange parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTrackChange)POIXMLTypeLoader.parse(param1InputStream, CTTrackChange.type, param1XmlOptions);
    }
    
    public static CTTrackChange parse(Reader param1Reader) throws XmlException, IOException {
      return (CTTrackChange)POIXMLTypeLoader.parse(param1Reader, CTTrackChange.type, null);
    }
    
    public static CTTrackChange parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTrackChange)POIXMLTypeLoader.parse(param1Reader, CTTrackChange.type, param1XmlOptions);
    }
    
    public static CTTrackChange parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTTrackChange)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTrackChange.type, null);
    }
    
    public static CTTrackChange parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTrackChange)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTrackChange.type, param1XmlOptions);
    }
    
    public static CTTrackChange parse(Node param1Node) throws XmlException {
      return (CTTrackChange)POIXMLTypeLoader.parse(param1Node, CTTrackChange.type, null);
    }
    
    public static CTTrackChange parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTrackChange)POIXMLTypeLoader.parse(param1Node, CTTrackChange.type, param1XmlOptions);
    }
    
    public static CTTrackChange parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTTrackChange)POIXMLTypeLoader.parse(param1XMLInputStream, CTTrackChange.type, null);
    }
    
    public static CTTrackChange parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTTrackChange)POIXMLTypeLoader.parse(param1XMLInputStream, CTTrackChange.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTrackChange.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTrackChange.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTTrackChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */