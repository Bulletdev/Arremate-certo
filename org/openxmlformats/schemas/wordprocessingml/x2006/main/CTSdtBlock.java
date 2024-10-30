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

public interface CTSdtBlock extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTSdtBlock.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctsdtblock221etype");
  
  CTSdtPr getSdtPr();
  
  boolean isSetSdtPr();
  
  void setSdtPr(CTSdtPr paramCTSdtPr);
  
  CTSdtPr addNewSdtPr();
  
  void unsetSdtPr();
  
  CTSdtEndPr getSdtEndPr();
  
  boolean isSetSdtEndPr();
  
  void setSdtEndPr(CTSdtEndPr paramCTSdtEndPr);
  
  CTSdtEndPr addNewSdtEndPr();
  
  void unsetSdtEndPr();
  
  CTSdtContentBlock getSdtContent();
  
  boolean isSetSdtContent();
  
  void setSdtContent(CTSdtContentBlock paramCTSdtContentBlock);
  
  CTSdtContentBlock addNewSdtContent();
  
  void unsetSdtContent();
  
  public static final class Factory {
    public static CTSdtBlock newInstance() {
      return (CTSdtBlock)POIXMLTypeLoader.newInstance(CTSdtBlock.type, null);
    }
    
    public static CTSdtBlock newInstance(XmlOptions param1XmlOptions) {
      return (CTSdtBlock)POIXMLTypeLoader.newInstance(CTSdtBlock.type, param1XmlOptions);
    }
    
    public static CTSdtBlock parse(String param1String) throws XmlException {
      return (CTSdtBlock)POIXMLTypeLoader.parse(param1String, CTSdtBlock.type, null);
    }
    
    public static CTSdtBlock parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSdtBlock)POIXMLTypeLoader.parse(param1String, CTSdtBlock.type, param1XmlOptions);
    }
    
    public static CTSdtBlock parse(File param1File) throws XmlException, IOException {
      return (CTSdtBlock)POIXMLTypeLoader.parse(param1File, CTSdtBlock.type, null);
    }
    
    public static CTSdtBlock parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSdtBlock)POIXMLTypeLoader.parse(param1File, CTSdtBlock.type, param1XmlOptions);
    }
    
    public static CTSdtBlock parse(URL param1URL) throws XmlException, IOException {
      return (CTSdtBlock)POIXMLTypeLoader.parse(param1URL, CTSdtBlock.type, null);
    }
    
    public static CTSdtBlock parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSdtBlock)POIXMLTypeLoader.parse(param1URL, CTSdtBlock.type, param1XmlOptions);
    }
    
    public static CTSdtBlock parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTSdtBlock)POIXMLTypeLoader.parse(param1InputStream, CTSdtBlock.type, null);
    }
    
    public static CTSdtBlock parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSdtBlock)POIXMLTypeLoader.parse(param1InputStream, CTSdtBlock.type, param1XmlOptions);
    }
    
    public static CTSdtBlock parse(Reader param1Reader) throws XmlException, IOException {
      return (CTSdtBlock)POIXMLTypeLoader.parse(param1Reader, CTSdtBlock.type, null);
    }
    
    public static CTSdtBlock parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSdtBlock)POIXMLTypeLoader.parse(param1Reader, CTSdtBlock.type, param1XmlOptions);
    }
    
    public static CTSdtBlock parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTSdtBlock)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSdtBlock.type, null);
    }
    
    public static CTSdtBlock parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSdtBlock)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSdtBlock.type, param1XmlOptions);
    }
    
    public static CTSdtBlock parse(Node param1Node) throws XmlException {
      return (CTSdtBlock)POIXMLTypeLoader.parse(param1Node, CTSdtBlock.type, null);
    }
    
    public static CTSdtBlock parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSdtBlock)POIXMLTypeLoader.parse(param1Node, CTSdtBlock.type, param1XmlOptions);
    }
    
    public static CTSdtBlock parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTSdtBlock)POIXMLTypeLoader.parse(param1XMLInputStream, CTSdtBlock.type, null);
    }
    
    public static CTSdtBlock parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTSdtBlock)POIXMLTypeLoader.parse(param1XMLInputStream, CTSdtBlock.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSdtBlock.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSdtBlock.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTSdtBlock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */