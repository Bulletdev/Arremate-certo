/*    */ package com.google.a.j;
/*    */ 
/*    */ import com.google.a.a.a;
/*    */ import com.google.a.a.c;
/*    */ import com.google.a.b.D;
/*    */ import com.google.b.a.a;
/*    */ import java.io.IOException;
/*    */ import java.io.Reader;
/*    */ import java.nio.CharBuffer;
/*    */ import java.util.LinkedList;
/*    */ import java.util.Queue;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @a
/*    */ @c
/*    */ public final class y
/*    */ {
/*    */   private final Readable a;
/*    */   private final Reader reader;
/* 43 */   private final CharBuffer cbuf = l.a();
/* 44 */   private final char[] buf = this.cbuf.array();
/*    */   
/* 46 */   private final Queue<String> i = new LinkedList<>();
/* 47 */   private final w a = new w(this)
/*    */     {
/*    */       protected void g(String param1String1, String param1String2)
/*    */       {
/* 51 */         y.a(this.a).add(param1String1);
/*    */       }
/*    */     };
/*    */ 
/*    */   
/*    */   public y(Readable paramReadable) {
/* 57 */     this.a = (w)D.checkNotNull(paramReadable);
/* 58 */     this.reader = (paramReadable instanceof Reader) ? (Reader)paramReadable : null;
/*    */   }
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
/*    */   @a
/*    */   public String readLine() throws IOException {
/* 72 */     while (this.i.peek() == null) {
/* 73 */       v.a(this.cbuf);
/*    */ 
/*    */       
/* 76 */       int i = (this.reader != null) ? this.reader.read(this.buf, 0, this.buf.length) : this.a.read(this.cbuf);
/* 77 */       if (i == -1) {
/* 78 */         this.a.finish();
/*    */         break;
/*    */       } 
/* 81 */       this.a.a(this.buf, 0, i);
/*    */     } 
/* 83 */     return this.i.poll();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\j\y.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */