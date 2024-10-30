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
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTCellFormula extends STFormula {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTCellFormula.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctcellformula3583type");
  
  STCellFormulaType.Enum getT();
  
  STCellFormulaType xgetT();
  
  boolean isSetT();
  
  void setT(STCellFormulaType.Enum paramEnum);
  
  void xsetT(STCellFormulaType paramSTCellFormulaType);
  
  void unsetT();
  
  boolean getAca();
  
  XmlBoolean xgetAca();
  
  boolean isSetAca();
  
  void setAca(boolean paramBoolean);
  
  void xsetAca(XmlBoolean paramXmlBoolean);
  
  void unsetAca();
  
  String getRef();
  
  STRef xgetRef();
  
  boolean isSetRef();
  
  void setRef(String paramString);
  
  void xsetRef(STRef paramSTRef);
  
  void unsetRef();
  
  boolean getDt2D();
  
  XmlBoolean xgetDt2D();
  
  boolean isSetDt2D();
  
  void setDt2D(boolean paramBoolean);
  
  void xsetDt2D(XmlBoolean paramXmlBoolean);
  
  void unsetDt2D();
  
  boolean getDtr();
  
  XmlBoolean xgetDtr();
  
  boolean isSetDtr();
  
  void setDtr(boolean paramBoolean);
  
  void xsetDtr(XmlBoolean paramXmlBoolean);
  
  void unsetDtr();
  
  boolean getDel1();
  
  XmlBoolean xgetDel1();
  
  boolean isSetDel1();
  
  void setDel1(boolean paramBoolean);
  
  void xsetDel1(XmlBoolean paramXmlBoolean);
  
  void unsetDel1();
  
  boolean getDel2();
  
  XmlBoolean xgetDel2();
  
  boolean isSetDel2();
  
  void setDel2(boolean paramBoolean);
  
  void xsetDel2(XmlBoolean paramXmlBoolean);
  
  void unsetDel2();
  
  String getR1();
  
  STCellRef xgetR1();
  
  boolean isSetR1();
  
  void setR1(String paramString);
  
  void xsetR1(STCellRef paramSTCellRef);
  
  void unsetR1();
  
  String getR2();
  
  STCellRef xgetR2();
  
  boolean isSetR2();
  
  void setR2(String paramString);
  
  void xsetR2(STCellRef paramSTCellRef);
  
  void unsetR2();
  
  boolean getCa();
  
  XmlBoolean xgetCa();
  
  boolean isSetCa();
  
  void setCa(boolean paramBoolean);
  
  void xsetCa(XmlBoolean paramXmlBoolean);
  
  void unsetCa();
  
  long getSi();
  
  XmlUnsignedInt xgetSi();
  
  boolean isSetSi();
  
  void setSi(long paramLong);
  
  void xsetSi(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetSi();
  
  boolean getBx();
  
  XmlBoolean xgetBx();
  
  boolean isSetBx();
  
  void setBx(boolean paramBoolean);
  
  void xsetBx(XmlBoolean paramXmlBoolean);
  
  void unsetBx();
  
  public static final class Factory {
    public static CTCellFormula newInstance() {
      return (CTCellFormula)POIXMLTypeLoader.newInstance(CTCellFormula.type, null);
    }
    
    public static CTCellFormula newInstance(XmlOptions param1XmlOptions) {
      return (CTCellFormula)POIXMLTypeLoader.newInstance(CTCellFormula.type, param1XmlOptions);
    }
    
    public static CTCellFormula parse(String param1String) throws XmlException {
      return (CTCellFormula)POIXMLTypeLoader.parse(param1String, CTCellFormula.type, null);
    }
    
    public static CTCellFormula parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCellFormula)POIXMLTypeLoader.parse(param1String, CTCellFormula.type, param1XmlOptions);
    }
    
    public static CTCellFormula parse(File param1File) throws XmlException, IOException {
      return (CTCellFormula)POIXMLTypeLoader.parse(param1File, CTCellFormula.type, null);
    }
    
    public static CTCellFormula parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCellFormula)POIXMLTypeLoader.parse(param1File, CTCellFormula.type, param1XmlOptions);
    }
    
    public static CTCellFormula parse(URL param1URL) throws XmlException, IOException {
      return (CTCellFormula)POIXMLTypeLoader.parse(param1URL, CTCellFormula.type, null);
    }
    
    public static CTCellFormula parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCellFormula)POIXMLTypeLoader.parse(param1URL, CTCellFormula.type, param1XmlOptions);
    }
    
    public static CTCellFormula parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTCellFormula)POIXMLTypeLoader.parse(param1InputStream, CTCellFormula.type, null);
    }
    
    public static CTCellFormula parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCellFormula)POIXMLTypeLoader.parse(param1InputStream, CTCellFormula.type, param1XmlOptions);
    }
    
    public static CTCellFormula parse(Reader param1Reader) throws XmlException, IOException {
      return (CTCellFormula)POIXMLTypeLoader.parse(param1Reader, CTCellFormula.type, null);
    }
    
    public static CTCellFormula parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCellFormula)POIXMLTypeLoader.parse(param1Reader, CTCellFormula.type, param1XmlOptions);
    }
    
    public static CTCellFormula parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTCellFormula)POIXMLTypeLoader.parse(param1XMLStreamReader, CTCellFormula.type, null);
    }
    
    public static CTCellFormula parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCellFormula)POIXMLTypeLoader.parse(param1XMLStreamReader, CTCellFormula.type, param1XmlOptions);
    }
    
    public static CTCellFormula parse(Node param1Node) throws XmlException {
      return (CTCellFormula)POIXMLTypeLoader.parse(param1Node, CTCellFormula.type, null);
    }
    
    public static CTCellFormula parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCellFormula)POIXMLTypeLoader.parse(param1Node, CTCellFormula.type, param1XmlOptions);
    }
    
    public static CTCellFormula parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTCellFormula)POIXMLTypeLoader.parse(param1XMLInputStream, CTCellFormula.type, null);
    }
    
    public static CTCellFormula parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTCellFormula)POIXMLTypeLoader.parse(param1XMLInputStream, CTCellFormula.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTCellFormula.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTCellFormula.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTCellFormula.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */