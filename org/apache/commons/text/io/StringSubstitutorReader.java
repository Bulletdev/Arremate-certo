/*     */ package org.apache.commons.text.io;
/*     */ 
/*     */ import java.io.FilterReader;
/*     */ import java.io.IOException;
/*     */ import java.io.Reader;
/*     */ import java.util.Objects;
/*     */ import org.apache.commons.text.StringSubstitutor;
/*     */ import org.apache.commons.text.TextStringBuilder;
/*     */ import org.apache.commons.text.matcher.StringMatcher;
/*     */ import org.apache.commons.text.matcher.StringMatcherFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class StringSubstitutorReader
/*     */   extends FilterReader
/*     */ {
/*     */   private static final int EOS = -1;
/*  49 */   private final TextStringBuilder buffer = new TextStringBuilder();
/*     */ 
/*     */   
/*     */   private boolean eos;
/*     */ 
/*     */   
/*     */   private final StringMatcher prefixEscapeMatcher;
/*     */ 
/*     */   
/*  58 */   private final char[] read1CharBuffer = new char[] { Character.MIN_VALUE };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final StringSubstitutor stringSubstitutor;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int toDrain;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StringSubstitutorReader(Reader paramReader, StringSubstitutor paramStringSubstitutor) {
/*  75 */     super(paramReader);
/*  76 */     this.stringSubstitutor = Objects.<StringSubstitutor>requireNonNull(paramStringSubstitutor);
/*  77 */     this
/*  78 */       .prefixEscapeMatcher = StringMatcherFactory.INSTANCE.charMatcher(paramStringSubstitutor.getEscapeChar()).andThen(paramStringSubstitutor.getVariablePrefixMatcher());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int buffer(int paramInt) throws IOException {
/*  85 */     int i = this.buffer.readFrom(this.in, paramInt);
/*  86 */     this.eos = (i == -1);
/*  87 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int bufferOrDrainOnEos(int paramInt1, char[] paramArrayOfchar, int paramInt2, int paramInt3) throws IOException {
/*  96 */     int i = buffer(paramInt1);
/*  97 */     return drainOnEos(i, paramArrayOfchar, paramInt2, paramInt3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int drain(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/* 104 */     int i = Math.min(this.buffer.length(), paramInt2);
/* 105 */     int j = this.buffer.drainChars(0, i, paramArrayOfchar, paramInt1);
/* 106 */     this.toDrain -= j;
/* 107 */     if (this.buffer.isEmpty() || this.toDrain == 0)
/*     */     {
/* 109 */       this.toDrain = 0;
/*     */     }
/* 111 */     return j;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int drainOnEos(int paramInt1, char[] paramArrayOfchar, int paramInt2, int paramInt3) {
/* 120 */     if (paramInt1 == -1) {
/*     */       
/* 122 */       if (this.buffer.isNotEmpty()) {
/* 123 */         this.toDrain = this.buffer.size();
/* 124 */         return drain(paramArrayOfchar, paramInt2, paramInt3);
/*     */       } 
/* 126 */       return -1;
/*     */     } 
/* 128 */     return paramInt1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isBufferMatchAt(StringMatcher paramStringMatcher, int paramInt) {
/* 135 */     return (paramStringMatcher.isMatch((CharSequence)this.buffer, paramInt) == paramStringMatcher.size());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isDraining() {
/* 142 */     return (this.toDrain > 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int read() throws IOException {
/* 153 */     int i = 0;
/*     */     
/*     */     while (true) {
/* 156 */       i = read(this.read1CharBuffer, 0, 1);
/* 157 */       if (i == -1) {
/* 158 */         return -1;
/*     */       }
/*     */       
/* 161 */       if (i >= 1) {
/* 162 */         return this.read1CharBuffer[0];
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int read(char[] paramArrayOfchar, int paramInt1, int paramInt2) throws IOException {
/* 183 */     if (this.eos && this.buffer.isEmpty()) {
/* 184 */       return -1;
/*     */     }
/* 186 */     if (paramInt2 <= 0)
/*     */     {
/* 188 */       return 0;
/*     */     }
/*     */     
/* 191 */     int i = paramInt1;
/* 192 */     int j = paramInt2;
/* 193 */     if (isDraining()) {
/*     */       
/* 195 */       int i5 = drain(paramArrayOfchar, i, Math.min(this.toDrain, j));
/* 196 */       if (i5 == j)
/*     */       {
/* 198 */         return j;
/*     */       }
/*     */       
/* 201 */       i += i5;
/* 202 */       j -= i5;
/*     */     } 
/*     */     
/* 205 */     int k = this.prefixEscapeMatcher.size();
/*     */     
/* 207 */     int m = buffer(readCount(k, 0));
/* 208 */     if (this.buffer.length() < k && j < k) {
/*     */       
/* 210 */       int i5 = drain(paramArrayOfchar, i, j);
/* 211 */       i += i5;
/* 212 */       int i6 = i - paramInt1;
/* 213 */       return (this.eos && i6 <= 0) ? -1 : i6;
/*     */     } 
/* 215 */     if (this.eos) {
/*     */       
/* 217 */       this.stringSubstitutor.replaceIn(this.buffer);
/* 218 */       this.toDrain = this.buffer.size();
/* 219 */       int i5 = drain(paramArrayOfchar, i, j);
/* 220 */       i += i5;
/* 221 */       int i6 = i - paramInt1;
/* 222 */       return (this.eos && i6 <= 0) ? -1 : i6;
/*     */     } 
/*     */ 
/*     */     
/* 226 */     byte b = 0;
/* 227 */     StringMatcher stringMatcher1 = this.stringSubstitutor.getVariablePrefixMatcher();
/* 228 */     int n = 0;
/* 229 */     while (j > 0) {
/* 230 */       if (isBufferMatchAt(stringMatcher1, 0)) {
/* 231 */         b = 1;
/* 232 */         n = stringMatcher1.size(); break;
/*     */       } 
/* 234 */       if (isBufferMatchAt(this.prefixEscapeMatcher, 0)) {
/* 235 */         b = 1;
/* 236 */         n = this.prefixEscapeMatcher.size();
/*     */         
/*     */         break;
/*     */       } 
/* 240 */       int i5 = drain(paramArrayOfchar, i, 1);
/* 241 */       i += i5;
/* 242 */       j -= i5;
/* 243 */       if (this.buffer.size() < k) {
/* 244 */         m = bufferOrDrainOnEos(k, paramArrayOfchar, i, j);
/* 245 */         if (this.eos || isDraining()) {
/*     */           
/* 247 */           if (m != -1) {
/* 248 */             i += m;
/* 249 */             j -= m;
/*     */           } 
/* 251 */           int i6 = i - paramInt1;
/* 252 */           return (i6 > 0) ? i6 : -1;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 257 */     if (j <= 0)
/*     */     {
/* 259 */       return paramInt2;
/*     */     }
/*     */ 
/*     */     
/* 263 */     StringMatcher stringMatcher2 = this.stringSubstitutor.getVariableSuffixMatcher();
/* 264 */     int i1 = Math.max(k, stringMatcher2.size());
/* 265 */     m = buffer(readCount(i1, n));
/* 266 */     if (this.eos) {
/*     */       
/* 268 */       this.stringSubstitutor.replaceIn(this.buffer);
/* 269 */       this.toDrain = this.buffer.size();
/* 270 */       int i5 = drain(paramArrayOfchar, i, j);
/* 271 */       return i + i5 - paramInt1;
/*     */     } 
/*     */     
/*     */     do {
/* 275 */       if (isBufferMatchAt(stringMatcher2, n)) {
/* 276 */         b--;
/* 277 */         n++;
/* 278 */         if (b == 0) {
/*     */           break;
/*     */         }
/* 281 */       } else if (isBufferMatchAt(stringMatcher1, n)) {
/* 282 */         b++;
/* 283 */         n += stringMatcher1.size();
/* 284 */       } else if (isBufferMatchAt(this.prefixEscapeMatcher, n)) {
/* 285 */         b++;
/* 286 */         n += this.prefixEscapeMatcher.size();
/*     */       } else {
/* 288 */         n++;
/*     */       } 
/* 290 */       m = buffer(readCount(i1, n));
/* 291 */     } while (m != -1 || n < this.buffer.size());
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 296 */     int i2 = n + 1;
/* 297 */     int i3 = Math.max(0, this.buffer.size() - n);
/* 298 */     this.stringSubstitutor.replaceIn(this.buffer, 0, Math.min(this.buffer.size(), i2));
/* 299 */     n = this.buffer.size() - i3;
/* 300 */     int i4 = Math.min(j, n);
/*     */     
/* 302 */     this.toDrain = n;
/* 303 */     drain(paramArrayOfchar, i, i4);
/* 304 */     return i - paramInt1 + i4;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int readCount(int paramInt1, int paramInt2) {
/* 312 */     int i = this.buffer.size() - paramInt2;
/* 313 */     return (i >= paramInt1) ? 0 : (paramInt1 - i);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\io\StringSubstitutorReader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */