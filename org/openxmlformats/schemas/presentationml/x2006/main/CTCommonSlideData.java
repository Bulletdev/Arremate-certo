package org.openxmlformats.schemas.presentationml.x2006.main;

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
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTCommonSlideData extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTCommonSlideData.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctcommonslidedata8c7ftype");
  
  CTBackground getBg();
  
  boolean isSetBg();
  
  void setBg(CTBackground paramCTBackground);
  
  CTBackground addNewBg();
  
  void unsetBg();
  
  CTGroupShape getSpTree();
  
  void setSpTree(CTGroupShape paramCTGroupShape);
  
  CTGroupShape addNewSpTree();
  
  CTCustomerDataList getCustDataLst();
  
  boolean isSetCustDataLst();
  
  void setCustDataLst(CTCustomerDataList paramCTCustomerDataList);
  
  CTCustomerDataList addNewCustDataLst();
  
  void unsetCustDataLst();
  
  CTControlList getControls();
  
  boolean isSetControls();
  
  void setControls(CTControlList paramCTControlList);
  
  CTControlList addNewControls();
  
  void unsetControls();
  
  CTExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTExtensionList paramCTExtensionList);
  
  CTExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  String getName();
  
  XmlString xgetName();
  
  boolean isSetName();
  
  void setName(String paramString);
  
  void xsetName(XmlString paramXmlString);
  
  void unsetName();
  
  public static final class Factory {
    public static CTCommonSlideData newInstance() {
      return (CTCommonSlideData)POIXMLTypeLoader.newInstance(CTCommonSlideData.type, null);
    }
    
    public static CTCommonSlideData newInstance(XmlOptions param1XmlOptions) {
      return (CTCommonSlideData)POIXMLTypeLoader.newInstance(CTCommonSlideData.type, param1XmlOptions);
    }
    
    public static CTCommonSlideData parse(String param1String) throws XmlException {
      return (CTCommonSlideData)POIXMLTypeLoader.parse(param1String, CTCommonSlideData.type, null);
    }
    
    public static CTCommonSlideData parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCommonSlideData)POIXMLTypeLoader.parse(param1String, CTCommonSlideData.type, param1XmlOptions);
    }
    
    public static CTCommonSlideData parse(File param1File) throws XmlException, IOException {
      return (CTCommonSlideData)POIXMLTypeLoader.parse(param1File, CTCommonSlideData.type, null);
    }
    
    public static CTCommonSlideData parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCommonSlideData)POIXMLTypeLoader.parse(param1File, CTCommonSlideData.type, param1XmlOptions);
    }
    
    public static CTCommonSlideData parse(URL param1URL) throws XmlException, IOException {
      return (CTCommonSlideData)POIXMLTypeLoader.parse(param1URL, CTCommonSlideData.type, null);
    }
    
    public static CTCommonSlideData parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCommonSlideData)POIXMLTypeLoader.parse(param1URL, CTCommonSlideData.type, param1XmlOptions);
    }
    
    public static CTCommonSlideData parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTCommonSlideData)POIXMLTypeLoader.parse(param1InputStream, CTCommonSlideData.type, null);
    }
    
    public static CTCommonSlideData parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCommonSlideData)POIXMLTypeLoader.parse(param1InputStream, CTCommonSlideData.type, param1XmlOptions);
    }
    
    public static CTCommonSlideData parse(Reader param1Reader) throws XmlException, IOException {
      return (CTCommonSlideData)POIXMLTypeLoader.parse(param1Reader, CTCommonSlideData.type, null);
    }
    
    public static CTCommonSlideData parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCommonSlideData)POIXMLTypeLoader.parse(param1Reader, CTCommonSlideData.type, param1XmlOptions);
    }
    
    public static CTCommonSlideData parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTCommonSlideData)POIXMLTypeLoader.parse(param1XMLStreamReader, CTCommonSlideData.type, null);
    }
    
    public static CTCommonSlideData parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCommonSlideData)POIXMLTypeLoader.parse(param1XMLStreamReader, CTCommonSlideData.type, param1XmlOptions);
    }
    
    public static CTCommonSlideData parse(Node param1Node) throws XmlException {
      return (CTCommonSlideData)POIXMLTypeLoader.parse(param1Node, CTCommonSlideData.type, null);
    }
    
    public static CTCommonSlideData parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCommonSlideData)POIXMLTypeLoader.parse(param1Node, CTCommonSlideData.type, param1XmlOptions);
    }
    
    public static CTCommonSlideData parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTCommonSlideData)POIXMLTypeLoader.parse(param1XMLInputStream, CTCommonSlideData.type, null);
    }
    
    public static CTCommonSlideData parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTCommonSlideData)POIXMLTypeLoader.parse(param1XMLInputStream, CTCommonSlideData.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTCommonSlideData.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTCommonSlideData.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\CTCommonSlideData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */