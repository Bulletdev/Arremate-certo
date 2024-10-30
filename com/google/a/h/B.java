/*     */ package com.google.a.h;
/*     */ 
/*     */ import com.google.a.b.D;
/*     */ import com.google.b.a.j;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.charset.Charset;
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
/*     */ @j
/*     */ abstract class b
/*     */   extends c
/*     */ {
/*     */   final o[] a;
/*     */   private static final long serialVersionUID = 0L;
/*     */   
/*     */   b(o... paramVarArgs) {
/*  38 */     for (o o1 : paramVarArgs) {
/*  39 */       D.checkNotNull(o1);
/*     */     }
/*  41 */     this.a = paramVarArgs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   abstract n a(p[] paramArrayOfp);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public p a() {
/*  54 */     p[] arrayOfP = new p[this.a.length];
/*  55 */     for (byte b1 = 0; b1 < arrayOfP.length; b1++) {
/*  56 */       arrayOfP[b1] = this.a[b1].a();
/*     */     }
/*  58 */     return a(arrayOfP);
/*     */   }
/*     */ 
/*     */   
/*     */   public p c(int paramInt) {
/*  63 */     D.checkArgument((paramInt >= 0));
/*  64 */     p[] arrayOfP = new p[this.a.length];
/*  65 */     for (byte b1 = 0; b1 < arrayOfP.length; b1++) {
/*  66 */       arrayOfP[b1] = this.a[b1].c(paramInt);
/*     */     }
/*  68 */     return a(arrayOfP);
/*     */   }
/*     */   
/*     */   private p a(p[] paramArrayOfp) {
/*  72 */     return new p(this, paramArrayOfp)
/*     */       {
/*     */         public p a(byte param1Byte) {
/*     */           // Byte code:
/*     */           //   0: aload_0
/*     */           //   1: getfield a : [Lcom/google/a/h/p;
/*     */           //   4: astore_2
/*     */           //   5: aload_2
/*     */           //   6: arraylength
/*     */           //   7: istore_3
/*     */           //   8: iconst_0
/*     */           //   9: istore #4
/*     */           //   11: iload #4
/*     */           //   13: iload_3
/*     */           //   14: if_icmpge -> 38
/*     */           //   17: aload_2
/*     */           //   18: iload #4
/*     */           //   20: aaload
/*     */           //   21: astore #5
/*     */           //   23: aload #5
/*     */           //   25: iload_1
/*     */           //   26: invokeinterface a : (B)Lcom/google/a/h/p;
/*     */           //   31: pop
/*     */           //   32: iinc #4, 1
/*     */           //   35: goto -> 11
/*     */           //   38: aload_0
/*     */           //   39: areturn
/*     */           // Line number table:
/*     */           //   Java source line number -> byte code offset
/*     */           //   #75	-> 0
/*     */           //   #76	-> 23
/*     */           //   #75	-> 32
/*     */           //   #78	-> 38
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public p a(byte[] param1ArrayOfbyte) {
/*     */           // Byte code:
/*     */           //   0: aload_0
/*     */           //   1: getfield a : [Lcom/google/a/h/p;
/*     */           //   4: astore_2
/*     */           //   5: aload_2
/*     */           //   6: arraylength
/*     */           //   7: istore_3
/*     */           //   8: iconst_0
/*     */           //   9: istore #4
/*     */           //   11: iload #4
/*     */           //   13: iload_3
/*     */           //   14: if_icmpge -> 38
/*     */           //   17: aload_2
/*     */           //   18: iload #4
/*     */           //   20: aaload
/*     */           //   21: astore #5
/*     */           //   23: aload #5
/*     */           //   25: aload_1
/*     */           //   26: invokeinterface a : ([B)Lcom/google/a/h/p;
/*     */           //   31: pop
/*     */           //   32: iinc #4, 1
/*     */           //   35: goto -> 11
/*     */           //   38: aload_0
/*     */           //   39: areturn
/*     */           // Line number table:
/*     */           //   Java source line number -> byte code offset
/*     */           //   #83	-> 0
/*     */           //   #84	-> 23
/*     */           //   #83	-> 32
/*     */           //   #86	-> 38
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public p a(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
/*     */           // Byte code:
/*     */           //   0: aload_0
/*     */           //   1: getfield a : [Lcom/google/a/h/p;
/*     */           //   4: astore #4
/*     */           //   6: aload #4
/*     */           //   8: arraylength
/*     */           //   9: istore #5
/*     */           //   11: iconst_0
/*     */           //   12: istore #6
/*     */           //   14: iload #6
/*     */           //   16: iload #5
/*     */           //   18: if_icmpge -> 45
/*     */           //   21: aload #4
/*     */           //   23: iload #6
/*     */           //   25: aaload
/*     */           //   26: astore #7
/*     */           //   28: aload #7
/*     */           //   30: aload_1
/*     */           //   31: iload_2
/*     */           //   32: iload_3
/*     */           //   33: invokeinterface a : ([BII)Lcom/google/a/h/p;
/*     */           //   38: pop
/*     */           //   39: iinc #6, 1
/*     */           //   42: goto -> 14
/*     */           //   45: aload_0
/*     */           //   46: areturn
/*     */           // Line number table:
/*     */           //   Java source line number -> byte code offset
/*     */           //   #91	-> 0
/*     */           //   #92	-> 28
/*     */           //   #91	-> 39
/*     */           //   #94	-> 45
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public p a(ByteBuffer param1ByteBuffer) {
/*     */           // Byte code:
/*     */           //   0: aload_1
/*     */           //   1: invokevirtual position : ()I
/*     */           //   4: istore_2
/*     */           //   5: aload_0
/*     */           //   6: getfield a : [Lcom/google/a/h/p;
/*     */           //   9: astore_3
/*     */           //   10: aload_3
/*     */           //   11: arraylength
/*     */           //   12: istore #4
/*     */           //   14: iconst_0
/*     */           //   15: istore #5
/*     */           //   17: iload #5
/*     */           //   19: iload #4
/*     */           //   21: if_icmpge -> 50
/*     */           //   24: aload_3
/*     */           //   25: iload #5
/*     */           //   27: aaload
/*     */           //   28: astore #6
/*     */           //   30: aload_1
/*     */           //   31: iload_2
/*     */           //   32: invokestatic b : (Ljava/nio/Buffer;I)V
/*     */           //   35: aload #6
/*     */           //   37: aload_1
/*     */           //   38: invokeinterface a : (Ljava/nio/ByteBuffer;)Lcom/google/a/h/p;
/*     */           //   43: pop
/*     */           //   44: iinc #5, 1
/*     */           //   47: goto -> 17
/*     */           //   50: aload_0
/*     */           //   51: areturn
/*     */           // Line number table:
/*     */           //   Java source line number -> byte code offset
/*     */           //   #99	-> 0
/*     */           //   #100	-> 5
/*     */           //   #101	-> 30
/*     */           //   #102	-> 35
/*     */           //   #100	-> 44
/*     */           //   #104	-> 50
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public p a(short param1Short) {
/*     */           // Byte code:
/*     */           //   0: aload_0
/*     */           //   1: getfield a : [Lcom/google/a/h/p;
/*     */           //   4: astore_2
/*     */           //   5: aload_2
/*     */           //   6: arraylength
/*     */           //   7: istore_3
/*     */           //   8: iconst_0
/*     */           //   9: istore #4
/*     */           //   11: iload #4
/*     */           //   13: iload_3
/*     */           //   14: if_icmpge -> 38
/*     */           //   17: aload_2
/*     */           //   18: iload #4
/*     */           //   20: aaload
/*     */           //   21: astore #5
/*     */           //   23: aload #5
/*     */           //   25: iload_1
/*     */           //   26: invokeinterface a : (S)Lcom/google/a/h/p;
/*     */           //   31: pop
/*     */           //   32: iinc #4, 1
/*     */           //   35: goto -> 11
/*     */           //   38: aload_0
/*     */           //   39: areturn
/*     */           // Line number table:
/*     */           //   Java source line number -> byte code offset
/*     */           //   #109	-> 0
/*     */           //   #110	-> 23
/*     */           //   #109	-> 32
/*     */           //   #112	-> 38
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public p b(int param1Int) {
/*     */           // Byte code:
/*     */           //   0: aload_0
/*     */           //   1: getfield a : [Lcom/google/a/h/p;
/*     */           //   4: astore_2
/*     */           //   5: aload_2
/*     */           //   6: arraylength
/*     */           //   7: istore_3
/*     */           //   8: iconst_0
/*     */           //   9: istore #4
/*     */           //   11: iload #4
/*     */           //   13: iload_3
/*     */           //   14: if_icmpge -> 38
/*     */           //   17: aload_2
/*     */           //   18: iload #4
/*     */           //   20: aaload
/*     */           //   21: astore #5
/*     */           //   23: aload #5
/*     */           //   25: iload_1
/*     */           //   26: invokeinterface b : (I)Lcom/google/a/h/p;
/*     */           //   31: pop
/*     */           //   32: iinc #4, 1
/*     */           //   35: goto -> 11
/*     */           //   38: aload_0
/*     */           //   39: areturn
/*     */           // Line number table:
/*     */           //   Java source line number -> byte code offset
/*     */           //   #117	-> 0
/*     */           //   #118	-> 23
/*     */           //   #117	-> 32
/*     */           //   #120	-> 38
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public p a(long param1Long) {
/*     */           // Byte code:
/*     */           //   0: aload_0
/*     */           //   1: getfield a : [Lcom/google/a/h/p;
/*     */           //   4: astore_3
/*     */           //   5: aload_3
/*     */           //   6: arraylength
/*     */           //   7: istore #4
/*     */           //   9: iconst_0
/*     */           //   10: istore #5
/*     */           //   12: iload #5
/*     */           //   14: iload #4
/*     */           //   16: if_icmpge -> 40
/*     */           //   19: aload_3
/*     */           //   20: iload #5
/*     */           //   22: aaload
/*     */           //   23: astore #6
/*     */           //   25: aload #6
/*     */           //   27: lload_1
/*     */           //   28: invokeinterface a : (J)Lcom/google/a/h/p;
/*     */           //   33: pop
/*     */           //   34: iinc #5, 1
/*     */           //   37: goto -> 12
/*     */           //   40: aload_0
/*     */           //   41: areturn
/*     */           // Line number table:
/*     */           //   Java source line number -> byte code offset
/*     */           //   #125	-> 0
/*     */           //   #126	-> 25
/*     */           //   #125	-> 34
/*     */           //   #128	-> 40
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public p a(float param1Float) {
/*     */           // Byte code:
/*     */           //   0: aload_0
/*     */           //   1: getfield a : [Lcom/google/a/h/p;
/*     */           //   4: astore_2
/*     */           //   5: aload_2
/*     */           //   6: arraylength
/*     */           //   7: istore_3
/*     */           //   8: iconst_0
/*     */           //   9: istore #4
/*     */           //   11: iload #4
/*     */           //   13: iload_3
/*     */           //   14: if_icmpge -> 38
/*     */           //   17: aload_2
/*     */           //   18: iload #4
/*     */           //   20: aaload
/*     */           //   21: astore #5
/*     */           //   23: aload #5
/*     */           //   25: fload_1
/*     */           //   26: invokeinterface a : (F)Lcom/google/a/h/p;
/*     */           //   31: pop
/*     */           //   32: iinc #4, 1
/*     */           //   35: goto -> 11
/*     */           //   38: aload_0
/*     */           //   39: areturn
/*     */           // Line number table:
/*     */           //   Java source line number -> byte code offset
/*     */           //   #133	-> 0
/*     */           //   #134	-> 23
/*     */           //   #133	-> 32
/*     */           //   #136	-> 38
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public p a(double param1Double) {
/*     */           // Byte code:
/*     */           //   0: aload_0
/*     */           //   1: getfield a : [Lcom/google/a/h/p;
/*     */           //   4: astore_3
/*     */           //   5: aload_3
/*     */           //   6: arraylength
/*     */           //   7: istore #4
/*     */           //   9: iconst_0
/*     */           //   10: istore #5
/*     */           //   12: iload #5
/*     */           //   14: iload #4
/*     */           //   16: if_icmpge -> 40
/*     */           //   19: aload_3
/*     */           //   20: iload #5
/*     */           //   22: aaload
/*     */           //   23: astore #6
/*     */           //   25: aload #6
/*     */           //   27: dload_1
/*     */           //   28: invokeinterface a : (D)Lcom/google/a/h/p;
/*     */           //   33: pop
/*     */           //   34: iinc #5, 1
/*     */           //   37: goto -> 12
/*     */           //   40: aload_0
/*     */           //   41: areturn
/*     */           // Line number table:
/*     */           //   Java source line number -> byte code offset
/*     */           //   #141	-> 0
/*     */           //   #142	-> 25
/*     */           //   #141	-> 34
/*     */           //   #144	-> 40
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public p a(boolean param1Boolean) {
/*     */           // Byte code:
/*     */           //   0: aload_0
/*     */           //   1: getfield a : [Lcom/google/a/h/p;
/*     */           //   4: astore_2
/*     */           //   5: aload_2
/*     */           //   6: arraylength
/*     */           //   7: istore_3
/*     */           //   8: iconst_0
/*     */           //   9: istore #4
/*     */           //   11: iload #4
/*     */           //   13: iload_3
/*     */           //   14: if_icmpge -> 38
/*     */           //   17: aload_2
/*     */           //   18: iload #4
/*     */           //   20: aaload
/*     */           //   21: astore #5
/*     */           //   23: aload #5
/*     */           //   25: iload_1
/*     */           //   26: invokeinterface a : (Z)Lcom/google/a/h/p;
/*     */           //   31: pop
/*     */           //   32: iinc #4, 1
/*     */           //   35: goto -> 11
/*     */           //   38: aload_0
/*     */           //   39: areturn
/*     */           // Line number table:
/*     */           //   Java source line number -> byte code offset
/*     */           //   #149	-> 0
/*     */           //   #150	-> 23
/*     */           //   #149	-> 32
/*     */           //   #152	-> 38
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public p a(char param1Char) {
/*     */           // Byte code:
/*     */           //   0: aload_0
/*     */           //   1: getfield a : [Lcom/google/a/h/p;
/*     */           //   4: astore_2
/*     */           //   5: aload_2
/*     */           //   6: arraylength
/*     */           //   7: istore_3
/*     */           //   8: iconst_0
/*     */           //   9: istore #4
/*     */           //   11: iload #4
/*     */           //   13: iload_3
/*     */           //   14: if_icmpge -> 38
/*     */           //   17: aload_2
/*     */           //   18: iload #4
/*     */           //   20: aaload
/*     */           //   21: astore #5
/*     */           //   23: aload #5
/*     */           //   25: iload_1
/*     */           //   26: invokeinterface a : (C)Lcom/google/a/h/p;
/*     */           //   31: pop
/*     */           //   32: iinc #4, 1
/*     */           //   35: goto -> 11
/*     */           //   38: aload_0
/*     */           //   39: areturn
/*     */           // Line number table:
/*     */           //   Java source line number -> byte code offset
/*     */           //   #157	-> 0
/*     */           //   #158	-> 23
/*     */           //   #157	-> 32
/*     */           //   #160	-> 38
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public p a(CharSequence param1CharSequence) {
/*     */           // Byte code:
/*     */           //   0: aload_0
/*     */           //   1: getfield a : [Lcom/google/a/h/p;
/*     */           //   4: astore_2
/*     */           //   5: aload_2
/*     */           //   6: arraylength
/*     */           //   7: istore_3
/*     */           //   8: iconst_0
/*     */           //   9: istore #4
/*     */           //   11: iload #4
/*     */           //   13: iload_3
/*     */           //   14: if_icmpge -> 38
/*     */           //   17: aload_2
/*     */           //   18: iload #4
/*     */           //   20: aaload
/*     */           //   21: astore #5
/*     */           //   23: aload #5
/*     */           //   25: aload_1
/*     */           //   26: invokeinterface a : (Ljava/lang/CharSequence;)Lcom/google/a/h/p;
/*     */           //   31: pop
/*     */           //   32: iinc #4, 1
/*     */           //   35: goto -> 11
/*     */           //   38: aload_0
/*     */           //   39: areturn
/*     */           // Line number table:
/*     */           //   Java source line number -> byte code offset
/*     */           //   #165	-> 0
/*     */           //   #166	-> 23
/*     */           //   #165	-> 32
/*     */           //   #168	-> 38
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public p a(CharSequence param1CharSequence, Charset param1Charset) {
/*     */           // Byte code:
/*     */           //   0: aload_0
/*     */           //   1: getfield a : [Lcom/google/a/h/p;
/*     */           //   4: astore_3
/*     */           //   5: aload_3
/*     */           //   6: arraylength
/*     */           //   7: istore #4
/*     */           //   9: iconst_0
/*     */           //   10: istore #5
/*     */           //   12: iload #5
/*     */           //   14: iload #4
/*     */           //   16: if_icmpge -> 41
/*     */           //   19: aload_3
/*     */           //   20: iload #5
/*     */           //   22: aaload
/*     */           //   23: astore #6
/*     */           //   25: aload #6
/*     */           //   27: aload_1
/*     */           //   28: aload_2
/*     */           //   29: invokeinterface a : (Ljava/lang/CharSequence;Ljava/nio/charset/Charset;)Lcom/google/a/h/p;
/*     */           //   34: pop
/*     */           //   35: iinc #5, 1
/*     */           //   38: goto -> 12
/*     */           //   41: aload_0
/*     */           //   42: areturn
/*     */           // Line number table:
/*     */           //   Java source line number -> byte code offset
/*     */           //   #173	-> 0
/*     */           //   #174	-> 25
/*     */           //   #173	-> 35
/*     */           //   #176	-> 41
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public <T> p a(T param1T, l<? super T> param1l) {
/*     */           // Byte code:
/*     */           //   0: aload_0
/*     */           //   1: getfield a : [Lcom/google/a/h/p;
/*     */           //   4: astore_3
/*     */           //   5: aload_3
/*     */           //   6: arraylength
/*     */           //   7: istore #4
/*     */           //   9: iconst_0
/*     */           //   10: istore #5
/*     */           //   12: iload #5
/*     */           //   14: iload #4
/*     */           //   16: if_icmpge -> 41
/*     */           //   19: aload_3
/*     */           //   20: iload #5
/*     */           //   22: aaload
/*     */           //   23: astore #6
/*     */           //   25: aload #6
/*     */           //   27: aload_1
/*     */           //   28: aload_2
/*     */           //   29: invokeinterface a : (Ljava/lang/Object;Lcom/google/a/h/l;)Lcom/google/a/h/p;
/*     */           //   34: pop
/*     */           //   35: iinc #5, 1
/*     */           //   38: goto -> 12
/*     */           //   41: aload_0
/*     */           //   42: areturn
/*     */           // Line number table:
/*     */           //   Java source line number -> byte code offset
/*     */           //   #181	-> 0
/*     */           //   #182	-> 25
/*     */           //   #181	-> 35
/*     */           //   #184	-> 41
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public n a() {
/* 189 */           return this.a.a((p[])this.a);
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\h\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */