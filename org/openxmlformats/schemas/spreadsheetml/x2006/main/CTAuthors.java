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

public interface CTAuthors extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTAuthors.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctauthorsb8a7type");
  
  List<String> getAuthorList();
  
  String[] getAuthorArray();
  
  String getAuthorArray(int paramInt);
  
  List<STXstring> xgetAuthorList();
  
  STXstring[] xgetAuthorArray();
  
  STXstring xgetAuthorArray(int paramInt);
  
  int sizeOfAuthorArray();
  
  void setAuthorArray(String[] paramArrayOfString);
  
  void setAuthorArray(int paramInt, String paramString);
  
  void xsetAuthorArray(STXstring[] paramArrayOfSTXstring);
  
  void xsetAuthorArray(int paramInt, STXstring paramSTXstring);
  
  void insertAuthor(int paramInt, String paramString);
  
  void addAuthor(String paramString);
  
  STXstring insertNewAuthor(int paramInt);
  
  STXstring addNewAuthor();
  
  void removeAuthor(int paramInt);
  
  public static final class Factory {
    public static CTAuthors newInstance() {
      return (CTAuthors)POIXMLTypeLoader.newInstance(CTAuthors.type, null);
    }
    
    public static CTAuthors newInstance(XmlOptions param1XmlOptions) {
      return (CTAuthors)POIXMLTypeLoader.newInstance(CTAuthors.type, param1XmlOptions);
    }
    
    public static CTAuthors parse(String param1String) throws XmlException {
      return (CTAuthors)POIXMLTypeLoader.parse(param1String, CTAuthors.type, null);
    }
    
    public static CTAuthors parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTAuthors)POIXMLTypeLoader.parse(param1String, CTAuthors.type, param1XmlOptions);
    }
    
    public static CTAuthors parse(File param1File) throws XmlException, IOException {
      return (CTAuthors)POIXMLTypeLoader.parse(param1File, CTAuthors.type, null);
    }
    
    public static CTAuthors parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTAuthors)POIXMLTypeLoader.parse(param1File, CTAuthors.type, param1XmlOptions);
    }
    
    public static CTAuthors parse(URL param1URL) throws XmlException, IOException {
      return (CTAuthors)POIXMLTypeLoader.parse(param1URL, CTAuthors.type, null);
    }
    
    public static CTAuthors parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTAuthors)POIXMLTypeLoader.parse(param1URL, CTAuthors.type, param1XmlOptions);
    }
    
    public static CTAuthors parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTAuthors)POIXMLTypeLoader.parse(param1InputStream, CTAuthors.type, null);
    }
    
    public static CTAuthors parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTAuthors)POIXMLTypeLoader.parse(param1InputStream, CTAuthors.type, param1XmlOptions);
    }
    
    public static CTAuthors parse(Reader param1Reader) throws XmlException, IOException {
      return (CTAuthors)POIXMLTypeLoader.parse(param1Reader, CTAuthors.type, null);
    }
    
    public static CTAuthors parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTAuthors)POIXMLTypeLoader.parse(param1Reader, CTAuthors.type, param1XmlOptions);
    }
    
    public static CTAuthors parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTAuthors)POIXMLTypeLoader.parse(param1XMLStreamReader, CTAuthors.type, null);
    }
    
    public static CTAuthors parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTAuthors)POIXMLTypeLoader.parse(param1XMLStreamReader, CTAuthors.type, param1XmlOptions);
    }
    
    public static CTAuthors parse(Node param1Node) throws XmlException {
      return (CTAuthors)POIXMLTypeLoader.parse(param1Node, CTAuthors.type, null);
    }
    
    public static CTAuthors parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTAuthors)POIXMLTypeLoader.parse(param1Node, CTAuthors.type, param1XmlOptions);
    }
    
    public static CTAuthors parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTAuthors)POIXMLTypeLoader.parse(param1XMLInputStream, CTAuthors.type, null);
    }
    
    public static CTAuthors parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTAuthors)POIXMLTypeLoader.parse(param1XMLInputStream, CTAuthors.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTAuthors.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTAuthors.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTAuthors.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */