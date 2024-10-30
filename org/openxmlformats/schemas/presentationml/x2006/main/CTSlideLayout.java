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
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorMappingOverride;
import org.w3c.dom.Node;

public interface CTSlideLayout extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTSlideLayout.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctslidelayouteb34type");
  
  CTCommonSlideData getCSld();
  
  void setCSld(CTCommonSlideData paramCTCommonSlideData);
  
  CTCommonSlideData addNewCSld();
  
  CTColorMappingOverride getClrMapOvr();
  
  boolean isSetClrMapOvr();
  
  void setClrMapOvr(CTColorMappingOverride paramCTColorMappingOverride);
  
  CTColorMappingOverride addNewClrMapOvr();
  
  void unsetClrMapOvr();
  
  CTSlideTransition getTransition();
  
  boolean isSetTransition();
  
  void setTransition(CTSlideTransition paramCTSlideTransition);
  
  CTSlideTransition addNewTransition();
  
  void unsetTransition();
  
  CTSlideTiming getTiming();
  
  boolean isSetTiming();
  
  void setTiming(CTSlideTiming paramCTSlideTiming);
  
  CTSlideTiming addNewTiming();
  
  void unsetTiming();
  
  CTHeaderFooter getHf();
  
  boolean isSetHf();
  
  void setHf(CTHeaderFooter paramCTHeaderFooter);
  
  CTHeaderFooter addNewHf();
  
  void unsetHf();
  
  CTExtensionListModify getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTExtensionListModify paramCTExtensionListModify);
  
  CTExtensionListModify addNewExtLst();
  
  void unsetExtLst();
  
  boolean getShowMasterSp();
  
  XmlBoolean xgetShowMasterSp();
  
  boolean isSetShowMasterSp();
  
  void setShowMasterSp(boolean paramBoolean);
  
  void xsetShowMasterSp(XmlBoolean paramXmlBoolean);
  
  void unsetShowMasterSp();
  
  boolean getShowMasterPhAnim();
  
  XmlBoolean xgetShowMasterPhAnim();
  
  boolean isSetShowMasterPhAnim();
  
  void setShowMasterPhAnim(boolean paramBoolean);
  
  void xsetShowMasterPhAnim(XmlBoolean paramXmlBoolean);
  
  void unsetShowMasterPhAnim();
  
  String getMatchingName();
  
  XmlString xgetMatchingName();
  
  boolean isSetMatchingName();
  
  void setMatchingName(String paramString);
  
  void xsetMatchingName(XmlString paramXmlString);
  
  void unsetMatchingName();
  
  STSlideLayoutType.Enum getType();
  
  STSlideLayoutType xgetType();
  
  boolean isSetType();
  
  void setType(STSlideLayoutType.Enum paramEnum);
  
  void xsetType(STSlideLayoutType paramSTSlideLayoutType);
  
  void unsetType();
  
  boolean getPreserve();
  
  XmlBoolean xgetPreserve();
  
  boolean isSetPreserve();
  
  void setPreserve(boolean paramBoolean);
  
  void xsetPreserve(XmlBoolean paramXmlBoolean);
  
  void unsetPreserve();
  
  boolean getUserDrawn();
  
  XmlBoolean xgetUserDrawn();
  
  boolean isSetUserDrawn();
  
  void setUserDrawn(boolean paramBoolean);
  
  void xsetUserDrawn(XmlBoolean paramXmlBoolean);
  
  void unsetUserDrawn();
  
  public static final class Factory {
    public static CTSlideLayout newInstance() {
      return (CTSlideLayout)POIXMLTypeLoader.newInstance(CTSlideLayout.type, null);
    }
    
    public static CTSlideLayout newInstance(XmlOptions param1XmlOptions) {
      return (CTSlideLayout)POIXMLTypeLoader.newInstance(CTSlideLayout.type, param1XmlOptions);
    }
    
    public static CTSlideLayout parse(String param1String) throws XmlException {
      return (CTSlideLayout)POIXMLTypeLoader.parse(param1String, CTSlideLayout.type, null);
    }
    
    public static CTSlideLayout parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSlideLayout)POIXMLTypeLoader.parse(param1String, CTSlideLayout.type, param1XmlOptions);
    }
    
    public static CTSlideLayout parse(File param1File) throws XmlException, IOException {
      return (CTSlideLayout)POIXMLTypeLoader.parse(param1File, CTSlideLayout.type, null);
    }
    
    public static CTSlideLayout parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSlideLayout)POIXMLTypeLoader.parse(param1File, CTSlideLayout.type, param1XmlOptions);
    }
    
    public static CTSlideLayout parse(URL param1URL) throws XmlException, IOException {
      return (CTSlideLayout)POIXMLTypeLoader.parse(param1URL, CTSlideLayout.type, null);
    }
    
    public static CTSlideLayout parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSlideLayout)POIXMLTypeLoader.parse(param1URL, CTSlideLayout.type, param1XmlOptions);
    }
    
    public static CTSlideLayout parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTSlideLayout)POIXMLTypeLoader.parse(param1InputStream, CTSlideLayout.type, null);
    }
    
    public static CTSlideLayout parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSlideLayout)POIXMLTypeLoader.parse(param1InputStream, CTSlideLayout.type, param1XmlOptions);
    }
    
    public static CTSlideLayout parse(Reader param1Reader) throws XmlException, IOException {
      return (CTSlideLayout)POIXMLTypeLoader.parse(param1Reader, CTSlideLayout.type, null);
    }
    
    public static CTSlideLayout parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSlideLayout)POIXMLTypeLoader.parse(param1Reader, CTSlideLayout.type, param1XmlOptions);
    }
    
    public static CTSlideLayout parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTSlideLayout)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSlideLayout.type, null);
    }
    
    public static CTSlideLayout parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSlideLayout)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSlideLayout.type, param1XmlOptions);
    }
    
    public static CTSlideLayout parse(Node param1Node) throws XmlException {
      return (CTSlideLayout)POIXMLTypeLoader.parse(param1Node, CTSlideLayout.type, null);
    }
    
    public static CTSlideLayout parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSlideLayout)POIXMLTypeLoader.parse(param1Node, CTSlideLayout.type, param1XmlOptions);
    }
    
    public static CTSlideLayout parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTSlideLayout)POIXMLTypeLoader.parse(param1XMLInputStream, CTSlideLayout.type, null);
    }
    
    public static CTSlideLayout parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTSlideLayout)POIXMLTypeLoader.parse(param1XMLInputStream, CTSlideLayout.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSlideLayout.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSlideLayout.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\CTSlideLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */