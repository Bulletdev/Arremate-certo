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

public interface CTDefinedNames extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTDefinedNames.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctdefinednamesce48type");
  
  List<CTDefinedName> getDefinedNameList();
  
  CTDefinedName[] getDefinedNameArray();
  
  CTDefinedName getDefinedNameArray(int paramInt);
  
  int sizeOfDefinedNameArray();
  
  void setDefinedNameArray(CTDefinedName[] paramArrayOfCTDefinedName);
  
  void setDefinedNameArray(int paramInt, CTDefinedName paramCTDefinedName);
  
  CTDefinedName insertNewDefinedName(int paramInt);
  
  CTDefinedName addNewDefinedName();
  
  void removeDefinedName(int paramInt);
  
  public static final class Factory {
    public static CTDefinedNames newInstance() {
      return (CTDefinedNames)POIXMLTypeLoader.newInstance(CTDefinedNames.type, null);
    }
    
    public static CTDefinedNames newInstance(XmlOptions param1XmlOptions) {
      return (CTDefinedNames)POIXMLTypeLoader.newInstance(CTDefinedNames.type, param1XmlOptions);
    }
    
    public static CTDefinedNames parse(String param1String) throws XmlException {
      return (CTDefinedNames)POIXMLTypeLoader.parse(param1String, CTDefinedNames.type, null);
    }
    
    public static CTDefinedNames parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTDefinedNames)POIXMLTypeLoader.parse(param1String, CTDefinedNames.type, param1XmlOptions);
    }
    
    public static CTDefinedNames parse(File param1File) throws XmlException, IOException {
      return (CTDefinedNames)POIXMLTypeLoader.parse(param1File, CTDefinedNames.type, null);
    }
    
    public static CTDefinedNames parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDefinedNames)POIXMLTypeLoader.parse(param1File, CTDefinedNames.type, param1XmlOptions);
    }
    
    public static CTDefinedNames parse(URL param1URL) throws XmlException, IOException {
      return (CTDefinedNames)POIXMLTypeLoader.parse(param1URL, CTDefinedNames.type, null);
    }
    
    public static CTDefinedNames parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDefinedNames)POIXMLTypeLoader.parse(param1URL, CTDefinedNames.type, param1XmlOptions);
    }
    
    public static CTDefinedNames parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTDefinedNames)POIXMLTypeLoader.parse(param1InputStream, CTDefinedNames.type, null);
    }
    
    public static CTDefinedNames parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDefinedNames)POIXMLTypeLoader.parse(param1InputStream, CTDefinedNames.type, param1XmlOptions);
    }
    
    public static CTDefinedNames parse(Reader param1Reader) throws XmlException, IOException {
      return (CTDefinedNames)POIXMLTypeLoader.parse(param1Reader, CTDefinedNames.type, null);
    }
    
    public static CTDefinedNames parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDefinedNames)POIXMLTypeLoader.parse(param1Reader, CTDefinedNames.type, param1XmlOptions);
    }
    
    public static CTDefinedNames parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTDefinedNames)POIXMLTypeLoader.parse(param1XMLStreamReader, CTDefinedNames.type, null);
    }
    
    public static CTDefinedNames parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTDefinedNames)POIXMLTypeLoader.parse(param1XMLStreamReader, CTDefinedNames.type, param1XmlOptions);
    }
    
    public static CTDefinedNames parse(Node param1Node) throws XmlException {
      return (CTDefinedNames)POIXMLTypeLoader.parse(param1Node, CTDefinedNames.type, null);
    }
    
    public static CTDefinedNames parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTDefinedNames)POIXMLTypeLoader.parse(param1Node, CTDefinedNames.type, param1XmlOptions);
    }
    
    public static CTDefinedNames parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTDefinedNames)POIXMLTypeLoader.parse(param1XMLInputStream, CTDefinedNames.type, null);
    }
    
    public static CTDefinedNames parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTDefinedNames)POIXMLTypeLoader.parse(param1XMLInputStream, CTDefinedNames.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTDefinedNames.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTDefinedNames.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTDefinedNames.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */