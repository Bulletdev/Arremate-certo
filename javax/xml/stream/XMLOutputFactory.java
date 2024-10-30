/*     */ package javax.xml.stream;
/*     */ 
/*     */ import java.io.OutputStream;
/*     */ import java.io.Writer;
/*     */ import javax.xml.transform.Result;
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
/*     */ public abstract class XMLOutputFactory
/*     */ {
/*     */   public static final String IS_REPAIRING_NAMESPACES = "javax.xml.stream.isRepairingNamespaces";
/*     */   
/*     */   public static XMLOutputFactory newInstance() throws FactoryConfigurationError {
/* 101 */     return (XMLOutputFactory)FactoryFinder.find("javax.xml.stream.XMLOutputFactory", "com.bea.xml.stream.XMLOutputFactoryBase");
/*     */   }
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
/*     */   public static XMLOutputFactory newInstance(String paramString, ClassLoader paramClassLoader) throws FactoryConfigurationError {
/* 118 */     return (XMLOutputFactory)FactoryFinder.find(paramString, "com.bea.xml.stream.XMLOutputFactoryBase", paramClassLoader);
/*     */   }
/*     */   
/*     */   public abstract XMLStreamWriter createXMLStreamWriter(Writer paramWriter) throws XMLStreamException;
/*     */   
/*     */   public abstract XMLStreamWriter createXMLStreamWriter(OutputStream paramOutputStream) throws XMLStreamException;
/*     */   
/*     */   public abstract XMLStreamWriter createXMLStreamWriter(OutputStream paramOutputStream, String paramString) throws XMLStreamException;
/*     */   
/*     */   public abstract XMLStreamWriter createXMLStreamWriter(Result paramResult) throws XMLStreamException;
/*     */   
/*     */   public abstract XMLEventWriter createXMLEventWriter(Result paramResult) throws XMLStreamException;
/*     */   
/*     */   public abstract XMLEventWriter createXMLEventWriter(OutputStream paramOutputStream) throws XMLStreamException;
/*     */   
/*     */   public abstract XMLEventWriter createXMLEventWriter(OutputStream paramOutputStream, String paramString) throws XMLStreamException;
/*     */   
/*     */   public abstract XMLEventWriter createXMLEventWriter(Writer paramWriter) throws XMLStreamException;
/*     */   
/*     */   public abstract void setProperty(String paramString, Object paramObject) throws IllegalArgumentException;
/*     */   
/*     */   public abstract Object getProperty(String paramString) throws IllegalArgumentException;
/*     */   
/*     */   public abstract boolean isPropertySupported(String paramString);
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\javax\xml\stream\XMLOutputFactory.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */