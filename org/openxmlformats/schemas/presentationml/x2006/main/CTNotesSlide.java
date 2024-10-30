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
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorMappingOverride;
import org.w3c.dom.Node;

public interface CTNotesSlide extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTNotesSlide.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctnotesslideab75type");
  
  CTCommonSlideData getCSld();
  
  void setCSld(CTCommonSlideData paramCTCommonSlideData);
  
  CTCommonSlideData addNewCSld();
  
  CTColorMappingOverride getClrMapOvr();
  
  boolean isSetClrMapOvr();
  
  void setClrMapOvr(CTColorMappingOverride paramCTColorMappingOverride);
  
  CTColorMappingOverride addNewClrMapOvr();
  
  void unsetClrMapOvr();
  
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
  
  public static final class Factory {
    public static CTNotesSlide newInstance() {
      return (CTNotesSlide)POIXMLTypeLoader.newInstance(CTNotesSlide.type, null);
    }
    
    public static CTNotesSlide newInstance(XmlOptions param1XmlOptions) {
      return (CTNotesSlide)POIXMLTypeLoader.newInstance(CTNotesSlide.type, param1XmlOptions);
    }
    
    public static CTNotesSlide parse(String param1String) throws XmlException {
      return (CTNotesSlide)POIXMLTypeLoader.parse(param1String, CTNotesSlide.type, null);
    }
    
    public static CTNotesSlide parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTNotesSlide)POIXMLTypeLoader.parse(param1String, CTNotesSlide.type, param1XmlOptions);
    }
    
    public static CTNotesSlide parse(File param1File) throws XmlException, IOException {
      return (CTNotesSlide)POIXMLTypeLoader.parse(param1File, CTNotesSlide.type, null);
    }
    
    public static CTNotesSlide parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNotesSlide)POIXMLTypeLoader.parse(param1File, CTNotesSlide.type, param1XmlOptions);
    }
    
    public static CTNotesSlide parse(URL param1URL) throws XmlException, IOException {
      return (CTNotesSlide)POIXMLTypeLoader.parse(param1URL, CTNotesSlide.type, null);
    }
    
    public static CTNotesSlide parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNotesSlide)POIXMLTypeLoader.parse(param1URL, CTNotesSlide.type, param1XmlOptions);
    }
    
    public static CTNotesSlide parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTNotesSlide)POIXMLTypeLoader.parse(param1InputStream, CTNotesSlide.type, null);
    }
    
    public static CTNotesSlide parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNotesSlide)POIXMLTypeLoader.parse(param1InputStream, CTNotesSlide.type, param1XmlOptions);
    }
    
    public static CTNotesSlide parse(Reader param1Reader) throws XmlException, IOException {
      return (CTNotesSlide)POIXMLTypeLoader.parse(param1Reader, CTNotesSlide.type, null);
    }
    
    public static CTNotesSlide parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNotesSlide)POIXMLTypeLoader.parse(param1Reader, CTNotesSlide.type, param1XmlOptions);
    }
    
    public static CTNotesSlide parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTNotesSlide)POIXMLTypeLoader.parse(param1XMLStreamReader, CTNotesSlide.type, null);
    }
    
    public static CTNotesSlide parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTNotesSlide)POIXMLTypeLoader.parse(param1XMLStreamReader, CTNotesSlide.type, param1XmlOptions);
    }
    
    public static CTNotesSlide parse(Node param1Node) throws XmlException {
      return (CTNotesSlide)POIXMLTypeLoader.parse(param1Node, CTNotesSlide.type, null);
    }
    
    public static CTNotesSlide parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTNotesSlide)POIXMLTypeLoader.parse(param1Node, CTNotesSlide.type, param1XmlOptions);
    }
    
    public static CTNotesSlide parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTNotesSlide)POIXMLTypeLoader.parse(param1XMLInputStream, CTNotesSlide.type, null);
    }
    
    public static CTNotesSlide parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTNotesSlide)POIXMLTypeLoader.parse(param1XMLInputStream, CTNotesSlide.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTNotesSlide.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTNotesSlide.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\CTNotesSlide.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */