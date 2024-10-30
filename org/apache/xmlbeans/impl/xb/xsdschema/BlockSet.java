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
/*     */ public interface BlockSet
/*     */   extends XmlAnySimpleType
/*     */ {
/*     */   Object getObjectValue();
/*     */   
/*  27 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$BlockSet == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$BlockSet = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.BlockSet")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$BlockSet).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("blockset815etype");
/*     */   
/*     */   void setObjectValue(Object paramObject);
/*     */   
/*     */   Object objectValue();
/*     */   
/*     */   void objectSet(Object paramObject);
/*     */   
/*     */   SchemaType instanceType();
/*     */   
/*  37 */   public static interface Member extends XmlToken { public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((BlockSet.null.class$org$apache$xmlbeans$impl$xb$xsdschema$BlockSet$Member == null) ? (BlockSet.null.class$org$apache$xmlbeans$impl$xb$xsdschema$BlockSet$Member = BlockSet.null.class$("org.apache.xmlbeans.impl.xb.xsdschema.BlockSet$Member")) : BlockSet.null.class$org$apache$xmlbeans$impl$xb$xsdschema$BlockSet$Member).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("anon0683type");
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
/*     */       public static BlockSet.Member newValue(Object param2Object) {
/* 100 */         return (BlockSet.Member)BlockSet.Member.type.newValue(param2Object);
/*     */       }
/*     */       public static BlockSet.Member newInstance() {
/* 103 */         return (BlockSet.Member)XmlBeans.getContextTypeLoader().newInstance(BlockSet.Member.type, null);
/*     */       }
/*     */       public static BlockSet.Member newInstance(XmlOptions param2XmlOptions) {
/* 106 */         return (BlockSet.Member)XmlBeans.getContextTypeLoader().newInstance(BlockSet.Member.type, param2XmlOptions);
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
/* 128 */     public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((BlockSet.null.class$org$apache$xmlbeans$impl$xb$xsdschema$BlockSet$Member2 == null) ? (BlockSet.null.class$org$apache$xmlbeans$impl$xb$xsdschema$BlockSet$Member2 = BlockSet.null.class$("org.apache.xmlbeans.impl.xb.xsdschema.BlockSet$Member2")) : BlockSet.null.class$org$apache$xmlbeans$impl$xb$xsdschema$BlockSet$Member2).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("anonc904type");
/*     */     
/*     */     List listValue();
/*     */     
/*     */     List xlistValue();
/*     */     
/*     */     void set(List param1List);
/*     */     
/*     */     public static interface Item
/*     */       extends DerivationControl {
/* 138 */       public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((BlockSet.null.class$org$apache$xmlbeans$impl$xb$xsdschema$BlockSet$Member2$Item == null) ? (BlockSet.null.class$org$apache$xmlbeans$impl$xb$xsdschema$BlockSet$Member2$Item = BlockSet.null.class$("org.apache.xmlbeans.impl.xb.xsdschema.BlockSet$Member2$Item")) : BlockSet.null.class$org$apache$xmlbeans$impl$xb$xsdschema$BlockSet$Member2$Item).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("anon421ctype");
/*     */ 
/*     */       
/* 141 */       public static final DerivationControl.Enum EXTENSION = DerivationControl.EXTENSION;
/* 142 */       public static final DerivationControl.Enum RESTRICTION = DerivationControl.RESTRICTION;
/* 143 */       public static final DerivationControl.Enum SUBSTITUTION = DerivationControl.SUBSTITUTION;
/*     */ 
/*     */       
/*     */       public static final int INT_EXTENSION = 2;
/*     */ 
/*     */       
/*     */       public static final int INT_RESTRICTION = 3;
/*     */       
/*     */       public static final int INT_SUBSTITUTION = 1;
/*     */ 
/*     */       
/*     */       public static final class Factory
/*     */       {
/*     */         public static BlockSet.Member2.Item newValue(Object param3Object) {
/* 157 */           return (BlockSet.Member2.Item)BlockSet.Member2.Item.type.newValue(param3Object);
/*     */         }
/*     */         public static BlockSet.Member2.Item newInstance() {
/* 160 */           return (BlockSet.Member2.Item)XmlBeans.getContextTypeLoader().newInstance(BlockSet.Member2.Item.type, null);
/*     */         }
/*     */         public static BlockSet.Member2.Item newInstance(XmlOptions param3XmlOptions) {
/* 163 */           return (BlockSet.Member2.Item)XmlBeans.getContextTypeLoader().newInstance(BlockSet.Member2.Item.type, param3XmlOptions);
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
/*     */       public static BlockSet.Member2 newValue(Object param2Object) {
/* 177 */         return (BlockSet.Member2)BlockSet.Member2.type.newValue(param2Object);
/*     */       }
/*     */       public static BlockSet.Member2 newInstance() {
/* 180 */         return (BlockSet.Member2)XmlBeans.getContextTypeLoader().newInstance(BlockSet.Member2.type, null);
/*     */       }
/*     */       public static BlockSet.Member2 newInstance(XmlOptions param2XmlOptions) {
/* 183 */         return (BlockSet.Member2)XmlBeans.getContextTypeLoader().newInstance(BlockSet.Member2.type, param2XmlOptions);
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
/*     */     public static BlockSet newValue(Object param1Object) {
/* 197 */       return (BlockSet)BlockSet.type.newValue(param1Object);
/*     */     }
/*     */     public static BlockSet newInstance() {
/* 200 */       return (BlockSet)XmlBeans.getContextTypeLoader().newInstance(BlockSet.type, null);
/*     */     }
/*     */     public static BlockSet newInstance(XmlOptions param1XmlOptions) {
/* 203 */       return (BlockSet)XmlBeans.getContextTypeLoader().newInstance(BlockSet.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static BlockSet parse(String param1String) throws XmlException {
/* 207 */       return (BlockSet)XmlBeans.getContextTypeLoader().parse(param1String, BlockSet.type, null);
/*     */     }
/*     */     public static BlockSet parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/* 210 */       return (BlockSet)XmlBeans.getContextTypeLoader().parse(param1String, BlockSet.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static BlockSet parse(File param1File) throws XmlException, IOException {
/* 214 */       return (BlockSet)XmlBeans.getContextTypeLoader().parse(param1File, BlockSet.type, null);
/*     */     }
/*     */     public static BlockSet parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 217 */       return (BlockSet)XmlBeans.getContextTypeLoader().parse(param1File, BlockSet.type, param1XmlOptions);
/*     */     }
/*     */     public static BlockSet parse(URL param1URL) throws XmlException, IOException {
/* 220 */       return (BlockSet)XmlBeans.getContextTypeLoader().parse(param1URL, BlockSet.type, null);
/*     */     }
/*     */     public static BlockSet parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 223 */       return (BlockSet)XmlBeans.getContextTypeLoader().parse(param1URL, BlockSet.type, param1XmlOptions);
/*     */     }
/*     */     public static BlockSet parse(InputStream param1InputStream) throws XmlException, IOException {
/* 226 */       return (BlockSet)XmlBeans.getContextTypeLoader().parse(param1InputStream, BlockSet.type, null);
/*     */     }
/*     */     public static BlockSet parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 229 */       return (BlockSet)XmlBeans.getContextTypeLoader().parse(param1InputStream, BlockSet.type, param1XmlOptions);
/*     */     }
/*     */     public static BlockSet parse(Reader param1Reader) throws XmlException, IOException {
/* 232 */       return (BlockSet)XmlBeans.getContextTypeLoader().parse(param1Reader, BlockSet.type, null);
/*     */     }
/*     */     public static BlockSet parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 235 */       return (BlockSet)XmlBeans.getContextTypeLoader().parse(param1Reader, BlockSet.type, param1XmlOptions);
/*     */     }
/*     */     public static BlockSet parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 238 */       return (BlockSet)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, BlockSet.type, null);
/*     */     }
/*     */     public static BlockSet parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 241 */       return (BlockSet)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, BlockSet.type, param1XmlOptions);
/*     */     }
/*     */     public static BlockSet parse(Node param1Node) throws XmlException {
/* 244 */       return (BlockSet)XmlBeans.getContextTypeLoader().parse(param1Node, BlockSet.type, null);
/*     */     }
/*     */     public static BlockSet parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 247 */       return (BlockSet)XmlBeans.getContextTypeLoader().parse(param1Node, BlockSet.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static BlockSet parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 251 */       return (BlockSet)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, BlockSet.type, null);
/*     */     }
/*     */     
/*     */     public static BlockSet parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 255 */       return (BlockSet)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, BlockSet.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 259 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, BlockSet.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 263 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, BlockSet.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\BlockSet.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */