package org.openxmlformats.schemas.presentationml.x2006.main;

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
import org.apache.xmlbeans.XmlDateTime;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D;
import org.w3c.dom.Node;

public interface CTComment extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTComment.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctcomment2d10type");
  
  CTPoint2D getPos();
  
  void setPos(CTPoint2D paramCTPoint2D);
  
  CTPoint2D addNewPos();
  
  String getText();
  
  XmlString xgetText();
  
  void setText(String paramString);
  
  void xsetText(XmlString paramXmlString);
  
  CTExtensionListModify getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTExtensionListModify paramCTExtensionListModify);
  
  CTExtensionListModify addNewExtLst();
  
  void unsetExtLst();
  
  long getAuthorId();
  
  XmlUnsignedInt xgetAuthorId();
  
  void setAuthorId(long paramLong);
  
  void xsetAuthorId(XmlUnsignedInt paramXmlUnsignedInt);
  
  Calendar getDt();
  
  XmlDateTime xgetDt();
  
  boolean isSetDt();
  
  void setDt(Calendar paramCalendar);
  
  void xsetDt(XmlDateTime paramXmlDateTime);
  
  void unsetDt();
  
  long getIdx();
  
  STIndex xgetIdx();
  
  void setIdx(long paramLong);
  
  void xsetIdx(STIndex paramSTIndex);
  
  public static final class Factory {
    public static CTComment newInstance() {
      return (CTComment)POIXMLTypeLoader.newInstance(CTComment.type, null);
    }
    
    public static CTComment newInstance(XmlOptions param1XmlOptions) {
      return (CTComment)POIXMLTypeLoader.newInstance(CTComment.type, param1XmlOptions);
    }
    
    public static CTComment parse(String param1String) throws XmlException {
      return (CTComment)POIXMLTypeLoader.parse(param1String, CTComment.type, null);
    }
    
    public static CTComment parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTComment)POIXMLTypeLoader.parse(param1String, CTComment.type, param1XmlOptions);
    }
    
    public static CTComment parse(File param1File) throws XmlException, IOException {
      return (CTComment)POIXMLTypeLoader.parse(param1File, CTComment.type, null);
    }
    
    public static CTComment parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTComment)POIXMLTypeLoader.parse(param1File, CTComment.type, param1XmlOptions);
    }
    
    public static CTComment parse(URL param1URL) throws XmlException, IOException {
      return (CTComment)POIXMLTypeLoader.parse(param1URL, CTComment.type, null);
    }
    
    public static CTComment parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTComment)POIXMLTypeLoader.parse(param1URL, CTComment.type, param1XmlOptions);
    }
    
    public static CTComment parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTComment)POIXMLTypeLoader.parse(param1InputStream, CTComment.type, null);
    }
    
    public static CTComment parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTComment)POIXMLTypeLoader.parse(param1InputStream, CTComment.type, param1XmlOptions);
    }
    
    public static CTComment parse(Reader param1Reader) throws XmlException, IOException {
      return (CTComment)POIXMLTypeLoader.parse(param1Reader, CTComment.type, null);
    }
    
    public static CTComment parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTComment)POIXMLTypeLoader.parse(param1Reader, CTComment.type, param1XmlOptions);
    }
    
    public static CTComment parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTComment)POIXMLTypeLoader.parse(param1XMLStreamReader, CTComment.type, null);
    }
    
    public static CTComment parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTComment)POIXMLTypeLoader.parse(param1XMLStreamReader, CTComment.type, param1XmlOptions);
    }
    
    public static CTComment parse(Node param1Node) throws XmlException {
      return (CTComment)POIXMLTypeLoader.parse(param1Node, CTComment.type, null);
    }
    
    public static CTComment parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTComment)POIXMLTypeLoader.parse(param1Node, CTComment.type, param1XmlOptions);
    }
    
    public static CTComment parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTComment)POIXMLTypeLoader.parse(param1XMLInputStream, CTComment.type, null);
    }
    
    public static CTComment parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTComment)POIXMLTypeLoader.parse(param1XMLInputStream, CTComment.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTComment.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTComment.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\CTComment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */