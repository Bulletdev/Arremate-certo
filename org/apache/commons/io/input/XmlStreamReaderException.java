/*     */ package org.apache.commons.io.input;
/*     */ 
/*     */ import java.io.IOException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XmlStreamReaderException
/*     */   extends IOException
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private final String bomEncoding;
/*     */   private final String xmlGuessEncoding;
/*     */   private final String xmlEncoding;
/*     */   private final String contentTypeMime;
/*     */   private final String contentTypeEncoding;
/*     */   
/*     */   public XmlStreamReaderException(String paramString1, String paramString2, String paramString3, String paramString4) {
/*  62 */     this(paramString1, null, null, paramString2, paramString3, paramString4);
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
/*     */ 
/*     */   
/*     */   public XmlStreamReaderException(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {
/*  81 */     super(paramString1);
/*  82 */     this.contentTypeMime = paramString2;
/*  83 */     this.contentTypeEncoding = paramString3;
/*  84 */     this.bomEncoding = paramString4;
/*  85 */     this.xmlGuessEncoding = paramString5;
/*  86 */     this.xmlEncoding = paramString6;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getBomEncoding() {
/*  95 */     return this.bomEncoding;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getXmlGuessEncoding() {
/* 104 */     return this.xmlGuessEncoding;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getXmlEncoding() {
/* 113 */     return this.xmlEncoding;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getContentTypeMime() {
/* 124 */     return this.contentTypeMime;
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
/*     */   public String getContentTypeEncoding() {
/* 136 */     return this.contentTypeEncoding;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\input\XmlStreamReaderException.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */