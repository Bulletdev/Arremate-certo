/*     */ package org.apache.xmlbeans.impl.xb.xsdschema;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.net.URL;
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.StringEnumAbstractBase;
/*     */ import org.apache.xmlbeans.XmlBeans;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.apache.xmlbeans.XmlQName;
/*     */ import org.apache.xmlbeans.XmlString;
/*     */ import org.apache.xmlbeans.xml.stream.XMLInputStream;
/*     */ import org.apache.xmlbeans.xml.stream.XMLStreamException;
/*     */ 
/*     */ public interface Attribute extends Annotated {
/*  18 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$Attribute == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$Attribute = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.Attribute")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$Attribute).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("attribute83a9type");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   LocalSimpleType getSimpleType();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isSetSimpleType();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setSimpleType(LocalSimpleType paramLocalSimpleType);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   LocalSimpleType addNewSimpleType();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void unsetSimpleType();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   String getName();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   XmlNCName xgetName();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isSetName();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setName(String paramString);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void xsetName(XmlNCName paramXmlNCName);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void unsetName();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   b getRef();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   XmlQName xgetRef();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isSetRef();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setRef(b paramb);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void xsetRef(XmlQName paramXmlQName);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void unsetRef();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   b getType();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   XmlQName xgetType();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isSetType();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setType(b paramb);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void xsetType(XmlQName paramXmlQName);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void unsetType();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Use.Enum getUse();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Use xgetUse();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isSetUse();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setUse(Use.Enum paramEnum);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void xsetUse(Use paramUse);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void unsetUse();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   String getDefault();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   XmlString xgetDefault();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isSetDefault();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setDefault(String paramString);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void xsetDefault(XmlString paramXmlString);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void unsetDefault();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   String getFixed();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   XmlString xgetFixed();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isSetFixed();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setFixed(String paramString);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void xsetFixed(XmlString paramXmlString);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void unsetFixed();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   FormChoice.Enum getForm();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   FormChoice xgetForm();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isSetForm();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setForm(FormChoice.Enum paramEnum);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void xsetForm(FormChoice paramFormChoice);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void unsetForm();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface Use
/*     */     extends XmlNMTOKEN
/*     */   {
/* 263 */     public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((Attribute.null.class$org$apache$xmlbeans$impl$xb$xsdschema$Attribute$Use == null) ? (Attribute.null.class$org$apache$xmlbeans$impl$xb$xsdschema$Attribute$Use = Attribute.null.class$("org.apache.xmlbeans.impl.xb.xsdschema.Attribute$Use")) : Attribute.null.class$org$apache$xmlbeans$impl$xb$xsdschema$Attribute$Use).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("usea41aattrtype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 269 */     public static final Enum PROHIBITED = Enum.forString("prohibited");
/* 270 */     public static final Enum OPTIONAL = Enum.forString("optional");
/* 271 */     public static final Enum REQUIRED = Enum.forString("required");
/*     */ 
/*     */     
/*     */     public static final int INT_PROHIBITED = 1;
/*     */     
/*     */     public static final int INT_OPTIONAL = 2;
/*     */     
/*     */     public static final int INT_REQUIRED = 3;
/*     */ 
/*     */     
/*     */     StringEnumAbstractBase enumValue();
/*     */ 
/*     */     
/*     */     void set(StringEnumAbstractBase param1StringEnumAbstractBase);
/*     */ 
/*     */     
/*     */     public static final class Enum
/*     */       extends StringEnumAbstractBase
/*     */     {
/*     */       static final int INT_PROHIBITED = 1;
/*     */       
/*     */       static final int INT_OPTIONAL = 2;
/*     */       
/*     */       static final int INT_REQUIRED = 3;
/*     */ 
/*     */       
/*     */       public static Enum forString(String param2String) {
/* 298 */         return (Enum)table.forString(param2String);
/*     */       }
/*     */ 
/*     */       
/*     */       public static Enum forInt(int param2Int) {
/* 303 */         return (Enum)table.forInt(param2Int);
/*     */       }
/*     */       private Enum(String param2String, int param2Int) {
/* 306 */         super(param2String, param2Int);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 312 */       public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("prohibited", 1), new Enum("optional", 2), new Enum("required", 3) });
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       private static final long serialVersionUID = 1L;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       private Object readResolve() {
/* 323 */         return forInt(intValue());
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static final class Factory
/*     */     {
/*     */       public static Attribute.Use newValue(Object param2Object) {
/* 334 */         return (Attribute.Use)Attribute.Use.type.newValue(param2Object);
/*     */       }
/*     */       public static Attribute.Use newInstance() {
/* 337 */         return (Attribute.Use)XmlBeans.getContextTypeLoader().newInstance(Attribute.Use.type, null);
/*     */       }
/*     */       public static Attribute.Use newInstance(XmlOptions param2XmlOptions) {
/* 340 */         return (Attribute.Use)XmlBeans.getContextTypeLoader().newInstance(Attribute.Use.type, param2XmlOptions);
/*     */       } }
/*     */   } public static final class Enum extends StringEnumAbstractBase { static final int INT_PROHIBITED = 1; static final int INT_OPTIONAL = 2; static final int INT_REQUIRED = 3; public static Enum forString(String param1String) {
/*     */       return (Enum)table.forString(param1String);
/*     */     } public static Enum forInt(int param1Int) {
/*     */       return (Enum)table.forInt(param1Int);
/*     */     } private Enum(String param1String, int param1Int) {
/*     */       super(param1String, param1Int);
/*     */     }
/*     */     public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("prohibited", 1), new Enum("optional", 2), new Enum("required", 3) }); private static final long serialVersionUID = 1L;
/*     */     private Object readResolve() {
/*     */       return forInt(intValue());
/*     */     } }
/*     */   public static final class Factory { public static Attribute newInstance() {
/* 354 */       return (Attribute)XmlBeans.getContextTypeLoader().newInstance(Attribute.type, null);
/*     */     }
/*     */     public static Attribute newInstance(XmlOptions param1XmlOptions) {
/* 357 */       return (Attribute)XmlBeans.getContextTypeLoader().newInstance(Attribute.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static Attribute parse(String param1String) throws XmlException {
/* 361 */       return (Attribute)XmlBeans.getContextTypeLoader().parse(param1String, Attribute.type, null);
/*     */     }
/*     */     public static Attribute parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/* 364 */       return (Attribute)XmlBeans.getContextTypeLoader().parse(param1String, Attribute.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static Attribute parse(File param1File) throws XmlException, IOException {
/* 368 */       return (Attribute)XmlBeans.getContextTypeLoader().parse(param1File, Attribute.type, null);
/*     */     }
/*     */     public static Attribute parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 371 */       return (Attribute)XmlBeans.getContextTypeLoader().parse(param1File, Attribute.type, param1XmlOptions);
/*     */     }
/*     */     public static Attribute parse(URL param1URL) throws XmlException, IOException {
/* 374 */       return (Attribute)XmlBeans.getContextTypeLoader().parse(param1URL, Attribute.type, null);
/*     */     }
/*     */     public static Attribute parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 377 */       return (Attribute)XmlBeans.getContextTypeLoader().parse(param1URL, Attribute.type, param1XmlOptions);
/*     */     }
/*     */     public static Attribute parse(InputStream param1InputStream) throws XmlException, IOException {
/* 380 */       return (Attribute)XmlBeans.getContextTypeLoader().parse(param1InputStream, Attribute.type, null);
/*     */     }
/*     */     public static Attribute parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 383 */       return (Attribute)XmlBeans.getContextTypeLoader().parse(param1InputStream, Attribute.type, param1XmlOptions);
/*     */     }
/*     */     public static Attribute parse(Reader param1Reader) throws XmlException, IOException {
/* 386 */       return (Attribute)XmlBeans.getContextTypeLoader().parse(param1Reader, Attribute.type, null);
/*     */     }
/*     */     public static Attribute parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 389 */       return (Attribute)XmlBeans.getContextTypeLoader().parse(param1Reader, Attribute.type, param1XmlOptions);
/*     */     }
/*     */     public static Attribute parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 392 */       return (Attribute)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, Attribute.type, null);
/*     */     }
/*     */     public static Attribute parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 395 */       return (Attribute)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, Attribute.type, param1XmlOptions);
/*     */     }
/*     */     public static Attribute parse(Node param1Node) throws XmlException {
/* 398 */       return (Attribute)XmlBeans.getContextTypeLoader().parse(param1Node, Attribute.type, null);
/*     */     }
/*     */     public static Attribute parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 401 */       return (Attribute)XmlBeans.getContextTypeLoader().parse(param1Node, Attribute.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static Attribute parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 405 */       return (Attribute)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, Attribute.type, null);
/*     */     }
/*     */     
/*     */     public static Attribute parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 409 */       return (Attribute)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, Attribute.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 413 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, Attribute.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 417 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, Attribute.type, param1XmlOptions);
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\Attribute.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */