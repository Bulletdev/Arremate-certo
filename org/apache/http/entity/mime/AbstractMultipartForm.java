/*     */ package org.apache.http.entity.mime;
/*     */ 
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.CharBuffer;
/*     */ import java.nio.charset.Charset;
/*     */ import java.util.List;
/*     */ import org.apache.http.entity.mime.content.ContentBody;
/*     */ import org.apache.http.util.Args;
/*     */ import org.apache.http.util.ByteArrayBuffer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ abstract class AbstractMultipartForm
/*     */ {
/*     */   private static ByteArrayBuffer encode(Charset paramCharset, String paramString) {
/*  53 */     ByteBuffer byteBuffer = paramCharset.encode(CharBuffer.wrap(paramString));
/*  54 */     ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer(byteBuffer.remaining());
/*  55 */     byteArrayBuffer.append(byteBuffer.array(), byteBuffer.position(), byteBuffer.remaining());
/*  56 */     return byteArrayBuffer;
/*     */   }
/*     */ 
/*     */   
/*     */   private static void writeBytes(ByteArrayBuffer paramByteArrayBuffer, OutputStream paramOutputStream) throws IOException {
/*  61 */     paramOutputStream.write(paramByteArrayBuffer.buffer(), 0, paramByteArrayBuffer.length());
/*     */   }
/*     */ 
/*     */   
/*     */   private static void writeBytes(String paramString, Charset paramCharset, OutputStream paramOutputStream) throws IOException {
/*  66 */     ByteArrayBuffer byteArrayBuffer = encode(paramCharset, paramString);
/*  67 */     writeBytes(byteArrayBuffer, paramOutputStream);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void writeBytes(String paramString, OutputStream paramOutputStream) throws IOException {
/*  72 */     ByteArrayBuffer byteArrayBuffer = encode(MIME.DEFAULT_CHARSET, paramString);
/*  73 */     writeBytes(byteArrayBuffer, paramOutputStream);
/*     */   }
/*     */ 
/*     */   
/*     */   protected static void writeField(MinimalField paramMinimalField, OutputStream paramOutputStream) throws IOException {
/*  78 */     writeBytes(paramMinimalField.getName(), paramOutputStream);
/*  79 */     writeBytes(FIELD_SEP, paramOutputStream);
/*  80 */     writeBytes(paramMinimalField.getBody(), paramOutputStream);
/*  81 */     writeBytes(CR_LF, paramOutputStream);
/*     */   }
/*     */ 
/*     */   
/*     */   protected static void writeField(MinimalField paramMinimalField, Charset paramCharset, OutputStream paramOutputStream) throws IOException {
/*  86 */     writeBytes(paramMinimalField.getName(), paramCharset, paramOutputStream);
/*  87 */     writeBytes(FIELD_SEP, paramOutputStream);
/*  88 */     writeBytes(paramMinimalField.getBody(), paramCharset, paramOutputStream);
/*  89 */     writeBytes(CR_LF, paramOutputStream);
/*     */   }
/*     */   
/*  92 */   private static final ByteArrayBuffer FIELD_SEP = encode(MIME.DEFAULT_CHARSET, ": ");
/*  93 */   private static final ByteArrayBuffer CR_LF = encode(MIME.DEFAULT_CHARSET, "\r\n");
/*  94 */   private static final ByteArrayBuffer TWO_DASHES = encode(MIME.DEFAULT_CHARSET, "--");
/*     */ 
/*     */ 
/*     */   
/*     */   final Charset charset;
/*     */ 
/*     */ 
/*     */   
/*     */   final String boundary;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AbstractMultipartForm(Charset paramCharset, String paramString) {
/* 108 */     Args.notNull(paramString, "Multipart boundary");
/* 109 */     this.charset = (paramCharset != null) ? paramCharset : MIME.DEFAULT_CHARSET;
/* 110 */     this.boundary = paramString;
/*     */   }
/*     */   
/*     */   public AbstractMultipartForm(String paramString) {
/* 114 */     this(null, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract List<FormBodyPart> getBodyParts();
/*     */ 
/*     */   
/*     */   void doWriteTo(OutputStream paramOutputStream, boolean paramBoolean) throws IOException {
/* 123 */     ByteArrayBuffer byteArrayBuffer = encode(this.charset, this.boundary);
/* 124 */     for (FormBodyPart formBodyPart : getBodyParts()) {
/* 125 */       writeBytes(TWO_DASHES, paramOutputStream);
/* 126 */       writeBytes(byteArrayBuffer, paramOutputStream);
/* 127 */       writeBytes(CR_LF, paramOutputStream);
/*     */       
/* 129 */       formatMultipartHeader(formBodyPart, paramOutputStream);
/*     */       
/* 131 */       writeBytes(CR_LF, paramOutputStream);
/*     */       
/* 133 */       if (paramBoolean) {
/* 134 */         formBodyPart.getBody().writeTo(paramOutputStream);
/*     */       }
/* 136 */       writeBytes(CR_LF, paramOutputStream);
/*     */     } 
/* 138 */     writeBytes(TWO_DASHES, paramOutputStream);
/* 139 */     writeBytes(byteArrayBuffer, paramOutputStream);
/* 140 */     writeBytes(TWO_DASHES, paramOutputStream);
/* 141 */     writeBytes(CR_LF, paramOutputStream);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract void formatMultipartHeader(FormBodyPart paramFormBodyPart, OutputStream paramOutputStream) throws IOException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeTo(OutputStream paramOutputStream) throws IOException {
/* 157 */     doWriteTo(paramOutputStream, true);
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
/*     */   public long getTotalLength() {
/* 175 */     long l = 0L;
/* 176 */     for (FormBodyPart formBodyPart : getBodyParts()) {
/* 177 */       ContentBody contentBody = formBodyPart.getBody();
/* 178 */       long l1 = contentBody.getContentLength();
/* 179 */       if (l1 >= 0L) {
/* 180 */         l += l1; continue;
/*     */       } 
/* 182 */       return -1L;
/*     */     } 
/*     */     
/* 185 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/*     */     try {
/* 187 */       doWriteTo(byteArrayOutputStream, false);
/* 188 */       byte[] arrayOfByte = byteArrayOutputStream.toByteArray();
/* 189 */       return l + arrayOfByte.length;
/* 190 */     } catch (IOException iOException) {
/*     */       
/* 192 */       return -1L;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\entity\mime\AbstractMultipartForm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */