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
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTPPr extends CTPPrBase {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTPPr.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctppr01c0type");
  
  CTParaRPr getRPr();
  
  boolean isSetRPr();
  
  void setRPr(CTParaRPr paramCTParaRPr);
  
  CTParaRPr addNewRPr();
  
  void unsetRPr();
  
  CTSectPr getSectPr();
  
  boolean isSetSectPr();
  
  void setSectPr(CTSectPr paramCTSectPr);
  
  CTSectPr addNewSectPr();
  
  void unsetSectPr();
  
  CTPPrChange getPPrChange();
  
  boolean isSetPPrChange();
  
  void setPPrChange(CTPPrChange paramCTPPrChange);
  
  CTPPrChange addNewPPrChange();
  
  void unsetPPrChange();
  
  public static final class Factory {
    public static CTPPr newInstance() {
      return (CTPPr)POIXMLTypeLoader.newInstance(CTPPr.type, null);
    }
    
    public static CTPPr newInstance(XmlOptions param1XmlOptions) {
      return (CTPPr)POIXMLTypeLoader.newInstance(CTPPr.type, param1XmlOptions);
    }
    
    public static CTPPr parse(String param1String) throws XmlException {
      return (CTPPr)POIXMLTypeLoader.parse(param1String, CTPPr.type, null);
    }
    
    public static CTPPr parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPPr)POIXMLTypeLoader.parse(param1String, CTPPr.type, param1XmlOptions);
    }
    
    public static CTPPr parse(File param1File) throws XmlException, IOException {
      return (CTPPr)POIXMLTypeLoader.parse(param1File, CTPPr.type, null);
    }
    
    public static CTPPr parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPPr)POIXMLTypeLoader.parse(param1File, CTPPr.type, param1XmlOptions);
    }
    
    public static CTPPr parse(URL param1URL) throws XmlException, IOException {
      return (CTPPr)POIXMLTypeLoader.parse(param1URL, CTPPr.type, null);
    }
    
    public static CTPPr parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPPr)POIXMLTypeLoader.parse(param1URL, CTPPr.type, param1XmlOptions);
    }
    
    public static CTPPr parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTPPr)POIXMLTypeLoader.parse(param1InputStream, CTPPr.type, null);
    }
    
    public static CTPPr parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPPr)POIXMLTypeLoader.parse(param1InputStream, CTPPr.type, param1XmlOptions);
    }
    
    public static CTPPr parse(Reader param1Reader) throws XmlException, IOException {
      return (CTPPr)POIXMLTypeLoader.parse(param1Reader, CTPPr.type, null);
    }
    
    public static CTPPr parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPPr)POIXMLTypeLoader.parse(param1Reader, CTPPr.type, param1XmlOptions);
    }
    
    public static CTPPr parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTPPr)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPPr.type, null);
    }
    
    public static CTPPr parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPPr)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPPr.type, param1XmlOptions);
    }
    
    public static CTPPr parse(Node param1Node) throws XmlException {
      return (CTPPr)POIXMLTypeLoader.parse(param1Node, CTPPr.type, null);
    }
    
    public static CTPPr parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPPr)POIXMLTypeLoader.parse(param1Node, CTPPr.type, param1XmlOptions);
    }
    
    public static CTPPr parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTPPr)POIXMLTypeLoader.parse(param1XMLInputStream, CTPPr.type, null);
    }
    
    public static CTPPr parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTPPr)POIXMLTypeLoader.parse(param1XMLInputStream, CTPPr.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPPr.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPPr.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTPPr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */