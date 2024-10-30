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
/*     */ public interface DerivationSet
/*     */   extends XmlAnySimpleType
/*     */ {
/*     */   Object getObjectValue();
/*     */   
/*  27 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$DerivationSet == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$DerivationSet = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.DerivationSet")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$DerivationSet).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("derivationset037atype");
/*     */   
/*     */   void setObjectValue(Object paramObject);
/*     */   
/*     */   Object objectValue();
/*     */   
/*     */   void objectSet(Object paramObject);
/*     */   
/*     */   SchemaType instanceType();
/*     */   
/*  37 */   public static interface Member extends XmlToken { public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((DerivationSet.null.class$org$apache$xmlbeans$impl$xb$xsdschema$DerivationSet$Member == null) ? (DerivationSet.null.class$org$apache$xmlbeans$impl$xb$xsdschema$DerivationSet$Member = DerivationSet.null.class$("org.apache.xmlbeans.impl.xb.xsdschema.DerivationSet$Member")) : DerivationSet.null.class$org$apache$xmlbeans$impl$xb$xsdschema$DerivationSet$Member).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("anoned75type");
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
/*     */       public static DerivationSet.Member newValue(Object param2Object) {
/* 100 */         return (DerivationSet.Member)DerivationSet.Member.type.newValue(param2Object);
/*     */       }
/*     */       public static DerivationSet.Member newInstance() {
/* 103 */         return (DerivationSet.Member)XmlBeans.getContextTypeLoader().newInstance(DerivationSet.Member.type, null);
/*     */       }
/*     */       public static DerivationSet.Member newInstance(XmlOptions param2XmlOptions) {
/* 106 */         return (DerivationSet.Member)XmlBeans.getContextTypeLoader().newInstance(DerivationSet.Member.type, param2XmlOptions);
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
/* 128 */     public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((DerivationSet.null.class$org$apache$xmlbeans$impl$xb$xsdschema$DerivationSet$Member2 == null) ? (DerivationSet.null.class$org$apache$xmlbeans$impl$xb$xsdschema$DerivationSet$Member2 = DerivationSet.null.class$("org.apache.xmlbeans.impl.xb.xsdschema.DerivationSet$Member2")) : DerivationSet.null.class$org$apache$xmlbeans$impl$xb$xsdschema$DerivationSet$Member2).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("anon9394type");
/*     */     
/*     */     List listValue();
/*     */     
/*     */     List xlistValue();
/*     */     
/*     */     void set(List param1List);
/*     */     
/*     */     public static final class Factory
/*     */     {
/*     */       public static DerivationSet.Member2 newValue(Object param2Object) {
/* 139 */         return (DerivationSet.Member2)DerivationSet.Member2.type.newValue(param2Object);
/*     */       }
/*     */       public static DerivationSet.Member2 newInstance() {
/* 142 */         return (DerivationSet.Member2)XmlBeans.getContextTypeLoader().newInstance(DerivationSet.Member2.type, null);
/*     */       }
/*     */       public static DerivationSet.Member2 newInstance(XmlOptions param2XmlOptions) {
/* 145 */         return (DerivationSet.Member2)XmlBeans.getContextTypeLoader().newInstance(DerivationSet.Member2.type, param2XmlOptions);
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
/*     */     public static DerivationSet newValue(Object param1Object) {
/* 159 */       return (DerivationSet)DerivationSet.type.newValue(param1Object);
/*     */     }
/*     */     public static DerivationSet newInstance() {
/* 162 */       return (DerivationSet)XmlBeans.getContextTypeLoader().newInstance(DerivationSet.type, null);
/*     */     }
/*     */     public static DerivationSet newInstance(XmlOptions param1XmlOptions) {
/* 165 */       return (DerivationSet)XmlBeans.getContextTypeLoader().newInstance(DerivationSet.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static DerivationSet parse(String param1String) throws XmlException {
/* 169 */       return (DerivationSet)XmlBeans.getContextTypeLoader().parse(param1String, DerivationSet.type, null);
/*     */     }
/*     */     public static DerivationSet parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/* 172 */       return (DerivationSet)XmlBeans.getContextTypeLoader().parse(param1String, DerivationSet.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static DerivationSet parse(File param1File) throws XmlException, IOException {
/* 176 */       return (DerivationSet)XmlBeans.getContextTypeLoader().parse(param1File, DerivationSet.type, null);
/*     */     }
/*     */     public static DerivationSet parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 179 */       return (DerivationSet)XmlBeans.getContextTypeLoader().parse(param1File, DerivationSet.type, param1XmlOptions);
/*     */     }
/*     */     public static DerivationSet parse(URL param1URL) throws XmlException, IOException {
/* 182 */       return (DerivationSet)XmlBeans.getContextTypeLoader().parse(param1URL, DerivationSet.type, null);
/*     */     }
/*     */     public static DerivationSet parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 185 */       return (DerivationSet)XmlBeans.getContextTypeLoader().parse(param1URL, DerivationSet.type, param1XmlOptions);
/*     */     }
/*     */     public static DerivationSet parse(InputStream param1InputStream) throws XmlException, IOException {
/* 188 */       return (DerivationSet)XmlBeans.getContextTypeLoader().parse(param1InputStream, DerivationSet.type, null);
/*     */     }
/*     */     public static DerivationSet parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 191 */       return (DerivationSet)XmlBeans.getContextTypeLoader().parse(param1InputStream, DerivationSet.type, param1XmlOptions);
/*     */     }
/*     */     public static DerivationSet parse(Reader param1Reader) throws XmlException, IOException {
/* 194 */       return (DerivationSet)XmlBeans.getContextTypeLoader().parse(param1Reader, DerivationSet.type, null);
/*     */     }
/*     */     public static DerivationSet parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 197 */       return (DerivationSet)XmlBeans.getContextTypeLoader().parse(param1Reader, DerivationSet.type, param1XmlOptions);
/*     */     }
/*     */     public static DerivationSet parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 200 */       return (DerivationSet)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, DerivationSet.type, null);
/*     */     }
/*     */     public static DerivationSet parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 203 */       return (DerivationSet)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, DerivationSet.type, param1XmlOptions);
/*     */     }
/*     */     public static DerivationSet parse(Node param1Node) throws XmlException {
/* 206 */       return (DerivationSet)XmlBeans.getContextTypeLoader().parse(param1Node, DerivationSet.type, null);
/*     */     }
/*     */     public static DerivationSet parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 209 */       return (DerivationSet)XmlBeans.getContextTypeLoader().parse(param1Node, DerivationSet.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static DerivationSet parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 213 */       return (DerivationSet)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, DerivationSet.type, null);
/*     */     }
/*     */     
/*     */     public static DerivationSet parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 217 */       return (DerivationSet)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, DerivationSet.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 221 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, DerivationSet.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 225 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, DerivationSet.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\DerivationSet.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */