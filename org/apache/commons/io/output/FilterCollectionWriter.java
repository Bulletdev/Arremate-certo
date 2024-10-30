/*     */ package org.apache.commons.io.output;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.Writer;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import org.apache.commons.io.IOExceptionList;
/*     */ import org.apache.commons.io.IOIndexedException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FilterCollectionWriter
/*     */   extends Writer
/*     */ {
/*  51 */   protected final Collection<Writer> EMPTY_WRITERS = Collections.emptyList();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final Collection<Writer> writers;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected FilterCollectionWriter(Collection<Writer> paramCollection) {
/*  64 */     this.writers = (paramCollection == null) ? this.EMPTY_WRITERS : paramCollection;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected FilterCollectionWriter(Writer... paramVarArgs) {
/*  73 */     this.writers = (paramVarArgs == null) ? this.EMPTY_WRITERS : Arrays.<Writer>asList(paramVarArgs);
/*     */   }
/*     */ 
/*     */   
/*     */   public Writer append(char paramChar) throws IOException {
/*  78 */     ArrayList<IOIndexedException> arrayList = new ArrayList();
/*  79 */     byte b = 0;
/*  80 */     for (Writer writer : this.writers) {
/*  81 */       if (writer != null) {
/*     */         try {
/*  83 */           writer.append(paramChar);
/*  84 */         } catch (IOException iOException) {
/*  85 */           arrayList.add(new IOIndexedException(b, iOException));
/*     */         } 
/*     */       }
/*  88 */       b++;
/*     */     } 
/*  90 */     if (!arrayList.isEmpty()) {
/*  91 */       throw new IOExceptionList(arrayList);
/*     */     }
/*  93 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Writer append(CharSequence paramCharSequence) throws IOException {
/*  98 */     ArrayList<IOIndexedException> arrayList = new ArrayList();
/*  99 */     byte b = 0;
/* 100 */     for (Writer writer : this.writers) {
/* 101 */       if (writer != null) {
/*     */         try {
/* 103 */           writer.append(paramCharSequence);
/* 104 */         } catch (IOException iOException) {
/* 105 */           arrayList.add(new IOIndexedException(b, iOException));
/*     */         } 
/*     */       }
/* 108 */       b++;
/*     */     } 
/* 110 */     if (!arrayList.isEmpty()) {
/* 111 */       throw new IOExceptionList(arrayList);
/*     */     }
/* 113 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Writer append(CharSequence paramCharSequence, int paramInt1, int paramInt2) throws IOException {
/* 119 */     ArrayList<IOIndexedException> arrayList = new ArrayList();
/* 120 */     byte b = 0;
/* 121 */     for (Writer writer : this.writers) {
/* 122 */       if (writer != null) {
/*     */         try {
/* 124 */           writer.append(paramCharSequence, paramInt1, paramInt2);
/* 125 */         } catch (IOException iOException) {
/* 126 */           arrayList.add(new IOIndexedException(b, iOException));
/*     */         } 
/*     */       }
/* 129 */       b++;
/*     */     } 
/* 131 */     if (!arrayList.isEmpty()) {
/* 132 */       throw new IOExceptionList(arrayList);
/*     */     }
/* 134 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public void close() throws IOException {
/* 139 */     ArrayList<IOIndexedException> arrayList = new ArrayList();
/* 140 */     byte b = 0;
/* 141 */     for (Writer writer : this.writers) {
/* 142 */       if (writer != null) {
/*     */         try {
/* 144 */           writer.close();
/* 145 */         } catch (IOException iOException) {
/* 146 */           arrayList.add(new IOIndexedException(b, iOException));
/*     */         } 
/*     */       }
/* 149 */       b++;
/*     */     } 
/* 151 */     if (!arrayList.isEmpty()) {
/* 152 */       throw new IOExceptionList(arrayList);
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
/*     */   public void flush() throws IOException {
/* 164 */     ArrayList<IOIndexedException> arrayList = new ArrayList();
/* 165 */     byte b = 0;
/* 166 */     for (Writer writer : this.writers) {
/* 167 */       if (writer != null) {
/*     */         try {
/* 169 */           writer.flush();
/* 170 */         } catch (IOException iOException) {
/* 171 */           arrayList.add(new IOIndexedException(b, iOException));
/*     */         } 
/*     */       }
/* 174 */       b++;
/*     */     } 
/* 176 */     if (!arrayList.isEmpty()) {
/* 177 */       throw new IOExceptionList(arrayList);
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
/*     */   public void write(char[] paramArrayOfchar, int paramInt1, int paramInt2) throws IOException {
/* 193 */     ArrayList<IOIndexedException> arrayList = new ArrayList();
/* 194 */     byte b = 0;
/* 195 */     for (Writer writer : this.writers) {
/* 196 */       if (writer != null) {
/*     */         try {
/* 198 */           writer.write(paramArrayOfchar, paramInt1, paramInt2);
/* 199 */         } catch (IOException iOException) {
/* 200 */           arrayList.add(new IOIndexedException(b, iOException));
/*     */         } 
/*     */       }
/* 203 */       b++;
/*     */     } 
/* 205 */     if (!arrayList.isEmpty()) {
/* 206 */       throw new IOExceptionList(arrayList);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void write(char[] paramArrayOfchar) throws IOException {
/* 212 */     ArrayList<IOIndexedException> arrayList = new ArrayList();
/* 213 */     byte b = 0;
/* 214 */     for (Writer writer : this.writers) {
/* 215 */       if (writer != null) {
/*     */         try {
/* 217 */           writer.write(paramArrayOfchar);
/* 218 */         } catch (IOException iOException) {
/* 219 */           arrayList.add(new IOIndexedException(b, iOException));
/*     */         } 
/*     */       }
/* 222 */       b++;
/*     */     } 
/* 224 */     if (!arrayList.isEmpty()) {
/* 225 */       throw new IOExceptionList(arrayList);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void write(int paramInt) throws IOException {
/* 236 */     ArrayList<IOIndexedException> arrayList = new ArrayList();
/* 237 */     byte b = 0;
/* 238 */     for (Writer writer : this.writers) {
/* 239 */       if (writer != null) {
/*     */         try {
/* 241 */           writer.write(paramInt);
/* 242 */         } catch (IOException iOException) {
/* 243 */           arrayList.add(new IOIndexedException(b, iOException));
/*     */         } 
/*     */       }
/* 246 */       b++;
/*     */     } 
/* 248 */     if (!arrayList.isEmpty()) {
/* 249 */       throw new IOExceptionList(arrayList);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void write(String paramString) throws IOException {
/* 255 */     ArrayList<IOIndexedException> arrayList = new ArrayList();
/* 256 */     byte b = 0;
/* 257 */     for (Writer writer : this.writers) {
/* 258 */       if (writer != null) {
/*     */         try {
/* 260 */           writer.write(paramString);
/* 261 */         } catch (IOException iOException) {
/* 262 */           arrayList.add(new IOIndexedException(b, iOException));
/*     */         } 
/*     */       }
/* 265 */       b++;
/*     */     } 
/* 267 */     if (!arrayList.isEmpty()) {
/* 268 */       throw new IOExceptionList(arrayList);
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
/*     */   public void write(String paramString, int paramInt1, int paramInt2) throws IOException {
/* 284 */     ArrayList<IOIndexedException> arrayList = new ArrayList();
/* 285 */     byte b = 0;
/* 286 */     for (Writer writer : this.writers) {
/* 287 */       if (writer != null) {
/*     */         try {
/* 289 */           writer.write(paramString, paramInt1, paramInt2);
/* 290 */         } catch (IOException iOException) {
/* 291 */           arrayList.add(new IOIndexedException(b, iOException));
/*     */         } 
/*     */       }
/* 294 */       b++;
/*     */     } 
/* 296 */     if (!arrayList.isEmpty())
/* 297 */       throw new IOExceptionList(arrayList); 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\output\FilterCollectionWriter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */