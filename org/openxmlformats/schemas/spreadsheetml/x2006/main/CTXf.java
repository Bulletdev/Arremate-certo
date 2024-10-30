package org.openxmlformats.schemas.spreadsheetml.x2006.main;

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
import org.w3c.dom.Node;

public interface CTXf extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTXf.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctxf97f7type");
  
  CTCellAlignment getAlignment();
  
  boolean isSetAlignment();
  
  void setAlignment(CTCellAlignment paramCTCellAlignment);
  
  CTCellAlignment addNewAlignment();
  
  void unsetAlignment();
  
  CTCellProtection getProtection();
  
  boolean isSetProtection();
  
  void setProtection(CTCellProtection paramCTCellProtection);
  
  CTCellProtection addNewProtection();
  
  void unsetProtection();
  
  CTExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTExtensionList paramCTExtensionList);
  
  CTExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  long getNumFmtId();
  
  STNumFmtId xgetNumFmtId();
  
  boolean isSetNumFmtId();
  
  void setNumFmtId(long paramLong);
  
  void xsetNumFmtId(STNumFmtId paramSTNumFmtId);
  
  void unsetNumFmtId();
  
  long getFontId();
  
  STFontId xgetFontId();
  
  boolean isSetFontId();
  
  void setFontId(long paramLong);
  
  void xsetFontId(STFontId paramSTFontId);
  
  void unsetFontId();
  
  long getFillId();
  
  STFillId xgetFillId();
  
  boolean isSetFillId();
  
  void setFillId(long paramLong);
  
  void xsetFillId(STFillId paramSTFillId);
  
  void unsetFillId();
  
  long getBorderId();
  
  STBorderId xgetBorderId();
  
  boolean isSetBorderId();
  
  void setBorderId(long paramLong);
  
  void xsetBorderId(STBorderId paramSTBorderId);
  
  void unsetBorderId();
  
  long getXfId();
  
  STCellStyleXfId xgetXfId();
  
  boolean isSetXfId();
  
  void setXfId(long paramLong);
  
  void xsetXfId(STCellStyleXfId paramSTCellStyleXfId);
  
  void unsetXfId();
  
  boolean getQuotePrefix();
  
  XmlBoolean xgetQuotePrefix();
  
  boolean isSetQuotePrefix();
  
  void setQuotePrefix(boolean paramBoolean);
  
  void xsetQuotePrefix(XmlBoolean paramXmlBoolean);
  
  void unsetQuotePrefix();
  
  boolean getPivotButton();
  
  XmlBoolean xgetPivotButton();
  
  boolean isSetPivotButton();
  
  void setPivotButton(boolean paramBoolean);
  
  void xsetPivotButton(XmlBoolean paramXmlBoolean);
  
  void unsetPivotButton();
  
  boolean getApplyNumberFormat();
  
  XmlBoolean xgetApplyNumberFormat();
  
  boolean isSetApplyNumberFormat();
  
  void setApplyNumberFormat(boolean paramBoolean);
  
  void xsetApplyNumberFormat(XmlBoolean paramXmlBoolean);
  
  void unsetApplyNumberFormat();
  
  boolean getApplyFont();
  
  XmlBoolean xgetApplyFont();
  
  boolean isSetApplyFont();
  
  void setApplyFont(boolean paramBoolean);
  
  void xsetApplyFont(XmlBoolean paramXmlBoolean);
  
  void unsetApplyFont();
  
  boolean getApplyFill();
  
  XmlBoolean xgetApplyFill();
  
  boolean isSetApplyFill();
  
  void setApplyFill(boolean paramBoolean);
  
  void xsetApplyFill(XmlBoolean paramXmlBoolean);
  
  void unsetApplyFill();
  
  boolean getApplyBorder();
  
  XmlBoolean xgetApplyBorder();
  
  boolean isSetApplyBorder();
  
  void setApplyBorder(boolean paramBoolean);
  
  void xsetApplyBorder(XmlBoolean paramXmlBoolean);
  
  void unsetApplyBorder();
  
  boolean getApplyAlignment();
  
  XmlBoolean xgetApplyAlignment();
  
  boolean isSetApplyAlignment();
  
  void setApplyAlignment(boolean paramBoolean);
  
  void xsetApplyAlignment(XmlBoolean paramXmlBoolean);
  
  void unsetApplyAlignment();
  
  boolean getApplyProtection();
  
  XmlBoolean xgetApplyProtection();
  
  boolean isSetApplyProtection();
  
  void setApplyProtection(boolean paramBoolean);
  
  void xsetApplyProtection(XmlBoolean paramXmlBoolean);
  
  void unsetApplyProtection();
  
  public static final class Factory {
    public static CTXf newInstance() {
      return (CTXf)POIXMLTypeLoader.newInstance(CTXf.type, null);
    }
    
    public static CTXf newInstance(XmlOptions param1XmlOptions) {
      return (CTXf)POIXMLTypeLoader.newInstance(CTXf.type, param1XmlOptions);
    }
    
    public static CTXf parse(String param1String) throws XmlException {
      return (CTXf)POIXMLTypeLoader.parse(param1String, CTXf.type, null);
    }
    
    public static CTXf parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTXf)POIXMLTypeLoader.parse(param1String, CTXf.type, param1XmlOptions);
    }
    
    public static CTXf parse(File param1File) throws XmlException, IOException {
      return (CTXf)POIXMLTypeLoader.parse(param1File, CTXf.type, null);
    }
    
    public static CTXf parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTXf)POIXMLTypeLoader.parse(param1File, CTXf.type, param1XmlOptions);
    }
    
    public static CTXf parse(URL param1URL) throws XmlException, IOException {
      return (CTXf)POIXMLTypeLoader.parse(param1URL, CTXf.type, null);
    }
    
    public static CTXf parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTXf)POIXMLTypeLoader.parse(param1URL, CTXf.type, param1XmlOptions);
    }
    
    public static CTXf parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTXf)POIXMLTypeLoader.parse(param1InputStream, CTXf.type, null);
    }
    
    public static CTXf parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTXf)POIXMLTypeLoader.parse(param1InputStream, CTXf.type, param1XmlOptions);
    }
    
    public static CTXf parse(Reader param1Reader) throws XmlException, IOException {
      return (CTXf)POIXMLTypeLoader.parse(param1Reader, CTXf.type, null);
    }
    
    public static CTXf parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTXf)POIXMLTypeLoader.parse(param1Reader, CTXf.type, param1XmlOptions);
    }
    
    public static CTXf parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTXf)POIXMLTypeLoader.parse(param1XMLStreamReader, CTXf.type, null);
    }
    
    public static CTXf parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTXf)POIXMLTypeLoader.parse(param1XMLStreamReader, CTXf.type, param1XmlOptions);
    }
    
    public static CTXf parse(Node param1Node) throws XmlException {
      return (CTXf)POIXMLTypeLoader.parse(param1Node, CTXf.type, null);
    }
    
    public static CTXf parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTXf)POIXMLTypeLoader.parse(param1Node, CTXf.type, param1XmlOptions);
    }
    
    public static CTXf parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTXf)POIXMLTypeLoader.parse(param1XMLInputStream, CTXf.type, null);
    }
    
    public static CTXf parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTXf)POIXMLTypeLoader.parse(param1XMLInputStream, CTXf.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTXf.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTXf.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTXf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */