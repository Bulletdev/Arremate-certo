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
/*     */ public interface FullDerivationSet
/*     */   extends XmlAnySimpleType
/*     */ {
/*     */   Object getObjectValue();
/*     */   
/*  27 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$FullDerivationSet == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$FullDerivationSet = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.FullDerivationSet")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$FullDerivationSet).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("fullderivationsetd369type");
/*     */   
/*     */   void setObjectValue(Object paramObject);
/*     */   
/*     */   Object objectValue();
/*     */   
/*     */   void objectSet(Object paramObject);
/*     */   
/*     */   SchemaType instanceType();
/*     */   
/*  37 */   public static interface Member extends XmlToken { public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((FullDerivationSet.null.class$org$apache$xmlbeans$impl$xb$xsdschema$FullDerivationSet$Member == null) ? (FullDerivationSet.null.class$org$apache$xmlbeans$impl$xb$xsdschema$FullDerivationSet$Member = FullDerivationSet.null.class$("org.apache.xmlbeans.impl.xb.xsdschema.FullDerivationSet$Member")) : FullDerivationSet.null.class$org$apache$xmlbeans$impl$xb$xsdschema$FullDerivationSet$Member).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("anon47e4type");
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
/*     */       public static FullDerivationSet.Member newValue(Object param2Object) {
/* 100 */         return (FullDerivationSet.Member)FullDerivationSet.Member.type.newValue(param2Object);
/*     */       }
/*     */       public static FullDerivationSet.Member newInstance() {
/* 103 */         return (FullDerivationSet.Member)XmlBeans.getContextTypeLoader().newInstance(FullDerivationSet.Member.type, null);
/*     */       }
/*     */       public static FullDerivationSet.Member newInstance(XmlOptions param2XmlOptions) {
/* 106 */         return (FullDerivationSet.Member)XmlBeans.getContextTypeLoader().newInstance(FullDerivationSet.Member.type, param2XmlOptions);
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
/* 128 */     public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((FullDerivationSet.null.class$org$apache$xmlbeans$impl$xb$xsdschema$FullDerivationSet$Member2 == null) ? (FullDerivationSet.null.class$org$apache$xmlbeans$impl$xb$xsdschema$FullDerivationSet$Member2 = FullDerivationSet.null.class$("org.apache.xmlbeans.impl.xb.xsdschema.FullDerivationSet$Member2")) : FullDerivationSet.null.class$org$apache$xmlbeans$impl$xb$xsdschema$FullDerivationSet$Member2).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("anonc683type");
/*     */     
/*     */     List listValue();
/*     */     
/*     */     List xlistValue();
/*     */     
/*     */     void set(List param1List);
/*     */     
/*     */     public static final class Factory
/*     */     {
/*     */       public static FullDerivationSet.Member2 newValue(Object param2Object) {
/* 139 */         return (FullDerivationSet.Member2)FullDerivationSet.Member2.type.newValue(param2Object);
/*     */       }
/*     */       public static FullDerivationSet.Member2 newInstance() {
/* 142 */         return (FullDerivationSet.Member2)XmlBeans.getContextTypeLoader().newInstance(FullDerivationSet.Member2.type, null);
/*     */       }
/*     */       public static FullDerivationSet.Member2 newInstance(XmlOptions param2XmlOptions) {
/* 145 */         return (FullDerivationSet.Member2)XmlBeans.getContextTypeLoader().newInstance(FullDerivationSet.Member2.type, param2XmlOptions);
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
/*     */     public static FullDerivationSet newValue(Object param1Object) {
/* 159 */       return (FullDerivationSet)FullDerivationSet.type.newValue(param1Object);
/*     */     }
/*     */     public static FullDerivationSet newInstance() {
/* 162 */       return (FullDerivationSet)XmlBeans.getContextTypeLoader().newInstance(FullDerivationSet.type, null);
/*     */     }
/*     */     public static FullDerivationSet newInstance(XmlOptions param1XmlOptions) {
/* 165 */       return (FullDerivationSet)XmlBeans.getContextTypeLoader().newInstance(FullDerivationSet.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static FullDerivationSet parse(String param1String) throws XmlException {
/* 169 */       return (FullDerivationSet)XmlBeans.getContextTypeLoader().parse(param1String, FullDerivationSet.type, null);
/*     */     }
/*     */     public static FullDerivationSet parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/* 172 */       return (FullDerivationSet)XmlBeans.getContextTypeLoader().parse(param1String, FullDerivationSet.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static FullDerivationSet parse(File param1File) throws XmlException, IOException {
/* 176 */       return (FullDerivationSet)XmlBeans.getContextTypeLoader().parse(param1File, FullDerivationSet.type, null);
/*     */     }
/*     */     public static FullDerivationSet parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 179 */       return (FullDerivationSet)XmlBeans.getContextTypeLoader().parse(param1File, FullDerivationSet.type, param1XmlOptions);
/*     */     }
/*     */     public static FullDerivationSet parse(URL param1URL) throws XmlException, IOException {
/* 182 */       return (FullDerivationSet)XmlBeans.getContextTypeLoader().parse(param1URL, FullDerivationSet.type, null);
/*     */     }
/*     */     public static FullDerivationSet parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 185 */       return (FullDerivationSet)XmlBeans.getContextTypeLoader().parse(param1URL, FullDerivationSet.type, param1XmlOptions);
/*     */     }
/*     */     public static FullDerivationSet parse(InputStream param1InputStream) throws XmlException, IOException {
/* 188 */       return (FullDerivationSet)XmlBeans.getContextTypeLoader().parse(param1InputStream, FullDerivationSet.type, null);
/*     */     }
/*     */     public static FullDerivationSet parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 191 */       return (FullDerivationSet)XmlBeans.getContextTypeLoader().parse(param1InputStream, FullDerivationSet.type, param1XmlOptions);
/*     */     }
/*     */     public static FullDerivationSet parse(Reader param1Reader) throws XmlException, IOException {
/* 194 */       return (FullDerivationSet)XmlBeans.getContextTypeLoader().parse(param1Reader, FullDerivationSet.type, null);
/*     */     }
/*     */     public static FullDerivationSet parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 197 */       return (FullDerivationSet)XmlBeans.getContextTypeLoader().parse(param1Reader, FullDerivationSet.type, param1XmlOptions);
/*     */     }
/*     */     public static FullDerivationSet parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 200 */       return (FullDerivationSet)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, FullDerivationSet.type, null);
/*     */     }
/*     */     public static FullDerivationSet parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 203 */       return (FullDerivationSet)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, FullDerivationSet.type, param1XmlOptions);
/*     */     }
/*     */     public static FullDerivationSet parse(Node param1Node) throws XmlException {
/* 206 */       return (FullDerivationSet)XmlBeans.getContextTypeLoader().parse(param1Node, FullDerivationSet.type, null);
/*     */     }
/*     */     public static FullDerivationSet parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 209 */       return (FullDerivationSet)XmlBeans.getContextTypeLoader().parse(param1Node, FullDerivationSet.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static FullDerivationSet parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 213 */       return (FullDerivationSet)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, FullDerivationSet.type, null);
/*     */     }
/*     */     
/*     */     public static FullDerivationSet parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 217 */       return (FullDerivationSet)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, FullDerivationSet.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 221 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, FullDerivationSet.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 225 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, FullDerivationSet.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\FullDerivationSet.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */