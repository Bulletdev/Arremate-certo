/*     */ package org.apache.commons.io.output;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import java.io.OutputStreamWriter;
/*     */ import java.io.StringWriter;
/*     */ import java.io.Writer;
/*     */ import java.util.Locale;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import org.apache.commons.io.input.XmlStreamReader;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XmlStreamWriter
/*     */   extends Writer
/*     */ {
/*     */   private static final int BUFFER_SIZE = 8192;
/*     */   private final OutputStream out;
/*     */   private final String defaultEncoding;
/*  48 */   private StringWriter xmlPrologWriter = new StringWriter(8192);
/*     */ 
/*     */ 
/*     */   
/*     */   private Writer writer;
/*     */ 
/*     */ 
/*     */   
/*     */   private String encoding;
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlStreamWriter(OutputStream paramOutputStream) {
/*  61 */     this(paramOutputStream, (String)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlStreamWriter(OutputStream paramOutputStream, String paramString) {
/*  72 */     this.out = paramOutputStream;
/*  73 */     this.defaultEncoding = (paramString != null) ? paramString : "UTF-8";
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
/*     */   public XmlStreamWriter(File paramFile) throws FileNotFoundException {
/*  85 */     this(paramFile, (String)null);
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
/*     */   public XmlStreamWriter(File paramFile, String paramString) throws FileNotFoundException {
/*  99 */     this(new FileOutputStream(paramFile), paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getEncoding() {
/* 108 */     return this.encoding;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDefaultEncoding() {
/* 117 */     return this.defaultEncoding;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() throws IOException {
/* 127 */     if (this.writer == null) {
/* 128 */       this.encoding = this.defaultEncoding;
/* 129 */       this.writer = new OutputStreamWriter(this.out, this.encoding);
/* 130 */       this.writer.write(this.xmlPrologWriter.toString());
/*     */     } 
/* 132 */     this.writer.close();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void flush() throws IOException {
/* 142 */     if (this.writer != null) {
/* 143 */       this.writer.flush();
/*     */     }
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
/*     */   private void detectEncoding(char[] paramArrayOfchar, int paramInt1, int paramInt2) throws IOException {
/* 157 */     int i = paramInt2;
/* 158 */     StringBuffer stringBuffer = this.xmlPrologWriter.getBuffer();
/* 159 */     if (stringBuffer.length() + paramInt2 > 8192) {
/* 160 */       i = 8192 - stringBuffer.length();
/*     */     }
/* 162 */     this.xmlPrologWriter.write(paramArrayOfchar, paramInt1, i);
/*     */ 
/*     */     
/* 165 */     if (stringBuffer.length() >= 5) {
/* 166 */       if (stringBuffer.substring(0, 5).equals("<?xml")) {
/*     */         
/* 168 */         int j = stringBuffer.indexOf("?>");
/* 169 */         if (j > 0) {
/*     */           
/* 171 */           Matcher matcher = ENCODING_PATTERN.matcher(stringBuffer.substring(0, j));
/*     */           
/* 173 */           if (matcher.find()) {
/* 174 */             this.encoding = matcher.group(1).toUpperCase(Locale.ROOT);
/* 175 */             this.encoding = this.encoding.substring(1, this.encoding.length() - 1);
/*     */           }
/*     */           else {
/*     */             
/* 179 */             this.encoding = this.defaultEncoding;
/*     */           }
/*     */         
/* 182 */         } else if (stringBuffer.length() >= 8192) {
/*     */ 
/*     */           
/* 185 */           this.encoding = this.defaultEncoding;
/*     */         }
/*     */       
/*     */       } else {
/*     */         
/* 190 */         this.encoding = this.defaultEncoding;
/*     */       } 
/* 192 */       if (this.encoding != null) {
/*     */         
/* 194 */         this.xmlPrologWriter = null;
/* 195 */         this.writer = new OutputStreamWriter(this.out, this.encoding);
/* 196 */         this.writer.write(stringBuffer.toString());
/* 197 */         if (paramInt2 > i) {
/* 198 */           this.writer.write(paramArrayOfchar, paramInt1 + i, paramInt2 - i);
/*     */         }
/*     */       } 
/*     */     } 
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
/*     */   public void write(char[] paramArrayOfchar, int paramInt1, int paramInt2) throws IOException {
/* 214 */     if (this.xmlPrologWriter != null) {
/* 215 */       detectEncoding(paramArrayOfchar, paramInt1, paramInt2);
/*     */     } else {
/* 217 */       this.writer.write(paramArrayOfchar, paramInt1, paramInt2);
/*     */     } 
/*     */   }
/*     */   
/* 221 */   static final Pattern ENCODING_PATTERN = XmlStreamReader.ENCODING_PATTERN;
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\output\XmlStreamWriter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */