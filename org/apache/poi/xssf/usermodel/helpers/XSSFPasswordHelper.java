/*     */ package org.apache.poi.xssf.usermodel.helpers;
/*     */ 
/*     */ import java.security.SecureRandom;
/*     */ import java.util.Arrays;
/*     */ import java.util.Locale;
/*     */ import javax.xml.bind.DatatypeConverter;
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.poi.poifs.crypt.CryptoFunctions;
/*     */ import org.apache.poi.poifs.crypt.HashAlgorithm;
/*     */ import org.apache.poi.util.Internal;
/*     */ import org.apache.xmlbeans.XmlCursor;
/*     */ import org.apache.xmlbeans.XmlObject;
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
/*     */ @Internal(since = "3.15 beta 3")
/*     */ public final class XSSFPasswordHelper
/*     */ {
/*     */   public static void setPassword(XmlObject paramXmlObject, String paramString1, HashAlgorithm paramHashAlgorithm, String paramString2) {
/*  50 */     XmlCursor xmlCursor = paramXmlObject.newCursor();
/*     */     
/*  52 */     if (paramString1 == null) {
/*  53 */       xmlCursor.removeAttribute(getAttrName(paramString2, "password"));
/*  54 */       xmlCursor.removeAttribute(getAttrName(paramString2, "algorithmName"));
/*  55 */       xmlCursor.removeAttribute(getAttrName(paramString2, "hashValue"));
/*  56 */       xmlCursor.removeAttribute(getAttrName(paramString2, "saltValue"));
/*  57 */       xmlCursor.removeAttribute(getAttrName(paramString2, "spinCount"));
/*     */       
/*     */       return;
/*     */     } 
/*  61 */     xmlCursor.toFirstContentToken();
/*  62 */     if (paramHashAlgorithm == null) {
/*  63 */       int i = CryptoFunctions.createXorVerifier1(paramString1);
/*  64 */       xmlCursor.insertAttributeWithValue(getAttrName(paramString2, "password"), String.format(Locale.ROOT, "%04X", new Object[] { Integer.valueOf(i) }).toUpperCase(Locale.ROOT));
/*     */     } else {
/*     */       
/*  67 */       SecureRandom secureRandom = new SecureRandom();
/*  68 */       byte[] arrayOfByte1 = secureRandom.generateSeed(16);
/*     */ 
/*     */ 
/*     */       
/*  72 */       int i = 100000;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  77 */       byte[] arrayOfByte2 = CryptoFunctions.hashPassword(paramString1, paramHashAlgorithm, arrayOfByte1, i, false);
/*     */       
/*  79 */       xmlCursor.insertAttributeWithValue(getAttrName(paramString2, "algorithmName"), paramHashAlgorithm.jceId);
/*  80 */       xmlCursor.insertAttributeWithValue(getAttrName(paramString2, "hashValue"), DatatypeConverter.printBase64Binary(arrayOfByte2));
/*  81 */       xmlCursor.insertAttributeWithValue(getAttrName(paramString2, "saltValue"), DatatypeConverter.printBase64Binary(arrayOfByte1));
/*  82 */       xmlCursor.insertAttributeWithValue(getAttrName(paramString2, "spinCount"), "" + i);
/*     */     } 
/*  84 */     xmlCursor.dispose();
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
/*     */   public static boolean validatePassword(XmlObject paramXmlObject, String paramString1, String paramString2) {
/* 100 */     if (paramString1 == null) return false;
/*     */     
/* 102 */     XmlCursor xmlCursor = paramXmlObject.newCursor();
/* 103 */     String str1 = xmlCursor.getAttributeText(getAttrName(paramString2, "password"));
/* 104 */     String str2 = xmlCursor.getAttributeText(getAttrName(paramString2, "algorithmName"));
/* 105 */     String str3 = xmlCursor.getAttributeText(getAttrName(paramString2, "hashValue"));
/* 106 */     String str4 = xmlCursor.getAttributeText(getAttrName(paramString2, "saltValue"));
/* 107 */     String str5 = xmlCursor.getAttributeText(getAttrName(paramString2, "spinCount"));
/* 108 */     xmlCursor.dispose();
/*     */     
/* 110 */     if (str1 != null) {
/* 111 */       int j = Integer.parseInt(str1, 16);
/* 112 */       int k = CryptoFunctions.createXorVerifier1(paramString1);
/* 113 */       return (j == k);
/*     */     } 
/* 115 */     if (str3 == null || str2 == null || str4 == null || str5 == null) {
/* 116 */       return false;
/*     */     }
/*     */     
/* 119 */     byte[] arrayOfByte1 = DatatypeConverter.parseBase64Binary(str3);
/* 120 */     HashAlgorithm hashAlgorithm = HashAlgorithm.fromString(str2);
/* 121 */     byte[] arrayOfByte2 = DatatypeConverter.parseBase64Binary(str4);
/* 122 */     int i = Integer.parseInt(str5);
/* 123 */     byte[] arrayOfByte3 = CryptoFunctions.hashPassword(paramString1, hashAlgorithm, arrayOfByte2, i, false);
/* 124 */     return Arrays.equals(arrayOfByte1, arrayOfByte3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static b getAttrName(String paramString1, String paramString2) {
/* 130 */     if (paramString1 == null || "".equals(paramString1)) {
/* 131 */       return new b(paramString2);
/*     */     }
/* 133 */     return new b(paramString1 + Character.toUpperCase(paramString2.charAt(0)) + paramString2.substring(1));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\helpers\XSSFPasswordHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */