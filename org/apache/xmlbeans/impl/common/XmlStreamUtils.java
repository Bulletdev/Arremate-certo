/*     */ package org.apache.xmlbeans.impl.common;
/*     */ 
/*     */ import javax.xml.stream.XMLStreamReader;
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
/*     */ public final class XmlStreamUtils
/*     */ {
/*     */   public static String printEvent(XMLStreamReader paramXMLStreamReader) {
/*     */     int i, j;
/*     */     String str1, str2;
/*  27 */     StringBuffer stringBuffer = new StringBuffer();
/*  28 */     stringBuffer.append("EVENT:[" + paramXMLStreamReader.getLocation().getLineNumber() + "][" + paramXMLStreamReader.getLocation().getColumnNumber() + "] ");
/*     */     
/*  30 */     stringBuffer.append(getName(paramXMLStreamReader.getEventType()));
/*  31 */     stringBuffer.append(" [");
/*  32 */     switch (paramXMLStreamReader.getEventType()) {
/*     */       case 1:
/*  34 */         stringBuffer.append("<");
/*  35 */         printName(paramXMLStreamReader, stringBuffer);
/*  36 */         for (i = 0; i < paramXMLStreamReader.getNamespaceCount(); i++) {
/*  37 */           stringBuffer.append(" ");
/*  38 */           String str = paramXMLStreamReader.getNamespacePrefix(i);
/*  39 */           if ("xmlns".equals(str)) {
/*  40 */             stringBuffer.append("xmlns=\"" + paramXMLStreamReader.getNamespaceURI(i) + "\"");
/*     */           } else {
/*  42 */             stringBuffer.append("xmlns:" + str);
/*  43 */             stringBuffer.append("=\"");
/*  44 */             stringBuffer.append(paramXMLStreamReader.getNamespaceURI(i));
/*  45 */             stringBuffer.append("\"");
/*     */           } 
/*     */         } 
/*     */         
/*  49 */         for (i = 0; i < paramXMLStreamReader.getAttributeCount(); i++) {
/*  50 */           stringBuffer.append(" ");
/*  51 */           printName(paramXMLStreamReader.getAttributePrefix(i), paramXMLStreamReader.getAttributeNamespace(i), paramXMLStreamReader.getAttributeLocalName(i), stringBuffer);
/*     */ 
/*     */ 
/*     */           
/*  55 */           stringBuffer.append("=\"");
/*  56 */           stringBuffer.append(paramXMLStreamReader.getAttributeValue(i));
/*  57 */           stringBuffer.append("\"");
/*     */         } 
/*     */         
/*  60 */         stringBuffer.append(">");
/*     */         break;
/*     */       case 2:
/*  63 */         stringBuffer.append("</");
/*  64 */         printName(paramXMLStreamReader, stringBuffer);
/*  65 */         for (i = 0; i < paramXMLStreamReader.getNamespaceCount(); i++) {
/*  66 */           stringBuffer.append(" ");
/*  67 */           String str = paramXMLStreamReader.getNamespacePrefix(i);
/*  68 */           if ("xmlns".equals(str)) {
/*  69 */             stringBuffer.append("xmlns=\"" + paramXMLStreamReader.getNamespaceURI(i) + "\"");
/*     */           } else {
/*  71 */             stringBuffer.append("xmlns:" + str);
/*  72 */             stringBuffer.append("=\"");
/*  73 */             stringBuffer.append(paramXMLStreamReader.getNamespaceURI(i));
/*  74 */             stringBuffer.append("\"");
/*     */           } 
/*     */         } 
/*  77 */         stringBuffer.append(">");
/*     */         break;
/*     */       
/*     */       case 4:
/*     */       case 6:
/*  82 */         i = paramXMLStreamReader.getTextStart();
/*  83 */         j = paramXMLStreamReader.getTextLength();
/*  84 */         stringBuffer.append(new String(paramXMLStreamReader.getTextCharacters(), i, j));
/*     */         break;
/*     */ 
/*     */       
/*     */       case 3:
/*  89 */         str1 = paramXMLStreamReader.getPITarget();
/*  90 */         if (str1 == null) str1 = ""; 
/*  91 */         str2 = paramXMLStreamReader.getPIData();
/*  92 */         if (str2 == null) str2 = ""; 
/*  93 */         stringBuffer.append("<?");
/*  94 */         stringBuffer.append(str1 + " " + str2);
/*  95 */         stringBuffer.append("?>");
/*     */         break;
/*     */       case 12:
/*  98 */         stringBuffer.append("<![CDATA[");
/*  99 */         if (paramXMLStreamReader.hasText())
/* 100 */           stringBuffer.append(paramXMLStreamReader.getText()); 
/* 101 */         stringBuffer.append("]]>");
/*     */         break;
/*     */       
/*     */       case 5:
/* 105 */         stringBuffer.append("<!--");
/* 106 */         if (paramXMLStreamReader.hasText())
/* 107 */           stringBuffer.append(paramXMLStreamReader.getText()); 
/* 108 */         stringBuffer.append("-->");
/*     */         break;
/*     */       case 9:
/* 111 */         stringBuffer.append(paramXMLStreamReader.getLocalName() + "=");
/* 112 */         if (paramXMLStreamReader.hasText())
/* 113 */           stringBuffer.append("[" + paramXMLStreamReader.getText() + "]"); 
/*     */         break;
/*     */       case 7:
/* 116 */         stringBuffer.append("<?xml");
/* 117 */         stringBuffer.append(" version='" + paramXMLStreamReader.getVersion() + "'");
/* 118 */         stringBuffer.append(" encoding='" + paramXMLStreamReader.getCharacterEncodingScheme() + "'");
/* 119 */         if (paramXMLStreamReader.isStandalone()) {
/* 120 */           stringBuffer.append(" standalone='yes'");
/*     */         } else {
/* 122 */           stringBuffer.append(" standalone='no'");
/* 123 */         }  stringBuffer.append("?>");
/*     */         break;
/*     */     } 
/*     */     
/* 127 */     stringBuffer.append("]");
/* 128 */     return stringBuffer.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void printName(String paramString1, String paramString2, String paramString3, StringBuffer paramStringBuffer) {
/* 137 */     if (paramString2 != null && !"".equals(paramString2)) paramStringBuffer.append("['" + paramString2 + "']:"); 
/* 138 */     if (paramString1 != null && !"".equals(paramString1)) paramStringBuffer.append(paramString1 + ":"); 
/* 139 */     if (paramString3 != null) paramStringBuffer.append(paramString3);
/*     */   
/*     */   }
/*     */   
/*     */   private static void printName(XMLStreamReader paramXMLStreamReader, StringBuffer paramStringBuffer) {
/* 144 */     if (paramXMLStreamReader.hasName()) {
/* 145 */       String str1 = paramXMLStreamReader.getPrefix();
/* 146 */       String str2 = paramXMLStreamReader.getNamespaceURI();
/* 147 */       String str3 = paramXMLStreamReader.getLocalName();
/* 148 */       printName(str1, str2, str3, paramStringBuffer);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static String getName(int paramInt) {
/* 154 */     switch (paramInt) {
/*     */       case 1:
/* 156 */         return "START_ELEMENT";
/*     */       case 2:
/* 158 */         return "END_ELEMENT";
/*     */       case 3:
/* 160 */         return "PROCESSING_INSTRUCTION";
/*     */       case 4:
/* 162 */         return "CHARACTERS";
/*     */       case 6:
/* 164 */         return "SPACE";
/*     */       case 5:
/* 166 */         return "COMMENT";
/*     */       case 7:
/* 168 */         return "START_DOCUMENT";
/*     */       case 8:
/* 170 */         return "END_DOCUMENT";
/*     */       case 9:
/* 172 */         return "ENTITY_REFERENCE";
/*     */       case 10:
/* 174 */         return "ATTRIBUTE";
/*     */       case 11:
/* 176 */         return "DTD";
/*     */       case 12:
/* 178 */         return "CDATA";
/*     */       case 13:
/* 180 */         return "NAMESPACE";
/*     */     } 
/* 182 */     return "UNKNOWN_EVENT_TYPE";
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getType(String paramString) {
/* 187 */     if (paramString.equals("START_ELEMENT"))
/* 188 */       return 1; 
/* 189 */     if (paramString.equals("SPACE"))
/* 190 */       return 6; 
/* 191 */     if (paramString.equals("END_ELEMENT"))
/* 192 */       return 2; 
/* 193 */     if (paramString.equals("PROCESSING_INSTRUCTION"))
/* 194 */       return 3; 
/* 195 */     if (paramString.equals("CHARACTERS"))
/* 196 */       return 4; 
/* 197 */     if (paramString.equals("COMMENT"))
/* 198 */       return 5; 
/* 199 */     if (paramString.equals("START_DOCUMENT"))
/* 200 */       return 7; 
/* 201 */     if (paramString.equals("END_DOCUMENT"))
/* 202 */       return 8; 
/* 203 */     if (paramString.equals("ATTRIBUTE"))
/* 204 */       return 10; 
/* 205 */     if (paramString.equals("DTD"))
/* 206 */       return 11; 
/* 207 */     if (paramString.equals("CDATA"))
/* 208 */       return 12; 
/* 209 */     if (paramString.equals("NAMESPACE"))
/* 210 */       return 13; 
/* 211 */     return -1;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\common\XmlStreamUtils.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */