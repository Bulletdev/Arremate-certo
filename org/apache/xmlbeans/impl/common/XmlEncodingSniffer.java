/*     */ package org.apache.xmlbeans.impl.common;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.Reader;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XmlEncodingSniffer
/*     */ {
/*     */   private String _xmlencoding;
/*     */   private String _javaencoding;
/*     */   private InputStream _stream;
/*     */   private Reader _reader;
/*     */   static final boolean $assertionsDisabled;
/*     */   
/*     */   public XmlEncodingSniffer(InputStream paramInputStream, String paramString) throws IOException, UnsupportedEncodingException {
/*  46 */     this._stream = paramInputStream;
/*     */     
/*  48 */     if (paramString != null) {
/*  49 */       this._xmlencoding = EncodingMap.getJava2IANAMapping(paramString);
/*     */     }
/*  51 */     if (this._xmlencoding == null) {
/*  52 */       this._xmlencoding = paramString;
/*     */     }
/*  54 */     if (this._xmlencoding == null) {
/*     */       
/*  56 */       SniffedXmlInputStream sniffedXmlInputStream = new SniffedXmlInputStream(this._stream);
/*  57 */       this._xmlencoding = sniffedXmlInputStream.getXmlEncoding();
/*  58 */       assert this._xmlencoding != null;
/*  59 */       this._stream = sniffedXmlInputStream;
/*     */     } 
/*     */     
/*  62 */     this._javaencoding = EncodingMap.getIANA2JavaMapping(this._xmlencoding);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  67 */     if (this._javaencoding == null) {
/*  68 */       this._javaencoding = this._xmlencoding;
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlEncodingSniffer(Reader paramReader, String paramString) throws IOException, UnsupportedEncodingException {
/*  86 */     if (paramString == null) {
/*  87 */       paramString = "UTF-8";
/*     */     }
/*  89 */     SniffedXmlReader sniffedXmlReader = new SniffedXmlReader(paramReader);
/*  90 */     this._reader = sniffedXmlReader;
/*  91 */     this._xmlencoding = sniffedXmlReader.getXmlEncoding();
/*     */     
/*  93 */     if (this._xmlencoding == null) {
/*     */       
/*  95 */       this._xmlencoding = EncodingMap.getJava2IANAMapping(paramString);
/*  96 */       if (this._xmlencoding != null) {
/*  97 */         this._javaencoding = paramString;
/*     */       } else {
/*  99 */         this._xmlencoding = paramString;
/*     */       } 
/*     */     } 
/* 102 */     if (this._xmlencoding == null) {
/* 103 */       this._xmlencoding = "UTF-8";
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 108 */     this._javaencoding = EncodingMap.getIANA2JavaMapping(this._xmlencoding);
/*     */     
/* 110 */     if (this._javaencoding == null) {
/* 111 */       this._javaencoding = this._xmlencoding;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getXmlEncoding() {
/* 116 */     return this._xmlencoding;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getJavaEncoding() {
/* 121 */     return this._javaencoding;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public InputStream getStream() throws UnsupportedEncodingException {
/* 127 */     if (this._stream != null) {
/*     */       
/* 129 */       InputStream inputStream = this._stream;
/* 130 */       this._stream = null;
/* 131 */       return inputStream;
/*     */     } 
/*     */     
/* 134 */     if (this._reader != null) {
/*     */       
/* 136 */       ReaderInputStream readerInputStream = new ReaderInputStream(this._reader, this._javaencoding);
/* 137 */       this._reader = null;
/* 138 */       return readerInputStream;
/*     */     } 
/*     */     
/* 141 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Reader getReader() throws UnsupportedEncodingException {
/* 148 */     if (this._reader != null) {
/*     */       
/* 150 */       Reader reader = this._reader;
/* 151 */       this._reader = null;
/* 152 */       return reader;
/*     */     } 
/*     */     
/* 155 */     if (this._stream != null) {
/*     */       
/* 157 */       InputStreamReader inputStreamReader = new InputStreamReader(this._stream, this._javaencoding);
/* 158 */       this._stream = null;
/* 159 */       return inputStreamReader;
/*     */     } 
/*     */     
/* 162 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\common\XmlEncodingSniffer.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */