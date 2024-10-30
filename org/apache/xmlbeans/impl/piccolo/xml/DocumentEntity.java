/*     */ package org.apache.xmlbeans.impl.piccolo.xml;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.net.MalformedURLException;
/*     */ import java.net.URL;
/*     */ import org.apache.xmlbeans.impl.piccolo.util.RecursionException;
/*     */ import org.xml.sax.InputSource;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DocumentEntity
/*     */   implements Entity
/*     */ {
/*     */   private boolean isOpen = false;
/*  29 */   private URL url = null;
/*  30 */   private String sysID = null;
/*  31 */   private InputSource source = null;
/*     */   private static URL defaultContext;
/*     */   private boolean isStandalone = false;
/*  34 */   private XMLStreamReader streamReader = null;
/*  35 */   private XMLReaderReader readerReader = null;
/*  36 */   private XMLInputReader activeReader = null;
/*     */   
/*     */   static {
/*     */     try {
/*  40 */       defaultContext = new URL("file", null, ".");
/*  41 */     } catch (IOException iOException) {
/*  42 */       defaultContext = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DocumentEntity(String paramString) throws IOException {
/*  51 */     reset(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public DocumentEntity(InputSource paramInputSource) throws IOException {
/*  56 */     reset(paramInputSource);
/*     */   }
/*     */   
/*     */   public boolean isOpen() {
/*  60 */     return this.isOpen;
/*     */   }
/*     */   
/*     */   public void open() throws IOException, RecursionException {
/*  64 */     String str = null;
/*     */ 
/*     */     
/*  67 */     if (this.source != null) {
/*     */       
/*  69 */       Reader reader = this.source.getCharacterStream();
/*  70 */       if (reader != null) {
/*  71 */         if (this.readerReader == null) {
/*  72 */           this.readerReader = new XMLReaderReader();
/*     */         }
/*  74 */         this.readerReader.reset(reader, true);
/*  75 */         this.isStandalone = this.readerReader.isXMLStandalone();
/*  76 */         this.activeReader = this.readerReader;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  85 */         this.isOpen = true;
/*     */         
/*     */         return;
/*     */       } 
/*     */       
/*  90 */       InputStream inputStream = this.source.getByteStream();
/*  91 */       if (inputStream != null) {
/*  92 */         if (this.streamReader == null)
/*  93 */           this.streamReader = new XMLStreamReader(); 
/*  94 */         this.streamReader.reset(inputStream, this.source.getEncoding(), true);
/*  95 */         this.isOpen = true;
/*  96 */         this.isStandalone = this.streamReader.isXMLStandalone();
/*  97 */         this.activeReader = this.streamReader;
/*     */         
/*     */         return;
/*     */       } 
/* 101 */       this.url = new URL(defaultContext, this.source.getSystemId());
/* 102 */       this.sysID = this.url.toString();
/* 103 */       str = this.source.getEncoding();
/*     */     } 
/*     */ 
/*     */     
/* 107 */     if (this.streamReader == null)
/* 108 */       this.streamReader = new XMLStreamReader(); 
/* 109 */     this.streamReader.reset(this.url.openStream(), str, true);
/* 110 */     this.isStandalone = this.streamReader.isXMLStandalone();
/* 111 */     this.activeReader = this.streamReader;
/* 112 */     this.isOpen = true;
/*     */   }
/*     */   
/*     */   public String getDeclaredEncoding() {
/* 116 */     return this.activeReader.getXMLDeclaredEncoding();
/*     */   }
/*     */   
/*     */   public boolean isStandaloneDeclared() {
/* 120 */     return this.activeReader.isXMLStandaloneDeclared();
/*     */   }
/*     */   
/*     */   public String getXMLVersion() {
/* 124 */     return this.activeReader.getXMLVersion();
/*     */   }
/*     */   
/*     */   public void reset(String paramString) throws IOException {
/* 128 */     close();
/* 129 */     this.isStandalone = false;
/* 130 */     this.source = null;
/*     */     try {
/* 132 */       this.url = new URL(defaultContext, paramString);
/*     */     }
/* 134 */     catch (MalformedURLException malformedURLException) {
/* 135 */       this.url = (new File(paramString)).toURL();
/*     */     } 
/*     */     
/* 138 */     this.sysID = this.url.toString();
/*     */   }
/*     */   
/*     */   public void reset(InputSource paramInputSource) throws IOException {
/* 142 */     close();
/* 143 */     this.isStandalone = false;
/* 144 */     this.source = paramInputSource;
/* 145 */     this.sysID = paramInputSource.getSystemId();
/* 146 */     if (this.sysID != null) {
/*     */       try {
/* 148 */         this.url = new URL(defaultContext, this.sysID);
/*     */       }
/* 150 */       catch (MalformedURLException malformedURLException) {
/* 151 */         this.url = (new File(this.sysID)).toURL();
/*     */       } 
/*     */       
/* 154 */       this.sysID = this.url.toString();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void close() throws IOException {
/* 159 */     if (!this.isOpen)
/*     */       return; 
/* 161 */     this.source = null;
/* 162 */     this.activeReader.close();
/* 163 */     this.activeReader = null;
/* 164 */     this.isOpen = false;
/*     */   }
/*     */   
/*     */   public String getPublicID() {
/* 168 */     return null;
/*     */   }
/*     */   
/*     */   public String getSystemID() {
/* 172 */     return this.sysID;
/*     */   }
/*     */   
/*     */   public boolean isStandalone() {
/* 176 */     return this.isStandalone;
/*     */   }
/*     */   
/*     */   public void setStandalone(boolean paramBoolean) {
/* 180 */     this.isStandalone = paramBoolean;
/*     */   }
/*     */   
/*     */   public boolean isInternal() {
/* 184 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isParsed() {
/* 188 */     return true;
/*     */   }
/*     */   
/*     */   public Reader getReader() {
/* 192 */     return this.activeReader;
/*     */   }
/*     */   
/*     */   public String stringValue() {
/* 196 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public char[] charArrayValue() {
/* 200 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public DocumentEntity() {}
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\piccolo\xml\DocumentEntity.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */