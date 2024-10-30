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

public interface CTComments extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTComments.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctcommentse3bdtype");
  
  CTAuthors getAuthors();
  
  void setAuthors(CTAuthors paramCTAuthors);
  
  CTAuthors addNewAuthors();
  
  CTCommentList getCommentList();
  
  void setCommentList(CTCommentList paramCTCommentList);
  
  CTCommentList addNewCommentList();
  
  CTExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTExtensionList paramCTExtensionList);
  
  CTExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  public static final class Factory {
    public static CTComments newInstance() {
      return (CTComments)POIXMLTypeLoader.newInstance(CTComments.type, null);
    }
    
    public static CTComments newInstance(XmlOptions param1XmlOptions) {
      return (CTComments)POIXMLTypeLoader.newInstance(CTComments.type, param1XmlOptions);
    }
    
    public static CTComments parse(String param1String) throws XmlException {
      return (CTComments)POIXMLTypeLoader.parse(param1String, CTComments.type, null);
    }
    
    public static CTComments parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTComments)POIXMLTypeLoader.parse(param1String, CTComments.type, param1XmlOptions);
    }
    
    public static CTComments parse(File param1File) throws XmlException, IOException {
      return (CTComments)POIXMLTypeLoader.parse(param1File, CTComments.type, null);
    }
    
    public static CTComments parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTComments)POIXMLTypeLoader.parse(param1File, CTComments.type, param1XmlOptions);
    }
    
    public static CTComments parse(URL param1URL) throws XmlException, IOException {
      return (CTComments)POIXMLTypeLoader.parse(param1URL, CTComments.type, null);
    }
    
    public static CTComments parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTComments)POIXMLTypeLoader.parse(param1URL, CTComments.type, param1XmlOptions);
    }
    
    public static CTComments parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTComments)POIXMLTypeLoader.parse(param1InputStream, CTComments.type, null);
    }
    
    public static CTComments parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTComments)POIXMLTypeLoader.parse(param1InputStream, CTComments.type, param1XmlOptions);
    }
    
    public static CTComments parse(Reader param1Reader) throws XmlException, IOException {
      return (CTComments)POIXMLTypeLoader.parse(param1Reader, CTComments.type, null);
    }
    
    public static CTComments parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTComments)POIXMLTypeLoader.parse(param1Reader, CTComments.type, param1XmlOptions);
    }
    
    public static CTComments parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTComments)POIXMLTypeLoader.parse(param1XMLStreamReader, CTComments.type, null);
    }
    
    public static CTComments parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTComments)POIXMLTypeLoader.parse(param1XMLStreamReader, CTComments.type, param1XmlOptions);
    }
    
    public static CTComments parse(Node param1Node) throws XmlException {
      return (CTComments)POIXMLTypeLoader.parse(param1Node, CTComments.type, null);
    }
    
    public static CTComments parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTComments)POIXMLTypeLoader.parse(param1Node, CTComments.type, param1XmlOptions);
    }
    
    public static CTComments parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTComments)POIXMLTypeLoader.parse(param1XMLInputStream, CTComments.type, null);
    }
    
    public static CTComments parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTComments)POIXMLTypeLoader.parse(param1XMLInputStream, CTComments.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTComments.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTComments.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTComments.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */