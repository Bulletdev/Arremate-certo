/*    */ package org.c.a.b.n;
/*    */ 
/*    */ import java.io.Closeable;
/*    */ import java.io.IOException;
/*    */ import java.util.zip.CRC32;
/*    */ import org.c.a.b.j.c;
/*    */ import org.c.a.b.j.d;
/*    */ import org.c.a.b.r.i;
/*    */ import org.c.a.b.r.n;
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
/*    */ public abstract class a
/*    */   implements b
/*    */ {
/*    */   private Integer g;
/*    */   
/*    */   public final int bP() {
/* 32 */     if (this.g == null) {
/* 33 */       CRC32 cRC32 = new CRC32();
/*    */       
/* 35 */       d d = null;
/*    */       try {
/* 37 */         d = a();
/*    */         c c;
/* 39 */         while ((c = d.a()) != null)
/*    */         {
/* 41 */           cRC32.update(n.bj(c.eG()).getBytes("UTF-8"));
/*    */         }
/* 43 */       } catch (IOException iOException) {
/* 44 */         throw new org.c.a.a.a("Unable to calculate checksum for " + eI() + " (" + 
/* 45 */             eJ() + "): " + iOException.getMessage(), iOException);
/*    */       } finally {
/* 47 */         i.close((Closeable)d);
/*    */       } 
/*    */       
/* 50 */       this.g = Integer.valueOf((int)cRC32.getValue());
/*    */     } 
/* 52 */     return this.g.intValue();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\n\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */