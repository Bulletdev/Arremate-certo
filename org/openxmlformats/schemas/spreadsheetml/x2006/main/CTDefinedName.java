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

public interface CTDefinedName extends STFormula {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTDefinedName.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctdefinedname9413type");
  
  String getName();
  
  STXstring xgetName();
  
  void setName(String paramString);
  
  void xsetName(STXstring paramSTXstring);
  
  String getComment();
  
  STXstring xgetComment();
  
  boolean isSetComment();
  
  void setComment(String paramString);
  
  void xsetComment(STXstring paramSTXstring);
  
  void unsetComment();
  
  String getCustomMenu();
  
  STXstring xgetCustomMenu();
  
  boolean isSetCustomMenu();
  
  void setCustomMenu(String paramString);
  
  void xsetCustomMenu(STXstring paramSTXstring);
  
  void unsetCustomMenu();
  
  String getDescription();
  
  STXstring xgetDescription();
  
  boolean isSetDescription();
  
  void setDescription(String paramString);
  
  void xsetDescription(STXstring paramSTXstring);
  
  void unsetDescription();
  
  String getHelp();
  
  STXstring xgetHelp();
  
  boolean isSetHelp();
  
  void setHelp(String paramString);
  
  void xsetHelp(STXstring paramSTXstring);
  
  void unsetHelp();
  
  String getStatusBar();
  
  STXstring xgetStatusBar();
  
  boolean isSetStatusBar();
  
  void setStatusBar(String paramString);
  
  void xsetStatusBar(STXstring paramSTXstring);
  
  void unsetStatusBar();
  
  long getLocalSheetId();
  
  XmlUnsignedInt xgetLocalSheetId();
  
  boolean isSetLocalSheetId();
  
  void setLocalSheetId(long paramLong);
  
  void xsetLocalSheetId(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetLocalSheetId();
  
  boolean getHidden();
  
  XmlBoolean xgetHidden();
  
  boolean isSetHidden();
  
  void setHidden(boolean paramBoolean);
  
  void xsetHidden(XmlBoolean paramXmlBoolean);
  
  void unsetHidden();
  
  boolean getFunction();
  
  XmlBoolean xgetFunction();
  
  boolean isSetFunction();
  
  void setFunction(boolean paramBoolean);
  
  void xsetFunction(XmlBoolean paramXmlBoolean);
  
  void unsetFunction();
  
  boolean getVbProcedure();
  
  XmlBoolean xgetVbProcedure();
  
  boolean isSetVbProcedure();
  
  void setVbProcedure(boolean paramBoolean);
  
  void xsetVbProcedure(XmlBoolean paramXmlBoolean);
  
  void unsetVbProcedure();
  
  boolean getXlm();
  
  XmlBoolean xgetXlm();
  
  boolean isSetXlm();
  
  void setXlm(boolean paramBoolean);
  
  void xsetXlm(XmlBoolean paramXmlBoolean);
  
  void unsetXlm();
  
  long getFunctionGroupId();
  
  XmlUnsignedInt xgetFunctionGroupId();
  
  boolean isSetFunctionGroupId();
  
  void setFunctionGroupId(long paramLong);
  
  void xsetFunctionGroupId(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetFunctionGroupId();
  
  String getShortcutKey();
  
  STXstring xgetShortcutKey();
  
  boolean isSetShortcutKey();
  
  void setShortcutKey(String paramString);
  
  void xsetShortcutKey(STXstring paramSTXstring);
  
  void unsetShortcutKey();
  
  boolean getPublishToServer();
  
  XmlBoolean xgetPublishToServer();
  
  boolean isSetPublishToServer();
  
  void setPublishToServer(boolean paramBoolean);
  
  void xsetPublishToServer(XmlBoolean paramXmlBoolean);
  
  void unsetPublishToServer();
  
  boolean getWorkbookParameter();
  
  XmlBoolean xgetWorkbookParameter();
  
  boolean isSetWorkbookParameter();
  
  void setWorkbookParameter(boolean paramBoolean);
  
  void xsetWorkbookParameter(XmlBoolean paramXmlBoolean);
  
  void unsetWorkbookParameter();
  
  public static final class Factory {
    public static CTDefinedName newInstance() {
      return (CTDefinedName)POIXMLTypeLoader.newInstance(CTDefinedName.type, null);
    }
    
    public static CTDefinedName newInstance(XmlOptions param1XmlOptions) {
      return (CTDefinedName)POIXMLTypeLoader.newInstance(CTDefinedName.type, param1XmlOptions);
    }
    
    public static CTDefinedName parse(String param1String) throws XmlException {
      return (CTDefinedName)POIXMLTypeLoader.parse(param1String, CTDefinedName.type, null);
    }
    
    public static CTDefinedName parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTDefinedName)POIXMLTypeLoader.parse(param1String, CTDefinedName.type, param1XmlOptions);
    }
    
    public static CTDefinedName parse(File param1File) throws XmlException, IOException {
      return (CTDefinedName)POIXMLTypeLoader.parse(param1File, CTDefinedName.type, null);
    }
    
    public static CTDefinedName parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDefinedName)POIXMLTypeLoader.parse(param1File, CTDefinedName.type, param1XmlOptions);
    }
    
    public static CTDefinedName parse(URL param1URL) throws XmlException, IOException {
      return (CTDefinedName)POIXMLTypeLoader.parse(param1URL, CTDefinedName.type, null);
    }
    
    public static CTDefinedName parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDefinedName)POIXMLTypeLoader.parse(param1URL, CTDefinedName.type, param1XmlOptions);
    }
    
    public static CTDefinedName parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTDefinedName)POIXMLTypeLoader.parse(param1InputStream, CTDefinedName.type, null);
    }
    
    public static CTDefinedName parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDefinedName)POIXMLTypeLoader.parse(param1InputStream, CTDefinedName.type, param1XmlOptions);
    }
    
    public static CTDefinedName parse(Reader param1Reader) throws XmlException, IOException {
      return (CTDefinedName)POIXMLTypeLoader.parse(param1Reader, CTDefinedName.type, null);
    }
    
    public static CTDefinedName parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDefinedName)POIXMLTypeLoader.parse(param1Reader, CTDefinedName.type, param1XmlOptions);
    }
    
    public static CTDefinedName parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTDefinedName)POIXMLTypeLoader.parse(param1XMLStreamReader, CTDefinedName.type, null);
    }
    
    public static CTDefinedName parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTDefinedName)POIXMLTypeLoader.parse(param1XMLStreamReader, CTDefinedName.type, param1XmlOptions);
    }
    
    public static CTDefinedName parse(Node param1Node) throws XmlException {
      return (CTDefinedName)POIXMLTypeLoader.parse(param1Node, CTDefinedName.type, null);
    }
    
    public static CTDefinedName parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTDefinedName)POIXMLTypeLoader.parse(param1Node, CTDefinedName.type, param1XmlOptions);
    }
    
    public static CTDefinedName parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTDefinedName)POIXMLTypeLoader.parse(param1XMLInputStream, CTDefinedName.type, null);
    }
    
    public static CTDefinedName parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTDefinedName)POIXMLTypeLoader.parse(param1XMLInputStream, CTDefinedName.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTDefinedName.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTDefinedName.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTDefinedName.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */