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

public interface CTFormulas extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTFormulas.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctformulas808btype");
  
  List<CTF> getFList();
  
  CTF[] getFArray();
  
  CTF getFArray(int paramInt);
  
  int sizeOfFArray();
  
  void setFArray(CTF[] paramArrayOfCTF);
  
  void setFArray(int paramInt, CTF paramCTF);
  
  CTF insertNewF(int paramInt);
  
  CTF addNewF();
  
  void removeF(int paramInt);
  
  public static final class Factory {
    public static CTFormulas newInstance() {
      return (CTFormulas)POIXMLTypeLoader.newInstance(CTFormulas.type, null);
    }
    
    public static CTFormulas newInstance(XmlOptions param1XmlOptions) {
      return (CTFormulas)POIXMLTypeLoader.newInstance(CTFormulas.type, param1XmlOptions);
    }
    
    public static CTFormulas parse(String param1String) throws XmlException {
      return (CTFormulas)POIXMLTypeLoader.parse(param1String, CTFormulas.type, null);
    }
    
    public static CTFormulas parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTFormulas)POIXMLTypeLoader.parse(param1String, CTFormulas.type, param1XmlOptions);
    }
    
    public static CTFormulas parse(File param1File) throws XmlException, IOException {
      return (CTFormulas)POIXMLTypeLoader.parse(param1File, CTFormulas.type, null);
    }
    
    public static CTFormulas parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTFormulas)POIXMLTypeLoader.parse(param1File, CTFormulas.type, param1XmlOptions);
    }
    
    public static CTFormulas parse(URL param1URL) throws XmlException, IOException {
      return (CTFormulas)POIXMLTypeLoader.parse(param1URL, CTFormulas.type, null);
    }
    
    public static CTFormulas parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTFormulas)POIXMLTypeLoader.parse(param1URL, CTFormulas.type, param1XmlOptions);
    }
    
    public static CTFormulas parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTFormulas)POIXMLTypeLoader.parse(param1InputStream, CTFormulas.type, null);
    }
    
    public static CTFormulas parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTFormulas)POIXMLTypeLoader.parse(param1InputStream, CTFormulas.type, param1XmlOptions);
    }
    
    public static CTFormulas parse(Reader param1Reader) throws XmlException, IOException {
      return (CTFormulas)POIXMLTypeLoader.parse(param1Reader, CTFormulas.type, null);
    }
    
    public static CTFormulas parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTFormulas)POIXMLTypeLoader.parse(param1Reader, CTFormulas.type, param1XmlOptions);
    }
    
    public static CTFormulas parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTFormulas)POIXMLTypeLoader.parse(param1XMLStreamReader, CTFormulas.type, null);
    }
    
    public static CTFormulas parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTFormulas)POIXMLTypeLoader.parse(param1XMLStreamReader, CTFormulas.type, param1XmlOptions);
    }
    
    public static CTFormulas parse(Node param1Node) throws XmlException {
      return (CTFormulas)POIXMLTypeLoader.parse(param1Node, CTFormulas.type, null);
    }
    
    public static CTFormulas parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTFormulas)POIXMLTypeLoader.parse(param1Node, CTFormulas.type, param1XmlOptions);
    }
    
    public static CTFormulas parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTFormulas)POIXMLTypeLoader.parse(param1XMLInputStream, CTFormulas.type, null);
    }
    
    public static CTFormulas parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTFormulas)POIXMLTypeLoader.parse(param1XMLInputStream, CTFormulas.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTFormulas.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTFormulas.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\vml\CTFormulas.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */