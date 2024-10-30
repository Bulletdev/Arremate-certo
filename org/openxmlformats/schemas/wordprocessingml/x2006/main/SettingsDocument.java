package org.openxmlformats.schemas.wordprocessingml.x2006.main;

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

public interface SettingsDocument extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(SettingsDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("settings9dd1doctype");
  
  CTSettings getSettings();
  
  void setSettings(CTSettings paramCTSettings);
  
  CTSettings addNewSettings();
  
  public static final class Factory {
    public static SettingsDocument newInstance() {
      return (SettingsDocument)POIXMLTypeLoader.newInstance(SettingsDocument.type, null);
    }
    
    public static SettingsDocument newInstance(XmlOptions param1XmlOptions) {
      return (SettingsDocument)POIXMLTypeLoader.newInstance(SettingsDocument.type, param1XmlOptions);
    }
    
    public static SettingsDocument parse(String param1String) throws XmlException {
      return (SettingsDocument)POIXMLTypeLoader.parse(param1String, SettingsDocument.type, null);
    }
    
    public static SettingsDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (SettingsDocument)POIXMLTypeLoader.parse(param1String, SettingsDocument.type, param1XmlOptions);
    }
    
    public static SettingsDocument parse(File param1File) throws XmlException, IOException {
      return (SettingsDocument)POIXMLTypeLoader.parse(param1File, SettingsDocument.type, null);
    }
    
    public static SettingsDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (SettingsDocument)POIXMLTypeLoader.parse(param1File, SettingsDocument.type, param1XmlOptions);
    }
    
    public static SettingsDocument parse(URL param1URL) throws XmlException, IOException {
      return (SettingsDocument)POIXMLTypeLoader.parse(param1URL, SettingsDocument.type, null);
    }
    
    public static SettingsDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (SettingsDocument)POIXMLTypeLoader.parse(param1URL, SettingsDocument.type, param1XmlOptions);
    }
    
    public static SettingsDocument parse(InputStream param1InputStream) throws XmlException, IOException {
      return (SettingsDocument)POIXMLTypeLoader.parse(param1InputStream, SettingsDocument.type, null);
    }
    
    public static SettingsDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (SettingsDocument)POIXMLTypeLoader.parse(param1InputStream, SettingsDocument.type, param1XmlOptions);
    }
    
    public static SettingsDocument parse(Reader param1Reader) throws XmlException, IOException {
      return (SettingsDocument)POIXMLTypeLoader.parse(param1Reader, SettingsDocument.type, null);
    }
    
    public static SettingsDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (SettingsDocument)POIXMLTypeLoader.parse(param1Reader, SettingsDocument.type, param1XmlOptions);
    }
    
    public static SettingsDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (SettingsDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, SettingsDocument.type, null);
    }
    
    public static SettingsDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (SettingsDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, SettingsDocument.type, param1XmlOptions);
    }
    
    public static SettingsDocument parse(Node param1Node) throws XmlException {
      return (SettingsDocument)POIXMLTypeLoader.parse(param1Node, SettingsDocument.type, null);
    }
    
    public static SettingsDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (SettingsDocument)POIXMLTypeLoader.parse(param1Node, SettingsDocument.type, param1XmlOptions);
    }
    
    public static SettingsDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (SettingsDocument)POIXMLTypeLoader.parse(param1XMLInputStream, SettingsDocument.type, null);
    }
    
    public static SettingsDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (SettingsDocument)POIXMLTypeLoader.parse(param1XMLInputStream, SettingsDocument.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, SettingsDocument.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, SettingsDocument.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\SettingsDocument.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */