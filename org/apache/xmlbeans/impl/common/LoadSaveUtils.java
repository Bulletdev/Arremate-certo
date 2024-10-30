/*     */ package org.apache.xmlbeans.impl.common;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import javax.xml.parsers.ParserConfigurationException;
/*     */ import javax.xml.parsers.SAXParser;
/*     */ import javax.xml.parsers.SAXParserFactory;
/*     */ import javax.xml.stream.XMLOutputFactory;
/*     */ import javax.xml.stream.XMLStreamException;
/*     */ import javax.xml.stream.XMLStreamReader;
/*     */ import javax.xml.stream.XMLStreamWriter;
/*     */ import org.w3c.dom.Document;
/*     */ import org.xml.sax.SAXException;
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
/*     */ public class LoadSaveUtils
/*     */ {
/*     */   public static Document xmlText2GenericDom(InputStream paramInputStream, Document paramDocument) throws SAXException, ParserConfigurationException, IOException {
/*  43 */     SAXParserFactory sAXParserFactory = SAXParserFactory.newInstance();
/*  44 */     sAXParserFactory.setNamespaceAware(true);
/*     */     
/*  46 */     SAXParser sAXParser = sAXParserFactory.newSAXParser();
/*     */     
/*  48 */     Sax2Dom sax2Dom = new Sax2Dom(paramDocument);
/*     */     
/*  50 */     sAXParser.setProperty("http://xml.org/sax/properties/lexical-handler", sax2Dom);
/*  51 */     sAXParser.parse(paramInputStream, sax2Dom);
/*     */     
/*  53 */     return (Document)sax2Dom.getDOM();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void xmlStreamReader2XmlText(XMLStreamReader paramXMLStreamReader, OutputStream paramOutputStream) throws XMLStreamException {
/*  60 */     XMLStreamWriter xMLStreamWriter = XMLOutputFactory.newInstance().createXMLStreamWriter(paramOutputStream);
/*     */     
/*  62 */     while (paramXMLStreamReader.hasNext()) {
/*     */       int i, j; byte b;
/*  64 */       switch (paramXMLStreamReader.getEventType()) {
/*     */         
/*     */         case 10:
/*  67 */           xMLStreamWriter.writeAttribute(paramXMLStreamReader.getPrefix(), paramXMLStreamReader.getNamespaceURI(), paramXMLStreamReader.getLocalName(), paramXMLStreamReader.getText());
/*     */           break;
/*     */         
/*     */         case 12:
/*  71 */           xMLStreamWriter.writeCData(paramXMLStreamReader.getText());
/*     */           break;
/*     */         
/*     */         case 4:
/*  75 */           xMLStreamWriter.writeCharacters(paramXMLStreamReader.getText());
/*     */           break;
/*     */         
/*     */         case 5:
/*  79 */           xMLStreamWriter.writeComment(paramXMLStreamReader.getText());
/*     */           break;
/*     */         
/*     */         case 11:
/*  83 */           xMLStreamWriter.writeDTD(paramXMLStreamReader.getText());
/*     */           break;
/*     */         
/*     */         case 8:
/*  87 */           xMLStreamWriter.writeEndDocument();
/*     */           break;
/*     */         
/*     */         case 2:
/*  91 */           xMLStreamWriter.writeEndElement();
/*     */           break;
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         case 9:
/*  98 */           xMLStreamWriter.writeEntityRef(paramXMLStreamReader.getText());
/*     */           break;
/*     */         
/*     */         case 13:
/* 102 */           xMLStreamWriter.writeNamespace(paramXMLStreamReader.getPrefix(), paramXMLStreamReader.getNamespaceURI());
/*     */           break;
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         case 3:
/* 109 */           xMLStreamWriter.writeProcessingInstruction(paramXMLStreamReader.getPITarget(), paramXMLStreamReader.getPIData());
/*     */           break;
/*     */         
/*     */         case 6:
/* 113 */           xMLStreamWriter.writeCharacters(paramXMLStreamReader.getText());
/*     */           break;
/*     */         
/*     */         case 7:
/* 117 */           xMLStreamWriter.writeStartDocument();
/*     */           break;
/*     */         
/*     */         case 1:
/* 121 */           xMLStreamWriter.writeStartElement((paramXMLStreamReader.getPrefix() == null) ? "" : paramXMLStreamReader.getPrefix(), paramXMLStreamReader.getLocalName(), paramXMLStreamReader.getNamespaceURI());
/*     */           
/* 123 */           i = paramXMLStreamReader.getAttributeCount();
/* 124 */           for (j = i - 1; j >= 0; j--)
/*     */           {
/* 126 */             xMLStreamWriter.writeAttribute((paramXMLStreamReader.getAttributePrefix(j) == null) ? "" : paramXMLStreamReader.getAttributePrefix(j), paramXMLStreamReader.getAttributeNamespace(j), paramXMLStreamReader.getAttributeLocalName(j), paramXMLStreamReader.getAttributeValue(j));
/*     */           }
/*     */           
/* 129 */           j = paramXMLStreamReader.getNamespaceCount();
/* 130 */           for (b = 0; b < j; b++)
/*     */           {
/* 132 */             xMLStreamWriter.writeNamespace(paramXMLStreamReader.getNamespacePrefix(b), paramXMLStreamReader.getNamespaceURI(b));
/*     */           }
/*     */           break;
/*     */       } 
/* 136 */       paramXMLStreamReader.next();
/*     */     } 
/* 138 */     xMLStreamWriter.flush();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\common\LoadSaveUtils.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */