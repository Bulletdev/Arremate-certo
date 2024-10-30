/*    */ package com.google.a.h;
/*    */ 
/*    */ import com.google.a.b.D;
/*    */ import com.google.b.a.j;
/*    */ import java.io.Serializable;
/*    */ import java.util.zip.Checksum;
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
/*    */ @j
/*    */ final class i
/*    */   extends c
/*    */   implements Serializable
/*    */ {
/*    */   private final t<? extends Checksum> a;
/*    */   private final int fx;
/*    */   private final String toString;
/*    */   private static final long serialVersionUID = 0L;
/*    */   
/*    */   i(t<? extends Checksum> paramt, int paramInt, String paramString) {
/* 37 */     this.a = (t<? extends Checksum>)D.checkNotNull(paramt);
/* 38 */     D.a((paramInt == 32 || paramInt == 64), "bits (%s) must be either 32 or 64", paramInt);
/* 39 */     this.fx = paramInt;
/* 40 */     this.toString = (String)D.checkNotNull(paramString);
/*    */   }
/*    */ 
/*    */   
/*    */   public int av() {
/* 45 */     return this.fx;
/*    */   }
/*    */ 
/*    */   
/*    */   public p a() {
/* 50 */     return new a((Checksum)this.a.get());
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 55 */     return this.toString;
/*    */   }
/*    */   
/*    */   private final class a
/*    */     extends a {
/*    */     private final Checksum a;
/*    */     
/*    */     private a(i this$0, Checksum param1Checksum) {
/* 63 */       this.a = (i)D.checkNotNull(param1Checksum);
/*    */     }
/*    */ 
/*    */     
/*    */     protected void a(byte param1Byte) {
/* 68 */       this.a.update(param1Byte);
/*    */     }
/*    */ 
/*    */     
/*    */     protected void update(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
/* 73 */       this.a.update(param1ArrayOfbyte, param1Int1, param1Int2);
/*    */     }
/*    */ 
/*    */     
/*    */     public n a() {
/* 78 */       long l = this.a.getValue();
/* 79 */       if (i.a(this.a) == 32)
/*    */       {
/*    */ 
/*    */ 
/*    */ 
/*    */         
/* 85 */         return n.b((int)l);
/*    */       }
/* 87 */       return n.b(l);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\h\i.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */