package org.openxmlformats.schemas.presentationml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface STPlaceholderType extends XmlToken {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STPlaceholderType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stplaceholdertypeca72type");
  
  public static final Enum TITLE = Enum.forString("title");
  
  public static final Enum BODY = Enum.forString("body");
  
  public static final Enum CTR_TITLE = Enum.forString("ctrTitle");
  
  public static final Enum SUB_TITLE = Enum.forString("subTitle");
  
  public static final Enum DT = Enum.forString("dt");
  
  public static final Enum SLD_NUM = Enum.forString("sldNum");
  
  public static final Enum FTR = Enum.forString("ftr");
  
  public static final Enum HDR = Enum.forString("hdr");
  
  public static final Enum OBJ = Enum.forString("obj");
  
  public static final Enum CHART = Enum.forString("chart");
  
  public static final Enum TBL = Enum.forString("tbl");
  
  public static final Enum CLIP_ART = Enum.forString("clipArt");
  
  public static final Enum DGM = Enum.forString("dgm");
  
  public static final Enum MEDIA = Enum.forString("media");
  
  public static final Enum SLD_IMG = Enum.forString("sldImg");
  
  public static final Enum PIC = Enum.forString("pic");
  
  public static final int INT_TITLE = 1;
  
  public static final int INT_BODY = 2;
  
  public static final int INT_CTR_TITLE = 3;
  
  public static final int INT_SUB_TITLE = 4;
  
  public static final int INT_DT = 5;
  
  public static final int INT_SLD_NUM = 6;
  
  public static final int INT_FTR = 7;
  
  public static final int INT_HDR = 8;
  
  public static final int INT_OBJ = 9;
  
  public static final int INT_CHART = 10;
  
  public static final int INT_TBL = 11;
  
  public static final int INT_CLIP_ART = 12;
  
  public static final int INT_DGM = 13;
  
  public static final int INT_MEDIA = 14;
  
  public static final int INT_SLD_IMG = 15;
  
  public static final int INT_PIC = 16;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STPlaceholderType newValue(Object param1Object) {
      return (STPlaceholderType)STPlaceholderType.type.newValue(param1Object);
    }
    
    public static STPlaceholderType newInstance() {
      return (STPlaceholderType)POIXMLTypeLoader.newInstance(STPlaceholderType.type, null);
    }
    
    public static STPlaceholderType newInstance(XmlOptions param1XmlOptions) {
      return (STPlaceholderType)POIXMLTypeLoader.newInstance(STPlaceholderType.type, param1XmlOptions);
    }
    
    public static STPlaceholderType parse(String param1String) throws XmlException {
      return (STPlaceholderType)POIXMLTypeLoader.parse(param1String, STPlaceholderType.type, null);
    }
    
    public static STPlaceholderType parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STPlaceholderType)POIXMLTypeLoader.parse(param1String, STPlaceholderType.type, param1XmlOptions);
    }
    
    public static STPlaceholderType parse(File param1File) throws XmlException, IOException {
      return (STPlaceholderType)POIXMLTypeLoader.parse(param1File, STPlaceholderType.type, null);
    }
    
    public static STPlaceholderType parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STPlaceholderType)POIXMLTypeLoader.parse(param1File, STPlaceholderType.type, param1XmlOptions);
    }
    
    public static STPlaceholderType parse(URL param1URL) throws XmlException, IOException {
      return (STPlaceholderType)POIXMLTypeLoader.parse(param1URL, STPlaceholderType.type, null);
    }
    
    public static STPlaceholderType parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STPlaceholderType)POIXMLTypeLoader.parse(param1URL, STPlaceholderType.type, param1XmlOptions);
    }
    
    public static STPlaceholderType parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STPlaceholderType)POIXMLTypeLoader.parse(param1InputStream, STPlaceholderType.type, null);
    }
    
    public static STPlaceholderType parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STPlaceholderType)POIXMLTypeLoader.parse(param1InputStream, STPlaceholderType.type, param1XmlOptions);
    }
    
    public static STPlaceholderType parse(Reader param1Reader) throws XmlException, IOException {
      return (STPlaceholderType)POIXMLTypeLoader.parse(param1Reader, STPlaceholderType.type, null);
    }
    
    public static STPlaceholderType parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STPlaceholderType)POIXMLTypeLoader.parse(param1Reader, STPlaceholderType.type, param1XmlOptions);
    }
    
    public static STPlaceholderType parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STPlaceholderType)POIXMLTypeLoader.parse(param1XMLStreamReader, STPlaceholderType.type, null);
    }
    
    public static STPlaceholderType parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STPlaceholderType)POIXMLTypeLoader.parse(param1XMLStreamReader, STPlaceholderType.type, param1XmlOptions);
    }
    
    public static STPlaceholderType parse(Node param1Node) throws XmlException {
      return (STPlaceholderType)POIXMLTypeLoader.parse(param1Node, STPlaceholderType.type, null);
    }
    
    public static STPlaceholderType parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STPlaceholderType)POIXMLTypeLoader.parse(param1Node, STPlaceholderType.type, param1XmlOptions);
    }
    
    public static STPlaceholderType parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STPlaceholderType)POIXMLTypeLoader.parse(param1XMLInputStream, STPlaceholderType.type, null);
    }
    
    public static STPlaceholderType parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STPlaceholderType)POIXMLTypeLoader.parse(param1XMLInputStream, STPlaceholderType.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STPlaceholderType.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STPlaceholderType.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_TITLE = 1;
    
    static final int INT_BODY = 2;
    
    static final int INT_CTR_TITLE = 3;
    
    static final int INT_SUB_TITLE = 4;
    
    static final int INT_DT = 5;
    
    static final int INT_SLD_NUM = 6;
    
    static final int INT_FTR = 7;
    
    static final int INT_HDR = 8;
    
    static final int INT_OBJ = 9;
    
    static final int INT_CHART = 10;
    
    static final int INT_TBL = 11;
    
    static final int INT_CLIP_ART = 12;
    
    static final int INT_DGM = 13;
    
    static final int INT_MEDIA = 14;
    
    static final int INT_SLD_IMG = 15;
    
    static final int INT_PIC = 16;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { 
          new Enum("title", 1), new Enum("body", 2), new Enum("ctrTitle", 3), new Enum("subTitle", 4), new Enum("dt", 5), new Enum("sldNum", 6), new Enum("ftr", 7), new Enum("hdr", 8), new Enum("obj", 9), new Enum("chart", 10), 
          new Enum("tbl", 11), new Enum("clipArt", 12), new Enum("dgm", 13), new Enum("media", 14), new Enum("sldImg", 15), new Enum("pic", 16) });
    
    private static final long serialVersionUID = 1L;
    
    public static Enum forString(String param1String) {
      return (Enum)table.forString(param1String);
    }
    
    public static Enum forInt(int param1Int) {
      return (Enum)table.forInt(param1Int);
    }
    
    private Enum(String param1String, int param1Int) {
      super(param1String, param1Int);
    }
    
    private Object readResolve() {
      return forInt(intValue());
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\STPlaceholderType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */