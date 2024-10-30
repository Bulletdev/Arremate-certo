/*     */ package org.apache.xmlbeans.impl.piccolo.xml;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.Reader;
/*     */ import org.apache.xmlbeans.impl.piccolo.io.IllegalCharException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class XMLReaderReader
/*     */   extends XMLInputReader
/*     */ {
/*     */   private static final int BUFFER_SIZE = 8192;
/*     */   private Reader in;
/*     */   private boolean rewindDeclaration;
/*  39 */   private char[] cbuf = new char[8192];
/*  40 */   private int cbufPos = 0; private int cbufEnd = 0;
/*     */   
/*     */   private boolean eofReached = false;
/*     */   private boolean sawCR = false;
/*  44 */   private char[] oneCharBuf = new char[1];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XMLReaderReader() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XMLReaderReader(Reader paramReader) throws IOException {
/*  60 */     this(paramReader, true);
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
/*     */   public XMLReaderReader(Reader paramReader, boolean paramBoolean) throws IOException {
/*  72 */     reset(paramReader, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void reset(Reader paramReader, boolean paramBoolean) throws IOException {
/*  78 */     resetInput();
/*  79 */     this.in = paramReader;
/*  80 */     this.rewindDeclaration = paramBoolean;
/*  81 */     this.cbufPos = this.cbufEnd = 0;
/*  82 */     this.sawCR = false;
/*  83 */     this.eofReached = false;
/*  84 */     fillCharBuffer();
/*  85 */     processXMLDecl();
/*     */   }
/*     */   
/*     */   public void close() throws IOException {
/*  89 */     this.eofReached = true;
/*  90 */     this.cbufPos = this.cbufEnd = 0;
/*  91 */     if (this.in != null)
/*  92 */       this.in.close(); 
/*     */   }
/*     */   
/*     */   public void mark(int paramInt) throws IOException {
/*  96 */     throw new UnsupportedOperationException("mark() not supported");
/*     */   }
/*     */   
/*     */   public boolean markSupported() {
/* 100 */     return false;
/*     */   }
/*     */   
/*     */   public int read() throws IOException {
/* 104 */     int i = read(this.oneCharBuf, 0, 1);
/* 105 */     if (i <= 0) {
/* 106 */       return i;
/*     */     }
/* 108 */     return this.oneCharBuf[0];
/*     */   }
/*     */   
/*     */   public int read(char[] paramArrayOfchar) throws IOException {
/* 112 */     return read(paramArrayOfchar, 0, paramArrayOfchar.length);
/*     */   }
/*     */   
/*     */   public int read(char[] paramArrayOfchar, int paramInt1, int paramInt2) throws IOException {
/* 116 */     byte b = 0;
/*     */ 
/*     */     
/* 119 */     while (b < paramInt2) {
/* 120 */       char c; if (this.cbufPos < this.cbufEnd) {
/* 121 */         c = this.cbuf[this.cbufPos++];
/*     */       } else {
/* 123 */         if (this.eofReached) {
/*     */           break;
/*     */         }
/*     */ 
/*     */         
/* 128 */         if (b == 0 || this.in.ready()) {
/* 129 */           fillCharBuffer();
/*     */           
/*     */           continue;
/*     */         } 
/*     */         
/*     */         break;
/*     */       } 
/*     */       
/* 137 */       if (c >= ' ') {
/* 138 */         if (c <= '퟿' || (c >= '' && c <= '�') || (c >= 65536 && c <= 1114111)) {
/*     */ 
/*     */ 
/*     */           
/* 142 */           this.sawCR = false;
/* 143 */           paramArrayOfchar[paramInt1 + b++] = c;
/*     */           continue;
/*     */         } 
/* 146 */         throw new IllegalCharException("Illegal XML Character: 0x" + Integer.toHexString(c));
/*     */       } 
/*     */ 
/*     */       
/* 150 */       switch (c) {
/*     */         case '\n':
/* 152 */           if (this.sawCR) {
/* 153 */             this.sawCR = false;
/*     */             continue;
/*     */           } 
/* 156 */           paramArrayOfchar[paramInt1 + b++] = '\n';
/*     */           continue;
/*     */         
/*     */         case '\r':
/* 160 */           this.sawCR = true;
/* 161 */           paramArrayOfchar[paramInt1 + b++] = '\n';
/*     */           continue;
/*     */         
/*     */         case '\t':
/* 165 */           paramArrayOfchar[paramInt1 + b++] = '\t';
/*     */           continue;
/*     */       } 
/*     */       
/* 169 */       throw new IllegalCharException("Illegal XML character: 0x" + Integer.toHexString(c));
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 175 */     return (b == 0 && this.eofReached) ? -1 : b;
/*     */   }
/*     */   
/*     */   public boolean ready() throws IOException {
/* 179 */     return (this.cbufEnd - this.cbufPos > 0 || this.in.ready());
/*     */   }
/*     */   
/*     */   public void reset() throws IOException {
/* 183 */     resetInput();
/* 184 */     this.in.reset();
/* 185 */     this.cbufPos = this.cbufEnd = 0;
/* 186 */     this.sawCR = false;
/* 187 */     this.eofReached = false;
/*     */   }
/*     */   
/*     */   public long skip(long paramLong) throws IOException {
/* 191 */     byte b = 0;
/*     */ 
/*     */     
/* 194 */     while (b < paramLong) {
/* 195 */       char c; if (this.cbufPos < this.cbufEnd) {
/* 196 */         c = this.cbuf[this.cbufPos++];
/*     */       } else {
/* 198 */         if (this.eofReached)
/*     */           break; 
/* 200 */         fillCharBuffer();
/*     */         
/*     */         continue;
/*     */       } 
/* 204 */       if (c >= ' ') {
/* 205 */         if (c <= '퟿' || (c >= '' && c <= '�') || (c >= 65536 && c <= 1114111)) {
/*     */ 
/*     */ 
/*     */           
/* 209 */           this.sawCR = false;
/* 210 */           b++;
/*     */           continue;
/*     */         } 
/* 213 */         throw new IllegalCharException("Illegal XML Character: 0x" + Integer.toHexString(c));
/*     */       } 
/*     */ 
/*     */       
/* 217 */       switch (c) {
/*     */         case '\n':
/* 219 */           if (this.sawCR) {
/* 220 */             this.sawCR = false;
/*     */             continue;
/*     */           } 
/* 223 */           b++;
/*     */           continue;
/*     */         
/*     */         case '\r':
/* 227 */           this.sawCR = true;
/* 228 */           b++;
/*     */           continue;
/*     */         
/*     */         case '\t':
/* 232 */           b++;
/*     */           continue;
/*     */       } 
/*     */       
/* 236 */       throw new IllegalCharException("Illegal XML character: 0x" + Integer.toHexString(c));
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 242 */     return ((b == 0 && this.eofReached) ? -1L : b);
/*     */   }
/*     */   
/*     */   private void fillCharBuffer() throws IOException {
/* 246 */     this.cbufPos = 0;
/* 247 */     this.cbufEnd = this.in.read(this.cbuf, 0, 8192);
/* 248 */     if (this.cbufEnd <= 0) {
/* 249 */       this.eofReached = true;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void processXMLDecl() throws IOException {
/* 258 */     int i = parseXMLDeclaration(this.cbuf, 0, this.cbufEnd);
/*     */     
/* 260 */     if (i > 0)
/*     */     {
/*     */ 
/*     */       
/* 264 */       if (!this.rewindDeclaration)
/* 265 */         this.cbufPos += i; 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\piccolo\xml\XMLReaderReader.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */