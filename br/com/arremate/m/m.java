/*    */ package br.com.arremate.m;
/*    */ 
/*    */ import br.com.arremate.f.e;
/*    */ import br.com.arremate.f.o;
/*    */ import br.com.arremate.l.a.b;
/*    */ import br.com.arremate.l.d;
/*    */ import br.com.arremate.l.e.c;
/*    */ import br.com.arremate.l.e.d;
/*    */ import br.com.arremate.l.h.b;
/*    */ import br.com.arremate.l.j;
/*    */ import br.com.arremate.l.k.c;
/*    */ import br.com.arremate.l.l.b;
/*    */ import br.com.arremate.l.m.c;
/*    */ import br.com.arremate.l.m.d;
/*    */ import br.com.arremate.l.n;
/*    */ import br.com.arremate.l.o.b;
/*    */ import java.sql.Timestamp;
/*    */ import java.util.Calendar;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class m
/*    */ {
/*    */   public static j a(long paramLong, int paramInt1, String paramString1, int paramInt2, String paramString2, boolean paramBoolean1, boolean paramBoolean2, Timestamp paramTimestamp1, int paramInt3, String paramString3, String paramString4, Timestamp paramTimestamp2) {
/*    */     b b;
/* 28 */     c c = null;
/* 29 */     n n = l.a().a(paramInt3);
/*    */     
/* 31 */     if (n != null) {
/* 32 */       d d1; c c2; c c1; d d; b b3; b b2; b b1; c c3; d d2 = g.a(n, paramLong);
/*    */       
/* 34 */       switch (null.g[n.a().ordinal()]) {
/*    */         case 1:
/* 36 */           c = new c(d2, paramInt1);
/*    */           break;
/*    */         case 2:
/* 39 */           d1 = new d(d2, paramInt1);
/*    */           
/* 41 */           if (paramTimestamp2 != null) {
/* 42 */             Calendar calendar = Calendar.getInstance();
/* 43 */             calendar.setTime(paramTimestamp2);
/* 44 */             d1.a(calendar);
/*    */           } 
/*    */           break;
/*    */         case 3:
/* 48 */           c2 = new c(d2, paramInt1);
/* 49 */           c3 = c2;
/* 50 */           c3.a(e.a(paramString3));
/* 51 */           c3.aA(paramString4);
/*    */           break;
/*    */         case 4:
/* 54 */           c1 = new c(d2, paramInt1);
/* 55 */           c1.aA(paramString4);
/*    */           break;
/*    */         case 5:
/* 58 */           d = new d(d2, paramInt1);
/* 59 */           d.aA(paramString4);
/*    */           break;
/*    */         case 6:
/* 62 */           b3 = new b(d2, paramInt1);
/*    */           break;
/*    */         case 7:
/* 65 */           b2 = new b(d2, paramInt1);
/*    */           break;
/*    */         case 8:
/* 68 */           b1 = new b(d2, paramInt1);
/*    */           break;
/*    */         case 9:
/* 71 */           b = new b(d2, paramInt1);
/*    */           break;
/*    */       } 
/*    */       
/* 75 */       if (b != null) {
/* 76 */         Calendar calendar = Calendar.getInstance();
/* 77 */         calendar.setTime(paramTimestamp1);
/*    */         
/* 79 */         b.T(paramString1);
/* 80 */         b.Q(paramInt2);
/* 81 */         b.aw(paramString2);
/* 82 */         b.b(calendar);
/* 83 */         b.s(paramBoolean1);
/* 84 */         b.C(paramBoolean2);
/*    */       } 
/*    */     } 
/* 87 */     return (j)b;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\m\m.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */