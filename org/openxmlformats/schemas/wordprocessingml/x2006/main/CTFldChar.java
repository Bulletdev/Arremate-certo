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

public interface CTFldChar extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTFldChar.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctfldchare83etype");
  
  CTText getFldData();
  
  boolean isSetFldData();
  
  void setFldData(CTText paramCTText);
  
  CTText addNewFldData();
  
  void unsetFldData();
  
  CTFFData getFfData();
  
  boolean isSetFfData();
  
  void setFfData(CTFFData paramCTFFData);
  
  CTFFData addNewFfData();
  
  void unsetFfData();
  
  CTTrackChangeNumbering getNumberingChange();
  
  boolean isSetNumberingChange();
  
  void setNumberingChange(CTTrackChangeNumbering paramCTTrackChangeNumbering);
  
  CTTrackChangeNumbering addNewNumberingChange();
  
  void unsetNumberingChange();
  
  STFldCharType.Enum getFldCharType();
  
  STFldCharType xgetFldCharType();
  
  void setFldCharType(STFldCharType.Enum paramEnum);
  
  void xsetFldCharType(STFldCharType paramSTFldCharType);
  
  STOnOff.Enum getFldLock();
  
  STOnOff xgetFldLock();
  
  boolean isSetFldLock();
  
  void setFldLock(STOnOff.Enum paramEnum);
  
  void xsetFldLock(STOnOff paramSTOnOff);
  
  void unsetFldLock();
  
  STOnOff.Enum getDirty();
  
  STOnOff xgetDirty();
  
  boolean isSetDirty();
  
  void setDirty(STOnOff.Enum paramEnum);
  
  void xsetDirty(STOnOff paramSTOnOff);
  
  void unsetDirty();
  
  public static final class Factory {
    public static CTFldChar newInstance() {
      return (CTFldChar)POIXMLTypeLoader.newInstance(CTFldChar.type, null);
    }
    
    public static CTFldChar newInstance(XmlOptions param1XmlOptions) {
      return (CTFldChar)POIXMLTypeLoader.newInstance(CTFldChar.type, param1XmlOptions);
    }
    
    public static CTFldChar parse(String param1String) throws XmlException {
      return (CTFldChar)POIXMLTypeLoader.parse(param1String, CTFldChar.type, null);
    }
    
    public static CTFldChar parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTFldChar)POIXMLTypeLoader.parse(param1String, CTFldChar.type, param1XmlOptions);
    }
    
    public static CTFldChar parse(File param1File) throws XmlException, IOException {
      return (CTFldChar)POIXMLTypeLoader.parse(param1File, CTFldChar.type, null);
    }
    
    public static CTFldChar parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTFldChar)POIXMLTypeLoader.parse(param1File, CTFldChar.type, param1XmlOptions);
    }
    
    public static CTFldChar parse(URL param1URL) throws XmlException, IOException {
      return (CTFldChar)POIXMLTypeLoader.parse(param1URL, CTFldChar.type, null);
    }
    
    public static CTFldChar parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTFldChar)POIXMLTypeLoader.parse(param1URL, CTFldChar.type, param1XmlOptions);
    }
    
    public static CTFldChar parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTFldChar)POIXMLTypeLoader.parse(param1InputStream, CTFldChar.type, null);
    }
    
    public static CTFldChar parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTFldChar)POIXMLTypeLoader.parse(param1InputStream, CTFldChar.type, param1XmlOptions);
    }
    
    public static CTFldChar parse(Reader param1Reader) throws XmlException, IOException {
      return (CTFldChar)POIXMLTypeLoader.parse(param1Reader, CTFldChar.type, null);
    }
    
    public static CTFldChar parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTFldChar)POIXMLTypeLoader.parse(param1Reader, CTFldChar.type, param1XmlOptions);
    }
    
    public static CTFldChar parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTFldChar)POIXMLTypeLoader.parse(param1XMLStreamReader, CTFldChar.type, null);
    }
    
    public static CTFldChar parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTFldChar)POIXMLTypeLoader.parse(param1XMLStreamReader, CTFldChar.type, param1XmlOptions);
    }
    
    public static CTFldChar parse(Node param1Node) throws XmlException {
      return (CTFldChar)POIXMLTypeLoader.parse(param1Node, CTFldChar.type, null);
    }
    
    public static CTFldChar parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTFldChar)POIXMLTypeLoader.parse(param1Node, CTFldChar.type, param1XmlOptions);
    }
    
    public static CTFldChar parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTFldChar)POIXMLTypeLoader.parse(param1XMLInputStream, CTFldChar.type, null);
    }
    
    public static CTFldChar parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTFldChar)POIXMLTypeLoader.parse(param1XMLInputStream, CTFldChar.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTFldChar.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTFldChar.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTFldChar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */