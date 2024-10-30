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
/*     */ public interface NamespaceList
/*     */   extends XmlAnySimpleType
/*     */ {
/*     */   Object getObjectValue();
/*     */   
/*  27 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$NamespaceList == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$NamespaceList = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.NamespaceList")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$NamespaceList).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("namespacelist10cctype");
/*     */   
/*     */   void setObjectValue(Object paramObject);
/*     */   
/*     */   Object objectValue();
/*     */   
/*     */   void objectSet(Object paramObject);
/*     */   
/*     */   SchemaType instanceType();
/*     */   
/*  37 */   public static interface Member extends XmlToken { public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((NamespaceList.null.class$org$apache$xmlbeans$impl$xb$xsdschema$NamespaceList$Member == null) ? (NamespaceList.null.class$org$apache$xmlbeans$impl$xb$xsdschema$NamespaceList$Member = NamespaceList.null.class$("org.apache.xmlbeans.impl.xb.xsdschema.NamespaceList$Member")) : NamespaceList.null.class$org$apache$xmlbeans$impl$xb$xsdschema$NamespaceList$Member).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("anonfac7type");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  43 */     public static final Enum ANY = Enum.forString("##any");
/*  44 */     public static final Enum OTHER = Enum.forString("##other");
/*     */ 
/*     */     
/*     */     public static final int INT_ANY = 1;
/*     */ 
/*     */     
/*     */     public static final int INT_OTHER = 2;
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
/*     */     public static final class Enum
/*     */       extends StringEnumAbstractBase
/*     */     {
/*     */       static final int INT_ANY = 1;
/*     */       
/*     */       static final int INT_OTHER = 2;
/*     */ 
/*     */       
/*     */       public static Enum forString(String param2String) {
/*  70 */         return (Enum)table.forString(param2String);
/*     */       }
/*     */ 
/*     */       
/*     */       public static Enum forInt(int param2Int) {
/*  75 */         return (Enum)table.forInt(param2Int);
/*     */       }
/*     */       private Enum(String param2String, int param2Int) {
/*  78 */         super(param2String, param2Int);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*  83 */       public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("##any", 1), new Enum("##other", 2) });
/*     */ 
/*     */ 
/*     */       
/*     */       private static final long serialVersionUID = 1L;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       private Object readResolve() {
/*  93 */         return forInt(intValue());
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static final class Factory
/*     */     {
/*     */       public static NamespaceList.Member newValue(Object param2Object) {
/* 104 */         return (NamespaceList.Member)NamespaceList.Member.type.newValue(param2Object);
/*     */       }
/*     */       public static NamespaceList.Member newInstance() {
/* 107 */         return (NamespaceList.Member)XmlBeans.getContextTypeLoader().newInstance(NamespaceList.Member.type, null);
/*     */       }
/*     */       public static NamespaceList.Member newInstance(XmlOptions param2XmlOptions) {
/* 110 */         return (NamespaceList.Member)XmlBeans.getContextTypeLoader().newInstance(NamespaceList.Member.type, param2XmlOptions);
/*     */       }
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface Member2
/*     */     extends XmlAnySimpleType
/*     */   {
/* 132 */     public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((NamespaceList.null.class$org$apache$xmlbeans$impl$xb$xsdschema$NamespaceList$Member2 == null) ? (NamespaceList.null.class$org$apache$xmlbeans$impl$xb$xsdschema$NamespaceList$Member2 = NamespaceList.null.class$("org.apache.xmlbeans.impl.xb.xsdschema.NamespaceList$Member2")) : NamespaceList.null.class$org$apache$xmlbeans$impl$xb$xsdschema$NamespaceList$Member2).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("anona0e6type");
/*     */     
/*     */     List getListValue();
/*     */     
/*     */     List xgetListValue();
/*     */     
/*     */     void setListValue(List param1List);
/*     */     
/*     */     List listValue();
/*     */     
/*     */     List xlistValue();
/*     */     
/*     */     void set(List param1List);
/*     */     
/*     */     public static interface Item
/*     */       extends XmlAnySimpleType
/*     */     {
/*     */       Object getObjectValue();
/*     */       
/* 151 */       public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((NamespaceList.null.class$org$apache$xmlbeans$impl$xb$xsdschema$NamespaceList$Member2$Item == null) ? (NamespaceList.null.class$org$apache$xmlbeans$impl$xb$xsdschema$NamespaceList$Member2$Item = NamespaceList.null.class$("org.apache.xmlbeans.impl.xb.xsdschema.NamespaceList$Member2$Item")) : NamespaceList.null.class$org$apache$xmlbeans$impl$xb$xsdschema$NamespaceList$Member2$Item).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("anon16cetype");
/*     */       
/*     */       void setObjectValue(Object param2Object);
/*     */       
/*     */       Object objectValue();
/*     */       
/*     */       void objectSet(Object param2Object);
/*     */       
/*     */       SchemaType instanceType();
/*     */       
/* 161 */       public static interface Member extends XmlToken { public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((NamespaceList.null.class$org$apache$xmlbeans$impl$xb$xsdschema$NamespaceList$Member2$Item$Member == null) ? (NamespaceList.null.class$org$apache$xmlbeans$impl$xb$xsdschema$NamespaceList$Member2$Item$Member = NamespaceList.null.class$("org.apache.xmlbeans.impl.xb.xsdschema.NamespaceList$Member2$Item$Member")) : NamespaceList.null.class$org$apache$xmlbeans$impl$xb$xsdschema$NamespaceList$Member2$Item$Member).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("anon0c73type");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 167 */         public static final Enum TARGET_NAMESPACE = Enum.forString("##targetNamespace");
/* 168 */         public static final Enum LOCAL = Enum.forString("##local");
/*     */ 
/*     */         
/*     */         public static final int INT_TARGET_NAMESPACE = 1;
/*     */ 
/*     */         
/*     */         public static final int INT_LOCAL = 2;
/*     */ 
/*     */ 
/*     */         
/*     */         StringEnumAbstractBase enumValue();
/*     */ 
/*     */ 
/*     */         
/*     */         void set(StringEnumAbstractBase param3StringEnumAbstractBase);
/*     */ 
/*     */         
/*     */         public static final class Enum
/*     */           extends StringEnumAbstractBase
/*     */         {
/*     */           static final int INT_TARGET_NAMESPACE = 1;
/*     */           
/*     */           static final int INT_LOCAL = 2;
/*     */ 
/*     */           
/*     */           public static Enum forString(String param4String) {
/* 194 */             return (Enum)table.forString(param4String);
/*     */           }
/*     */ 
/*     */           
/*     */           public static Enum forInt(int param4Int) {
/* 199 */             return (Enum)table.forInt(param4Int);
/*     */           }
/*     */           private Enum(String param4String, int param4Int) {
/* 202 */             super(param4String, param4Int);
/*     */           }
/*     */ 
/*     */ 
/*     */           
/* 207 */           public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("##targetNamespace", 1), new Enum("##local", 2) });
/*     */ 
/*     */ 
/*     */           
/*     */           private static final long serialVersionUID = 1L;
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           private Object readResolve() {
/* 217 */             return forInt(intValue());
/*     */           }
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public static final class Factory
/*     */         {
/*     */           public static NamespaceList.Member2.Item.Member newValue(Object param4Object) {
/* 228 */             return (NamespaceList.Member2.Item.Member)NamespaceList.Member2.Item.Member.type.newValue(param4Object);
/*     */           }
/*     */           public static NamespaceList.Member2.Item.Member newInstance() {
/* 231 */             return (NamespaceList.Member2.Item.Member)XmlBeans.getContextTypeLoader().newInstance(NamespaceList.Member2.Item.Member.type, null);
/*     */           }
/*     */           public static NamespaceList.Member2.Item.Member newInstance(XmlOptions param4XmlOptions) {
/* 234 */             return (NamespaceList.Member2.Item.Member)XmlBeans.getContextTypeLoader().newInstance(NamespaceList.Member2.Item.Member.type, param4XmlOptions);
/*     */           }
/*     */         } }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public static final class Factory
/*     */       {
/*     */         public static NamespaceList.Member2.Item newValue(Object param3Object) {
/* 248 */           return (NamespaceList.Member2.Item)NamespaceList.Member2.Item.type.newValue(param3Object);
/*     */         }
/*     */         public static NamespaceList.Member2.Item newInstance() {
/* 251 */           return (NamespaceList.Member2.Item)XmlBeans.getContextTypeLoader().newInstance(NamespaceList.Member2.Item.type, null);
/*     */         }
/*     */         public static NamespaceList.Member2.Item newInstance(XmlOptions param3XmlOptions) {
/* 254 */           return (NamespaceList.Member2.Item)XmlBeans.getContextTypeLoader().newInstance(NamespaceList.Member2.Item.type, param3XmlOptions);
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
/*     */       public static NamespaceList.Member2 newValue(Object param2Object) {
/* 268 */         return (NamespaceList.Member2)NamespaceList.Member2.type.newValue(param2Object);
/*     */       }
/*     */       public static NamespaceList.Member2 newInstance() {
/* 271 */         return (NamespaceList.Member2)XmlBeans.getContextTypeLoader().newInstance(NamespaceList.Member2.type, null);
/*     */       }
/*     */       public static NamespaceList.Member2 newInstance(XmlOptions param2XmlOptions) {
/* 274 */         return (NamespaceList.Member2)XmlBeans.getContextTypeLoader().newInstance(NamespaceList.Member2.type, param2XmlOptions);
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
/*     */     public static NamespaceList newValue(Object param1Object) {
/* 288 */       return (NamespaceList)NamespaceList.type.newValue(param1Object);
/*     */     }
/*     */     public static NamespaceList newInstance() {
/* 291 */       return (NamespaceList)XmlBeans.getContextTypeLoader().newInstance(NamespaceList.type, null);
/*     */     }
/*     */     public static NamespaceList newInstance(XmlOptions param1XmlOptions) {
/* 294 */       return (NamespaceList)XmlBeans.getContextTypeLoader().newInstance(NamespaceList.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static NamespaceList parse(String param1String) throws XmlException {
/* 298 */       return (NamespaceList)XmlBeans.getContextTypeLoader().parse(param1String, NamespaceList.type, null);
/*     */     }
/*     */     public static NamespaceList parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/* 301 */       return (NamespaceList)XmlBeans.getContextTypeLoader().parse(param1String, NamespaceList.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static NamespaceList parse(File param1File) throws XmlException, IOException {
/* 305 */       return (NamespaceList)XmlBeans.getContextTypeLoader().parse(param1File, NamespaceList.type, null);
/*     */     }
/*     */     public static NamespaceList parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 308 */       return (NamespaceList)XmlBeans.getContextTypeLoader().parse(param1File, NamespaceList.type, param1XmlOptions);
/*     */     }
/*     */     public static NamespaceList parse(URL param1URL) throws XmlException, IOException {
/* 311 */       return (NamespaceList)XmlBeans.getContextTypeLoader().parse(param1URL, NamespaceList.type, null);
/*     */     }
/*     */     public static NamespaceList parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 314 */       return (NamespaceList)XmlBeans.getContextTypeLoader().parse(param1URL, NamespaceList.type, param1XmlOptions);
/*     */     }
/*     */     public static NamespaceList parse(InputStream param1InputStream) throws XmlException, IOException {
/* 317 */       return (NamespaceList)XmlBeans.getContextTypeLoader().parse(param1InputStream, NamespaceList.type, null);
/*     */     }
/*     */     public static NamespaceList parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 320 */       return (NamespaceList)XmlBeans.getContextTypeLoader().parse(param1InputStream, NamespaceList.type, param1XmlOptions);
/*     */     }
/*     */     public static NamespaceList parse(Reader param1Reader) throws XmlException, IOException {
/* 323 */       return (NamespaceList)XmlBeans.getContextTypeLoader().parse(param1Reader, NamespaceList.type, null);
/*     */     }
/*     */     public static NamespaceList parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 326 */       return (NamespaceList)XmlBeans.getContextTypeLoader().parse(param1Reader, NamespaceList.type, param1XmlOptions);
/*     */     }
/*     */     public static NamespaceList parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 329 */       return (NamespaceList)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, NamespaceList.type, null);
/*     */     }
/*     */     public static NamespaceList parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 332 */       return (NamespaceList)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, NamespaceList.type, param1XmlOptions);
/*     */     }
/*     */     public static NamespaceList parse(Node param1Node) throws XmlException {
/* 335 */       return (NamespaceList)XmlBeans.getContextTypeLoader().parse(param1Node, NamespaceList.type, null);
/*     */     }
/*     */     public static NamespaceList parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 338 */       return (NamespaceList)XmlBeans.getContextTypeLoader().parse(param1Node, NamespaceList.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static NamespaceList parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 342 */       return (NamespaceList)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, NamespaceList.type, null);
/*     */     }
/*     */     
/*     */     public static NamespaceList parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 346 */       return (NamespaceList)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, NamespaceList.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 350 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, NamespaceList.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 354 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, NamespaceList.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\NamespaceList.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */