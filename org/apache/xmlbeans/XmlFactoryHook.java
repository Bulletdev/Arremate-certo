/*     */ package org.apache.xmlbeans;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.lang.ref.SoftReference;
/*     */ import javax.xml.stream.XMLStreamReader;
/*     */ import org.apache.xmlbeans.xml.stream.XMLInputStream;
/*     */ import org.apache.xmlbeans.xml.stream.XMLStreamException;
/*     */ import org.w3c.dom.DOMImplementation;
/*     */ import org.w3c.dom.Node;
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
/*     */ public interface XmlFactoryHook
/*     */ {
/*     */   XmlObject newInstance(SchemaTypeLoader paramSchemaTypeLoader, SchemaType paramSchemaType, XmlOptions paramXmlOptions);
/*     */   
/*     */   XmlObject parse(SchemaTypeLoader paramSchemaTypeLoader, String paramString, SchemaType paramSchemaType, XmlOptions paramXmlOptions) throws XmlException;
/*     */   
/*     */   XmlObject parse(SchemaTypeLoader paramSchemaTypeLoader, InputStream paramInputStream, SchemaType paramSchemaType, XmlOptions paramXmlOptions) throws XmlException, IOException;
/*     */   
/*     */   XmlObject parse(SchemaTypeLoader paramSchemaTypeLoader, XMLStreamReader paramXMLStreamReader, SchemaType paramSchemaType, XmlOptions paramXmlOptions) throws XmlException;
/*     */   
/*     */   XmlObject parse(SchemaTypeLoader paramSchemaTypeLoader, Reader paramReader, SchemaType paramSchemaType, XmlOptions paramXmlOptions) throws XmlException, IOException;
/*     */   
/*     */   XmlObject parse(SchemaTypeLoader paramSchemaTypeLoader, Node paramNode, SchemaType paramSchemaType, XmlOptions paramXmlOptions) throws XmlException;
/*     */   
/*     */   XmlObject parse(SchemaTypeLoader paramSchemaTypeLoader, XMLInputStream paramXMLInputStream, SchemaType paramSchemaType, XmlOptions paramXmlOptions) throws XmlException, XMLStreamException;
/*     */   
/*     */   XmlSaxHandler newXmlSaxHandler(SchemaTypeLoader paramSchemaTypeLoader, SchemaType paramSchemaType, XmlOptions paramXmlOptions);
/*     */   
/*     */   DOMImplementation newDomImplementation(SchemaTypeLoader paramSchemaTypeLoader, XmlOptions paramXmlOptions);
/*     */   
/*     */   public static final class ThreadContext
/*     */   {
/*  93 */     private static ThreadLocal threadHook = new ThreadLocal();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlFactoryHook getHook() {
/* 100 */       SoftReference softReference = threadHook.get();
/* 101 */       return (softReference == null) ? null : softReference.get();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static void setHook(XmlFactoryHook param1XmlFactoryHook) {
/* 109 */       threadHook.set(new SoftReference(param1XmlFactoryHook));
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\XmlFactoryHook.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */