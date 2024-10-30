/*     */ package org.apache.http.entity.mime.content;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import org.apache.http.entity.ContentType;
/*     */ import org.apache.http.util.Args;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ByteArrayBody
/*     */   extends AbstractContentBody
/*     */ {
/*     */   private final byte[] data;
/*     */   private final String filename;
/*     */   
/*     */   @Deprecated
/*     */   public ByteArrayBody(byte[] paramArrayOfbyte, String paramString1, String paramString2) {
/*  67 */     this(paramArrayOfbyte, ContentType.create(paramString1), paramString2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ByteArrayBody(byte[] paramArrayOfbyte, ContentType paramContentType, String paramString) {
/*  74 */     super(paramContentType);
/*  75 */     Args.notNull(paramArrayOfbyte, "byte[]");
/*  76 */     this.data = paramArrayOfbyte;
/*  77 */     this.filename = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ByteArrayBody(byte[] paramArrayOfbyte, String paramString) {
/*  87 */     this(paramArrayOfbyte, "application/octet-stream", paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getFilename() {
/*  92 */     return this.filename;
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeTo(OutputStream paramOutputStream) throws IOException {
/*  97 */     paramOutputStream.write(this.data);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCharset() {
/* 102 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getTransferEncoding() {
/* 107 */     return "binary";
/*     */   }
/*     */ 
/*     */   
/*     */   public long getContentLength() {
/* 112 */     return this.data.length;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\entity\mime\content\ByteArrayBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */