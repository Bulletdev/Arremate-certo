package com.microsoft.schemas.vml;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
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

public interface CTHandles extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTHandles.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cthandles5c1ftype");
  
  List<CTH> getHList();
  
  CTH[] getHArray();
  
  CTH getHArray(int paramInt);
  
  int sizeOfHArray();
  
  void setHArray(CTH[] paramArrayOfCTH);
  
  void setHArray(int paramInt, CTH paramCTH);
  
  CTH insertNewH(int paramInt);
  
  CTH addNewH();
  
  void removeH(int paramInt);
  
  public static final class Factory {
    public static CTHandles newInstance() {
      return (CTHandles)POIXMLTypeLoader.newInstance(CTHandles.type, null);
    }
    
    public static CTHandles newInstance(XmlOptions param1XmlOptions) {
      return (CTHandles)POIXMLTypeLoader.newInstance(CTHandles.type, param1XmlOptions);
    }
    
    public static CTHandles parse(String param1String) throws XmlException {
      return (CTHandles)POIXMLTypeLoader.parse(param1String, CTHandles.type, null);
    }
    
    public static CTHandles parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTHandles)POIXMLTypeLoader.parse(param1String, CTHandles.type, param1XmlOptions);
    }
    
    public static CTHandles parse(File param1File) throws XmlException, IOException {
      return (CTHandles)POIXMLTypeLoader.parse(param1File, CTHandles.type, null);
    }
    
    public static CTHandles parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTHandles)POIXMLTypeLoader.parse(param1File, CTHandles.type, param1XmlOptions);
    }
    
    public static CTHandles parse(URL param1URL) throws XmlException, IOException {
      return (CTHandles)POIXMLTypeLoader.parse(param1URL, CTHandles.type, null);
    }
    
    public static CTHandles parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTHandles)POIXMLTypeLoader.parse(param1URL, CTHandles.type, param1XmlOptions);
    }
    
    public static CTHandles parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTHandles)POIXMLTypeLoader.parse(param1InputStream, CTHandles.type, null);
    }
    
    public static CTHandles parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTHandles)POIXMLTypeLoader.parse(param1InputStream, CTHandles.type, param1XmlOptions);
    }
    
    public static CTHandles parse(Reader param1Reader) throws XmlException, IOException {
      return (CTHandles)POIXMLTypeLoader.parse(param1Reader, CTHandles.type, null);
    }
    
    public static CTHandles parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTHandles)POIXMLTypeLoader.parse(param1Reader, CTHandles.type, param1XmlOptions);
    }
    
    public static CTHandles parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTHandles)POIXMLTypeLoader.parse(param1XMLStreamReader, CTHandles.type, null);
    }
    
    public static CTHandles parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTHandles)POIXMLTypeLoader.parse(param1XMLStreamReader, CTHandles.type, param1XmlOptions);
    }
    
    public static CTHandles parse(Node param1Node) throws XmlException {
      return (CTHandles)POIXMLTypeLoader.parse(param1Node, CTHandles.type, null);
    }
    
    public static CTHandles parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTHandles)POIXMLTypeLoader.parse(param1Node, CTHandles.type, param1XmlOptions);
    }
    
    public static CTHandles parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTHandles)POIXMLTypeLoader.parse(param1XMLInputStream, CTHandles.type, null);
    }
    
    public static CTHandles parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTHandles)POIXMLTypeLoader.parse(param1XMLInputStream, CTHandles.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTHandles.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTHandles.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\vml\CTHandles.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */