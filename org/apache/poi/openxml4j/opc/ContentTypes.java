/*     */ package org.apache.poi.openxml4j.opc;
/*     */ 
/*     */ import java.util.Locale;
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
/*     */ public final class ContentTypes
/*     */ {
/*     */   public static final String CORE_PROPERTIES_PART = "application/vnd.openxmlformats-package.core-properties+xml";
/*     */   public static final String DIGITAL_SIGNATURE_CERTIFICATE_PART = "application/vnd.openxmlformats-package.digital-signature-certificate";
/*     */   public static final String DIGITAL_SIGNATURE_ORIGIN_PART = "application/vnd.openxmlformats-package.digital-signature-origin";
/*     */   public static final String DIGITAL_SIGNATURE_XML_SIGNATURE_PART = "application/vnd.openxmlformats-package.digital-signature-xmlsignature+xml";
/*     */   public static final String RELATIONSHIPS_PART = "application/vnd.openxmlformats-package.relationships+xml";
/*     */   public static final String CUSTOM_XML_PART = "application/vnd.openxmlformats-officedocument.customXmlProperties+xml";
/*     */   public static final String PLAIN_OLD_XML = "application/xml";
/*     */   public static final String IMAGE_JPEG = "image/jpeg";
/*     */   public static final String EXTENSION_JPG_1 = "jpg";
/*     */   public static final String EXTENSION_JPG_2 = "jpeg";
/*     */   public static final String IMAGE_PNG = "image/png";
/*     */   public static final String EXTENSION_PNG = "png";
/*     */   public static final String IMAGE_GIF = "image/gif";
/*     */   public static final String EXTENSION_GIF = "gif";
/*     */   public static final String IMAGE_TIFF = "image/tiff";
/*     */   public static final String EXTENSION_TIFF = "tiff";
/*     */   public static final String IMAGE_PICT = "image/pict";
/*     */   public static final String EXTENSION_PICT = "tiff";
/*     */   public static final String XML = "text/xml";
/*     */   public static final String EXTENSION_XML = "xml";
/*     */   
/*     */   public static String getContentTypeFromFileExtension(String paramString) {
/* 114 */     String str = paramString.substring(paramString.lastIndexOf(".") + 1).toLowerCase(Locale.ROOT);
/*     */     
/* 116 */     if (str.equals("jpg") || str.equals("jpeg"))
/*     */     {
/* 118 */       return "image/jpeg"; } 
/* 119 */     if (str.equals("gif"))
/* 120 */       return "image/gif"; 
/* 121 */     if (str.equals("tiff"))
/* 122 */       return "image/pict"; 
/* 123 */     if (str.equals("png"))
/* 124 */       return "image/png"; 
/* 125 */     if (str.equals("tiff"))
/* 126 */       return "image/tiff"; 
/* 127 */     if (str.equals("xml")) {
/* 128 */       return "text/xml";
/*     */     }
/* 130 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\openxml4j\opc\ContentTypes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */