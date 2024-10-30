/*     */ package org.apache.xmlbeans.impl.xb.xmlconfig;
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
/*  27 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xmlconfig$NamespaceList == null) ? (null.class$org$apache$xmlbeans$impl$xb$xmlconfig$NamespaceList = null.class$("org.apache.xmlbeans.impl.xb.xmlconfig.NamespaceList")) : null.class$org$apache$xmlbeans$impl$xb$xmlconfig$NamespaceList).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLCONFIG").resolveHandle("namespacelist20datype");
/*     */   
/*     */   void setObjectValue(Object paramObject);
/*     */   
/*     */   Object objectValue();
/*     */   
/*     */   void objectSet(Object paramObject);
/*     */   
/*     */   SchemaType instanceType();
/*     */   
/*  37 */   public static interface Member extends XmlToken { public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((NamespaceList.null.class$org$apache$xmlbeans$impl$xb$xmlconfig$NamespaceList$Member == null) ? (NamespaceList.null.class$org$apache$xmlbeans$impl$xb$xmlconfig$NamespaceList$Member = NamespaceList.null.class$("org.apache.xmlbeans.impl.xb.xmlconfig.NamespaceList$Member")) : NamespaceList.null.class$org$apache$xmlbeans$impl$xb$xmlconfig$NamespaceList$Member).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLCONFIG").resolveHandle("anonc6fftype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  43 */     public static final Enum ANY = Enum.forString("##any");
/*     */ 
/*     */ 
/*     */     
/*     */     public static final int INT_ANY = 1;
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
/*     */       static final int INT_ANY = 1;
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
/*  80 */       public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("##any", 1) });
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
/*     */       public static NamespaceList.Member newValue(Object param2Object) {
/* 100 */         return (NamespaceList.Member)NamespaceList.Member.type.newValue(param2Object);
/*     */       }
/*     */       public static NamespaceList.Member newInstance() {
/* 103 */         return (NamespaceList.Member)XmlBeans.getContextTypeLoader().newInstance(NamespaceList.Member.type, null);
/*     */       }
/*     */       public static NamespaceList.Member newInstance(XmlOptions param2XmlOptions) {
/* 106 */         return (NamespaceList.Member)XmlBeans.getContextTypeLoader().newInstance(NamespaceList.Member.type, param2XmlOptions);
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
/* 128 */     public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((NamespaceList.null.class$org$apache$xmlbeans$impl$xb$xmlconfig$NamespaceList$Member2 == null) ? (NamespaceList.null.class$org$apache$xmlbeans$impl$xb$xmlconfig$NamespaceList$Member2 = NamespaceList.null.class$("org.apache.xmlbeans.impl.xb.xmlconfig.NamespaceList$Member2")) : NamespaceList.null.class$org$apache$xmlbeans$impl$xb$xmlconfig$NamespaceList$Member2).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLCONFIG").resolveHandle("anon5680type");
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
/* 147 */       public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((NamespaceList.null.class$org$apache$xmlbeans$impl$xb$xmlconfig$NamespaceList$Member2$Item == null) ? (NamespaceList.null.class$org$apache$xmlbeans$impl$xb$xmlconfig$NamespaceList$Member2$Item = NamespaceList.null.class$("org.apache.xmlbeans.impl.xb.xmlconfig.NamespaceList$Member2$Item")) : NamespaceList.null.class$org$apache$xmlbeans$impl$xb$xmlconfig$NamespaceList$Member2$Item).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLCONFIG").resolveHandle("anon0798type");
/*     */       
/*     */       void setObjectValue(Object param2Object);
/*     */       
/*     */       Object objectValue();
/*     */       
/*     */       void objectSet(Object param2Object);
/*     */       
/*     */       SchemaType instanceType();
/*     */       
/* 157 */       public static interface Member extends XmlToken { public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((NamespaceList.null.class$org$apache$xmlbeans$impl$xb$xmlconfig$NamespaceList$Member2$Item$Member == null) ? (NamespaceList.null.class$org$apache$xmlbeans$impl$xb$xmlconfig$NamespaceList$Member2$Item$Member = NamespaceList.null.class$("org.apache.xmlbeans.impl.xb.xmlconfig.NamespaceList$Member2$Item$Member")) : NamespaceList.null.class$org$apache$xmlbeans$impl$xb$xmlconfig$NamespaceList$Member2$Item$Member).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLCONFIG").resolveHandle("anon1dd3type");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 163 */         public static final Enum LOCAL = Enum.forString("##local");
/*     */ 
/*     */ 
/*     */         
/*     */         public static final int INT_LOCAL = 1;
/*     */ 
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
/*     */         
/*     */         public static final class Enum
/*     */           extends StringEnumAbstractBase
/*     */         {
/*     */           static final int INT_LOCAL = 1;
/*     */ 
/*     */ 
/*     */           
/*     */           public static Enum forString(String param4String) {
/* 188 */             return (Enum)table.forString(param4String);
/*     */           }
/*     */ 
/*     */           
/*     */           public static Enum forInt(int param4Int) {
/* 193 */             return (Enum)table.forInt(param4Int);
/*     */           }
/*     */           private Enum(String param4String, int param4Int) {
/* 196 */             super(param4String, param4Int);
/*     */           }
/*     */ 
/*     */           
/* 200 */           public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("##local", 1) });
/*     */ 
/*     */ 
/*     */           
/*     */           private static final long serialVersionUID = 1L;
/*     */ 
/*     */ 
/*     */           
/*     */           private Object readResolve() {
/* 209 */             return forInt(intValue());
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
/* 220 */             return (NamespaceList.Member2.Item.Member)NamespaceList.Member2.Item.Member.type.newValue(param4Object);
/*     */           }
/*     */           public static NamespaceList.Member2.Item.Member newInstance() {
/* 223 */             return (NamespaceList.Member2.Item.Member)XmlBeans.getContextTypeLoader().newInstance(NamespaceList.Member2.Item.Member.type, null);
/*     */           }
/*     */           public static NamespaceList.Member2.Item.Member newInstance(XmlOptions param4XmlOptions) {
/* 226 */             return (NamespaceList.Member2.Item.Member)XmlBeans.getContextTypeLoader().newInstance(NamespaceList.Member2.Item.Member.type, param4XmlOptions);
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
/* 240 */           return (NamespaceList.Member2.Item)NamespaceList.Member2.Item.type.newValue(param3Object);
/*     */         }
/*     */         public static NamespaceList.Member2.Item newInstance() {
/* 243 */           return (NamespaceList.Member2.Item)XmlBeans.getContextTypeLoader().newInstance(NamespaceList.Member2.Item.type, null);
/*     */         }
/*     */         public static NamespaceList.Member2.Item newInstance(XmlOptions param3XmlOptions) {
/* 246 */           return (NamespaceList.Member2.Item)XmlBeans.getContextTypeLoader().newInstance(NamespaceList.Member2.Item.type, param3XmlOptions);
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
/* 260 */         return (NamespaceList.Member2)NamespaceList.Member2.type.newValue(param2Object);
/*     */       }
/*     */       public static NamespaceList.Member2 newInstance() {
/* 263 */         return (NamespaceList.Member2)XmlBeans.getContextTypeLoader().newInstance(NamespaceList.Member2.type, null);
/*     */       }
/*     */       public static NamespaceList.Member2 newInstance(XmlOptions param2XmlOptions) {
/* 266 */         return (NamespaceList.Member2)XmlBeans.getContextTypeLoader().newInstance(NamespaceList.Member2.type, param2XmlOptions);
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
/* 280 */       return (NamespaceList)NamespaceList.type.newValue(param1Object);
/*     */     }
/*     */     public static NamespaceList newInstance() {
/* 283 */       return (NamespaceList)XmlBeans.getContextTypeLoader().newInstance(NamespaceList.type, null);
/*     */     }
/*     */     public static NamespaceList newInstance(XmlOptions param1XmlOptions) {
/* 286 */       return (NamespaceList)XmlBeans.getContextTypeLoader().newInstance(NamespaceList.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static NamespaceList parse(String param1String) throws XmlException {
/* 290 */       return (NamespaceList)XmlBeans.getContextTypeLoader().parse(param1String, NamespaceList.type, null);
/*     */     }
/*     */     public static NamespaceList parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/* 293 */       return (NamespaceList)XmlBeans.getContextTypeLoader().parse(param1String, NamespaceList.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static NamespaceList parse(File param1File) throws XmlException, IOException {
/* 297 */       return (NamespaceList)XmlBeans.getContextTypeLoader().parse(param1File, NamespaceList.type, null);
/*     */     }
/*     */     public static NamespaceList parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 300 */       return (NamespaceList)XmlBeans.getContextTypeLoader().parse(param1File, NamespaceList.type, param1XmlOptions);
/*     */     }
/*     */     public static NamespaceList parse(URL param1URL) throws XmlException, IOException {
/* 303 */       return (NamespaceList)XmlBeans.getContextTypeLoader().parse(param1URL, NamespaceList.type, null);
/*     */     }
/*     */     public static NamespaceList parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 306 */       return (NamespaceList)XmlBeans.getContextTypeLoader().parse(param1URL, NamespaceList.type, param1XmlOptions);
/*     */     }
/*     */     public static NamespaceList parse(InputStream param1InputStream) throws XmlException, IOException {
/* 309 */       return (NamespaceList)XmlBeans.getContextTypeLoader().parse(param1InputStream, NamespaceList.type, null);
/*     */     }
/*     */     public static NamespaceList parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 312 */       return (NamespaceList)XmlBeans.getContextTypeLoader().parse(param1InputStream, NamespaceList.type, param1XmlOptions);
/*     */     }
/*     */     public static NamespaceList parse(Reader param1Reader) throws XmlException, IOException {
/* 315 */       return (NamespaceList)XmlBeans.getContextTypeLoader().parse(param1Reader, NamespaceList.type, null);
/*     */     }
/*     */     public static NamespaceList parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 318 */       return (NamespaceList)XmlBeans.getContextTypeLoader().parse(param1Reader, NamespaceList.type, param1XmlOptions);
/*     */     }
/*     */     public static NamespaceList parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 321 */       return (NamespaceList)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, NamespaceList.type, null);
/*     */     }
/*     */     public static NamespaceList parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 324 */       return (NamespaceList)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, NamespaceList.type, param1XmlOptions);
/*     */     }
/*     */     public static NamespaceList parse(Node param1Node) throws XmlException {
/* 327 */       return (NamespaceList)XmlBeans.getContextTypeLoader().parse(param1Node, NamespaceList.type, null);
/*     */     }
/*     */     public static NamespaceList parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 330 */       return (NamespaceList)XmlBeans.getContextTypeLoader().parse(param1Node, NamespaceList.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static NamespaceList parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 334 */       return (NamespaceList)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, NamespaceList.type, null);
/*     */     }
/*     */     
/*     */     public static NamespaceList parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 338 */       return (NamespaceList)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, NamespaceList.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 342 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, NamespaceList.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 346 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, NamespaceList.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xmlconfig\NamespaceList.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */