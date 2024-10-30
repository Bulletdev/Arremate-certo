/*     */ package org.apache.xmlbeans.impl.common;
/*     */ 
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.xml.stream.XMLName;
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
/*     */ public class XMLNameHelper
/*     */ {
/*     */   public static b getQName(XMLName paramXMLName) {
/*  26 */     if (paramXMLName == null) {
/*  27 */       return null;
/*     */     }
/*  29 */     return QNameHelper.forLNS(paramXMLName.getLocalName(), paramXMLName.getNamespaceUri());
/*     */   }
/*     */ 
/*     */   
/*     */   public static XMLName forLNS(String paramString1, String paramString2) {
/*  34 */     if (paramString2 == null)
/*  35 */       paramString2 = ""; 
/*  36 */     return new XmlNameImpl(paramString2, paramString1);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XMLName forLN(String paramString) {
/*  41 */     return new XmlNameImpl("", paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XMLName forPretty(String paramString, int paramInt) {
/*  46 */     int i = paramString.indexOf('@', paramInt);
/*  47 */     if (i < 0)
/*  48 */       return new XmlNameImpl("", paramString.substring(paramInt)); 
/*  49 */     return new XmlNameImpl(paramString.substring(i + 1), paramString.substring(paramInt, i));
/*     */   }
/*     */ 
/*     */   
/*     */   public static String pretty(XMLName paramXMLName) {
/*  54 */     if (paramXMLName == null) {
/*  55 */       return "null";
/*     */     }
/*  57 */     if (paramXMLName.getNamespaceUri() == null || paramXMLName.getNamespaceUri().length() == 0) {
/*  58 */       return paramXMLName.getLocalName();
/*     */     }
/*  60 */     return paramXMLName.getLocalName() + "@" + paramXMLName.getNamespaceUri();
/*     */   }
/*     */   
/*  63 */   private static final char[] hexdigits = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean isSafe(int paramInt) {
/*  68 */     if (paramInt >= 97 && paramInt <= 122)
/*  69 */       return true; 
/*  70 */     if (paramInt >= 65 && paramInt <= 90)
/*  71 */       return true; 
/*  72 */     if (paramInt >= 48 && paramInt <= 57)
/*  73 */       return true; 
/*  74 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public static String hexsafe(String paramString) {
/*  79 */     StringBuffer stringBuffer = new StringBuffer();
/*  80 */     for (byte b = 0; b < paramString.length(); b++) {
/*     */       
/*  82 */       char c = paramString.charAt(b);
/*  83 */       if (isSafe(c)) {
/*     */         
/*  85 */         stringBuffer.append(c);
/*     */       }
/*     */       else {
/*     */         
/*  89 */         byte[] arrayOfByte = null;
/*     */         
/*     */         try {
/*  92 */           arrayOfByte = paramString.substring(b, b + 1).getBytes("UTF-8");
/*  93 */           for (byte b1 = 0; b1 < arrayOfByte.length; b1++)
/*     */           {
/*  95 */             stringBuffer.append('_');
/*  96 */             stringBuffer.append(hexdigits[arrayOfByte[b1] >> 4 & 0xF]);
/*  97 */             stringBuffer.append(hexdigits[arrayOfByte[b1] & 0xF]);
/*     */           }
/*     */         
/* 100 */         } catch (UnsupportedEncodingException unsupportedEncodingException) {
/*     */ 
/*     */           
/* 103 */           stringBuffer.append("_BAD_UTF8_CHAR");
/*     */         } 
/*     */       } 
/*     */     } 
/* 107 */     return stringBuffer.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public static String hexsafedir(XMLName paramXMLName) {
/* 112 */     if (paramXMLName.getNamespaceUri() == null || paramXMLName.getNamespaceUri().length() == 0)
/* 113 */       return "_nons/" + hexsafe(paramXMLName.getLocalName()); 
/* 114 */     return hexsafe(paramXMLName.getNamespaceUri()) + "/" + hexsafe(paramXMLName.getLocalName());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\common\XMLNameHelper.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */