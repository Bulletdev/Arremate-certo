/*     */ package org.apache.xmlbeans.impl.xb.xsdschema;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.net.URL;
/*     */ import javax.xml.stream.XMLStreamReader;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.StringEnumAbstractBase;
/*     */ import org.apache.xmlbeans.XmlBeans;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.apache.xmlbeans.xml.stream.XMLInputStream;
/*     */ import org.apache.xmlbeans.xml.stream.XMLStreamException;
/*     */ import org.w3c.dom.Node;
/*     */ 
/*     */ public interface WhiteSpaceDocument extends XmlObject {
/*  19 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$WhiteSpaceDocument == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$WhiteSpaceDocument = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.WhiteSpaceDocument")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$WhiteSpaceDocument).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("whitespaced2c6doctype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   WhiteSpace getWhiteSpace();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setWhiteSpace(WhiteSpace paramWhiteSpace);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   WhiteSpace addNewWhiteSpace();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface WhiteSpace
/*     */     extends Facet
/*     */   {
/*  44 */     public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((WhiteSpaceDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$WhiteSpaceDocument$WhiteSpace == null) ? (WhiteSpaceDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$WhiteSpaceDocument$WhiteSpace = WhiteSpaceDocument.null.class$("org.apache.xmlbeans.impl.xb.xsdschema.WhiteSpaceDocument$WhiteSpace")) : WhiteSpaceDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$WhiteSpaceDocument$WhiteSpace).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("whitespace97ffelemtype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static interface Value
/*     */       extends XmlNMTOKEN
/*     */     {
/*  54 */       public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((WhiteSpaceDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$WhiteSpaceDocument$WhiteSpace$Value == null) ? (WhiteSpaceDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$WhiteSpaceDocument$WhiteSpace$Value = WhiteSpaceDocument.null.class$("org.apache.xmlbeans.impl.xb.xsdschema.WhiteSpaceDocument$WhiteSpace$Value")) : WhiteSpaceDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$WhiteSpaceDocument$WhiteSpace$Value).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("value8186attrtype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  60 */       public static final Enum PRESERVE = Enum.forString("preserve");
/*  61 */       public static final Enum REPLACE = Enum.forString("replace");
/*  62 */       public static final Enum COLLAPSE = Enum.forString("collapse");
/*     */ 
/*     */       
/*     */       public static final int INT_PRESERVE = 1;
/*     */       
/*     */       public static final int INT_REPLACE = 2;
/*     */       
/*     */       public static final int INT_COLLAPSE = 3;
/*     */ 
/*     */       
/*     */       StringEnumAbstractBase enumValue();
/*     */ 
/*     */       
/*     */       void set(StringEnumAbstractBase param2StringEnumAbstractBase);
/*     */ 
/*     */       
/*     */       public static final class Enum
/*     */         extends StringEnumAbstractBase
/*     */       {
/*     */         static final int INT_PRESERVE = 1;
/*     */         
/*     */         static final int INT_REPLACE = 2;
/*     */         
/*     */         static final int INT_COLLAPSE = 3;
/*     */ 
/*     */         
/*     */         public static Enum forString(String param3String) {
/*  89 */           return (Enum)table.forString(param3String);
/*     */         }
/*     */ 
/*     */         
/*     */         public static Enum forInt(int param3Int) {
/*  94 */           return (Enum)table.forInt(param3Int);
/*     */         }
/*     */         private Enum(String param3String, int param3Int) {
/*  97 */           super(param3String, param3Int);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 103 */         public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("preserve", 1), new Enum("replace", 2), new Enum("collapse", 3) });
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         private static final long serialVersionUID = 1L;
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         private Object readResolve() {
/* 114 */           return forInt(intValue());
/*     */         }
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public static final class Factory
/*     */       {
/*     */         public static WhiteSpaceDocument.WhiteSpace.Value newValue(Object param3Object) {
/* 125 */           return (WhiteSpaceDocument.WhiteSpace.Value)WhiteSpaceDocument.WhiteSpace.Value.type.newValue(param3Object);
/*     */         }
/*     */         public static WhiteSpaceDocument.WhiteSpace.Value newInstance() {
/* 128 */           return (WhiteSpaceDocument.WhiteSpace.Value)XmlBeans.getContextTypeLoader().newInstance(WhiteSpaceDocument.WhiteSpace.Value.type, null);
/*     */         }
/*     */         public static WhiteSpaceDocument.WhiteSpace.Value newInstance(XmlOptions param3XmlOptions) {
/* 131 */           return (WhiteSpaceDocument.WhiteSpace.Value)XmlBeans.getContextTypeLoader().newInstance(WhiteSpaceDocument.WhiteSpace.Value.type, param3XmlOptions);
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static final class Factory
/*     */     {
/*     */       public static WhiteSpaceDocument.WhiteSpace newInstance() {
/* 145 */         return (WhiteSpaceDocument.WhiteSpace)XmlBeans.getContextTypeLoader().newInstance(WhiteSpaceDocument.WhiteSpace.type, null);
/*     */       }
/*     */       public static WhiteSpaceDocument.WhiteSpace newInstance(XmlOptions param2XmlOptions) {
/* 148 */         return (WhiteSpaceDocument.WhiteSpace)XmlBeans.getContextTypeLoader().newInstance(WhiteSpaceDocument.WhiteSpace.type, param2XmlOptions);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static WhiteSpaceDocument newInstance() {
/* 162 */       return (WhiteSpaceDocument)XmlBeans.getContextTypeLoader().newInstance(WhiteSpaceDocument.type, null);
/*     */     }
/*     */     public static WhiteSpaceDocument newInstance(XmlOptions param1XmlOptions) {
/* 165 */       return (WhiteSpaceDocument)XmlBeans.getContextTypeLoader().newInstance(WhiteSpaceDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static WhiteSpaceDocument parse(String param1String) throws XmlException {
/* 169 */       return (WhiteSpaceDocument)XmlBeans.getContextTypeLoader().parse(param1String, WhiteSpaceDocument.type, null);
/*     */     }
/*     */     public static WhiteSpaceDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/* 172 */       return (WhiteSpaceDocument)XmlBeans.getContextTypeLoader().parse(param1String, WhiteSpaceDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static WhiteSpaceDocument parse(File param1File) throws XmlException, IOException {
/* 176 */       return (WhiteSpaceDocument)XmlBeans.getContextTypeLoader().parse(param1File, WhiteSpaceDocument.type, null);
/*     */     }
/*     */     public static WhiteSpaceDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 179 */       return (WhiteSpaceDocument)XmlBeans.getContextTypeLoader().parse(param1File, WhiteSpaceDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static WhiteSpaceDocument parse(URL param1URL) throws XmlException, IOException {
/* 182 */       return (WhiteSpaceDocument)XmlBeans.getContextTypeLoader().parse(param1URL, WhiteSpaceDocument.type, null);
/*     */     }
/*     */     public static WhiteSpaceDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 185 */       return (WhiteSpaceDocument)XmlBeans.getContextTypeLoader().parse(param1URL, WhiteSpaceDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static WhiteSpaceDocument parse(InputStream param1InputStream) throws XmlException, IOException {
/* 188 */       return (WhiteSpaceDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, WhiteSpaceDocument.type, null);
/*     */     }
/*     */     public static WhiteSpaceDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 191 */       return (WhiteSpaceDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, WhiteSpaceDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static WhiteSpaceDocument parse(Reader param1Reader) throws XmlException, IOException {
/* 194 */       return (WhiteSpaceDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, WhiteSpaceDocument.type, null);
/*     */     }
/*     */     public static WhiteSpaceDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 197 */       return (WhiteSpaceDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, WhiteSpaceDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static WhiteSpaceDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 200 */       return (WhiteSpaceDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, WhiteSpaceDocument.type, null);
/*     */     }
/*     */     public static WhiteSpaceDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 203 */       return (WhiteSpaceDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, WhiteSpaceDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static WhiteSpaceDocument parse(Node param1Node) throws XmlException {
/* 206 */       return (WhiteSpaceDocument)XmlBeans.getContextTypeLoader().parse(param1Node, WhiteSpaceDocument.type, null);
/*     */     }
/*     */     public static WhiteSpaceDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 209 */       return (WhiteSpaceDocument)XmlBeans.getContextTypeLoader().parse(param1Node, WhiteSpaceDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static WhiteSpaceDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 213 */       return (WhiteSpaceDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, WhiteSpaceDocument.type, null);
/*     */     }
/*     */     
/*     */     public static WhiteSpaceDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 217 */       return (WhiteSpaceDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, WhiteSpaceDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 221 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, WhiteSpaceDocument.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 225 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, WhiteSpaceDocument.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\WhiteSpaceDocument.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */