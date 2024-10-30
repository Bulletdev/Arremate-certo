package org.openxmlformats.schemas.spreadsheetml.x2006.main;

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

public interface CTIgnoredErrors extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTIgnoredErrors.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctignorederrorsbebctype");
  
  List<CTIgnoredError> getIgnoredErrorList();
  
  CTIgnoredError[] getIgnoredErrorArray();
  
  CTIgnoredError getIgnoredErrorArray(int paramInt);
  
  int sizeOfIgnoredErrorArray();
  
  void setIgnoredErrorArray(CTIgnoredError[] paramArrayOfCTIgnoredError);
  
  void setIgnoredErrorArray(int paramInt, CTIgnoredError paramCTIgnoredError);
  
  CTIgnoredError insertNewIgnoredError(int paramInt);
  
  CTIgnoredError addNewIgnoredError();
  
  void removeIgnoredError(int paramInt);
  
  CTExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTExtensionList paramCTExtensionList);
  
  CTExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  public static final class Factory {
    public static CTIgnoredErrors newInstance() {
      return (CTIgnoredErrors)POIXMLTypeLoader.newInstance(CTIgnoredErrors.type, null);
    }
    
    public static CTIgnoredErrors newInstance(XmlOptions param1XmlOptions) {
      return (CTIgnoredErrors)POIXMLTypeLoader.newInstance(CTIgnoredErrors.type, param1XmlOptions);
    }
    
    public static CTIgnoredErrors parse(String param1String) throws XmlException {
      return (CTIgnoredErrors)POIXMLTypeLoader.parse(param1String, CTIgnoredErrors.type, null);
    }
    
    public static CTIgnoredErrors parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTIgnoredErrors)POIXMLTypeLoader.parse(param1String, CTIgnoredErrors.type, param1XmlOptions);
    }
    
    public static CTIgnoredErrors parse(File param1File) throws XmlException, IOException {
      return (CTIgnoredErrors)POIXMLTypeLoader.parse(param1File, CTIgnoredErrors.type, null);
    }
    
    public static CTIgnoredErrors parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTIgnoredErrors)POIXMLTypeLoader.parse(param1File, CTIgnoredErrors.type, param1XmlOptions);
    }
    
    public static CTIgnoredErrors parse(URL param1URL) throws XmlException, IOException {
      return (CTIgnoredErrors)POIXMLTypeLoader.parse(param1URL, CTIgnoredErrors.type, null);
    }
    
    public static CTIgnoredErrors parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTIgnoredErrors)POIXMLTypeLoader.parse(param1URL, CTIgnoredErrors.type, param1XmlOptions);
    }
    
    public static CTIgnoredErrors parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTIgnoredErrors)POIXMLTypeLoader.parse(param1InputStream, CTIgnoredErrors.type, null);
    }
    
    public static CTIgnoredErrors parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTIgnoredErrors)POIXMLTypeLoader.parse(param1InputStream, CTIgnoredErrors.type, param1XmlOptions);
    }
    
    public static CTIgnoredErrors parse(Reader param1Reader) throws XmlException, IOException {
      return (CTIgnoredErrors)POIXMLTypeLoader.parse(param1Reader, CTIgnoredErrors.type, null);
    }
    
    public static CTIgnoredErrors parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTIgnoredErrors)POIXMLTypeLoader.parse(param1Reader, CTIgnoredErrors.type, param1XmlOptions);
    }
    
    public static CTIgnoredErrors parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTIgnoredErrors)POIXMLTypeLoader.parse(param1XMLStreamReader, CTIgnoredErrors.type, null);
    }
    
    public static CTIgnoredErrors parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTIgnoredErrors)POIXMLTypeLoader.parse(param1XMLStreamReader, CTIgnoredErrors.type, param1XmlOptions);
    }
    
    public static CTIgnoredErrors parse(Node param1Node) throws XmlException {
      return (CTIgnoredErrors)POIXMLTypeLoader.parse(param1Node, CTIgnoredErrors.type, null);
    }
    
    public static CTIgnoredErrors parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTIgnoredErrors)POIXMLTypeLoader.parse(param1Node, CTIgnoredErrors.type, param1XmlOptions);
    }
    
    public static CTIgnoredErrors parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTIgnoredErrors)POIXMLTypeLoader.parse(param1XMLInputStream, CTIgnoredErrors.type, null);
    }
    
    public static CTIgnoredErrors parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTIgnoredErrors)POIXMLTypeLoader.parse(param1XMLInputStream, CTIgnoredErrors.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTIgnoredErrors.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTIgnoredErrors.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTIgnoredErrors.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */