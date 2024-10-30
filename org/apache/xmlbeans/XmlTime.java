/*     */ package org.apache.xmlbeans;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.net.URL;
/*     */ import java.util.Calendar;
/*     */ import javax.xml.stream.XMLStreamReader;
/*     */ import org.apache.xmlbeans.xml.stream.XMLInputStream;
/*     */ import org.apache.xmlbeans.xml.stream.XMLStreamException;
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
/*     */ public interface XmlTime
/*     */   extends XmlAnySimpleType
/*     */ {
/*  37 */   public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_time");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Calendar getCalendarValue();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setCalendarValue(Calendar paramCalendar);
/*     */ 
/*     */ 
/*     */   
/*     */   GDate getGDateValue();
/*     */ 
/*     */ 
/*     */   
/*     */   void setGDateValue(GDate paramGDate);
/*     */ 
/*     */ 
/*     */   
/*     */   Calendar calendarValue();
/*     */ 
/*     */ 
/*     */   
/*     */   void set(Calendar paramCalendar);
/*     */ 
/*     */ 
/*     */   
/*     */   GDate gDateValue();
/*     */ 
/*     */ 
/*     */   
/*     */   void set(GDateSpecification paramGDateSpecification);
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static XmlTime newInstance() {
/*  78 */       return (XmlTime)XmlBeans.getContextTypeLoader().newInstance(XmlTime.type, null);
/*     */     }
/*     */     
/*     */     public static XmlTime newInstance(XmlOptions param1XmlOptions) {
/*  82 */       return (XmlTime)XmlBeans.getContextTypeLoader().newInstance(XmlTime.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlTime newValue(Object param1Object) {
/*  86 */       return (XmlTime)XmlTime.type.newValue(param1Object);
/*     */     }
/*     */     
/*     */     public static XmlTime parse(String param1String) throws XmlException {
/*  90 */       return (XmlTime)XmlBeans.getContextTypeLoader().parse(param1String, XmlTime.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlTime parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  94 */       return (XmlTime)XmlBeans.getContextTypeLoader().parse(param1String, XmlTime.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlTime parse(File param1File) throws XmlException, IOException {
/*  98 */       return (XmlTime)XmlBeans.getContextTypeLoader().parse(param1File, XmlTime.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlTime parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 102 */       return (XmlTime)XmlBeans.getContextTypeLoader().parse(param1File, XmlTime.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlTime parse(URL param1URL) throws XmlException, IOException {
/* 106 */       return (XmlTime)XmlBeans.getContextTypeLoader().parse(param1URL, XmlTime.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlTime parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 110 */       return (XmlTime)XmlBeans.getContextTypeLoader().parse(param1URL, XmlTime.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlTime parse(InputStream param1InputStream) throws XmlException, IOException {
/* 114 */       return (XmlTime)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlTime.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlTime parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 118 */       return (XmlTime)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlTime.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlTime parse(Reader param1Reader) throws XmlException, IOException {
/* 122 */       return (XmlTime)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlTime.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlTime parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 126 */       return (XmlTime)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlTime.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlTime parse(Node param1Node) throws XmlException {
/* 130 */       return (XmlTime)XmlBeans.getContextTypeLoader().parse(param1Node, XmlTime.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlTime parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 134 */       return (XmlTime)XmlBeans.getContextTypeLoader().parse(param1Node, XmlTime.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlTime parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 140 */       return (XmlTime)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlTime.type, (XmlOptions)null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlTime parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 146 */       return (XmlTime)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlTime.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlTime parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 150 */       return (XmlTime)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlTime.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlTime parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 154 */       return (XmlTime)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlTime.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 160 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlTime.type, null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 166 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlTime.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\XmlTime.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */