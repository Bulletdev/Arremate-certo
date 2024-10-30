/*     */ package org.apache.xmlbeans.impl.xb.xsdschema;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.net.URL;
/*     */ import java.util.List;
/*     */ import javax.xml.stream.XMLStreamReader;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.StringEnumAbstractBase;
/*     */ import org.apache.xmlbeans.XmlAnySimpleType;
/*     */ import org.apache.xmlbeans.XmlBeans;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.apache.xmlbeans.XmlToken;
/*     */ import org.apache.xmlbeans.xml.stream.XMLInputStream;
/*     */ import org.apache.xmlbeans.xml.stream.XMLStreamException;
/*     */ import org.w3c.dom.Node;
/*     */ 
/*     */ 
/*     */ public interface SimpleDerivationSet
/*     */   extends XmlAnySimpleType
/*     */ {
/*     */   Object getObjectValue();
/*     */   
/*  27 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$SimpleDerivationSet == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$SimpleDerivationSet = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.SimpleDerivationSet")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$SimpleDerivationSet).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("simplederivationsetf70ctype");
/*     */   
/*     */   void setObjectValue(Object paramObject);
/*     */   
/*     */   Object objectValue();
/*     */   
/*     */   void objectSet(Object paramObject);
/*     */   
/*     */   SchemaType instanceType();
/*     */   
/*  37 */   public static interface Member extends XmlToken { public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((SimpleDerivationSet.null.class$org$apache$xmlbeans$impl$xb$xsdschema$SimpleDerivationSet$Member == null) ? (SimpleDerivationSet.null.class$org$apache$xmlbeans$impl$xb$xsdschema$SimpleDerivationSet$Member = SimpleDerivationSet.null.class$("org.apache.xmlbeans.impl.xb.xsdschema.SimpleDerivationSet$Member")) : SimpleDerivationSet.null.class$org$apache$xmlbeans$impl$xb$xsdschema$SimpleDerivationSet$Member).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("anon38c7type");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  43 */     public static final Enum ALL = Enum.forString("#all");
/*     */ 
/*     */ 
/*     */     
/*     */     public static final int INT_ALL = 1;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     StringEnumAbstractBase enumValue();
/*     */ 
/*     */ 
/*     */     
/*     */     void set(StringEnumAbstractBase param1StringEnumAbstractBase);
/*     */ 
/*     */ 
/*     */     
/*     */     public static final class Enum
/*     */       extends StringEnumAbstractBase
/*     */     {
/*     */       static final int INT_ALL = 1;
/*     */ 
/*     */ 
/*     */       
/*     */       public static Enum forString(String param2String) {
/*  68 */         return (Enum)table.forString(param2String);
/*     */       }
/*     */ 
/*     */       
/*     */       public static Enum forInt(int param2Int) {
/*  73 */         return (Enum)table.forInt(param2Int);
/*     */       }
/*     */       private Enum(String param2String, int param2Int) {
/*  76 */         super(param2String, param2Int);
/*     */       }
/*     */ 
/*     */       
/*  80 */       public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("#all", 1) });
/*     */ 
/*     */ 
/*     */       
/*     */       private static final long serialVersionUID = 1L;
/*     */ 
/*     */ 
/*     */       
/*     */       private Object readResolve() {
/*  89 */         return forInt(intValue());
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static final class Factory
/*     */     {
/*     */       public static SimpleDerivationSet.Member newValue(Object param2Object) {
/* 100 */         return (SimpleDerivationSet.Member)SimpleDerivationSet.Member.type.newValue(param2Object);
/*     */       }
/*     */       public static SimpleDerivationSet.Member newInstance() {
/* 103 */         return (SimpleDerivationSet.Member)XmlBeans.getContextTypeLoader().newInstance(SimpleDerivationSet.Member.type, null);
/*     */       }
/*     */       public static SimpleDerivationSet.Member newInstance(XmlOptions param2XmlOptions) {
/* 106 */         return (SimpleDerivationSet.Member)XmlBeans.getContextTypeLoader().newInstance(SimpleDerivationSet.Member.type, param2XmlOptions);
/*     */       }
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface Member2
/*     */     extends XmlAnySimpleType
/*     */   {
/*     */     List getListValue();
/*     */ 
/*     */ 
/*     */     
/*     */     List xgetListValue();
/*     */ 
/*     */ 
/*     */     
/*     */     void setListValue(List param1List);
/*     */ 
/*     */ 
/*     */     
/* 128 */     public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((SimpleDerivationSet.null.class$org$apache$xmlbeans$impl$xb$xsdschema$SimpleDerivationSet$Member2 == null) ? (SimpleDerivationSet.null.class$org$apache$xmlbeans$impl$xb$xsdschema$SimpleDerivationSet$Member2 = SimpleDerivationSet.null.class$("org.apache.xmlbeans.impl.xb.xsdschema.SimpleDerivationSet$Member2")) : SimpleDerivationSet.null.class$org$apache$xmlbeans$impl$xb$xsdschema$SimpleDerivationSet$Member2).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("anon8ba6type");
/*     */     
/*     */     List listValue();
/*     */     
/*     */     List xlistValue();
/*     */     
/*     */     void set(List param1List);
/*     */     
/*     */     public static interface Item
/*     */       extends DerivationControl {
/* 138 */       public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((SimpleDerivationSet.null.class$org$apache$xmlbeans$impl$xb$xsdschema$SimpleDerivationSet$Member2$Item == null) ? (SimpleDerivationSet.null.class$org$apache$xmlbeans$impl$xb$xsdschema$SimpleDerivationSet$Member2$Item = SimpleDerivationSet.null.class$("org.apache.xmlbeans.impl.xb.xsdschema.SimpleDerivationSet$Member2$Item")) : SimpleDerivationSet.null.class$org$apache$xmlbeans$impl$xb$xsdschema$SimpleDerivationSet$Member2$Item).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("anonf38etype");
/*     */ 
/*     */       
/* 141 */       public static final DerivationControl.Enum LIST = DerivationControl.LIST;
/* 142 */       public static final DerivationControl.Enum UNION = DerivationControl.UNION;
/* 143 */       public static final DerivationControl.Enum RESTRICTION = DerivationControl.RESTRICTION;
/*     */ 
/*     */       
/*     */       public static final int INT_LIST = 4;
/*     */ 
/*     */       
/*     */       public static final int INT_UNION = 5;
/*     */       
/*     */       public static final int INT_RESTRICTION = 3;
/*     */ 
/*     */       
/*     */       public static final class Factory
/*     */       {
/*     */         public static SimpleDerivationSet.Member2.Item newValue(Object param3Object) {
/* 157 */           return (SimpleDerivationSet.Member2.Item)SimpleDerivationSet.Member2.Item.type.newValue(param3Object);
/*     */         }
/*     */         public static SimpleDerivationSet.Member2.Item newInstance() {
/* 160 */           return (SimpleDerivationSet.Member2.Item)XmlBeans.getContextTypeLoader().newInstance(SimpleDerivationSet.Member2.Item.type, null);
/*     */         }
/*     */         public static SimpleDerivationSet.Member2.Item newInstance(XmlOptions param3XmlOptions) {
/* 163 */           return (SimpleDerivationSet.Member2.Item)XmlBeans.getContextTypeLoader().newInstance(SimpleDerivationSet.Member2.Item.type, param3XmlOptions);
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
/*     */       public static SimpleDerivationSet.Member2 newValue(Object param2Object) {
/* 177 */         return (SimpleDerivationSet.Member2)SimpleDerivationSet.Member2.type.newValue(param2Object);
/*     */       }
/*     */       public static SimpleDerivationSet.Member2 newInstance() {
/* 180 */         return (SimpleDerivationSet.Member2)XmlBeans.getContextTypeLoader().newInstance(SimpleDerivationSet.Member2.type, null);
/*     */       }
/*     */       public static SimpleDerivationSet.Member2 newInstance(XmlOptions param2XmlOptions) {
/* 183 */         return (SimpleDerivationSet.Member2)XmlBeans.getContextTypeLoader().newInstance(SimpleDerivationSet.Member2.type, param2XmlOptions);
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
/*     */     public static SimpleDerivationSet newValue(Object param1Object) {
/* 197 */       return (SimpleDerivationSet)SimpleDerivationSet.type.newValue(param1Object);
/*     */     }
/*     */     public static SimpleDerivationSet newInstance() {
/* 200 */       return (SimpleDerivationSet)XmlBeans.getContextTypeLoader().newInstance(SimpleDerivationSet.type, null);
/*     */     }
/*     */     public static SimpleDerivationSet newInstance(XmlOptions param1XmlOptions) {
/* 203 */       return (SimpleDerivationSet)XmlBeans.getContextTypeLoader().newInstance(SimpleDerivationSet.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static SimpleDerivationSet parse(String param1String) throws XmlException {
/* 207 */       return (SimpleDerivationSet)XmlBeans.getContextTypeLoader().parse(param1String, SimpleDerivationSet.type, null);
/*     */     }
/*     */     public static SimpleDerivationSet parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/* 210 */       return (SimpleDerivationSet)XmlBeans.getContextTypeLoader().parse(param1String, SimpleDerivationSet.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static SimpleDerivationSet parse(File param1File) throws XmlException, IOException {
/* 214 */       return (SimpleDerivationSet)XmlBeans.getContextTypeLoader().parse(param1File, SimpleDerivationSet.type, null);
/*     */     }
/*     */     public static SimpleDerivationSet parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 217 */       return (SimpleDerivationSet)XmlBeans.getContextTypeLoader().parse(param1File, SimpleDerivationSet.type, param1XmlOptions);
/*     */     }
/*     */     public static SimpleDerivationSet parse(URL param1URL) throws XmlException, IOException {
/* 220 */       return (SimpleDerivationSet)XmlBeans.getContextTypeLoader().parse(param1URL, SimpleDerivationSet.type, null);
/*     */     }
/*     */     public static SimpleDerivationSet parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 223 */       return (SimpleDerivationSet)XmlBeans.getContextTypeLoader().parse(param1URL, SimpleDerivationSet.type, param1XmlOptions);
/*     */     }
/*     */     public static SimpleDerivationSet parse(InputStream param1InputStream) throws XmlException, IOException {
/* 226 */       return (SimpleDerivationSet)XmlBeans.getContextTypeLoader().parse(param1InputStream, SimpleDerivationSet.type, null);
/*     */     }
/*     */     public static SimpleDerivationSet parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 229 */       return (SimpleDerivationSet)XmlBeans.getContextTypeLoader().parse(param1InputStream, SimpleDerivationSet.type, param1XmlOptions);
/*     */     }
/*     */     public static SimpleDerivationSet parse(Reader param1Reader) throws XmlException, IOException {
/* 232 */       return (SimpleDerivationSet)XmlBeans.getContextTypeLoader().parse(param1Reader, SimpleDerivationSet.type, null);
/*     */     }
/*     */     public static SimpleDerivationSet parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 235 */       return (SimpleDerivationSet)XmlBeans.getContextTypeLoader().parse(param1Reader, SimpleDerivationSet.type, param1XmlOptions);
/*     */     }
/*     */     public static SimpleDerivationSet parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 238 */       return (SimpleDerivationSet)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, SimpleDerivationSet.type, null);
/*     */     }
/*     */     public static SimpleDerivationSet parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 241 */       return (SimpleDerivationSet)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, SimpleDerivationSet.type, param1XmlOptions);
/*     */     }
/*     */     public static SimpleDerivationSet parse(Node param1Node) throws XmlException {
/* 244 */       return (SimpleDerivationSet)XmlBeans.getContextTypeLoader().parse(param1Node, SimpleDerivationSet.type, null);
/*     */     }
/*     */     public static SimpleDerivationSet parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 247 */       return (SimpleDerivationSet)XmlBeans.getContextTypeLoader().parse(param1Node, SimpleDerivationSet.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static SimpleDerivationSet parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 251 */       return (SimpleDerivationSet)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, SimpleDerivationSet.type, null);
/*     */     }
/*     */     
/*     */     public static SimpleDerivationSet parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 255 */       return (SimpleDerivationSet)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, SimpleDerivationSet.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 259 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, SimpleDerivationSet.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 263 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, SimpleDerivationSet.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\SimpleDerivationSet.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */