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

public interface CTDataValidation extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTDataValidation.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctdatavalidation9d0ctype");
  
  String getFormula1();
  
  STFormula xgetFormula1();
  
  boolean isSetFormula1();
  
  void setFormula1(String paramString);
  
  void xsetFormula1(STFormula paramSTFormula);
  
  void unsetFormula1();
  
  String getFormula2();
  
  STFormula xgetFormula2();
  
  boolean isSetFormula2();
  
  void setFormula2(String paramString);
  
  void xsetFormula2(STFormula paramSTFormula);
  
  void unsetFormula2();
  
  STDataValidationType.Enum getType();
  
  STDataValidationType xgetType();
  
  boolean isSetType();
  
  void setType(STDataValidationType.Enum paramEnum);
  
  void xsetType(STDataValidationType paramSTDataValidationType);
  
  void unsetType();
  
  STDataValidationErrorStyle.Enum getErrorStyle();
  
  STDataValidationErrorStyle xgetErrorStyle();
  
  boolean isSetErrorStyle();
  
  void setErrorStyle(STDataValidationErrorStyle.Enum paramEnum);
  
  void xsetErrorStyle(STDataValidationErrorStyle paramSTDataValidationErrorStyle);
  
  void unsetErrorStyle();
  
  STDataValidationImeMode$Enum getImeMode();
  
  STDataValidationImeMode xgetImeMode();
  
  boolean isSetImeMode();
  
  void setImeMode(STDataValidationImeMode$Enum paramSTDataValidationImeMode$Enum);
  
  void xsetImeMode(STDataValidationImeMode paramSTDataValidationImeMode);
  
  void unsetImeMode();
  
  STDataValidationOperator.Enum getOperator();
  
  STDataValidationOperator xgetOperator();
  
  boolean isSetOperator();
  
  void setOperator(STDataValidationOperator.Enum paramEnum);
  
  void xsetOperator(STDataValidationOperator paramSTDataValidationOperator);
  
  void unsetOperator();
  
  boolean getAllowBlank();
  
  XmlBoolean xgetAllowBlank();
  
  boolean isSetAllowBlank();
  
  void setAllowBlank(boolean paramBoolean);
  
  void xsetAllowBlank(XmlBoolean paramXmlBoolean);
  
  void unsetAllowBlank();
  
  boolean getShowDropDown();
  
  XmlBoolean xgetShowDropDown();
  
  boolean isSetShowDropDown();
  
  void setShowDropDown(boolean paramBoolean);
  
  void xsetShowDropDown(XmlBoolean paramXmlBoolean);
  
  void unsetShowDropDown();
  
  boolean getShowInputMessage();
  
  XmlBoolean xgetShowInputMessage();
  
  boolean isSetShowInputMessage();
  
  void setShowInputMessage(boolean paramBoolean);
  
  void xsetShowInputMessage(XmlBoolean paramXmlBoolean);
  
  void unsetShowInputMessage();
  
  boolean getShowErrorMessage();
  
  XmlBoolean xgetShowErrorMessage();
  
  boolean isSetShowErrorMessage();
  
  void setShowErrorMessage(boolean paramBoolean);
  
  void xsetShowErrorMessage(XmlBoolean paramXmlBoolean);
  
  void unsetShowErrorMessage();
  
  String getErrorTitle();
  
  STXstring xgetErrorTitle();
  
  boolean isSetErrorTitle();
  
  void setErrorTitle(String paramString);
  
  void xsetErrorTitle(STXstring paramSTXstring);
  
  void unsetErrorTitle();
  
  String getError();
  
  STXstring xgetError();
  
  boolean isSetError();
  
  void setError(String paramString);
  
  void xsetError(STXstring paramSTXstring);
  
  void unsetError();
  
  String getPromptTitle();
  
  STXstring xgetPromptTitle();
  
  boolean isSetPromptTitle();
  
  void setPromptTitle(String paramString);
  
  void xsetPromptTitle(STXstring paramSTXstring);
  
  void unsetPromptTitle();
  
  String getPrompt();
  
  STXstring xgetPrompt();
  
  boolean isSetPrompt();
  
  void setPrompt(String paramString);
  
  void xsetPrompt(STXstring paramSTXstring);
  
  void unsetPrompt();
  
  List getSqref();
  
  STSqref xgetSqref();
  
  void setSqref(List paramList);
  
  void xsetSqref(STSqref paramSTSqref);
  
  public static final class Factory {
    public static CTDataValidation newInstance() {
      return (CTDataValidation)POIXMLTypeLoader.newInstance(CTDataValidation.type, null);
    }
    
    public static CTDataValidation newInstance(XmlOptions param1XmlOptions) {
      return (CTDataValidation)POIXMLTypeLoader.newInstance(CTDataValidation.type, param1XmlOptions);
    }
    
    public static CTDataValidation parse(String param1String) throws XmlException {
      return (CTDataValidation)POIXMLTypeLoader.parse(param1String, CTDataValidation.type, null);
    }
    
    public static CTDataValidation parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTDataValidation)POIXMLTypeLoader.parse(param1String, CTDataValidation.type, param1XmlOptions);
    }
    
    public static CTDataValidation parse(File param1File) throws XmlException, IOException {
      return (CTDataValidation)POIXMLTypeLoader.parse(param1File, CTDataValidation.type, null);
    }
    
    public static CTDataValidation parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDataValidation)POIXMLTypeLoader.parse(param1File, CTDataValidation.type, param1XmlOptions);
    }
    
    public static CTDataValidation parse(URL param1URL) throws XmlException, IOException {
      return (CTDataValidation)POIXMLTypeLoader.parse(param1URL, CTDataValidation.type, null);
    }
    
    public static CTDataValidation parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDataValidation)POIXMLTypeLoader.parse(param1URL, CTDataValidation.type, param1XmlOptions);
    }
    
    public static CTDataValidation parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTDataValidation)POIXMLTypeLoader.parse(param1InputStream, CTDataValidation.type, null);
    }
    
    public static CTDataValidation parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDataValidation)POIXMLTypeLoader.parse(param1InputStream, CTDataValidation.type, param1XmlOptions);
    }
    
    public static CTDataValidation parse(Reader param1Reader) throws XmlException, IOException {
      return (CTDataValidation)POIXMLTypeLoader.parse(param1Reader, CTDataValidation.type, null);
    }
    
    public static CTDataValidation parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDataValidation)POIXMLTypeLoader.parse(param1Reader, CTDataValidation.type, param1XmlOptions);
    }
    
    public static CTDataValidation parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTDataValidation)POIXMLTypeLoader.parse(param1XMLStreamReader, CTDataValidation.type, null);
    }
    
    public static CTDataValidation parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTDataValidation)POIXMLTypeLoader.parse(param1XMLStreamReader, CTDataValidation.type, param1XmlOptions);
    }
    
    public static CTDataValidation parse(Node param1Node) throws XmlException {
      return (CTDataValidation)POIXMLTypeLoader.parse(param1Node, CTDataValidation.type, null);
    }
    
    public static CTDataValidation parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTDataValidation)POIXMLTypeLoader.parse(param1Node, CTDataValidation.type, param1XmlOptions);
    }
    
    public static CTDataValidation parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTDataValidation)POIXMLTypeLoader.parse(param1XMLInputStream, CTDataValidation.type, null);
    }
    
    public static CTDataValidation parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTDataValidation)POIXMLTypeLoader.parse(param1XMLInputStream, CTDataValidation.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTDataValidation.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTDataValidation.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTDataValidation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */