/*     */ package org.apache.xmlbeans.impl.common;
/*     */ 
/*     */ import javax.xml.stream.XMLStreamException;
/*     */ import javax.xml.stream.XMLStreamReader;
/*     */ import javax.xml.stream.XMLStreamWriter;
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
/*     */ public final class XmlReaderToWriter
/*     */ {
/*     */   public static void writeAll(XMLStreamReader paramXMLStreamReader, XMLStreamWriter paramXMLStreamWriter) throws XMLStreamException {
/*  33 */     while (paramXMLStreamReader.hasNext()) {
/*  34 */       write(paramXMLStreamReader, paramXMLStreamWriter);
/*  35 */       paramXMLStreamReader.next();
/*     */     } 
/*  37 */     write(paramXMLStreamReader, paramXMLStreamWriter);
/*  38 */     paramXMLStreamWriter.flush(); } public static void write(XMLStreamReader paramXMLStreamReader, XMLStreamWriter paramXMLStreamWriter) throws XMLStreamException { String str1;
/*     */     String str2;
/*     */     byte b;
/*     */     String str3;
/*     */     int i;
/*     */     String str4;
/*  44 */     switch (paramXMLStreamReader.getEventType()) {
/*     */       case 1:
/*  46 */         str1 = paramXMLStreamReader.getLocalName();
/*  47 */         str2 = paramXMLStreamReader.getNamespaceURI();
/*  48 */         if (str2 != null && str2.length() > 0)
/*  49 */         { String str = paramXMLStreamReader.getPrefix();
/*  50 */           if (str != null) {
/*  51 */             paramXMLStreamWriter.writeStartElement(str, str1, str2);
/*     */           } else {
/*     */             
/*  54 */             paramXMLStreamWriter.writeStartElement(str2, str1);
/*     */           }  }
/*  56 */         else { paramXMLStreamWriter.writeStartElement(str1); }
/*     */ 
/*     */         
/*  59 */         for (b = 0, i = paramXMLStreamReader.getNamespaceCount(); b < i; b++) {
/*  60 */           paramXMLStreamWriter.writeNamespace(paramXMLStreamReader.getNamespacePrefix(b), paramXMLStreamReader.getNamespaceURI(b));
/*     */         }
/*     */ 
/*     */         
/*  64 */         for (b = 0, i = paramXMLStreamReader.getAttributeCount(); b < i; b++) {
/*  65 */           String str = paramXMLStreamReader.getAttributeNamespace(b);
/*  66 */           if (str != null) {
/*  67 */             paramXMLStreamWriter.writeAttribute(str, paramXMLStreamReader.getAttributeLocalName(b), paramXMLStreamReader.getAttributeValue(b));
/*     */           }
/*     */           else {
/*     */             
/*  71 */             paramXMLStreamWriter.writeAttribute(paramXMLStreamReader.getAttributeLocalName(b), paramXMLStreamReader.getAttributeValue(b));
/*     */           } 
/*     */         } 
/*     */         break;
/*     */       case 2:
/*  76 */         paramXMLStreamWriter.writeEndElement();
/*     */         break;
/*     */       case 4:
/*     */       case 6:
/*  80 */         paramXMLStreamWriter.writeCharacters(paramXMLStreamReader.getTextCharacters(), paramXMLStreamReader.getTextStart(), paramXMLStreamReader.getTextLength());
/*     */         break;
/*     */ 
/*     */       
/*     */       case 3:
/*  85 */         paramXMLStreamWriter.writeProcessingInstruction(paramXMLStreamReader.getPITarget(), paramXMLStreamReader.getPIData());
/*     */         break;
/*     */       
/*     */       case 12:
/*  89 */         paramXMLStreamWriter.writeCData(paramXMLStreamReader.getText());
/*     */         break;
/*     */       
/*     */       case 5:
/*  93 */         paramXMLStreamWriter.writeComment(paramXMLStreamReader.getText());
/*     */         break;
/*     */       case 9:
/*  96 */         paramXMLStreamWriter.writeEntityRef(paramXMLStreamReader.getLocalName());
/*     */         break;
/*     */       case 7:
/*  99 */         str3 = paramXMLStreamReader.getCharacterEncodingScheme();
/* 100 */         str4 = paramXMLStreamReader.getVersion();
/*     */         
/* 102 */         if (str3 != null && str4 != null) {
/* 103 */           paramXMLStreamWriter.writeStartDocument(str3, str4); break;
/*     */         } 
/* 105 */         if (str4 != null)
/* 106 */           paramXMLStreamWriter.writeStartDocument(paramXMLStreamReader.getVersion()); 
/*     */         break;
/*     */       case 8:
/* 109 */         paramXMLStreamWriter.writeEndDocument();
/*     */         break;
/*     */       case 11:
/* 112 */         paramXMLStreamWriter.writeDTD(paramXMLStreamReader.getText());
/*     */         break;
/*     */     }  }
/*     */ 
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\common\XmlReaderToWriter.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */