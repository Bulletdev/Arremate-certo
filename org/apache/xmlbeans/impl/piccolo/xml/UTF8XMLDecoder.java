/*     */ package org.apache.xmlbeans.impl.piccolo.xml;
/*     */ 
/*     */ import java.io.CharConversionException;
/*     */ import org.apache.xmlbeans.impl.piccolo.io.CharsetDecoder;
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
/*     */ public final class UTF8XMLDecoder
/*     */   implements XMLDecoder
/*     */ {
/*     */   private boolean sawCR = false;
/*     */   
/*     */   public CharsetDecoder newCharsetDecoder() {
/*  39 */     return newXMLDecoder(); } public XMLDecoder newXMLDecoder() {
/*  40 */     return new UTF8XMLDecoder();
/*     */   }
/*     */   public int minBytesPerChar() {
/*  43 */     return 1;
/*     */   }
/*     */   
/*     */   public int maxBytesPerChar() {
/*  47 */     return 3;
/*     */   }
/*     */   public void reset() {
/*  50 */     this.sawCR = false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void decode(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, char[] paramArrayOfchar, int paramInt3, int paramInt4, int[] paramArrayOfint) throws CharConversionException {
/*  56 */     byte b2 = 0, b1 = b2; while (true) { if (b1 < paramInt2 && b2 < paramInt4) {
/*     */ 
/*     */ 
/*     */         
/*  60 */         int i = paramArrayOfbyte[paramInt1 + b1];
/*     */ 
/*     */         
/*  63 */         if ((i & 0x80) != 0) {
/*     */           byte b;
/*     */ 
/*     */ 
/*     */           
/*  68 */           if (++b1 < paramInt2) {
/*  69 */             b = paramArrayOfbyte[paramInt1 + b1];
/*     */           } else {
/*  71 */             paramArrayOfint[0] = b1 - 1;
/*  72 */             paramArrayOfint[1] = b2;
/*     */             
/*     */             return;
/*     */           } 
/*     */           
/*  77 */           if ((i & 0xE0) == 192) {
/*     */             
/*  79 */             if ((b & 0x80) != 128) {
/*  80 */               throw new CharConversionException("Malformed UTF-8 character: 0x" + Integer.toHexString(i & 0xFF) + " 0x" + Integer.toHexString(b & 0xFF));
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*  85 */             i = (i & 0x1F) << 6 | b & 0x3F;
/*     */ 
/*     */             
/*  88 */             if ((i & 0x780) == 0) {
/*  89 */               throw new CharConversionException("2-byte UTF-8 character is overlong: 0x" + Integer.toHexString(paramArrayOfbyte[paramInt1 + b1 - 1] & 0xFF) + " 0x" + Integer.toHexString(b & 0xFF));
/*     */ 
/*     */             
/*     */             }
/*     */ 
/*     */           
/*     */           }
/*  96 */           else if ((i & 0xF0) == 224) {
/*  97 */             byte b3; if (++b1 < paramInt2) {
/*  98 */               b3 = paramArrayOfbyte[paramInt1 + b1];
/*     */             } else {
/* 100 */               paramArrayOfint[0] = b1 - 2;
/* 101 */               paramArrayOfint[1] = b2;
/*     */               
/*     */               return;
/*     */             } 
/*     */             
/* 106 */             if ((b & 0x80) != 128 || (b3 & 0x80) != 128)
/*     */             {
/* 108 */               throw new CharConversionException("Malformed UTF-8 character: 0x" + Integer.toHexString(i & 0xFF) + " 0x" + Integer.toHexString(b & 0xFF) + " 0x" + Integer.toHexString(b3 & 0xFF));
/*     */             }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 115 */             i = (i & 0xF) << 12 | (b & 0x3F) << 6 | b3 & 0x3F;
/*     */ 
/*     */             
/* 118 */             if ((i & 0xF800) == 0) {
/* 119 */               throw new CharConversionException("3-byte UTF-8 character is overlong: 0x" + Integer.toHexString(paramArrayOfbyte[paramInt1 + b1 - 2] & 0xFF) + " 0x" + Integer.toHexString(b & 0xFF) + " 0x" + Integer.toHexString(b3 & 0xFF));
/*     */             
/*     */             }
/*     */           
/*     */           }
/*     */           else {
/*     */             
/* 126 */             if ((i & 0xF0) == 240) {
/* 127 */               byte b3, b4; if (b1 + 2 < paramInt2) {
/* 128 */                 b3 = paramArrayOfbyte[paramInt1 + ++b1];
/* 129 */                 b4 = paramArrayOfbyte[paramInt1 + ++b1];
/*     */               } else {
/*     */                 
/* 132 */                 paramArrayOfint[0] = b1 - 2;
/* 133 */                 paramArrayOfint[1] = b2;
/*     */                 
/*     */                 return;
/*     */               } 
/*     */               
/* 138 */               if ((b & 0x80) != 128 || (b3 & 0x80) != 128 || (b4 & 0x80) != 128)
/*     */               {
/*     */                 
/* 141 */                 throw new CharConversionException("Malformed UTF-8 character: 0x" + Integer.toHexString(i & 0xFF) + " 0x" + Integer.toHexString(b & 0xFF) + " 0x" + Integer.toHexString(b3 & 0xFF) + " 0x" + Integer.toHexString(b4 & 0xFF));
/*     */               }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */               
/* 148 */               i = (i & 0x7) << 18 | (b & 0x3F) << 12 | (b3 & 0x3F) << 6 | b4 & 0x3F;
/*     */               
/* 150 */               if (i < 65536 || i > 1114111) {
/* 151 */                 throw new IllegalCharException("Illegal XML character: 0x" + Integer.toHexString(i));
/*     */               }
/*     */ 
/*     */               
/* 155 */               i -= 65536;
/* 156 */               paramArrayOfchar[paramInt3 + b2++] = (char)(i >> 10 | 0xD800);
/* 157 */               paramArrayOfchar[paramInt3 + b2++] = (char)(i & 0x3FF | 0xDC00);
/* 158 */               this.sawCR = false;
/*     */             }
/*     */             else {
/*     */               
/* 162 */               throw new CharConversionException("Characters larger than 4 bytes are not supported: byte 0x" + Integer.toHexString(i & 0xFF) + " implies a length of more than 4 bytes");
/*     */             } 
/*     */             b1++;
/*     */           } 
/* 166 */           if ((i >= 55296 && i < 57344) || i == 65534 || i == 65535)
/*     */           {
/* 168 */             throw new IllegalCharException("Illegal XML character: 0x" + Integer.toHexString(i));
/*     */           }
/*     */         } 
/*     */         
/* 172 */         if (i >= 32) {
/* 173 */           this.sawCR = false;
/* 174 */           paramArrayOfchar[paramInt3 + b2++] = (char)i;
/*     */         } else {
/*     */           
/* 177 */           switch (i) {
/*     */             case 10:
/* 179 */               if (this.sawCR) {
/* 180 */                 this.sawCR = false;
/*     */                 break;
/*     */               } 
/* 183 */               paramArrayOfchar[paramInt3 + b2++] = '\n';
/*     */               break;
/*     */             
/*     */             case 13:
/* 187 */               this.sawCR = true;
/* 188 */               paramArrayOfchar[paramInt3 + b2++] = '\n';
/*     */               break;
/*     */             
/*     */             case 9:
/* 192 */               paramArrayOfchar[paramInt3 + b2++] = '\t';
/*     */               break;
/*     */             
/*     */             default:
/* 196 */               throw new IllegalCharException("Illegal XML character: 0x" + Integer.toHexString(i));
/*     */           } 
/*     */         } 
/*     */       } else {
/*     */         break;
/*     */       }  b1++; }
/* 202 */      paramArrayOfint[0] = b1;
/* 203 */     paramArrayOfint[1] = b2;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void decodeXMLDecl(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, char[] paramArrayOfchar, int paramInt3, int paramInt4, int[] paramArrayOfint) throws CharConversionException {
/*     */     byte b1;
/*     */     byte b2;
/* 211 */     for (b1 = b2 = 0; b1 < paramInt2 && b2 < paramInt4; b1++) {
/*     */ 
/*     */       
/* 214 */       byte b = paramArrayOfbyte[paramInt1 + b1];
/*     */ 
/*     */ 
/*     */       
/* 218 */       if ((b & 0x80) != 0) {
/*     */         break;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 224 */       if (b >= 32) {
/* 225 */         this.sawCR = false;
/* 226 */         paramArrayOfchar[paramInt3 + b2++] = (char)b;
/*     */ 
/*     */ 
/*     */         
/* 230 */         if (b == 62) {
/* 231 */           b1++;
/*     */           
/*     */           break;
/*     */         } 
/*     */       } else {
/* 236 */         switch (b) {
/*     */           case 10:
/* 238 */             if (this.sawCR) {
/* 239 */               this.sawCR = false;
/*     */               break;
/*     */             } 
/* 242 */             paramArrayOfchar[paramInt3 + b2++] = '\n';
/*     */             break;
/*     */           
/*     */           case 13:
/* 246 */             this.sawCR = true;
/* 247 */             paramArrayOfchar[paramInt3 + b2++] = '\n';
/*     */             break;
/*     */           
/*     */           case 9:
/* 251 */             paramArrayOfchar[paramInt3 + b2++] = '\t';
/*     */             break;
/*     */           
/*     */           default:
/*     */             break;
/*     */         } 
/*     */       
/*     */       } 
/*     */     } 
/* 260 */     paramArrayOfint[0] = b1;
/* 261 */     paramArrayOfint[1] = b2;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\piccolo\xml\UTF8XMLDecoder.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */