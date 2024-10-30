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

public interface CTInd extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTInd.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctind4b93type");
  
  BigInteger getLeft();
  
  STSignedTwipsMeasure xgetLeft();
  
  boolean isSetLeft();
  
  void setLeft(BigInteger paramBigInteger);
  
  void xsetLeft(STSignedTwipsMeasure paramSTSignedTwipsMeasure);
  
  void unsetLeft();
  
  BigInteger getLeftChars();
  
  STDecimalNumber xgetLeftChars();
  
  boolean isSetLeftChars();
  
  void setLeftChars(BigInteger paramBigInteger);
  
  void xsetLeftChars(STDecimalNumber paramSTDecimalNumber);
  
  void unsetLeftChars();
  
  BigInteger getRight();
  
  STSignedTwipsMeasure xgetRight();
  
  boolean isSetRight();
  
  void setRight(BigInteger paramBigInteger);
  
  void xsetRight(STSignedTwipsMeasure paramSTSignedTwipsMeasure);
  
  void unsetRight();
  
  BigInteger getRightChars();
  
  STDecimalNumber xgetRightChars();
  
  boolean isSetRightChars();
  
  void setRightChars(BigInteger paramBigInteger);
  
  void xsetRightChars(STDecimalNumber paramSTDecimalNumber);
  
  void unsetRightChars();
  
  BigInteger getHanging();
  
  STTwipsMeasure xgetHanging();
  
  boolean isSetHanging();
  
  void setHanging(BigInteger paramBigInteger);
  
  void xsetHanging(STTwipsMeasure paramSTTwipsMeasure);
  
  void unsetHanging();
  
  BigInteger getHangingChars();
  
  STDecimalNumber xgetHangingChars();
  
  boolean isSetHangingChars();
  
  void setHangingChars(BigInteger paramBigInteger);
  
  void xsetHangingChars(STDecimalNumber paramSTDecimalNumber);
  
  void unsetHangingChars();
  
  BigInteger getFirstLine();
  
  STTwipsMeasure xgetFirstLine();
  
  boolean isSetFirstLine();
  
  void setFirstLine(BigInteger paramBigInteger);
  
  void xsetFirstLine(STTwipsMeasure paramSTTwipsMeasure);
  
  void unsetFirstLine();
  
  BigInteger getFirstLineChars();
  
  STDecimalNumber xgetFirstLineChars();
  
  boolean isSetFirstLineChars();
  
  void setFirstLineChars(BigInteger paramBigInteger);
  
  void xsetFirstLineChars(STDecimalNumber paramSTDecimalNumber);
  
  void unsetFirstLineChars();
  
  public static final class Factory {
    public static CTInd newInstance() {
      return (CTInd)POIXMLTypeLoader.newInstance(CTInd.type, null);
    }
    
    public static CTInd newInstance(XmlOptions param1XmlOptions) {
      return (CTInd)POIXMLTypeLoader.newInstance(CTInd.type, param1XmlOptions);
    }
    
    public static CTInd parse(String param1String) throws XmlException {
      return (CTInd)POIXMLTypeLoader.parse(param1String, CTInd.type, null);
    }
    
    public static CTInd parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTInd)POIXMLTypeLoader.parse(param1String, CTInd.type, param1XmlOptions);
    }
    
    public static CTInd parse(File param1File) throws XmlException, IOException {
      return (CTInd)POIXMLTypeLoader.parse(param1File, CTInd.type, null);
    }
    
    public static CTInd parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTInd)POIXMLTypeLoader.parse(param1File, CTInd.type, param1XmlOptions);
    }
    
    public static CTInd parse(URL param1URL) throws XmlException, IOException {
      return (CTInd)POIXMLTypeLoader.parse(param1URL, CTInd.type, null);
    }
    
    public static CTInd parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTInd)POIXMLTypeLoader.parse(param1URL, CTInd.type, param1XmlOptions);
    }
    
    public static CTInd parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTInd)POIXMLTypeLoader.parse(param1InputStream, CTInd.type, null);
    }
    
    public static CTInd parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTInd)POIXMLTypeLoader.parse(param1InputStream, CTInd.type, param1XmlOptions);
    }
    
    public static CTInd parse(Reader param1Reader) throws XmlException, IOException {
      return (CTInd)POIXMLTypeLoader.parse(param1Reader, CTInd.type, null);
    }
    
    public static CTInd parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTInd)POIXMLTypeLoader.parse(param1Reader, CTInd.type, param1XmlOptions);
    }
    
    public static CTInd parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTInd)POIXMLTypeLoader.parse(param1XMLStreamReader, CTInd.type, null);
    }
    
    public static CTInd parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTInd)POIXMLTypeLoader.parse(param1XMLStreamReader, CTInd.type, param1XmlOptions);
    }
    
    public static CTInd parse(Node param1Node) throws XmlException {
      return (CTInd)POIXMLTypeLoader.parse(param1Node, CTInd.type, null);
    }
    
    public static CTInd parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTInd)POIXMLTypeLoader.parse(param1Node, CTInd.type, param1XmlOptions);
    }
    
    public static CTInd parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTInd)POIXMLTypeLoader.parse(param1XMLInputStream, CTInd.type, null);
    }
    
    public static CTInd parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTInd)POIXMLTypeLoader.parse(param1XMLInputStream, CTInd.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTInd.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTInd.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTInd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */