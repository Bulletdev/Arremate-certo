/*    */ package org.c.a.b.j;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.Reader;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class b
/*    */   implements d
/*    */ {
/*    */   private final Reader reader;
/*    */   private int lineNumber;
/*    */   
/*    */   public b(Reader paramReader) {
/* 29 */     this.reader = new a(paramReader);
/*    */   }
/*    */ 
/*    */   
/*    */   public c a() {
/* 34 */     this.lineNumber++;
/*    */     try {
/* 36 */       StringBuilder stringBuilder = new StringBuilder();
/*    */       int i;
/* 38 */       while ((i = this.reader.read()) != -1) {
/* 39 */         char c = (char)i;
/* 40 */         stringBuilder.append(c);
/* 41 */         if (c == '\n') {
/*    */           break;
/*    */         }
/*    */       } 
/* 45 */       if (stringBuilder.length() == 0) {
/* 46 */         return null;
/*    */       }
/* 48 */       return new a(this.lineNumber, stringBuilder.toString());
/* 49 */     } catch (IOException iOException) {
/* 50 */       throw new org.c.a.a.a("Unable to read line " + this.lineNumber + ": " + iOException.getMessage(), iOException);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void close() throws IOException {
/* 56 */     this.reader.close();
/*    */   }
/*    */   
/*    */   private static class a extends Reader {
/*    */     private final Reader c;
/* 61 */     private final char[] buffer = new char[16384];
/*    */     private boolean end;
/* 63 */     private int max = 0;
/* 64 */     private int pos = 0;
/*    */     
/*    */     private a(Reader param1Reader) {
/* 67 */       this.c = param1Reader;
/*    */     }
/*    */ 
/*    */     
/*    */     public int read() throws IOException {
/* 72 */       if (this.pos < this.max) {
/* 73 */         return this.buffer[this.pos++];
/*    */       }
/* 75 */       if (this.end) {
/* 76 */         return -1;
/*    */       }
/* 78 */       this.max = this.c.read(this.buffer);
/* 79 */       if (this.max <= 0) {
/* 80 */         this.end = true;
/* 81 */         return -1;
/*    */       } 
/* 83 */       this.pos = 0;
/* 84 */       return this.buffer[this.pos++];
/*    */     }
/*    */ 
/*    */     
/*    */     public int read(char[] param1ArrayOfchar, int param1Int1, int param1Int2) throws IOException {
/* 89 */       return this.c.read(param1ArrayOfchar, param1Int1, param1Int2);
/*    */     }
/*    */ 
/*    */     
/*    */     public void close() throws IOException {
/* 94 */       this.c.close();
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\j\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */