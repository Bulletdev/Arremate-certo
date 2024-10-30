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
/*     */ public interface XmlGMonth
/*     */   extends XmlAnySimpleType
/*     */ {
/*  37 */   public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_gMonth");
/*     */ 
/*     */ 
/*     */   
/*     */   Calendar getCalendarValue();
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
/*     */   int getIntValue();
/*     */ 
/*     */ 
/*     */   
/*     */   void setIntValue(int paramInt);
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
/*     */   int intValue();
/*     */ 
/*     */ 
/*     */   
/*     */   void set(int paramInt);
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static XmlGMonth newInstance() {
/*  91 */       return (XmlGMonth)XmlBeans.getContextTypeLoader().newInstance(XmlGMonth.type, null);
/*     */     }
/*     */     
/*     */     public static XmlGMonth newInstance(XmlOptions param1XmlOptions) {
/*  95 */       return (XmlGMonth)XmlBeans.getContextTypeLoader().newInstance(XmlGMonth.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlGMonth newValue(Object param1Object) {
/*  99 */       return (XmlGMonth)XmlGMonth.type.newValue(param1Object);
/*     */     }
/*     */     
/*     */     public static XmlGMonth parse(String param1String) throws XmlException {
/* 103 */       return (XmlGMonth)XmlBeans.getContextTypeLoader().parse(param1String, XmlGMonth.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlGMonth parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/* 107 */       return (XmlGMonth)XmlBeans.getContextTypeLoader().parse(param1String, XmlGMonth.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlGMonth parse(File param1File) throws XmlException, IOException {
/* 111 */       return (XmlGMonth)XmlBeans.getContextTypeLoader().parse(param1File, XmlGMonth.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlGMonth parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 115 */       return (XmlGMonth)XmlBeans.getContextTypeLoader().parse(param1File, XmlGMonth.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlGMonth parse(URL param1URL) throws XmlException, IOException {
/* 119 */       return (XmlGMonth)XmlBeans.getContextTypeLoader().parse(param1URL, XmlGMonth.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlGMonth parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 123 */       return (XmlGMonth)XmlBeans.getContextTypeLoader().parse(param1URL, XmlGMonth.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlGMonth parse(InputStream param1InputStream) throws XmlException, IOException {
/* 127 */       return (XmlGMonth)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlGMonth.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlGMonth parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 131 */       return (XmlGMonth)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlGMonth.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlGMonth parse(Reader param1Reader) throws XmlException, IOException {
/* 135 */       return (XmlGMonth)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlGMonth.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlGMonth parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 139 */       return (XmlGMonth)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlGMonth.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlGMonth parse(Node param1Node) throws XmlException {
/* 143 */       return (XmlGMonth)XmlBeans.getContextTypeLoader().parse(param1Node, XmlGMonth.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlGMonth parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 147 */       return (XmlGMonth)XmlBeans.getContextTypeLoader().parse(param1Node, XmlGMonth.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlGMonth parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 153 */       return (XmlGMonth)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlGMonth.type, (XmlOptions)null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlGMonth parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 159 */       return (XmlGMonth)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlGMonth.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlGMonth parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 163 */       return (XmlGMonth)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlGMonth.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlGMonth parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 167 */       return (XmlGMonth)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlGMonth.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 173 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlGMonth.type, null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 179 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlGMonth.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\XmlGMonth.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */