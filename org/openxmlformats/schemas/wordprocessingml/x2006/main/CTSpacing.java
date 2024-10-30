package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigInteger;
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

public interface CTSpacing extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTSpacing.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctspacingff2ftype");
  
  BigInteger getBefore();
  
  STTwipsMeasure xgetBefore();
  
  boolean isSetBefore();
  
  void setBefore(BigInteger paramBigInteger);
  
  void xsetBefore(STTwipsMeasure paramSTTwipsMeasure);
  
  void unsetBefore();
  
  BigInteger getBeforeLines();
  
  STDecimalNumber xgetBeforeLines();
  
  boolean isSetBeforeLines();
  
  void setBeforeLines(BigInteger paramBigInteger);
  
  void xsetBeforeLines(STDecimalNumber paramSTDecimalNumber);
  
  void unsetBeforeLines();
  
  STOnOff.Enum getBeforeAutospacing();
  
  STOnOff xgetBeforeAutospacing();
  
  boolean isSetBeforeAutospacing();
  
  void setBeforeAutospacing(STOnOff.Enum paramEnum);
  
  void xsetBeforeAutospacing(STOnOff paramSTOnOff);
  
  void unsetBeforeAutospacing();
  
  BigInteger getAfter();
  
  STTwipsMeasure xgetAfter();
  
  boolean isSetAfter();
  
  void setAfter(BigInteger paramBigInteger);
  
  void xsetAfter(STTwipsMeasure paramSTTwipsMeasure);
  
  void unsetAfter();
  
  BigInteger getAfterLines();
  
  STDecimalNumber xgetAfterLines();
  
  boolean isSetAfterLines();
  
  void setAfterLines(BigInteger paramBigInteger);
  
  void xsetAfterLines(STDecimalNumber paramSTDecimalNumber);
  
  void unsetAfterLines();
  
  STOnOff.Enum getAfterAutospacing();
  
  STOnOff xgetAfterAutospacing();
  
  boolean isSetAfterAutospacing();
  
  void setAfterAutospacing(STOnOff.Enum paramEnum);
  
  void xsetAfterAutospacing(STOnOff paramSTOnOff);
  
  void unsetAfterAutospacing();
  
  BigInteger getLine();
  
  STSignedTwipsMeasure xgetLine();
  
  boolean isSetLine();
  
  void setLine(BigInteger paramBigInteger);
  
  void xsetLine(STSignedTwipsMeasure paramSTSignedTwipsMeasure);
  
  void unsetLine();
  
  STLineSpacingRule.Enum getLineRule();
  
  STLineSpacingRule xgetLineRule();
  
  boolean isSetLineRule();
  
  void setLineRule(STLineSpacingRule.Enum paramEnum);
  
  void xsetLineRule(STLineSpacingRule paramSTLineSpacingRule);
  
  void unsetLineRule();
  
  public static final class Factory {
    public static CTSpacing newInstance() {
      return (CTSpacing)POIXMLTypeLoader.newInstance(CTSpacing.type, null);
    }
    
    public static CTSpacing newInstance(XmlOptions param1XmlOptions) {
      return (CTSpacing)POIXMLTypeLoader.newInstance(CTSpacing.type, param1XmlOptions);
    }
    
    public static CTSpacing parse(String param1String) throws XmlException {
      return (CTSpacing)POIXMLTypeLoader.parse(param1String, CTSpacing.type, null);
    }
    
    public static CTSpacing parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSpacing)POIXMLTypeLoader.parse(param1String, CTSpacing.type, param1XmlOptions);
    }
    
    public static CTSpacing parse(File param1File) throws XmlException, IOException {
      return (CTSpacing)POIXMLTypeLoader.parse(param1File, CTSpacing.type, null);
    }
    
    public static CTSpacing parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSpacing)POIXMLTypeLoader.parse(param1File, CTSpacing.type, param1XmlOptions);
    }
    
    public static CTSpacing parse(URL param1URL) throws XmlException, IOException {
      return (CTSpacing)POIXMLTypeLoader.parse(param1URL, CTSpacing.type, null);
    }
    
    public static CTSpacing parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSpacing)POIXMLTypeLoader.parse(param1URL, CTSpacing.type, param1XmlOptions);
    }
    
    public static CTSpacing parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTSpacing)POIXMLTypeLoader.parse(param1InputStream, CTSpacing.type, null);
    }
    
    public static CTSpacing parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSpacing)POIXMLTypeLoader.parse(param1InputStream, CTSpacing.type, param1XmlOptions);
    }
    
    public static CTSpacing parse(Reader param1Reader) throws XmlException, IOException {
      return (CTSpacing)POIXMLTypeLoader.parse(param1Reader, CTSpacing.type, null);
    }
    
    public static CTSpacing parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSpacing)POIXMLTypeLoader.parse(param1Reader, CTSpacing.type, param1XmlOptions);
    }
    
    public static CTSpacing parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTSpacing)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSpacing.type, null);
    }
    
    public static CTSpacing parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSpacing)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSpacing.type, param1XmlOptions);
    }
    
    public static CTSpacing parse(Node param1Node) throws XmlException {
      return (CTSpacing)POIXMLTypeLoader.parse(param1Node, CTSpacing.type, null);
    }
    
    public static CTSpacing parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSpacing)POIXMLTypeLoader.parse(param1Node, CTSpacing.type, param1XmlOptions);
    }
    
    public static CTSpacing parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTSpacing)POIXMLTypeLoader.parse(param1XMLInputStream, CTSpacing.type, null);
    }
    
    public static CTSpacing parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTSpacing)POIXMLTypeLoader.parse(param1XMLInputStream, CTSpacing.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSpacing.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSpacing.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTSpacing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */