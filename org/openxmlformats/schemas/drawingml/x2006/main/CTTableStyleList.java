package org.openxmlformats.schemas.drawingml.x2006.main;

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

public interface CTTableStyleList extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTTableStyleList.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttablestylelist4bdctype");
  
  List<CTTableStyle> getTblStyleList();
  
  CTTableStyle[] getTblStyleArray();
  
  CTTableStyle getTblStyleArray(int paramInt);
  
  int sizeOfTblStyleArray();
  
  void setTblStyleArray(CTTableStyle[] paramArrayOfCTTableStyle);
  
  void setTblStyleArray(int paramInt, CTTableStyle paramCTTableStyle);
  
  CTTableStyle insertNewTblStyle(int paramInt);
  
  CTTableStyle addNewTblStyle();
  
  void removeTblStyle(int paramInt);
  
  String getDef();
  
  STGuid xgetDef();
  
  void setDef(String paramString);
  
  void xsetDef(STGuid paramSTGuid);
  
  public static final class Factory {
    public static CTTableStyleList newInstance() {
      return (CTTableStyleList)POIXMLTypeLoader.newInstance(CTTableStyleList.type, null);
    }
    
    public static CTTableStyleList newInstance(XmlOptions param1XmlOptions) {
      return (CTTableStyleList)POIXMLTypeLoader.newInstance(CTTableStyleList.type, param1XmlOptions);
    }
    
    public static CTTableStyleList parse(String param1String) throws XmlException {
      return (CTTableStyleList)POIXMLTypeLoader.parse(param1String, CTTableStyleList.type, null);
    }
    
    public static CTTableStyleList parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTableStyleList)POIXMLTypeLoader.parse(param1String, CTTableStyleList.type, param1XmlOptions);
    }
    
    public static CTTableStyleList parse(File param1File) throws XmlException, IOException {
      return (CTTableStyleList)POIXMLTypeLoader.parse(param1File, CTTableStyleList.type, null);
    }
    
    public static CTTableStyleList parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTableStyleList)POIXMLTypeLoader.parse(param1File, CTTableStyleList.type, param1XmlOptions);
    }
    
    public static CTTableStyleList parse(URL param1URL) throws XmlException, IOException {
      return (CTTableStyleList)POIXMLTypeLoader.parse(param1URL, CTTableStyleList.type, null);
    }
    
    public static CTTableStyleList parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTableStyleList)POIXMLTypeLoader.parse(param1URL, CTTableStyleList.type, param1XmlOptions);
    }
    
    public static CTTableStyleList parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTTableStyleList)POIXMLTypeLoader.parse(param1InputStream, CTTableStyleList.type, null);
    }
    
    public static CTTableStyleList parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTableStyleList)POIXMLTypeLoader.parse(param1InputStream, CTTableStyleList.type, param1XmlOptions);
    }
    
    public static CTTableStyleList parse(Reader param1Reader) throws XmlException, IOException {
      return (CTTableStyleList)POIXMLTypeLoader.parse(param1Reader, CTTableStyleList.type, null);
    }
    
    public static CTTableStyleList parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTableStyleList)POIXMLTypeLoader.parse(param1Reader, CTTableStyleList.type, param1XmlOptions);
    }
    
    public static CTTableStyleList parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTTableStyleList)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTableStyleList.type, null);
    }
    
    public static CTTableStyleList parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTableStyleList)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTableStyleList.type, param1XmlOptions);
    }
    
    public static CTTableStyleList parse(Node param1Node) throws XmlException {
      return (CTTableStyleList)POIXMLTypeLoader.parse(param1Node, CTTableStyleList.type, null);
    }
    
    public static CTTableStyleList parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTableStyleList)POIXMLTypeLoader.parse(param1Node, CTTableStyleList.type, param1XmlOptions);
    }
    
    public static CTTableStyleList parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTTableStyleList)POIXMLTypeLoader.parse(param1XMLInputStream, CTTableStyleList.type, null);
    }
    
    public static CTTableStyleList parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTTableStyleList)POIXMLTypeLoader.parse(param1XMLInputStream, CTTableStyleList.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTableStyleList.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTableStyleList.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTTableStyleList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */