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

public interface CTCommentList extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTCommentList.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctcommentlist7a3ctype");
  
  List<CTComment> getCommentList();
  
  CTComment[] getCommentArray();
  
  CTComment getCommentArray(int paramInt);
  
  int sizeOfCommentArray();
  
  void setCommentArray(CTComment[] paramArrayOfCTComment);
  
  void setCommentArray(int paramInt, CTComment paramCTComment);
  
  CTComment insertNewComment(int paramInt);
  
  CTComment addNewComment();
  
  void removeComment(int paramInt);
  
  public static final class Factory {
    public static CTCommentList newInstance() {
      return (CTCommentList)POIXMLTypeLoader.newInstance(CTCommentList.type, null);
    }
    
    public static CTCommentList newInstance(XmlOptions param1XmlOptions) {
      return (CTCommentList)POIXMLTypeLoader.newInstance(CTCommentList.type, param1XmlOptions);
    }
    
    public static CTCommentList parse(String param1String) throws XmlException {
      return (CTCommentList)POIXMLTypeLoader.parse(param1String, CTCommentList.type, null);
    }
    
    public static CTCommentList parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCommentList)POIXMLTypeLoader.parse(param1String, CTCommentList.type, param1XmlOptions);
    }
    
    public static CTCommentList parse(File param1File) throws XmlException, IOException {
      return (CTCommentList)POIXMLTypeLoader.parse(param1File, CTCommentList.type, null);
    }
    
    public static CTCommentList parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCommentList)POIXMLTypeLoader.parse(param1File, CTCommentList.type, param1XmlOptions);
    }
    
    public static CTCommentList parse(URL param1URL) throws XmlException, IOException {
      return (CTCommentList)POIXMLTypeLoader.parse(param1URL, CTCommentList.type, null);
    }
    
    public static CTCommentList parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCommentList)POIXMLTypeLoader.parse(param1URL, CTCommentList.type, param1XmlOptions);
    }
    
    public static CTCommentList parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTCommentList)POIXMLTypeLoader.parse(param1InputStream, CTCommentList.type, null);
    }
    
    public static CTCommentList parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCommentList)POIXMLTypeLoader.parse(param1InputStream, CTCommentList.type, param1XmlOptions);
    }
    
    public static CTCommentList parse(Reader param1Reader) throws XmlException, IOException {
      return (CTCommentList)POIXMLTypeLoader.parse(param1Reader, CTCommentList.type, null);
    }
    
    public static CTCommentList parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCommentList)POIXMLTypeLoader.parse(param1Reader, CTCommentList.type, param1XmlOptions);
    }
    
    public static CTCommentList parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTCommentList)POIXMLTypeLoader.parse(param1XMLStreamReader, CTCommentList.type, null);
    }
    
    public static CTCommentList parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCommentList)POIXMLTypeLoader.parse(param1XMLStreamReader, CTCommentList.type, param1XmlOptions);
    }
    
    public static CTCommentList parse(Node param1Node) throws XmlException {
      return (CTCommentList)POIXMLTypeLoader.parse(param1Node, CTCommentList.type, null);
    }
    
    public static CTCommentList parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCommentList)POIXMLTypeLoader.parse(param1Node, CTCommentList.type, param1XmlOptions);
    }
    
    public static CTCommentList parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTCommentList)POIXMLTypeLoader.parse(param1XMLInputStream, CTCommentList.type, null);
    }
    
    public static CTCommentList parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTCommentList)POIXMLTypeLoader.parse(param1XMLInputStream, CTCommentList.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTCommentList.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTCommentList.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTCommentList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */