package org.openxmlformats.schemas.drawingml.x2006.chart;

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

public interface CTNumData extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTNumData.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctnumdata4f16type");
  
  String getFormatCode();
  
  STXstring xgetFormatCode();
  
  boolean isSetFormatCode();
  
  void setFormatCode(String paramString);
  
  void xsetFormatCode(STXstring paramSTXstring);
  
  void unsetFormatCode();
  
  CTUnsignedInt getPtCount();
  
  boolean isSetPtCount();
  
  void setPtCount(CTUnsignedInt paramCTUnsignedInt);
  
  CTUnsignedInt addNewPtCount();
  
  void unsetPtCount();
  
  List<CTNumVal> getPtList();
  
  CTNumVal[] getPtArray();
  
  CTNumVal getPtArray(int paramInt);
  
  int sizeOfPtArray();
  
  void setPtArray(CTNumVal[] paramArrayOfCTNumVal);
  
  void setPtArray(int paramInt, CTNumVal paramCTNumVal);
  
  CTNumVal insertNewPt(int paramInt);
  
  CTNumVal addNewPt();
  
  void removePt(int paramInt);
  
  CTExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTExtensionList paramCTExtensionList);
  
  CTExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  public static final class Factory {
    public static CTNumData newInstance() {
      return (CTNumData)POIXMLTypeLoader.newInstance(CTNumData.type, null);
    }
    
    public static CTNumData newInstance(XmlOptions param1XmlOptions) {
      return (CTNumData)POIXMLTypeLoader.newInstance(CTNumData.type, param1XmlOptions);
    }
    
    public static CTNumData parse(String param1String) throws XmlException {
      return (CTNumData)POIXMLTypeLoader.parse(param1String, CTNumData.type, null);
    }
    
    public static CTNumData parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTNumData)POIXMLTypeLoader.parse(param1String, CTNumData.type, param1XmlOptions);
    }
    
    public static CTNumData parse(File param1File) throws XmlException, IOException {
      return (CTNumData)POIXMLTypeLoader.parse(param1File, CTNumData.type, null);
    }
    
    public static CTNumData parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNumData)POIXMLTypeLoader.parse(param1File, CTNumData.type, param1XmlOptions);
    }
    
    public static CTNumData parse(URL param1URL) throws XmlException, IOException {
      return (CTNumData)POIXMLTypeLoader.parse(param1URL, CTNumData.type, null);
    }
    
    public static CTNumData parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNumData)POIXMLTypeLoader.parse(param1URL, CTNumData.type, param1XmlOptions);
    }
    
    public static CTNumData parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTNumData)POIXMLTypeLoader.parse(param1InputStream, CTNumData.type, null);
    }
    
    public static CTNumData parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNumData)POIXMLTypeLoader.parse(param1InputStream, CTNumData.type, param1XmlOptions);
    }
    
    public static CTNumData parse(Reader param1Reader) throws XmlException, IOException {
      return (CTNumData)POIXMLTypeLoader.parse(param1Reader, CTNumData.type, null);
    }
    
    public static CTNumData parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNumData)POIXMLTypeLoader.parse(param1Reader, CTNumData.type, param1XmlOptions);
    }
    
    public static CTNumData parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTNumData)POIXMLTypeLoader.parse(param1XMLStreamReader, CTNumData.type, null);
    }
    
    public static CTNumData parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTNumData)POIXMLTypeLoader.parse(param1XMLStreamReader, CTNumData.type, param1XmlOptions);
    }
    
    public static CTNumData parse(Node param1Node) throws XmlException {
      return (CTNumData)POIXMLTypeLoader.parse(param1Node, CTNumData.type, null);
    }
    
    public static CTNumData parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTNumData)POIXMLTypeLoader.parse(param1Node, CTNumData.type, param1XmlOptions);
    }
    
    public static CTNumData parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTNumData)POIXMLTypeLoader.parse(param1XMLInputStream, CTNumData.type, null);
    }
    
    public static CTNumData parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTNumData)POIXMLTypeLoader.parse(param1XMLInputStream, CTNumData.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTNumData.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTNumData.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\CTNumData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */