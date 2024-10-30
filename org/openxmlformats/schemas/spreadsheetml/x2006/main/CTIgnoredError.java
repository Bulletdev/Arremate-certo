package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
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

public interface CTIgnoredError extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTIgnoredError.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctignorederrorc51ftype");
  
  List getSqref();
  
  STSqref xgetSqref();
  
  void setSqref(List paramList);
  
  void xsetSqref(STSqref paramSTSqref);
  
  boolean getEvalError();
  
  XmlBoolean xgetEvalError();
  
  boolean isSetEvalError();
  
  void setEvalError(boolean paramBoolean);
  
  void xsetEvalError(XmlBoolean paramXmlBoolean);
  
  void unsetEvalError();
  
  boolean getTwoDigitTextYear();
  
  XmlBoolean xgetTwoDigitTextYear();
  
  boolean isSetTwoDigitTextYear();
  
  void setTwoDigitTextYear(boolean paramBoolean);
  
  void xsetTwoDigitTextYear(XmlBoolean paramXmlBoolean);
  
  void unsetTwoDigitTextYear();
  
  boolean getNumberStoredAsText();
  
  XmlBoolean xgetNumberStoredAsText();
  
  boolean isSetNumberStoredAsText();
  
  void setNumberStoredAsText(boolean paramBoolean);
  
  void xsetNumberStoredAsText(XmlBoolean paramXmlBoolean);
  
  void unsetNumberStoredAsText();
  
  boolean getFormula();
  
  XmlBoolean xgetFormula();
  
  boolean isSetFormula();
  
  void setFormula(boolean paramBoolean);
  
  void xsetFormula(XmlBoolean paramXmlBoolean);
  
  void unsetFormula();
  
  boolean getFormulaRange();
  
  XmlBoolean xgetFormulaRange();
  
  boolean isSetFormulaRange();
  
  void setFormulaRange(boolean paramBoolean);
  
  void xsetFormulaRange(XmlBoolean paramXmlBoolean);
  
  void unsetFormulaRange();
  
  boolean getUnlockedFormula();
  
  XmlBoolean xgetUnlockedFormula();
  
  boolean isSetUnlockedFormula();
  
  void setUnlockedFormula(boolean paramBoolean);
  
  void xsetUnlockedFormula(XmlBoolean paramXmlBoolean);
  
  void unsetUnlockedFormula();
  
  boolean getEmptyCellReference();
  
  XmlBoolean xgetEmptyCellReference();
  
  boolean isSetEmptyCellReference();
  
  void setEmptyCellReference(boolean paramBoolean);
  
  void xsetEmptyCellReference(XmlBoolean paramXmlBoolean);
  
  void unsetEmptyCellReference();
  
  boolean getListDataValidation();
  
  XmlBoolean xgetListDataValidation();
  
  boolean isSetListDataValidation();
  
  void setListDataValidation(boolean paramBoolean);
  
  void xsetListDataValidation(XmlBoolean paramXmlBoolean);
  
  void unsetListDataValidation();
  
  boolean getCalculatedColumn();
  
  XmlBoolean xgetCalculatedColumn();
  
  boolean isSetCalculatedColumn();
  
  void setCalculatedColumn(boolean paramBoolean);
  
  void xsetCalculatedColumn(XmlBoolean paramXmlBoolean);
  
  void unsetCalculatedColumn();
  
  public static final class Factory {
    public static CTIgnoredError newInstance() {
      return (CTIgnoredError)POIXMLTypeLoader.newInstance(CTIgnoredError.type, null);
    }
    
    public static CTIgnoredError newInstance(XmlOptions param1XmlOptions) {
      return (CTIgnoredError)POIXMLTypeLoader.newInstance(CTIgnoredError.type, param1XmlOptions);
    }
    
    public static CTIgnoredError parse(String param1String) throws XmlException {
      return (CTIgnoredError)POIXMLTypeLoader.parse(param1String, CTIgnoredError.type, null);
    }
    
    public static CTIgnoredError parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTIgnoredError)POIXMLTypeLoader.parse(param1String, CTIgnoredError.type, param1XmlOptions);
    }
    
    public static CTIgnoredError parse(File param1File) throws XmlException, IOException {
      return (CTIgnoredError)POIXMLTypeLoader.parse(param1File, CTIgnoredError.type, null);
    }
    
    public static CTIgnoredError parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTIgnoredError)POIXMLTypeLoader.parse(param1File, CTIgnoredError.type, param1XmlOptions);
    }
    
    public static CTIgnoredError parse(URL param1URL) throws XmlException, IOException {
      return (CTIgnoredError)POIXMLTypeLoader.parse(param1URL, CTIgnoredError.type, null);
    }
    
    public static CTIgnoredError parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTIgnoredError)POIXMLTypeLoader.parse(param1URL, CTIgnoredError.type, param1XmlOptions);
    }
    
    public static CTIgnoredError parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTIgnoredError)POIXMLTypeLoader.parse(param1InputStream, CTIgnoredError.type, null);
    }
    
    public static CTIgnoredError parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTIgnoredError)POIXMLTypeLoader.parse(param1InputStream, CTIgnoredError.type, param1XmlOptions);
    }
    
    public static CTIgnoredError parse(Reader param1Reader) throws XmlException, IOException {
      return (CTIgnoredError)POIXMLTypeLoader.parse(param1Reader, CTIgnoredError.type, null);
    }
    
    public static CTIgnoredError parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTIgnoredError)POIXMLTypeLoader.parse(param1Reader, CTIgnoredError.type, param1XmlOptions);
    }
    
    public static CTIgnoredError parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTIgnoredError)POIXMLTypeLoader.parse(param1XMLStreamReader, CTIgnoredError.type, null);
    }
    
    public static CTIgnoredError parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTIgnoredError)POIXMLTypeLoader.parse(param1XMLStreamReader, CTIgnoredError.type, param1XmlOptions);
    }
    
    public static CTIgnoredError parse(Node param1Node) throws XmlException {
      return (CTIgnoredError)POIXMLTypeLoader.parse(param1Node, CTIgnoredError.type, null);
    }
    
    public static CTIgnoredError parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTIgnoredError)POIXMLTypeLoader.parse(param1Node, CTIgnoredError.type, param1XmlOptions);
    }
    
    public static CTIgnoredError parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTIgnoredError)POIXMLTypeLoader.parse(param1XMLInputStream, CTIgnoredError.type, null);
    }
    
    public static CTIgnoredError parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTIgnoredError)POIXMLTypeLoader.parse(param1XMLInputStream, CTIgnoredError.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTIgnoredError.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTIgnoredError.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTIgnoredError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */